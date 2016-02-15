/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.entryindex.modelo;

/**
 *
 * @author 961256G2
 */
public class Equipo {
    
    private String IdEquipo;
    private String Descripcion;
    private Boolean Estado;

   

    public String getIdEquipo() {
        return IdEquipo;
    }

    public void setIdEquipo(String Equipo) {
        this.IdEquipo = IdEquipo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Boolean getEstado() {
        return Estado;
    }

    public void setEstado(Boolean Estado) {
        this.Estado = Estado;
    }

    
    
}
