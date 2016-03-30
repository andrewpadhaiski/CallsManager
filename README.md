# CallsManager
Simple Application that accepts a call, validate it and store the formatted result in a file.

Application internally uses Spring Boot with an embedded application server Tomcat.
Building tool is gradle. Distribution of gradle you can find [here](http://gradle.org/). 

#### There are two ways to run the application:

* Using spring boot plugin for gradle

```
    gradle springBoot
```

* Building and running an executable jar file

```
    gradle build
    java -jar build/libs/CallsManager-0.1.jar
```

#### Use case:

Application provides next url for call creation

```
   POST api/call
```

Accepted json data are the following:

```
    {
        "firstName":"Andrew",
        "lastName":"Padhaiski",
        "telephoneNumber": "111123443333"
    }
```

If request didn't pass the validation rules, response with status code 400 (Bad Request) will send to client

```
    {
        "timestamp": 1459337367199,
        "status": 400,
        "error": "Bad Request",
        "exception": "com.redalpha.callsmanager.exception.ValidationException",
        "message": "First name cannot be more than 30 characters.",
        "path": "/api/call"
    }
```

Successful response has http status code 201 (Created) with following json.

```
    {
         "firstName": "Andrew",
         "lastName": "Padhaiski",
         "time": "10:52:22",
         "telephoneNumber": "00111 123 443 333"
    }
```

The file is created in the directory where you run java - jar command.
