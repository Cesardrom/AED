package com.docencia.personas.repository;

import com.docencia.personas.model.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PersonaRepository extends MongoRepository<Persona, String> {

    Optional<Persona> findByEmail(String email);

    List<Persona> findByNombreContainingIgnoreCase(String nombre);

    List<Persona> findByEdadBetween(Integer min, Integer max);

    @Query("{ 'direccion.ciudad': ?0 }")
    List<Persona> findByCiudad(String ciudad);
}