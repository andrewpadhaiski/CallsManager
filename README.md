# CallsManager
Simple Application that accepts a call, validate it and store the formatted result in a file.

Application internally uses Spring Boot with an embedded application server Tomcat.

There are two ways to run the project:

1) Using spring boot plugin for gradle.

gradle springBoot

2) Building an executable jar:

gradle build
java -jar build/libs/CallsManager-0.1.jar

NOTE: The file is created in the directory where you run java - jar command
