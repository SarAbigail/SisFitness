/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfitness.formularios.tablas;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sisfitness.models.EmpleadoModel;

/**
 *
 * 
 */
public class EmpleadoTableModel  extends AbstractTableModel{
        private final String[] columnNames = {"ID","Apellidos", "Nombres","Direccion","Teléfono","Correo"};
        private final List<EmpleadoModel> listaempleado;
        
        public EmpleadoTableModel(List<EmpleadoModel> listaempleado)
        {
            this.listaempleado=listaempleado;
        }

    @Override
    public int getRowCount() {
        return listaempleado.size();
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
        EmpleadoModel empleadoModel=listaempleado.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return empleadoModel.getIdempleado();
            case 1:
                return empleadoModel.getApellidos();
            case 2:
                return empleadoModel.getNombres();
            case 3:
                return empleadoModel.getDireccion();   
            case 4:
                return empleadoModel.getTelefono();  
            case 5:
                return empleadoModel.getCorreo(); 
            default:                
                return null;
        }
    }
        
        
}
