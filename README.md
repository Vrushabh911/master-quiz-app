🧠 QuizFullStack Application
A professional-grade Full-Stack Quiz platform built with Spring Boot 3, featuring a secure authentication system and a modern UI. This project follows the Clean Architecture principle, ensuring a strict separation between web routing, business logic, and data persistence.

🏗️ Architectural Overview
The application is structured into four distinct layers to ensure maintainability and security:

Security Layer: Implements Spring Security with BCrypt password hashing. It uses a CustomUserDetailsService to authenticate users against the MySQL database.

Controller Layer: Acts as the entry point. It handles HTTP requests, manages form binding with Thymeleaf, and controls the navigation flow between the login, registration, and dashboard pages.

Service Layer: The "Brain" of the application. It handles business rules such as verifying if a username or email is already taken before allowing a new registration.

Repository Layer: Powered by Spring Data JPA. It provides an abstraction over MySQL, allowing for clean data access without writing complex SQL.

🛠️ Technical Stack
Component,Technology
Backend,"Java 17+, Spring Boot 3.x, Spring Security"
Database,MySQL (Relational Persistence)
ORM,Spring Data JPA (Hibernate)
View Engine,Thymeleaf (Server-side rendering)
Frontend,"HTML5, CSS3, JavaScript"

📂 Core Package Structure
com.vrushabh.QuizFullStack
├── Controller   # AuthController: Handles Login/Register endpoints
├── Service      # UserService: Business logic & transaction management
├── Repository   # UserRepository: Data access for MySQL
├── Security     # SecurityConfig & CustomUserDetailsService
├── Entity       # User & Role: Database models and Enums
└── Resources    # application.properties & Thymeleaf templates

🔒 Security Implementation
Authentication: JPA-based authentication linked to the User entity.

Authorization: Role-based access (e.g., ROLE_USER) ensuring protected pages like /dashboard are only accessible to logged-in users.

Data Protection: Password encoding using BCryptPasswordEncoder.
