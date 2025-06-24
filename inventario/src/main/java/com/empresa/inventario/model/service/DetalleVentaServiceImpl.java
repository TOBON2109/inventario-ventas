package com.empresa.inventario.model.service;

import com.empresa.inventario.model.dao.DetalleVentaDao;
import com.empresa.inventario.model.entities.DetalleVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleVentaServiceImpl implements IDetalleVentaService {

    @Autowired
    private DetalleVentaDao detalleVentaDao;

    @Override
    public List<DetalleVenta> findAll() {
        return (List<DetalleVenta>) detalleVentaDao.findAll();
    }

    @Override
    public DetalleVenta findById(Long id) {
        return detalleVentaDao.findById(id).orElse(null);
    }

    @Override
    public DetalleVenta save(DetalleVenta detalleVenta) {
        return detalleVentaDao.save(detalleVenta);
    }

    @Override
    public void delete(Long id) {
        detalleVentaDao.deleteById(id);
    }
}
