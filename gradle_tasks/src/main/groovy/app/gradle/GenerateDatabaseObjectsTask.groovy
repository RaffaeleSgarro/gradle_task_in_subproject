package app.gradle

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class GenerateDatabaseObjectsTask extends DefaultTask {

    String greeting = 'Default message'

    @TaskAction
    def generate() {
        println greeting
    }
}
