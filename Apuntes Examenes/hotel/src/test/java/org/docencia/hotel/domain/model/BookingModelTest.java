package org.docencia.hotel.domain.model;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.transaction.Transactional;

public class BookingModelTest {
    private Hotel hotel;
    private Room room1 = new Room("R1", hotel, 1, 20.0f, "Single");
    private Booking booking1 = new Booking();
    private Guest guest1 = new Guest("G1");
    private String date1;
    private String date2;

    @BeforeEach
    @Transactional
    void beforeEach() {
        room1 = new Room();
        guest1 = new Guest();
        booking1 = new Booking();

    }

    @Test
    void getRoomTest() {
        booking1.setRoom(room1);
        Room room = booking1.getRoom();
        Assertions.assertEquals(room, booking1.getRoom());

    }

    @Test
    void getGuestTest() {
        booking1.setGuest(guest1);
        Guest guest = booking1.getGuest();
        Assertions.assertEquals(guest, booking1.getGuest());
    }

    @Test
    void getIdTest() {
        String id = booking1.getId();
        Assertions.assertEquals(id, booking1.getId());
    }

    @Test
    void constructorIdTest() {
        Booking booking2 = new Booking("B1");
        Assertions.assertEquals("B1", booking2.getId());
    }

    @Test
    void bookingConstructTest() {
        Booking booking2 = new Booking("B1", room1, guest1, date1, date2);
        Assertions.assertEquals("B1", booking2.getId());
    }

    @Test
    void bookingSetGuestTest() {
        booking1.setGuest(guest1);
        Assertions.assertEquals(guest1, booking1.getGuest());
    }

    @Test
    void bookingSetRoomTest() {
        booking1.setRoom(room1);
        Assertions.assertEquals(room1, booking1.getRoom());
    }

    @Test
    void bookingEqualsTest() {
        booking1.setId("B1");
        booking1.setRoom(room1);
        booking1.setGuest(guest1);
        Booking booking2 = new Booking("B1", room1, guest1);
        Assertions.assertTrue(booking1.equals(booking2));
    }

    @Test
    void bookingEqualsObjectTest() {
        booking1.setId("B1");
        booking1.setRoom(room1);
        booking1.setGuest(guest1);
        Booking booking2 = new Booking("B1", room1, guest1);
        Assertions.assertTrue(booking2.equals(booking2));
    }

    @Test
    void bookingHashCodeTest() {
        Booking booking1 = new Booking("B1", room1, guest1);
        Booking booking2 = new Booking("B1", room1, guest1);
        Assertions.assertEquals(booking1.hashCode(), booking2.hashCode());
    }

    @Test
    void bookingEqualsIsNotObjectTest() {
        Assertions.assertFalse(booking1.equals("booking"));
    }

    @Test
    void testGetCheckOut() {
        Booking booking = new Booking("b1", room1, guest1, date1, date2);
        assertEquals(date2, booking.getCheckOut());
    }

    @Test
    void testSetCheckOut() {
        Booking booking = new Booking("b1", room1, guest1, date1, date2);
        booking.setCheckOut(date2);
        assertEquals(date2, booking.getCheckOut());

    }

    @Test
    void testGetCheckIn() {
        Booking booking = new Booking("b1", room1, guest1, date1, date2);
        assertEquals(date1, booking.getCheckIn());
    }

    @Test
    void testSetCheckIn() {
        Booking booking = new Booking("b1", room1, guest1, date1, date2);
        booking.setCheckIn(date1);
        assertEquals(date1, booking.getCheckIn());
    }

   
}