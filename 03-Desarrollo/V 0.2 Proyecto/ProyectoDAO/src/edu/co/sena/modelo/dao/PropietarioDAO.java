/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.modelo.dao;

import edu.co.sena.modelo.dto.Propietario;
import edu.co.sena.modelo.dto.PropietarioPK;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface PropietarioDAO {
public List<Propietario> findALl();  
public String getTableName();
public void insert(Propietario pro);
public void update(PropietarioPK proPK,Propietario pro);
public void updatePK(PropietarioPK proViejo,PropietarioPK proNuevo);
public void deleteForPk(PropietarioPK proPK);
public List<Propietario> findByPK(PropietarioPK proPK);  
public int count();
}
