/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.modelo.dao.mysql;

import edu.co.sena.modelo.dao.CuentaDAO;
import edu.co.sena.modelo.dto.Cuenta;
import edu.co.sena.modelo.dto.CuentaPK;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dxracso
 */
public class TestCuentaDAOImp {
    
    public TestCuentaDAOImp() {
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
     * Test of findAll method, of class CuentaDAOImp.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        CuentaDAO instance = new CuentaDAOImp();

        List<Cuenta> result = instance.findAll();
        
        for (Cuenta running : result) {
            System.out.println(running.toString());
      
        }

    }

    /**
     * Test of getTableName method, of class CuentaDAOImp.
     */
    @Test
    public void testGetTableName() {
        System.out.println("getTableName");
        CuentaDAOImp instance = new CuentaDAOImp();
        String expResult = "";
        String result = instance.getTableName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class CuentaDAOImp.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Cuenta cu = null;
        CuentaDAOImp instance = new CuentaDAOImp();
        instance.insert(cu);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class CuentaDAOImp.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        CuentaPK cuepk = null;
        Cuenta cu = null;
        CuentaDAOImp instance = new CuentaDAOImp();
        instance.update(cuepk, cu);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updatepk method, of class CuentaDAOImp.
     */
    @Test
    public void testUpdatepk() {
        System.out.println("updatepk");
        CuentaPK cuViejo = null;
        CuentaPK cuNuevo = null;
        CuentaDAOImp instance = new CuentaDAOImp();
        instance.updatepk(cuViejo, cuNuevo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteForPk method, of class CuentaDAOImp.
     */
    @Test
    public void testDeleteForPk() {
        System.out.println("deleteForPk");
        CuentaPK cuepk = null;
        CuentaDAOImp instance = new CuentaDAOImp();
        instance.deleteForPk(cuepk);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByPK method, of class CuentaDAOImp.
     */
    @Test
    public void testFindByPK() {
        System.out.println("findByPK");
        CuentaPK cuePK = null;
        CuentaDAOImp instance = new CuentaDAOImp();
        List<Cuenta> expResult = null;
        List<Cuenta> result = instance.findByPK(cuePK);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of count method, of class CuentaDAOImp.
     */
    @Test
    public void testCount() {
        System.out.println("count");
        CuentaDAOImp instance = new CuentaDAOImp();
        int expResult = 0;
        int result = instance.count();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
