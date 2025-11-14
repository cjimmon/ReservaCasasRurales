package reservaruralapp;

import util.DBConnection;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.SpinnerDateModel;
/**
 *
 * @author jimen
 */
public class PanelNuevaReserva extends javax.swing.JPanel {

    public PanelNuevaReserva() {
        initComponents();
        cargarCasasEnComboBox();
        configurarSpinnersFecha();
    }

    private void configurarSpinnersFecha() {
        // Configurar jSpinnerFechaInicio
        jSpinnerFechaInicio.setModel(new SpinnerDateModel());
        jSpinnerFechaInicio.setEditor(new JSpinner.DateEditor(jSpinnerFechaInicio, "dd/MM/yyyy"));
        jSpinnerFechaInicio.setValue(new java.util.Date()); // fecha actual por defecto

        // Configurar jSpinnerFechaFin
        jSpinnerFechaFin.setModel(new SpinnerDateModel());
        jSpinnerFechaFin.setEditor(new JSpinner.DateEditor(jSpinnerFechaFin, "dd/MM/yyyy"));
        jSpinnerFechaFin.setValue(new java.util.Date()); // fecha actual por defecto
    }
    

 private void cargarCasasEnComboBox() {
    casaReserva.removeAllItems(); // Limpiar el combo primero
        String sql = "SELECT nombre FROM casa";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                casaReserva.addItem(rs.getString("nombre"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar casas: " + e.getMessage());
        }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        PanelOpciones = new javax.swing.JPanel();
        LabelOpciones = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        apelleidosReserva = new javax.swing.JTextField();
        DNIReserva = new javax.swing.JTextField();
        telefonoReserva = new javax.swing.JTextField();
        emailReserva = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        casaReserva = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        numeroPersonasReserva = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        guardarNuevaReserva = new javax.swing.JButton();
        nombreReserva = new javax.swing.JTextField();
        limpiarReserva = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        comentarioReserva = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        estadoReserva = new javax.swing.JComboBox<>();
        jSpinnerFechaInicio = new javax.swing.JSpinner();
        jSpinnerFechaFin = new javax.swing.JSpinner();

        LabelOpciones.setText("NUEVA RESERVA");

        jSeparator3.setBackground(new java.awt.Color(0, 102, 51));
        jSeparator3.setForeground(new java.awt.Color(0, 102, 51));

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellidos");

        jLabel4.setText("DNI");

        jLabel5.setText("Telefono");

        jLabel6.setText("Email");

        apelleidosReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apelleidosReservaActionPerformed(evt);
            }
        });

        telefonoReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonoReservaActionPerformed(evt);
            }
        });

        emailReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailReservaActionPerformed(evt);
            }
        });

        jLabel7.setText("Casa");

        casaReserva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        casaReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casaReservaActionPerformed(evt);
            }
        });

        jLabel8.setText("Fecha Entrada");

        jLabel9.setText("Fecha Salida");

        jLabel10.setText("Nº de persona");

        guardarNuevaReserva.setText("Guardar");
        guardarNuevaReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarNuevaReservaActionPerformed(evt);
            }
        });

        nombreReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreReservaActionPerformed(evt);
            }
        });

        limpiarReserva.setText("Limpiar");
        limpiarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarReservaActionPerformed(evt);
            }
        });

        jLabel1.setText("Comentarios");

        comentarioReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comentarioReservaActionPerformed(evt);
            }
        });

        jLabel12.setText("Estado");

        estadoReserva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pendiente", "cancelada", "confirmada" }));
        estadoReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadoReservaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombreReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(emailReserva, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                    .addComponent(telefonoReserva, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DNIReserva, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(apelleidosReserva)
                                    .addComponent(comentarioReserva))
                                .addGap(125, 125, 125)
                                .addComponent(guardarNuevaReserva)
                                .addGap(18, 18, 18)
                                .addComponent(limpiarReserva))))
                    .addComponent(jLabel6)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel7)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(estadoReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numeroPersonasReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(casaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(335, 335, 335)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinnerFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(98, 98, 98)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jSpinnerFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(238, 329, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(nombreReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(apelleidosReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(DNIReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(telefonoReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(emailReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(guardarNuevaReserva)
                            .addComponent(limpiarReserva)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(comentarioReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(numeroPersonasReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(casaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(estadoReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(113, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelOpcionesLayout = new javax.swing.GroupLayout(PanelOpciones);
        PanelOpciones.setLayout(PanelOpcionesLayout);
        PanelOpcionesLayout.setHorizontalGroup(
            PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LabelOpciones, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelOpcionesLayout.setVerticalGroup(
            PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelOpciones)
                .addGap(32, 32, 32)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1034, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comentarioReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comentarioReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comentarioReservaActionPerformed

    private void casaReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casaReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_casaReservaActionPerformed

    private void nombreReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreReservaActionPerformed

    private void apelleidosReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apelleidosReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apelleidosReservaActionPerformed

    private void telefonoReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonoReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefonoReservaActionPerformed

    private void emailReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailReservaActionPerformed

    private void estadoReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadoReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estadoReservaActionPerformed

    private void guardarNuevaReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarNuevaReservaActionPerformed
      String nombre = nombreReserva.getText().trim();
        String apellidos = apelleidosReserva.getText().trim();
        String dni = DNIReserva.getText().trim();
        String telefono = telefonoReserva.getText().trim();
        String email = emailReserva.getText().trim();
        String comentarios = comentarioReserva.getText().trim();
        String casaSeleccionada = (String) casaReserva.getSelectedItem();
        String estado = (String) estadoReserva.getSelectedItem();
        int numPersonas = (int) numeroPersonasReserva.getValue();

        if (nombre.isEmpty() || apellidos.isEmpty() || dni.isEmpty() || casaSeleccionada == null) {
            JOptionPane.showMessageDialog(this, "Rellena todos los campos obligatorios.");
            return;
        }

        // Obtener fechas de los JSpinner
        java.util.Date utilFechaInicio = (java.util.Date) jSpinnerFechaInicio.getValue();
        java.util.Date utilFechaFin = (java.util.Date) jSpinnerFechaFin.getValue();

        if (utilFechaFin.before(utilFechaInicio)) {
            JOptionPane.showMessageDialog(this, "La fecha de salida no puede ser anterior a la fecha de entrada.");
            return;
        }

        // Formatear fechas como texto dd/MM/yyyy
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaInicioStr = sdf.format(utilFechaInicio);
        String fechaFinStr = sdf.format(utilFechaFin);

        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);

            // Insertar cliente
            String sqlCliente = "INSERT INTO cliente(nombre, apellidos, DNI, telefono, email, comentarios) VALUES (?, ?, ?, ?, ?, ?)";
            int idCliente;
            try (PreparedStatement psCliente = conn.prepareStatement(sqlCliente, Statement.RETURN_GENERATED_KEYS)) {
                psCliente.setString(1, nombre);
                psCliente.setString(2, apellidos);
                psCliente.setString(3, dni);
                psCliente.setString(4, telefono);
                psCliente.setString(5, email);
                psCliente.setString(6, comentarios);
                psCliente.executeUpdate();

                ResultSet rs = psCliente.getGeneratedKeys();
                if (rs.next()) {
                    idCliente = rs.getInt(1);
                } else {
                    throw new SQLException("No se pudo obtener el ID del cliente.");
                }
            }

            // Obtener id_casa
            String sqlCasa = "SELECT id_casa FROM casa WHERE nombre = ?";
            int idCasa;
            try (PreparedStatement psCasa = conn.prepareStatement(sqlCasa)) {
                psCasa.setString(1, casaSeleccionada);
                ResultSet rsCasa = psCasa.executeQuery();
                if (rsCasa.next()) {
                    idCasa = rsCasa.getInt("id_casa");
                } else {
                    throw new SQLException("La casa seleccionada no existe.");
                }
            }

            // Insertar reserva
            String sqlReserva = "INSERT INTO reserva(id_cliente, id_casa, fecha_inicio, fecha_fin, estado, num_personas) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement psReserva = conn.prepareStatement(sqlReserva)) {
                psReserva.setInt(1, idCliente);
                psReserva.setInt(2, idCasa);
                psReserva.setString(3, fechaInicioStr);
                psReserva.setString(4, fechaFinStr);
                psReserva.setString(5, estado);
                psReserva.setInt(6, numPersonas);
                psReserva.executeUpdate();
            }

            conn.commit();
            JOptionPane.showMessageDialog(this, "Reserva creada correctamente.");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al crear reserva: " + e.getMessage());
        }
    }//GEN-LAST:event_guardarNuevaReservaActionPerformed

    private void limpiarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarReservaActionPerformed
        nombreReserva.setText("");
        apelleidosReserva.setText("");
        DNIReserva.setText("");
        telefonoReserva.setText("");
        emailReserva.setText("");
        comentarioReserva.setText("");
        numeroPersonasReserva.setValue(1);

        // Poner los calendarios a la fecha actual
        jSpinnerFechaInicio.setValue(new java.util.Date());
        jSpinnerFechaFin.setValue(new java.util.Date());

        // Seleccionar el primer elemento del combo de casas
        if (casaReserva.getItemCount() > 0) {
            casaReserva.setSelectedIndex(0);
        }

        // Seleccionar el primer estado (pendiente)
        if (estadoReserva.getItemCount() > 0) {
            estadoReserva.setSelectedIndex(0);
        }
    
    }//GEN-LAST:event_limpiarReservaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DNIReserva;
    private javax.swing.JLabel LabelOpciones;
    private javax.swing.JPanel PanelOpciones;
    private javax.swing.JTextField apelleidosReserva;
    private javax.swing.JComboBox<String> casaReserva;
    private javax.swing.JTextField comentarioReserva;
    private javax.swing.JTextField emailReserva;
    private javax.swing.JComboBox<String> estadoReserva;
    private javax.swing.JButton guardarNuevaReserva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSpinner jSpinnerFechaFin;
    private javax.swing.JSpinner jSpinnerFechaInicio;
    private javax.swing.JButton limpiarReserva;
    private javax.swing.JTextField nombreReserva;
    private javax.swing.JSpinner numeroPersonasReserva;
    private javax.swing.JTextField telefonoReserva;
    // End of variables declaration//GEN-END:variables
}