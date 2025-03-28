// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.resourcemanager.appservice;

import com.azure.core.http.HttpPipeline;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.Region;
import com.azure.core.management.exception.ManagementException;
import com.azure.core.management.profile.AzureProfile;
import com.azure.resourcemanager.appcontainers.ContainerAppsApiManager;
import com.azure.resourcemanager.appcontainers.models.ManagedEnvironment;
import com.azure.resourcemanager.appservice.models.AppServicePlan;
import com.azure.resourcemanager.appservice.models.AppSetting;
import com.azure.resourcemanager.appservice.models.ConnectionStringType;
import com.azure.resourcemanager.appservice.models.FunctionApp;
import com.azure.resourcemanager.appservice.models.FunctionAppBasic;
import com.azure.resourcemanager.appservice.models.FunctionDeploymentSlot;
import com.azure.resourcemanager.appservice.models.FunctionEnvelope;
import com.azure.resourcemanager.appservice.models.FunctionRuntimeStack;
import com.azure.resourcemanager.appservice.models.PricingTier;
import com.azure.resourcemanager.appservice.models.PublicNetworkAccess;
import com.azure.resourcemanager.appservice.models.SkuName;
import com.azure.resourcemanager.resources.fluentcore.utils.ResourceManagerUtils;
import com.azure.resourcemanager.resources.models.ResourceGroup;
import com.azure.resourcemanager.storage.StorageManager;
import com.azure.resourcemanager.storage.models.StorageAccount;
import com.azure.resourcemanager.storage.models.StorageAccountSkuType;
import com.azure.resourcemanager.test.utils.TestDelayProvider;
import com.azure.resourcemanager.test.utils.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.lang.reflect.Constructor;
import java.time.Duration;
import java.util.Arrays;
import java.util.Map;
import java.util.regex.Pattern;

public class FunctionAppsTests extends AppServiceTest {
    private String rgName1 = "";
    private String rgName2 = "";
    private String webappName1 = "";
    private String webappName2 = "";
    private String webappName3 = "";
    private String appServicePlanName1 = "";
    private String appServicePlanName2 = "";
    private String storageAccountName1 = "";

    protected StorageManager storageManager;
    protected ContainerAppsApiManager containerAppsApiManager;

    @Override
    protected void initializeClients(HttpPipeline httpPipeline, AzureProfile profile) {
        webappName1 = generateRandomResourceName("java-func-", 20);
        webappName2 = generateRandomResourceName("java-func-", 20);
        webappName3 = generateRandomResourceName("java-func-", 20);
        appServicePlanName1 = generateRandomResourceName("java-asp-", 20);
        appServicePlanName2 = generateRandomResourceName("java-asp-", 20);
        storageAccountName1 = generateRandomResourceName("javastore", 20);
        rgName1 = generateRandomResourceName("javacsmrg", 20);
        rgName2 = generateRandomResourceName("javacsmrg", 20);

        storageManager = buildManager(StorageManager.class, httpPipeline, profile);
        // build ContainerAppsApiManager
        try {
            Constructor<ContainerAppsApiManager> constructor = ContainerAppsApiManager.class
                .getDeclaredConstructor(httpPipeline.getClass(), profile.getClass(), Duration.class);
            Runnable runnable = () -> constructor.setAccessible(true);
            runnable.run();
            ResourceManagerUtils.InternalRuntimeContext.setDelayProvider(new TestDelayProvider(!isPlaybackMode()));
            containerAppsApiManager = constructor.newInstance(httpPipeline, profile,
                // Lite packages need this for playback mode, since they take defaultPollInterval directly as polling interval.
                ResourceManagerUtils.InternalRuntimeContext.getDelayDuration(Duration.ofSeconds(30)));

        } catch (ReflectiveOperationException ex) {
            throw LOGGER.logExceptionAsError(new RuntimeException(ex));
        }

        super.initializeClients(httpPipeline, profile);
    }

    @Override
    protected void cleanUpResources() {
        if (rgName1 != null) {
            resourceManager.resourceGroups().beginDeleteByName(rgName1);
        }
        if (rgName2 != null) {
            try {
                resourceManager.resourceGroups().beginDeleteByName(rgName2);
            } catch (ManagementException e) {
                // fine, RG_NAME_2 is not created
            }
        }
    }

