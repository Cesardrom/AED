package com.docencia.objetos.domain;
import java.util.Objects;


public class Alumno {
  private Long id;
  private String nombre;
  private String email;
  private String ciclo;

  /**
   * Constructor vacio
   */
  public Alumno() {
  }

  /**
   * Constructor con el id del alumno para busquedas
   * @param id Identificador unico del alumno
   */
  public Alumno(Long id) {
    this.id = id;
  }

  /**
   * Constructor con todas las propiedades del objeto
   * @param id identificador del alumno
   * @param nombre nombre del alumno
   * @param email email del alumno
   * @param ciclo ciclo al que pertence el alumno
   */
  public Alumno(Long id, String nombre, String email, String ciclo) {
    this.id = id;
    this.nombre = nombre;
    this.email = email;
    this.ciclo = ciclo;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCiclo() {
    return this.ciclo;
  }

  public void setCiclo(String ciclo) {
    this.ciclo = ciclo;
  }

  public Alumno id(Long id) {
    setId(id);
    return this;
  }

  public Alumno nombre(String nombre) {
    setNombre(nombre);
    return this;
  }

  public Alumno email(String email) {
    setEmail(email);
    return this;
  }

  public Alumno ciclo(String ciclo) {
    setCiclo(ciclo);
    return this;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Alumno)) {
            return false;
        }
        Alumno alumno = (Alumno) o;
        if (id == null || alumno.getId() == null) {
          return false;
        }
        return Objects.equals(id, alumno.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", nombre='" + getNombre() + "'" +
      ", email='" + getEmail() + "'" +
      ", ciclo='" + getCiclo() + "'" +
      "}";
  }

}
