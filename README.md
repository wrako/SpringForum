# SpringForum

SpringForum is a forum application built using a **microservices architecture** with **Spring Boot**. The project is designed to be scalable, flexible, and easy to maintain by dividing the system into independent services communicating via **REST API**.

## Microservices Overview

- **API Gateway** – The single entry point for client requests, routing them to the appropriate services while providing security and load balancing.  
- **Comment Service** – Manages user comments, including creation, editing, deletion, and display.  
- **Rating Service** – Handles the rating system, allowing users to rate topics and comments, and calculates average ratings.  
- **Score Service** – Tracks user activity, awarding points for actions such as creating topics, posting comments, and receiving ratings.  
- **Server** – Hosts the **frontend using Java (Spring MVC) + Thymeleaf + HTML/CSS**, providing the forum’s user interface and handling UI-related backend logic.  
- **User Service** – Manages users, including registration, authentication, authorization, and profile management.  

## Tech Stack

### **Back-end**
- **Java 17+** – Primary programming language  
- **Spring Boot** – Framework for microservices development  
- **Spring Security** – Authentication and authorization  
- **Spring Data JPA** – Database interaction  
- **Hibernate** – ORM for working with relational databases  
- **Lombok** – Reduces boilerplate code  

### **Front-end**
- **Spring MVC + Thymeleaf** – Server-side rendering  
- **HTML/CSS** – UI structure and styling  

### **Database**
- **PostgreSQL** – Primary relational database  

### **API & Communication**
- **REST API** – Enables communication between microservices  

### **DevOps & CI/CD**
- **Docker** – Containerization of services  

## **Project Features**
- Fully microservices-based architecture with independent services.  
- Secure authentication and authorization system.  
- Server-side rendered frontend with **Spring MVC + Thymeleaf**.  
- Scalable and modular design for easy future expansion.  

## **Setup & Deployment**
### **Prerequisites**
- Install **Java 17+**
- Install **Docker** (optional for containerized deployment)
- Install **PostgreSQL**  

### **Run the Project**
1. Clone the repository:  
   ```sh
   git clone https://github.com/wrako/SpringForum.git
   cd SpringForum
