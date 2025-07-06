/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfitness.business;

import java.util.List;
import sisfitness.dao.CategoriaDaoImpl;
import sisfitness.models.CategoriaModel;

/**
 *
 * 
 */
public class BCategoria {
    CategoriaDaoImpl catImp;

    public BCategoria()
    {
        catImp=new CategoriaDaoImpl();
    }
    
    public List<CategoriaModel> ListaCategoria()
    {
        return catImp.getListaAll();
    }
    
    public CategoriaModel BuscarByID(int ID)
    {
        return catImp.getFindbyID(ID);
    }    
    
    public int GuardarCategoria(String opcion, CategoriaModel categoria)
    {
        return catImp.setGuardar(opcion, categoria);
    }    
        
}
