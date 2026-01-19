1er proyecto educativo
# 🏢 Sistema de Gestión de Agencia – Spring Boot CRUD

Aplicación web desarrollada con **Spring Boot** que implementa un CRUD completo para la gestión de una agencia, permitiendo administrar entidades como **Choferes, Clientes, Localidades y Viajes**. El proyecto está orientado a consolidar conceptos de desarrollo backend, arquitectura MVC y persistencia de datos con JPA.

---

## 🚀 Funcionalidades

- Alta, listado, edición y eliminación de choferes
- Gestión de datos mediante formularios HTML
- Persistencia en base de datos relacional MySQL
- Renderizado de vistas con Thymeleaf
- Separación de responsabilidades por capas (Controller, Service, Repository, Model)

---

## 🧱 Arquitectura

El proyecto sigue una arquitectura **MVC clásica**:

- **Controller**: manejo de rutas HTTP y lógica de presentación
- **Service**: capa de negocio y reglas de la aplicación
- **Repository**: acceso a datos mediante Spring Data JPA
- **Model**: entidades persistentes (JPA)
- **View**: templates HTML con Thymeleaf

Estructura simplificada del proyecto:

src/
└── main/
├── java/com/agencia/agencia/
│ ├── controller/
│ ├── models/
│ ├── repository/
│ ├── service/
│ └── AgenciaApplication.java
└── resources/
├── templates/
└── application.properties


---

## 🛠️ Tecnologías utilizadas

- Java 21
- Spring Boot 3.3.5
- Spring MVC
- Spring Data JPA
- Thymeleaf
- MySQL
- Hibernate
- Maven
- Tomcat
- Git

---

## 📌 Ejemplo de flujo CRUD (Chofer)

- `GET /choferes` → listado de choferes
- `GET /choferes/nuevo` → formulario de alta
- `POST /choferes` → creación de chofer
- `GET /choferes/editar/{id}` → edición de chofer
- `POST /choferes/{id}` → actualización de datos
- `GET /choferes/eliminar/{id}` → eliminación de registro

---

## ⚙️ Configuración del entorno

### 1️⃣ Clonar el repositorio
```bash
git clone https://github.com/Cordob4a/nombre-del-repo.git
cd nombre-del-repo
2️⃣ Configurar la base de datos
Crear una base de datos MySQL:

CREATE DATABASE agencia;
Configurar las credenciales en application.properties:

properties

spring.datasource.url=jdbc:mysql://localhost:3306/agencia
spring.datasource.username=root
spring.datasource.password=****
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

3️⃣ Ejecutar la aplicación
mvn spring-boot:run
La aplicación estará disponible en:

http://localhost:8080/choferes
🎯 Objetivo del proyecto

Proyecto desarrollado con fines educativos, enfocado en:
Comprender el flujo completo de un CRUD backend
Aplicar arquitectura MVC con Spring Boot
Utilizar JPA/Hibernate para persistencia
Integrar backend y frontend con Thymeleaf
Consolidar fundamentos de desarrollo backend en Java

🔍 Posibles mejoras futuras
Uso de métodos HTTP REST correctos (POST / PUT / DELETE)

Validaciones con Bean Validation

Manejo de excepciones global

Autenticación y autorización

Migración a API REST con Spring Boot

Integración con frontend desacoplado

👤 Autor
Julian A. Córdoba
Analista en Sistemas
