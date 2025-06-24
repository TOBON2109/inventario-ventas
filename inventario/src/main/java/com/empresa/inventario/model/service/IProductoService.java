package com.empresa.inventario.model.service;

import com.empresa.inventario.model.entities.Producto;
import java.util.List;

public interface IProductoService {
    List<Producto> findAll();
    Producto findById(Long id);
    Producto save(Producto producto);
    void delete(Long id);
}

