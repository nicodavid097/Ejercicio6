/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.modelo.dto;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author Dxracso
 */
public class RegistroEquipo implements Serializable {

    private Integer numeroRegistro;
    private Timestamp fechaEntrada;
    private String equipoIdEquipo;
    private Timestamp fechaSalida;

    public Integer getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(Integer numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }


    public String getEquipoIdEquipo() {
        return equipoIdEquipo;
    }

    public void setEquipoIdEquipo(String equipoIdEquipo) {
        this.equipoIdEquipo = equipoIdEquipo;
    }

    public Timestamp getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Timestamp fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Timestamp getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Timestamp fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    @Override
    public String toString() {
        return "RegistroEquipo{" + "numeroRegistro=" + numeroRegistro + ", fechaEntrada=" + fechaEntrada + ", equipoIdEquipo=" + equipoIdEquipo + ", fechaSalida=" + fechaSalida + '}';
    }

 
    

}
