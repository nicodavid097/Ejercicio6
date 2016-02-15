/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.modelo.dto;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Dxracso
 */
public class RegistroEquipo implements Serializable {

    private Integer numeroRegistro;
    private String fechaEntrada;
    private Integer equipoIdEquipo;
    private String fechaSalida;

    public Integer getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(Integer numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Integer getEquipoIdEquipo() {
        return equipoIdEquipo;
    }

    public void setEquipoIdEquipo(Integer equipoIdEquipo) {
        this.equipoIdEquipo = equipoIdEquipo;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    
    

}
