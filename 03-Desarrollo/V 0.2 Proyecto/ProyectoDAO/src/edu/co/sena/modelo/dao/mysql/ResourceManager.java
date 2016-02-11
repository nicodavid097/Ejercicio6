/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.modelo.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class ResourceManager {

    private static String URL = "jdbc:mysql://192.168.0.105:3306/"
            + "DB_ENTRY_INDEX";
    private static String USUARIO = "remoto";
    private static String CLAVE = "123456789";

    public static Connection getConnection() throws SQLException {
        Connection conexion = null;

        try {
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println("Se conecto");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return conexion;
    }

    public static void close(Connection con) {
        try {
            if (con != null) {
                con.close();
                System.out.println("Se desconecto");
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public static void close(PreparedStatement st) {
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public static void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}
