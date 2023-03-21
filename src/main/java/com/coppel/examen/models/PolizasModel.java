package com.coppel.examen.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "polizas")
public class PolizasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPolizas", unique = true, nullable = false)
    private Long idPolizas;

    @ManyToOne
    @JoinColumn(name = "empleadoGenero")
    private EmpleadoModel empleado;

    @ManyToOne
    @JoinColumn(name = "sku")
    private InventarioModel articulo;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "fecha")
    private Date fecha;

    public Long getIdPolizas() {
        return idPolizas;
    }

    public void setIdPolizas(Long idPolizas) {
        this.idPolizas = idPolizas;
    }

    public EmpleadoModel getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadoModel empleado) {
        this.empleado = empleado;
    }

    public InventarioModel getArticulo() {
        return articulo;
    }

    public void setArticulo(InventarioModel articulo) {
        this.articulo = articulo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
