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
        classpath project(":gradle_generate_task")
    }
}

task(regenerate, type: GenerateDatabaseObjects) {
  // ...
}
```

But when I run `generated_java:regenerate` it can't find anything:

```
FAILURE: Build failed with an exception.                                                                       

* What went wrong:                                                                                             
A problem occurred configuring project ':generated_java'.                                                    
> Could not resolve all dependencies for configuration ':generated_java:classpath'.                          
   > Could not find org.apache.commons:commons-lang3:3.1.                                                      
     Required by:                                                                                              
         app:generated_java:unspecified > app:gradle_generate_task:unspecified                    
         app:generated_java:unspecified > app:gradle_generate_task:unspecified > app:utils:unspecified                                                                                                
         app:generated_java:unspecified > app:gradle_generate_task:unspecified > app:utils:unspecified > app:base:unspecified                                                         
         app:generated_java:unspecified > app:gradle_generate_task:unspecified > app:utils:unspecified > app:base2:unspecified                                                   
   > Could not find org.slf4j:slf4j-api:1.6.6.                                                                 
     Required by:                                                                                              
         app:generated_java:unspecified > app:gradle_generate_task:unspecified                    
         app:generated_java:unspecified > app:gradle_generate_task:unspecified > app:lib
```

[sscce]: <http://sscce.org/>
