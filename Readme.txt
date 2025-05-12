### Assesment
## Problem 1: Custom Number Series Generator
- This Java console application generates a custom number series and prints the nth member of the series.

## Problem 2: Character Replacement in File
= This program reads a file and replaces all occurrences of the character 'a' (case-insensitive)

## HTML Pages (User Interface)
/problem.html

## API
1. /problem - GET
2. /problem1 - POST
3. /problem2 - POST


# Online Shopping Web Application (Spring Boot)

This is a simple baseline web application developed for Alice's online business. It includes basic features like login, add/update/delete products, and exposes REST APIs for mobile integration.

---

## 🔧 Technologies Used

- **Spring Boot**
- **Hibernate / JPA**
- **H2 In-Memory Database** (for development/testing)
- **Spring MVC (Controller + View-based routing)**
- **Plain HTML (converted from JSF)**
- **Spring Security (Optional)**
- **Jackson (for JSON response)**
- **AES-256 Encryption (for product prices)**
- **SHA-256 Hashing (for user passwords)**

---

## 🌐 Features

### 👤 Login
- Plain HTML login page
- SHA-256 password hashing
- Admin account seeded manually or via SQL

### 📦 Product Management
- Add product (name, encrypted price)
- Update product
- Delete product
- View product list

### 🔐 Security
- Passwords stored as SHA-256 hashes
- Prices encrypted using AES-256
- REST API access can be restricted by token-based auth or IP allowlisting

---------

## HTML Pages (User Interface)
/login.html
/success.html
/failed.html
/product.html
/list.html

## API
1. /interview/login - GET
2. /interview/login - POST
3. /interview/product - GET
4. /interview/addProduct - POST
5. /interview/listProduct - POST
6. /interview/updateProduct - POST
7. /interview/deleteProduct - POST

---------

### Reference
## Added Requirement for the online shopping
- API_KEY_HEADER = "X-API-KEY";
- VALID_API_KEY = "mobile-app-secret-key";
- Validation on the path /interview/
- Login ADMIN_USERNAME = "admin";
= Login ADMIN_PASSWORD_HASH = "741f67765bef6f01f37bf5cb1724509a83409324efa6ad2586d27f4e3edea296"; //"hashedpassword"

--------

*** Login and Logout are not fully implemented
