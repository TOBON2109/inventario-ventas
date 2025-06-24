package com.empresa.inventario.controller;

import com.empresa.inventario.model.entities.Producto;
import com.empresa.inventario.model.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class ProductoRestController {

    @Autowired
    private IProductoService productoService;

    @GetMapping
    public List<Producto> listarTodos() {
        return productoService.findAll();
    }

    @GetMapping("/{id}")
    public Producto buscarPorId(@PathVariable Long id) {
        return productoService.findById(id);
    }

    @PostMapping
    public Producto guardar(@RequestBody Producto producto) {
        return productoService.save(producto);
    }

    @PutMapping("/{id}")
    public Producto editar(@PathVariable Long id, @RequestBody Producto producto) {
        Producto actual = productoService.findById(id);
        if (actual != null) {
            actual.setNombre(producto.getNombre());
            actual.setPrecio(producto.getPrecio());
            actual.setStock(producto.getStock());
            return productoService.save(actual);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        productoService.delete(id);
    }
}
