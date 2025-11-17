package org.docencia.hotel.persistence.jpa.Impl;

import org.docencia.hotel.domain.model.Guest;
import org.docencia.hotel.persistence.jpa.IGuestJpaRepository;
import org.docencia.hotel.repository.IGuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class GuestJpaImpl implements IGuestRepository {

    @Autowired
    private IGuestJpaRepository guestJpaRepository;

    @Override
    @Transactional
    public boolean existsById(String id) {
        return guestJpaRepository.existsById(id);
    }

    @Override
    @Transactional

    public Optional<Guest> findById(String id) {
        return guestJpaRepository.findById(id);
    }

    @Override
    @Transactional

    public List<Guest> findAll() {
        return guestJpaRepository.findAll();
    }

    @Override
    @Transactional

    public Guest save(Guest guest) {
        return guestJpaRepository.save(guest);
    }

    @Override
    @Transactional

    public void deleteById(String id) {
        guestJpaRepository.deleteById(id);
    }
}
