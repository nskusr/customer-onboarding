# Customer Registration Application

This repository contains the **Customer Registration** application, which includes a frontend built with Angular and a backend built with Spring Boot.

## Table of Contents

- [Setup Options](#setup-options)
  - [Option 1: Running Frontend and Backend Separately](#option-1-running-frontend-and-backend-separately)
    - [Backend Setup](#backend-setup)
    - [Frontend Setup](#frontend-setup)
  - [Option 2: Running Backend with Embedded Angular Build](#option-2-running-backend-with-embedded-angular-build)
- [Prerequisites](#prerequisites)
- [Running Tests](#running-tests)
  - [Backend Tests](#backend-tests)
  - [Frontend Tests](#frontend-tests)
- [Build Instructions](#build-instructions)
  - [Backend Build](#backend-build)
  - [Frontend Build](#frontend-build)
- [License](#license)

## Setup Options

You can run the application using one of the following options:

### Option 1: Running Frontend and Backend Separately

#### Backend Setup

- **Application Name:** `customer-registration`
- **Instructions:**
  1. Ensure you have Java 17 or higher installed.
  2. Navigate to the `customer-registration` directory.
  3. To compile the code, run tests, package the application, and install the artifact into your local Maven repository
     ```bash
     mvn clean install
     ```
  4. Run the application as a Spring Boot application using your preferred IDE or by executing:
     ```bash
     ./mvnw spring-boot:run
     ```
     
#### Frontend Setup

- **Application Name:** `customer-app`
- **Instructions:**
  1. Ensure you have Node.js and npm installed.
  2. Navigate to the `customer-app` directory.
  3. Install the necessary dependencies:

     ```bash
     npm install
     ```

  4. Launch the Angular application:

     ```bash
     ng serve
     ```

  5. Access the frontend at [http://localhost:4200](http://localhost:4200).

### Option 2: Running Backend with Embedded Angular Build

- **Application Name:** `customer-registration`
- **Instructions:**
  1. Ensure you have Java 17 or higher installed.
  2. The Angular build (`customer-app`) is already embedded in the Spring Boot application.
  3. Navigate to the `customer-registration` directory.
  4. Run the application as a Spring Boot application using your preferred IDE or by executing:

     ```bash
     ./mvnw spring-boot:run
     ```

  5. Access the application at [http://localhost:8080](http://localhost:8080).

## Prerequisites

- **Java 17+**: Required for the Spring Boot backend.
- **Node.js & npm**: Required for the Angular frontend (if using Option 1).
- **Angular CLI**: Recommended for frontend development.
- **Maven**: Required for building the backend application.
