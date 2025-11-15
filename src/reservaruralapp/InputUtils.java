
package reservaruralapp;

public class InputUtils {

    // Método general para normalizar textos
    public static String normalizarMayusculas(String texto) {
        if (texto == null) return "";
        return texto.trim().toUpperCase();
    }

    
    private static final String LETRAS = "TRWAGMYFPDXBNJZSQVHLCKE";

   
    
      // Valida un DNI español
    public static boolean validaDNI(String dni) {
        if (dni == null) return false;
        dni = normalizarMayusculas(dni);

        // Comprobamos longitud: 8 números + 1 letra
        if (dni.length() != 9) return false;

        String numeros = dni.substring(0, 8);
        char letra = dni.charAt(8);

        // Comprobamos que los primeros 8 caracteres son dígitos
        if (!numeros.matches("\\d{8}")) return false;

        int numero = Integer.parseInt(numeros);
        char letraCorrecta = LETRAS.charAt(numero % 23);

        return letra == letraCorrecta;
        
    }
    // ✅ Método para validar emails con expresión regular
    public static boolean validaEmail(String email) {
        if (email == null) return false;
        email = email.trim();
        // Regex básico: nombre@dominio.extension
        String emailRegex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$";
        return email.matches(emailRegex);
    }
    public static boolean validaTelefonoE164(String telefono) {
    if (telefono == null) return false;

    // Expresión regular para formato E.164:
    // + seguido de 1 a 15 dígitos (sin espacios, guiones, paréntesis, etc.)
    String regex = "^\\+?[1-9]\\d{1,14}$";

    return telefono.matches(regex);
}
}
    

