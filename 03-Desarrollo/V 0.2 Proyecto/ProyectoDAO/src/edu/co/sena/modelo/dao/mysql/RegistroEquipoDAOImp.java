/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.modelo.dao.mysql;

import edu.co.sena.modelo.dao.RegistroEquipoDAO;
import edu.co.sena.modelo.dto.RegistroEquipo;
import edu.co.sena.modelo.dto.RegistroEquipoPK;
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
public class RegistroEquipoDAOImp implements RegistroEquipoDAO{

  
    Connection conexion = null;
    private final String SQL_SELECT_ALL = "select * from DB_ENTRY_INDEX." + getTableName() + ";";

    @Override
    public List<RegistroEquipo> findAll() {
        final String SQL = SQL_SELECT_ALL;

        final boolean estaConectado = (conexion != null);

        Connection conect = null;

        PreparedStatement sentencia = null;

        ResultSet resultado = null;

        List<RegistroEquipo> listaRegistroEquipo = new ArrayList<>();

        try {
//patron singleton :p

            if (estaConectado) {
                conect = conexion;
                System.out.println("Se Establecio La Conexion");
            } else {
                conect = ResourceManager.getConnection();
                System.out.println("Se Establecio La Conexion");
            }

            sentencia = conect.prepareStatement(SQL);
            resultado = sentencia.executeQuery();

            if (!resultado.wasNull()) {
                while (resultado.next()) {
                    RegistroEquipo registroEquipoObj = new RegistroEquipo();
                    registroEquipoObj.setNumeroRegistro(resultado.getInt(1));
                    registroEquipoObj.setFechaEntrada(resultado.getDate(2).toString() + " " + resultado.getTime(2).toString());
                    registroEquipoObj.setEquipoIdEquipo(resultado.getInt(3));
                    registroEquipoObj.setFechaSalida(resultado.getDate(4).toString() + " " + resultado.getTime(4).toString());
                    listaRegistroEquipo.add(registroEquipoObj);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error ! [FindAll] : " + e.getMessage());
        } finally {
            ResourceManager.close(resultado);
            System.out.println("Se Cerro El ResulSet");
            ResourceManager.close(sentencia);
            System.out.println("Se Cerro La Sentencia");
            if (!estaConectado) {
                ResourceManager.close(conect);
                System.out.println("Se Cerro La Conexion");
            }
        }
        return listaRegistroEquipo;
    }

    private final String SQL_INSERT = "insert into DB_ENTRY_INDEX." + getTableName() + " values (?,?,?,?);";

    @Override
    public void insert(RegistroEquipo re) {
        final String SQL = SQL_INSERT;

        final boolean estaConectado = (conexion != null);

        Connection conect = null;

        PreparedStatement sentencia = null;

        int resultado;

        try {
//patron singleton :p

            if (estaConectado) {
                conect = conexion;
                System.out.println("Se Establecio La Conexion");
            } else {
                conect = ResourceManager.getConnection();
                System.out.println("Se Establecio La Conexion");
            }

            sentencia = conect.prepareStatement(SQL);
            sentencia.setInt(1, re.getNumeroRegistro());
            sentencia.setString(2, re.getFechaEntrada());
            sentencia.setInt(3, re.getEquipoIdEquipo());
            sentencia.setString(4, re.getFechaSalida());

            resultado = sentencia.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error ! [Insert] : " + e.getMessage());
        } finally {
            ResourceManager.close(sentencia);
            System.out.println("Se Cerro La Sentencia");
            if (!estaConectado) {
                ResourceManager.close(conect);
                System.out.println("Se Cerro La Conexion");
            }
        }
    }

    private final String SQL_UPDATE = "update db_entry_index." + getTableName() + " set numero_registro= ?,equipo_id_equipo= ?  where fecha_entrada = ? ;";

    @Override
    public void update(RegistroEquipoPK rePK, RegistroEquipo re) {
        final String SQL = SQL_INSERT;

        final boolean estaConectado = (conexion != null);

        Connection conect = null;

        PreparedStatement sentencia = null;

        int resultado;

        try {
//patron singleton :p

            if (estaConectado) {
                conect = conexion;
                System.out.println("Se Establecio La Conexion");
            } else {
                conect = ResourceManager.getConnection();
                System.out.println("Se Establecio La Conexion");
            }

            sentencia = conect.prepareStatement(SQL);

            sentencia.setInt(1, re.getNumeroRegistro());

            sentencia.setInt(2, re.getEquipoIdEquipo());

            sentencia.setString(3, rePK.getFechaEntrada());

            resultado = sentencia.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error ! [Update] : " + e.getMessage());
        } finally {
            ResourceManager.close(sentencia);
            System.out.println("Se Cerro La Sentencia");
            if (!estaConectado) {
                ResourceManager.close(conect);
                System.out.println("Se Cerro La Conexion");
            }
        }
    }

    @Override
    public void update(RegistroEquipoPK rePKViejo, RegistroEquipoPK rePKNuevo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteForPk(RegistroEquipoPK rePK) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RegistroEquipo> findByPK(RegistroEquipoPK rePK) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private final String SQL_COUNT = "select count(*) from db_entry_index." + getTableName() + ";";

    @Override
    public int count() {
        final String SQL = SQL_COUNT;

        final boolean estaConectado = (conexion != null);

        Connection conect = null;

        PreparedStatement sentencia = null;

        ResultSet resultado = null;
        int counts = 0;
        try {
//patron singleton :p

            if (estaConectado) {
                conect = conexion;
                System.out.println("Se Establecio La Conexion");
            } else {
                conect = ResourceManager.getConnection();
                System.out.println("Se Establecio La Conexion");
            }

            sentencia = conect.prepareStatement(SQL);
            resultado = sentencia.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    counts = resultado.getInt(1);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error ! [Count] : " + e.getMessage());
        } finally {
            ResourceManager.close(resultado);
            System.out.println("Se Cerro El ResulSet");
            ResourceManager.close(sentencia);
            System.out.println("Se Cerro La Sentencia");
            if (!estaConectado) {
                ResourceManager.close(conect);
                System.out.println("Se Cerro La Conexion");
            }
        }

        return counts;
    }

    @Override
    public String getTableName() {
        return "registro_equipo";
    }
    
}
