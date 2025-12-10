package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

   private static final String URL = "jdbc:sqlite:" + System.getProperty("user.dir") + "/reservas_rurales.db";
    private static Connection conn = null;

    public static Connection getConnection() {
        try {
            Class.forName("org.sqlite.JDBC"); 
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(URL);
                System.out.println("Conexión establecida con BD");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Driver SQLite no encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }
        return conn;
    }

    public static void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Conexión finalizada");
            }
        } catch (SQLException e) {
            System.err.println("Error al finalizar conexión: " + e.getMessage());
        }
    }
}