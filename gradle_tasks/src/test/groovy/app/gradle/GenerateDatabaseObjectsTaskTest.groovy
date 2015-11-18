package app.gradle;

import org.gradle.api.Project;
import org.gradle.testfixtures.ProjectBuilder;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class GenerateDatabaseObjectsTaskTest {

    @Test
    public void testGenerate() throws Exception {
        Project project = ProjectBuilder.builder().build()
        def task = project.task('greeting', type: GenerateDatabaseObjectsTask)
        assertTrue(task instanceof GenerateDatabaseObjectsTask)
    }
}