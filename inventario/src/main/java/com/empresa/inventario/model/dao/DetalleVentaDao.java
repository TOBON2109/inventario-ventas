package com.empresa.inventario.model.dao;

import com.empresa.inventario.model.entities.DetalleVenta;
import org.springframework.data.repository.CrudRepository;

public interface DetalleVentaDao extends CrudRepository<DetalleVenta, Long> {
}
