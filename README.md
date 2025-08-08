# 🛒 E-Commerce Web Application

A Java-based E-Commerce Web Application built using Spring Boot, Thymeleaf, and PostgreSQL. This project focuses on core backend development including user management, product browsing, order placement, and secure admin APIs.

## 🚀 Features

### 👤 User Side
- User Registration & Login (secured with Spring Security)
- Browse products with a clean UI
- Search products by name
- Place orders directly (no cart functionality)
- View confirmation after placing an order

### 🔐 Admin Side (via REST API)
- Add, update, and delete products
- Role-based access control for admin endpoints
- APIs tested using Postman

## 🧱 Architecture

- **Layered Design**: Controller → Service → Repository
- **Security**: Custom `DaoAuthenticationProvider` with `UserDetailsService`
- **ORM**: Hibernate (JPA)
- **Database**: PostgreSQL
- **Frontend**: HTML + CSS using Thymeleaf (No JavaScript or UI frameworks)

## 🛠 Tech Stack

| Category        | Technologies                                   |
|-----------------|------------------------------------------------|
| Language        | Java                                           |
| Backend         | Spring Boot, Spring MVC, Spring Security       |
| ORM             | Hibernate (JPA)                                |
| View Layer      | Thymeleaf + HTML/CSS                           |
| Database        | PostgreSQL                                     |
| Build Tool      | Maven                                          |
| Tools           | Postman, Git, Eclipse                          |




   git clone https://github.com/your-username/ecommerce-app.git
   cd ecommerce-app
