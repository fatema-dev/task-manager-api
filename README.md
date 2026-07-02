# Task Manager API

A RESTful API for managing tasks, built with Spring Boot. Supports full CRUD operations (create, read, update, delete) backed by an in-memory H2 database, with a clean layered architecture separating controller, service, and repository responsibilities.

## Overview

This project was built to practice designing and implementing a REST API from the ground up using the Spring ecosystem, covering routing, request/response handling, dependency injection, and data persistence with Spring Data JPA. Endpoints were tested and validated using Postman.

## Tech Stack

- **Java**
- **Spring Boot**
- **Spring Web** REST controller layer
- **Spring Data JPA** repository/persistence layer
- **H2 Database** in-memory database for development/testing
- **Maven**  build and dependency management
- **JUnit 5**  testing framework

## Project Structure

```
src/main/java/com/fatema/taskmanager/
├── TaskmanagerApplication.java     # Application entry point
├── controller/
│   └── Controller.java             # REST endpoints
├── service/
│   └── TaskService.java            # Business logic
├── repository/
│   └── TaskRepository.java         # Data access (extends JpaRepository)
└── model/
    └── Task.java                   # Task entity
```

## API Endpoints

| Method | Endpoint      | Description              | Request Body | Response              |
|--------|---------------|---------------------------|---------------|------------------------|
| GET    | `/tasks`      | Get all tasks             | —             | `200 OK` + list of tasks |
| GET    | `/tasks/{id}` | Get a single task by ID   | —             | `200 OK` or `404 Not Found` |
| POST   | `/tasks`      | Create a new task         | Task JSON     | `201 Created` + created task |
| PUT    | `/tasks/{id}` | Update an existing task   | Task JSON     | `200 OK` or `404 Not Found` |
| DELETE | `/tasks/{id}` | Delete a task by ID       | —             | `204 No Content` or `404 Not Found` |

### Task object

```json
{
  "id": 1,
  "title": "Finish README",
  "desc": "Write documentation for the Task Manager API",
  "done": false
}
```

`id` is auto-generated, omit it when creating a new task.

## Getting Started

### Prerequisites

- Java 17+ 
- Maven (or use the included Maven Wrapper, no local install needed)

### Run the application

```bash
git clone https://github.com/fatema-dev/task-manager-api.git
cd task-manager-api
./mvnw spring-boot:run
```

On Windows, use `mvnw.cmd spring-boot:run` instead.

The API will start on `http://localhost:8080` by default.

### Testing the API

All endpoints were tested using **Postman**. Example request to create a task:

```
POST http://localhost:8080/tasks
Content-Type: application/json

{
  "title": "Buy groceries",
  "desc": "Milk, eggs, bread",
  "done": false
}
```

## What I Learned

- Structuring a Spring Boot application into distinct controller, service, and repository layers for separation of concerns
- Using Spring Data JPA's `JpaRepository` to handle CRUD operations without writing boilerplate SQL
- Returning proper HTTP status codes (`200`, `201`, `204`, `404`) based on request outcomes using `ResponseEntity`
- Handling `Optional` results from the repository layer to avoid null-pointer issues
- Testing REST endpoints systematically with Postman

## Future Improvements

- Add input validation (e.g. reject empty titles) using `@Valid` and Bean Validation
- Add pagination and sorting for `GET /tasks`
- Replace H2 with a persistent database (PostgreSQL/MySQL) for production use
- Add unit and integration tests for the service and controller layers
- Add global exception handling with `@ControllerAdvice`

## License

MIT
