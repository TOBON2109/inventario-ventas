package com.empresa.inventario.model.service;

import com.empresa.inventario.model.entities.Venta;
import java.util.List;

public interface IVentaService {
    List<Venta> findAll();
    Venta findById(Long id);
    Venta save(Venta venta);
    void delete(Long id);
}
