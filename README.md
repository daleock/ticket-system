# Sistema de Gestión de Incidencias TI

Proyecto backend para la gestión de incidencias y tickets de soporte TI desarrollado con Java 21, Spring Boot y MySQL siguiendo una arquitectura por capas.

Este proyecto tiene como objetivo aplicar buenas prácticas de desarrollo backend, modelado de bases de datos, diseño de APIs REST y estructura empresarial utilizada en sistemas reales de soporte técnico y mesa de ayuda.


# Tecnologías Utilizadas

## Backend

* Java 21 LTS
* Spring Boot
* Spring Data JPA
* Hibernate
* Maven

## Base de Datos

* MySQL 8.4 LTS

## Frontend

* HTML
* CSS
* JavaScript

## Herramientas

* Visual Studio Code
* MySQL Workbench
* Git
* GitHub

# Arquitectura del Proyecto

El proyecto utiliza una arquitectura por capas para mantener una correcta separación de responsabilidades y facilitar la escalabilidad y el mantenimiento.

Presentation Layer
        ↓
Controller Layer
        ↓
Service Layer
        ↓
Repository Layer
        ↓
Database Layer

# Funcionalidades Implementadas

## Actualmente desarrollado

* Diseño relacional de base de datos
* Modelado de entidades con JPA
* Repositories con Spring Data JPA
* Implementación de DTOs
* Mappers para transformación de datos
* Capa Service para lógica de negocio
* Gestión de estados de ticket mediante catálogos
* Gestión de prioridades y categorías
* Configuración de Hibernate con validación de esquema
* Estructura profesional del proyecto

# Funcionalidades en Desarrollo

* Controllers REST
* Autenticación y autorización
* Manejo global de excepciones
* Validaciones de requests
* Historial de cambios de tickets
* Integración con Postman
* Integración frontend-backend


# Estructura de Base de Datos

Tablas principales implementadas:

* rol
* usuario
* ticket
* estado_ticket
* prioridad
* categoria
* historial_ticket

# Estructura del Proyecto

ticket-system/

src/main/java/com/benjamin/ticketsystem/

controller/
service/
repository/
model/
dto/
mapper/
security/
config/
exception/
utils/

resources/
templates/
static/

database/
docs/

# Decisiones Técnicas

* Arquitectura por capas
* Uso de tablas catálogo en lugar de ENUMs
* Persistencia con JPA/Hibernate
* Uso de DTOs para comunicación API
* Mapper layer para transformación de entidades
* Almacenamiento de contraseñas mediante hash
* Configuración `ddl-auto=validate`

# Instalación y Ejecución

## Clonar repositorio

git clone https://github.com/daleock/ticket-system.git

## Ingresar al proyecto

cd ticket-system

## Crear base de datos en MySQL

CREATE DATABASE ticket_system;

## Configurar credenciales

Modificar el archivo:

src/main/resources/application.properties

## Ejecutar proyecto

./mvnw spring-boot:run

# Mejoras Futuras

* Autenticación JWT
* Control de acceso por roles
* Dashboard administrativo
* Notificaciones por correo
* Adjuntos en tickets
* Dockerización
* Testing unitario e integración
* Pipeline CI/CD

# Autor

Benjamin Madrid Jara

Estudiante de Ingeniería de Sistemas enfocado en desarrollo backend, arquitectura de software y sistemas empresariales.

GitHub:
https://github.com/daleock