    @Test
    public void canCRUDFunctionApp() throws Exception {
        // Create with consumption
        FunctionApp functionApp1 = appServiceManager.functionApps()
            .define(webappName1)
            .withRegion(Region.US_WEST)
            .withNewResourceGroup(rgName1)
            .create();
        Assertions.assertNotNull(functionApp1);
        Assertions.assertEquals(Region.US_WEST, functionApp1.region());
        Assertions.assertFalse(functionApp1.alwaysOn());
        AppServicePlan plan1 = appServiceManager.appServicePlans().getById(functionApp1.appServicePlanId());
        Assertions.assertNotNull(plan1);
        Assertions.assertEquals(Region.US_WEST, plan1.region());
        Assertions.assertEquals(new PricingTier(SkuName.DYNAMIC.toString(), "Y1"), plan1.pricingTier());

        FunctionAppResource functionAppResource1 = getStorageAccount(storageManager, functionApp1);
        // consumption plan requires this 2 settings
        Assertions.assertTrue(functionAppResource1.appSettings.containsKey(KEY_CONTENT_AZURE_FILE_CONNECTION_STRING));
        Assertions.assertTrue(functionAppResource1.appSettings.containsKey(KEY_CONTENT_SHARE));
        Assertions.assertEquals(functionAppResource1.appSettings.get(KEY_AZURE_WEB_JOBS_STORAGE).value(),
            functionAppResource1.appSettings.get(KEY_CONTENT_AZURE_FILE_CONNECTION_STRING).value());
        // verify accountKey
        if (!isPlaybackMode()) {
            Assertions.assertEquals(functionAppResource1.storageAccount.getKeys().get(0).value(),
                functionAppResource1.accountKey);
        }

        // Create with the same consumption plan
        FunctionApp functionApp2 = appServiceManager.functionApps()
            .define(webappName2)
            .withExistingAppServicePlan(plan1)
            .withNewResourceGroup(rgName2)
            .withExistingStorageAccount(functionApp1.storageAccount())
            .create();
        Assertions.assertNotNull(functionApp2);
        Assertions.assertEquals(Region.US_WEST, functionApp2.region());
        Assertions.assertFalse(functionApp2.alwaysOn());

        // Create with app service plan
        FunctionApp functionApp3 = appServiceManager.functionApps()
            .define(webappName3)
            .withRegion(Region.US_WEST)
            .withExistingResourceGroup(rgName2)
            .withNewAppServicePlan(PricingTier.BASIC_B1)
            .withExistingStorageAccount(functionApp1.storageAccount())
            .create();
        Assertions.assertNotNull(functionApp3);
        Assertions.assertEquals(Region.US_WEST, functionApp3.region());
        Assertions.assertTrue(functionApp3.alwaysOn());

        // app service plan does not have this 2 settings
        // https://github.com/Azure/azure-libraries-for-net/issues/485
        FunctionAppResource functionAppResource3 = getStorageAccount(storageManager, functionApp3);
        Assertions.assertFalse(functionAppResource3.appSettings.containsKey(KEY_CONTENT_AZURE_FILE_CONNECTION_STRING));
        Assertions.assertFalse(functionAppResource3.appSettings.containsKey(KEY_CONTENT_SHARE));
        // verify accountKey
        if (!isPlaybackMode()) {
            Assertions.assertEquals(functionAppResource3.storageAccount.getKeys().get(0).value(),
                functionAppResource3.accountKey);
        }

        // Get
        FunctionApp functionApp = appServiceManager.functionApps().getByResourceGroup(rgName1, functionApp1.name());
        Assertions.assertEquals(functionApp1.id(), functionApp.id());
        functionApp = appServiceManager.functionApps().getById(functionApp2.id());
        Assertions.assertEquals(functionApp2.name(), functionApp.name());

        // List
        PagedIterable<FunctionAppBasic> functionApps = appServiceManager.functionApps().listByResourceGroup(rgName1);
        Assertions.assertEquals(1, TestUtilities.getSize(functionApps));
        functionApps = appServiceManager.functionApps().listByResourceGroup(rgName2);
        Assertions.assertEquals(2, TestUtilities.getSize(functionApps));

        // Update
        functionApp2.update().withNewStorageAccount(storageAccountName1, StorageAccountSkuType.STANDARD_LRS).apply();
        Assertions.assertEquals(storageAccountName1, functionApp2.storageAccount().name());

        FunctionAppResource functionAppResource2 = getStorageAccount(storageManager, functionApp2);
        Assertions.assertTrue(functionAppResource2.appSettings.containsKey(KEY_CONTENT_AZURE_FILE_CONNECTION_STRING));
        Assertions.assertTrue(functionAppResource2.appSettings.containsKey(KEY_CONTENT_SHARE));
        Assertions.assertEquals(functionAppResource2.appSettings.get(KEY_AZURE_WEB_JOBS_STORAGE).value(),
            functionAppResource2.appSettings.get(KEY_CONTENT_AZURE_FILE_CONNECTION_STRING).value());
        Assertions.assertEquals(storageAccountName1, functionAppResource2.storageAccount.name());
        if (!isPlaybackMode()) {
            Assertions.assertEquals(functionAppResource2.storageAccount.getKeys().get(0).value(),
                functionAppResource2.accountKey);
        }

        // Update, verify modify AppSetting does not create new storage account
        // https://github.com/Azure/azure-libraries-for-net/issues/457
        int numStorageAccountBefore
            = TestUtilities.getSize(storageManager.storageAccounts().listByResourceGroup(rgName1));
        functionApp1.update().withAppSetting("newKey", "newValue").apply();
        int numStorageAccountAfter
            = TestUtilities.getSize(storageManager.storageAccounts().listByResourceGroup(rgName1));
        Assertions.assertEquals(numStorageAccountBefore, numStorageAccountAfter);
        FunctionAppResource functionAppResource1Updated = getStorageAccount(storageManager, functionApp1);
        Assertions.assertTrue(functionAppResource1Updated.appSettings.containsKey("newKey"));
        Assertions.assertEquals(functionAppResource1.appSettings.get(KEY_AZURE_WEB_JOBS_STORAGE).value(),
            functionAppResource1Updated.appSettings.get(KEY_AZURE_WEB_JOBS_STORAGE).value());
        Assertions.assertEquals(functionAppResource1.appSettings.get(KEY_CONTENT_AZURE_FILE_CONNECTION_STRING).value(),
            functionAppResource1Updated.appSettings.get(KEY_CONTENT_AZURE_FILE_CONNECTION_STRING).value());
        Assertions.assertEquals(functionAppResource1.appSettings.get(KEY_CONTENT_SHARE).value(),
            functionAppResource1Updated.appSettings.get(KEY_CONTENT_SHARE).value());
        Assertions.assertEquals(functionAppResource1.storageAccount.name(),
            functionAppResource1Updated.storageAccount.name());

        // Scale
        functionApp3.update().withNewAppServicePlan(PricingTier.STANDARD_S2).apply();
        Assertions.assertNotEquals(functionApp3.appServicePlanId(), functionApp1.appServicePlanId());
        Assertions.assertTrue(functionApp3.alwaysOn());
    }

