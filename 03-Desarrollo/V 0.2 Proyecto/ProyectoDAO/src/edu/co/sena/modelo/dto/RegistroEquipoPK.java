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


    private String equipoIdEquipo;

    public RegistroEquipoPK(int numeroRegistro, String equipoIdEquipo) {
        this.numeroRegistro = numeroRegistro;
        this.equipoIdEquipo = equipoIdEquipo;
    }

    public int getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(int numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public String getEquipoIdEquipo() {
        return equipoIdEquipo;
    }

    public void setEquipoIdEquipo(String equipoIdEquipo) {
        this.equipoIdEquipo = equipoIdEquipo;
    }

    
}
