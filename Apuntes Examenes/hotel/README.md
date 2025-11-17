# Proyecto Hotel - Gestión de Hoteles con Spring Boot y SQLite

Este proyecto es una aplicación Spring Boot que implementa un sistema de gestión de hoteles, habitaciones, huéspedes y reservas utilizando JPA con SQLite como base de datos.

## Descripción General

La aplicación permite gestionar:

- **Hoteles**: Información básica de hoteles (ID, nombre, dirección)
- **Habitaciones**: Habitaciones asociadas a hoteles con número, precio por noche y tipo
- **Huéspedes**: Información de los huéspedes (ID, nombre completo, email, teléfono)
- **Reservas**: Reservas de habitaciones por huéspedes con fechas de check-in y check-out

## Arquitectura

El proyecto sigue una arquitectura en capas típica de Spring Boot:

- **Domain/Model**: Entidades JPA que representan los objetos de negocio
- **Repository**: Interfaces de repositorio para acceso a datos
- **Persistence/JPA**: Implementaciones concretas usando Spring Data JPA

### Dependencias Principales

- **Spring Boot Starter**: Base de la aplicación
- **Spring Boot Starter Data JPA**: Para persistencia de datos
- **SQLite JDBC**: Driver para SQLite
- **Hibernate Community Dialects**: Dialecto de Hibernate para SQLite

## Configuración

### Base de Datos

La aplicación utiliza SQLite con la siguiente configuración en `application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:sqlite:./hotel_puerto.db
    driver-class-name: org.sqlite.JDBC
  jpa:
    hibernate:
      ddl-auto: update
    database-platform: org.hibernate.community.dialect.SQLiteDialect
```

### Pruebas

Para las pruebas se utiliza una base de datos separada (`hotel_puerto_test.db`) configurada en `application-test.yml`.

## Modelos de Datos

### Hotel

Entidad que representa un hotel con sus habitaciones asociadas.

```java
@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @NonNull
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "hotel")
    @Column(name = "rooms")
    private List<Room> rooms = new ArrayList<>();
}
```

### Room (Habitación)

Entidad que representa una habitación perteneciente a un hotel.

```java
@Entity
@Table(name = "room")
public class Room {
    @Id
    String id;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    Hotel hotel;

    @Column(name = "number")
    Integer roomNumber;

    @Column(name = "price per night", nullable = false)
    private Float pricePerNight;

    @Column(name = "type")
    String type;
}
```

### Guest (Huésped)

Entidad que representa a un huésped del hotel.

```java
@Entity
@Table(name = "guest")
public class Guest {
    @Id
    String id;

    @Column(name = "full_name")
    String fullName;

    @Column(name = "email")
    String email;

    @Column(name = "phone")
    String phone;
}
```

### Booking (Reserva)

Entidad que representa una reserva de habitación por un huésped.

```java
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @Column(name = "id")
    String id;

    @ManyToOne
    @JoinColumn(name = "room_id")
    Room room;

    @ManyToOne
    @JoinColumn(name = "guest_id")
    Guest guest;

    @Column(name = "check_in")
    String checkIn;

    @Column(name = "check_out")
    String checkOut;
}
```

## Repositorios

### Interfaces de Repositorio

Cada entidad tiene su interfaz de repositorio que define las operaciones CRUD básicas:

```java
public interface IHotelRepository {
    boolean existsById(String id);
    Optional<Hotel> findById(String id);
    List<Hotel> findAll();
    Hotel save(Hotel hotel);
    void deleteById(String id);
}
```

### Repositorios JPA

Interfaces que extienden `JpaRepository` para operaciones básicas:

```java
@Repository
public interface IHotelJpaRepository extends JpaRepository<Hotel, String> {
}
```

Para consultas específicas:

```java
@Repository
public interface IRoomJpaRepository extends JpaRepository<Room, String> {
    List<Room> findByHotelId(String hotelId);
}
```

