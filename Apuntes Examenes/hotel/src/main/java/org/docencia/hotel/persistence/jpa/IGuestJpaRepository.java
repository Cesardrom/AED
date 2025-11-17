package org.docencia.hotel.persistence.jpa;

import org.docencia.hotel.domain.model.Guest;
import org.docencia.hotel.repository.IGuestRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGuestJpaRepository extends JpaRepository<Guest, String>{
}
