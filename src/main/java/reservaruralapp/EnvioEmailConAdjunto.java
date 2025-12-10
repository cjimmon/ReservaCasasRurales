package reservaruralapp;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.util.ByteArrayDataSource;
import javax.swing.JOptionPane;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import util.DBConnection;

public class EnvioEmailConAdjunto {

    private static float getXCenter(String text, PDType1Font font, float pageWidth, float fontSize) throws Exception {
        return (pageWidth - (font.getStringWidth(text) / 1000 * fontSize)) / 2;
    }

    public String obtenerEmailClientePorFactura(int idFactura) {
        String email = null;
        String sql = "SELECT c.email FROM cliente c " +
                     "JOIN reserva r ON c.id_cliente = r.id_cliente " +
                     "JOIN factura f ON r.id_reserva = f.id_reserva " +
                     "WHERE f.id_factura = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idFactura);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) email = rs.getString("email");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener email: " + e.getMessage());
        }
        return email;
    }

    public byte[] generarFacturaEnMemoria(int idFactura) {
    try {
        InputStream plantillaStream = GenerarFactura.class.getResourceAsStream("/plantilla/plantilla.pdf");
        if (plantillaStream == null) {
            JOptionPane.showMessageDialog(null, "No se encontró la plantilla PDF");
            return null;
        }

            PDDocument doc = PDDocument.load(plantillaStream);
            PDPage page = doc.getPage(0);
            float pageWidth = page.getMediaBox().getWidth();
            float y = page.getMediaBox().getHeight() * 2 / 3f;
            float marginLeft = 50;
            float fontSize = 12;
            PDType1Font fontBold = PDType1Font.HELVETICA_BOLD;
            PDType1Font fontNormal = PDType1Font.HELVETICA;

            String sql = "SELECT f.id_factura, f.fecha_emision, f.importe_total, " +
                         "r.id_reserva, r.fecha_inicio, r.fecha_fin, r.num_personas, r.estado AS estado_reserva, " +
                         "c.nombre AS cliente_nombre, c.apellidos, c.telefono, c.email, c.DNI AS dni, " +
                         "ca.nombre AS casa_nombre, ca.ubicacion " +
                         "FROM factura f " +
                         "INNER JOIN reserva r ON f.id_reserva = r.id_reserva " +
                         "INNER JOIN cliente c ON r.id_cliente = c.id_cliente " +
                         "INNER JOIN casa ca ON r.id_casa = ca.id_casa " +
                         "WHERE f.id_factura = ?";

            try (Connection con = DBConnection.getConnection();
                 PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, idFactura);
                ResultSet rs = ps.executeQuery();
                if (!rs.next()) {
                    JOptionPane.showMessageDialog(null, "No se encontró la factura con ID: " + idFactura);
                    doc.close();
                    return null;
                }

                int idFact = rs.getInt("id_factura");
                String cliente = rs.getString("cliente_nombre") + " " + rs.getString("apellidos");
                String dni = rs.getString("dni");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                String casa = rs.getString("casa_nombre") + " (" + rs.getString("ubicacion") + ")";
                String fechas = "Inicio: " + rs.getString("fecha_inicio") + "  Fin: " + rs.getString("fecha_fin");
                int numPersonas = rs.getInt("num_personas");
                String estado = rs.getString("estado_reserva");
                double total = rs.getDouble("importe_total");

                PDPageContentStream cs = new PDPageContentStream(doc, page, PDPageContentStream.AppendMode.APPEND, true);

              
                cs.beginText();
                cs.setFont(fontBold, fontSize + 2);
                cs.setNonStrokingColor(0, 0, 0); 
                cs.newLineAtOffset(getXCenter("FACTURA Nº " + idFact, fontBold, pageWidth, fontSize + 2), y);
                cs.showText("FACTURA Nº " + idFact);
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

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                doc.save(baos);
                doc.close();
                plantillaStream.close();
                return baos.toByteArray();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error generando factura en memoria: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public void enviarFacturaPorEmail(String emailCliente, byte[] pdfBytes, String nombreArchivo) {
         if (emailCliente == null || emailCliente.isBlank()) {
        JOptionPane.showMessageDialog(null, "No se pudo obtener el email del cliente.");
        return;
    }

    String remitente = "";
    String passwordApp = "";

    try (Connection conn = DBConnection.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT correoRemitente, passwordApp FROM OpcionesEmail LIMIT 1")) {

        if (rs.next()) {
            remitente = rs.getString("correoRemitente");
            passwordApp = rs.getString("passwordApp");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron datos SMTP en la base de datos.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al cargar SMTP: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
  
        Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true"); // activa STARTTLS
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587"); // puerto para STARTTLS
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com"); // confiar en Gmail

            final String remitenteFinal = remitente;
            final String passwordAppFinal = passwordApp;

            Session session = Session.getInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(remitenteFinal, passwordAppFinal);
                }
            });


    
    
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(remitente));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailCliente));
        message.setSubject("Factura");

        MimeBodyPart texto = new MimeBodyPart();
        texto.setText("Adjunto encontrará su factura.");

        MimeBodyPart adjunto = new MimeBodyPart();
        adjunto.setFileName(nombreArchivo);
        DataSource dataSource = new ByteArrayDataSource(pdfBytes, "application/pdf");
        adjunto.setDataHandler(new DataHandler(dataSource));

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(texto);
        multipart.addBodyPart(adjunto);

        message.setContent(multipart);
        Transport.send(message);

        JOptionPane.showMessageDialog(null, "Factura enviada correctamente a " + emailCliente);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al enviar email: " + e.getMessage());
        e.printStackTrace();
    }
}
}