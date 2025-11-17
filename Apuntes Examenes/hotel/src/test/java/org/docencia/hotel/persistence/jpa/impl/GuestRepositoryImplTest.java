package org.docencia.hotel.persistence.jpa.impl;

import org.docencia.hotel.domain.model.Guest;
import org.docencia.hotel.repository.IGuestRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GuestRepositoryImplTest {
    
    @Autowired
    private IGuestRepository guestRepository;
    
    private Guest testGuest;
    
    @BeforeEach
    void beforeEach(){
        testGuest = guestRepository.save(new Guest("g1", "John Doe", "john@example.com", "123456"));

    }
    
    @AfterEach
    void afterEach() {
        guestRepository.deleteById("g1");
    }
    
    @Test
    void testSaveGuest() {
        Guest guest = new Guest("g2", "Jane Smith", "jane@example.com","34234");
        Guest saved = guestRepository.save(guest);
        assertNotNull(saved);
        assertEquals("g2", saved.getId());
        guestRepository.deleteById("g2");
    }
    
    @Test
    void testFindGuestById() {
        Optional<Guest> found = guestRepository.findById("g1");
        assertTrue(found.isPresent());
        assertEquals("g1", found.get().getId());
    }
    
    @Test
    void testFindAllGuests() {
        List<Guest> guests = guestRepository.findAll();
        assertNotNull(guests);
        assertTrue(guests.size() > 0);
    }
    
    @Test
    void testUpdateGuest() {
        testGuest.setEmail("newemail@example.com");
        Guest updated = guestRepository.save(testGuest);
        assertEquals("newemail@example.com", updated.getEmail());
    }
    
    @Test
    void testExistsById() {
        assertTrue(guestRepository.existsById("g1"));
        assertFalse(guestRepository.existsById("nonexistent"));
    }
}
