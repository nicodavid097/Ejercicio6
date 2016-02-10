/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.modelo.dao;

import edu.co.sena.modelo.dto.Registro;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface RegistroDAO {
    public List<Registro> findAll();
    public String getTableName();
    public void insert(Registro reg);
    public void update(Registro reg);
    public void deleteForPk();
    public void deleteAll();
}
