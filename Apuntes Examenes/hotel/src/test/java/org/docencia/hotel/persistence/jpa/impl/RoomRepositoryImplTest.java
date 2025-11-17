package org.docencia.hotel.persistence.jpa.impl;

import org.docencia.hotel.domain.model.Hotel;
import org.docencia.hotel.domain.model.Room;
import org.docencia.hotel.repository.IHotelRepository;
import org.docencia.hotel.repository.IRoomRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoomRepositoryImplTest {
    
    @Autowired
    private IRoomRepository roomRepository;
    
    @Autowired
    private IHotelRepository hotelRepository;
    
    private Hotel testHotel;
    private Room testRoom;
    
    @BeforeEach
    void beforeEach() {
        testHotel = hotelRepository.save(new Hotel("h1", "Test Hotel", "Test City"));
        testRoom = roomRepository.save(new Room("r1", testHotel, 101, 100.0f, "Single"));
    }
    
    @AfterEach
    void afterEach() {
        roomRepository.deleteById("r1");
        hotelRepository.deleteById("h1");
    }
    
    @Test
    void testSaveRoom() {
        Room room = new Room("r2", testHotel, 102, 150.0f, "Double");
        Room saved = roomRepository.save(room);
        assertNotNull(saved);
        assertEquals("r2", saved.getId());
        roomRepository.deleteById("r2");
    }
    
    @Test
    void testFindRoomById() {
        Optional<Room> found = roomRepository.findById("r1");
        assertTrue(found.isPresent());
        assertEquals("r1", found.get().getId());
    }
    
    @Test
    void testFindAllRooms() {
        List<Room> rooms = roomRepository.findAll();
        assertNotNull(rooms);
        assertTrue(rooms.size() > 0);
    }
    
    @Test
    void testUpdateRoom() {
        testRoom.setType("Twin");
        Room updated = roomRepository.save(testRoom);
        assertEquals("Twin", updated.getType());
    }
    
    @Test
    void testExistsById() {
        assertTrue(roomRepository.existsById("r1"));
        assertFalse(roomRepository.existsById("nonexistent"));
    }
    
    @Test
    void testFindByHotelId() {
        List<Room> rooms = roomRepository.findByHotelId("h1");
        assertNotNull(rooms);
        assertTrue(rooms.size() > 0);
    }
}
