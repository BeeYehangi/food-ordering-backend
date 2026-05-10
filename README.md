# 🍔 Online Food Ordering System — Backend

A secure and scalable REST API backend built with **Spring Boot** for an Online Food Ordering System. This project was developed as part of the CMJD (Comprehensive Master Java Developer) course — Batch 112/113, Assignment 1.

---

## 📌 Project Overview

This backend application provides a fully functional REST API that handles user authentication, food and category management, cart operations, order processing, and payments. It is designed to integrate seamlessly with the React TypeScript frontend.

---

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| Spring Boot | Core application framework |
| Spring Data JPA | ORM & database persistence |
| Spring Security | Authentication & authorization |
| MySQL | Relational database |
| JWT (JSON Web Token) | Stateless authentication |
| Maven | Dependency management |

---

## ✨ Features

### 🔐 Authentication & Authorization
- User registration (Sign-Up) and login (Sign-In)
- JWT-based stateless authentication
- Role-based access control — `ADMIN` and `CUSTOMER`
- Secured endpoints via Spring Security

### 👤 User Management
- Manage user profiles
- Role assignment and access control

### 🍕 Food & Categories
- Full CRUD for food items
- Food status: `AVAILABLE`, `OUT_OF_STOCK`
- Category management with One-to-Many relationship to food items

### 🛒 Cart
- One-to-One relationship between Cart and User
- Add, update, and remove cart items
- Many-to-One relationship between Cart Item and Food Item

### 📦 Orders
- Place and manage orders
- Order status flow: `PLACED` → `PREPARING` → `DELIVERED` / `CANCELLED`
- Order items linked to food items (Many-to-One)

### 💳 Payment
- Payment processing per order
- Payment status: `PENDING`, `COMPLETED`, `FAILED`

### 🧱 Architecture
- Layered architecture: Controller → Service → Repository
- Global exception handling
- Logging for system activity monitoring

---

## 🗄️ Database Schema

```
User ──────────────── Cart (One-to-One)
                         │
                     Cart Item (Many-to-One)
                         │
Category ──── Food Item ─┘
                │
            Order Item (Many-to-One)
                │
Order ──────────┘
  │
Payment (One-to-One)
```

### Entity Summary

| Entity | Key Fields | Status / Roles |
|---|---|---|
| User | id, name, email, password, role | ADMIN, CUSTOMER |
| Food Item | id, name, price, categoryId | AVAILABLE, OUT_OF_STOCK |
| Category | id, name | — |
| Cart | id, userId | — |
| Cart Item | id, cartId, foodItemId, quantity | — |
| Order | id, userId, totalAmount | PLACED, PREPARING, DELIVERED, CANCELLED |
| Order Item | id, orderId, foodItemId, quantity | — |
| Payment | id, orderId, amount | PENDING, COMPLETED, FAILED |

---

## 📁 Project Structure

```
src/main/java/com/yourpackage/
├── controller/
│   ├── AuthController.java
│   ├── UserController.java
│   ├── FoodController.java
│   ├── CategoryController.java
│   ├── CartController.java
│   ├── OrderController.java
│   └── PaymentController.java
├── service/
│   ├── AuthService.java
│   ├── UserService.java
│   ├── FoodService.java
│   ├── CategoryService.java
│   ├── CartService.java
│   ├── OrderService.java
│   └── PaymentService.java
├── repository/
│   ├── UserRepository.java
│   ├── FoodRepository.java
│   ├── CategoryRepository.java
│   ├── CartRepository.java
│   ├── OrderRepository.java
│   └── PaymentRepository.java
├── entity/
│   ├── User.java
│   ├── FoodItem.java
│   ├── Category.java
│   ├── Cart.java
│   ├── CartItem.java
│   ├── Order.java
│   ├── OrderItem.java
│   └── Payment.java
├── dto/
│   ├── request/
│   └── response/
├── security/
│   ├── JwtUtil.java
│   ├── JwtFilter.java
│   └── SecurityConfig.java
├── exception/
│   ├── GlobalExceptionHandler.java
│   └── ResourceNotFoundException.java
└── enums/
    ├── Role.java
    ├── FoodStatus.java
    ├── OrderStatus.java
    └── PaymentStatus.java
```

---

## 🔗 API Endpoints

### Auth
| Method | Endpoint | Access |
|---|---|---|
| POST | `/api/auth/register` | Public |
| POST | `/api/auth/login` | Public |

### Users
| Method | Endpoint | Access |
|---|---|---|
| GET | `/api/users` | ADMIN |
| GET | `/api/users/{id}` | ADMIN, CUSTOMER |
| PUT | `/api/users/{id}` | ADMIN, CUSTOMER |
| DELETE | `/api/users/{id}` | ADMIN |

### Food Items
| Method | Endpoint | Access |
|---|---|---|
| GET | `/api/foods` | Public |
| GET | `/api/foods/{id}` | Public |
| POST | `/api/foods` | ADMIN |
| PUT | `/api/foods/{id}` | ADMIN |
| DELETE | `/api/foods/{id}` | ADMIN |

### Categories
| Method | Endpoint | Access |
|---|---|---|
| GET | `/api/categories` | Public |
| POST | `/api/categories` | ADMIN |
| PUT | `/api/categories/{id}` | ADMIN |
| DELETE | `/api/categories/{id}` | ADMIN |

### Cart
| Method | Endpoint | Access |
|---|---|---|
| GET | `/api/cart` | CUSTOMER |
| POST | `/api/cart/add` | CUSTOMER |
| PUT | `/api/cart/update/{itemId}` | CUSTOMER |
| DELETE | `/api/cart/remove/{itemId}` | CUSTOMER |

### Orders
| Method | Endpoint | Access |
|---|---|---|
| GET | `/api/orders` | ADMIN |
| GET | `/api/orders/{id}` | ADMIN, CUSTOMER |
| POST | `/api/orders` | CUSTOMER |
| PUT | `/api/orders/{id}/status` | ADMIN |

### Payments
| Method | Endpoint | Access |
|---|---|---|
| POST | `/api/payments` | CUSTOMER |
| GET | `/api/payments/{orderId}` | ADMIN, CUSTOMER |

---

## 🚀 Getting Started

### Prerequisites

- Java 17+
- Maven 3.8+
- MySQL 8+

### Database Setup

```sql
CREATE DATABASE food_ordering_db;
```
### Default Admin Credentials

| Field | Value |
|---|---|
| Email | test@gmail.com |
| Password | password123 |
```

### Configuration

Update `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/food_ordering_db
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

app.jwt.secret=your_jwt_secret_key
app.jwt.expiration=86400000
```

### Running the App

```bash
# Clone the repository
git clone https://github.com/BeeYehangi/food-ordering-backend.git

# Navigate into the project
cd food-ordering-backend

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`

---

## 👨‍💻 Author

**[Bimaya Yehangi Eriyawala]**
CMJD Batch 112/113
IJSE — Institute of Java & Software Engineering
