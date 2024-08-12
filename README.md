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
- Postman

### Installation

1. **Clone the Repository**

   ```bash
   git clone https://github.com/yourusername/student-subject-management.git

cd student-subject-management

2. Configure Database

   Create a MySQL database and update the application.properties file with your database credentials.

   spring.datasource.url=jdbc:mysql://localhost:3306/yourdatabase
   spring.datasource.username=yourusername
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update




Go to the Postman
# Student Management with Subject

## Testing Admin Endpoints with Postman

Below are the instructions to test the Admin-related endpoints in the Student-Subject Management System using Postman.

### 1. Create Students

- **URL**: `http://localhost:8080/students/post`
- **Method**: `POST`
- **Request Body**:
  - Go to the **Body** section in Postman.
  - Select **raw** and choose **JSON** from the dropdown.
  - Enter the following JSON payload:
    ```json
    {
     "name": "",
     "address": "",
     "subjects": [
       {
         "name": "Subject Name"
       },
       {
         "name": "Subject Name"
       }
     ]
   }
   ```
- **Response**: `200 OK` with the created admin in JSON format.

### 2. Get All Students

- **URL**: `http://localhost:8080/students/all`
- **Method**: `GET`
- **Response**: `200 OK` with a list of all admins in JSON format.

### 3. Get Single Student by ID

- **URL**: `http://localhost:8080/students/get/{id}`
- **Method**: `GET`
- **URL Parameter**: Replace `{id}` with the actual ID of the admin you want to retrieve.
- **Response**: `200 OK` with the admin data for the specified ID in JSON format.

### 4. Update Students

- **URL**: `http://localhost:8080/students/update`
- **Method**: `PUT`
- **Request Body**:
  - Go to the **Body** section in Postman.
  - Select **raw** and choose **JSON** from the dropdown.
  - Enter the following JSON payload:
    ```json
    {
     "id": 1,
     "name": "",
     "address": "",
     "subjects": [
       {
         "id": 1,
         "name": "Sub. Name"
       },
       {
         "id": 2,
         "name": "Subject Name"
       }
     ]
   }
    ```
- **Response**: `200 OK` with the updated admin in JSON format.

### 5. Delete Students

- **URL**: `http://localhost:8080/students/delete/{id}`
- **Method**: `DELETE`
- **URL Parameter**: Replace `{id}` with the actual ID of the admin you want to delete.
- **Response**: `204 No Content` if successful.
  
  ------------------------------------------------------------------------------------
  ------------------------------------------------------------------------------------


# Admin Management in Student-Subject System (You Need Username : Neera or Password : Neera)

## Testing Admin Endpoints with Postman

Below are the instructions to test the Admin-related endpoints in the Student-Subject Management System using Postman.

### 1. Create Admin

- **URL**: `http://localhost:8080/admin/post`
- **Method**: `POST`
- **Request Body**:
  - Go to the **Body** section in Postman.
  - Select **raw** and choose **JSON** from the dropdown.
  - Enter the following JSON payload:
    ```json
    {
      "id": 1,
      "name": "Admin Name",
      "city": "Admin City",
      "role": "Admin"
    }
    ```
- **Response**: `200 OK` with the created admin in JSON format.

### 2. Get All Admins

- **URL**: `http://localhost:8080/admin/all`
- **Method**: `GET`
- **Response**: `200 OK` with a list of all admins in JSON format.

### 3. Get Single Admin by ID

- **URL**: `http://localhost:8080/admin/get/{id}`
- **Method**: `GET`
- **URL Parameter**: Replace `{id}` with the actual ID of the admin you want to retrieve.
- **Response**: `200 OK` with the admin data for the specified ID in JSON format.

### 4. Update Admin

- **URL**: `http://localhost:8080/admin/update`
- **Method**: `PUT`
- **Request Body**:
  - Go to the **Body** section in Postman.
  - Select **raw** and choose **JSON** from the dropdown.
  - Enter the following JSON payload:
    ```json
    {
      "id": 1,
      "name": "Updated Admin Name",
      "city": "Updated Admin City",
      "role": "Admin"
    }
    ```
- **Response**: `200 OK` with the updated admin in JSON format.

### 5. Delete Admin

- **URL**: `http://localhost:8080/admin/delete/{id}`
- **Method**: `DELETE`
- **URL Parameter**: Replace `{id}` with the actual ID of the admin you want to delete.
- **Response**: `204 No Content` if successful.

---

Make sure your Spring Boot application is running and accessible at `http://localhost:8080` before testing these endpoints.

Happy testing!
