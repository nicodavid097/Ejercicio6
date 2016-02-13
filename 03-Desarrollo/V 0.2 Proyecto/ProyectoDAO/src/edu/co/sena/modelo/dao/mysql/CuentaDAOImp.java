/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.modelo.dao.mysql;

import edu.co.sena.modelo.dao.CuentaDAO;
import edu.co.sena.modelo.dto.Cuenta;
import edu.co.sena.modelo.dto.CuentaPK;
import java.sql.Blob;
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

    Connection connexion = null;

    private final String SQL_SELLEC_ALL = "select * from " + getTableName() + ";";
    private final String SQL_INSERT = "insert into " + getTableName() + " values(?,?,null,?,?,?,?,?,?,?);";

    @Override
    public List<Cuenta> findAll() {

        final boolean estaConectado = (connexion != null);

        Connection connect = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        List<Cuenta> listaCuenta = new ArrayList<>();

        try {

            if (estaConectado) {
                connect = connexion;
            } else {
                connect = ResourceManager.getConnection();
            }

            sentencia = connect.prepareStatement(SQL_SELLEC_ALL);
            rs = sentencia.executeQuery();

            if (!rs.wasNull()) {
                while (rs.next()) {
                    int index = 1;
                    Cuenta cuenta = new Cuenta();
                    cuenta.setNumeroDocumento(rs.getString((index++)));
                    cuenta.setTipoDocumento(rs.getString((index++)));
                    /*foto*/ cuenta.setFoto(rs.getBlob((index++)));
                    cuenta.setPrimeroNombre(rs.getString((index++)));
                    cuenta.setSegundoNombre(rs.getString((index++)));
                    cuenta.setPrimerApellido(rs.getString((index++)));
                    cuenta.setSegundoApellido(rs.getString((index++)));
                    cuenta.setCargo(rs.getString((index++)));
                    cuenta.setFechaFinalizacion(rs.getDate((index++)));
                    cuenta.setEstado(rs.getBoolean((index++)));

                    listaCuenta.add(cuenta);
                }

            }

        } catch (SQLException e) {
            System.out.println("Error ! [FindAll] : " + e.getMessage());
        } finally {
            ResourceManager.close(connect);
            ResourceManager.close(sentencia);
            ResourceManager.close(rs);

        }
        return listaCuenta;

    }

    @Override
    public String getTableName() {
        return "cuenta";
    }

    @Override
    public void insert(Cuenta cu) {
        Connection connect = null;
        PreparedStatement sentencia = null;
        int resultado;
        int index = 1;

        final boolean estaConectadoh = (connexion != null);

        try {
            if (estaConectadoh) {
                connect = connexion;
            } else {
                connect = ResourceManager.getConnection();
            }
            sentencia = connect.prepareStatement(SQL_INSERT);
            sentencia.setString(index++, cu.getNumeroDocumento());
            sentencia.setString(index++, cu.getTipoDocumento());
            sentencia.setBlob(index, cu.getFoto());
            sentencia.setString(index++, cu.getPrimeroNombre());
            sentencia.setString(index++, cu.getSegundoNombre());
            sentencia.setString(index++, cu.getPrimerApellido());
            sentencia.setString(index++, cu.getSegundoApellido());
            sentencia.setString(index++, cu.getCargo());
            sentencia.setDate(index++, new java.sql.Date(cu.getFechaFinalizacion().getTime()));
            sentencia.setBoolean(index++, cu.getEstado());

            resultado = sentencia.executeUpdate();

            if (resultado == 1) {
                System.out.println("Se agrego Exitosamente");
            }

        } catch (SQLException e) {

            System.out.println("Error [Insert]" + e.toString());
        } finally {

            ResourceManager.close(connect);
            ResourceManager.close(sentencia);

        }

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
