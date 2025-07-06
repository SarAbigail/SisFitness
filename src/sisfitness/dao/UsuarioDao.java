/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfitness.dao;

import sisfitness.models.UsuarioModel;

/**
 *
 * 
 */
public interface UsuarioDao {
        UsuarioModel getValidaCredenciales(String login, String contrasena);
}
