/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecsup.clubapp.model;

/**
 *
 * @author LAB704-00
 */
public class Local {
    private long id;
    private String direccion;
    private String descripcion;
    private int estado;
    private String maps;
    private String telefono;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getMaps() {
        return maps;
    }

    public void setMaps(String maps) {
        this.maps = maps;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Local(long id, String direccion, String descripcion, int estado, String maps, String telefono) {
        this.id = id;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.estado = estado;
        this.maps = maps;
        this.telefono = telefono;
    }

    public Local() {
    }
    
    
}
