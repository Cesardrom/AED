package org.docencia.hotel.persistence.jpa.impl;

import org.docencia.hotel.domain.model.Booking;
import org.docencia.hotel.domain.model.Guest;
import org.docencia.hotel.domain.model.Hotel;
import org.docencia.hotel.domain.model.Room;
import org.docencia.hotel.repository.IBookingRepository;
import org.docencia.hotel.repository.IGuestRepository;
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
class BookingRepositoryImplTest {

    @Autowired
    private IBookingRepository bookingRepository;

    @Autowired
    private IHotelRepository hotelRepository;

    @Autowired
    private IRoomRepository roomRepository;

    @Autowired
    private IGuestRepository guestRepository;

    private Booking testBooking;
    private Hotel testHotel;
    private Room testRoom;
    private Guest testGuest;
    private String checkin;
    private String checkout;

    @BeforeEach
    void beforeEach() {
        checkin = "2025-08-10";
        checkout="2025-08-20";
        testHotel = hotelRepository.save(new Hotel("h1", "Test Hotel", "Test City"));
        testRoom = roomRepository.save(new Room("R105", testHotel, 101, 100.0f, "Single"));
        testGuest = guestRepository.save(new Guest("g1", "John Doe", "john@example.com", "123456"));
        testBooking =new Booking("B3", testRoom, testGuest, checkin, checkout);
        bookingRepository.save(testBooking);
    }

    @AfterEach
    void afterEach() {
        bookingRepository.deleteById("B3");
        roomRepository.deleteById("R105");
        guestRepository.deleteById("g1");
        hotelRepository.deleteById("h1");
    }

    @Test
    void testSaveBooking() {
        Booking booking = new Booking("b2", testRoom, testGuest, checkin, checkout);
        Booking saved = bookingRepository.save(booking);
        assertNotNull(saved);
        assertEquals("b2", saved.getId());
        bookingRepository.deleteById("b2");
    }

    @Test
    void testFindBookingById() {
        Optional<Booking> found = bookingRepository.findById("B3");
        assertTrue(found.isPresent());
        assertEquals("B3", found.get().getId());
    }

    @Test
    void testFindAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        assertNotNull(bookings);
        assertTrue(bookings.size() > 0);
    }

    @Test
    void testUpdateBooking() {
        testBooking.setCheckOut(checkout);
        Booking updated = bookingRepository.save(testBooking);
        assertEquals(checkout, updated.getCheckOut());
    }

    @Test
    void testExistsById() {
        assertTrue(bookingRepository.existsById("B3"));
        assertFalse(bookingRepository.existsById("nonexistent"));
    }

    @Test
    void testFindByRoomIdAndDateRange() {
        List<Booking> bookings = bookingRepository.findByRoomIdAndDateRange(testRoom.getId(), checkin, checkout);
        assertNotNull(bookings);
        assertTrue(bookings.size() > 0);
    } 



}
