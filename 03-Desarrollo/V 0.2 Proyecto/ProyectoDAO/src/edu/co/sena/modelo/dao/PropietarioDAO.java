/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.modelo.dao;

import edu.co.sena.modelo.dto.Propietario;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface PropietarioDAO {
public List<Propietario> findALl();  
public String getTableName();
public void insert(Propietario pro);
public void update(Propietario pro);
public void deleteForPk();
    public void deleteAll();
}
