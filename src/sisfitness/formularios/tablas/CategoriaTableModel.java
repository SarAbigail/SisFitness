/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfitness.formularios.tablas;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sisfitness.models.CategoriaModel;

/**
 *
 * 
 */
public class CategoriaTableModel extends AbstractTableModel {
    
    private final String[] columnNames = {"ID","Nombre", "Descripcion"};
    private final List<CategoriaModel> categorias;
    
    public CategoriaTableModel(List<CategoriaModel> categorias) {
        this.categorias = categorias;
    }
    
  @Override
    public int getRowCount() {
        return categorias.size();
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
        CategoriaModel categoria = categorias.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return categoria.getId();
            case 1:
                return categoria.getNombre();                
            case 2:
                return categoria.getDescripcion();
            default:                
                return null;
        }
    }    
    
}
