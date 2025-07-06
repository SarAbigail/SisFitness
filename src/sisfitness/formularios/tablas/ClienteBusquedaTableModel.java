/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfitness.formularios.tablas;

import java.util.List;
import java.util.Optional;
import javax.swing.table.AbstractTableModel;
import sisfitness.models.ClienteModel;

/**
 *
 * 
 */
public class ClienteBusquedaTableModel  extends AbstractTableModel{
    private final String[] columnNames = {"ID","DNI", "Apellidos y Nombres"};
         private final List<ClienteModel> listacliente;
         
         public ClienteBusquedaTableModel( List<ClienteModel> listacliente)
         {
             this.listacliente=listacliente;
         }

    @Override
    public int getRowCount() {
        return listacliente.size();
    }

    @Override
    public int getColumnCount() {
       return columnNames.length;
    }
    
    @Override
    public String getColumnName(int column) {
       return columnNames[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
         return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       ClienteModel clienteModel=listacliente.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return clienteModel.getIdcliente();
            case 1:
                return clienteModel.getDni();
            case 2:
                return clienteModel.getApellidos() + " " + clienteModel.getNombres();     
            default:                
                return null;
        }       
    }
    
    public ClienteModel ObtenerByID(int sID)
    {
        Optional<ClienteModel> cliienteEncontrado = listacliente.stream()
                .filter(cliente -> cliente.getIdcliente()==sID)
                .findFirst();

        // Verificar si el objeto fue encontrado
        if (cliienteEncontrado.isPresent()) {
            return cliienteEncontrado.get();
        } else {
            return null;
        }
    }
}
