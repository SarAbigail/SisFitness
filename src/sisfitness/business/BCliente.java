/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfitness.business;

import java.util.List;
import sisfitness.dao.ClienteDaoImpl;
import sisfitness.models.ClienteModel;

/**
 *
 * 
 */
public class BCliente {
    
    ClienteDaoImpl clienteDaoImpl;
    
    public BCliente()
    {
        clienteDaoImpl=new ClienteDaoImpl();
    }
    
    public List<ClienteModel> ListaCliente()
    {
        return clienteDaoImpl.getListaAll();
    }
        
    public ClienteModel BuscarByID(int ID)
    {
        return clienteDaoImpl.getFindbyID(ID);
    }     
    
    public int GuardarCliente(String opcion, ClienteModel cliente)
    {
        return clienteDaoImpl.setGuardar(opcion, cliente);
    }     
    
    public List<ClienteModel> BuscarByApeNom(String sFilter)
    {
        return clienteDaoImpl.getBuscarByApeNom(sFilter);
    }    
}
