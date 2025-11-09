package reservaruralapp;

import util.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        // Ejecutar la GUI en el hilo del EDT
        SwingUtilities.invokeLater(() -> {
            PantallaInicio splash = new PantallaInicio();
            splash.showSplashAndInit();
        });

        // Hilo independiente para la prueba de BD (no bloquea la GUI)
        new Thread(() -> {
            pruebaBD();
        }).start();
    }


    private static void pruebaBD() {
        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cliente");
            System.out.println("Lista de clientes:");
            while (rs.next()) {
                System.out.println(rs.getInt("id_cliente") + " - " + rs.getString("nombre") + " " + rs.getString("apellido"));
            }
            DBConnection.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
