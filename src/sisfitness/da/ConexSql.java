/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfitness.da;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 
 */
    public class ConexSql {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/bd_sistcontrol";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "sqladmin";
    private Connection connection;

    // Constructor: Establece la conexión
    public ConexSql() throws SQLException {
        connect();
    }

    private void connect() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Conexión establecida correctamente.");
        }
    }
    
    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            System.out.println("Conexión cerrada.");
        }
    }
    
    public ResultSet executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }
    
// Ejecutar un procedimiento almacenado con parámetros
    public boolean executeStoredProcedure(String procedureName, Object[] parameters) throws SQLException {
        StringBuilder sql = new StringBuilder("{CALL ").append(procedureName).append("(");
        for (int i = 0; i < parameters.length; i++) {
            sql.append("?");
            if (i < parameters.length - 1) {
                sql.append(", ");
            }
        }
        sql.append(")}");

        try (CallableStatement callableStatement = connection.prepareCall(sql.toString())) {
            for (int i = 0; i < parameters.length; i++) {
                callableStatement.setObject(i + 1, parameters[i]);
            }
            return callableStatement.execute();
        }
    }
    
    // Método para insertar, actualizar y eliminar datos en una tabla
    public int executeSetQuery(String query, List<Object> params) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            for (int i = 0; i < params.size(); i++) {
                preparedStatement.setObject(i + 1, params.get(i));
            }
            return preparedStatement.executeUpdate(); // Retorna la cantidad de filas afectadas
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }      
    
// Método para insertar un registro y devolver el ID generado
    public int insertarConRetornarID(String sql, List<Object> parametros) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet generatedKeys = null;
        int idGenerado = -1;

        try {
            // Preparar la sentencia y especificar que queremos las claves generadas
            pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // Asignar los parámetros
            for (int i = 0; i < parametros.size(); i++) {
                pstmt.setObject(i + 1, parametros.get(i));
            }

            // Ejecutar la consulta
            int filasAfectadas = pstmt.executeUpdate();

            if (filasAfectadas > 0) {
                // Obtener las claves generadas
                generatedKeys = pstmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    idGenerado = generatedKeys.getInt(1);
                }
            } else {
                throw new SQLException("La inserción falló, no se generó ningún ID.");
            }
        } finally {
            // Cerrar los recursos
            if (generatedKeys != null) generatedKeys.close();
            if (pstmt != null) pstmt.close();
        }

        return idGenerado;
    }    
    
}
