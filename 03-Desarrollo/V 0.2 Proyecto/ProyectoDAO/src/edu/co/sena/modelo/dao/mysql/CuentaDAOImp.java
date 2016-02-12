/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.modelo.dao.mysql;

import edu.co.sena.modelo.dao.CuentaDAO;
import edu.co.sena.modelo.dto.Cuenta;
import edu.co.sena.modelo.dto.CuentaPK;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class CuentaDAOImp implements CuentaDAO {

    private Connection connec = null;
    Connection conexion = null;
    
    private final String SQL_SELLEC_ALL = "select * from DB_ENTRY_INDEX." + getTableName() + ";";

    @Override
    public List<Cuenta> findAll() {

        final boolean estaConectado = (conexion != null);

        Connection conect = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        List<Cuenta> listaCuenta = new ArrayList<>();

        try {

            if (estaConectado) {
                conect = conexion;
                System.out.println("Se Establecio La Conexion");
            } else {
                conect = ResourceManager.getConnection();
                System.out.println("Se Establecio La Conexion");
            }

            sentencia = conect.prepareStatement(SQL_SELLEC_ALL);
            rs = sentencia.executeQuery();

           
            if (!rs.wasNull()) {
                while (rs.next()) {
                    int index=1;
                    Cuenta cuenta = new Cuenta();
                    
                    cuenta.setNumeroDocumento(rs.getString(1));
                    cuenta.setTipoDocumento(rs.getString(2));
                 /*foto*/   cuenta.setFoto(rs.getBlob(3));
                    cuenta.setPrimeroNombre(rs.getString(4));
                    cuenta.setSegundoNombre(rs.getString(5));
                    cuenta.setPrimerApellido(rs.getString(6));
                    cuenta.setSegundoApellido(rs.getString(7));
                    cuenta.setCargo(rs.getString(8));
                    cuenta.setFechaFinalizacion(rs.getDate(9));
                    cuenta.setEstado(rs.getBoolean(10));
                  
                    listaCuenta.add(cuenta);
                }
               
            }

        } catch (SQLException e) {
            System.out.println("Error ! [FindAll] : " + e.getMessage());
        } finally {
            ResourceManager.close(rs);
            System.out.println("Se Cerro El ResulSet");
            ResourceManager.close(sentencia);
            System.out.println("Se Cerro La Sentencia");
            if (!estaConectado) {
                ResourceManager.close(conect);
                System.out.println("Se Cerro La Conexion");
            }
        }
        return listaCuenta;

    }

    
    @Override
    public String getTableName() {

        return "cuenta";
    }

    @Override
    public void insert(Cuenta cu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(CuentaPK cuepk, Cuenta cu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updatepk(CuentaPK cuViejo, CuentaPK cuNuevo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteForPk(CuentaPK cuepk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cuenta> findByPK(CuentaPK cuePK) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int count() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
