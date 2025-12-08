package reservaruralapp;

import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import util.DBConnection;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class GenerarFactura {

    private static float getXCenter(String text, PDType1Font font, float pageWidth, float fontSize) throws Exception {
        return (pageWidth - (font.getStringWidth(text) / 1000 * fontSize)) / 2;
    }

    public static void generarFacturaConDialogo(int idFacturaSeleccionada) {
        try {
           
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar factura como...");
            fileChooser.setSelectedFile(new File("Factura_" + idFacturaSeleccionada + ".pdf"));
            int userSelection = fileChooser.showSaveDialog(null);
            if (userSelection != JFileChooser.APPROVE_OPTION) return;

            File fileToSave = fileChooser.getSelectedFile();
            String rutaFinal = fileToSave.getAbsolutePath();
            if (!rutaFinal.toLowerCase().endsWith(".pdf")) {
                rutaFinal += ".pdf";
                fileToSave = new File(rutaFinal);
            }

            if (fileToSave.exists()) {
                int resp = JOptionPane.showConfirmDialog(null,
                        "El archivo ya existe. ¿Desea sobrescribirlo?",
                        "Sobrescribir PDF", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (resp != JOptionPane.YES_OPTION) return;
            }

            InputStream plantillaStream = GenerarFactura.class.getResourceAsStream("/plantilla/plantilla.pdf");
            if (plantillaStream == null) {
                System.err.println("No se encontró la plantilla");
            } else {
                System.out.println("Plantilla encontrada correctamente");
            }

            PDDocument doc = PDDocument.load(plantillaStream);
            PDPage page = doc.getPage(0);
            float pageWidth = page.getMediaBox().getWidth();

            String sql = "SELECT f.id_factura, f.fecha_emision, f.importe_total, " +
                    "r.id_reserva, r.fecha_inicio, r.fecha_fin, r.num_personas, r.estado AS estado_reserva, " +
                    "c.nombre AS cliente_nombre, c.apellidos, c.telefono, c.email, c.comentarios, c.DNI AS dni, " +
                    "ca.nombre AS casa_nombre, ca.descripcion, ca.precio_noche, ca.ubicacion " +
                    "FROM Factura f " +
                    "INNER JOIN reserva r ON f.id_reserva = r.id_reserva " +
                    "INNER JOIN cliente c ON r.id_cliente = c.id_cliente " +
                    "INNER JOIN casa ca ON r.id_casa = ca.id_casa " +
                    "WHERE f.id_factura = ?";

            try (Connection con = DBConnection.getConnection();
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setInt(1, idFacturaSeleccionada);
                ResultSet rs = ps.executeQuery();
                if (!rs.next()) {
                    JOptionPane.showMessageDialog(null, "No se encontró la factura con ID: " + idFacturaSeleccionada);
                    return;
                }

                int idFactura = rs.getInt("id_factura");
                String cliente = rs.getString("cliente_nombre") + " " + rs.getString("apellidos");
                String dni = rs.getString("dni");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                String casa = rs.getString("casa_nombre") + " (" + rs.getString("ubicacion") + ")";
                String fechas = "Inicio: " + rs.getString("fecha_inicio") + "  Fin: " + rs.getString("fecha_fin");
                int numPersonas = rs.getInt("num_personas");
                String estado = rs.getString("estado_reserva");
                double total = rs.getDouble("importe_total");

            PDPageContentStream cs = new PDPageContentStream(doc, page,
            PDPageContentStream.AppendMode.APPEND, true);

            float y = page.getMediaBox().getHeight() * 2 / 3f; 
            PDType1Font fontBold = PDType1Font.HELVETICA_BOLD;
            PDType1Font fontNormal = PDType1Font.HELVETICA;
            float fontSize = 12;

            float marginLeft = 50;
   
            String textFactura = "FACTURA Nº " + idFactura;
            cs.beginText();
            cs.setFont(fontBold, fontSize + 2);
            cs.setNonStrokingColor(0, 0, 0); 
            cs.newLineAtOffset(getXCenter(textFactura, fontBold, pageWidth, fontSize + 2), y);
            cs.showText(textFactura);
            cs.endText();


                y -= 25; 
                
                y -= 40;  
                cs.beginText();
                cs.setFont(fontBold, fontSize);
                cs.newLineAtOffset(marginLeft, y);
                cs.showText("Datos del cliente:");
                cs.endText();

                y -= 20;
                cs.beginText();
                cs.setFont(fontNormal, fontSize);
                cs.newLineAtOffset(marginLeft, y);
                cs.showText(cliente + " - DNI: " + dni);
                cs.endText();

                y -= 18;
                cs.beginText();
                cs.newLineAtOffset(marginLeft, y);
                cs.showText("Tel: " + telefono + "  Email: " + email);
                cs.endText();
              
                y -= 60; 
                cs.beginText();
                cs.setFont(fontBold, fontSize);
                cs.newLineAtOffset(marginLeft, y);
                cs.showText("Datos de la reserva:");
                cs.endText();

                y -= 20;
                cs.beginText();
                cs.setFont(fontNormal, fontSize);
                cs.newLineAtOffset(marginLeft, y);
                cs.showText("Casa: " + casa);
                cs.endText();

                y -= 18;
                cs.beginText();
                cs.newLineAtOffset(marginLeft, y);
                cs.showText("Inicio: " + rs.getString("fecha_inicio") + " Fin: " + rs.getString("fecha_fin") 
                            + " | Personas: " + numPersonas + " | Estado: " + estado);
                cs.endText();

            float yTotal = 50; 
            String textTotal = "TOTAL: " + String.format("%.2f €", total);
            float textWidth = fontBold.getStringWidth(textTotal) / 1000 * fontSize;
            cs.beginText();
            cs.setFont(fontBold, fontSize);
            cs.newLineAtOffset(pageWidth - marginLeft - textWidth, yTotal);
            cs.showText(textTotal);
            cs.endText();

            cs.close();

            
                doc.save(rutaFinal);
                doc.close();
                plantillaStream.close();
            }

            JOptionPane.showMessageDialog(null, "PDF generado correctamente en:\n" + rutaFinal);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error generando factura: " + e.getMessage());
            e.printStackTrace();
        }
    }

}