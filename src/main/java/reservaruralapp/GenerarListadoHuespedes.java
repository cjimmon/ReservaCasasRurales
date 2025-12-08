package reservaruralapp;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import util.DBConnection;

public class GenerarListadoHuespedes {

    public static void generarPDFHuespedes(String inicioSQL, String finSQL) {
        try (Connection con = DBConnection.getConnection()) {

            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Guardar listado de huéspedes...");
            chooser.setSelectedFile(new File("Listado_Huespedes_" + inicioSQL + "_a_" + finSQL + ".pdf"));

            if (chooser.showSaveDialog(null) != JFileChooser.APPROVE_OPTION) return;

            File destino = chooser.getSelectedFile();
            String rutaFinal = destino.getAbsolutePath();
            if (!rutaFinal.toLowerCase().endsWith(".pdf"))
                rutaFinal += ".pdf";

            String sql = "SELECT id_huesped, id_reserva, nombre_completo, tipo_documento, numero_documento, sexo, " +
                         "fecha_nacimiento, nacionalidad, domicilio, fecha_entrada, fecha_salida " +
                         "FROM Huespedes " +
                         "WHERE (substr(fecha_entrada,7,4)||'-'||substr(fecha_entrada,4,2)||'-'||substr(fecha_entrada,1,2)) <= ? " +
                         "AND (substr(fecha_salida,7,4)||'-'||substr(fecha_salida,4,2)||'-'||substr(fecha_salida,1,2)) >= ? " +
                         "ORDER BY fecha_entrada";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, finSQL);
            ps.setString(2, inicioSQL);

            ResultSet rs = ps.executeQuery();

            PDDocument pdf = new PDDocument();
            PDPage page = new PDPage();
            pdf.addPage(page);

            PDPageContentStream cs = new PDPageContentStream(pdf, page);

            cs.beginText();
            cs.setFont(PDType1Font.HELVETICA_BOLD, 18);
            cs.newLineAtOffset(40, 750);
            cs.showText("Listado de Huéspedes (" + inicioSQL + " a " + finSQL + ")");
            cs.endText();

            float y = 715;  
            float anchoMax = 520; 

            while (rs.next()) {
                String[][] campos = {
                    
                    {"Reserva: ", String.valueOf(rs.getInt("id_reserva"))},
                    {"Nombre: ", rs.getString("nombre_completo")},
                    {"Documento: ", rs.getString("tipo_documento") + " " + rs.getString("numero_documento")},
                    {"Sexo: ", rs.getString("sexo")},
                    {"Nacionalidad: ", rs.getString("nacionalidad")},
                    {"Fecha Nacimiento: ", rs.getString("fecha_nacimiento")},
                    {"Domicilio: ", rs.getString("domicilio")},
                    {"Fecha Entrada: ", rs.getString("fecha_entrada")},
                    {"Fecha Salida: ", rs.getString("fecha_salida")}
                };

                for (String[] campo : campos) {
                    cs.beginText();
                    cs.setFont(PDType1Font.HELVETICA, 10); 
                    cs.newLineAtOffset(40, y);
                    cs.showText(campo[0]);
                    cs.endText();

                    float offsetX = 40 + PDType1Font.HELVETICA.getStringWidth(campo[0]) / 1000 * 10;

                    cs.beginText();
                    cs.setFont(PDType1Font.HELVETICA_BOLD, 10); 
                    cs.newLineAtOffset(offsetX, y);
                    cs.showText(campo[1]);
                    cs.endText();

                    y -= 15;

                    if (y < 50) { 
                        cs.close();
                        page = new PDPage();
                        pdf.addPage(page);
                        cs = new PDPageContentStream(pdf, page);
                        y = 750;
                    }
                }

                y -= 10; 
            }

            cs.close();
            pdf.save(rutaFinal);
            pdf.close();

            JOptionPane.showMessageDialog(null, "PDF generado correctamente:\n" + rutaFinal);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al generar PDF: " + e.getMessage());
        }
    }
}
