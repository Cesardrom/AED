package com.docencia.ficheros.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.docencia.ficheros.repo.INoteRepository;

public abstract class ServiceNoteAbstract implements INoteService {
    @Autowired
    INoteRepository noteRepository;

    public INoteRepository getNoteRepository() {
        return noteRepository;
    }
}
