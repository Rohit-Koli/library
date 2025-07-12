# 📚 Library Management System – Backend

This is a simple Spring Boot RESTful backend service for managing books in a library system. It allows users to perform CRUD operations on books and update their availability status.

---

## 🚀 Features

- ✅ Add a new book
- 🔄 Update book details (title, author, ISBN, availability)
- 📖 Get a book by ID
- 📚 Retrieve all books
- ❌ Delete a book by ID
- ⚡ Change book availability only

---

## 📁 Project Structure


---

## 🔧 Technologies Used

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- H2 / MySQL Database (configurable)
- Maven

---

## 🔗 API Endpoints

| Method | Endpoint                        | Description                         |
|--------|----------------------------------|-------------------------------------|
| POST   | `/books/save`                   | Save a new book                     |
| PUT    | `/books/updateBook`             | Update book details                 |
| GET    | `/books/getBook/{id}`           | Get a book by ID                    |
| GET    | `/books/getAllBooks`            | Retrieve all books                  |
| DELETE | `/books/deleteBook/{id}`        | Delete a book by ID                 |
| PATCH  | `/books/changeAvailability/{id}`| Change only availability status     |

---

## 📦 Sample JSON Payload

### ➕ Add or Update a Book

{
  "id": 1,
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "isbn": "978-0132350884",
  "isAvailable": true
}

### 🛠️ Setup Instructions
git clone https://github.com/Rohit-Koli/library.git

cd library 

Run the application
mvn spring-boot:run

Access API via Postman or browser

http://localhost:8081/books/getAllBooks

### ✍️ Author
##  ROHIT KOLI
