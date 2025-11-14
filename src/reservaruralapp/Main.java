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

    }
}