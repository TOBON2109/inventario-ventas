package com.empresa.inventario.model.dao;

import com.empresa.inventario.model.entities.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Cliente, Long> {
}
