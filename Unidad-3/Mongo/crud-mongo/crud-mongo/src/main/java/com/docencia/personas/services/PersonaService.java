package com.docencia.personas.services;


import org.springframework.stereotype.Service;

import com.docencia.personas.model.Persona;
import com.docencia.personas.repository.PersonaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    public Optional<Persona> findById(String id) {
        return personaRepository.findById(id);
    }

    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    public void deleteById(String id) {
        personaRepository.deleteById(id);
    }
}
