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
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
    public void pruebaFindAll() {

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
        try {
            RegistroEquipoDAO registroEquipoDAO = new RegistroEquipoDAOImp();
            RegistroEquipo reguistroEquipo = new RegistroEquipo();

            Registro regist = new Registro();
            regist.setNumeroRegistro(2);

            Equipo equi = new Equipo();
            equi.setIdEquipo("112233");

            Calendar c1 = GregorianCalendar.getInstance();
            c1.set(2015, 10, 17, 15, 50, 20);
            Calendar c2 = GregorianCalendar.getInstance();
            c2.set(2018, 10, 17, 15, 50, 20);
            Timestamp t1 = new Timestamp(c1.getTimeInMillis());
            Timestamp t2 = new Timestamp(c2.getTimeInMillis());

            reguistroEquipo.setEquipoIdEquipo(equi.getIdEquipo());
            reguistroEquipo.setFechaEntrada(t1);
            reguistroEquipo.setNumeroRegistro(regist.getNumeroRegistro());
            reguistroEquipo.setFechaSalida(t2);

            registroEquipoDAO.insert(reguistroEquipo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void pruebaUpdate() {

        RegistroEquipoDAO registroEquipo = new RegistroEquipoDAOImp();

        RegistroEquipo registroDTO = new RegistroEquipo();

        Registro regist = new Registro();
        regist.setNumeroRegistro(1);

        Equipo equi = new Equipo();
        equi.setIdEquipo("112233");

        Calendar c1 = GregorianCalendar.getInstance();
        c1.set(2015, 10, 17, 15, 50, 20);

        Calendar c2 = GregorianCalendar.getInstance();
        c2.set(2018, 10, 17, 15, 50, 20);
        Timestamp t1 = new Timestamp(c1.getTimeInMillis());

        Timestamp t2 = new Timestamp(c2.getTimeInMillis());

        RegistroEquipoPK rePk = new RegistroEquipoPK(1, "112233");

        registroDTO.setFechaEntrada(t1);
        registroDTO.setFechaSalida(t2);

        registroEquipo.update(rePk, registroDTO);
    }

    @Test
    public void pruebaUpdatePk() {
        RegistroEquipoDAO registroEquipo = new RegistroEquipoDAOImp();

        RegistroEquipo registroDTO = new RegistroEquipo();
        RegistroEquipoPK rePk = new RegistroEquipoPK(1, "112233");

        registroDTO.setEquipoIdEquipo("13451");
        registroDTO.setNumeroRegistro(12);

        Calendar c2 = GregorianCalendar.getInstance();
        c2.set(2018, 10, 17, 15, 50, 20);

        Timestamp t2 = new Timestamp(c2.getTimeInMillis());

        registroDTO.setFechaEntrada(t2);

        registroEquipo.update(rePk, registroDTO);

    }

    @Test
    public void pruebaDeletePk() {
        RegistroEquipoDAO registroEquipo = new RegistroEquipoDAOImp();

        RegistroEquipoPK rePk = new RegistroEquipoPK(1, "112233");

        registroEquipo.deleteForPk(rePk);

    }

    @Test
    public void pruebaFinByPK() {
        RegistroEquipoDAO registroEquipo = new RegistroEquipoDAOImp();

        RegistroEquipoPK rePk = new RegistroEquipoPK(3, "312233");

        for (RegistroEquipo runner : registroEquipo.findByPK(rePk)) {
            System.out.println(".-----------------------------------------------.");
            System.out.println("Equipo_Id_Equipo : " + runner.getEquipoIdEquipo());
            System.out.println("NumeroRegistro : " + runner.getNumeroRegistro());
            System.out.println("Fecha_Entrada : " + runner.getFechaEntrada());
            System.out.println("Fecha_Salida : " + runner.getFechaSalida());
        }
    }

    @Test
    public void pruebaCount() {
        RegistroEquipoDAO regui = new RegistroEquipoDAOImp();
        System.out.print(regui.count());
    }

}
