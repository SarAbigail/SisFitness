/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfitness.dao;

import java.util.List;
import sisfitness.models.CategoriaModel;

/**
 *
 * 
 */
public interface CategoriaDao {
    List<CategoriaModel> getListaAll();
    CategoriaModel getFindbyID(int ID);
    int setGuardar(String opcion, CategoriaModel categoria);        
}
