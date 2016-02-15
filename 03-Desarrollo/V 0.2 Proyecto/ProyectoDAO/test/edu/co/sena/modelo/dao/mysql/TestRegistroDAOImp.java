/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.modelo.dao.mysql;

import edu.co.sena.modelo.dao.RegistroDAO;
import edu.co.sena.modelo.dao.factory.DAOFactory;
import edu.co.sena.modelo.dao.factory.mysql.MysqlDAOFactory;
import edu.co.sena.modelo.dto.Registro;
import edu.co.sena.modelo.dto.RegistroPK;
import java.sql.Timestamp;
import java.util.Calendar;
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
public class TestRegistroDAOImp {
    
    
    public TestRegistroDAOImp() {
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
     * Test of findAll method, of class RegistroDAOImp.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        DAOFactory fabrica = new MysqlDAOFactory();
        RegistroDAO instance = fabrica.crearRegistro();
        List<Registro> result = instance.findAll();
        
        for (Registro result1 : result) {
            System.out.println(result1.toString());
        }
    }

    /**
     * Test of getTableName method, of class RegistroDAOImp.
     */
    @Test
    public void testGetTableName() {
       System.out.println("getTableName");
        DAOFactory fabrica=new MysqlDAOFactory();
        RegistroDAO instance = fabrica.crearRegistro();
        System.out.println(instance.getTableName());
    }

    /**
     * Test of insert method, of class RegistroDAOImp.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Registro reg = new Registro();
        reg.setNumeroRegistro(182546);
        Calendar cal1=GregorianCalendar.getInstance();
        cal1.set(2018, Calendar.JUNE, 25, 13, 50, 50);
        Timestamp ts1=new Timestamp(cal1.getTimeInMillis());
        Timestamp ts2=new Timestamp(cal1.getTimeInMillis());
        
        reg.setFechaEntrada(ts1);
        reg.setFechaSalida(ts2);
        reg.setCuentaNumeroDocumento("1030684230");
        reg.setCuentaTipoDocumento("CC");
        reg.setVisita("a administracion del segundo piso");
        reg.setRolVisita("psicologo");

        
        DAOFactory fabrica=new MysqlDAOFactory();
        RegistroDAO instance = fabrica.crearRegistro();
        instance.insert(reg);
    }
    /**
     * Test of update method, of class RegistroDAOImp.
     */
    @Test
    public void testUpdate() {
       System.out.println("update");
        RegistroPK regPK = new RegistroPK(182546);
        Registro reg = new Registro();
        Calendar cal1=GregorianCalendar.getInstance();
        Calendar cal2=GregorianCalendar.getInstance();
        cal1.set(2016, Calendar.JUNE, 25, 13, 50, 50);
        cal2.set(2018, Calendar.AUGUST, 25, 13, 50, 1);
        Timestamp ts1=new Timestamp(cal1.getTimeInMillis());
        Timestamp ts2=new Timestamp(cal2.getTimeInMillis());
        
        
        reg.setFechaEntrada(ts1);
        reg.setFechaSalida(ts2);
        reg.setCuentaNumeroDocumento("97081623485");
        reg.setCuentaTipoDocumento("TI");
        reg.setVisita(null);
        reg.setRolVisita("algo");

        DAOFactory fabrica=new MysqlDAOFactory();
        RegistroDAO instance = fabrica.crearRegistro();
        instance.update(regPK, reg);
        
    }

    /**
     * Test of update method, of class RegistroDAOImp.
     */
    @Test
    public void testUpdatePK() {
        System.out.println("updatePK");
        RegistroPK regViejo =new RegistroPK(182546);
        RegistroPK regNuevo = new RegistroPK(123);
        DAOFactory fabrica=new MysqlDAOFactory();
        RegistroDAO instance = fabrica.crearRegistro();
        instance.updatePK(regViejo, regNuevo);
    }

    /**
     * Test of deleteForPk method, of class RegistroDAOImp.
     */
    @Test
    public void testDeleteForPk() {
        System.out.println("deleteForPk");
        RegistroPK reg =new RegistroPK(123);
        DAOFactory fabrica=new MysqlDAOFactory();
        RegistroDAO instance = fabrica.crearRegistro();
        instance.deleteForPk(reg);
    }

    /**
     * Test of findByPK method, of class RegistroDAOImp.
     */
    @Test
    public void testFindByPK() {
     System.out.println("findByPK");
        RegistroPK reg =new RegistroPK(14);
        DAOFactory fabrica=new MysqlDAOFactory();
        RegistroDAO instance = fabrica.crearRegistro();
        
        List<Registro> result = instance.findByPK(reg);
        for (Registro result1 : result) {
            System.out.println(result1.toString());
            
        }
        
    }

    /**
     * Test of count method, of class RegistroDAOImp.
     */
    @Test
    public void testCount() {
        System.out.println("count");
        DAOFactory fabrica =new MysqlDAOFactory() ;
        RegistroDAO instance = fabrica.crearRegistro();
        System.out.println("Count: "+instance.count());
    }
    
}
