package com.docencia.objetos.repo;

import com.docencia.objetos.domain.Alumno;
import com.docencia.objetos.repo.jpa.AlumnoEntity;
import com.docencia.objetos.repo.jpa.AlumnoJpaRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Profile("h2")
public class AlumnoRepositoryJpaAdapter implements AlumnoRepository {

  private final AlumnoJpaRepository jpa;

  public AlumnoRepositoryJpaAdapter(AlumnoJpaRepository jpa) {
    this.jpa = jpa;
  }

  @Override
  public List<Alumno> findAll() {
    return jpa.findAll().stream()
        .map(this::toDomain)
        .collect(Collectors.toList());
  }

  @Override
  public Optional<Alumno> findById(Long id) {
    return jpa.findById(id).map(this::toDomain);
  }

  @Override
  public Alumno save(Alumno alumno) {
    AlumnoEntity entity = toEntity(alumno);
    AlumnoEntity saved = jpa.save(entity);
    return toDomain(saved);
  }

  @Override
  public boolean existsByEmail(String email) {
    return jpa.existsByEmail(email);
  }

  @Override
  public void deleteById(Long id) {
    jpa.deleteById(id);
  }

  @Override
  public long count() {
    return jpa.count();
  }

  private Alumno toDomain(AlumnoEntity entity) {
    return new Alumno(entity.getId(), entity.getNombre(), entity.getEmail(), entity.getCiclo());
  }

  private AlumnoEntity toEntity(Alumno alumno) {
    return new AlumnoEntity(alumno.getId(), alumno.getNombre(), alumno.getEmail(), alumno.getCiclo());
  }
}
