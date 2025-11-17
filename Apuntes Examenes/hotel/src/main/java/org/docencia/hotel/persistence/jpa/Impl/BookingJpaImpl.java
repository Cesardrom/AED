package org.docencia.hotel.persistence.jpa.Impl;

import org.docencia.hotel.domain.model.Booking;
import org.docencia.hotel.persistence.jpa.IBookingJpaRepository;
import org.docencia.hotel.repository.IBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Component
public class BookingJpaImpl implements IBookingRepository {

    @Autowired

    private IBookingJpaRepository bookingJpaRepository;

    @Override
    @Transactional
    public boolean existsById(String id) {
        return bookingJpaRepository.existsById(id);
    }

    @Transactional

    @Override
    public Optional<Booking> findById(String id) {
        return bookingJpaRepository.findById(id);
    }

    @Transactional

    @Override
    public List<Booking> findAll() {
        return bookingJpaRepository.findAll();
    }

    @Transactional

    @Override
    public Booking save(Booking booking) {
        return bookingJpaRepository.save(booking);
    }

    @Transactional

    @Override
    public void deleteById(String id) {
        bookingJpaRepository.deleteById(id);
    }

    @Transactional

    @Override
    public List<Booking> findByRoomIdAndDateRange(String roomId, String startDate, String endDate) {
        return bookingJpaRepository.findByRoomIdAndDateRange(roomId, startDate, endDate);
    }

}
