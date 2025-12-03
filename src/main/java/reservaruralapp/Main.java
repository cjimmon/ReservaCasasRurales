package reservaruralapp;


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