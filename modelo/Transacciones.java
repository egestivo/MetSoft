/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Estivo
 */
public class Transacciones {
    private String usuario;
    private String tipoTransaccion;
    private Date fecha;
    private String descripcion;
    private double monto;

    // Constructor
    public Transacciones(String usuario, String tipoTransaccion, Date fecha, String descripcion, double monto) {
        this.usuario = usuario;
        this.tipoTransaccion = tipoTransaccion;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.monto = monto;
    }

    // Getters and Setters
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}