    private static final String FUNCTION_APP_PACKAGE_URL
        = "https://raw.githubusercontent.com/Azure/azure-sdk-for-java/main/sdk/resourcemanager/azure-resourcemanager-appservice/src/test/resources/java-functions.zip";

    @Test
    public void canCRUDLinuxFunctionApp() throws Exception {
        rgName2 = null;

        // function app with consumption plan
        FunctionApp functionApp1 = appServiceManager.functionApps()
            .define(webappName1)
            .withRegion(Region.US_EAST)
            .withNewResourceGroup(rgName1)
            .withNewLinuxConsumptionPlan()
            .withBuiltInImage(FunctionRuntimeStack.JAVA_8)
            .withHttpsOnly(true)
            .withAppSetting("WEBSITE_RUN_FROM_PACKAGE", FUNCTION_APP_PACKAGE_URL)
            .withConnectionString("connectionName", "connectionValue", ConnectionStringType.CUSTOM)
            .create();
        Assertions.assertNotNull(functionApp1);
        assertLinuxJava(functionApp1, FunctionRuntimeStack.JAVA_8);
        Assertions.assertFalse(functionApp1.alwaysOn());
        Assertions.assertEquals("connectionValue", functionApp1.getConnectionStrings().get("connectionName").value());

        AppServicePlan plan1 = appServiceManager.appServicePlans().getById(functionApp1.appServicePlanId());
        Assertions.assertNotNull(plan1);
        Assertions.assertEquals(Region.US_EAST, plan1.region());
        Assertions.assertEquals(new PricingTier(SkuName.DYNAMIC.toString(), "Y1"), plan1.pricingTier());
        Assertions.assertTrue(plan1.innerModel().reserved());
        Assertions.assertTrue(Arrays.asList(functionApp1.innerModel().kind().split(Pattern.quote(",")))
            .containsAll(Arrays.asList("linux", "functionapp")));

        FunctionAppResource functionAppResource1 = getStorageAccount(storageManager, functionApp1);
        // consumption plan requires this 2 settings
        Assertions.assertTrue(functionAppResource1.appSettings.containsKey(KEY_CONTENT_AZURE_FILE_CONNECTION_STRING));
        Assertions.assertTrue(functionAppResource1.appSettings.containsKey(KEY_CONTENT_SHARE));
        Assertions.assertEquals(functionAppResource1.appSettings.get(KEY_AZURE_WEB_JOBS_STORAGE).value(),
            functionAppResource1.appSettings.get(KEY_CONTENT_AZURE_FILE_CONNECTION_STRING).value());
        // verify accountKey
        if (!isPlaybackMode()) {
            Assertions.assertEquals(functionAppResource1.storageAccount.getKeys().get(0).value(),
                functionAppResource1.accountKey);
        }

        PagedIterable<FunctionAppBasic> functionApps = appServiceManager.functionApps().listByResourceGroup(rgName1);
        Assertions.assertEquals(1, TestUtilities.getSize(functionApps));

        // function app with app service plan
        FunctionApp functionApp2 = appServiceManager.functionApps()
            .define(webappName2)
            .withRegion(Region.US_EAST)
            .withExistingResourceGroup(rgName1)
            .withNewLinuxAppServicePlan(PricingTier.STANDARD_S1)
            .withBuiltInImage(FunctionRuntimeStack.JAVA_8)
            .withHttpsOnly(true)
            .withAppSetting("WEBSITE_RUN_FROM_PACKAGE", FUNCTION_APP_PACKAGE_URL)
            .create();
        Assertions.assertNotNull(functionApp2);
        assertLinuxJava(functionApp2, FunctionRuntimeStack.JAVA_8);
        Assertions.assertTrue(functionApp2.alwaysOn());

        AppServicePlan plan2 = appServiceManager.appServicePlans().getById(functionApp2.appServicePlanId());
        Assertions.assertNotNull(plan2);
        Assertions.assertEquals(PricingTier.STANDARD_S1, plan2.pricingTier());
        Assertions.assertTrue(plan2.innerModel().reserved());

        // one more function app using existing app service plan
        FunctionApp functionApp3 = appServiceManager.functionApps()
            .define(webappName3)
            .withExistingLinuxAppServicePlan(plan2)
            .withExistingResourceGroup(rgName1)
            .withBuiltInImage(FunctionRuntimeStack.JAVA_8)
            .withHttpsOnly(true)
            .withAppSetting("WEBSITE_RUN_FROM_PACKAGE", FUNCTION_APP_PACKAGE_URL)
            .create();
        Assertions.assertNotNull(functionApp3);
        assertLinuxJava(functionApp3, FunctionRuntimeStack.JAVA_8);
        Assertions.assertTrue(functionApp3.alwaysOn());

        // wait for deploy
        if (!isPlaybackMode()) {
            ResourceManagerUtils.sleep(Duration.ofMinutes(3));
        }

        functionApps = appServiceManager.functionApps().listByResourceGroup(rgName1);
        Assertions.assertEquals(3, TestUtilities.getSize(functionApps));

        // verify deploy
        PagedIterable<FunctionEnvelope> functions
            = appServiceManager.functionApps().listFunctions(functionApp1.resourceGroupName(), functionApp1.name());
        Assertions.assertEquals(1, TestUtilities.getSize(functions));

        functions
            = appServiceManager.functionApps().listFunctions(functionApp2.resourceGroupName(), functionApp2.name());
        Assertions.assertEquals(1, TestUtilities.getSize(functions));

        functions
            = appServiceManager.functionApps().listFunctions(functionApp3.resourceGroupName(), functionApp3.name());
        Assertions.assertEquals(1, TestUtilities.getSize(functions));
    }

