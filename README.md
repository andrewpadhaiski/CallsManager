# CallsManager
Simple Application that accepts a call, validate it and store the formatted result in a file.

Application internally uses Spring Boot with an embedded application server Tomcat.

There are two ways to run the application:

1. Using spring boot plugin for gradle. 1

```
    gradle springBoot
```

2. Building an executable jar. 2

```
    gradle build
    java -jar build/libs/CallsManager-0.1.jar
```

NOTE: The file is created in the directory where you run java - jar command
