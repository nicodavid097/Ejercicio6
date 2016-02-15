/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.modelo.dao.mysql;

import edu.co.sena.modelo.dao.EquipoDAO;
import edu.co.sena.modelo.dto.Equipo;
import edu.co.sena.modelo.dto.EquipoPK;
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
public class EquipoDAOImp implements EquipoDAO {

    Connection conexion = null;
    private final String SQL_SELECT_ALL = "select * from DB_ENTRY_INDEX." + getTableName() + ";";

    @Override
    public List<Equipo> findAll() {
        final String SQL = SQL_SELECT_ALL;

        final boolean estaConectado = (conexion != null);

        Connection conect = null;

        PreparedStatement sentencia = null;

        ResultSet resultado = null;

        List<Equipo> listaEquipo = new ArrayList<>();

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
                    Equipo equipoObj = new Equipo();
                    equipoObj.setIdEquipo(resultado.getString(1));
                    equipoObj.setDescripcion(resultado.getString(2));
                    equipoObj.setEstado(resultado.getBoolean(3));
                    listaEquipo.add(equipoObj);
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
        return listaEquipo;

    }

    //TODO
    private final String SQL_INSERT = "insert into DB_ENTRY_INDEX." + getTableName() + " values (?,?,?);";

    @Override
    public void insert(Equipo eq) {
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

            sentencia.setString(1, eq.getIdEquipo());
            sentencia.setString(2, eq.getDescripcion());
            sentencia.setBoolean(3, eq.getEstado());

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

    private final String SQL_UPDATE = "update db_entry_index." + getTableName() + " set id_equipo= ?,descripcion= ?,estado= ?  where id_equipo = ? ;";

    @Override
    public void update(EquipoPK equPK, Equipo eq) {

        final String SQL = SQL_UPDATE;

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

            sentencia.setString(1, eq.getIdEquipo());
            sentencia.setString(2, eq.getDescripcion());
            sentencia.setBoolean(3, eq.getEstado());

            sentencia.setString(4, equPK.getIdEquipo());

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

    private final String SQL_UPDATE_PK = "update db_entry_index." + getTableName() + " set id_equipo=? where id_equipo=?;";

    @Override
    public void update(EquipoPK equPKViejo, EquipoPK eqPKNuevo) {

        final String SQL = SQL_UPDATE_PK;

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

            sentencia.setString(1, eqPKNuevo.getIdEquipo());

            sentencia.setString(2, equPKViejo.getIdEquipo());

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

    private final String SQL_DELETE_PK = "delete from db_entry_index." + getTableName() + " where  id_equipo = ?;";

    @Override
    public void deleteForPk(EquipoPK equPK) {
        final String SQL = SQL_DELETE_PK;

        final boolean estaConectado = (conexion != null);

        Connection conect = null;

        PreparedStatement sentencia = null;

        int resultado = 0;

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

            //debe actualizar el estado?
            sentencia.setString(1, equPK.getIdEquipo());
            System.out.println("Se borro");
            resultado = sentencia.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error ! [DeleteForPk] : " + e.getMessage());
        } finally {
            ResourceManager.close(sentencia);
            System.out.println("Se Cerro La Sentencia");
            if (!estaConectado) {
                ResourceManager.close(conect);
                System.out.println("Se Cerro La Conexion");
            }
        }
    }

    private final String SQL_FIND_BY_PK = "select * from db_entry_index. " + getTableName() + " where id_equipo = ?;";

    @Override
    public List<Equipo> findByPK(EquipoPK equPK) {
        final String SQL = SQL_FIND_BY_PK;

        final boolean estaConectado = (conexion != null);

        Connection conect = null;

        PreparedStatement sentencia = null;

        ResultSet resultado = null;

        List<Equipo> listaEquipoByPk = new ArrayList<>();

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

            sentencia.setString(1, equPK.getIdEquipo());

            resultado = sentencia.executeQuery();

            if (resultado != null) {
                while (resultado.next()) {
                    Equipo equi = new Equipo();
                    equi.setIdEquipo(resultado.getString(1));
                    equi.setDescripcion(resultado.getString(2));
                    equi.setEstado(resultado.getBoolean(3));
                    listaEquipoByPk.add(equi);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error ! [FindByPk] : " + e.getMessage());
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
        return listaEquipoByPk;
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
        return "equipo";
    }

}
