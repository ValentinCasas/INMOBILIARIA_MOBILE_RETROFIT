package com.example.inmobiliaria_android_mobile.modelo;

import java.io.Serializable;
import java.util.Objects;

public class Propietario implements Serializable {

    private int id;
    private Long dni;
    private String nombre;
    private String apellido;
    private String usuario;
    private String clave;
    private String telefono;

    public Propietario(){}

    public Propietario(int id, Long dni, String nombre, String apellido, String usuario, String clave, String telefono) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.clave = clave;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String email) {
        this.usuario = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String contraseña) {
        this.clave = contraseña;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Propietario that = (Propietario) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
