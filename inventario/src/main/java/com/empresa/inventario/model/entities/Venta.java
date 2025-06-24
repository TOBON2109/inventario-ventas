package com.empresa.inventario.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "venta")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonIgnoreProperties({"ventas"}) // Evita problemas si Cliente tiene una lista de ventas
    private Cliente cliente;

    private LocalDateTime fecha;

    private Double total;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"venta"}) // Evita recursión en detalles
    private List<DetalleVenta> detalles;

    public Venta() {}

    public Venta(Long id, Cliente cliente, LocalDateTime fecha, Double total, List<DetalleVenta> detalles) {
        this.id = id;
        this.cliente = cliente;
        this.fecha = fecha;
        this.total = total;
        this.detalles = detalles;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }

    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }

    public List<DetalleVenta> getDetalles() { return detalles; }
    public void setDetalles(List<DetalleVenta> detalles) { this.detalles = detalles; }
}
