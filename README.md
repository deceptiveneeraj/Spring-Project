# Spring Backend Project

## Project Overview

This is a basic Spring Boot application designed to manage students and subjects in an educational setting. It includes the following features:
- **Student Management**: Create, retrieve, update, and delete student records.
- **Subject Management**: Create and retrieve subject records.
- **Security**: Role-based access control with roles `STUDENT` and `ADMIN`.
- **Database**: Uses MySQL for data persistence.

## Technologies Used

- **Java**: 17
- **Spring Boot**: 3.x
- **Spring Security**: For role-based access control
- **MySQL**: Relational database
- **Maven**: Build tool

## Project Structure

- **`com.school.entities`**: Contains JPA entities for `Student` and `Subject`.
- **`com.school.Repository`**: Repositories for database access.
- **`com.school.service`**: Service layer for business logic.
- **`com.school.Controller`**: REST controllers for API endpoints.
- **`com.school.security`**: Security configuration.

## Getting Started

### Prerequisites

- JDK 17 or higher
- Maven
- MySQL database

### Installation

1. **Clone the Repository**

   ```bash
   git clone https://github.com/yourusername/student-subject-management.git
   cd student-subject-management

   

