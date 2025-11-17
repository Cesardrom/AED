package com.docencia.ficheros.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.docencia.ficheros.model.Note;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;

public class JsonServiceNote extends ServiceNoteAbstract {
    JsonMapper jsonMapper;

    public JsonServiceNote() {
        jsonMapper = new JsonMapper();
    }

    private static Logger logger = LoggerFactory.getLogger(JsonServiceNote.class);

    @Override
    public boolean exists(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'exists'");
    }

    @Override
    public Note findById(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<Note> findAll() {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Note save(Note note) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public boolean delete(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

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

    @Override
    public Note stringToNote(String data) {
        Note resultado = null;
        try {
            resultado = jsonMapper.readValue(data, Note.class);
        } catch (JsonProcessingException e) {
            logger.error("Se ha producido un error en la transformacion", e);

        }
        return resultado;
    }

}
