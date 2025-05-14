# AI in Development: Home Work

This repository contains three independent tasks, each located in its own folder:

- `task-1`: Web Application - Expense Calculator (HTML/JS and Spring Boot versions)
- `task-2`: API Testing - Identifying Defects in Product Data
- `task-3`: SQL Queries - Analyzing a Database Online

---

## Task 1: Web Application - Expense Calculator

This project is a simple web application for managing expenses. It includes two parts:

1. **task-1**: A basic HTML/JavaScript application.
2. **task-1-Java_Spring**: A Spring Boot application with a RESTful API.

### HTML/JS Version

**Goal:**
Develop a web application to calculate monthly expense metrics.

**Features:**
- Add/delete expenses via UI
- Calculate:
   - Total expenses
   - Average daily expense
   - Top 3 largest expenses

**Input Format:**

| Category      | Amount ($) |
|---------------|------------|
| Groceries     | 15,000     |
| Rent          | 40,000     |
| Transportation| 5,000      |
| Entertainment | 10,000     |
| Communication | 2,000      |
| Gym           | 3,000      |

**Expected Output:**
- Total: 75,000 $
- Average daily: 2,500 $
- Top 3: Rent (40,000), Groceries (15,000), Entertainment (10,000)

**Tools:**
- CursorAI for HTML/JS code
- Browser for testing

**How to Run**

1. Open `index.html` in a web browser.
2. Use the interface to manage expenses.

### Spring Boot API Version

**Features:**
- REST API for expense management
- Same calculation capabilities as web version

**Endpoints:**
- `POST /api/expenses/add`: Add a new expense.
- `GET /api/expenses/list`: List all expenses.
- `PUT /api/expenses/update/{id}`: Update an expense.
- `DELETE /api/expenses/delete/{id}`: Delete an expense.
- `GET /api/expenses/calculate`: Calculate total and average expenses.

**Tools:**
- Java 17+
- Spring Boot 3.x
- Maven

**How to Run:**
1. Navigate to the `task-1-Java_Spring/AIhomework-api` directory
2. Run the application using Maven:
   ```bash
   mvn spring-boot:run
   ```
3. Access the API at `http://localhost:8080`.
---

## Task 2: API Testing - Identifying Defects in Product Data

**Goal:**
Validate product data from FakeStore API.

**API:**
`https://fakestoreapi.com/products`

**Test Objectives:**
- Verify response code = 200
- Validate:
   - `title` not empty
   - `price` ≥ 0
   - `rating.rate` ≤ 5
- Generate defect report

**Tools:**
- Postman/ReqBin
- CursorAI for test scenarios

**How to Run:**

- Using Postman:
1. Import the test collection (provided in task-2/postman_collection.json)
2. Set environment variables:
    - base_url: https://fakestoreapi.com
3. Run all tests

- Using cURL:
```bash
curl -X GET "https://fakestoreapi.com/products" \
-H "Content-Type: application/json" \
-w "\nStatus Code: %{http_code}\n"
```

---

## Task 3: SQL Queries - Analyzing a Database Online

**Goal:**
Analyze sales data with SQL.

**Setup:**
```sql
CREATE TABLE orders (
     id INTEGER PRIMARY KEY,
     customer TEXT,
     amount REAL,
     order_date DATE
);

INSERT INTO orders (customer, amount, order_date) VALUES
     ('Alice', 5000, '2024-03-01'),
     ('Bob', 8000, '2024-03-05'),
     ('Alice', 3000, '2024-03-15'),
     ('Charlie', 7000, '2024-02-20'),
     ('Alice', 10000, '2024-02-28'),
     ('Bob', 4000, '2024-02-10'),
     ('Charlie', 9000, '2024-03-22'),
     ('Alice', 2000, '2024-03-30');
```
**Tasks:**

- Total March 2024 sales (Expected: 27,000)
- Top-spending customer (Expected: Alice 20,000)
- Average order value (Expected: 6,000)

**Tools:**

- SQLite Online
- CursorAI for query refinement

