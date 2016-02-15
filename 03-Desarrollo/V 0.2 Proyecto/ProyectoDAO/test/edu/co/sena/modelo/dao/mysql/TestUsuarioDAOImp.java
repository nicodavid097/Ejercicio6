/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.modelo.dao.mysql;

import edu.co.sena.modelo.dao.UsuarioDAO;
import edu.co.sena.modelo.dao.factory.DAOFactory;
import edu.co.sena.modelo.dao.factory.mysql.MysqlDAOFactory;
import edu.co.sena.modelo.dto.Usuario;
import edu.co.sena.modelo.dto.UsuarioPK;
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
public class TestUsuarioDAOImp {
    
    public TestUsuarioDAOImp() {
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
     * Test of findAll method, of class UsuarioDAOImp.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        DAOFactory fabrica=new MysqlDAOFactory();
        UsuarioDAO instance = fabrica.creaUsuario();
        List<Usuario> result = instance.findAll();

        for (Usuario result1 : result) {
            System.out.println(result1.toString());
            
        }
    }

    /**
     * Test of getTableName method, of class UsuarioDAOImp.
     */
    @Test
    public void testGetTableName() {
        System.out.println("getTableName");
        DAOFactory fabrica=new MysqlDAOFactory();
        UsuarioDAO instance = fabrica.creaUsuario();
        System.out.println(instance.getTableName());
    }

    /**
     * Test of insert method, of class UsuarioDAOImp.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Usuario user = new Usuario();
        user.setCorreoElectronico("ejemplo@ejemplito.com");
        user.setContrasena("mimamamemima");
        user.setRoll("Instructor");
        user.setCuentaNumeroDocumento("1030680250");
        user.setCuentaTipoDocumento("CC");
        user.setActivo(Boolean.FALSE);
        
        DAOFactory fabrica=new MysqlDAOFactory();
        UsuarioDAO instance = fabrica.creaUsuario();
        instance.insert(user);

    }

    /**
     * Test of update method, of class UsuarioDAOImp.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        UsuarioPK userpk = new UsuarioPK("ejemplo@ejemplito.com");
        Usuario user = new Usuario();
        user.setContrasena("adsad");
        user.setRoll("Instructor2.0");
        user.setCuentaNumeroDocumento("1030680430");
        user.setCuentaTipoDocumento("CC");
        user.setActivo(Boolean.TRUE);
        DAOFactory fabrica=new MysqlDAOFactory();
        UsuarioDAO instance = fabrica.creaUsuario();
        instance.update(userpk, user);
       
    }

    /**
     * Test of updatePK method, of class UsuarioDAOImp.
     */
    @Test
    public void testUpdatePK() {
        System.out.println("updatePK");
        UsuarioPK userViejo =new UsuarioPK("ejemplo@ejemplito.com");
        UsuarioPK userNuevo = new UsuarioPK("nosemeocurrenada@coreo.com");
        DAOFactory fabrica=new MysqlDAOFactory();
        UsuarioDAO instance = fabrica.creaUsuario();
        instance.updatePK(userViejo, userNuevo);

    }

    /**
     * Test of deleteForPk method, of class UsuarioDAOImp.
     */
    @Test
    public void testDeleteForPk() {
        System.out.println("deleteForPk");
        UsuarioPK user =new UsuarioPK("nosemeocurrenada@coreo.com");
        DAOFactory fabrica=new MysqlDAOFactory();
        UsuarioDAO instance = fabrica.creaUsuario();
        instance.deleteForPk(user);

    }

    /**
     * Test of findByPK method, of class UsuarioDAOImp.
     */
    @Test
    public void testFindByPK() {
        System.out.println("findByPK");
        UsuarioPK user =new UsuarioPK("@elejemplo.com");
        DAOFactory fabrica=new MysqlDAOFactory();
        UsuarioDAO instance = fabrica.creaUsuario();
        
        List<Usuario> result = instance.findByPK(user);
        
        for (Usuario result1 : result) {
            System.out.println(result1.toString());
            
        }

    }

    /**
     * Test of count method, of class UsuarioDAOImp.
     */
    @Test
    public void testCount() {
        System.out.println("count");
        DAOFactory fabrica =new MysqlDAOFactory() ;
        UsuarioDAO instance = fabrica.creaUsuario();
        System.out.println("Count: "+instance.count());
    }
    
}
