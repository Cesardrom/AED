package com.docencia.objetos.service;

import com.docencia.objetos.domain.Alumno;
import com.docencia.objetos.repo.AlumnoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {

  private final AlumnoRepository repo;
  public AlumnoService(AlumnoRepository repo){ this.repo = repo; }

  public List<Alumno> listar(){
    return repo.findAll();
  }

  public Alumno obtener(Long id){
    Optional<Alumno> alumno = repo.findById(id);
    if (alumno.isEmpty()) {
      throw new RuntimeException("Alumno no encontrado con id: " + id);
    }
    return alumno.get();
  }

  public Alumno crear(Alumno a){
    if (repo.existsByEmail(a.getEmail())) {
      throw new RuntimeException("Email ya existe: " + a.getEmail());
    }
    return repo.save(a);
  }

  public Alumno actualizar(Long id, Alumno a){
    Optional<Alumno> existente = repo.findById(id);
    if (existente.isEmpty()) {
      throw new RuntimeException("Alumno no encontrado con id: " + id);
    }
    if (!existente.get().getEmail().equals(a.getEmail()) && repo.existsByEmail(a.getEmail())) {
      throw new RuntimeException("Email ya existe: " + a.getEmail());
    }
    a.setId(id);
    return repo.save(a);
  }

  public void borrar(Long id){
    if (!repo.findById(id).isPresent()) {
      throw new RuntimeException("Alumno no encontrado con id: " + id);
    }
    repo.deleteById(id);
  }

  // TODO: definir excepciones BadRequest/NotFound si se desea
}
