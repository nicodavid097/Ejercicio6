/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.modelo.dto;

/**
 *
 * @author Usuario
 */
public class EquipoPK {
 private String idEquipo;

    public EquipoPK(String idEquipo) {
        this.idEquipo = idEquipo;
    }
 

    public String getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(String idEquipo) {
        this.idEquipo = idEquipo;
    }

    @Override
    public String toString() {
        return "EquipoPK " + "idEquipo=" + idEquipo ;
    }
 
    
}
