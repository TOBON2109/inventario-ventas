package com.empresa.inventario.model.service;

import com.empresa.inventario.model.entities.DetalleVenta;
import java.util.List;

public interface IDetalleVentaService {
    List<DetalleVenta> findAll();
    DetalleVenta findById(Long id);
    DetalleVenta save(DetalleVenta detalleVenta);
    void delete(Long id);
}
