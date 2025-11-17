package org.docencia.hotel.repository;

import org.docencia.hotel.domain.model.Room;
import java.util.List;
import java.util.Optional;

public interface IRoomRepository {
    boolean existsById(String id);

    Optional<Room> findById(String id);

    List<Room> findAll();

    Room save(Room room);

    void deleteById(String id);

    List<Room> findByHotelId(String hotelId);
}
