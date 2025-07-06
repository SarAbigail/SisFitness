/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfitness.dao;

import java.util.List;
import sisfitness.models.ProductoModel;

/**
 *
 * 
 */
public interface ProductoDao {
    List<ProductoModel> getListaAll();
    List<ProductoModel> getBuscarByDescripcion(String sFilter);        
    ProductoModel getFindbyID(int ID);
    int setGuardar(String opcion, ProductoModel producto);
}
