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
public class PropietarioPK {

    private String equipoIdEquipo;
    private String cuentaNumeroDocumento;
    private String cuentaTipoDocumento;

    public PropietarioPK(String equipoIdEquipo, String cuentaNumeroDocumento, 
            String cuentaTipoDocumento) {
        this.equipoIdEquipo = equipoIdEquipo;
        this.cuentaNumeroDocumento = cuentaNumeroDocumento;
        this.cuentaTipoDocumento = cuentaTipoDocumento;
    }

    public String getEquipoIdEquipo() {
        return equipoIdEquipo;
    }

    public void setEquipoIdEquipo(String equipoIdEquipo) {
        this.equipoIdEquipo = equipoIdEquipo;
    }

    public String getCuentaNumeroDocumento() {
        return cuentaNumeroDocumento;
    }

    public void setCuentaNumeroDocumento(String cuentaNumeroDocumento) {
        this.cuentaNumeroDocumento = cuentaNumeroDocumento;
    }

    public String getCuentaTipoDocumento() {
        return cuentaTipoDocumento;
    }

    public void setCuentaTipoDocumento(String cuentaTipoDocumento) {
        this.cuentaTipoDocumento = cuentaTipoDocumento;
    }

    @Override
    public String toString() {
        return "PropietarioPK{" + "equipoIdEquipo=" + equipoIdEquipo + ", cuentaNumeroDocumento=" + cuentaNumeroDocumento + ", cuentaTipoDocumento=" + cuentaTipoDocumento + '}';
    }

}
