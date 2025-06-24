package com.empresa.inventario.controller;

import com.empresa.inventario.model.entities.Cliente;
import com.empresa.inventario.model.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*") // Permite peticiones desde cualquier frontend
public class ClienteRestController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping
    public List<Cliente> listarTodos() {
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable Long id) {
        return clienteService.findById(id);
    }

    @PostMapping
    public Cliente guardar(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @PutMapping("/{id}")
    public Cliente editar(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente actual = clienteService.findById(id);
        if (actual != null) {
            actual.setNombre(cliente.getNombre());
            actual.setCedula(cliente.getCedula());
            actual.setTelefono(cliente.getTelefono());
            actual.setDireccion(cliente.getDireccion());
            return clienteService.save(actual);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        clienteService.delete(id);
    }
}