    @Test
    public void canCRUDLinuxFunctionAppPremium() {
        rgName2 = null;

        // function app with premium plan
        FunctionApp functionApp1 = appServiceManager.functionApps()
            .define(webappName1)
            .withRegion(Region.US_EAST)
            .withNewResourceGroup(rgName1)
            .withNewLinuxAppServicePlan(new PricingTier(SkuName.ELASTIC_PREMIUM.toString(), "EP1"))
            .withBuiltInImage(FunctionRuntimeStack.JAVA_8)
            .withHttpsOnly(true)
            .withAppSetting("WEBSITE_RUN_FROM_PACKAGE", FUNCTION_APP_PACKAGE_URL)
            .create();
        Assertions.assertNotNull(functionApp1);
        Assertions.assertTrue(functionApp1.alwaysOn());
        AppServicePlan plan1 = appServiceManager.appServicePlans().getById(functionApp1.appServicePlanId());
        Assertions.assertNotNull(plan1);
        Assertions.assertEquals(new PricingTier(SkuName.ELASTIC_PREMIUM.toString(), "EP1"), plan1.pricingTier());
        assertLinuxJava(functionApp1, FunctionRuntimeStack.JAVA_8);

        FunctionAppResource functionAppResource1 = getStorageAccount(storageManager, functionApp1);
        // premium plan requires this 2 settings
        Assertions.assertTrue(functionAppResource1.appSettings.containsKey(KEY_CONTENT_AZURE_FILE_CONNECTION_STRING));
        Assertions.assertTrue(functionAppResource1.appSettings.containsKey(KEY_CONTENT_SHARE));

        // wait for deploy
        if (!isPlaybackMode()) {
            ResourceManagerUtils.sleep(Duration.ofMinutes(3));
        }

        // verify deploy
        PagedIterable<FunctionEnvelope> functions
            = appServiceManager.functionApps().listFunctions(functionApp1.resourceGroupName(), functionApp1.name());
        Assertions.assertEquals(1, TestUtilities.getSize(functions));
    }

