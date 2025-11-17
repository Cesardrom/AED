package com.docencia.ficheros.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.Objects;

/**
 * Clase note para que almacene informacion
 * 
 * @author DavidRiccio
 * @version 1.0.0
 */

public class Note {
    @NotBlank
    private String id;

    @NotBlank
    @Size(max = 200)
    private String title;

    @NotBlank
    private String content;
    public Note(){

    }
    public Note(String id){
        this.id = id;
        
    }

    /* Construcor por defecto */
    /**Constructor con parametros
     * @param id Identificador
     * @param title Titulo
     * @param content Contenido
     */
    public Note(String id, String title, String content) {
        this.id = id;
        this.title= title;
        this.content= content;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Note)) {
            return false;
        }
        Note note = (Note) o;
        return Objects.equals(id, note.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
