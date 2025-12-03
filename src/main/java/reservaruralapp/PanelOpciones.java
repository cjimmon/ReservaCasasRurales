
package reservaruralapp;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import javax.mail.internet.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.*;
import javax.mail.util.ByteArrayDataSource;
import javax.swing.JOptionPane;
import util.DBConnection;



public class PanelOpciones extends javax.swing.JPanel {

    public PanelOpciones() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelOpciones = new javax.swing.JPanel();
        LabelOpciones = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        BotonGuardarOpciones = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TextoNombreOpciones = new javax.swing.JTextField();
        TextoContraseñaOpciones = new javax.swing.JTextField();
        BotonBuscarOpciones = new javax.swing.JButton();
        BotonEliminarOpciones = new javax.swing.JButton();
        AdminRecepcionista = new javax.swing.JComboBox<>();
        CopiaSeguridad = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        PanelOpciones.setBackground(new java.awt.Color(255, 255, 255));

        LabelOpciones.setText("CREAR / MODIFICAR USUARIOS");

        jSeparator3.setBackground(new java.awt.Color(0, 102, 51));
        jSeparator3.setForeground(new java.awt.Color(0, 102, 51));

        BotonGuardarOpciones.setBackground(new java.awt.Color(233, 249, 233));
        BotonGuardarOpciones.setForeground(new java.awt.Color(51, 102, 0));
        BotonGuardarOpciones.setText("Guardar");
        BotonGuardarOpciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGuardarOpcionesActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre:");

        jLabel3.setText("Contraseña:");

        jLabel4.setText("Rol:");

        TextoNombreOpciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextoNombreOpcionesActionPerformed(evt);
            }
        });

        TextoContraseñaOpciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextoContraseñaOpcionesActionPerformed(evt);
            }
        });

        BotonBuscarOpciones.setBackground(new java.awt.Color(233, 249, 233));
        BotonBuscarOpciones.setForeground(new java.awt.Color(51, 102, 0));
        BotonBuscarOpciones.setText("Buscar");
        BotonBuscarOpciones.setToolTipText("");
        BotonBuscarOpciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBuscarOpcionesActionPerformed(evt);
            }
        });

        BotonEliminarOpciones.setBackground(new java.awt.Color(233, 249, 233));
        BotonEliminarOpciones.setForeground(new java.awt.Color(51, 102, 0));
        BotonEliminarOpciones.setText("Eliminar Usuario");
        BotonEliminarOpciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEliminarOpcionesActionPerformed(evt);
            }
        });

        AdminRecepcionista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "recepcionista" }));
        AdminRecepcionista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminRecepcionistaActionPerformed(evt);
            }
        });

        CopiaSeguridad.setBackground(new java.awt.Color(245, 255, 245));
        CopiaSeguridad.setForeground(new java.awt.Color(51, 102, 0));
        CopiaSeguridad.setText("Copia Seguridad BBDD");
        CopiaSeguridad.setToolTipText("Manda una copia de la BBDD al correo");
        CopiaSeguridad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopiaSeguridadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelOpcionesLayout = new javax.swing.GroupLayout(PanelOpciones);
        PanelOpciones.setLayout(PanelOpcionesLayout);
        PanelOpcionesLayout.setHorizontalGroup(
            PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelOpcionesLayout.createSequentialGroup()
                .addGroup(PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(PanelOpcionesLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelOpcionesLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(TextoNombreOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelOpcionesLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(26, 26, 26)
                                .addComponent(TextoContraseñaOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelOpcionesLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(45, 45, 45)
                                .addComponent(AdminRecepcionista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelOpcionesLayout.createSequentialGroup()
                                .addComponent(BotonBuscarOpciones)
                                .addGap(45, 45, 45)
                                .addComponent(BotonGuardarOpciones)))
                        .addGap(672, 672, 672))
                    .addGroup(PanelOpcionesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PanelOpcionesLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(BotonEliminarOpciones)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CopiaSeguridad)
                                .addGap(288, 288, 288))
                            .addComponent(LabelOpciones, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1133, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelOpcionesLayout.setVerticalGroup(
            PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelOpciones)
                .addGap(32, 32, 32)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TextoNombreOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TextoContraseñaOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(AdminRecepcionista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonBuscarOpciones)
                    .addComponent(BotonGuardarOpciones))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 346, Short.MAX_VALUE)
                .addGroup(PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CopiaSeguridad)
                    .addComponent(BotonEliminarOpciones))
                .addGap(38, 38, 38))
        );

        add(PanelOpciones, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void BotonGuardarOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGuardarOpcionesActionPerformed
        String username = TextoNombreOpciones.getText().trim().toUpperCase();
        String password = TextoContraseñaOpciones.getText().trim().toUpperCase();
        String rol = AdminRecepcionista.getSelectedItem().toString().trim().toLowerCase();


        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nombre y contraseña son obligatorios.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String sqlCheck = "SELECT * FROM usuario WHERE UPPER(username) = UPPER(?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement psCheck = conn.prepareStatement(sqlCheck)) {

            psCheck.setString(1, username);
            ResultSet rs = psCheck.executeQuery();

            if (rs.next()) {
                // UPDATE
                String sqlUpdate = "UPDATE usuario SET password = ?, rol = ? WHERE UPPER(username) = UPPER(?)";

                try (PreparedStatement psUpdate = conn.prepareStatement(sqlUpdate)) {
                    psUpdate.setString(1, password);
                    psUpdate.setString(2, rol);
                    psUpdate.setString(3, username);
                    psUpdate.executeUpdate();

                    JOptionPane.showMessageDialog(this, "Usuario actualizado correctamente.");
                }

            } else {
                // INSERT
                String sqlInsert = "INSERT INTO usuario(username, password, rol) VALUES(?,?,?)";

                try (PreparedStatement psInsert = conn.prepareStatement(sqlInsert)) {
                    psInsert.setString(1, username);
                    psInsert.setString(2, password);
                    psInsert.setString(3, rol);
                    psInsert.executeUpdate();

                    JOptionPane.showMessageDialog(this, "Usuario creado correctamente.");
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    

    }//GEN-LAST:event_BotonGuardarOpcionesActionPerformed

    private void TextoNombreOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextoNombreOpcionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextoNombreOpcionesActionPerformed

    private void TextoContraseñaOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextoContraseñaOpcionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextoContraseñaOpcionesActionPerformed

    private void BotonBuscarOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBuscarOpcionesActionPerformed
         String nombre = TextoNombreOpciones.getText().trim().toUpperCase();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduce un nombre para buscar.");
            return;
        }

        String sql = "SELECT * FROM usuario WHERE UPPER(username) = UPPER(?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                TextoContraseñaOpciones.setText(rs.getString("password"));
                AdminRecepcionista.setSelectedItem(rs.getString("rol").toUpperCase());
            } else {
                TextoContraseñaOpciones.setText("");
                AdminRecepcionista.setSelectedIndex(0);
                JOptionPane.showMessageDialog(this, "Usuario no encontrado.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al buscar usuario: " + e.getMessage());
        }
    
    }//GEN-LAST:event_BotonBuscarOpcionesActionPerformed

    private void BotonEliminarOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEliminarOpcionesActionPerformed
         String nombre = TextoNombreOpciones.getText().trim().toUpperCase();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduce un nombre para eliminar.");
            return;
        }

        String sql = "DELETE FROM usuario WHERE UPPER(username) = UPPER(?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nombre);
            int filas = ps.executeUpdate();

            if (filas > 0) {
                JOptionPane.showMessageDialog(this, "Usuario eliminado correctamente.");
                TextoNombreOpciones.setText("");
                TextoContraseñaOpciones.setText("");
                AdminRecepcionista.setSelectedIndex(0);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró el usuario para eliminar.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al eliminar usuario: " + e.getMessage());
        }
    }//GEN-LAST:event_BotonEliminarOpcionesActionPerformed

    private void AdminRecepcionistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminRecepcionistaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AdminRecepcionistaActionPerformed

    private void CopiaSeguridadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CopiaSeguridadActionPerformed
         try {
        
        String nombreOriginal = "C:\\Users\\jimen\\Documents\\NetBeansProjects\\ReservaCasasRurales\\reservas_rurales.db"; 
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String fecha = LocalDateTime.now().format(dtf);
        String nombreBackup = "backup_reservaRural_" + fecha + ".db";

        
        byte[] backupBytes = Files.readAllBytes(Paths.get(nombreOriginal));

        
        String remitente = "carlosjimenezmontalvo@gmail.com";
        String passwordApp = "safh kvnr ftie qewj";
        String destinatario = "carlosjimenezmontalvo@gmail.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remitente, passwordApp);
            }
        });

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(remitente));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
        message.setSubject("Backup ReservaRuralApp - " + fecha);

        MimeBodyPart texto = new MimeBodyPart();
        texto.setText("Adjunto encontrará la copia de seguridad de la base de datos.");

        MimeBodyPart adjunto = new MimeBodyPart();
        adjunto.setFileName(nombreBackup);
        DataSource dataSource = new ByteArrayDataSource(backupBytes, "application/octet-stream");
        adjunto.setDataHandler(new DataHandler(dataSource));

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(texto);
        multipart.addBodyPart(adjunto);

        message.setContent(multipart);
        Transport.send(message);

        JOptionPane.showMessageDialog(this, "Copia de seguridad enviada correctamente.");

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al crear/enviar copia: " + e.getMessage());
        e.printStackTrace();
    }
    }//GEN-LAST:event_CopiaSeguridadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> AdminRecepcionista;
    private javax.swing.JButton BotonBuscarOpciones;
    private javax.swing.JButton BotonEliminarOpciones;
    private javax.swing.JButton BotonGuardarOpciones;
    private javax.swing.JButton CopiaSeguridad;
    private javax.swing.JLabel LabelOpciones;
    private javax.swing.JPanel PanelOpciones;
    private javax.swing.JTextField TextoContraseñaOpciones;
    private javax.swing.JTextField TextoNombreOpciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