    @Test
    @Disabled("Need container registry")
    public void canCRUDLinuxFunctionAppPremiumDocker() {
        // function app with premium plan with private docker
        FunctionApp functionApp1 = appServiceManager.functionApps()
            .define(webappName1)
            .withRegion(Region.US_EAST)
            .withNewResourceGroup(rgName1)
            .withNewLinuxAppServicePlan(new PricingTier(SkuName.ELASTIC_PREMIUM.toString(), "EP1"))
            .withPrivateRegistryImage("weidxuregistry.azurecr.io/az-func-java:v1", "https://weidxuregistry.azurecr.io")
            .withCredentials("weidxuregistry", "PASSWORD")
            .withRuntime("java")
            .withRuntimeVersion("~3")
            .create();

        Assertions.assertFalse(functionApp1.alwaysOn());

        // deploy
        if (!isPlaybackMode()) {
            functionApp1.zipDeploy(new File(FunctionAppsTests.class.getResource("/java-functions.zip").getPath()));
        }
    }

    @Test
    public void canCRUDLinuxFunctionAppJava11() throws Exception {
        rgName2 = null;

        String runtimeVersion = "~4";

        // function app with consumption plan
        FunctionApp functionApp1 = appServiceManager.functionApps()
            .define(webappName1)
            .withRegion(Region.US_EAST)
            .withNewResourceGroup(rgName1)
            .withNewLinuxConsumptionPlan()
            .withBuiltInImage(FunctionRuntimeStack.JAVA_11)
            .withRuntimeVersion(runtimeVersion)
            .withHttpsOnly(true)
            .withAppSetting("WEBSITE_RUN_FROM_PACKAGE", FUNCTION_APP_PACKAGE_URL)
            .create();
        Assertions.assertNotNull(functionApp1);
        assertLinuxJava(functionApp1, FunctionRuntimeStack.JAVA_11, runtimeVersion);

        assertFunctionAppRunning(functionApp1);
    }

