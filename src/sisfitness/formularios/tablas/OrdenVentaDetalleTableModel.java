/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfitness.formularios.tablas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sisfitness.models.OrdenVentaDetalleModel;

/**
 *
 * 
 */
public class OrdenVentaDetalleTableModel  extends AbstractTableModel {
        private final String[] columnNames = {"Item","Producto","Categoria","Cantidad","Precio","Total"};
        private List<OrdenVentaDetalleModel> listadetalle;
        
     public OrdenVentaDetalleTableModel( List<OrdenVentaDetalleModel> listadetalle)
     {
         this.listadetalle=listadetalle;
     }
     
        
  @Override
    public int getRowCount() {
        return listadetalle.size();
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
     switch (columnIndex) {
         case 3:
             return true;
         default:
             return false;
      }
    }
    
    public void addItem(OrdenVentaDetalleModel item)
    {
        listadetalle.add(item);
        fireTableRowsInserted(listadetalle.size() - 1, listadetalle.size() - 1);
    }
    
    public void removeItem(int rowIndex)
    {
        listadetalle.remove(rowIndex);        
        fireTableRowsDeleted(rowIndex, rowIndex);
    }  
    
    public void Limpiar()
    {
        listadetalle=new ArrayList<>();
        fireTableRowsUpdated(0, listadetalle.size());
    }
    
    public List<OrdenVentaDetalleModel> Lista()
    {
        return listadetalle;
    }
    
    public void actualizarNroItems()
    {
        for (int i = 0; i < listadetalle.size(); i++) {
            listadetalle.get(i).setItem(i+1);
        }
         fireTableRowsUpdated(0, listadetalle.size()-1);
    }
    
    
    public double getTotal()
    {
        double nTotal = listadetalle.stream()
                         .mapToDouble(OrdenVentaDetalleModel::getTotal) // Mapear las edades
                         .sum(); // Sumar todas las edades
        
        return nTotal;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      OrdenVentaDetalleModel  detalle=listadetalle.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return detalle.getItem();
            case 1:
                return detalle.getProducto().getNombre();
            case 2:
                return detalle.getProducto().getCategoria().getNombre();
            case 3:
                return detalle.getCantidad();
            case 4:
                return detalle.getPrecio();                
            case 5:
                return detalle.getTotal();
            default:                
                return null;
        }       
    }           

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        OrdenVentaDetalleModel item = listadetalle.get(rowIndex);
        switch (columnIndex) {
            case 3:
                try {
                    item.setCantidad(Double.parseDouble(aValue.toString()));
                    item.setTotal(item.getCantidad() * item.getPrecio());
                } catch (NumberFormatException e) {
                    //No aplica
                }
                break;
        }
         fireTableCellUpdated(rowIndex, columnIndex); 
         fireTableRowsUpdated(rowIndex, rowIndex);
    }
    
    
        
}
