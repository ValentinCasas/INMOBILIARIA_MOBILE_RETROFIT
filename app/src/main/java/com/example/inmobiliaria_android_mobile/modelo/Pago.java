package com.example.inmobiliaria_android_mobile.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class Pago implements Serializable {

    private int id;
    private int idContrato;
    private Contrato contrato;
    private int numDePago;
    private String fechaDePago;
    private double importe;

    public Pago() {
    }

    public Pago(int id, int idContrato, Contrato contrato, int numDePago, String fechaDePago, double importe) {
        this.id = id;
        this.idContrato = idContrato;
        this.contrato = contrato;
        this.numDePago = numDePago;
        this.fechaDePago = fechaDePago;
        this.importe = importe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public int getNumDePago() {
        return numDePago;
    }

    public void setNumDePago(int numDePago) {
        this.numDePago = numDePago;
    }

    public String getFechaDePago() {
        return fechaDePago;
    }

    public void setFechaDePago(String fechaDePago) {
        this.fechaDePago = fechaDePago;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
}
