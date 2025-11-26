package com.docencia.rest.service.interfaces;

import java.util.Optional;

import com.docencia.rest.modelo.DetalleProducto;
import com.docencia.rest.modelo.Producto;

public interface ProductoRelationalRepository {
    Optional<Producto> findByProductoId(int productoId);
    Producto save(int productoId, DetalleProducto detalle);
    boolean deleteByProductoId(int productoId);
}