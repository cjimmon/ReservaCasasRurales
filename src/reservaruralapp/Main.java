package reservaruralapp;

import util.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cliente");

            System.out.println("Lista de clientes:");
            while (rs.next()) {
                System.out.println(rs.getInt("id_cliente") + " - " +
                                   rs.getString("nombre") + " " +
                                   rs.getString("apellidos"));
            }

            DBConnection.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
