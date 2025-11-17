package org.docencia.hotel.repository;

import org.docencia.hotel.domain.model.Hotel;
import java.util.List;
import java.util.Optional;

public interface IHotelRepository {
    boolean existsById(String id);

    Optional<Hotel> findById(String id);

    List<Hotel> findAll();

    Hotel save(Hotel hotel);

    void deleteById(String id);
}
