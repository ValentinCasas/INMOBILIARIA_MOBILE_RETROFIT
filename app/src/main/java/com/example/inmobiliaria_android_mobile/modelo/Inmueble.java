package com.example.inmobiliaria_android_mobile.modelo;

import java.io.Serializable;
import java.util.Objects;

public class Inmueble implements Serializable {

    private int id;
    private int idPropietario;
    private Propietario propietario;
    private String direccion;
    private String uso;
    private String tipo;
    private int cantidadAmbientes;
    private String coordenadas;
    private double precioInmueble;
    private String estado;
    //private String imagen;


    public Inmueble(int id, int idPropietario, Propietario propietario, String direccion, String uso, String tipo, int cantidadAmbientes, String coordenadas, double precioInmueble, String estado) {
        this.id = id;
        this.idPropietario = idPropietario;
        this.propietario = propietario;
        this.direccion = direccion;
        this.uso = uso;
        this.tipo = tipo;
        this.cantidadAmbientes = cantidadAmbientes;
        this.coordenadas = coordenadas;
        this.precioInmueble = precioInmueble;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidadAmbientes() {
        return cantidadAmbientes;
    }

    public void setCantidadAmbientes(int cantidadAmbientes) {
        this.cantidadAmbientes = cantidadAmbientes;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    public double getPrecioInmueble() {
        return precioInmueble;
    }

    public void setPrecioInmueble(double precioInmueble) {
        this.precioInmueble = precioInmueble;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inmueble inmueble = (Inmueble) o;
        return id == inmueble.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
