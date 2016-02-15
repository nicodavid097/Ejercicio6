/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.entryindex.modelo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author 961256G2
 */
public class RegistroEquipo {
       
    private Integer registroNumeroRegistro;
    private Integer equipoIdEquipo;
    private String cuentaNumeroDocumento;
    private String cuentaTipoDocumento;
    private Timestamp fechaEntrada;
    private Timestamp fechaSalida;
    private List<Registro> registro;
    
    
    private List<Equipo>  equipo;

  
    
    public RegistroEquipo(){
         registro = new ArrayList<>();
         equipo = new ArrayList<>();
    }

    public List<Registro> getRegistro() {
        return registro;
    }

    public void setRegistro(List<Registro> registro) {
        this.registro = registro;
    }

    public List<Equipo> getEquipo() {
        return equipo;
    }

    public void setEquipo(List<Equipo> equipo) {
        this.equipo = equipo;
    }
    

    public Integer getRegistroNumeroRegistro() {
        return registroNumeroRegistro;
    }

    public void setRegistroNumeroRegistro(Integer registroNumeroRegistro) {
        this.registroNumeroRegistro = registroNumeroRegistro;
    }

    public Integer getEquipoIdEquipo() {
        return equipoIdEquipo;
    }

    public void setEquipoIdEquipo(Integer equipoIdEquipo) {
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
    
    
}