    @Test
    public void canCRUDLinuxFunctionAppJava17() throws Exception {
        rgName2 = null;

        // function app with consumption plan
        FunctionApp functionApp1 = appServiceManager.functionApps()
            .define(webappName1)
            .withRegion(Region.US_EAST)
            .withNewResourceGroup(rgName1)
            .withNewLinuxConsumptionPlan()
            .withBuiltInImage(FunctionRuntimeStack.JAVA_17)
            .withHttpsOnly(true)
            .withAppSetting("WEBSITE_RUN_FROM_PACKAGE", FUNCTION_APP_PACKAGE_URL)
            .create();
        Assertions.assertNotNull(functionApp1);
        assertLinuxJava(functionApp1, FunctionRuntimeStack.JAVA_17);

        assertFunctionAppRunning(functionApp1);
    }

    @Test
    public void canCreateAndUpdateFunctionAppWithContainerSize() {
        rgName2 = null;
        webappName1 = generateRandomResourceName("java-function-", 20);
        String functionDeploymentSlotName = generateRandomResourceName("fds", 15);

        FunctionApp functionApp1 = appServiceManager.functionApps()
            .define(webappName1)
            .withRegion(Region.US_WEST)
            .withNewResourceGroup(rgName1)
            .withContainerSize(512)
            .create();

        FunctionDeploymentSlot functionDeploymentSlot = functionApp1.deploymentSlots()
            .define(functionDeploymentSlotName)
            .withConfigurationFromParent()
            .withContainerSize(256)
            .create();

        Assertions.assertEquals(512, functionApp1.containerSize());
        Assertions.assertEquals(256, functionDeploymentSlot.containerSize());

        functionApp1.update().withContainerSize(320).apply();

        functionApp1.refresh();

        Assertions.assertEquals(320, functionApp1.containerSize());

        Assertions.assertEquals(256, functionDeploymentSlot.containerSize());

        functionDeploymentSlot.update().withContainerSize(128).apply();

        functionDeploymentSlot.refresh();

        Assertions.assertEquals(128, functionDeploymentSlot.containerSize());
    }

    @Test
    public void canCreateAndUpdateFunctionAppOnACA() {
        rgName2 = null;

        Region region = Region.US_EAST;
        ResourceGroup resourceGroup
            = appServiceManager.resourceManager().resourceGroups().define(rgName1).withRegion(region).create();
        webappName1 = generateRandomResourceName("java-function-", 20);
        // function app not created, get will throw exception
        Assertions.assertThrows(ManagementException.class,
            () -> appServiceManager.serviceClient().getWebApps().getByResourceGroup(rgName1, webappName1));

        String managedEnvironmentId = createAcaEnvironment(region, resourceGroup);
        appServiceManager.functionApps()
            .define(webappName1)
            .withRegion(region)
            .withExistingResourceGroup(resourceGroup)
            .withManagedEnvironmentId(managedEnvironmentId)
            .withMaxReplicas(10)
            .withMinReplicas(3)
            .withPublicDockerHubImage("mcr.microsoft.com/azure-functions/dotnet7-quickstart-demo:1.0")
            // backend has bug, it returns Array instead of Object:
            // https://github.com/Azure/azure-rest-api-specs/issues/27176
            //            .withConnectionString("connectionName", "connectionValue", ConnectionStringType.CUSTOM)
            .withAppSetting("customSetting", "mySettingValue")
            .create();

        FunctionApp functionApp = appServiceManager.functionApps().getByResourceGroup(rgName1, webappName1);

        assertResourceIdEquals(managedEnvironmentId, functionApp.managedEnvironmentId());
        Assertions.assertEquals(10, functionApp.maxReplicas());
        Assertions.assertEquals(3, functionApp.minReplicas());

        Assertions.assertNotNull(functionApp.getAppSettings());
        Assertions.assertEquals("mySettingValue", functionApp.getAppSettings().get("customSetting").value());
        //        Assertions.assertEquals("connectionValue", functionApp.getConnectionStrings().get("connectionName").value());

        functionApp.update()
            .withPublicDockerHubImage("mcr.microsoft.com/azure-functions/dotnet7-quickstart-demo:1.0")
            .apply();

        functionApp.update().withMaxReplicas(15).apply();

        // only changed max, min not changed
        Assertions.assertEquals(15, functionApp.maxReplicas());
        Assertions.assertEquals(3, functionApp.minReplicas());

        functionApp.update().withMinReplicas(5).apply();

        // only changed min, max not changed
        Assertions.assertEquals(15, functionApp.maxReplicas());
        Assertions.assertEquals(5, functionApp.minReplicas());
    }

