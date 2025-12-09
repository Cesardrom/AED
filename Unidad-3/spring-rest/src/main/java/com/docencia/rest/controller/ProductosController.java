package com.docencia.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docencia.rest.model.ProductoEntity;
import com.docencia.rest.service.ProductoServiceInterface;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/productos")
@Tag(name = "Productos", description = "Operaciones sobre productos")
public class ProductosController {
    private ProductoServiceInterface productoService;

    @Autowired
    public void setProductoService(ProductoServiceInterface productoService) {
        this.productoService = productoService;
    }

    @Operation(summary = "Get all productos")
    @GetMapping("")
    public List<ProductoEntity> getAllProductos() {
        return productoService.findAll();
    }

    @Operation(summary = "Get productos by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Producto not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ProductoEntity> getUserById(@PathVariable(value = "id") Integer productoId) {
        ProductoEntity producto = productoService.findById(productoId).orElse(null);
        if (producto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(producto);
    }

    @Operation(summary = "Insert producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @PostMapping("")
    public ProductoEntity createProducto(@Valid @RequestBody ProductoEntity producto) {
        return productoService.save(producto);
    }

    @Operation(summary = "Update producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto updated successfully"),
            @ApiResponse(responseCode = "404", description = "Producto not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ProductoEntity> updateProducto(@PathVariable(value = "id") int productoId, @Valid @RequestBody ProductoEntity producto) {
        final ProductoEntity updatedProducto = productoService.save(producto);
        return ResponseEntity.ok(updatedProducto);
    }

    @Operation(summary = "Delete producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Producto not found")
    })
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteProducto(@PathVariable(value = "id") int productoId) {
        productoService.deleteById(productoId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
