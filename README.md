![Ekwateur](https://lenergeek.com/wp-content/uploads/2017/01/ekwateur.png)

Build Restful CRUD API for a simple Ekwateur application using Spring Boot, Mysql, JPA and Hibernate.

## Requirements

1. Java - 17.x

2. Maven - 3.x.x

3. Mysql - 5.x.x

4. Spring Boot - 3.x.x

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/philemongloblehi/ekwateur-backend.git
```

**2. Create Mysql database**
```bash
create database ekwateur_DB
```

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**4. Build and run the app using maven**

```bash
mvn package
java -jar target/backend-0.0.1-SNAPSHOT.jar
```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8080>.

## Explore Rest APIs

The app defines following CRUD for Particular model.

    GET /api/particulars
    
    POST /api/particulars
    
    GET /api/particulars/{id}
    
    PUT /api/particulars/{id}
    
    DELETE /api/particulars/{id}

The app defines following CRUD for Professional model.

    GET /api/particulars

    POST /api/particulars
    
    GET /api/particulars/{id}
    
    PUT /api/particulars/{id}
    
    DELETE /api/particulars/{id}

The app defines following generate invoice for Particular and Professional model.
    
    POST /api/particulars/{id}/invoices
    POST /api/professionals/{id}/invoices

You can test them using postman or any other rest client.
