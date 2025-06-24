package com.empresa.inventario.model.dao;

import com.empresa.inventario.model.entities.Venta;
import org.springframework.data.repository.CrudRepository;

public interface VentaDao extends CrudRepository<Venta, Long> {
}
