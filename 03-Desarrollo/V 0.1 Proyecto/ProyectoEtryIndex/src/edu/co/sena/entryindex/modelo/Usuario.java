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
public class Usuario {


    private String correoElectronico;
    private String Contrasena;
    private String CuentaTipoDocumento;
    private String CuentaNumeroDocumento;
    private Boolean Estado;
    private Cuenta cuenta;

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    

    public Usuario() {

    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public String getCuentaTipoDocumento() {
        return CuentaTipoDocumento;
    }

    public void setCuentaTipoDocumento(String CuentaTipoDocumento) {
        this.CuentaTipoDocumento = CuentaTipoDocumento;
    }

    public String getCuentaNumeroDocumento() {
        return CuentaNumeroDocumento;
    }

    public void setCuentaNumeroDocumento(String CuentaNumeroDocumento) {
        this.CuentaNumeroDocumento = CuentaNumeroDocumento;
    }

    public Boolean getEstado() {
        return Estado;
    }

    public void setEstado(Boolean Estado) {
        this.Estado = Estado;
    }
    
    
}
