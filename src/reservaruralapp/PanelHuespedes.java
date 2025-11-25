
package reservaruralapp;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import util.DBConnection;

public class PanelHuespedes extends javax.swing.JPanel {

    
    public PanelHuespedes() {
         initComponents();
         
          ControlAcceso.aplicarPermisos(BotonNuevoHuesped, BotonEliminarHuesped);
          
        tablaHuespedes.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] { "ID Huesped", "ID Reserva", "Nombre Completo", "Tipo Documento", "Número Documento",
                           "Sexo", "Fecha Nacimiento", "Nacionalidad", "Domicilio", "Fecha Entrada", "Fecha Salida" }
        ));
    }

     private void cargarHuespedes() {
        DefaultTableModel model = (DefaultTableModel) tablaHuespedes.getModel();
        model.setRowCount(0);

        String sql = "SELECT * FROM Huespedes";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                model.addRow(new Object[] {
                    rs.getInt("id_huesped"),
                    rs.getInt("id_reserva"),
                    rs.getString("nombre_completo"),
                    rs.getString("tipo_documento"),
                    rs.getString("numero_documento"),
                    rs.getString("sexo"),
                    rs.getString("fecha_nacimiento"),
                    rs.getString("nacionalidad"),
                    rs.getString("domicilio"),
                    rs.getString("fecha_entrada"),
                    rs.getString("fecha_salida")
                });
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar huespedes: " + e.getMessage());
        }
     }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        scrolltablaHuespedes = new javax.swing.JScrollPane();
        tablaHuespedes = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        BotonNuevoHuesped = new javax.swing.JButton();
        GuardarHuesped = new javax.swing.JButton();
        BotonVerHuespedes = new javax.swing.JButton();
        BotonLupaHuesped = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        LabelClientes = new javax.swing.JLabel();
        CampoBuscarHuesped = new javax.swing.JTextField();
        BotonEliminarHuesped = new javax.swing.JButton();

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tablaHuespedes.setBackground(new java.awt.Color(204, 255, 204));
        tablaHuespedes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id_huesped", "id_reserva", "nombre_completo", "tipo_documento", "numero_documento", "sexo", "fecha_nacimiento", "nacionalidad", "domicilio", "fecha_entrada", "fecha_salida"
            }
        ));
        scrolltablaHuespedes.setViewportView(tablaHuespedes);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrolltablaHuespedes, javax.swing.GroupLayout.PREFERRED_SIZE, 1653, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrolltablaHuespedes, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        BotonNuevoHuesped.setBackground(new java.awt.Color(241, 250, 241));
        BotonNuevoHuesped.setForeground(new java.awt.Color(51, 102, 0));
        BotonNuevoHuesped.setText("Agregar Huesped");
        BotonNuevoHuesped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonNuevoHuespedActionPerformed(evt);
            }
        });

        GuardarHuesped.setBackground(new java.awt.Color(241, 250, 241));
        GuardarHuesped.setForeground(new java.awt.Color(51, 102, 0));
        GuardarHuesped.setText("Guardar");
        GuardarHuesped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarHuespedActionPerformed(evt);
            }
        });

        BotonVerHuespedes.setBackground(new java.awt.Color(241, 250, 241));
        BotonVerHuespedes.setForeground(new java.awt.Color(51, 102, 0));
        BotonVerHuespedes.setText("Ver Huespedes");
        BotonVerHuespedes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonVerHuespedesActionPerformed(evt);
            }
        });

        BotonLupaHuesped.setBackground(new java.awt.Color(241, 250, 241));
        BotonLupaHuesped.setForeground(new java.awt.Color(51, 102, 0));
        BotonLupaHuesped.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/lupa.png"))); // NOI18N
        BotonLupaHuesped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonLupaHuespedActionPerformed(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(0, 102, 51));
        jSeparator2.setForeground(new java.awt.Color(0, 102, 51));

        LabelClientes.setText("HUESPEDES");

        CampoBuscarHuesped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoBuscarHuespedActionPerformed(evt);
            }
        });

        BotonEliminarHuesped.setBackground(new java.awt.Color(241, 250, 241));
        BotonEliminarHuesped.setForeground(new java.awt.Color(51, 102, 0));
        BotonEliminarHuesped.setText("Eliminar Huesped");
        BotonEliminarHuesped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEliminarHuespedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jSeparator2)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LabelClientes))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(BotonVerHuespedes)
                        .addGap(50, 50, 50)
                        .addComponent(BotonNuevoHuesped)
                        .addGap(45, 45, 45)
                        .addComponent(GuardarHuesped)
                        .addGap(49, 49, 49)
                        .addComponent(BotonEliminarHuesped)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CampoBuscarHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BotonLupaHuesped)
                .addGap(103, 103, 103))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(LabelClientes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BotonVerHuespedes)
                            .addComponent(GuardarHuesped)
                            .addComponent(BotonNuevoHuesped)
                            .addComponent(CampoBuscarHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonEliminarHuesped)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BotonLupaHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BotonNuevoHuespedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonNuevoHuespedActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tablaHuespedes.getModel();
        // Agrega una fila vacía con todos los valores null (ID se asignará al guardar)
        modelo.addRow(new Object[]{null, null, null, null, null, null, null});

        // Selecciona automáticamente la fila recién agregada
        int fila = modelo.getRowCount() - 1;
        tablaHuespedes.setRowSelectionInterval(fila, fila);
    }//GEN-LAST:event_BotonNuevoHuespedActionPerformed

    private void GuardarHuespedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarHuespedActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tablaHuespedes.getModel();
    boolean todoCorrecto = true; // bandera para controlar errores

    try (Connection conn = DBConnection.getConnection()) {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            Object idObj = modelo.getValueAt(i, 0);
            Object idReservaObj = modelo.getValueAt(i, 1);

            if (idReservaObj == null || idReservaObj.toString().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe indicar un ID de reserva válido en la fila " + (i + 1));
                todoCorrecto = false;
                continue;
            }

            int idReserva = Integer.parseInt(idReservaObj.toString());

            // Comprobar si la reserva existe y obtener datos
            String sqlReserva = "SELECT num_personas, fecha_inicio, fecha_fin FROM Reserva WHERE id_reserva=?";
            try (PreparedStatement psReserva = conn.prepareStatement(sqlReserva)) {
                psReserva.setInt(1, idReserva);
                ResultSet rsReserva = psReserva.executeQuery();
                if (!rsReserva.next()) {
                    JOptionPane.showMessageDialog(this, "La reserva con ID " + idReserva + " no existe.");
                    todoCorrecto = false;
                    continue;
                }

                int numPersonas = rsReserva.getInt("num_personas");
                String fechaInicio = rsReserva.getString("fecha_inicio");
                String fechaFin = rsReserva.getString("fecha_fin");

                // Contar huespedes ya guardados de esa reserva
                String sqlCount = "SELECT COUNT(*) AS total FROM Huespedes WHERE id_reserva=?";
                try (PreparedStatement psCount = conn.prepareStatement(sqlCount)) {
                    psCount.setInt(1, idReserva);
                    ResultSet rsCount = psCount.executeQuery();
                    rsCount.next();
                    int totalHuespedes = rsCount.getInt("total");
                    if (idObj == null) totalHuespedes++; // sumamos el que se está agregando ahora

                    if (totalHuespedes > numPersonas) {
                        JOptionPane.showMessageDialog(this, "No se puede agregar más huéspedes de los permitidos en la reserva " + idReserva);
                        todoCorrecto = false;
                        continue;
                    }
                }

                // Datos del huésped
                String nombreCompleto = modelo.getValueAt(i, 2).toString().toUpperCase();
                String tipoDocumento = modelo.getValueAt(i, 3).toString().toUpperCase();
                String numeroDocumento = modelo.getValueAt(i, 4).toString().toUpperCase();
                String sexo = modelo.getValueAt(i, 5).toString().toUpperCase();
                String fechaNacimiento = modelo.getValueAt(i, 6).toString();
                String nacionalidad = modelo.getValueAt(i, 7).toString().toUpperCase();
                String domicilio = modelo.getValueAt(i, 8).toString().toUpperCase();

                if (idObj == null || idObj.toString().isEmpty()) {
                    // INSERT
                    String sqlInsert = "INSERT INTO Huespedes(id_reserva, nombre_completo, tipo_documento, numero_documento, sexo, fecha_nacimiento, nacionalidad, domicilio, fecha_entrada, fecha_salida) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    try (PreparedStatement psInsert = conn.prepareStatement(sqlInsert)) {
                        psInsert.setInt(1, idReserva);
                        psInsert.setString(2, nombreCompleto);
                        psInsert.setString(3, tipoDocumento);
                        psInsert.setString(4, numeroDocumento);
                        psInsert.setString(5, sexo);
                        psInsert.setString(6, fechaNacimiento);
                        psInsert.setString(7, nacionalidad);
                        psInsert.setString(8, domicilio);
                        psInsert.setString(9, fechaInicio);
                        psInsert.setString(10, fechaFin);
                        psInsert.executeUpdate();
                    }
                } else {
                    // UPDATE
                    int idHuesped = Integer.parseInt(idObj.toString());
                    String sqlUpdate = "UPDATE Huespedes SET nombre_completo=?, tipo_documento=?, numero_documento=?, sexo=?, fecha_nacimiento=?, nacionalidad=?, domicilio=?, fecha_entrada=?, fecha_salida=? WHERE id_huesped=?";
                    try (PreparedStatement psUpdate = conn.prepareStatement(sqlUpdate)) {
                        psUpdate.setString(1, nombreCompleto);
                        psUpdate.setString(2, tipoDocumento);
                        psUpdate.setString(3, numeroDocumento);
                        psUpdate.setString(4, sexo);
                        psUpdate.setString(5, fechaNacimiento);
                        psUpdate.setString(6, nacionalidad);
                        psUpdate.setString(7, domicilio);
                        psUpdate.setString(8, fechaInicio);
                        psUpdate.setString(9, fechaFin);
                        psUpdate.setInt(10, idHuesped);
                        psUpdate.executeUpdate();
                    }
                }

            }
        }

        if (todoCorrecto) {
            JOptionPane.showMessageDialog(this, "Huéspedes guardados correctamente.");
        }

        cargarHuespedes();

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al guardar huéspedes: " + e.getMessage());
    }
    }//GEN-LAST:event_GuardarHuespedActionPerformed

    private void BotonVerHuespedesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonVerHuespedesActionPerformed
             cargarHuespedes();
    }//GEN-LAST:event_BotonVerHuespedesActionPerformed

    private void BotonLupaHuespedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonLupaHuespedActionPerformed
        String textoBusqueda = CampoBuscarHuesped.getText().trim().toUpperCase();

        if (textoBusqueda.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduce un texto para buscar.");
            return;
        }

        DefaultTableModel modelo = (DefaultTableModel) tablaHuespedes.getModel();
        modelo.setRowCount(0);

        String sql = "SELECT * FROM Huespedes WHERE " +
                     "UPPER(nombre_completo) LIKE ? OR " +
                     "UPPER(tipo_documento) LIKE ? OR " +
                     "UPPER(numero_documento) LIKE ? OR " +
                     "UPPER(sexo) LIKE ? OR " +
                     "UPPER(nacionalidad) LIKE ? OR " +
                     "UPPER(domicilio) LIKE ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            for (int i = 1; i <= 6; i++) ps.setString(i, "%" + textoBusqueda + "%");

            ResultSet rs = ps.executeQuery();
            boolean hayResultados = false;

            while (rs.next()) {
                modelo.addRow(new Object[] {
                    rs.getInt("id_huesped"),
                    rs.getInt("id_reserva"),
                    rs.getString("nombre_completo"),
                    rs.getString("tipo_documento"),
                    rs.getString("numero_documento"),
                    rs.getString("sexo"),
                    rs.getString("fecha_nacimiento"),
                    rs.getString("nacionalidad"),
                    rs.getString("domicilio"),
                    rs.getString("fecha_entrada"),
                    rs.getString("fecha_salida")
                });
                hayResultados = true;
            }

            if (!hayResultados) {
                JOptionPane.showMessageDialog(this, "No se encontraron huespedes con ese criterio.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al buscar huespedes: " + e.getMessage());
        }
    }//GEN-LAST:event_BotonLupaHuespedActionPerformed

    private void CampoBuscarHuespedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoBuscarHuespedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoBuscarHuespedActionPerformed

    private void BotonEliminarHuespedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEliminarHuespedActionPerformed
        int fila = tablaHuespedes.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un huesped para eliminar.");
            return;
        }

        int idHuesped = (int) tablaHuespedes.getValueAt(fila, 0);
        int confirmar = JOptionPane.showConfirmDialog(this, "¿Seguro que quieres eliminar este huesped?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirmar != JOptionPane.YES_OPTION) return;

        String sql = "DELETE FROM Huespedes WHERE id_huesped=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idHuesped);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Huesped eliminado correctamente.");
            cargarHuespedes();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al eliminar huesped: " + e.getMessage());
        }
    
    }//GEN-LAST:event_BotonEliminarHuespedActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonEliminarHuesped;
    private javax.swing.JButton BotonLupaHuesped;
    private javax.swing.JButton BotonNuevoHuesped;
    private javax.swing.JButton BotonVerHuespedes;
    private javax.swing.JTextField CampoBuscarHuesped;
    private javax.swing.JButton GuardarHuesped;
    private javax.swing.JLabel LabelClientes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JScrollPane scrolltablaHuespedes;
    private javax.swing.JTable tablaHuespedes;
    // End of variables declaration//GEN-END:variables
}
