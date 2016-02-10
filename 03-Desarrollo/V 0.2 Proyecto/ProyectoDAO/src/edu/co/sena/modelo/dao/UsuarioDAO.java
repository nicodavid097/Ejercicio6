/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.modelo.dao;

import edu.co.sena.modelo.dto.Usuario;
import edu.co.sena.modelo.dto.UsuarioPK;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface UsuarioDAO {
    public List<Usuario> findAll();
    public String getTableName();
    public void insert(Usuario user);
    public void update(UsuarioPK userpk,Usuario user);
    public void updatePK(UsuarioPK userViejo,UsuarioPK userNuevo);
    public void deleteForPk(UsuarioPK user);
    public List<Usuario> findByPK(UsuarioPK user);
    public int count();
}
