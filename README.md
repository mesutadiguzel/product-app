# Product App

This is a microservices-based application for managing products, built using Spring Boot and Spring Cloud.

## Project Structure

The project is organized into several modules:

- `api-gateway`: API Gateway service
- `discovery-server`: Eureka Discovery Server
- `product-command-service`: Handles product creation and updates
- `product-core`: Contains core domain models and exceptions
- `product-data-access`: Manages data persistence and database operations
- `product-query-service`: Handles product queries

## Technologies Used

- Java 24
- Spring Boot
- Spring Cloud (version 2024.0.1)
- Spring Data JPA
- Spring WebFlux
- Netflix Eureka for Service Discovery
- Maven for dependency management and build automation
- MySQL for database (in product-data-access module)
- Docker (compose.yaml included for containerization)

## Getting Started

1. Ensure you have Java 24 and Maven installed on your system.
2. Clone the repository: https://github.com/mesutadiguzel/product-app
