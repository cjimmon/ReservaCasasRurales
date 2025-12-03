package reservaruralapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.DBConnection;


public class PanelBuscarReserva extends javax.swing.JPanel {

   
    public PanelBuscarReserva() {
    initComponents();
    
    tablaReservas.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {}, // Sin filas al inicio
        new String [] { "Nº Factura", "ID", "Nombre", "Apellidos", "DNI", "Teléfono", "Email", "Casa", "Personas", "Inicio", "Fin", "Estado" }
    ));
    
      ControlAcceso.aplicarPermisos(botoneliminarReservas, botonVerReservas);
   }
    
    private int obtenerIdClienteDesdeReserva(int idReserva, Connection conn) throws SQLException {
    String sql = "SELECT id_cliente FROM reserva WHERE id_reserva = ?";
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, idReserva);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("id_cliente");
            } else {
                throw new SQLException("No se encontró el cliente para la reserva " + idReserva);
            }
        }
    }
}

    private int obtenerIdCasaDesdeReserva(int idReserva, Connection conn) throws SQLException {
    String sql = "SELECT id_casa FROM reserva WHERE id_reserva = ?";
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, idReserva);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("id_casa");
            } else {
                throw new SQLException("No se encontró la casa para la reserva " + idReserva);
            }
        }
    }
}
    
   
   private void cargarReservas() {
        DefaultTableModel model = (DefaultTableModel) tablaReservas.getModel();
        model.setRowCount(0);

        String sql = """
            SELECT 
                f.id_factura,
                r.id_reserva,
                c.nombre AS nombre_cliente,
                c.apellidos AS apellidos_cliente,
                c.DNI,
                c.telefono,
                c.email,
                ca.nombre AS nombre_casa,
                r.num_personas,
                r.fecha_inicio,
                r.fecha_fin,
                r.estado
            FROM reserva r
            JOIN cliente c ON r.id_cliente = c.id_cliente
            JOIN casa ca ON r.id_casa = ca.id_casa
            LEFT JOIN factura f ON r.id_reserva = f.id_reserva
        """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getObject("id_factura"), // Puede ser null si no hay factura
                    rs.getInt("id_reserva"),
                    rs.getString("nombre_cliente"),
                    rs.getString("apellidos_cliente"),
                    rs.getString("DNI"),
                    rs.getString("telefono"),
                    rs.getString("email"),
                    rs.getString("nombre_casa"),
                    rs.getInt("num_personas"),
                    rs.getString("fecha_inicio"),
                    rs.getString("fecha_fin"),
                    rs.getString("estado")
                });
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar reservas: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelBuscarReserva = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        campoBusqueda = new javax.swing.JTextField();
        botonEjecutarBusqueda = new javax.swing.JButton();
        scrollTablaReservas = new javax.swing.JScrollPane();
        tablaReservas = new javax.swing.JTable();
        botonGuardarCambios = new javax.swing.JButton();
        botoneliminarReservas = new javax.swing.JButton();
        SeparadorBuscarReseva = new javax.swing.JSeparator();
        botonVerReservas = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        PanelBuscarReserva.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("BUSCAR RESERVA");

        jLabel7.setText("Buscar por: ");

        campoBusqueda.setToolTipText("Busca en cualquier campo");
        campoBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoBusquedaActionPerformed(evt);
            }
        });

        botonEjecutarBusqueda.setBackground(new java.awt.Color(242, 253, 242));
        botonEjecutarBusqueda.setForeground(new java.awt.Color(51, 102, 0));
        botonEjecutarBusqueda.setText("Buscar");
        botonEjecutarBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEjecutarBusquedaActionPerformed(evt);
            }
        });

        scrollTablaReservas.setBackground(new java.awt.Color(242, 255, 242));

        tablaReservas.setBackground(new java.awt.Color(204, 255, 204));
        tablaReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nº Factura ", "Nº Reserva", "Nombre", "Apellidos", "DNI", "Telefono", "Email", "Casa", "Numero personas", "Fecha Entrada", "Fecha Salida", "Estado"
            }
        ));
        scrollTablaReservas.setViewportView(tablaReservas);

        botonGuardarCambios.setBackground(new java.awt.Color(242, 253, 242));
        botonGuardarCambios.setForeground(new java.awt.Color(51, 102, 0));
        botonGuardarCambios.setText("Guardar Cambios");
        botonGuardarCambios.setToolTipText("Guardar modificaciones en reservas");
        botonGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarCambiosActionPerformed(evt);
            }
        });

        botoneliminarReservas.setBackground(new java.awt.Color(242, 253, 242));
        botoneliminarReservas.setForeground(new java.awt.Color(51, 102, 0));
        botoneliminarReservas.setText("Eliminar Reserva");
        botoneliminarReservas.setToolTipText("Eliminar linea completa");
        botoneliminarReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoneliminarReservasActionPerformed(evt);
            }
        });

        SeparadorBuscarReseva.setBackground(new java.awt.Color(0, 102, 51));
        SeparadorBuscarReseva.setForeground(new java.awt.Color(0, 102, 51));

        botonVerReservas.setBackground(new java.awt.Color(242, 253, 242));
        botonVerReservas.setForeground(new java.awt.Color(51, 102, 0));
        botonVerReservas.setText("Ver Reservas");
        botonVerReservas.setToolTipText("Ver Listado de Reservas");
        botonVerReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerReservasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelBuscarReservaLayout = new javax.swing.GroupLayout(PanelBuscarReserva);
        PanelBuscarReserva.setLayout(PanelBuscarReservaLayout);
        PanelBuscarReservaLayout.setHorizontalGroup(
            PanelBuscarReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBuscarReservaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelBuscarReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelBuscarReservaLayout.createSequentialGroup()
                        .addGroup(PanelBuscarReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonEjecutarBusqueda)
                        .addGap(140, 140, 140)
                        .addComponent(botonGuardarCambios)
                        .addGap(98, 98, 98)
                        .addComponent(botoneliminarReservas))
                    .addGroup(PanelBuscarReservaLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(botonVerReservas)))
                .addGap(0, 778, Short.MAX_VALUE))
            .addGroup(PanelBuscarReservaLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(PanelBuscarReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollTablaReservas)
                    .addComponent(SeparadorBuscarReseva))
                .addContainerGap())
        );
        PanelBuscarReservaLayout.setVerticalGroup(
            PanelBuscarReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBuscarReservaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(23, 23, 23)
                .addComponent(botonVerReservas)
                .addGap(18, 18, 18)
                .addGroup(PanelBuscarReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelBuscarReservaLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(PanelBuscarReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addGroup(PanelBuscarReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(campoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(botonEjecutarBusqueda))))
                    .addComponent(botoneliminarReservas)
                    .addComponent(botonGuardarCambios))
                .addGap(18, 18, 18)
                .addComponent(SeparadorBuscarReseva, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scrollTablaReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        add(PanelBuscarReserva, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void campoBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoBusquedaActionPerformed

    private void botonEjecutarBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEjecutarBusquedaActionPerformed
                                                     
       String textoBusqueda = InputUtils.normalizarMayusculas(campoBusqueda.getText().trim());

        if (textoBusqueda.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduce un campo de búsqueda");
            return;
        }

        DefaultTableModel modelo = (DefaultTableModel) tablaReservas.getModel();
        modelo.setRowCount(0);

        String sql = "SELECT r.id_reserva, c.nombre, c.apellidos, c.DNI, c.telefono, c.email, " +
                     "ca.nombre AS casa, r.num_personas, r.fecha_inicio, r.fecha_fin, r.estado " +
                     "FROM reserva r " +
                     "JOIN cliente c ON r.id_cliente = c.id_cliente " +
                     "JOIN casa ca ON r.id_casa = ca.id_casa " +
                     "WHERE r.id_reserva LIKE ? OR c.nombre LIKE ? OR c.apellidos LIKE ? OR " +
                     "c.DNI LIKE ? OR c.telefono LIKE ? OR c.email LIKE ? OR ca.nombre LIKE ? OR " +
                     "r.num_personas LIKE ? OR r.fecha_inicio LIKE ? OR r.fecha_fin LIKE ? OR r.estado LIKE ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            String filtro = "%" + InputUtils.normalizarMayusculas(textoBusqueda) + "%";
            for (int i = 1; i <= 11; i++) ps.setString(i, filtro);

            ResultSet rs = ps.executeQuery();
            boolean hayResultados = false;

            while (rs.next()) {
                String fechaInicio = rs.getString("fecha_inicio");
                String fechaFin = rs.getString("fecha_fin");

                Object[] fila = new Object[] {
                    rs.getInt("id_reserva"),
                    rs.getString("nombre"),
                    rs.getString("apellidos"),
                    rs.getString("DNI"),
                    rs.getString("telefono"),
                    rs.getString("email"),
                    rs.getString("casa"),
                    rs.getInt("num_personas"),
                    fechaInicio != null ? fechaInicio : "",
                    fechaFin != null ? fechaFin : "",
                    rs.getString("estado")
                };
                modelo.addRow(fila);
                hayResultados = true;
            }

            if (!hayResultados) {
                JOptionPane.showMessageDialog(this, "No se encontraron reservas con ese criterio.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al buscar reservas: " + e.getMessage());
        }
           
    }//GEN-LAST:event_botonEjecutarBusquedaActionPerformed

    private void botonGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarCambiosActionPerformed
      DefaultTableModel modelo = (DefaultTableModel) tablaReservas.getModel();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try (Connection conn = DBConnection.getConnection()) {
            for (int i = 0; i < modelo.getRowCount(); i++) {
                int idReserva = (int) modelo.getValueAt(i, 1);
                int idCliente = obtenerIdClienteDesdeReserva(idReserva, conn);
                int idCasa = obtenerIdCasaDesdeReserva(idReserva, conn);

                // Datos del cliente
                String nombre = InputUtils.normalizarMayusculas(modelo.getValueAt(i, 2).toString());
                String apellidos = InputUtils.normalizarMayusculas(modelo.getValueAt(i, 3).toString());
                String dni = InputUtils.normalizarMayusculas(modelo.getValueAt(i, 4).toString());

            if (dni != null && !dni.isEmpty() && !InputUtils.validaDNI(dni)) {
                JOptionPane.showMessageDialog(this, "El DNI no es válido: " + dni);
                return; // no guarda si el DNI es incorrecto
            }
                String telefono = InputUtils.normalizarMayusculas(modelo.getValueAt(i, 5) != null 
                    ? modelo.getValueAt(i, 5).toString() 
                    : null);

            if (telefono != null && !telefono.isEmpty() && !InputUtils.validaTelefonoE164(telefono)) {
                JOptionPane.showMessageDialog(this, "El teléfono de la fila " + (i+1) + " no es válido: " + telefono);
                return;
            }
                String email = InputUtils.normalizarMayusculas(modelo.getValueAt(i, 6).toString());
            if (!InputUtils.validaEmail(email)) {
                JOptionPane.showMessageDialog(this, "El email no es válido: " + email);
                return; // no guarda si el email es incorrecto
            }

                // Datos de la casa
                String nombreCasa = InputUtils.normalizarMayusculas(modelo.getValueAt(i, 7).toString());

                // Datos de la reserva
                int numPersonas = Integer.parseInt(modelo.getValueAt(i, 8).toString());
                String fechaInicio = modelo.getValueAt(i, 9).toString();
                String fechaFin = modelo.getValueAt(i, 10).toString();
                String estado = InputUtils.normalizarMayusculas(modelo.getValueAt(i, 11).toString());
                if (!InputUtils.validaFecha(fechaInicio)) {
                    JOptionPane.showMessageDialog(this, "Formato de fecha incorrecto en la fila " + (i+1));
                    return;
                }
                if (!InputUtils.validaFecha(fechaFin)) {
                    JOptionPane.showMessageDialog(this, "Formato de fecha incorrecto en la fila " + (i+1));
                    return;
}

                // Guardar como texto directamente
                String sqlCliente = "UPDATE cliente SET nombre=?, apellidos=?, DNI=?, telefono=?, email=? WHERE id_cliente=?";
                try (PreparedStatement ps = conn.prepareStatement(sqlCliente)) {
                    ps.setString(1, nombre);
                    ps.setString(2, apellidos);
                    ps.setString(3, dni);
                    ps.setString(4, telefono);
                    ps.setString(5, email);
                    ps.setInt(6, idCliente);
                    ps.executeUpdate();
                }

                String sqlCasa = "UPDATE casa SET nombre=? WHERE id_casa=?";
                try (PreparedStatement ps = conn.prepareStatement(sqlCasa)) {
                    ps.setString(1, nombreCasa);
                    ps.setInt(2, idCasa);
                    ps.executeUpdate();
                }

                if (idReserva == 0) {
                    String sql = "INSERT INTO reserva (id_cliente, id_casa, num_personas, fecha_inicio, fecha_fin, estado) VALUES (?, ?, ?, ?, ?, ?)";
                    try (PreparedStatement ps = conn.prepareStatement(sql)) {
                        ps.setInt(1, idCliente);
                        ps.setInt(2, idCasa);
                        ps.setInt(3, numPersonas);
                        ps.setString(4, fechaInicio);
                        ps.setString(5, fechaFin);
                        ps.setString(6, estado);
                        ps.executeUpdate();
                    }
                } else {
                String sql = "UPDATE reserva SET id_cliente=?, id_casa=?, num_personas=?, fecha_inicio=?, fecha_fin=?, estado=? WHERE id_reserva=?";
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setInt(1, idCliente);
                    ps.setInt(2, idCasa);
                    ps.setInt(3, numPersonas);
                    ps.setString(4, fechaInicio);
                    ps.setString(5, fechaFin);
                    ps.setString(6, estado);
                    ps.setInt(7, idReserva);
                    ps.executeUpdate();
                }

                // --- GENERAR FACTURA SI SE CONFIRMA LA RESERVA ---
                if ("CONFIRMADA".equalsIgnoreCase(estado)) {
                    // Comprobar si ya existe factura para esta reserva
                    String sqlCheck = "SELECT id_factura, importe_total FROM factura WHERE id_reserva = ?";
                    Integer idFacturaExistente = null;
                    double importeActualFactura = 0;

                    try (PreparedStatement psCheck = conn.prepareStatement(sqlCheck)) {
                        psCheck.setInt(1, idReserva);
                        ResultSet rsCheck = psCheck.executeQuery();
                        if (rsCheck.next()) {
                            idFacturaExistente = rsCheck.getInt("id_factura"); // Guardamos el id de la factura
                            importeActualFactura = rsCheck.getDouble("importe_total"); // Guardamos el importe actual
                        }
                    }

                    // Calcular importe_total basado en fechas y precio_noche
                    String sqlImporte = "SELECT (julianday(substr(r.fecha_fin, 7, 4) || '-' || substr(r.fecha_fin, 4, 2) || '-' || substr(r.fecha_fin, 1, 2)) " +
                                        "- julianday(substr(r.fecha_inicio, 7, 4) || '-' || substr(r.fecha_inicio, 4, 2) || '-' || substr(r.fecha_inicio, 1, 2))) " +
                                        "* c.precio_noche AS total " +
                                        "FROM reserva r JOIN casa c ON r.id_casa = c.id_casa " +
                                        "WHERE r.id_reserva = ?";

                    double importeTotal = 0;
                    try (PreparedStatement psImp = conn.prepareStatement(sqlImporte)) {
                        psImp.setInt(1, idReserva);
                        ResultSet rs = psImp.executeQuery();
                        if (rs.next()) {
                            importeTotal = rs.getDouble("total");
                        }
                    }

                    java.time.LocalDate hoy = java.time.LocalDate.now();
                    java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");

                    if (idFacturaExistente == null) {
                        // No existe factura → INSERT
                        String sqlFactura = "INSERT INTO factura(id_reserva, fecha_emision, importe_total) VALUES(?, ?, ?)";
                        try (PreparedStatement psFac = conn.prepareStatement(sqlFactura)) {
                            psFac.setInt(1, idReserva);
                            psFac.setString(2, hoy.format(formatter));
                            psFac.setDouble(3, importeTotal);
                            psFac.executeUpdate();

                            // Mensaje de creación
                            JOptionPane.showMessageDialog(this,
                                "Reserva confirmada: factura creada correctamente.\nFecha emisión: " + hoy.format(formatter));
                        }
                    } else if (importeActualFactura != importeTotal) {
                        // Ya existe factura → UPDATE solo si cambió el importe
                        String sqlFacturaUpdate = "UPDATE factura SET fecha_emision = ?, importe_total = ? WHERE id_factura = ?";
                        try (PreparedStatement psFac = conn.prepareStatement(sqlFacturaUpdate)) {
                            psFac.setString(1, hoy.format(formatter));
                            psFac.setDouble(2, importeTotal);
                            psFac.setInt(3, idFacturaExistente);
                            psFac.executeUpdate();

                            // Mensaje de actualización solo si cambió importe
                            JOptionPane.showMessageDialog(this,
                                "La factura existente se ha actualizado debido a cambios en las fechas o importe.\nNueva fecha emisión: " + hoy.format(formatter));
                        }
                    }
                }
            }
                        }

                        JOptionPane.showMessageDialog(this, "Cambios guardados correctamente.");
                        cargarReservas();

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Error al guardar: " + e.getMessage());
                    }
    }//GEN-LAST:event_botonGuardarCambiosActionPerformed

    private void botoneliminarReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoneliminarReservasActionPerformed
        int fila = tablaReservas.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una reserva para eliminar.");
            return;
        }

        int idReserva = (int) tablaReservas.getValueAt(fila, 1);
        int confirmar = JOptionPane.showConfirmDialog(this, "¿Seguro que quieres eliminar esta reserva?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirmar != JOptionPane.YES_OPTION) return;

        String sql = "DELETE FROM reserva WHERE id_reserva = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idReserva);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Reserva eliminada correctamente.");
            cargarReservas();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al eliminar reserva: " + e.getMessage());
        }
    }//GEN-LAST:event_botoneliminarReservasActionPerformed

    private void botonVerReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerReservasActionPerformed
        cargarReservas();
    }//GEN-LAST:event_botonVerReservasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelBuscarReserva;
    private javax.swing.JSeparator SeparadorBuscarReseva;
    private javax.swing.JButton botonEjecutarBusqueda;
    private javax.swing.JButton botonGuardarCambios;
    private javax.swing.JButton botonVerReservas;
    private javax.swing.JButton botoneliminarReservas;
    private javax.swing.JTextField campoBusqueda;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane scrollTablaReservas;
    private javax.swing.JTable tablaReservas;
    // End of variables declaration//GEN-END:variables
}
