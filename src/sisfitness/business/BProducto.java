/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfitness.business;

import java.util.List;
import sisfitness.dao.ProductoDaoImpl;
import sisfitness.builder.ProductoModel;

/**
 *
 * 
 */
public class BProducto {
    
    ProductoDaoImpl prodImp;
    
    public BProducto()
    {
        prodImp=new ProductoDaoImpl();
    }
    
    public List<ProductoModel> ListaProducto()
    {
        return prodImp.getListaAll();
    }
    
    public ProductoModel BuscarByID(int ID)
    {
        return prodImp.getFindbyID(ID);
    }    
    
    public int GuardarProducto(String opcion, ProductoModel producto)
    {
        return prodImp.setGuardar(opcion, producto);
    }
    
    public List<ProductoModel> BuscarByDescripcion(String sFilter)
    {
        return prodImp.getBuscarByDescripcion(sFilter);
    }     
    
}
