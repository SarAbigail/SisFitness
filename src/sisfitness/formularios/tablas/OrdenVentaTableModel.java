/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfitness.formularios.tablas;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sisfitness.models.OrdenVentaModel;

/**
 *
 * 
 */
public class OrdenVentaTableModel  extends AbstractTableModel  {
    private final String[] columnNames = {"ID","Cliente","Fecha Venta","Total Venta","Fecha Registro"};
    private List<OrdenVentaModel> lista;
    
     public OrdenVentaTableModel( List<OrdenVentaModel> lista)
     {
         this.lista=lista;
     }    

    @Override
    public int getRowCount() {
        return lista.size();
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
        OrdenVentaModel  item=lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return item.getIdorden();
            case 1:
                return item.getCliente().getApellidos() + " " + item.getCliente().getNombres();
            case 2:
                return item.getFechaventa();
            case 3:
                 return item.getTotalventa();
            case 4:
                return item.getFecharegistro();
            default:                
                return null;
        }     
    }
}
