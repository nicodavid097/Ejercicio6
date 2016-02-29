/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.modelo.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class ResourceManagerTest {
    
    public ResourceManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of conectar method, of class ResourceManager.
     */
    @org.junit.Test
    public void testConectar() throws SQLException {
        Connection rs =null;
        try {
      rs = ResourceManager.getConnection();      
        } catch (SQLException e) {
        e.toString();
        }finally{
            if (rs!=null) {
                ResourceManager.close(rs);
            }
        }
      
     //  ResourceManager.close(rs);
        
    }
    @org.junit.Test
    public void testRsClose()throws SQLException{
    Connection con = null;
    PreparedStatement st =null;
    ResultSet rs=null;
    String sql="select*from catalogo;";    
    try {
        con = ResourceManager.getConnection();
        st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {            
                System.out.println("Id Catalogo: "+rs.getInt(1));
                System.out.println("nombre :"+rs.getString(2));
                System.out.println(" desciroc: "+rs.getString(3));
        }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally{
        if (rs!=null) {
            ResourceManager.close(rs);
        }
        if (st!=null) {
            ResourceManager.close(st);
        }
        if (con!=null) {
            ResourceManager.close(con);
        }
    }
            }

    
}
