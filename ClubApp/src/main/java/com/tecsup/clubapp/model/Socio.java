/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecsup.clubapp.model;

/**
 *
 * @author LAB704-00
 */
public class Socio {
    private long id;
    private String email;
    private String nombres;
    private String paterno;
    private String materno;
    private String celular;
    private String sexo;
    private String direccion;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Socio(long id, String email, String nombres, String paterno, String materno, String celular, String sexo, String direccion) {
        this.id = id;
        this.email = email;
        this.nombres = nombres;
        this.paterno = paterno;
        this.materno = materno;
        this.celular = celular;
        this.sexo = sexo;
        this.direccion = direccion;
    }
    
    
}
