package com.docencia.ficheros.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.docencia.ficheros.model.Note;

class JsonServiceNoteTest {
    JsonServiceNote jsonServiceNote;
    Note note;

    @BeforeEach
    void before(){
        jsonServiceNote = new JsonServiceNote();
        note = new Note();
        note.setId("1");
        note.setTitle("Titulo");
        note.setContent("Contenido");

    }


    @Test
    public void serializarNote(){
        String noteStr= jsonServiceNote.noteToString(note);
        Note noteTest = jsonServiceNote.stringToNote(noteStr);
        Assertions.assertEquals(note, noteTest,"Los elementos deben ser iguales");
    }

    @Test 
    void desSerializarNote(){

    }
}
