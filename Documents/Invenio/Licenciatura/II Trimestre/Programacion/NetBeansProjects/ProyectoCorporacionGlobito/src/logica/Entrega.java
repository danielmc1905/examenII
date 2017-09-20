/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.Serializable;

/**
 *
 * @author Gloriana
 */
public class Entrega implements Serializable{
    private int vendedora;
    private int perfume;
    private int cantidad;
    private double precio;
    private double total;
    private String fecha;

    public Entrega() {
    }

    public Entrega(int vendedora, int perfume, int cantidad, double precio, double total, String fecha) {
        this.vendedora = vendedora;
        this.perfume = perfume;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
        this.fecha = fecha;
    }

    public int getVendedora() {
        return vendedora;
    }

    public void setVendedora(int vendedora) {
        this.vendedora = vendedora;
    }

    public int getPerfume() {
        return perfume;
    }

    public void setPerfume(int perfume) {
        this.perfume = perfume;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}
