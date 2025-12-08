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

public class GenerarListadoClientes {

    public static void generarPDFcliente(String inicioSQL, String finSQL) {
        try (Connection con = DBConnection.getConnection()) {

            
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Guardar listado de clientes...");
            chooser.setSelectedFile(new File("Listado_Clientes_" + inicioSQL + "_a_" + finSQL + ".pdf"));

            if (chooser.showSaveDialog(null) != JFileChooser.APPROVE_OPTION) return;

            File destino = chooser.getSelectedFile();
            String rutaFinal = destino.getAbsolutePath();
            if (!rutaFinal.toLowerCase().endsWith(".pdf"))
                rutaFinal += ".pdf";

            
            String sql = "SELECT c.nombre, c.apellidos, c.DNI, c.telefono, c.email " +
                         "FROM cliente c " +
                         "JOIN reserva r ON c.id_cliente = r.id_cliente " +
                         "WHERE (substr(r.fecha_inicio,7,4)||'-'||substr(r.fecha_inicio,4,2)||'-'||substr(r.fecha_inicio,1,2)) <= ? " +
                         "AND (substr(r.fecha_fin,7,4)||'-'||substr(r.fecha_fin,4,2)||'-'||substr(r.fecha_fin,1,2)) >= ? " +
                         "GROUP BY c.id_cliente " +
                         "ORDER BY c.apellidos";

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
            cs.showText("Listado de Clientes (" + inicioSQL + " a " + finSQL + ")");
            cs.endText();

            float y = 715;  
            float anchoMax = 520; 

            while (rs.next()) {
                String linea = rs.getString("apellidos") + ", " + rs.getString("nombre") +
                               " | DNI: " + rs.getString("DNI") +
                               " | Tel: " + rs.getString("telefono") +
                               " | Email: " + rs.getString("email");

                float textWidth = PDType1Font.HELVETICA.getStringWidth(linea) / 1000 * 10;

                if (textWidth <= anchoMax) {
                   
                    cs.beginText();
                    cs.setFont(PDType1Font.HELVETICA, 10);
                    cs.newLineAtOffset(40, y);
                    cs.showText(linea);
                    cs.endText();
                    y -= 22;
                } else {
                    
                    String[] partes = linea.split("\\| Email:", 2);
                    String linea1 = partes[0] + "|";
                    String linea2 = "Email:" + partes[1];

                    cs.beginText();
                    cs.setFont(PDType1Font.HELVETICA, 10);
                    cs.newLineAtOffset(40, y);
                    cs.showText(linea1);
                    cs.endText();

                    y -= 15;

                    cs.beginText();
                    cs.setFont(PDType1Font.HELVETICA, 10);
                    cs.newLineAtOffset(40, y);
                    cs.showText(linea2);
                    cs.endText();

                    y -= 25;
                }
               
                if (y < 50) {
                    cs.close();
                    page = new PDPage();
                    pdf.addPage(page);
                    cs = new PDPageContentStream(pdf, page);
                    y = 750;
                }
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
