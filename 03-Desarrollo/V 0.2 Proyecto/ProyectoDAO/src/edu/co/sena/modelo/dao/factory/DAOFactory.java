/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.modelo.dao.factory;

import edu.co.sena.modelo.dao.CuentaDAO;
import edu.co.sena.modelo.dao.EquipoDAO;
import edu.co.sena.modelo.dao.PropietarioDAO;
import edu.co.sena.modelo.dao.RegistroDAO;
import edu.co.sena.modelo.dao.RegistroEquipoDAO;
import edu.co.sena.modelo.dao.UsuarioDAO;
import edu.co.sena.modelo.dto.Usuario;

/**
 *
 * @author Usuario
 */
public interface DAOFactory {
public UsuarioDAO creaUsuario();  
public RegistroEquipoDAO crearRegistroEquipo();
public RegistroDAO crearRegistro();
public PropietarioDAO crearPropietario();
public CuentaDAO crearCuenta();
public EquipoDAO crearEquipo();
}
