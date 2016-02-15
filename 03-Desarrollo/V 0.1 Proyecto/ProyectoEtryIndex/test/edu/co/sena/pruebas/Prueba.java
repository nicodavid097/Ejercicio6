/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.pruebas;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import edu.co.sena.entryindex.modelo.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author kevin
 */
public class Prueba {
    
    public Prueba() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void primerPrueba() {
         Registro r = new Registro();
         Usuario usu = new Usuario();
     Cuenta cu = new Cuenta();
     RegistroEquipo re1 = new RegistroEquipo();
     RegistroEquipo re2 = new RegistroEquipo();
     RegistroEquipo re3 = new RegistroEquipo();
     RegistroEquipo re4 = new RegistroEquipo();
     Equipo equi= new Equipo();
     
     List<RegistroEquipo> lt = new ArrayList<>();
     lt.add(re4);
     lt.add(re1);
     lt.add(re2);
     lt.add(re3);
     cu.setRegistroEquipos(lt);
     re1.setEquipo(equi);
     r.setRegistroEquipos(lt);
     cu.setUsuario(usu);
     }
}
