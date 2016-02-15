/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.entryindex.modelo;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author 961256G2
 */
public class Cuenta {
    private String tipoDocumento;
    private String numeroDocumento;
    private byte[] foto;
    private String primerNombre;
    private String segundoNombre;
    private String primerapellido;
    private String segundoApellido;
    private String cargo;
    private Date FechaFinalizacion;
    private Boolean Estado;
    
    private List<Registro> registros;
    private List<RegistroEquipo> registroEquipos;

    public Cuenta() {
        this.Estado = true;
    }
    
    
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerapellido() {
        return primerapellido;
    }

    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getFechaFinalizacion() {
        return FechaFinalizacion;
    }

    public void setFechaFinalizacion(Date FechaFinalizacion) {
        this.FechaFinalizacion = FechaFinalizacion;
    }

    public Boolean getEstado() {
        return Estado;
    }

    public void setEstado(Boolean Estado) {
        this.Estado = Estado;
        
    }

    public List<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }


    public List<RegistroEquipo> getRegistroEquipos() {
        return registroEquipos;
    }

    public void setRegistroEquipos(List<RegistroEquipo> registroEquipos) {
        this.registroEquipos = registroEquipos;
    }

    
}
