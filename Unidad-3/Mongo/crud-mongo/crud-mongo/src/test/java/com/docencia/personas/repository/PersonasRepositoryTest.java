package com.docencia.personas.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.docencia.personas.model.Direccion;
import com.docencia.personas.model.Persona;

@SpringBootTest
@ActiveProfiles
public class PersonasRepositoryTest {

    private PersonaRepository personaRepository;
    private Persona personaColection;
    Direccion direccion;
    private Persona personaFind;

    @Autowired
    public PersonasRepositoryTest(PersonaRepository personaRepository){
        this.personaRepository = personaRepository;
    }

    @BeforeEach
    void cleanDataBase(){
        personaRepository.deleteAll();
        direccion = new Direccion("Una calle", "Una ciudad", "38315", "Francia");
        personaColection = new Persona("test", 18, "un@gmail.com", direccion);
        personaFind = personaRepository.save(personaColection);
    }

    @Test
    void TestFind(){
        Assertions.assertEquals(1, personaRepository.count());
        Assertions.assertNotNull(personaFind);
        Assertions.assertNotNull(personaFind.getId());
    }

    @Test
    void TestFindById(){
        Optional<Persona> found = personaRepository.findById(personaFind.getId());
        Assertions.assertTrue(found.isPresent());
        Assertions.assertEquals(personaFind.getId(), found.get().getId());
    }

    @Test
    void TestFindByEdadBetween(){
        Direccion dir2 = new Direccion("Otra calle", "Otra ciudad", "12345", "España");
        Persona persona2 = new Persona("cesar", 20, "cesar@gmail.com", dir2);
        personaRepository.save(persona2);
        List<Persona> personas = personaRepository.findByEdadBetween(15, 30);
        Assertions.assertEquals(2, personas.size());
    }

    @Test
    void TestFindByNombreContainingIgnoreCase(){
        Direccion dir2 = new Direccion("Otra calle", "Otra ciudad", "12345", "España");
        Persona persona2 = new Persona("cesar", 20, "cesar@gmail.com", dir2);
        personaRepository.save(persona2);
        List<Persona> personas = personaRepository.findByNombreContainingIgnoreCase("test");
        Assertions.assertEquals(1, personas.size());
        Assertions.assertEquals("test", personas.get(0).getNombre());
    }
}
