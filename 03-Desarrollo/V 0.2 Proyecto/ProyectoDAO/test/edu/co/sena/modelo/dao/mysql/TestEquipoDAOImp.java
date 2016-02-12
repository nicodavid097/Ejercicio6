/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.modelo.dao.mysql;

import edu.co.sena.modelo.dao.EquipoDAO;
import edu.co.sena.modelo.dto.Equipo;
import edu.co.sena.modelo.dto.EquipoPK;
import java.sql.Connection;
import java.sql.SQLException;
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
public class TestEquipoDAOImp {

    public TestEquipoDAOImp() {
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
    public void pruebaFindAll() throws SQLException {

        EquipoDAO equipo = new EquipoDAOImp();

        for (Equipo running : equipo.findAll()) {
            System.out.println("---------------------------------------------");
            System.out.println("id : " + running.getIdEquipo());
            System.out.println("Descripcion : " + running.getDescripcion());
            System.out.print("Estado : ");
            if (running.getEstado() == true) {
                System.out.print("Activo \n");
            } else {
                System.out.print("InActivo \n");
            }
            System.out.println("---------------------------------------------");
        }

    }

    @Test
    public void pruebaInsert() {
        //TODO

        EquipoDAO equipo = new EquipoDAOImp();

        Equipo equipoDto = new Equipo();

        equipoDto.setIdEquipo("011089");
        equipoDto.setDescripcion("Descripcion con id 011089 :D OPD");
        equipoDto.setEstado(false);

        equipo.insert(equipoDto);

    }

    @Test
    public void update() {
        EquipoDAO equipo = new EquipoDAOImp();

        EquipoPK equipopk = new EquipoPK("011089");

        Equipo equipoDto = new Equipo();

        equipoDto.setIdEquipo("0110891");
        equipoDto.setDescripcion("desccripcion nueva 011089");
        equipoDto.setEstado(true);

        equipo.update(equipopk, equipoDto);
    }

    @Test
    public void updatePk() {

        EquipoDAO equipoDao = new EquipoDAOImp();
        EquipoPK equipoPkViejo = new EquipoPK("891001");
        EquipoPK equipoPKNuevo = new EquipoPK("01020304");

        equipoDao.update(equipoPkViejo, equipoPKNuevo);

    }

    @Test
    public void pruebaDeleteForPk() {
        EquipoDAO equipo = new EquipoDAOImp();

        Equipo equipoDto = new Equipo();

        equipoDto.setIdEquipo("12415815881598589");
        equipoDto.setDescripcion("Descripcion con id 12415815881598589 :D OPD");
        equipoDto.setEstado(false);
        equipo.insert(equipoDto);

        System.out.println("----------------------");

        EquipoPK equipopk = new EquipoPK("12415815881598589");

        equipo.deleteForPk(equipopk);

    }

    @Test
    public void findByPk() {
//TODO

        EquipoDAO equipoDAO = new EquipoDAOImp();

        EquipoPK equipopk = new EquipoPK("123");

        for (Equipo running : equipoDAO.findByPK(equipopk)) {
            System.out.println("________________________________________");
            System.out.println("Id Equipo : " + running.getIdEquipo());
            System.out.println("Descripcion : " + running.getDescripcion());
            System.out.print("Estado : ");
            if (running.getEstado() == true) {
                System.out.print("Activo \n");
            } else {
                System.out.print("In Activo \n");
            }
            System.out.println("________________________________________");

        }

    }

    @Test
    public void count() {
        EquipoDAO equipo = new EquipoDAOImp();
        System.out.println("Counts In Equipo : " + equipo.count());
    }

}
