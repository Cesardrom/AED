package org.docencia.hotel.repository;

import org.docencia.hotel.domain.model.Booking;

import java.util.List;
import java.util.Optional;

public interface IBookingRepository {
    boolean existsById(String id);

    Optional<Booking> findById(String id);

    List<Booking> findAll();

    Booking save(Booking booking);

    void deleteById(String id);

    List<Booking> findByRoomIdAndDateRange(String roomId, String startDate, String endDate);
}
