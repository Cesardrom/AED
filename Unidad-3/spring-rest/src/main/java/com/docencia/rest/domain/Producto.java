package com.docencia.rest.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Producto {
    private int id;
    private String nombre;
    private BigDecimal precio;
    private Integer stock;
    private DetalleProducto detallesProducto;

    public Producto() {
    }

    public Producto(int id) {
        this.id = id;
    }

    public Producto(int id, String nombre, BigDecimal precio, Integer stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Producto productoEntity = (Producto) o;
        return id == productoEntity.id && Objects.equals(nombre, productoEntity.nombre) && Objects.equals(precio, productoEntity.precio) && Objects.equals(stock, productoEntity.stock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, precio, stock);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }
}
