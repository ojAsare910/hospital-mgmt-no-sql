# Hospital Management System (NoSQL)

This project is a hospital management system using MongoDB and Redis as the primary data stores. The application manages doctors, nurses, patients, and departments in a hospital.

## Features

- **Doctors Management**: Add, update, retrieve, and manage doctor information.
- **Nurses Management**: Add, update, retrieve, and manage nurse information.
- **Patients Management**: Add, update, and retrieve patient information.
- **Department Management**: Create departments and associate doctors with them.
- **Caching**: Caffeine-based caching is implemented for doctor retrieval operations by speciality.
- **Redis**: Patient data is stored in Redis, which allows fast access and supports caching.

## Technologies Used

- **Spring Boot 3.3.2**: Used for application setup and dependency management.
- **MongoDB**: The primary database for storing doctor, nurse, and department data.
- **Redis**: Used to store and cache patient data.
- **Caffeine**: For in-memory caching.
- **Spring Data MongoDB**: For MongoDB integration.
- **Spring Data Redis**: For Redis integration.
- **Jedis**: Redis client for handling Redis operations.
- **Spring Web**: For building RESTful web services.
- **Lombok**: For reducing boilerplate code.

## Prerequisites

Before you begin, ensure you have the following installed:

- Java JDK 21 or later
- Maven
- MongoDB
- Redis

## Getting Started

### Clone the repository

```bash
git clone https://github.com/ojAsare910/hospital-management-system-nosql.git
cd hospital-management-system-nosql
