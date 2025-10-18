Proyecto Authentication JWT

Proyecto personal para practicar autenticación y autorización con **Spring Boot** usando **JWT (JSON Web Tokens)**.

La idea fue crear una base sencilla pero completa para manejar registro, login y validación de tokens en un backend hecho en Java.

Estructura del proyecto

├── auth
│ ├── AuthController.java
│ ├── AuthService.java
│ └── dto
│ ├── RegisterRequest.java
│ ├── LoginRequest.java
│ └── AuthResponse.java
│
├── config
│ ├── JwtService.java
│ ├── JwtAuthenticationFilter.java
│ ├── SecurityConfig.java
│ └── ApplicationConfig.java
│
├── controller
│ └── DemoController.java
│
├── entities
│ └── User.java
│
├── repository
│ └── UserRepository.java
│
└── AuthenticationJwtApplication.java
