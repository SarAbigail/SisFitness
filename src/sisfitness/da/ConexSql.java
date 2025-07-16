/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfitness.da;

import java.sql.*;
import java.util.List;

public class ConexSql {

    //Constantes de configuración de la base de datos
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/bd_sistcontrol";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "sqladmin";

    //Instancia única de la clase
    private static ConexSql instancia;

    //Conexion activa con la base de datos
    private Connection connection;

    // Constructor privado para evitar la creacion de multiples instancias
    private ConexSql() throws SQLException {
        //Conexion a base de datos
        connect();
    }

    // Método público para obtener la instancia única
    public static ConexSql getInstancia() throws SQLException {
        //Si no existe o la conexión está cerrada, se crea una nueva instancia
        if (instancia == null || instancia.connection == null || instancia.connection.isClosed()) {
            instancia = new ConexSql();
        }
        return instancia;
    }

    //Método que establece la conexion
    private void connect() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Conexión establecida correctamente (ahora con singleton).");
        }
    }

    //Método que cierra la conexion
    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            System.out.println("Conexión cerrada.");
        }
    }

    //Método que ejecuta un query sin parámetros
    public ResultSet executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    //Método que ejecuta un query con parámetros
    public ResultSet executeQuery(String query, List<Object> params) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(query);
        for (int i = 0; i < params.size(); i++) {
            ps.setObject(i + 1, params.get(i));
        }
        return ps.executeQuery();
    }

    // Método que ejecuta un procedimiento almacenado con parámetros
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
            PreparedStatement ps = connection.prepareStatement(query);
            for (int i = 0; i < params.size(); i++) {
                ps.setObject(i + 1, params.get(i));
            }
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    // Método para insertar un registro y devolver el ID generado
    public int insertarConRetornarID(String sql, List<Object> parametros) throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            for (int i = 0; i < parametros.size(); i++) {
                pstmt.setObject(i + 1, parametros.get(i));
            }

            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1);
                    }
                }
            }
            throw new SQLException("La inserción falló, no se generó ningún ID.");
        }
    }
}
