/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.modelo.dao;

import edu.co.sena.modelo.dto.Cuenta;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface CuentaDAO {
    public List<Cuenta> findAll();
    public String getTableName();
    public void insert(Cuenta cu);
    public void update(Cuenta cu);
    public void deleteForPk();
    public void deleteAll();
}
