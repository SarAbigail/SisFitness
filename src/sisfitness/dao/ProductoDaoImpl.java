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
import sisfitness.models.ProductoModel;
import sisfitness.models.ProductoRowMapper;

/**
 *
 * 
 */
public class ProductoDaoImpl implements ProductoDao {

    public ProductoDaoImpl()
    {
        
    }
    
    @Override
    public List<ProductoModel> getListaAll() {
        List<ProductoModel> listproucto=new ArrayList<>();
        
        try {
            ConexSql cnx=new ConexSql();
            String query = "select\n" +
"p.idproducto\n" +
",p.nombre\n" +
",p.descripcion\n" +
",p.serie\n" +
",p.precio\n" +
",p.stock\n" +
",p.idcategoria\n" +
",c.nombre categoria\n" +
"from producto p \n" +
"	inner join categoria c\n" +
"		on p.idcategoria=c.idcategoria\n" +
"where p.flgeli='0'\n" +
"and c.flgeli='0' order by p.idproducto";  
            ResultSet resultSet = cnx.executeQuery(query);
            ProductoRowMapper mapper=new ProductoRowMapper();
            listproucto=mapper.mapRow(resultSet);            
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listproucto;         
    }

    @Override
    public int setGuardar(String opcion, ProductoModel producto) {
        int nResult=-1;
            try {
            ConexSql cnx=new ConexSql();
            
            if (opcion.equals(OPCION_NUEVO))
            {
                String query="insert into producto(nombre,descripcion,serie,precio,stock,flgeli,idcategoria) values (?,?,?,?,?,?,?)";
                List<Object> Params = new ArrayList<>();
                Params.add(producto.getNombre());
                Params.add(producto.getDescripcion());
                Params.add(producto.getSerie());
                Params.add(producto.getPrecio());
                Params.add(producto.getStock());
                Params.add("0");
                Params.add(producto.getCategoria().getId());
                
                nResult = cnx.executeSetQuery(query, Params);                
            }            
            else  if (opcion.equals(OPCION_MODIFICAR))
            {
                String query="update producto set nombre= ?, descripcion = ? ,serie=? ,precio=? ,stock=?, idcategoria=? where idproducto=?";
                List<Object> Params = new ArrayList<>();
                Params.add(producto.getNombre());
                Params.add(producto.getDescripcion());
                Params.add(producto.getSerie());
                Params.add(producto.getPrecio());
                Params.add(producto.getStock());
                Params.add(producto.getCategoria().getId());
                Params.add(producto.getId());
                
                nResult = cnx.executeSetQuery(query, Params);                
            }   
            
            else  if (opcion.equals(OPCION_ELIMINAR))
            {
                String query="update producto set flgeli='1' where idproducto=?";
                List<Object> Params = new ArrayList<>();
                Params.add(producto.getId());
                
                nResult = cnx.executeSetQuery(query, Params);                
            }                
           
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return nResult;
    }

    @Override
    public ProductoModel getFindbyID(int ID) {
        List<ProductoModel> listproucto=new ArrayList<>();
        
        try {
            ConexSql cnx=new ConexSql();
            String query = "select\n" +
"p.idproducto\n" +
",p.nombre\n" +
",p.descripcion\n" +
",p.serie\n" +
",p.precio\n" +
",p.stock\n" +
",p.idcategoria\n" +
",c.nombre categoria\n" +
"from producto p \n" +
"	inner join categoria c\n" +
"		on p.idcategoria=c.idcategoria\n" +
"where p.flgeli='0'\n" +
"and c.flgeli='0'\n" +
"and p.idproducto=" + ID + " ";  
            ResultSet resultSet = cnx.executeQuery(query);
            ProductoRowMapper mapper=new ProductoRowMapper();
            listproucto=mapper.mapRow(resultSet);            
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listproucto.get(0);         
    }

    @Override
    public List<ProductoModel> getBuscarByDescripcion(String sFilter) {
       List<ProductoModel> listproucto=new ArrayList<>();
        
        try {
            ConexSql cnx=new ConexSql();
            String query = "select\n" +
"p.idproducto\n" +
",p.nombre\n" +
",p.descripcion\n" +
",p.serie\n" +
",p.precio\n" +
",p.stock\n" +
",p.idcategoria\n" +
",c.nombre categoria\n" +
"from producto p \n" +
"	inner join categoria c\n" +
"		on p.idcategoria=c.idcategoria\n" +
"where p.flgeli='0'\n" +
"and p.nombre like '%" +  sFilter + "%'\n" +                    
"and c.flgeli='0' order by p.idproducto";  
            ResultSet resultSet = cnx.executeQuery(query);
            ProductoRowMapper mapper=new ProductoRowMapper();
            listproucto=mapper.mapRow(resultSet);            
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listproucto;
    }
    
}
