package com.empresa.inventario.model.service;

import com.empresa.inventario.model.entities.Cliente;
import java.util.List;

public interface IClienteService {
    List<Cliente> findAll();
    Cliente findById(Long id);
    Cliente save(Cliente cliente);
    void delete(Long id);
}
