package org.docencia.hotel.persistence.jpa.Impl;

import org.docencia.hotel.domain.model.Hotel;
import org.docencia.hotel.persistence.jpa.IHotelJpaRepository;
import org.docencia.hotel.repository.IHotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class HotelJpaImpl implements IHotelRepository {

    @Autowired
    private IHotelJpaRepository hotelJpaRepository;

    @Override
    @Transactional

    public boolean existsById(String id) {
        return hotelJpaRepository.existsById(id);
    }

    @Override
    @Transactional

    public Optional<Hotel> findById(String id) {
        return hotelJpaRepository.findById(id);
    }

    @Override
    @Transactional

    public List<Hotel> findAll() {
        return hotelJpaRepository.findAll();
    }

    @Override
    @Transactional

    public Hotel save(Hotel hotel) {
        return hotelJpaRepository.save(hotel);
    }

    @Override
    @Transactional

    public void deleteById(String id) {
        hotelJpaRepository.deleteById(id);
    }
}
