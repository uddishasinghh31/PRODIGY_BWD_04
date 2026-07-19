# 🚀 Spring Boot User Management REST API

<div align="center">

![Java](https://img.shields.io/badge/Java-25-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.1-green?style=for-the-badge&logo=springboot)
![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=springsecurity)
![JWT](https://img.shields.io/badge/JWT-Authentication-black?style=for-the-badge)
![Redis](https://img.shields.io/badge/Redis-Docker-red?style=for-the-badge&logo=redis)
![Docker](https://img.shields.io/badge/Docker-Container-blue?style=for-the-badge&logo=docker)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue?style=for-the-badge&logo=mysql)
![Flyway](https://img.shields.io/badge/Flyway-Migrations-brown?style=for-the-badge)
![Maven](https://img.shields.io/badge/Maven-Build-red?style=for-the-badge&logo=apachemaven)

### Secure User Management REST API using Spring Boot

A production-style REST API built using **Spring Boot**, **Spring Security**, **JWT Authentication**, **Redis Caching**, **MySQL**, **Flyway Database Migration**, and **Docker**.

</div>

---

# 📌 Project Overview

This project demonstrates how modern backend applications are built using Spring Boot with secure authentication, database persistence, caching, and database version control.

The application follows a clean layered architecture:

- Controller
- Service
- Repository
- Database

The project secures all protected endpoints using **JWT Authentication** and improves performance using **Redis Cache** running inside a **Docker container**.

---

# ✨ Features

- 🔐 JWT Authentication
- 👤 User Registration
- 🔑 User Login
- 🛡 Spring Security
- 📦 CRUD Operations
- 🗄 MySQL Database
- ⚡ Redis Cache
- 🐳 Dockerized Redis
- 🔄 Flyway Database Migration
- 📑 Request Validation
- ❌ Global Exception Handling
- 🧩 Layered Architecture
- 🚀 Maven Build
- 📬 API Testing using Postman

---

# 🛠 Tech Stack

| Technology | Used |
|------------|------|
| Java 25 | ✅ |
| Spring Boot | ✅ |
| Spring Security | ✅ |
| JWT | ✅ |
| Spring Data JPA | ✅ |
| Hibernate | ✅ |
| MySQL | ✅ |
| Redis | ✅ |
| Docker | ✅ |
| Flyway | ✅ |
| Maven | ✅ |
| IntelliJ IDEA | ✅ |
| Postman | ✅ |

---

# 🏗 Project Architecture

```text
                Client (Postman)

                       │
                       ▼

              Spring Security

                       │
                       ▼

             JWT Authentication

                       │
                       ▼

              User Controller

                       │
                       ▼

               Service Layer

              ↙              ↘

        Redis Cache      JPA Repository

              │               │

           Docker        Hibernate ORM

                              │

                              ▼

                       MySQL Database
```

---

# 📂 Project Structure

```text
basic-rest-api
│
├── docs
│   └── screenshots
│
├── src
│   ├── main
│   │
│   ├── java
│   │     └── com.example.basic_rest_api
│   │
│   │          ├── config
│   │          ├── controller
│   │          ├── dto
│   │          ├── exception
│   │          ├── model
│   │          ├── repository
│   │          ├── security
│   │          ├── service
│   │          └── BasicRestApiApplication
│   │
│   └── resources
│        ├── application.properties
│        └── db
│             └── migration
│
├── pom.xml
├── docker-compose.yml
├── README.md
└── .gitignore
```

---

# 🔗 REST API Endpoints

## Authentication APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/auth/register` | Register User |
| POST | `/auth/login` | Login User |

---

## User APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | `/users` | Get All Users |
| GET | `/users/{id}` | Get User by ID |
| PUT | `/users/{id}` | Update User |
| DELETE | `/users/{id}` | Delete User |

> 🔒 All User APIs require a valid JWT Token.

---

# 🔐 JWT Authentication Flow

```text
Register User
      │
      ▼
Login
      │
      ▼
JWT Token Generated
      │
      ▼
Authorization Header

Bearer <JWT Token>

      │
      ▼
Spring Security Filter
      │
      ▼
Protected APIs
```

---

# ⚡ Redis Cache Flow

```text
Client

   │

GET /users

   │

   ▼

Redis Cache ?

YES ─────────► Return Cached Response

NO

 │

 ▼

MySQL Database

 │

 ▼

Store Data in Redis

 │

 ▼

Return Response
```

Redis is used to cache frequently requested user data to reduce unnecessary database queries and improve response time.

---

# 🐳 Docker

Redis runs inside a Docker container.

### Run Redis

```bash
docker run -d --name redis-server -p 6379:6379 redis
```

### Start Existing Container

```bash
docker start redis-server
```

### Verify Running Containers

```bash
docker ps
```

---

# 🗄 Flyway Database Migration

Database schema is managed automatically using Flyway.

```text
V1__create_users_table.sql

↓

V2__insert_initial_data.sql

↓

Executed Automatically
During Application Startup
```

---

# 🚀 Getting Started

## Clone Repository

```bash
git clone https://github.com/uddishasinghh31/YOUR_REPOSITORY_NAME.git
```

---

## Open Project

Open the project using IntelliJ IDEA.

---

## Configure MySQL

Update your `application.properties`.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/prodigy_task2_db
spring.datasource.username=root
spring.datasource.password=your_password
```

---

## Start Redis

```bash
docker start redis-server
```

---

## Run Application

```bash
mvn spring-boot:run
```

or run

```
BasicRestApiApplication.java
```

Application starts on:

```
http://localhost:8080
```

---

# 📮 Testing with Postman

1. Register a new user.
2. Login using registered credentials.
3. Copy the generated JWT Token.
4. Add it to the Authorization Header.

```text
Authorization

Bearer your_jwt_token
```

5. Access all protected APIs.

---

# 📸 Project Screenshots

## 📂 Project Structure

<p align="center">
<img src="task_4_fileStructure.png" width="280"/>
</p>

---

## 🎫 JWT Token Generated

<p align="center">
<img src="task_4_postman_working.png" width="850"/>
</p>

---

## 🗄 MySQL Database

<p align="center">
<img src="docs/screenshots/mysql_database.png" width="850"/>
</p>

---

## ⚡ Redis Cache

<p align="center">
<img src="redis_caching.png" width="850"/>
</p>

---

## 🐳 Docker Redis Container

<p align="center">
<img src="redis_containers.png" width="850"/>
</p>

---

# 🎥 Project Demo

<p align="center">
<img src="docs/screenshots/demo.gif" width="900"/>
</p>

Or upload a video and link it here.

---

# 🚀 Future Improvements

- 📄 Swagger / OpenAPI Documentation
- 👥 Role-Based Authentication
- 🔄 Refresh Tokens
- 📊 Pagination & Sorting
- 🔍 Search APIs
- 🧪 Unit Testing
- ☁ Cloud Deployment
- ⚙ CI/CD Pipeline
- 📈 Monitoring using Prometheus & Grafana

---

# 👩‍💻 Developed By

## Udisha

Aspiring Java Backend Developer

### Skills

- ☕ Java
- 🌱 Spring Boot
- 🔐 Spring Security
- 🎫 JWT Authentication
- 🗄 MySQL
- ⚡ Redis
- 🐳 Docker
- 🚀 REST APIs

GitHub:

```
https://github.com/uddishasinghh31
```

---

# ⭐ Support

If you found this project useful,

⭐ Consider giving this repository a **Star**!

<div align="center">

## Made with ❤️ using Spring Boot

</div>
