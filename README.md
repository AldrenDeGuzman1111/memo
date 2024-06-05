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
![image](https://github.com/AldrenDeGuzman1111/memo/assets/171792343/246e63c8-3b01-41bb-a93f-8c794ca4c16d)

Configure the application.properties file to use SQLite as the database:
![image](https://github.com/AldrenDeGuzman1111/memo/assets/171792343/b41cbecd-d3ef-4dfb-93e5-58e264cbed0a)

## Running the application

