package org.docencia.hotel.domain.model;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.transaction.Transactional;

class HotelModelTest {

    private Hotel hotel;
    private Room room1 = new Room("R1", hotel, 1, 20.0f, "Single");

    @BeforeEach
    @Transactional
    void beforeEach() {
        hotel = new Hotel();
    }

    @Test
    void EqualsTest() {
        hotel.setId("H1");
        hotel.setName("Hotel");
        hotel.setAddress("Calle Las Fresas");
        Hotel hotel2 = new Hotel("H1", "Hotel", "Calle Las Fresas", null);
        Assertions.assertTrue(hotel.equals(hotel2));
    }

    @Test
    void EqualsObjectTest() {
        hotel.setId("H1");
        hotel.setName("Hotel");
        hotel.setAddress("Calle Las Fresas");
        Hotel hotel2 = new Hotel("H1", "Hotel", "Calle Las Fresas", null);
        Assertions.assertTrue(hotel2.equals(hotel2));
    }

    @Test
    void EqualsIsNotObjectTest() {
        Assertions.assertFalse(hotel.equals("hotel"));
    }

    @Test
    void GetAdressTest() {
        String address = hotel.getAddress();
        Assertions.assertEquals(address, hotel.getAddress());
    }

    @Test
    void GetIdTest() {
        String id = hotel.getId();
        Assertions.assertEquals(id, hotel.getId());
    }



    @Test
    void idContructorTest() {
        Hotel hotel1 = new Hotel("H1");
        Assertions.assertEquals("H1", hotel1.getId());
    }
    @Test
    void GetNameTest() {
        String name = hotel.getName();
        Assertions.assertEquals(name, hotel.getName());
    }

    @Test
    void getRoomTest() {
        hotel.setRooms(List.of(room1));
        List<Room> rooms = hotel.getRooms();
        Assertions.assertEquals(rooms, hotel.getRooms());
    }

    @Test
    void SetRoomsTest() {
        hotel.setRooms(List.of(room1));
        Assertions.assertEquals(List.of(room1), hotel.getRooms());

    }

    @Test
    void hotelHashCodeTest() {
        Hotel hotel1 = new Hotel("H1", "Hotel A", "Calle 1", null);
        Hotel hotel2 = new Hotel("H1", "Hotel B", "Calle 2", null);

        Assertions.assertEquals(hotel1.hashCode(), hotel2.hashCode());
    }

}
