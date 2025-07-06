/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfitness.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sisfitness.da.ConexSql;
import sisfitness.models.UsuarioModel;
import sisfitness.models.UsuarioRowMapper;

/**
 *
 * 
 */
public class UsuarioDaoImpl implements UsuarioDao{

    @Override
    public UsuarioModel getValidaCredenciales(String login, String contrasena) {        
    
    try {
            ConexSql cnx=new ConexSql();
            String query = "select * from usuario where login='" + login + "' and contrasena='"+ contrasena + "' and flgeli='0' ";  
            ResultSet resultSet = cnx.executeQuery(query);
            UsuarioRowMapper mapper=new UsuarioRowMapper();
            List<UsuarioModel> lista= mapper.mapRow(resultSet);         
            if (lista.size()>0)
                return lista.get(0);
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
}
