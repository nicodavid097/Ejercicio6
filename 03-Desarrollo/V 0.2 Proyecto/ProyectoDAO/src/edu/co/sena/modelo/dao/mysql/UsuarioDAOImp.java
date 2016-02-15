/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.modelo.dao.mysql;

import edu.co.sena.modelo.dao.UsuarioDAO;
import edu.co.sena.modelo.dto.Usuario;
import edu.co.sena.modelo.dto.UsuarioPK;
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
public class UsuarioDAOImp implements UsuarioDAO {

    Connection connexion = null;

    private final String SQL_SELLEC_ALL = "select * from "
            + getTableName() + ";";
    private final String SQL_INSERT = "insert into " + getTableName()
            + " values(?,?,?,?,?,?);";
    private final String SQL_UPDATE = "update " + getTableName() + "\n"
            + "set\n"
            + "contrasena = ?,\n"
            + "roll = ?,\n"
            + "cuenta_numero_documento = ?,\n"
            + "cuenta_tipo_documento = ?,\n"
            + "activo = ?\n"
            + "where correo_electronico = ?;";


    private final String SQL_UPDATE_PK = "update " + getTableName() + "\n"
            + "set\n"
            + "correo_electronico = ?\n"
            + "where correo_electronico = ?;";

    private final String SQL_DELETE_PK = "delete from " + getTableName() + "\n"
            + "where correo_electronico = ?;";
    private final String SQL_SELECT_PK = "select * from " + getTableName() + "\n"
            + " where correo_electronico like ?;";
    private final String SQL_SELECT_COUNT = "select count(*) from " + getTableName() + " ;";

    @Override
    public List<Usuario> findAll() {
        Connection connect = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        List<Usuario> usuarios = new ArrayList<>();
        final boolean estaConectado = (connexion != null);
        Usuario usuario;

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
                    usuario = new Usuario();
                    usuario.setCorreoElectronico(resultado.getString(index++));
                    usuario.setContrasena(resultado.getString(index++));
                    usuario.setRoll(resultado.getString(index++));
                    usuario.setCuentaNumeroDocumento(resultado.getString(index++));
                    usuario.setCuentaTipoDocumento(resultado.getString(index++));
                    usuario.setActivo(resultado.getBoolean(index++));
             
                    usuarios.add(usuario);
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
        return "usuario";
    }

    @Override
    public void insert(Usuario user) {
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
            sentencia.setString(index++, user.getCorreoElectronico());
            sentencia.setString(index++, user.getContrasena());
            sentencia.setString(index++, user.getRoll());
            sentencia.setString(index++, user.getCuentaNumeroDocumento());
            sentencia.setString(index++, user.getCuentaTipoDocumento());
            sentencia.setBoolean(index++, user.getActivo());
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
    public void update(UsuarioPK userpk, Usuario user) {
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
            sentencia.setString(index++, user.getContrasena());
            sentencia.setString(index++, user.getRoll());
            sentencia.setString(index++, user.getCuentaNumeroDocumento());
            sentencia.setString(index++, user.getCuentaTipoDocumento());
            sentencia.setBoolean(index++, user.getActivo());
           
            sentencia.setString(index++, userpk.getCorreoElectronico());


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
    public void updatePK(UsuarioPK userViejo, UsuarioPK userNuevo) {
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
            sentencia.setString(index++, userNuevo.getCorreoElectronico());

            sentencia.setString(index++, userViejo.getCorreoElectronico());


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
    public void deleteForPk(UsuarioPK user) {
        
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
            sentencia.setString(index++, user.getCorreoElectronico());

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
    public List<Usuario> findByPK(UsuarioPK user) {
        Connection connect = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        final Boolean estaConectado = (connexion != null);
        List<Usuario> resultados=new ArrayList<>();
        int index=1;
        
        Usuario usuario;
        
        try {
            if (estaConectado) {
                connect = connexion;
            } else {
                connect = ResourceManager.getConnection();
            }
            
            sentencia=connect.prepareStatement(SQL_SELECT_PK);
            sentencia.setString(index++, "%"+user.getCorreoElectronico()+"%");

            rs=sentencia.executeQuery();
            if (!rs.wasNull()) {
                while (rs.next()) { 
                    index=1;
                    
                    usuario = new Usuario();
                    usuario.setCorreoElectronico(rs.getString(index++));
                    usuario.setContrasena(rs.getString(index++));
                    usuario.setRoll(rs.getString(index++));
                    usuario.setCuentaNumeroDocumento(rs.getString(index++));
                    usuario.setCuentaTipoDocumento(rs.getString(index++));
                    usuario.setActivo(rs.getBoolean(index++));
             
                    resultados.add(usuario);
                    
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
