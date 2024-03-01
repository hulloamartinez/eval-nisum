#   EVALUACION JAVA NISUM
## Table of Contents
<p>
<details>
<summary>Click to unfold.</summary>

[[_TOC_]]

</details>
</p>

## Functional Description
### Context
Test de evaluacion de conocimientos JAVA para NISUM

### Business Process 
 - Desarrollar una aplicación que exponga una API RESTful de creación de usuarios  
 - Todos los endpoints deben aceptar y retornar solamente JSON, inclusive al para los mensajes de
error.


## Technical Description
Servicio construido con Java SE 8. Uso de Autenticación por usuario y contraseña, autenticacion de endpoint por JWT.

## Detalles del servicio
- Base de datos en memoria H2
- USO de JPA (JPA Repository)
- Se utiliza una tabla de credenciales, distinta a la de usuarios, esto para mejorar la seguridad.
- No se utiliza Autowired para las inyecciones de dependencias
- Bcrypt para la encriptacion de la contraseña
- JWT para el token de autorizacion

## Observaciones

- Se adjunta schema.sql y data.sql para la creacion de las tablas y llenado de campos


#### Patterns
- Patron REST API

#### Development Stack 
Para el desarrollo del servicio se utilizan los siguientes lenguajes y frameworks: 
- Lenguaje: Java (v8)
- Framework: Spring boot (v2.7.18)
- Gestion de proyecto: Maven 
- Analisis de codigo: Jacoco
- Pruebas Unitarias: JUnit 5 + Mockito

## Métodos
- Método Login (POST)
- Método User (POST)

## Contact Info
- Product Owner Canal:
- Delivery Integration Team:
- Lider Tecnico:
- Arquitecto:
- Seguridad:
- Desarrolladores: Hector Ulloa Martínez


