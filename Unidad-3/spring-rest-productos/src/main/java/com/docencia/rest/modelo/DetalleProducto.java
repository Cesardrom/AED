package com.docencia.rest.modelo;

import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document(collection = "producto_detalle")
public class DetalleProducto {
    @Id
    private String id;
    private int productoId;
    private String descripcionLarga;
    private Map<String, String> especificacionesTecnicas;
    private List<String> tags;
}
