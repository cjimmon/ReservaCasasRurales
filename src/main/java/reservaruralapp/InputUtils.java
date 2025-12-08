
package reservaruralapp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InputUtils {

    public static String normalizarMayusculas(String texto) {
        if (texto == null) return "";
        return texto.trim().toUpperCase();
    }

    
    private static final String LETRAS = "TRWAGMYFPDXBNJZSQVHLCKE";

   
    public static boolean validaDNI(String dni) {
        if (dni == null) return false;
        dni = normalizarMayusculas(dni);

        if (dni.length() != 9) return false;

        String numeros = dni.substring(0, 8);
        char letra = dni.charAt(8);

        if (!numeros.matches("\\d{8}")) return false;

        int numero = Integer.parseInt(numeros);
        char letraCorrecta = LETRAS.charAt(numero % 23);

        return letra == letraCorrecta;
        
    }
    public static boolean validaEmail(String email) {
        if (email == null) return false;
        email = email.trim();
        String emailRegex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$";
        return email.matches(emailRegex);
    }
    public static boolean validaTelefonoE164(String telefono) {
    if (telefono == null) return false;

    String regex = "^\\+?[1-9]\\d{1,14}$";

    return telefono.matches(regex);
}
    public static boolean validaFecha(String fecha) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    try {
        LocalDate.parse(fecha, formatter);
        return true;
    } catch (Exception e) {
        return false;
    }
    
    }
}
    

