# Ficheros Serializables - Proyecto Spring Boot

Este proyecto es una aplicación Spring Boot que demuestra el manejo de archivos serializables, específicamente para gestionar "notas" (Notes) utilizando serialización en formatos JSON y XML. El proyecto incluye repositorios basados en archivos, servicios para conversión de datos, y pruebas unitarias.

## Descripción General

El proyecto implementa un sistema simple de gestión de notas, donde cada nota tiene un ID único, un título y contenido. Los datos se almacenan en archivos de texto plano (para JSON) o XML, utilizando la biblioteca Jackson para la serialización y deserialización. Incluye abstracciones para repositorios y servicios, permitiendo extensiones futuras (por ejemplo, bases de datos).

### Características Principales

- **Modelo de Datos**: Clase `Note` con validaciones usando Jakarta Validation.
- **Serialización**: Soporte para JSON y XML mediante servicios dedicados.
- **Repositorios**: Implementaciones basadas en archivos con locking para concurrencia.
- **Arquitectura**: Uso de interfaces, clases abstractas y inyección de dependencias de Spring.
- **Pruebas**: Tests unitarios con JUnit 5 para serialización y repositorios.

## Requisitos

- Java 17+
- Maven 3.8+
- Spring Boot 3.5.6

## Instalación y Ejecución

1. Clona o descarga el proyecto.
2. Navega al directorio raíz: `cd JAVA/ficheros-serializables`
3. Ejecuta con Maven: `./mvnw spring-boot:run` (o `mvnw.cmd` en Windows).

La aplicación se ejecutará en el puerto por defecto de Spring Boot (8080). Sin embargo, no expone endpoints REST; es una demo de lógica de negocio.

## Arquitectura del Código

### Modelo de Datos

La clase `Note` representa una nota simple:

```java
package com.docencia.ficheros.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.Objects;

/**
 * Clase note para que almacene informacion
 *
 * @author DavidRiccio
 * @version 1.0.0
 */
public class Note {
    @NotBlank
    private String id;

    @NotBlank
    @Size(max = 200)
    private String title;

    @NotBlank
    private String content;

    public Note() {}

    public Note(String id) {
        this.id = id;
    }

    public Note(String id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    // Getters y setters...
    // equals y hashCode basados en id...
}
```

- Usa anotaciones de validación: `@NotBlank` para campos obligatorios y `@Size` para límites.
- Implementa `equals` y `hashCode` basados en el ID para comparación.

### Repositorios

Los repositorios manejan el almacenamiento y recuperación de notas desde archivos.

#### Interfaz Base

```java
package com.docencia.ficheros.repo;

import java.util.List;
import com.docencia.ficheros.model.Note;

public interface INoteRepository {
    public boolean exists(String id);
    public Note findById(String id);
    public Note find(Note note);
    public List<Note> findAll();
    public Note save(Note note);
    public boolean delete(String id);
}
```

#### Implementación Abstracta

La clase `FileNoteAbstractRepository` proporciona lógica común para repositorios basados en archivos:

```java
public abstract class FileNoteAbstractRepository implements INoteRepository {
    ObjectMapper mapper;
    private String nameFile;
    private Path path;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public FileNoteAbstractRepository(String name, ObjectMapper mapper) {
        this.nameFile = name;
        this.mapper = mapper;
        this.path = verificarFichero();
    }

    private Path verificarFichero() {
        URL resource = getClass().getClassLoader().getResource(nameFile);
        return Paths.get(resource.getPath());
    }

    @Override
    public List<Note> findAll() {
        lock.readLock().lock();
        try {
            return Collections.unmodifiableList(readAllInternal());
        } finally {
            lock.readLock().unlock();
        }
    }

    public Note save(Note note) {
        lock.writeLock().lock();
        try {
            List<Note> notes = findAll();
            if (StringUtils.isEmpty(note.getId())) {
                note.setId(UUID.randomUUID().toString());
            }
            notes.removeIf(n -> Objects.equals(n.getId(), note.getId()));
            notes.add(note);
            writeAllInternal(notes);
            return note;
        } finally {
            lock.writeLock().unlock();
        }
    }

    // Métodos auxiliares para leer/escribir...
}
```

- Usa `ReentrantReadWriteLock` para manejar concurrencia en lecturas/escrituras.
- Serializa listas de notas como arrays JSON/XML.
- Genera IDs únicos si no se proporcionan.

#### Implementaciones Concretas

- `FileNoteRepository`: Usa XML por defecto, lee desde `note-repository.txt`.
- `FileNoteXmlRepository`: Extiende la abstracta para XML específico.

### Servicios

Los servicios convierten notas a strings y viceversa, usando Jackson.

#### Interfaz

```java
public interface INoteService {
    public boolean exists(String id);
    public Note findById(String id);
    public List<Note> findAll();
    public Note save(Note note);
    public boolean delete(String id);
    public String noteToString(Note note);
    public Note stringToNote(String data);
}
```

#### Clase Abstracta

```java
public abstract class ServiceNoteAbstract implements INoteService {
    @Autowired
    INoteRepository noteRepository;

    public INoteRepository getNoteRepository() {
        return noteRepository;
    }
}
```

#### Implementaciones

- `JsonServiceNote`: Usa `JsonMapper` para JSON.
- `XmlServiceNote`: Usa `XmlMapper` para XML.

Ejemplo de serialización en `JsonServiceNote`:

```java
@Override
public String noteToString(Note note) {
    String resultado = null;
    try {
        resultado = jsonMapper.writeValueAsString(note);
    } catch (JsonProcessingException e) {
        logger.error("Se ha producido un error en la transformacion", e);
    }
    return resultado;
}
```

### Serialización Básica

La clase `SimpleBean` demuestra serialización Java estándar:

```java
public class SimpleBean implements Serializable {
    private int x = 1;
    private int y = 2;

    // Getters y setters...
}
```

### Configuración

- `pom.xml`: Dependencias de Spring Boot, Jackson para XML/JSON, SLF4J para logging.
- `application.properties`: Nombre de la aplicación.
- Archivos de datos: `note-repository.txt` (vacío inicialmente), `note-repository.xml` (vacío).

### Tests

Pruebas unitarias con JUnit 5:

- `SimpleBeanTest`: Serialización XML de `SimpleBean`.
- `JsonServiceNoteTest` y `XmlServiceNoteTest`: Conversión nota-string-nota.
- `FileNoteRepositoryTest`: Operaciones básicas de repositorio.
- `FicherosSerializablesApplicationTests`: Carga de contexto Spring.

Ejemplo de test de serialización:

```java
@Test
void simpleBeanSerializarTest() {
    XmlMapper xmlMapper = new XmlMapper();
    String xml = xmlMapper.writeValueAsString(new SimpleBean());
    assertNotNull(xml);
    assertTrue(xml.contains("<x>1</x>"));
}
```

## Funcionamiento

1. La aplicación arranca con Spring Boot.
2. Los repositorios cargan datos desde archivos en `src/main/resources`.
3. Los servicios permiten convertir notas a JSON/XML y viceversa.
4. Las operaciones de repositorio usan locking para thread-safety.
5. Los tests verifican la serialización y operaciones CRUD básicas.

Este proyecto sirve como base para sistemas de persistencia basados en archivos, extensible a bases de datos o APIs REST.
