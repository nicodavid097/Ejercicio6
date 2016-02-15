/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.modelo.dao.mysql;

import edu.co.sena.modelo.dao.RegistroEquipoDAO;
import edu.co.sena.modelo.dto.Equipo;
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
public class RegistroEquipoDAOImp implements RegistroEquipoDAO {

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
                    registroEquipoObj.setFechaEntrada(resultado.getTimestamp(2));
                    registroEquipoObj.setEquipoIdEquipo(resultado.getString(3));
                    registroEquipoObj.setFechaSalida(resultado.getTimestamp(4));
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
            sentencia.setTimestamp(2, re.getFechaEntrada());
            sentencia.setString(3, re.getEquipoIdEquipo());
            sentencia.setTimestamp(4, re.getFechaSalida());

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

    private final String SQL_UPDATE = "update db_entry_index." + getTableName() + " set   fecha_entrada=?,fecha_salida=?    where   numero_registro= ? and equipo_id_equipo= ?  ;";

    @Override
    public void update(RegistroEquipoPK rePK, RegistroEquipo re) {
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

            sentencia.setTimestamp(1, re.getFechaEntrada());
            sentencia.setTimestamp(2, re.getFechaSalida());

            sentencia.setInt(3, rePK.getNumeroRegistro());
            sentencia.setString(4, rePK.getEquipoIdEquipo());

            resultado = sentencia.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error ! [Update] : " + e.getMessage());
        } finally {
            ResourceManager.close(sentencia);
            System.out.println("Se Cerro La Sentencia.");
            if (!estaConectado) {
                ResourceManager.close(conect);
                System.out.println("Se Cerro La Conexion");
            }
        }
    }

    private final String SQL_UPDATE_PK = "update db_entry_index." + getTableName() + " set   numero_registro= ? ,equipo_id_equipo=?    where   numero_registro= ? and equipo_id_equipo= ?  ;";

    @Override
    public void update(RegistroEquipoPK rePKViejo, RegistroEquipoPK rePKNuevo) {
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

            sentencia.setString(1, rePKNuevo.getEquipoIdEquipo());
            sentencia.setInt(2, rePKNuevo.getNumeroRegistro());

            sentencia.setInt(3, rePKViejo.getNumeroRegistro());
            sentencia.setString(4, rePKViejo.getEquipoIdEquipo());

            resultado = sentencia.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error ! [UpdatePk] : " + e.getMessage());
        } finally {
            ResourceManager.close(sentencia);
            System.out.println("Se Cerro La Sentencia");
            if (!estaConectado) {
                ResourceManager.close(conect);
                System.out.println("Se Cerro La Conexion");
            }
        }
    }

    private final String SQL_DELETE_PK = "delete from db_entry_index." + getTableName() + " where  numero_registro= ? and equipo_id_equipo= ? ;";

    @Override
    public void deleteForPk(RegistroEquipoPK rePK) {
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

            sentencia.setInt(1, rePK.getNumeroRegistro());
            sentencia.setString(2, rePK.getEquipoIdEquipo());

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

    
    private final String SQL_FIND_BY_PK = "select * from db_entry_index. " + getTableName() + " where numero_registro= ? and equipo_id_equipo= ?;";

    @Override
    public List<RegistroEquipo> findByPK(RegistroEquipoPK rePK) {
        final String SQL = SQL_FIND_BY_PK;

        final boolean estaConectado = (conexion != null);

        Connection conect = null;

        PreparedStatement sentencia = null;

        ResultSet resultado = null;

        List<RegistroEquipo> listaEquipoFindByPk = new ArrayList<>();

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

            sentencia.setInt(1, rePK.getNumeroRegistro());
            sentencia.setString(2, rePK.getEquipoIdEquipo());

            resultado = sentencia.executeQuery();

            if (resultado != null) {
                while (resultado.next()) {
                    RegistroEquipo equi = new RegistroEquipo();
                    equi.setEquipoIdEquipo(resultado.getString(1));
                    equi.setFechaEntrada(resultado.getTimestamp(2));
                    equi.setFechaSalida(resultado.getTimestamp(3));
                    equi.setNumeroRegistro(resultado.getInt(4));
                    listaEquipoFindByPk.add(equi);
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
        return listaEquipoFindByPk;
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
