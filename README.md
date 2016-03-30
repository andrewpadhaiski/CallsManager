# CallsManager
Simple Application that accepts a call, validate it and store the formatted result in a file.

Application internally uses Spring Boot with an embedded application server Tomcat.

#### There are two ways to run the application:

1. Using spring boot plugin for gradle

```
    gradle springBoot
```

2. Building an executable jar

```
    gradle build
    java -jar build/libs/CallsManager-0.1.jar
```

#### Use case:

Application provides next url for call creation:

```
   POST api/call
```

which accepts the next json structure:

```
    {
        "firstName":"Andrew",
        "lastName":"Padhaiski",
        "telephoneNumber": "111123443333"
    }

```

Successful response has http status code 201 Created with following json.

```
    {
         "firstName": "Andrew",
         "lastName": "Padhaiski",
         "time": "10:52:22",
         "telephoneNumber": "00111 123 443 333"
    }

The file is created in the directory where you run java - jar command.
