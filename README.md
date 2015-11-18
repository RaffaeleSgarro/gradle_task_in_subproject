*Disclaimer: [This is a Short, Self Contained, Correct (Compilable), Example][sscce]*

I need to write a custom task to generate Java source files that interacts with
the database, but can't find a way to let the buildscript find its dependencies.
Consider the following tree of subprojects

```
| root
|
+-- utils
+-- gradle_generate_task (depends on utils)
+-- generated_java
+-- app (depends on utils, generated_java)
```

Here is what I put in the `build.gradle` of `generated_java`

```groovy
buildscript {
    dependencies {
        classpath project(":gradle_tasks")
    }
}

task regenerate(type: GenerateDatabaseObjectsTask) {
    // ...
}
```

But when I run `generated_java:regenerate` it complains:

```sh
FAILURE: Build failed with an exception.

* What went wrong:
A problem occurred configuring project ':generated_java'.
> Cannot use project dependencies in a script classpath definition.
```

[sscce]: <http://sscce.org/>
