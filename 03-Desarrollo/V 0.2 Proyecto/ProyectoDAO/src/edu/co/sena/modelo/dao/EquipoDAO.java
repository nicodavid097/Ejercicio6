/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.modelo.dao;

import edu.co.sena.modelo.dto.Equipo;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface EquipoDAO {
    public List<Equipo> findAll();
    public String getTableName();
    public void insert(Equipo eq);
    public void update(Equipo eq);
    public void deleteForPk();
    public void deleteAll();
}
