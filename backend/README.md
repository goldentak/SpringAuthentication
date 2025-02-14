# Spring Boot Authentication API

## Description

Simple API for user registration and login. Built with Spring Boot and PostgreSQL. A good starting point for serious projects. Ignore the front part, it’s just for existence

## Tech Stack

- Java 17
- Spring Boot 3
- Spring Data JPA (Hibernate)
- PostgreSQL
- Maven

## Running the Project

### Install Dependencies

Make sure you have **JDK 17+** and **Maven** installed.

```sh
mvn clean install
```

### Database Setup

This project uses PostgreSQL. Configure it in `src/main/resources/application.properties`:


Replace `mydatabase`, `myuser`, and `mypassword` with your own values.

### Run the App

After setting up dependencies and database:

```sh
mvn spring-boot:run
```

## Project Structure

```plaintext
.
├── README.md
├── pom.xml
├── src
│   ├── main
│   │   ├── java/com/example/app
│   │   │   ├── App.java
│   │   │   ├── controllers/AuthController.java
│   │   │   ├── dto/
│   │   │   ├── models/User.java
│   │   │   ├── repositories/UserRepository.java
│   │   │   └── services/
│   │   └── resources/application.properties
└── target
```

### Main Components
- **`AuthController.java`** – Handles authentication requests.
- **`User.java`** – User model.
- **`UserRepository.java`** – Database interaction.
- **`LoginRequest.java`** / **`RegisterRequest.java`** – DTO classes.
- **`application.properties`** – App configuration.

## API Endpoints

### Register
<span style="color: #ff79c6;">**POST** `/api/auth/register`</span>
```json
{
  "username": "user123",
  "password": "securePassword"
}
```

### Login
<span style="color: #ffb86c;">**POST** `/api/auth/login`</span>
```json
{
  "username": "user123",
  "password": "securePassword"
}
```