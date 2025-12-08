package reservaruralapp;

import javax.swing.JButton;

public class ControlAcceso {

    private static String rolActual = "admin";

    public static void setRol(String rol) {
        rolActual = rol;
    }

    public static String getRol() {
        return rolActual;
    }

    public static void aplicarPermisos(JButton... botones) {

        switch (rolActual) {

            case "admin":
                
                break;

            case "recepcionista":
                
                for (JButton b : botones) {
                    String txt = b.getText().trim().toLowerCase();

                    if (txt.contains("eliminar") ||
                        txt.contains("borrar") ||
                        txt.contains("email") ||
                        txt.contains("guardar") ||
                        txt.contains("opciones")){
                        

                        b.setVisible(false);
                    }
                }
                break;

            
        }
    }
}
