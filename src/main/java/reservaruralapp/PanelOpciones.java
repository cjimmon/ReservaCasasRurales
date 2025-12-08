
package reservaruralapp;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import javax.mail.internet.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
        cargarOpciones();
    }
private void cargarOpciones() {
    try (Connection conn = DBConnection.getConnection()){
        String sql = "SELECT correoRemitente, passwordApp FROM OpcionesEmail LIMIT 1";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            PasswordCorreo.setText(rs.getString("passwordApp"));
            RemitenteCorreo.setText(rs.getString("correoRemitente"));
        }

    } catch (Exception e) {
        System.out.println("Error al cargar opciones: " + e.getMessage());
    }
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
        RemitenteCorreo = new javax.swing.JTextField();
        PasswordCorreo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Textodestinatario = new javax.swing.JTextField();
        ActualizarSMTP = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();

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

        AdminRecepcionista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMIN", "RECEPCIONISTA" }));
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

        jLabel2.setText("Remitente");

        jLabel5.setText("Password App");

        Textodestinatario.setToolTipText("Destinatario");
        Textodestinatario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextodestinatarioActionPerformed(evt);
            }
        });

        ActualizarSMTP.setBackground(new java.awt.Color(239, 253, 239));
        ActualizarSMTP.setForeground(new java.awt.Color(51, 102, 0));
        ActualizarSMTP.setText("Actualizar");
        ActualizarSMTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarSMTPActionPerformed(evt);
            }
        });

        jLabel6.setText("Configurar SMTP");

        jLabel7.setText("Enviar copia de Seguridad");

        jLabel8.setText("OTRAS OPCIONES");

        javax.swing.GroupLayout PanelOpcionesLayout = new javax.swing.GroupLayout(PanelOpciones);
        PanelOpciones.setLayout(PanelOpcionesLayout);
        PanelOpcionesLayout.setHorizontalGroup(
            PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelOpcionesLayout.createSequentialGroup()
                .addGroup(PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(PanelOpcionesLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 1133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(PanelOpcionesLayout.createSequentialGroup()
                                    .addGap(15, 15, 15)
                                    .addComponent(LabelOpciones))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelOpcionesLayout.createSequentialGroup()
                            .addGap(87, 87, 87)
                            .addGroup(PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(PanelOpcionesLayout.createSequentialGroup()
                                    .addGroup(PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel5))
                                    .addGap(47, 47, 47)
                                    .addGroup(PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(PasswordCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(RemitenteCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(12, 12, 12)
                                    .addComponent(ActualizarSMTP))
                                .addGroup(PanelOpcionesLayout.createSequentialGroup()
                                    .addGroup(PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PanelOpcionesLayout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addGap(50, 50, 50)
                                            .addComponent(TextoNombreOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(PanelOpcionesLayout.createSequentialGroup()
                                            .addGroup(PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel4))
                                            .addGap(34, 34, 34)
                                            .addGroup(PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(AdminRecepcionista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(TextoContraseñaOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGap(98, 98, 98)
                                    .addGroup(PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(BotonGuardarOpciones)
                                        .addComponent(BotonBuscarOpciones)
                                        .addComponent(BotonEliminarOpciones))))))
                    .addGroup(PanelOpcionesLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(Textodestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(CopiaSeguridad))
                    .addGroup(PanelOpcionesLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
                            .addComponent(jSeparator4)))
                    .addGroup(PanelOpcionesLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel8)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        PanelOpcionesLayout.setVerticalGroup(
            PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelOpcionesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(LabelOpciones)
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TextoNombreOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonBuscarOpciones))
                .addGap(25, 25, 25)
                .addGroup(PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TextoContraseñaOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonGuardarOpciones))
                .addGap(24, 24, 24)
                .addGroup(PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(AdminRecepcionista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonEliminarOpciones))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel6)
                .addGap(19, 19, 19)
                .addGroup(PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RemitenteCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(ActualizarSMTP))
                    .addComponent(PasswordCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(50, 50, 50)
                .addGroup(PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Textodestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CopiaSeguridad))
                .addGap(100, 100, 100))
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
            
            String sqlUpdate = "UPDATE usuario SET password = ?, rol = ? WHERE UPPER(username) = UPPER(?)";

            try (PreparedStatement psUpdate = conn.prepareStatement(sqlUpdate)) {
                psUpdate.setString(1, password);
                psUpdate.setString(2, rol);
                psUpdate.setString(3, username);
                psUpdate.executeUpdate();

                JOptionPane.showMessageDialog(this, "Usuario actualizado correctamente.");
            }

        } else {
            
            String sqlInsert = "INSERT INTO usuario(username, password, rol) VALUES(?,?,?)";

            try (PreparedStatement psInsert = conn.prepareStatement(sqlInsert)) {
                psInsert.setString(1, username);
                psInsert.setString(2, password);
                psInsert.setString(3, rol);
                psInsert.executeUpdate();

                JOptionPane.showMessageDialog(this, "Usuario creado correctamente.");
            }
        }

      
        String correoSMTP = TextoNombreOpciones.getText().trim();
        String contrasenaSMTP = TextoContraseñaOpciones.getText().trim();

        if (!correoSMTP.isEmpty() && !contrasenaSMTP.isEmpty()) {

            
            String checkOpciones = "SELECT COUNT(*) FROM opciones";
            PreparedStatement psOpcCheck = conn.prepareStatement(checkOpciones);
            ResultSet rsOpc = psOpcCheck.executeQuery();
            rsOpc.next();
            boolean existe = rsOpc.getInt(1) > 0;

            if (existe) {
                
                String updateOpc = "UPDATE opciones SET correoRemitente=?, contrasenaApp=? WHERE id=1";
                PreparedStatement psUpdateOpc = conn.prepareStatement(updateOpc);
                psUpdateOpc.setString(1, correoSMTP);
                psUpdateOpc.setString(2, contrasenaSMTP);
                psUpdateOpc.executeUpdate();
            } else {
                
                String insertOpc = "INSERT INTO opciones(correoRemitente, contrasenaApp) VALUES (?,?)";
                PreparedStatement psInsertOpc = conn.prepareStatement(insertOpc);
                psInsertOpc.setString(1, correoSMTP);
                psInsertOpc.setString(2, contrasenaSMTP);
                psInsertOpc.executeUpdate();
            }
        }

        JOptionPane.showMessageDialog(this, "Datos de correo SMTP guardados correctamente.");

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

        
        String remitente = "";
        String passwordApp = "";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT correoRemitente, passwordApp FROM OpcionesEmail LIMIT 1")) {
            if (rs.next()) {
                remitente = rs.getString("correoRemitente");
                passwordApp = rs.getString("passwordApp");
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró el remitente en la base de datos.");
                return;
            }
        }

        
        String destinatario = Textodestinatario.getText().trim();
        if (destinatario.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduce un destinatario.");
            return;
        }

        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

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

    private void ActualizarSMTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarSMTPActionPerformed
         String nuevoCorreo = RemitenteCorreo.getText().trim();
    String nuevaContrasena = PasswordCorreo.getText().trim();

    if (nuevoCorreo.isEmpty() || nuevaContrasena.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Introduce correo y contraseña para actualizar.", "Aviso", JOptionPane.WARNING_MESSAGE);
        return;
    }

    try (Connection conn = DBConnection.getConnection()) {

        
        String checkSql = "SELECT COUNT(*) FROM OpcionesEmail";
        PreparedStatement psCheck = conn.prepareStatement(checkSql);
        ResultSet rsCheck = psCheck.executeQuery();
        rsCheck.next();
        boolean existe = rsCheck.getInt(1) > 0;

        if (existe) {
            
            String updateSql = "UPDATE OpcionesEmail SET correoRemitente = ?, passwordApp = ? WHERE id = 1";
            PreparedStatement psUpdate = conn.prepareStatement(updateSql);
            psUpdate.setString(1, nuevoCorreo);
            psUpdate.setString(2, nuevaContrasena);
            psUpdate.executeUpdate();
        } else {
            
            String insertSql = "INSERT INTO OpcionesEmail(correoRemitente, passwordApp) VALUES(?, ?)";
            PreparedStatement psInsert = conn.prepareStatement(insertSql);
            psInsert.setString(1, nuevoCorreo);
            psInsert.setString(2, nuevaContrasena);
            psInsert.executeUpdate();
        }

        JOptionPane.showMessageDialog(this, "Datos SMTP guardados correctamente.");

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al guardar SMTP: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_ActualizarSMTPActionPerformed

    private void TextodestinatarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextodestinatarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextodestinatarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ActualizarSMTP;
    private javax.swing.JComboBox<String> AdminRecepcionista;
    private javax.swing.JButton BotonBuscarOpciones;
    private javax.swing.JButton BotonEliminarOpciones;
    private javax.swing.JButton BotonGuardarOpciones;
    private javax.swing.JButton CopiaSeguridad;
    private javax.swing.JLabel LabelOpciones;
    private javax.swing.JPanel PanelOpciones;
    private javax.swing.JTextField PasswordCorreo;
    private javax.swing.JTextField RemitenteCorreo;
    private javax.swing.JTextField TextoContraseñaOpciones;
    private javax.swing.JTextField TextoNombreOpciones;
    private javax.swing.JTextField Textodestinatario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    // End of variables declaration//GEN-END:variables
}
