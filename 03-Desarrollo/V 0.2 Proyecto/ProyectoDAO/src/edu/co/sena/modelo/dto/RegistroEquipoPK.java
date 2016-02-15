/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.modelo.dto;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Usuario
 */
public class RegistroEquipoPK {
    private int numeroRegistro;
    private String fechaEntrada;
    private Time horaEntrada;
    private String equipoIdEquipo;

    public Time getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Time horaEntrada) {
        this.horaEntrada = horaEntrada;
    }
    

    public RegistroEquipoPK(int numeroRegistro, String fechaEntrada,Time horaEntrada, String equipoIdEquipo) {
        this.numeroRegistro = numeroRegistro;
        this.fechaEntrada = fechaEntrada;
        this.horaEntrada = horaEntrada;
        this.equipoIdEquipo = equipoIdEquipo;
    }

    public int getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(int numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getEquipoIdEquipo() {
        return equipoIdEquipo;
    }

    public void setEquipoIdEquipo(String equipoIdEquipo) {
        this.equipoIdEquipo = equipoIdEquipo;
    }
    
}
