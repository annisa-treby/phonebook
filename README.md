# phonebook-app
application to manage 

## Requirements
- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [maven 4.0](https://maven.apache.org)
- postman

## Running the application locally

1. open command prompt
2. run command for build project

    ```shell
    mvn clean install
    ```
3. run project locally
    ```shell
    java -jar .\target\phonebook-0.0.1-SNAPSHOT.jar
    ```
4. open postman
5. import postman collection inside the project phonebook (phone-book.postman_collection.json)
