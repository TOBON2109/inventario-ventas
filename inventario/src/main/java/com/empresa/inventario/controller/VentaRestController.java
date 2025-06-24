package com.empresa.inventario.controller;

import com.empresa.inventario.model.entities.Venta;
import com.empresa.inventario.model.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
@CrossOrigin(origins = "*")
public class VentaRestController {

    @Autowired
    private IVentaService ventaService;

    @GetMapping
    public List<Venta> listarTodas() {
        return ventaService.findAll();
    }

    @GetMapping("/{id}")
    public Venta buscarPorId(@PathVariable Long id) {
        return ventaService.findById(id);
    }

    @PostMapping
    public Venta guardar(@RequestBody Venta venta) {
        return ventaService.save(venta);
    }

    @PutMapping("/{id}")
    public Venta editar(@PathVariable Long id, @RequestBody Venta venta) {
        Venta actual = ventaService.findById(id);
        if (actual != null) {
            actual.setCliente(venta.getCliente());
            actual.setFecha(venta.getFecha());
            actual.setTotal(venta.getTotal());
            return ventaService.save(actual);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        ventaService.delete(id);
    }
}
