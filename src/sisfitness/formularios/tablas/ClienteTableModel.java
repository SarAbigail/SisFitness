/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfitness.formularios.tablas;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sisfitness.models.ClienteModel;

/**
 *
 * 
 */
public class ClienteTableModel extends AbstractTableModel {
        private final String[] columnNames = {"ID","DNI", "Apellidos", "Nombres","Direccion","Distrito","Correo","Celular"};
         private final List<ClienteModel> listacliente;
         
         public ClienteTableModel( List<ClienteModel> listacliente)
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
                return clienteModel.getApellidos();
            case 3:
                return clienteModel.getNombres();
            case 4:
                return clienteModel.getDireccion();   
            case 5:
                return clienteModel.getDistrito();  
            case 6:
                return clienteModel.getCorreo();
            case 7:
                return clienteModel.getCeluar();                
            default:                
                return null;
        }       
    }
}
