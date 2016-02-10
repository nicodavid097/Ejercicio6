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
public class RegistroPK {
    private int numeroRegistro;

    public RegistroPK(int numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public int getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(int numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    @Override
    public String toString() {
        return "RegistroPK{" + "numeroRegistro=" + numeroRegistro + '}';
    }
    
}
