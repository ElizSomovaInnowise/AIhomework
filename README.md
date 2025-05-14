# Expense Calculator

This project is a simple web application for managing expenses. It includes two parts:

1. **task-1**: A basic HTML/JavaScript application.
2. **task-1-Java_Spring**: A Spring Boot application with a RESTful API.

## task-1

### Features
- Add, update, and delete expenses.
- Calculate total and average expenses.
- List top 3 expenses.

### How to Run
1. Open `index.html` in a web browser.
2. Use the interface to manage expenses.

## task-1-Java_Spring

### Features
- RESTful API for managing expenses.
- Endpoints for adding, listing, updating, and deleting expenses.

### How to Run
1. Navigate to the `AIhomework-api` directory.
2. Run the application using Maven:
   ```bash
   mvn spring-boot:run
   ```
3. Access the API at `http://localhost:8080`.

### API Endpoints
- `POST /api/expenses/add`: Add a new expense.
- `GET /api/expenses/list`: List all expenses.
- `PUT /api/expenses/update/{id}`: Update an expense by ID.
- `DELETE /api/expenses/delete/{id}`: Delete an expense by ID.
- `GET /api/expenses/calculate`: Calculate total and average expenses. 
