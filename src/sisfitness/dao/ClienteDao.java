/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfitness.dao;

import java.util.List;
import sisfitness.models.ClienteModel;

/**
 *
 * 
 */
public interface ClienteDao {
    List<ClienteModel> getListaAll();
    List<ClienteModel> getBuscarByApeNom(String sFilter);    
    ClienteModel getFindbyID(int ID);
    int setGuardar(String opcion, ClienteModel cliente);
}
