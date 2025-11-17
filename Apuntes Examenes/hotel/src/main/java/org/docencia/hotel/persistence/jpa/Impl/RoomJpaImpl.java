package org.docencia.hotel.persistence.jpa.Impl;

import org.docencia.hotel.domain.model.Room;
import org.docencia.hotel.persistence.jpa.IRoomJpaRepository;
import org.docencia.hotel.repository.IRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class RoomJpaImpl implements IRoomRepository {

    @Autowired
    private IRoomJpaRepository roomJpaRepository;

    @Override
    @Transactional

    public boolean existsById(String id) {
        return roomJpaRepository.existsById(id);
    }

    @Override
    @Transactional

    public Optional<Room> findById(String id) {
        return roomJpaRepository.findById(id);
    }

    @Override
    @Transactional

    public List<Room> findAll() {
        return roomJpaRepository.findAll();
    }

    @Override
    @Transactional

    public Room save(Room room) {
        return roomJpaRepository.save(room);
    }

    @Override
    @Transactional

    public void deleteById(String id) {
        roomJpaRepository.deleteById(id);
    }

    @Override
    @Transactional

    public List<Room> findByHotelId(String hotelId) {
        return roomJpaRepository.findByHotelId(hotelId);
    }
}
