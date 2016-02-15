/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.modelo.dao.mysql;

import edu.co.sena.modelo.dao.CuentaDAO;
import edu.co.sena.modelo.dao.factory.DAOFactory;
import edu.co.sena.modelo.dao.factory.mysql.MysqlDAOFactory;
import edu.co.sena.modelo.dto.Cuenta;
import edu.co.sena.modelo.dto.CuentaPK;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
        
        DAOFactory fabrica =new MysqlDAOFactory() ;
        CuentaDAO instance = fabrica.crearCuenta();

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
        DAOFactory fabrica =new MysqlDAOFactory() ;
        CuentaDAO cuenta1 = fabrica.crearCuenta();
        System.out.println(cuenta1.getTableName());
      
    }

    /**
     * Test of insert method, of class CuentaDAOImp.
     */
    @Test
    public void testInsert(){
        System.out.println("insert");
        Cuenta c1=new Cuenta();
        Calendar cal1=GregorianCalendar.getInstance();
        cal1.set(2017, cal1.JUNE, 11);
        
        DAOFactory fabrica =new MysqlDAOFactory() ;
        CuentaDAO cuenta1 = fabrica.crearCuenta();
        
        c1.setNumeroDocumento("a55556667787");
        c1.setTipoDocumento("C.E");
        c1.setFoto(null);
        c1.setPrimeroNombre("Don");
        c1.setSegundoNombre("Ramon");
        c1.setPrimerApellido("Perez");
        c1.setSegundoApellido("Villegas");
        c1.setCargo("Aprendiz");
        c1.setFechaFinalizacion(cal1.getTime());
        c1.setEstado(Boolean.TRUE);
        
        cuenta1.insert(c1);
    
        
        
    }
    /**
     * Test of update method, of class CuentaDAOImp.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        CuentaPK cuepk = new CuentaPK("5555666777", "C.E");
        Calendar cal1=GregorianCalendar.getInstance();
        cal1.set(2018, cal1.JUNE, 30);
        
        Cuenta cu = new Cuenta();
        cu.setFoto(null);
        cu.setPrimeroNombre("papito");
        cu.setSegundoNombre(null);
        cu.setPrimerApellido("buena vista");
        cu.setSegundoApellido(null);
        cu.setCargo("Atrendiz de intercambio");
        cu.setFechaFinalizacion(cal1.getTime());
        cu.setEstado(Boolean.FALSE);
        
        DAOFactory fabrica=new MysqlDAOFactory();
        
        CuentaDAO instance = fabrica.crearCuenta();
        
        instance.update(cuepk, cu);
        
    }

    /**
     * Test of updatepk method, of class CuentaDAOImp.
     */
    @Test
    public void testUpdatepk() {
        System.out.println("updatepk");
        CuentaPK cuNuevo =new CuentaPK("015343828", "serialN");
        CuentaPK cuViejo=new CuentaPK("97081623485", "TI");
        
        DAOFactory fabrica=new MysqlDAOFactory();
        CuentaDAO instance = fabrica.crearCuenta();
        instance.updatepk(cuViejo, cuNuevo);
    }

    /**
     * Test of deleteForPk method, of class CuentaDAOImp.
     */
    @Test
    public void testDeleteForPk() {
        System.out.println("deleteForPk");
        DAOFactory fabrica=new MysqlDAOFactory();
        
        CuentaPK cuepk = new CuentaPK("5555666777", "C.E");
        CuentaDAO instance = fabrica.crearCuenta();
        instance.deleteForPk(cuepk);
 
    }

    /**
     * Test of findByPK method, of class CuentaDAOImp.
     */
    @Test
    public void testFindByPK() {
        System.out.println("findByPK");
        DAOFactory fabrica =new MysqlDAOFactory() ;
        CuentaDAO instance = fabrica.crearCuenta();
        CuentaPK cuenpk =new CuentaPK("10306", "CC");

        List<Cuenta> result = instance.findByPK(cuenpk);
        
        for (Cuenta running : result) {
            System.out.println(running.toString());
      
        }
    }

    /**
     * Test of count method, of class CuentaDAOImp.
     */
    @Test
    public void testCount() {
        System.out.println("count");
        DAOFactory fabrica =new MysqlDAOFactory() ;
        CuentaDAO instance = fabrica.crearCuenta();
        System.out.println("Count: "+instance.count());
    }
    
}
