# User-Management-SpringMongodb
This is a web application built with Spring Boot for the backend and MongoDB for the database that manages user accounts. It provides RESTful API endpoints to create, read, update, and delete user accounts.

## Features
- User account management
- RESTful API for interacting with the backend
- MongoDB for database storage
## Technologies Used
- Spring Boot
- MongoDB

## Getting Started
To run the app locally, follow these steps:  

1. Clone the repository:
```
git clone https://github.com/adirn26/User-Management-SpringMongodb.git
```
2. Install the dependencies:
```
cd user-management-api
mvn clean install
```
3. Start the Spring Boot application:
```
mvn spring-boot:run
```
Access the API endpoints using your preferred HTTP client:
```
http://localhost:8080/api/users
```
## API Endpoints
- GET /api/users: Get all user accounts
- GET /api/users/{id}: Get a specific user account by ID
- POST /api/users: Create a new user account
- PUT /api/users/{id}: Update an existing user account
- DELETE /api/users/{id}: Delete a user account by ID