```java
public interface IBookingJpaRepository extends JpaRepository<Booking, String> {
    @Query("SELECT b FROM Booking b WHERE b.room.id = :roomId " +
           "AND b.checkOut > :startDate AND b.checkIn < :endDate")
    List<Booking> findByRoomIdAndDateRange(String roomId, String startDate, String endDate);
}
```

### Implementaciones

Las implementaciones concretas delegan las operaciones a los repositorios JPA:

```java
@Component
public class HotelJpaImpl implements IHotelRepository {
    @Autowired
    private IHotelJpaRepository hotelJpaRepository;

    @Override
    @Transactional
    public boolean existsById(String id) {
        return hotelJpaRepository.existsById(id);
    }

    // ... otros métodos
}
```

## Pruebas

### Pruebas Unitarias

Se incluyen pruebas unitarias para los modelos usando JUnit 5:

```java
class HotelModelTest {
    @Test
    void EqualsTest() {
        hotel.setId("H1");
        hotel.setName("Hotel");
        hotel.setAddress("Calle Las Fresas");
        Hotel hotel2 = new Hotel("H1", "Hotel", "Calle Las Fresas", null);
        Assertions.assertTrue(hotel.equals(hotel2));
    }
}
```

### Pruebas de Integración

Pruebas de integración para los repositorios usando `@SpringBootTest`:

```java
@SpringBootTest
class HotelRepositoryImplTest {
    @Autowired
    private IHotelRepository hotelRepository;

    @Test
    void testSaveHotel() {
        Hotel saved = hotelRepository.save(hotel1);
        assertNotNull(saved);
        assertEquals("H1", saved.getId());
    }
}
```

## Cobertura de Código

El proyecto incluye configuración de JaCoCo para medir cobertura de código con un mínimo del 70% requerido.

```xml
<plugin>
    <groupId>org.jacoco</groupId>
    <artifactId>jacoco-maven-plugin</artifactId>
    <configuration>
        <excludes>
            <exclude>**/persistence/jpa/impl/HotelRepositoryImplTest.class</exclude>
        </excludes>
    </configuration>
    <executions>
        <execution>
            <id>check</id>
            <goals>
                <goal>check</goal>
            </goals>
            <configuration>
                <rules>
                    <rule>
                        <element>BUNDLE</element>
                        <limits>
                            <limit>
                                <counter>LINE</counter>
                                <value>COVEREDRATIO</value>
                                <minimum>0.70</minimum>
                            </limit>
                        </limits>
                    </rule>
                </rules>
            </configuration>
        </execution>
    </executions>
</plugin>
```

## Ejecución

### Requisitos

- Java 17
- Maven

### Compilación y Ejecución

```bash
# Compilar
mvn clean compile

# Ejecutar pruebas
mvn test

# Ejecutar aplicación
mvn spring-boot:run

# Verificar cobertura
mvn jacoco:report
```

### Verificación de Cobertura

```bash
mvn clean test jacoco:report
```

El reporte de cobertura se genera en `target/site/jacoco/index.html`.

## Funcionamiento General

1. **Inicio de la Aplicación**: Spring Boot configura automáticamente la conexión a SQLite y crea las tablas según las entidades JPA.

2. **Gestión de Datos**: Los repositorios permiten operaciones CRUD sobre hoteles, habitaciones, huéspedes y reservas.

3. **Relaciones**: Las entidades están relacionadas mediante anotaciones JPA (@OneToMany, @ManyToOne).

4. **Consultas Específicas**: Algunos repositorios incluyen métodos de consulta personalizados, como buscar habitaciones por hotel o reservas por habitación y rango de fechas.

5. **Pruebas**: Las pruebas verifican tanto la lógica de negocio como la integración con la base de datos.

Este proyecto demuestra el uso de Spring Boot con JPA para construir una aplicación de gestión hotelera persistente y testeable.
