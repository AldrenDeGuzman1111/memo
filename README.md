# Summary Note taker
This guide provided a step-by-step process to create a CRUD API for managing memos using Spring Boot and SQLite. Here are the key components:

1. **Setup**: Created a new Spring Boot project and added dependencies.
2. **Configuration**: Configured SQLite in **`application.properties`**.
3. **Entity**: Created a Memo entity class.
4. **Repository**: Defined a repository interface for CRUD operations.
5. **Service**: Implemented a service class for business logic.
6. **Controller**: Created a REST controller to expose CRUD operations via HTTP endpoints.
7. **Execution**: Ran the application to test the API endpoints.
This setup ensures a structured and modular approach to developing a RESTful API with Spring Boot, providing a foundation for further enhancements and customizations.

**NOTE:**
no need to install other application for sql lite the library from maven will autmatically create the DB if it's not existing

##Configure SQLite Database
Add the SQLite dependency in your pom.xml:
```bash
<dependency>
    <groupId>org.xerial</groupId>
    <artifactId>sqlite-jdbc</artifactId>
    <version>3.36.0.3</version>
</dependency>
```

Configure the application.properties file to use SQLite as the database:
```bash
spring.datasource.url=jdbc:sqlite:memodb.db
spring.datasource.driver-class-name=org.sqlite.JDBC
spring.datasource.username=
spring.datasource.password=
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.SQLiteDialect
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
```

 ## **Try the sample application**


In your terminal, `cd` into the root directory of your local repository. Set the `SPRING_PROFILES_ACTIVE` environment variable with
the appropriate Spring profile name. For our example, we will use the `local` profile:
```bash
# On a -nix based OS
> export SPRING_PROFILES_ACTIVE=local

# In a Windows command prompt where you will run mvn:
> set SPRING_PROFILES_ACTIVE=local
```
Other profiles include `non-prod` and `production` - these profiles can be used to switch between different configurations for the app. For example, `local` displays
logs in the console, whereas `non-prod` and `production` sends logs to your GCP project's Stackdriver service. The [logging readme](docs/logging-java.md) has a guide
to help you locate the log entries in  our GCP project.

To test your sample application directly in the terminal, enter the following command:

    mvn spring-boot:run

This will run the application with the JVM arguments specified in your [pom.xml](pom.xml) (check the configuration comment under `spring-boot-maven-plugin`.)

To package the sample app into a runnable JAR file, enter the following command:

    mvn package

This should produce a JAR file in a directory named `target/` (for example `target/spring-boot-1.0.0-SNAPSHOT.jar`). To run the app, enter the following command:

    java -jar <path to your JAR file>

In our example, `<path to your JAR file>` would be replaced with `target/spring-boot-1.0.0-SNAPSHOT.jar`.
Applications run using `java -jar ...` do not use the JVM arguments listed in `pom.xml`, so they must be entered explicitly in the command (as in the
[Dockerfile](Dockerfile).) For example:

    java -Xmx2048m -Xdebug -DargumentName=someValue -jar <path to your JAR file>

Once the app has started: go to your web browser, type `localhost:8080` into the address bar, and play around with the webpages.

To stop the app, use `Ctrl + C` in the terminal.

To package the app again after having made changes, run:

    mvn clean
    mvn package

See [TMF 630 Spectral Linting](docs/tmf-linting.md) for details, to generate/update swagger file (.oas2.yml), run:

    mvn install
   
or

    mvn verify
 

