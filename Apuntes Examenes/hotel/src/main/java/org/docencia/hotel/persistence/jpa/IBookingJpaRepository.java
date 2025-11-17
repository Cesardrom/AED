package org.docencia.hotel.persistence.jpa;

import java.util.List;

import org.docencia.hotel.domain.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IBookingJpaRepository extends JpaRepository<Booking, String> {
    @Query("SELECT b FROM Booking b WHERE b.room.id = :roomId " +
           "AND b.checkOut > :startDate AND b.checkIn < :endDate")
    List<Booking> findByRoomIdAndDateRange(String roomId, String startDate, String endDate);
}