    @Test
    @Disabled("need private registry image")
    public void canCreateAndUpdateFunctionAppOnAcaWithPrivateRegistryImage() {
        Region region = Region.US_EAST;
        ResourceGroup resourceGroup
            = appServiceManager.resourceManager().resourceGroups().define(rgName1).withRegion(region).create();
        webappName1 = generateRandomResourceName("java-function-", 20);
        // function app not created, get will throw exception
        Assertions.assertThrows(ManagementException.class,
            () -> appServiceManager.serviceClient().getWebApps().getByResourceGroup(rgName1, webappName1));

        String password = "PASSWORD";

        String managedEnvironmentId = createAcaEnvironment(region, resourceGroup);
        appServiceManager.functionApps()
            .define(webappName1)
            .withRegion(region)
            .withExistingResourceGroup(resourceGroup)
            .withManagedEnvironmentId(managedEnvironmentId)
            .withMaxReplicas(10)
            .withMinReplicas(3)
            .withPrivateRegistryImage("samples/nginx:latest", "https://xiaofeiacr.azurecr.io")
            .withCredentials("xiaofeiacr", password)
            .withRuntimeVersion("4")
            .create();

        FunctionApp functionApp = appServiceManager.functionApps().getByResourceGroup(rgName1, webappName1);

        Assertions.assertEquals(managedEnvironmentId, functionApp.managedEnvironmentId());
        Assertions.assertEquals(10, functionApp.maxReplicas());
        Assertions.assertEquals(3, functionApp.minReplicas());

        String connectionString = functionApp.getAppSettings().get(KEY_AZURE_WEB_JOBS_STORAGE).value();

        functionApp.update()
            .withMaxReplicas(15)
            .withPrivateRegistryImage("xiaofeiacr.azurecr.io/samples/nginx:latest", "https://xiaofeiacr.azurecr.io")
            .withCredentials("xiaofeiacr", password)
            .withNewStorageAccount(generateRandomResourceName("as", 15), StorageAccountSkuType.STANDARD_LRS)
            .apply();

        // only changed max, min not changed
        Assertions.assertEquals(15, functionApp.maxReplicas());
        Assertions.assertEquals(3, functionApp.minReplicas());

        Assertions.assertNotEquals(connectionString,
            functionApp.getAppSettings().get(KEY_AZURE_WEB_JOBS_STORAGE).value());

        // when serverUrl has no protocol(https), use imageAndTag directly
        functionApp.update()
            .withMaxReplicas(15)
            .withPrivateRegistryImage("xiaofeiacr.azurecr.io/samples/nginx:latest", "xiaofeiacr.azurecr.io")
            .withCredentials("xiaofeiacr", password)
            .apply();
    }

    @Test
    public void canCreateAndUpdatePublicNetworkAccess() {
        webappName1 = generateRandomResourceName("java-function-", 20);
        FunctionApp functionApp = appServiceManager.functionApps()
            .define(webappName1)
            .withRegion(Region.US_WEST)
            .withNewResourceGroup(rgName1)
            .withContainerSize(512)
            .disablePublicNetworkAccess()
            .create();

        functionApp.refresh();
        Assertions.assertEquals(PublicNetworkAccess.DISABLED, functionApp.publicNetworkAccess());

        functionApp.update().enablePublicNetworkAccess().apply();
        functionApp.refresh();
        Assertions.assertEquals(PublicNetworkAccess.ENABLED, functionApp.publicNetworkAccess());

        functionApp.update().disablePublicNetworkAccess().apply();
        functionApp.refresh();
        Assertions.assertEquals(PublicNetworkAccess.DISABLED, functionApp.publicNetworkAccess());

    }

