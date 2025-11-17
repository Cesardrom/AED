package org.docencia.hotel.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.transaction.Transactional;

public class RoomModelTest {

    private Hotel hotel;
    private Room room1 = new Room("R105", hotel, 1, 20.0f, "Single");

    @BeforeEach
    @Transactional
    void beforeEach() {
        room1 = new Room();
    }


    @Test
    void RoomEqualsTest() {
        room1.setId("R105");
        room1.setHotel(hotel);
        room1.setRoomNumber(1);
        room1.setPricePerNight(20.0f);
        room1.setType("Single");
        Room room2 = new Room("R105", hotel, 1, 20.0f, "Single");
        Assertions.assertTrue(room1.equals(room2));


        
    }
    @Test
    void RoomEqualsObjectTest() {
        room1.setId("R105");
        room1.setHotel(hotel);
        room1.setRoomNumber(1);
        room1.setPricePerNight(20.0f);
        room1.setType("Single");
        Room room2 = new Room("R105", hotel, 1, 20.0f, "Single");
        Assertions.assertTrue(room2.equals(room2));
    }


    @Test
    void getRoomNumberTest() {
        Integer roomNumber = room1.getRoomNumber();
        Assertions.assertEquals(roomNumber, room1.getRoomNumber());
    }


    @Test 
    void getPricePerNightTest() {
        Float pricePerNight = room1.getPricePerNight();
        Assertions.assertEquals(pricePerNight, room1.getPricePerNight());
    }


    @Test 
    void getHotelTest() {
        Hotel hotel = room1.getHotel();
        Assertions.assertEquals(hotel, room1.getHotel());
    }

    @Test
    void roomHashCodeTest() {
        Room room1 = new Room("R105", hotel, 1, 20.0f, "Single");
        Room room2 = new Room("R105", hotel, 2, 30.0f, "Double");
        Assertions.assertEquals(room1.hashCode(), room2.hashCode());
    
    }

    @Test
    void getIdTest() {
        String id = room1.getId();
        Assertions.assertEquals(id, room1.getId());
    }


    @Test 
    void idContructorTest() {
        Room room1 = new Room("R105");
        Assertions.assertEquals("R105", room1.getId());
    }

    @Test 
    void getTypeTest() {
        String type = room1.getType();
        Assertions.assertEquals(type, room1.getType());
    }

@Test
void equalsWithNonRoomObjectTest() {
    Room room = new Room("R105", hotel, 1, 20.0f, "Single");
    String notARoom = "R105";
    
    Assertions.assertFalse(room.equals(notARoom));
}


}


