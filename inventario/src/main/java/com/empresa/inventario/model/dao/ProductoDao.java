package com.empresa.inventario.model.dao;

import com.empresa.inventario.model.entities.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoDao extends CrudRepository<Producto, Long> {
}

