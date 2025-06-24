package com.empresa.inventario.controller;

import com.empresa.inventario.model.entities.DetalleVenta;
import com.empresa.inventario.model.service.IDetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalles-venta")
@CrossOrigin(origins = "*")
public class DetalleVentaRestController {

    @Autowired
    private IDetalleVentaService detalleVentaService;

    @GetMapping
    public List<DetalleVenta> listarTodas() {
        return detalleVentaService.findAll();
    }

    @GetMapping("/{id}")
    public DetalleVenta buscarPorId(@PathVariable Long id) {
        return detalleVentaService.findById(id);
    }

    @PostMapping
    public DetalleVenta guardar(@RequestBody DetalleVenta detalleVenta) {
        return detalleVentaService.save(detalleVenta);
    }

    @PutMapping("/{id}")
    public DetalleVenta editar(@PathVariable Long id, @RequestBody DetalleVenta detalleVenta) {
        DetalleVenta actual = detalleVentaService.findById(id);
        if (actual != null) {
            actual.setVenta(detalleVenta.getVenta());
            actual.setProducto(detalleVenta.getProducto());
            actual.setCantidad(detalleVenta.getCantidad());
            actual.setPrecioUnitario(detalleVenta.getPrecioUnitario());
            actual.setSubtotal(detalleVenta.getSubtotal());
            return detalleVentaService.save(actual);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        detalleVentaService.delete(id);
    }
}
