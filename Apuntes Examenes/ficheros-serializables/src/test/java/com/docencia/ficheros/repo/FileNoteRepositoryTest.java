package com.docencia.ficheros.repo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.docencia.ficheros.model.Note;

class FileNoteRepositoryTest {
    FileNoteRepository fileNoteRepository;
    Note elemento;
    Note elementoFind = null;
    String id = "0001";
    String title = "Titulo";
    String content = "content";

    @BeforeEach
    void beforeEach() {
        fileNoteRepository = new FileNoteRepository();
        elemento = new Note(id, title, content);
        elementoFind=fileNoteRepository.find(elemento);
        Assertions.assertNull(elementoFind,"El elemto debe ser null");
    }

    @AfterEach
    void afterEach() {
        elementoFind=fileNoteRepository.findById(id);
        Assertions.assertNotNull(elementoFind,"El elemento no debe ser null");
        fileNoteRepository.delete(id);
    }

    @Test
    void createFileTest() {
        Assertions.assertNotNull(fileNoteRepository, "El repositorio no debe ser nulo");
    }

    @Test
    void insertNote() {
        Note result = fileNoteRepository.findById(null);
        Assertions.assertNotNull(result, "El resultado no debe ser nulo");
        Assertions.assertEquals(result, result, "El valor no es el esperado");
        // getById
        // Insert
        // getById
        // eliminar
    }
}
