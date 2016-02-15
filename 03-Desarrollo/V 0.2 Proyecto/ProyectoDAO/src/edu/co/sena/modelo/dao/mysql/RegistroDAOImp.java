/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.modelo.dao.mysql;

import edu.co.sena.modelo.dao.RegistroDAO;
import edu.co.sena.modelo.dto.Registro;
import edu.co.sena.modelo.dto.RegistroPK;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class RegistroDAOImp implements RegistroDAO {

    Connection connexion = null;

    private final String SQL_SELLEC_ALL = "select * from "
            + getTableName() + ";";
    private final String SQL_INSERT = "insert into " + getTableName()
            + " values(?,?,?,?,?,?,?);";
    private final String SQL_UPDATE = "update " + getTableName() + "\n"
            + "set\n"
            + "fecha_entrada = ?,\n"
            + "fecha_salida = ?,\n"
            + "cuenta_numero_documento = ?,\n"
            + "cuenta_tipo_documento = ?,\n"
            + "visita = ?,\n"
            + "rol_visita = ?\n"
            + "where numero_registro = ?;";

    private final String SQL_UPDATE_PK = "update " + getTableName() + "\n"
            + "set\n"
            + "numero_registro  =  ?\n"
            + "where numero_registro = ?;";

    private final String SQL_DELETE_PK = "delete from " + getTableName() + "\n"
            + "where numero_registro = ?;";
    private final String SQL_SELECT_PK = "select * from " + getTableName() + "\n"
            + "where numero_registro = ?;";
    private final String SQL_SELECT_COUNT = "select count(*) from " + getTableName() + " ;";

    @Override
    public List<Registro> findAll() {
        Connection connect = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        List<Registro> usuarios = new ArrayList<>();
        final boolean estaConectado = (connexion != null);
        Registro registro;

        try {

            if (estaConectado) {
                connect = connexion;
            } else {
                connect = ResourceManager.getConnection();
            }

            sentencia = connect.prepareStatement(SQL_SELLEC_ALL);
            resultado = sentencia.executeQuery();

            if (!resultado.wasNull()) {
                while (resultado.next()) {
                    int index = 1;
                    registro = new Registro();
                    registro.setNumeroRegistro(resultado.getInt(index++));
                    registro.setFechaEntrada(resultado.getTimestamp(index++));
                    registro.setFechaSalida(resultado.getTimestamp(index++));
                    registro.setCuentaNumeroDocumento(resultado.getString(index++));
                    registro.setCuentaTipoDocumento(resultado.getString(index++));
                    registro.setVisita(resultado.getString(index++));
                    registro.setRolVisita(resultado.getString(index++));
             
                    usuarios.add(registro);
                }

            }

        } catch (SQLException e) {
            System.out.println("Error ! [FindAll] : " + e.getMessage());
        } finally {
            ResourceManager.close(connect);
            ResourceManager.close(sentencia);
            ResourceManager.close(resultado);

        }
        return usuarios;
    }

    @Override
    public String getTableName() {
    return "registro";
    }

    @Override
    public void insert(Registro reg) {

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
            sentencia.setInt(index++, reg.getNumeroRegistro());
            sentencia.setTimestamp(index++, reg.getFechaEntrada());
            sentencia.setTimestamp(index++, reg.getFechaSalida());
            sentencia.setString(index++, reg.getCuentaNumeroDocumento());
            sentencia.setString(index++, reg.getCuentaTipoDocumento());
            sentencia.setString(index++, reg.getVisita());
            sentencia.setString(index++, reg.getRolVisita());
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
    public void update(RegistroPK rePK, Registro reg) {
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
            
            sentencia.setTimestamp(index++, reg.getFechaEntrada());
            sentencia.setTimestamp(index++, reg.getFechaSalida());
            sentencia.setString(index++, reg.getCuentaNumeroDocumento());
            sentencia.setString(index++, reg.getCuentaTipoDocumento());
            sentencia.setString(index++, reg.getVisita());
            sentencia.setString(index++, reg.getRolVisita());
           
            sentencia.setInt(index++, rePK.getNumeroRegistro());

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
    public void updatePK(RegistroPK rePKViejo, RegistroPK regPKNuevo) {
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
            sentencia.setInt(index++, regPKNuevo.getNumeroRegistro());

            sentencia.setInt(index++, rePKViejo.getNumeroRegistro());


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
    public void deleteForPk(RegistroPK rePK) {
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
            sentencia.setInt(index++, rePK.getNumeroRegistro());

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
    public List<Registro> findByPK(RegistroPK rePK) {

        Connection connect = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        final Boolean estaConectado = (connexion != null);
        List<Registro> resultados=new ArrayList<>();
        int index=1;
        
        Registro registro;
        
        try {
            if (estaConectado) {
                connect = connexion;
            } else {
                connect = ResourceManager.getConnection();
            }
            
            sentencia=connect.prepareStatement(SQL_SELECT_PK);
            sentencia.setInt(index++, rePK.getNumeroRegistro());

            resultado=sentencia.executeQuery();
            if (!resultado.wasNull()) {
                while (resultado.next()) { 
                    index = 1;
                    registro = new Registro();
                    registro.setNumeroRegistro(resultado.getInt(index++));
                    registro.setFechaEntrada(resultado.getTimestamp(index++));
                    registro.setFechaSalida(resultado.getTimestamp(index++));
                    registro.setCuentaNumeroDocumento(resultado.getString(index++));
                    registro.setCuentaTipoDocumento(resultado.getString(index++));
                    registro.setVisita(resultado.getString(index++));
                    registro.setRolVisita(resultado.getString(index++));
                    resultados.add(registro);
                    
                }
            }

        } catch (SQLException e) {
            System.out.println("Error [FindByPK]: " + e.toString());
        } finally {
            ResourceManager.close(resultado);
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
