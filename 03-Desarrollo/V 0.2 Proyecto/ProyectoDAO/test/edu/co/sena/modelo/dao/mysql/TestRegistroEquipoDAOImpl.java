/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.modelo.dao.mysql;

import edu.co.sena.modelo.dao.RegistroEquipoDAO;
import edu.co.sena.modelo.dao.mysql.RegistroEquipoDAOImp;
import edu.co.sena.modelo.dto.Equipo;
import edu.co.sena.modelo.dto.Registro;
import edu.co.sena.modelo.dto.RegistroEquipo;
import edu.co.sena.modelo.dto.RegistroEquipoPK;
import java.sql.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sun.reflect.generics.visitor.Reifier;

/**
 *
 * @author PeterD
 */
public class TestRegistroEquipoDAOImpl {

    public TestRegistroEquipoDAOImpl() {
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

    @Test
    public void pruebaFinAll() {

        RegistroEquipoDAO registroEquipo = new RegistroEquipoDAOImp();

        for (RegistroEquipo running : registroEquipo.findAll()) {
            System.out.println("------------------------------------------");
            System.out.println("NO. Registro : " + running.getNumeroRegistro());
            System.out.println("Fecha Entrada : " + running.getFechaEntrada());
            System.out.println("Id Equipo : " + running.getEquipoIdEquipo());
            System.out.println("Fecah Salida : " + running.getFechaSalida());
            System.out.println("------------------------------------------");
        }
    }

    @Test
    public void pruebaInsert() {
        /*   AVERIGUAR COMO SETEAR DATOS 'Date' DESDE IDE */
        try {
            RegistroEquipoDAO registroEquipoDAO = new RegistroEquipoDAOImp();
            RegistroEquipo reguistroEquipo = new RegistroEquipo();

            Registro regist = new Registro();
            regist.setNumeroRegistro(2);

            Equipo equi = new Equipo();
            equi.setIdEquipo("112233");

            reguistroEquipo.setEquipoIdEquipo(Integer.parseInt(equi.getIdEquipo()));
            reguistroEquipo.setFechaEntrada("2015-12-11 12:04:00");
            reguistroEquipo.setNumeroRegistro(regist.getNumeroRegistro());
            reguistroEquipo.setFechaSalida("2015-12-11 06:45:00");

            registroEquipoDAO.insert(reguistroEquipo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

//    @Test
//    public void pruebaUpdate (){
//        
//        // enrealidad poara que se actualiza el registro equipo...? 0.o como mrd?
//        //deberia solo actualizarse el id y numero de registro 
//        
//        RegistroEquipoDAO registroEquipo=new RegistroEquipoDAOImp();
//        
//        RegistroEquipo registroDTO=new RegistroEquipo();
//        
//            Registro regist = new Registro();
//            regist.setNumeroRegistro(42);
//
//            Equipo equi = new Equipo();
//            equi.setIdEquipo("31223343");
//        
//        
//        registroDTO.setEquipoIdEquipo(regist.getNumeroRegistro());
//        registroDTO.setNumeroRegistro(Integer.parseInt(equi.getIdEquipo()));
//        
//        RegistroEquipoPK reguistroEquiPK=new RegistroEquipoPK("2015-12-11 12:04:00");
//        
//        registroEquipo.update(reguistroEquiPK, registroDTO);
//    }
    @Test
    public void pruebaCount() {
        RegistroEquipoDAO regui = new RegistroEquipoDAOImp();

        System.out.print(regui.count());
    }

}
