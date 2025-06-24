package com.empresa.inventario.model.service;

import com.empresa.inventario.model.dao.VentaDao;
import com.empresa.inventario.model.entities.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaServiceImpl implements IVentaService {

    @Autowired
    private VentaDao ventaDao;

    @Override
    public List<Venta> findAll() {
        return (List<Venta>) ventaDao.findAll();
    }

    @Override
    public Venta findById(Long id) {
        return ventaDao.findById(id).orElse(null);
    }

    @Override
    public Venta save(Venta venta) {
        return ventaDao.save(venta);
    }

    @Override
    public void delete(Long id) {
        ventaDao.deleteById(id);
    }
}

