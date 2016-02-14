/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.modelo.dao.mysql;

import edu.co.sena.modelo.dao.CuentaDAO;
import edu.co.sena.modelo.dto.Cuenta;
import edu.co.sena.modelo.dto.CuentaPK;
import java.math.BigDecimal;
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

    private final String SQL_SELLEC_ALL = "select * from "
            + getTableName() + ";";
    private final String SQL_INSERT = "insert into " + getTableName()
            + " values(?,?,null,?,?,?,?,?,?,?);";
    private final String SQL_UPDATE = "update " + getTableName() + "\n"
            + "set \n"
            + "foto = ?,\n"
            + "primer_nombre =?,\n"
            + "segundo_nombre = ?,\n"
            + "primer_apellido = ?,\n"
            + "segundo_apellido = ?,\n"
            + "cargo = ?,\n"
            + "fecha_finalizacion = ?,\n"
            + "estado = ?\n"
            + "where numero_documento = ? and tipo_documento = ?;";

    private final String SQL_UPDATE_PK = "update " + getTableName() + "\n"
            + "set\n"
            + "numero_documento = ?,\n"
            + "tipo_documento = ?\n"
            + "where numero_documento = ? and tipo_documento = ?;";

    private final String SQL_DELETE_PK = "delete from " + getTableName() + "\n"
            + "where numero_documento = ? and tipo_documento = ?;";
    private final String SQL_SELECT_PK = "select * from "+getTableName()+"\n"
            +" where numero_documento like ? and tipo_documento like ?;";
    private final String SQL_SELECT_COUNT="select count(*) from "+getTableName()+" ;";

    @Override
    public List<Cuenta> findAll() {

        Connection connect = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        List<Cuenta> listaCuenta = new ArrayList<>();
        final boolean estaConectado = (connexion != null);
        Cuenta cuenta;

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
                    cuenta = new Cuenta();
                    cuenta.setNumeroDocumento(rs.getString(index++));
                    cuenta.setTipoDocumento(rs.getString(index++));
                    /*foto*/ cuenta.setFoto(rs.getBlob(index++));
                    cuenta.setPrimeroNombre(rs.getString(index++));
                    cuenta.setSegundoNombre(rs.getString(index++));
                    cuenta.setPrimerApellido(rs.getString(index++));
                    cuenta.setSegundoApellido(rs.getString(index++));
                    cuenta.setCargo(rs.getString(index++));
                    cuenta.setFechaFinalizacion(rs.getDate(index++));
                    cuenta.setEstado(rs.getBoolean(index++));

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
        final boolean estaConectado = (connexion != null);

        try {
            if (estaConectado) {
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

        Connection connect = null;
        PreparedStatement sentencia = null;
        int resultado = 0;
        int index = 1;
        final boolean estaConectado = (connexion != null);

        try {
            if (estaConectado) {
                connect = connexion;
            } else {
                connect = ResourceManager.getConnection();
            }

            sentencia = connect.prepareStatement(SQL_UPDATE);
            sentencia.setBlob(index++, cu.getFoto());
            sentencia.setString(index++, cu.getPrimeroNombre());
            sentencia.setString(index++, cu.getSegundoNombre());
            sentencia.setString(index++, cu.getPrimerApellido());
            sentencia.setString(index++, cu.getSegundoApellido());
            sentencia.setString(index++, cu.getCargo());
            sentencia.setDate(index++, new Date(cu.getFechaFinalizacion().getTime()));
            sentencia.setBoolean(index++, cu.getEstado());

            sentencia.setString(index++, cuepk.getNumeroDocumento());
            sentencia.setString(index++, cuepk.getTipoDocumento());

            resultado = sentencia.executeUpdate();

            if (resultado == 1) {
                System.out.println("Se actualizo correctamente");
            }

        } catch (SQLException e) {
            System.out.println("Error [Update]: " + e.toString());
        } finally {

            ResourceManager.close(connect);
            ResourceManager.close(sentencia);

        }
    }

    @Override
    public void updatepk(CuentaPK cuViejo, CuentaPK cuNuevo) {
        final boolean estaConectado = (connexion != null);
        Connection connect = null;
        PreparedStatement sentencia = null;
        int resultado;
        int index = 1;

        try {
            if (estaConectado) {
                connect = connexion;
            } else {
                connect = ResourceManager.getConnection();
            }

            sentencia = connect.prepareStatement(SQL_UPDATE_PK);
            sentencia.setString(index++, cuNuevo.getNumeroDocumento());
            sentencia.setString(index++, cuNuevo.getTipoDocumento());

            sentencia.setString(index++, cuViejo.getNumeroDocumento());
            sentencia.setString(index++, cuViejo.getTipoDocumento());

            resultado = sentencia.executeUpdate();

            if (resultado == 1) {
                System.out.println("Se actualizo documento exitosamente");
            }

        } catch (SQLException e) {
            System.out.println("Error [UpdatePK]" + e.toString());
        } finally {

            ResourceManager.close(connect);
            ResourceManager.close(sentencia);

        }

    }

    @Override
    public void deleteForPk(CuentaPK cuepk) {

        final Boolean estaConectado = (connexion != null);
        Connection connect = null;
        PreparedStatement sentencia = null;
        int resultado;
        int index = 1;

        try {
            if (estaConectado) {
                connect = connexion;
            } else {
                connect = ResourceManager.getConnection();
            }

            sentencia = connect.prepareStatement(SQL_DELETE_PK);
            sentencia.setString(index++, cuepk.getNumeroDocumento());
            sentencia.setString(index++, cuepk.getTipoDocumento());
            resultado = sentencia.executeUpdate();
            if (resultado == 1) {
                System.out.println("Se elimino satisfactoriamente");

            }

        } catch (SQLException e) {
            System.out.println("Error [Delete]: " + e.toString());
        } finally {
            ResourceManager.close(sentencia);
            ResourceManager.close(connect);
        }

    }

    @Override
    public List<Cuenta> findByPK(CuentaPK cuePK) {
        Connection connect = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        final Boolean estaConectado = (connexion != null);
        List<Cuenta> resultados=new ArrayList<>();
        int index=1;
        
        Cuenta cuenta;
        
        try {
            if (estaConectado) {
                connect = connexion;
            } else {
                connect = ResourceManager.getConnection();
            }
            
            
            sentencia=connect.prepareStatement(SQL_SELECT_PK);
            sentencia.setString(index++, "%"+cuePK.getNumeroDocumento()+"%");
            sentencia.setString(index++, "%"+cuePK.getTipoDocumento()+"%");
            rs=sentencia.executeQuery();
            if (!rs.wasNull()) {
                while (rs.next()) { 
                    index=1;
                    cuenta = new Cuenta();
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

                    resultados.add(cuenta);
                    
                }
            }

        } catch (SQLException e) {
            System.out.println("Error [FindByPK]: " + e.toString());
        } finally {
            ResourceManager.close(rs);
            ResourceManager.close(sentencia);
            ResourceManager.close(connect);
        }
        return resultados;
    }

    @Override
    public int count() {
        Connection connect=null;
        PreparedStatement sentencia=null;
        ResultSet resultado=null;
        
        Boolean estaConectaado=(connexion!=null);
        Integer count=0;
        
        try {
            
            if (estaConectaado) {
                connect=connexion;
            }else{
            connect=ResourceManager.getConnection();
            }
            
            sentencia=connect.prepareStatement(SQL_SELECT_COUNT);
            resultado=sentencia.executeQuery();
            resultado.next();
           count=Integer.parseInt(resultado.getString(1));
           
            
        } catch (SQLException e) {
            System.out.println("Error [Count]: "+e.toString());

        }finally {
            ResourceManager.close(resultado);
            ResourceManager.close(sentencia);
            ResourceManager.close(connect);
        }
        return count;
    }

}
