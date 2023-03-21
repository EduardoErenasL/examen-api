package com.coppel.examen.models;

import javax.persistence.*;

@Entity
@Table(name = "empleado")
public class EmpleadoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEmpleado", unique = true, nullable = false)
    private Long idEmpleado;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "apellido", length = 50)
    private String apellido;

    @Column(name = "puesto", length = 50)
    private String puesto;

    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    public Long getIdEmpleado() {
        return this.idEmpleado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return this.nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getApellido() {
        return this.apellido;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    public String getPuesto() {
        return this.puesto;
    }
}
