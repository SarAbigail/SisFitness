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
import static sisfitness.common.Parametros.OPCION_ELIMINAR;
import static sisfitness.common.Parametros.OPCION_MODIFICAR;
import static sisfitness.common.Parametros.OPCION_NUEVO;
import sisfitness.da.ConexSql;
import sisfitness.models.ClienteModel;
import sisfitness.models.ClienteRowMapper;

/**
 *
 *
 */
public class ClienteDaoImpl implements ClienteDao {

    public ClienteDaoImpl() {
    }

    @Override
    public List<ClienteModel> getListaAll() {
        List<ClienteModel> listproucto = new ArrayList<>();
        try {
            ConexSql cnx = ConexSql.getInstancia();
            String query = "select * from cliente where flgeli='0' order by idcliente";
            ResultSet resultSet = cnx.executeQuery(query);
            ClienteRowMapper mapper = new ClienteRowMapper();
            listproucto = mapper.mapRow(resultSet);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listproucto;
    }

    @Override
    public ClienteModel getFindbyID(int ID) {
        List<ClienteModel> listproucto = new ArrayList<>();
        try {
            ConexSql cnx = ConexSql.getInstancia();
            String query = "select * from cliente where flgeli='0' and idcliente=" + ID + " order by idcliente";
            ResultSet resultSet = cnx.executeQuery(query);
            ClienteRowMapper mapper = new ClienteRowMapper();
            listproucto = mapper.mapRow(resultSet);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listproucto.get(0);
    }

    @Override
    public int setGuardar(String opcion, ClienteModel cliente) {
        int nResult = -1;
        try {
            ConexSql cnx = ConexSql.getInstancia();

            if (opcion.equals(OPCION_NUEVO)) {
                String query = "insert into cliente(dni,apellidos,nombres,direccion,distrito,correo,celular,flgeli) values (?,?,?,?,?,?,?)";
                List<Object> Params = new ArrayList<>();
                Params.add(cliente.getDni());
                Params.add(cliente.getApellidos());
                Params.add(cliente.getNombres());
                Params.add(cliente.getDireccion());
                Params.add(cliente.getDistrito());
                Params.add(cliente.getCorreo());
                Params.add(cliente.getCeluar());
                Params.add("0");

                nResult = cnx.executeSetQuery(query, Params);
            } else if (opcion.equals(OPCION_MODIFICAR)) {
                String query = "update cliente set apellidos= ?, nombres = ? ,direccion=? ,distrito=? ,correo=?, celular=? where idcliente=?";
                List<Object> Params = new ArrayList<>();
                Params.add(cliente.getApellidos());
                Params.add(cliente.getNombres());
                Params.add(cliente.getDireccion());
                Params.add(cliente.getDistrito());
                Params.add(cliente.getCorreo());
                Params.add(cliente.getCeluar());
                Params.add(cliente.getIdcliente());

                nResult = cnx.executeSetQuery(query, Params);
            } else if (opcion.equals(OPCION_ELIMINAR)) {
                String query = "update cliente set flgeli='1' where idcliente=?";
                List<Object> Params = new ArrayList<>();
                Params.add(cliente.getIdcliente());

                nResult = cnx.executeSetQuery(query, Params);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return nResult;
    }

    @Override
    public List<ClienteModel> getBuscarByApeNom(String sFilter) {
        List<ClienteModel> listproucto = new ArrayList<>();
        try {
            ConexSql cnx = ConexSql.getInstancia();
            String query = "select * from cliente where flgeli='0'  and concat(apellidos,' ',nombres) like '%" + sFilter + "%' order by idcliente";
            ResultSet resultSet = cnx.executeQuery(query);
            ClienteRowMapper mapper = new ClienteRowMapper();
            listproucto = mapper.mapRow(resultSet);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listproucto;
    }

}
