package reservaruralapp;

import util.DBConnection;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.SpinnerDateModel;



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
    private int obtenerIdCasa(String nombreCasa) {
    String sql = "SELECT id_casa FROM casa WHERE nombre = ?";
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    int idCasa = -1;

    try {
        conn = DBConnection.getConnection();
        ps = conn.prepareStatement(sql);
        ps.setString(1, nombreCasa);
        rs = ps.executeQuery();
        if (rs.next()) {
            idCasa = rs.getInt("id_casa");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error obteniendo id_casa: " + e.getMessage());
    } finally {
        try { if (rs != null) rs.close(); } catch (SQLException ex) {}
        try { if (ps != null) ps.close(); } catch (SQLException ex) {}
        try { if (conn != null) conn.close(); } catch (SQLException ex) {}
    }
    return idCasa;
}


//Comprueba si una casa está disponible entre dos fechas.

private boolean estaDisponible(int idCasa, String fechaInicio, String fechaFin) {
    String sql = "SELECT COUNT(*) FROM reserva " +
                 "WHERE id_casa = ? AND estado IN ('CONFIRMADA','PENDIENTE') " +
                 "AND NOT (fecha_fin < ? OR fecha_inicio > ?)";

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        conn = DBConnection.getConnection();
        ps = conn.prepareStatement(sql);
        ps.setInt(1, idCasa);
        ps.setString(2, fechaInicio);
        ps.setString(3, fechaFin);

        rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) == 0; // disponible si no hay reservas superpuestas
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error comprobando disponibilidad: " + e.getMessage());
    } finally {
        try { if (rs != null) rs.close(); } catch (SQLException ex) {}
        try { if (ps != null) ps.close(); } catch (SQLException ex) {}
        try { if (conn != null) conn.close(); } catch (SQLException ex) {}
    }
    return false;
}


//Carga los nombres de todas las casas en el JComboBox.

