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
public class UsuarioPK {
    private String correoElectronico;

    public UsuarioPK(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    @Override
    public String toString() {
        return "UsuarioPK{" + "correoElectronico=" + correoElectronico + '}';
    }
    
    
}
