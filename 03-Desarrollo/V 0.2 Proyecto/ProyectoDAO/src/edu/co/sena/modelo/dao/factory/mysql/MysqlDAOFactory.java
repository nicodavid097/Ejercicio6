/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.modelo.dao.factory.mysql;

import edu.co.sena.modelo.dao.CuentaDAO;
import edu.co.sena.modelo.dao.EquipoDAO;
import edu.co.sena.modelo.dao.PropietarioDAO;
import edu.co.sena.modelo.dao.RegistroDAO;
import edu.co.sena.modelo.dao.RegistroEquipoDAO;
import edu.co.sena.modelo.dao.UsuarioDAO;
import edu.co.sena.modelo.dao.factory.DAOFactory;
import edu.co.sena.modelo.dao.mysql.CuentaDAOImp;
import edu.co.sena.modelo.dao.mysql.EquipoDAOImp;
import edu.co.sena.modelo.dao.mysql.PropietarioDAOImp;
import edu.co.sena.modelo.dao.mysql.RegistroDAOImp;
import edu.co.sena.modelo.dao.mysql.RegistroEquipoDAOImp;
import edu.co.sena.modelo.dao.mysql.UsuarioDAOImp;

/**
 *
 * @author Usuario
 */
public class MysqlDAOFactory implements DAOFactory{

    @Override
    public UsuarioDAO creaUsuario() {
    return new UsuarioDAOImp();
            }

    @Override
    public RegistroEquipoDAO crearRegistroEquipo() {
    return new RegistroEquipoDAOImp();
    }

    @Override
    public RegistroDAO crearRegistro() {
    return new RegistroDAOImp();
    }

    @Override
    public PropietarioDAO crearPropietario() {
    return  new PropietarioDAOImp();
    }

    @Override
    public CuentaDAO crearCuenta() {
    return new CuentaDAOImp();
    }

    @Override
    public EquipoDAO crearEquipo() {
    return new EquipoDAOImp();
    }
    
}
