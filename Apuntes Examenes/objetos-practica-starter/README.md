# Proyecto Objetos-Práctica-Starter - Gestión de Alumnos con Spring Boot y H2

Este proyecto es un starter de Spring Boot que implementa un sistema básico de gestión de alumnos utilizando JPA con base de datos H2 en memoria. El proyecto está diseñado como un punto de partida para prácticas, con implementaciones pendientes marcadas con TODOs.

## Descripción General

El proyecto permite gestionar alumnos con información básica como nombre, email y ciclo formativo. Utiliza una arquitectura en capas con dominio, repositorio y servicio, implementando el patrón Repository con adaptadores JPA.

## Arquitectura

El proyecto sigue una arquitectura hexagonal/clean architecture:

- **Domain**: Modelo de dominio (Alumno)
- **Repository**: Interfaz de repositorio y adaptadores de persistencia
- **Service**: Lógica de negocio
- **Config**: Configuración opcional de H2

### Dependencias Principales

- **Spring Boot Starter**: Base de la aplicación
- **Spring Boot Starter Data JPA**: Para persistencia de datos
- **H2 Database**: Base de datos en memoria para desarrollo

## Configuración

### Base de Datos H2

La aplicación utiliza H2 en memoria con configuración automática de esquemas:

```yaml
spring:
  datasource:
    url: jdbc:h2:mem:alumnosdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
    driver-class-name: org.h2.Driver
    username: sa
    password:
  jpa:
    hibernate:
      ddl-auto: create-drop
    show-sql: true
main:
  web-application-type: none
```

### Perfiles

- **default**: Activa el perfil `h2`
- **h2**: Configuración para base de datos H2 en memoria

## Modelo de Datos

### Alumno (Dominio)

Clase de dominio que representa a un alumno:

```java
public class Alumno {
    private Long id;
    private String nombre;
    private String email;
    private String ciclo;

    // TODO: constructores, getters y setters
}
```

### AlumnoEntity (JPA)

Entidad JPA que mapea la tabla `alumnos`:

```java
@Entity
@Table(name="alumnos")
public class AlumnoEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(unique = true)
    private String email;

    private String ciclo;

    // Constructores, getters, setters, equals, hashCode, toString
}
```

## Repositorios

### Interfaz AlumnoRepository

Define las operaciones de persistencia:

```java
public interface AlumnoRepository {
    List<Alumno> findAll();
    Optional<Alumno> findById(Long id);
    Alumno save(Alumno alumno);
    boolean existsByEmail(String email);
    void deleteById(Long id);
    long count();
}
```

### Adaptador JPA

Implementa la interfaz usando Spring Data JPA:

```java
@Repository
@Profile("h2")
public class AlumnoRepositoryJpaAdapter implements AlumnoRepository {
    private final AlumnoJpaRepository jpa;

    // TODO: implementar métodos usando jpa.findAll(), jpa.findById(), etc.
    // TODO: métodos de mapeo toDomain/toEntity
}
```

### Repositorio JPA

Interfaz que extiende JpaRepository:

```java
public interface AlumnoJpaRepository extends JpaRepository<AlumnoEntity, Long> {
    boolean existsByEmail(String email);
}
```

## Servicio

### AlumnoService

Contiene la lógica de negocio:

```java
@Service
public class AlumnoService {
    private final AlumnoRepository repo;

    public List<Alumno> listar() {
        throw new UnsupportedOperationException("TODO");
    }

    public Alumno obtener(Long id) {
        throw new UnsupportedOperationException("TODO");
    }

    public Alumno crear(Alumno a) {
        throw new UnsupportedOperationException("TODO");
    }

    public Alumno actualizar(Long id, Alumno a) {
        throw new UnsupportedOperationException("TODO");
    }

    public void borrar(Long id) {
        throw new UnsupportedOperationException("TODO");
    }
}
```

## Aplicación Principal

### DemoApplication

Clase principal de Spring Boot:

```java
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
```

## Implementaciones Pendientes (TODOs)

### En Alumno.java

- Definir constructores
- Implementar getters y setters
- Añadir validaciones Jakarta si se desea

### En AlumnoRepositoryJpaAdapter.java

- Implementar `findAll()`: usar `jpa.findAll()` y mapear a dominio
- Implementar `findById()`: usar `jpa.findById()` y mapear a dominio
- Implementar `save()`: mapear dominio→entidad, guardar, mapear entidad→dominio
- Implementar `existsByEmail()`: usar método derivado en JPA
- Implementar `deleteById()`: usar `jpa.deleteById(id)`
- Implementar `count()`: usar `jpa.count()`
- Añadir métodos de mapeo `toDomain()` y `toEntity()`

### En AlumnoService.java

- Implementar `listar()`: llamar a `repo.findAll()`
- Implementar `obtener()`: llamar a `repo.findById()`, manejar Optional
- Implementar `crear()`: validar email único, guardar
- Implementar `actualizar()`: verificar existencia, actualizar
- Implementar `borrar()`: verificar existencia, eliminar
- Definir excepciones personalizadas si se desea (BadRequest, NotFound)

## Ejecución

### Requisitos

- Java 17+
- Maven 3.8+

### Compilar y Ejecutar

```bash
# Compilar
mvn clean compile

# Ejecutar (fallará en TODOs)
mvn spring-boot:run -Dspring-boot.run.profiles=h2

# Ejecutar con perfil h2 explícito
mvn spring-boot:run -Dspring-boot.run.profiles=h2
```

### Consola H2 (Opcional)

Si se descomenta la configuración en `H2ServerConfig.java`, se puede acceder a:

- Consola web: http://localhost:8082
- Servidor TCP: jdbc:h2:tcp://localhost:9092/mem:alumnosdb

## Funcionamiento General

1. **Inicio**: Spring Boot configura H2 en memoria y crea las tablas automáticamente
2. **Persistencia**: Los adaptadores JPA convierten entre objetos de dominio y entidades
3. **Servicio**: La lógica de negocio valida y coordina operaciones
4. **Repositorio**: Abstrae el acceso a datos permitiendo cambiar implementaciones

## Próximos Pasos

Para completar el proyecto:

1. Implementar los constructores y métodos en `Alumno.java`
2. Completar los métodos en `AlumnoRepositoryJpaAdapter.java`
3. Implementar la lógica en `AlumnoService.java`
4. Añadir validaciones y manejo de errores
5. Crear tests unitarios e integración
6. Considerar añadir endpoints REST si se desea

Este starter proporciona una base sólida para aprender sobre Spring Boot, JPA y arquitectura limpia.
