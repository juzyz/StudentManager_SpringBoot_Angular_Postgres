# Student Management System

A full-stack web application that showcases CRUD (Create, Read, Update, Delete) operations for managing student records. The project consists of two main modules:

- **Frontend Module:** Developed using **Angular 17**, it includes features like authorization, guards, and local storage for a seamless user experience.

- **Backend Module:** Built on Java 17 with **Spring Boot** (v.3.1.7) including  **Spring MVC, Spring Data JPA,** and **Spring Security** to handle the business logic.

**PostgreSQL** is used as the database. 



## Table of Contents

- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running the Project](#running-the-project)
- [Front-End](#front-end)
- [Back-End](#back-end)
- [Contributing](#contributing)
- [License](#license)


### Prerequisites

Before you begin, make sure you have the following installed on your machine:

- [Java](https://www.oracle.com/java/technologies/javase-downloads.html) : 17.0.8
- [Node.js](https://nodejs.org/): 18.16.1
- [Angular CLI](https://cli.angular.io/) : 17.0.9
- [PostgreSQL](https://www.postgresql.org/): 16.1
- [Apache Maven](https://maven.apache.org/): 3.8.1

## Installation

Follow these steps to set up the project:

**1. Clone the repository:**

```
 git clone https://github.com/juzyz/StudentManager_SpringBoot_Angular_Postgres.git
 cd StudentManager_SpringBoot_Angular_Postgres
```

**2. Set up the PostgreSQL database:**

Create a new database named students. 
Update the database connection settings in the application.properties file in the backend directory (\backend\src\main\resources\application.properties).

   ```
  spring.datasource.driver-class-name=org.postgresql.Driver
  spring.datasource.url=jdbc:postgresql://localhost:5432/students
  spring.datasource.username=yourUserName
  spring.datasource.password=yourPassword
  ```

**3. Install front-end dependencies:**

```
  cd frontend
  npm install
```

**4. Install back-end dependencies:**

```
  cd backend
  mvn clean install
```

## Running the Project

**1 Run the back end:**

```
cd backend
mvn spring-boot:run
```

The back end will be accessible at http://localhost:8080. 

**2 Run the front end:**

```
cd frontend
ng serve
```

The front end will be accessible at http://localhost:4200.


## Front-End

The front end of the application is developed using Angular 17. It includes user authorization, guards, and local storage for a seamless user experience. There are several implemented forms:

![GUI](https://github.com/juzyz/StudentManager_SpringBoot_Angular_Postgres/assets/96008515/6e01ee71-ed7f-4f5f-bb47-b3162750c09b)

To access the admin features of the application, you can use the following default credentials:

- **Username:** admin@gmail.com
- **Password:** 123
  
To explore the frontend code, navigate to the frontend directory.

## Back-End
The back end is built on Java 17 with Spring Boot. It utilizes Spring MVC, Spring Data JPA, and Spring Security to handle the business logic and interact with the PostgreSQL database.

The following endpoints have been implemented: 

#### 1. Authentication Controller

| Endpoints   |   Method    | Description | Parameters | Request Body |
| ----------- | ----------- |----------- |----------- |----------- |
| api/v1/auth/authenticate  | POST     |Authenticates a user based on provided credentials.| None| `email` (String): The email of the user.<br> `password` (String): The password of the user.


#### 2. Student Controller

| Endpoints   |   Method    | Description | Parameters | Request Body |
| ----------- | ----------- |----------- |----------- |----------- |
| api/v1/student  | GET     |Retrieves a list of all students.| None| None
| api/v1/student  | POST    |Creates a new student with the provided details.| None| `name` (String): The student's name  <br>`email` (String): The student's email address<br> `dateOfBirth` (String): The student's date of birth
| api/v1/student/{studentId}  | PUT     | Updates the student information based on the provided student's data.|  `studentId` (Integer): The unique identifier of the student.|`name` (String): The student's name  <br>`email` (String): The student's email address.
| api/v1/student/{studentId}  | DELETE     | Deletes the student information based on the provided `studentId`.|  `studentId` (Integer): The unique identifier of the student. | None


To explore the back-end code, navigate to the backend directory.

## Contributing
Feel free to contribute to this project by opening issues or submitting pull requests. 

## License
This project is licensed under the MIT License.
