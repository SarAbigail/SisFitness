/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfitness.formularios.tablas;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sisfitness.builder.ProductoModel;

/**
 *
 * 
 */
public class ProductoTableModel extends AbstractTableModel {

    private final String[] columnNames = {"ID", "Nombre", "Descripcion","Serie","Precio","Stock","Categoria"};
    private final List<ProductoModel> productos;
    
    public ProductoTableModel(List<ProductoModel> productos) {
        this.productos = productos;
    }
    
    @Override
    public int getRowCount() {
        return productos.size();
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
        ProductoModel producto = productos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return producto.getId();
            case 1:
                return producto.getNombre();
            case 2:
                return producto.getDescripcion();
            case 3:
                return producto.getSerie();
            case 4:
                return producto.getPrecio();   
            case 5:
                return producto.getStock();  
            case 6:
                return producto.getCategoria().getNombre();                  
            default:                
                return null;
        }
    }
    
   
    
}
