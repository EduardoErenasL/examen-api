package com.coppel.examen.models;

import javax.persistence.*;

@Entity
@Table(name = "inventario")
public class InventarioModel {
    @Id
    @Column(unique = true, nullable = false, length = 8)
    private String sku;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "cantidad")
    private Integer cantidad;

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getCantidad() {
        return this.cantidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setSKU(String sku) {
        this.sku = sku;
    }

    public String getSKU() {
        return this.sku;
    }
}
