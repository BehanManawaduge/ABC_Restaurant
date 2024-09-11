
# ABC Restaurant System - JavaFX Project

## Overview

This is a JavaFX-based application for managing a restaurant's operations. It includes functionalities for different types of users: Admin, Staff, and Customers.

## Prerequisites

- JDK 11 or higher
- JavaFX libraries
- MySQL or PostgreSQL for the database
- An IDE such as IntelliJ IDEA, Eclipse, or NetBeans

## Database Setup

1. Install MySQL or PostgreSQL.
2. Create a database named `abc_restaurant`.
3. Execute the SQL script provided in the `database` folder to create necessary tables.

## How to Run

1. Open the project in your IDE.
2. Make sure the JavaFX libraries are properly configured.
3. Run the `App.java` file to start the application.

## Project Structure

- `controller`: Java classes that handle user interactions.
- `model`: Java classes representing the data model.
- `repository`: Data access layer (DAOs) for interacting with the database.
- `service`: Business logic layer.
- `util`: Utility classes like database connection management.
- `resources`: FXML files for UI layouts.

## Features

- User Authentication and Authorization
- Online Reservation System
- Search and Filter Services and Offers
- Submit Queries and Manage Customer Interactions
- Payment Processing
- Reports for Admin
- User Management by Admin
