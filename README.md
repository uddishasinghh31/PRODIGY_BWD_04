<div align="center">

# 🚀 Spring Boot User CRUD REST API

### RESTful CRUD Operations using Spring Boot | Java | Maven | UUID | Validation

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.x-6DB33F?style=for-the-badge&logo=springboot)
![Maven](https://img.shields.io/badge/Maven-Build-C71A36?style=for-the-badge&logo=apachemaven)
![REST API](https://img.shields.io/badge/REST-API-blue?style=for-the-badge)
![Validation](https://img.shields.io/badge/Jakarta-Validation-success?style=for-the-badge)
![UUID](https://img.shields.io/badge/UUID-Identifier-purple?style=for-the-badge)

**A clean and well-structured RESTful API built with Spring Boot that performs complete CRUD operations on user data using in-memory storage, request validation, UUID identifiers, and layered architecture.**

</div>

---

# 📌 Project Overview

This project was developed as part of the **Prodigy InfoTech Internship – Task 1: Build a REST API for CRUD Operations**.

The application demonstrates the fundamentals of backend development by implementing a RESTful API capable of creating, retrieving, updating, and deleting user records.

The project follows a clean layered architecture (**Controller → Service → DTO → Model**) and uses **HashMap** as an in-memory data store, making it ideal for learning Spring Boot fundamentals before integrating a database.

---

# ✨ Features

- ✅ Create User
- ✅ Retrieve All Users
- ✅ Retrieve User by ID
- ✅ Update Existing User
- ✅ Delete User
- ✅ UUID Generated for Every User
- ✅ In-Memory Storage using HashMap
- ✅ Request Validation
- ✅ Global Exception Handling
- ✅ Layered Architecture
- ✅ RESTful API Design
- ✅ Tested using Postman

---

# 🛠 Tech Stack

| Technology | Purpose |
|------------|---------|
| Java 21 | Programming Language |
| Spring Boot | Backend Framework |
| Spring Web MVC | REST API Development |
| Maven | Dependency Management |
| Jakarta Bean Validation | Request Validation |
| UUID | Unique User Identifier |
| HashMap | In-Memory Storage |
| IntelliJ IDEA | Development Environment |
| Postman | API Testing |

---

# 🏗 Project Architecture

```text
                 Client (Postman)

                        │
                        ▼

             ┌─────────────────────┐
             │   UserController     │
             └─────────────────────┘
                        │
                        ▼

             ┌─────────────────────┐
             │    UserService       │
             └─────────────────────┘
                        │
                        ▼

             ┌─────────────────────┐
             │ HashMap<UUID, User>  │
             └─────────────────────┘
```

---

# 📂 Project Structure

```text
basic-rest-api
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.basic_rest_api
│   │   │
│   │   ├── controller
│   │   │     └── UserController.java
│   │   │
│   │   ├── dto
│   │   │     └── UserRequest.java
│   │   │
│   │   ├── exception
│   │   │     ├── GlobalExceptionHandler.java
│   │   │     └── UserNotFoundException.java
│   │   │
│   │   ├── model
│   │   │     └── User.java
│   │   │
│   │   ├── service
│   │   │     └── UserService.java
│   │   │
│   │   └── BasicRestApiApplication.java
│   │
│   └── resources
│
├── pom.xml
├── README.md
└── .gitignore
```

---

# 📦 Data Model

Each user contains the following fields:

| Field | Type |
|--------|------|
| id | UUID |
| name | String |
| email | String |
| age | Integer |

---

# 🔗 REST API Endpoints

| Method | Endpoint | Description | Response |
|---------|----------|-------------|----------|
| POST | `/api/users` | Create User | 201 Created |
| GET | `/api/users` | Retrieve All Users | 200 OK |
| GET | `/api/users/{id}` | Retrieve User by UUID | 200 OK |
| PUT | `/api/users/{id}` | Update User | 200 OK |
| DELETE | `/api/users/{id}` | Delete User | 204 No Content |

---

# 🧪 Sample Request

## Create User

```http
POST /api/users
```

```json
{
  "name": "Ritu Singh",
  "email": "ritu@example.com",
  "age": 24
}
```

---

## Successful Response

```json
{
  "id": "81acc614-cae5-44a2-881e-d85156fa6efb",
  "name": "Ritu Singh",
  "email": "ritu@example.com",
  "age": 24
}
```

---

# ⚠️ Validation & Error Handling

| Scenario | Status Code |
|----------|-------------|
| Invalid Request Body | 400 Bad Request |
| Invalid Email | 400 Bad Request |
| Missing Required Fields | 400 Bad Request |
| User Not Found | 404 Not Found |

Example Error Response

```json
{
  "error": "User not found with id: xxxxxxxxx"
}
```

---

# ⚙️ How to Run the Project

## Clone Repository

```bash
git clone https://github.com/uddishasinghh31/YOUR_REPOSITORY_NAME.git
```

---

## Open in IntelliJ IDEA

Import the project as a **Maven Project** and allow dependencies to download.

---

## Run the Application

Using Maven

```bash
mvn spring-boot:run
```

or simply run

```
BasicRestApiApplication.java
```

---

The application starts at

```
http://localhost:8080
```

---

# 📝 Notes

- Data is stored in memory using **HashMap**.
- Restarting the application clears all stored users.
- UUIDs are automatically generated for every new user.
- Input validation is handled using Jakarta Bean Validation annotations.

---

# 🚀 Future Improvements

- MySQL Database Integration
- Spring Data JPA
- Hibernate ORM
- Flyway Database Migration
- Spring Security
- JWT Authentication
- Swagger/OpenAPI Documentation
- Docker Support
- Unit Testing with JUnit & Mockito
- Cloud Deployment (AWS / Railway / Render)

---

# 👩‍💻 Author

**Udisha Singh**

Backend Developer | Java | Spring Boot | MySQL

- **GitHub:** https://github.com/uddishasinghh31
- **LinkedIn:** https://www.linkedin.com/in/udisha-singh-47170b338

---

# 📄 Internship Details

**Organization:** Prodigy InfoTech

- **Task 1:** Build a REST API for CRUD Operations using Spring Boot
- **Storage:** In-Memory using HashMap
- **Architecture:** Controller → Service → DTO → Model

---

<div align="center">

### ⭐ If you found this project useful, please consider giving it a Star!

</div>
