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

public class GenerarListadoReservas {

    public static void generarPDFreservas(String inicioSQL, String finSQL) {
        try (Connection con = DBConnection.getConnection()) {

            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Guardar listado de reservas...");
            chooser.setSelectedFile(new File("Listado_Reservas_" + inicioSQL + "_a_" + finSQL + ".pdf"));
            if (chooser.showSaveDialog(null) != JFileChooser.APPROVE_OPTION) return;

            File destino = chooser.getSelectedFile();
            String rutaFinal = destino.getAbsolutePath();
            if (!rutaFinal.toLowerCase().endsWith(".pdf"))
                rutaFinal += ".pdf";

            String sql = """
                SELECT 
                    r.id_reserva,
                    c.nombre       AS cliente_nombre,
                    c.apellidos    AS cliente_apellidos,
                    ca.nombre      AS casa,
                    r.fecha_inicio,
                    r.fecha_fin,
                    r.num_personas,
                    r.estado,
                    f.importe_total
                FROM reserva r
                JOIN cliente c  ON r.id_cliente = c.id_cliente
                JOIN casa ca    ON r.id_casa = ca.id_casa
                LEFT JOIN factura f  ON f.id_reserva = r.id_reserva
                WHERE (substr(r.fecha_inicio, 7, 4) || '-' || substr(r.fecha_inicio, 4, 2) || '-' || substr(r.fecha_inicio, 1, 2)) <= ?
                  AND (substr(r.fecha_fin,     7, 4) || '-' || substr(r.fecha_fin,     4, 2) || '-' || substr(r.fecha_fin,     1, 2)) >= ?
                ORDER BY r.fecha_inicio;
            """;

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
            cs.showText("Listado de Reservas: " + inicioSQL + " a " + finSQL);
            cs.endText();

            float y = 720;

            while (rs.next()) {

                double total = rs.getDouble("importe_total");
                if (rs.wasNull()) total = 0.0;

                String linea1 = 
                        "ID: " + rs.getInt("id_reserva") +
                        " | Cliente: " + rs.getString("cliente_apellidos") + ", " + rs.getString("cliente_nombre") +
                        " | Casa: " + rs.getString("casa") +
                        " | " + rs.getString("fecha_inicio") + " -> " + rs.getString("fecha_fin");

                String linea2 =
                        "Personas: " + rs.getInt("num_personas") +
                        " | Estado: " + rs.getString("estado") +
                        " | Total: " + total + " €";

                cs.beginText();
                cs.setFont(PDType1Font.HELVETICA, 10);
                cs.newLineAtOffset(40, y);
                cs.showText(linea1);
                cs.endText();
                y -= 15;

                cs.beginText();
                cs.setFont(PDType1Font.HELVETICA, 10);
                cs.newLineAtOffset(60, y);
                cs.showText(linea2);
                cs.endText();
                y -= 22;

                cs.beginText();
                cs.setFont(PDType1Font.HELVETICA, 8);
                cs.newLineAtOffset(40, y);
                cs.showText("------------------------------------------------------------");
                cs.endText();
                y -= 18;

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
            e.printStackTrace();
        }
    }
}
