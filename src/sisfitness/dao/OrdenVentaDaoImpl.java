/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfitness.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sisfitness.da.ConexSql;
import sisfitness.models.OrdenVentaDetalleModel;
import sisfitness.models.OrdenVentaModel;
import sisfitness.models.OrdenVentaRowMapper;
import sisfitness.models.ProductoRowMapper;

/**
 *
 * 
 */
public class OrdenVentaDaoImpl implements OrdenVentaDao {

    @Override
    public int setGuardar(OrdenVentaModel ordenVentaModel) {
        int nResult=0;
            try {
            ConexSql cnx=new ConexSql();
            
                //Insertamos datos de la cabecera            
                String query="insert into ordenventa(idcliente,fechaventa,total,fecharegistro,flgeli) values (?,?,?,now(),'0')";
                List<Object> Params = new ArrayList<>();
                Params.add(ordenVentaModel.getCliente().getIdcliente());
                Params.add(java.sql.Date.valueOf(ordenVentaModel.getFechaventa()));
                Params.add(ordenVentaModel.getTotalventa());     
                
                //ResultSet resultSet = cnx.executeQuery(query);                
                int ID = cnx.insertarConRetornarID(query, Params);      
                
                for(OrdenVentaDetalleModel detalleModel:ordenVentaModel.getOrdenVentaDetalles())
                {
                    query="insert into ordenventa_detalle(idorden,item,idproducto,cantidad,precio,total,flgeli) values (?,?,?,?,?,?,'0')";
                    Params = new ArrayList<>();
                    Params.add(ID);
                    Params.add(detalleModel.getItem());
                    Params.add(detalleModel.getProducto().getId());
                    Params.add(detalleModel.getCantidad());
                    Params.add(detalleModel.getProducto().getPrecio());
                    Params.add(detalleModel.getTotal());
                    nResult = nResult +  cnx.executeSetQuery(query, Params);    
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(ProductoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        return nResult;
    }

    @Override
    public List<OrdenVentaModel> BuscarByClienteAndFechaVenta(int idcliente, String sFechaVenta) {
         List<OrdenVentaModel> lista=new ArrayList<>();
        
        try {
            ConexSql cnx=new ConexSql();
            String query = "select\n" +
" a.idorden\n" +
",a.idcliente\n" +
",b.apellidos\n" +
",b.nombres\n" +
",a.fechaventa\n" +
",a.total\n" +
",a.fecharegistro\n" +
"from ordenventa a\n" +
" inner join cliente b\n" +
" 	on a.idcliente=b.idcliente\n" +
"where a.flgeli='0' order by a.idorden " ;
            if (idcliente>0)
                query=query + " and a.idcliente=" +idcliente ;
            if (!sFechaVenta.isEmpty())
                query=query + " and a.fechaventa='" + sFechaVenta  + "'";           
//"and a.fechaventa='2024-12-10'\n" +
//"and a.idcliente=1";  
            ResultSet resultSet = cnx.executeQuery(query);
            OrdenVentaRowMapper mapper=new OrdenVentaRowMapper();
            lista=mapper.mapRow(resultSet);            
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;       
    }
    
}
