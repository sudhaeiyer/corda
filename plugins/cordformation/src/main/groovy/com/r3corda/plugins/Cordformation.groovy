package com.r3corda.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * The Cordformation plugin deploys nodes to a directory in a state ready to be used by a developer for experimentation,
 * testing, and debugging. It will prepopulate several fields in the configuration and create a simple node runner.
 */
class Cordformation implements Plugin<Project> {
    void apply(Project project) {
        
    }

    /**
     * Gets a resource file from this plugin's JAR file.
     *
     * @param project The project environment this plugin executes in.
     * @param filePathInJar The file in the JAR, relative to root, you wish to access.
     * @return A file handle to the file in the JAR.
     */
    static File getPluginFile(Project project, String filePathInJar) {
        return project.resources.text.fromArchiveEntry(project.buildscript.configurations.classpath.find {
            it.name.contains('cordformation')
        }, filePathInJar).asFile()
    }
}