    private String createAcaEnvironment(Region region, ResourceGroup resourceGroup) {
        String managedEnvironmentName = generateRandomResourceName("jvacam", 15);
        ManagedEnvironment managedEnvironment = containerAppsApiManager.managedEnvironments()
            .define(managedEnvironmentName)
            .withRegion(region)
            .withExistingResourceGroup(resourceGroup.name())
            .withZoneRedundant(false)
            .create();
        return managedEnvironment.id();
    }

    private static Map<String, AppSetting> assertLinuxJava(FunctionApp functionApp, FunctionRuntimeStack stack) {
        return assertLinuxJava(functionApp, stack, null);
    }

    private static Map<String, AppSetting> assertLinuxJava(FunctionApp functionApp, FunctionRuntimeStack stack,
        String runtimeVersion) {
        Assertions.assertEquals(stack.getLinuxFxVersion(), functionApp.linuxFxVersion());
        Assertions.assertTrue(Arrays.asList(functionApp.innerModel().kind().split(Pattern.quote(",")))
            .containsAll(Arrays.asList("linux", "functionapp")));
        Assertions.assertTrue(functionApp.innerModel().reserved());

        Map<String, AppSetting> appSettings = functionApp.getAppSettings();
        Assertions.assertNotNull(appSettings);
        Assertions.assertNotNull(appSettings.get(KEY_AZURE_WEB_JOBS_STORAGE));
        Assertions.assertEquals(stack.runtime(), appSettings.get(KEY_FUNCTIONS_WORKER_RUNTIME).value());
        Assertions.assertEquals(runtimeVersion == null ? stack.version() : runtimeVersion,
            appSettings.get(KEY_FUNCTIONS_EXTENSION_VERSION).value());

        return appSettings;
    }

    private static final String KEY_AZURE_WEB_JOBS_STORAGE = "AzureWebJobsStorage";
    private static final String KEY_CONTENT_AZURE_FILE_CONNECTION_STRING = "WEBSITE_CONTENTAZUREFILECONNECTIONSTRING";
    private static final String KEY_CONTENT_SHARE = "WEBSITE_CONTENTSHARE";
    private static final String KEY_FUNCTIONS_WORKER_RUNTIME = "FUNCTIONS_WORKER_RUNTIME";
    private static final String KEY_FUNCTIONS_EXTENSION_VERSION = "FUNCTIONS_EXTENSION_VERSION";

    private static final String ACCOUNT_NAME_SEGMENT = "AccountName=";
    private static final String ACCOUNT_KEY_SEGMENT = "AccountKey=";

    private static class FunctionAppResource {
        Map<String, AppSetting> appSettings;

        String accountName;
        String accountKey;

        StorageAccount storageAccount;
    }

    private static FunctionAppResource getStorageAccount(StorageManager storageManager, FunctionApp functionApp) {
        FunctionAppResource resource = new FunctionAppResource();
        resource.appSettings = functionApp.getAppSettings();

        String storageAccountConnectionString = resource.appSettings.get(KEY_AZURE_WEB_JOBS_STORAGE).value();
        String[] segments = storageAccountConnectionString.split(";");
        for (String segment : segments) {
            if (segment.startsWith(ACCOUNT_NAME_SEGMENT)) {
                resource.accountName = segment.substring(ACCOUNT_NAME_SEGMENT.length());
            } else if (segment.startsWith(ACCOUNT_KEY_SEGMENT)) {
                resource.accountKey = segment.substring(ACCOUNT_KEY_SEGMENT.length());
            }
        }
        if (resource.accountName != null) {
            PagedIterable<StorageAccount> storageAccounts = storageManager.storageAccounts().list();
            for (StorageAccount storageAccount : storageAccounts) {
                if (resource.accountName.equals(storageAccount.name())) {
                    resource.storageAccount = storageAccount;
                    break;
                }
            }
        }

        return resource;
    }
}
