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
import static sisfitness.common.Parametros.OPCION_ELIMINAR;
import static sisfitness.common.Parametros.OPCION_MODIFICAR;
import static sisfitness.common.Parametros.OPCION_NUEVO;
import sisfitness.da.ConexSql;
import sisfitness.models.CategoriaModel;
import sisfitness.models.CategoriaRowMapper;

/**
 *
 * 
 */
public class CategoriaDaoImpl implements CategoriaDao{

    @Override
    public List<CategoriaModel> getListaAll() {
         List<CategoriaModel> listcategoria=new ArrayList<>();
         try {
            ConexSql cnx=new ConexSql();
            String query = "select * from categoria where flgeli='0' order by idcategoria";  
            ResultSet resultSet = cnx.executeQuery(query);
            CategoriaRowMapper mapper=new CategoriaRowMapper();
            listcategoria=mapper.mapRow(resultSet);            
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listcategoria;  
    }

    @Override
    public CategoriaModel getFindbyID(int ID) {
         List<CategoriaModel> listcategoria=new ArrayList<>();
         try {
            ConexSql cnx=new ConexSql();
            String query = "select * from categoria where flgeli='0' and idcategoria="+ ID + " order by idcategoria"  ;  
            ResultSet resultSet = cnx.executeQuery(query);
            CategoriaRowMapper mapper=new CategoriaRowMapper();
            listcategoria=mapper.mapRow(resultSet);            
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listcategoria.get(0);  
    }

    @Override
    public int setGuardar(String opcion, CategoriaModel categoria) {
    int nResult=-1;
            try {
            ConexSql cnx=new ConexSql();
            
            if (opcion.equals(OPCION_NUEVO))
            {
                String query="insert into categoria(nombre, descripcion,flgeli) values (?,?,?)";
                List<Object> Params = new ArrayList<>();
                Params.add(categoria.getNombre());
                Params.add(categoria.getDescripcion());
                Params.add("0");
                
                nResult = cnx.executeSetQuery(query, Params);                
            }            
            else  if (opcion.equals(OPCION_MODIFICAR))
            {
                String query="update categoria set nombre=?, descripcion = ?  where idcategoria=?";
                List<Object> Params = new ArrayList<>();
                Params.add(categoria.getNombre());
                Params.add(categoria.getDescripcion());
                Params.add(categoria.getId());
                
                nResult = cnx.executeSetQuery(query, Params);                
            }   
            
            else  if (opcion.equals(OPCION_ELIMINAR))
            {
                String query="update categoria set flgeli='1' where idcategoria=?";
                List<Object> Params = new ArrayList<>();
                Params.add(categoria.getId());
                
                nResult = cnx.executeSetQuery(query, Params);                
            }                
           
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return nResult;
    }
    
}
