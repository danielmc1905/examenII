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
public class Vendedora implements Serializable{
    private int identificacion;
    private String nombre;
    private String sexo;

    public Vendedora() {
    }

    public Vendedora(int identificacion, String nombre, String sexo) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.sexo = sexo;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Vendedora{" + "identificacion=" + identificacion + ", nombre=" + nombre + ", sexo=" + sexo + '}';
    }
    
    
}
