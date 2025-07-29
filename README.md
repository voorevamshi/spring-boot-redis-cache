# Spring Boot Redis Cache Example

This is a demo Spring Boot project that uses **Redis** for caching REST API responses.

## 📦 Features
- Spring Boot Web
- Spring Data JPA (with H2 DB)
- Redis Caching
- CRUD for `Book` entity

## ⚙️ Requirements
- Java 17+
- Maven
- Redis Server running on `localhost:6379`

## ▶️ How to Run

1. Start Redis on your local machine.
2. Run the Spring Boot application:

```bash
./mvnw spring-boot:run
```

3. Test API using Postman or curl:

- Save book:
  ```bash
  curl -X POST http://localhost:8080/books \
  -H "Content-Type: application/json" \
  -d '{"id":"1","title":"Redis in Action","author":"Josiah"}'
  ```

- Get book:
  ```bash
  curl http://localhost:8080/books/1
  ```

## 🧠 Caching Logic

- `@Cacheable`: Caches on GET
- `@CachePut`: Updates cache on POST
- `@CacheEvict`: Clears cache on DELETE

## 📁 Structure
```
spring-boot-redis-cache/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── vmc/
│       │           └── redis/
│       │               ├── RedisCacheApplication.java
│       │               ├── config/
│       │               │   └── RedisConfig.java
│       │               ├── controller/
│       │               │   └── BookController.java
│       │               ├── model/
│       │               │   └── Book.java
│       │               ├── repository/
│       │               │   └── BookRepository.java
│       │               └── service/
│       │                   └── BookService.java
│       └── resources/
│           └── application.yml
├── pom.xml

```

## 🤝 License
Free to use and modify.
