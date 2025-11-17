package com.docencia.ficheros.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.docencia.ficheros.model.Note;
import com.docencia.ficheros.service.XmlServiceNote;

class XmlServiceNoteTest {
    XmlServiceNote xmlServiceNote;
    Note note;

    @BeforeEach
    void before(){
        xmlServiceNote = new XmlServiceNote();
        note = new Note();
        note.setId("1");
        note.setTitle("Titulo");
        note.setContent("Contenido");

    }


    @Test
    public void serializarNote(){
        String noteStr= xmlServiceNote.noteToString(note);
        Note noteTest = xmlServiceNote.stringToNote(noteStr);
        Assertions.assertEquals(note, noteTest,"Los elementos deben ser iguales");
    }

    @Test 
    void desSerializarNote(){

    }
}