private void cargarCasasEnComboBox() {
    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
    String sql = "SELECT nombre FROM casa";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            model.addElement(rs.getString("nombre"));
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al cargar casas: " + e.getMessage());
        e.printStackTrace();
    }

    // Finalmente, asignamos el modelo al combo
    casaReserva.setModel(model);
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
        VerCalendario = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        PanelOpciones.setBackground(new java.awt.Color(255, 255, 255));

        LabelOpciones.setText("NUEVA RESERVA");

        jSeparator3.setBackground(new java.awt.Color(0, 102, 51));
        jSeparator3.setForeground(new java.awt.Color(0, 102, 51));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

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

        guardarNuevaReserva.setBackground(new java.awt.Color(242, 252, 242));
        guardarNuevaReserva.setForeground(new java.awt.Color(51, 102, 0));
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

        limpiarReserva.setBackground(new java.awt.Color(242, 252, 242));
        limpiarReserva.setForeground(new java.awt.Color(51, 102, 0));
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

        estadoReserva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pendiente" }));
        estadoReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadoReservaActionPerformed(evt);
            }
        });

        VerCalendario.setBackground(new java.awt.Color(239, 255, 239));
        VerCalendario.setText("Ver Calendario");
        VerCalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerCalendarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(guardarNuevaReserva)
                .addGap(83, 83, 83)
                .addComponent(limpiarReserva)
                .addGap(228, 228, 228)
                .addComponent(VerCalendario)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(telefonoReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(29, 29, 29)
                            .addComponent(nombreReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jSpinnerFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(31, 31, 31)
                        .addComponent(casaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(apelleidosReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jSpinnerFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(emailReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(estadoReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(42, 42, 42))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(196, 196, 196)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(numeroPersonasReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(158, 158, 158))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DNIReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comentarioReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(130, 130, 130))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nombreReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(apelleidosReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(DNIReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(telefonoReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(emailReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(comentarioReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jSpinnerFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jSpinnerFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(numeroPersonasReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel12)
                    .addComponent(casaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(estadoReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(296, 349, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardarNuevaReserva)
                    .addComponent(limpiarReserva)
                    .addComponent(VerCalendario))
                .addGap(253, 253, 253))
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
                .addContainerGap(107, Short.MAX_VALUE))
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
                .addContainerGap(511, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 6, 1530, 870));
    }// </editor-fold>//GEN-END:initComponents

    private void estadoReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadoReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estadoReservaActionPerformed

    private void comentarioReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comentarioReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comentarioReservaActionPerformed

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

    private void nombreReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreReservaActionPerformed

    private void guardarNuevaReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarNuevaReservaActionPerformed
        String nombre = InputUtils.normalizarMayusculas(nombreReserva.getText().trim());
        String apellidos = InputUtils.normalizarMayusculas(apelleidosReserva.getText().trim());
        String dni = InputUtils.normalizarMayusculas(DNIReserva.getText().trim());
        if (dni != null && !dni.isEmpty() && !InputUtils.validaDNI(dni)) {
            JOptionPane.showMessageDialog(this, "El DNI no es válido: " + dni);
            return; // no guarda si el DNI es incorrecto
        }
        String telefono = InputUtils.normalizarMayusculas(telefonoReserva.getText().trim());
        if (telefono != null && !telefono.isEmpty() && !InputUtils.validaTelefonoE164(telefono)) {
            JOptionPane.showMessageDialog(this, "El teléfono no es válido: " + telefono);
            return;
        }
        String email = InputUtils.normalizarMayusculas(emailReserva.getText().trim());
        if (!InputUtils.validaEmail(email)) {
            JOptionPane.showMessageDialog(this, "El email no es válido: " + email);
            return; // no guarda si el email es incorrecto
        }
        String comentarios = InputUtils.normalizarMayusculas(comentarioReserva.getText().trim());
        String casaSeleccionada = InputUtils.normalizarMayusculas((String) casaReserva.getSelectedItem());
        String estado = InputUtils.normalizarMayusculas((String) estadoReserva.getSelectedItem());
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

            int idCliente = 0;
            // Verificar si el cliente ya existe por DNI
            String sqlBuscarCliente = "SELECT id_cliente FROM cliente WHERE DNI = ?";
            try (PreparedStatement psBuscar = conn.prepareStatement(sqlBuscarCliente)) {
                psBuscar.setString(1, dni);
                ResultSet rs = psBuscar.executeQuery();
                if (rs.next()) {
                    idCliente = rs.getInt("id_cliente");
                    JOptionPane.showMessageDialog(this, "El cliente ya existe. Se usará su registro para la nueva reserva.");
                }
            }

            // Si no existe, insertamos el cliente
            if (idCliente == 0) {
                String sqlCliente = "INSERT INTO cliente(nombre, apellidos, DNI, telefono, email, comentarios) VALUES (?, ?, ?, ?, ?, ?)";
                try (PreparedStatement psCliente = conn.prepareStatement(sqlCliente, Statement.RETURN_GENERATED_KEYS)) {
                    psCliente.setString(1, InputUtils.normalizarMayusculas(nombre));
                    psCliente.setString(2, InputUtils.normalizarMayusculas(apellidos));
                    psCliente.setString(3, InputUtils.normalizarMayusculas(dni));
                    psCliente.setString(4, InputUtils.normalizarMayusculas(telefono));
                    psCliente.setString(5, InputUtils.normalizarMayusculas(email));
                    psCliente.setString(6, InputUtils.normalizarMayusculas(comentarios));
                    psCliente.executeUpdate();

                    ResultSet rs = psCliente.getGeneratedKeys();
                    if (rs.next()) {
                        idCliente = rs.getInt(1);
                    } else {
                        throw new SQLException("No se pudo obtener el ID del cliente.");
                    }
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
                psReserva.setString(5, InputUtils.normalizarMayusculas(estado));
                psReserva.setInt(6, numPersonas);
                psReserva.executeUpdate();
            }

            conn.commit();
            JOptionPane.showMessageDialog(this, "Reserva creada correctamente.");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al crear reserva: " + e.getMessage());
        }
    }//GEN-LAST:event_guardarNuevaReservaActionPerformed

    private void casaReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casaReservaActionPerformed
     
    }//GEN-LAST:event_casaReservaActionPerformed

    private void emailReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailReservaActionPerformed

    private void telefonoReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonoReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefonoReservaActionPerformed

    private void apelleidosReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apelleidosReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apelleidosReservaActionPerformed

    private void VerCalendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerCalendarioActionPerformed
          new VentanaCalendario().setVisible(true);
    }//GEN-LAST:event_VerCalendarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DNIReserva;
    private javax.swing.JLabel LabelOpciones;
    private javax.swing.JPanel PanelOpciones;
    private javax.swing.JButton VerCalendario;
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
