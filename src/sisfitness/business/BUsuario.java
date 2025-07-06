/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfitness.business;

import sisfitness.dao.UsuarioDaoImpl;
import sisfitness.models.UsuarioModel;

/**
 *
 * 
 */
public class BUsuario {
    
    UsuarioDaoImpl usuarioDaoImpl;
    
    public BUsuario()
    {
        usuarioDaoImpl=new UsuarioDaoImpl();
    }
    
    public UsuarioModel ValidaCredenciales(String login, String contrasena)
    {
        return usuarioDaoImpl.getValidaCredenciales(login, contrasena);
    }
    
}
