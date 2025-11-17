package org.docencia.hotel.persistence.jpa.impl;

import org.docencia.hotel.domain.model.Hotel;
import org.docencia.hotel.persistence.jpa.IHotelJpaRepository;
import org.docencia.hotel.repository.IHotelRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HotelRepositoryImplTest {

    @Autowired
    private IHotelRepository hotelRepository;


    private Hotel hotel1;
    private Hotel hotel2;
    private List<String> createdIds;

    @BeforeEach
    void beforeEach() {

        createdIds = new java.util.ArrayList<>();
        hotel1 = new Hotel("H1", "Hotel España", "Calle Mayor 1", null);
        hotel2 = new Hotel("H2", "Hotel Portugal", "Rua Lisboa 2", null);
    }

    @AfterEach
    void afterEach() {

        for (String id : createdIds) {
            hotelRepository.deleteById(id);
        }
        createdIds.clear();
    }

    @Test
    void testSaveHotel() {

        Hotel saved = hotelRepository.save(hotel1);
        createdIds.add(saved.getId());

        assertNotNull(saved);
        assertEquals("H1", saved.getId());
        assertEquals("Hotel España", saved.getName());

        assertTrue(hotelRepository.existsById("H1"));
    }

    @Test
    void testExistsById_ReturnTrue() {

        Hotel saved = hotelRepository.save(hotel1);
        createdIds.add(saved.getId());

        boolean exists = hotelRepository.existsById("H1");

        assertTrue(exists);
    }

    @Test
    void testExistsById_ReturnFalse() {

        boolean exists = hotelRepository.existsById("H_NO_EXISTE_12345");

        assertFalse(exists);
    }

    @Test
    void testFindById_ReturnHotel() {

        Hotel saved = hotelRepository.save(hotel1);
        createdIds.add(saved.getId());

        Optional<Hotel> result = hotelRepository.findById("H1");

        assertTrue(result.isPresent());
        assertEquals("H1", result.get().getId());
        assertEquals("Hotel España", result.get().getName());
    }

    @Test
    void testFindById_ReturnEmpty() {

        Optional<Hotel> result = hotelRepository.findById("H_NO_EXISTE_12345");

        assertFalse(result.isPresent());
    }

    @Test
    void testFindAll() {

        Hotel saved1 = hotelRepository.save(hotel1);
        Hotel saved2 = hotelRepository.save(hotel2);
        createdIds.add(saved1.getId());
        createdIds.add(saved2.getId());

        List<Hotel> hotels = hotelRepository.findAll();

        assertTrue(hotels.size() >= 2);
        assertTrue(hotels.stream().anyMatch(h -> h.getId().equals("H1")));
        assertTrue(hotels.stream().anyMatch(h -> h.getId().equals("H2")));
    }

    @Test
    void testDeleteById() {

        Hotel saved = hotelRepository.save(hotel1);
        createdIds.add(saved.getId());

        assertTrue(hotelRepository.existsById("H1"));

        hotelRepository.deleteById("H1");
        createdIds.remove("H1");

        assertFalse(hotelRepository.existsById("H1"));
        assertFalse(hotelRepository.findById("H1").isPresent());
    }

    @Test
    void testUpdateHotel() {

        Hotel saved = hotelRepository.save(hotel1);
        createdIds.add(saved.getId());

        Hotel updated = new Hotel("H1", "Hotel España Actualizado", "Calle Nueva 5", null);

        hotelRepository.save(updated);
        Optional<Hotel> result = hotelRepository.findById("H1");

        assertTrue(result.isPresent());
        assertEquals("Hotel España Actualizado", result.get().getName());
        assertEquals("Calle Nueva 5", result.get().getAddress());
    }

    @Test
    void testSaveMultipleHotels() {

        Hotel saved1 = hotelRepository.save(hotel1);
        Hotel saved2 = hotelRepository.save(hotel2);
        createdIds.add(saved1.getId());
        createdIds.add(saved2.getId());

        List<Hotel> hotels = hotelRepository.findAll();

        assertTrue(hotels.size() >= 2);
    }

    @Test
    void testDeleteAndVerify() {

        Hotel saved1 = hotelRepository.save(hotel1);
        Hotel saved2 = hotelRepository.save(hotel2);
        createdIds.add(saved1.getId());
        createdIds.add(saved2.getId());

        hotelRepository.deleteById("H1");
        createdIds.remove("H1");

        List<Hotel> hotels = hotelRepository.findAll();

        assertTrue(hotels.stream().anyMatch(h -> h.getId().equals("H2")));
        assertFalse(hotels.stream().anyMatch(h -> h.getId().equals("H1")));
    }

    @Test
    void testSaveAndFindByIdConsistency() {

        Hotel saved = hotelRepository.save(hotel1);
        createdIds.add(saved.getId());

        Optional<Hotel> retrieved = hotelRepository.findById(saved.getId());

        assertTrue(retrieved.isPresent());
        assertEquals(saved.getId(), retrieved.get().getId());
        assertEquals(saved.getName(), retrieved.get().getName());
    }
}
