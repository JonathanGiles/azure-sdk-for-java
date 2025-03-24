package com.example;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.*;
import org.apache.maven.artifact.DependencyResolutionRequiredException;
import org.apache.maven.execution.MavenSession;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Mojo(name = "compile-golden-image")
public class GoldenImageCompilerMojo extends AbstractMojo {
    private static final boolean LIST_DEPENDENCIES = false;
    private static final boolean LIST_CLASSES = false;
    private static final boolean LOG_COMPILE_COMMAND = false;

    /**
     * Comma-separated list of profiles to build.
     * For example: "v1,v2"
     */
    @Parameter(property = "targetProfiles", defaultValue = "v1")
    private String targetProfiles;

    @Parameter(defaultValue = "${project.basedir}", readonly = true)
    private File baseDir;

    @Parameter(defaultValue = "${project}", readonly = true, required = true)
    private MavenProject project;

    @Parameter(defaultValue = "${session}", readonly = true, required = true)
    private MavenSession session;

    @Component
    private ProjectBuilder projectBuilder;

    public void execute() throws MojoExecutionException {
        String testResourcesPath = baseDir.getAbsolutePath() + "/src/test/resources/migrationExamples";
        File testResourcesDir = new File(testResourcesPath);

        if (!testResourcesDir.exists()) {
            throw new MojoExecutionException("Test resources directory does not exist: " + testResourcesPath);
        }

        List<File> testFolders = findTestFolders(testResourcesDir);
        String[] profiles = targetProfiles.split(",");

        for (File folder : testFolders) {
            for (String profile : profiles) {
                File profileDir = new File(folder, profile);

                if (!profileDir.exists()) {
                    getLog().warn("Skipping " + folder.getAbsolutePath() + " as profile directory " + profile + " does not exist.");
                    continue;
                }

                compileJavaFilesWithProfile(profileDir, profile);
            }
        }
    }

    private List<File> findTestFolders(File baseDir) throws MojoExecutionException {
        try (Stream<Path> paths = Files.walk(baseDir.toPath())) {
            return paths
                .filter(Files::isDirectory)
                .filter(path -> path.resolve("v1").toFile().exists() && path.resolve("v2").toFile().exists())
                .map(Path::toFile)
                .collect(Collectors.toList());
        } catch (IOException e) {
            throw new MojoExecutionException("Failed to find test folders", e);
        }
    }

    private void compileJavaFilesWithProfile(File dir, String profile) throws MojoExecutionException {
        getLog().info("Compiling " + dir.getAbsolutePath() + " using profile " + profile);

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        if (compiler == null) {
            throw new MojoExecutionException("No Java compiler available. Make sure you are running the plugin with a JDK.");
        }

        try (Stream<Path> paths = Files.walk(Paths.get(dir.getAbsolutePath()))) {
            List<String> javaFiles = paths
                .filter(Files::isRegularFile)
                .map(Path::toString)
                .filter(string -> string.endsWith(".java"))
                .collect(Collectors.toList());

            if (javaFiles.isEmpty()) {
                getLog().warn("No Java files found in " + dir.getAbsolutePath());
                return;
            }

            if (LIST_CLASSES) {
                // Log the Java files that will be compiled
                getLog().info("Java files to be compiled:");
                for (String javaFile : javaFiles) {
                    getLog().info(" - " + javaFile);
                }
            }

            // Activate the profile and rebuild the project
            ProjectBuildingRequest buildingRequest = session.getProjectBuildingRequest();
            buildingRequest.setActiveProfileIds(Collections.singletonList(profile));
            buildingRequest.setResolveDependencies(true);

            // Rebuild the project with the active profile
            ProjectBuildingResult result;
            try {
                result = projectBuilder.build(project.getFile(), buildingRequest);
            } catch (ProjectBuildingException e) {
                getLog().error("Failed to build project with profile " + profile, e);
                throw new MojoExecutionException("Failed to build project with profile " + profile, e);
            }
            MavenProject activeProject = result.getProject();

            // Add classpath dependencies
            List<String> classpathElements;
            try {
                classpathElements = activeProject.getCompileClasspathElements();
            } catch (DependencyResolutionRequiredException e) {
                getLog().error("Failed to resolve dependencies for profile " + profile, e);
                throw new MojoExecutionException("Failed to resolve dependencies for profile " + profile, e);
            }
            String classpath = String.join(File.pathSeparator, classpathElements);

            // Log the classpath elements
            if (LIST_DEPENDENCIES) {
                getLog().info("Classpath for profile " + profile + ":");
                for (String element : classpathElements) {
                    getLog().info(" - " + element);
                }
            }

            // Create the compilation command
            List<String> compileOptions = new ArrayList<>(javaFiles);
            compileOptions.add(0, "-classpath");
            compileOptions.add(1, classpath);

            // Log the compilation command
            if (LOG_COMPILE_COMMAND) {
                getLog().info("Compilation command:");
                for (String option : compileOptions) {
                    getLog().info(" " + option);
                }
            }

            // Compile Java files
            int compileResult = compiler.run(null, null, null, compileOptions.toArray(new String[0]));

            if (compileResult != 0) {
                throw new MojoExecutionException("Compilation failed for " + dir.getAbsolutePath());
            } else {
                getLog().info("Compilation successful for " + dir.getAbsolutePath());
            }
        } catch (IOException e) {
            getLog().error("Failed to compile Java files in " + dir.getAbsolutePath(), e);
            throw new MojoExecutionException("Failed to compile Java files in " + dir.getAbsolutePath(), e);
        } finally {
            // Clean up .class files
            cleanClassFiles(dir);
        }
    }

    private void cleanClassFiles(File dir) {
        try (Stream<Path> paths = Files.walk(dir.toPath())) {
            List<Path> classFiles = paths
                .filter(Files::isRegularFile)
                .filter(path -> path.toString().endsWith(".class"))
                .collect(Collectors.toList());

            for (Path classFile : classFiles) {
                Files.delete(classFile);
                getLog().info("Deleted .class file: " + classFile.toString());
            }
        } catch (IOException e) {
            getLog().error("Failed to clean .class files in " + dir.getAbsolutePath(), e);
        }
    }
}
