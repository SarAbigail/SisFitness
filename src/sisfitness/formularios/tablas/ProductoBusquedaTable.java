/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfitness.formularios.tablas;

import java.util.List;
import java.util.Optional;
import javax.swing.table.AbstractTableModel;
import sisfitness.builder.ProductoModel;

/**
 *
 * 
 */
public class ProductoBusquedaTable extends AbstractTableModel {
     private final String[] columnNames = {"ID","Producto","Categoria"};
     private final List<ProductoModel> listaproducto;
     public ProductoBusquedaTable( List<ProductoModel> listaproducto)
     {
         this.listaproducto=listaproducto;
     }     
         
  @Override
    public int getRowCount() {
        return listaproducto.size();
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
       ProductoModel producto=listaproducto.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return producto.getId();
            case 1:
                return producto.getNombre();
            case 2:
                return producto.getCategoria().getNombre();
            default:                
                return null;
        }       
    }
    
    public ProductoModel ObtenerByID(int sID)
    {
        Optional<ProductoModel> productoEncontrado = listaproducto.stream()
                .filter(producto -> producto.getId()==sID)
                .findFirst();

        // Verificar si el objeto fue encontrado
        if (productoEncontrado.isPresent()) {
            return productoEncontrado.get();
        } else {
            return null;
        }
    }         
         
}
