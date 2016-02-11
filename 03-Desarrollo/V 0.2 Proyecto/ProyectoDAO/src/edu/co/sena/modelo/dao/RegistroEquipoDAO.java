/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.modelo.dao;

import edu.co.sena.modelo.dto.RegistroEquipo;
import edu.co.sena.modelo.dto.RegistroEquipoPK;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface RegistroEquipoDAO {
    public List<RegistroEquipo> findAll();
    public String getTableName();
    public void insert(RegistroEquipo re);
    public void update(RegistroEquipoPK rePK,RegistroEquipo re);
    public void update(RegistroEquipoPK rePKViejo,RegistroEquipoPK rePKNuevo);
    public void deleteForPk(RegistroEquipoPK rePK);
    public List<RegistroEquipo> findByPK(RegistroEquipoPK rePK);
    public int count();
}
