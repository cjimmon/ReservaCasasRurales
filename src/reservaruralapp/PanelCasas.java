/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package reservaruralapp;

import util.DBConnection;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

/**
 *
 * @author jimen
 */
public class PanelCasas extends javax.swing.JPanel {

    public PanelCasas() {
        initComponents();
       
        }
    public void cargarCasas() {
        DefaultTableModel modelo = (DefaultTableModel) TableCasas.getModel();
        modelo.setRowCount(0); // Limpiar tabla

        String sql = "SELECT * FROM casas";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Object[] fila = new Object[]{
                    rs.getInt("id_casa"),
                    rs.getString("nombre"),
                    rs.getString("ubicacion"),
                    rs.getInt("capacidad"),
                    rs.getDouble("precio_noche"),
                    rs.getString("descripcion")
                };
                modelo.addRow(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar casas: " + e.getMessage());
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelCasas = new javax.swing.JPanel();
        LabelCasas = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        BotonNuevaCasa = new javax.swing.JButton();
        BotonEliminarCasa = new javax.swing.JButton();
        VerCasas = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        GuardarCasas = new javax.swing.JButton();
        ScrollPanelCasas = new javax.swing.JScrollPane();
        TableCasas = new javax.swing.JTable();

        LabelCasas.setText("CASAS");

        BotonNuevaCasa.setText("Nueva Casa");
        BotonNuevaCasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonNuevaCasaActionPerformed(evt);
            }
        });

        BotonEliminarCasa.setText("Eliminar Casa");
        BotonEliminarCasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEliminarCasaActionPerformed(evt);
            }
        });

        VerCasas.setText("Ver");
        VerCasas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerCasasActionPerformed(evt);
            }
        });

        jSeparator4.setBackground(new java.awt.Color(0, 102, 51));
        jSeparator4.setForeground(new java.awt.Color(0, 102, 51));

        GuardarCasas.setText("Guardar");
        GuardarCasas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarCasasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(BotonNuevaCasa)
                .addGap(18, 18, 18)
                .addComponent(GuardarCasas)
                .addGap(34, 34, 34)
                .addComponent(BotonEliminarCasa)
                .addGap(98, 98, 98)
                .addComponent(VerCasas)
                .addContainerGap(478, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator4)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonNuevaCasa)
                    .addComponent(BotonEliminarCasa)
                    .addComponent(VerCasas)
                    .addComponent(GuardarCasas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        TableCasas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "id_casa", "Nombre", "Ubicacion", "Capacidad", "Precio Noche", "Descripcion"
            }
        ));
        ScrollPanelCasas.setViewportView(TableCasas);

        javax.swing.GroupLayout PanelCasasLayout = new javax.swing.GroupLayout(PanelCasas);
        PanelCasas.setLayout(PanelCasasLayout);
        PanelCasasLayout.setHorizontalGroup(
            PanelCasasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCasasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCasasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelCasasLayout.createSequentialGroup()
                        .addComponent(LabelCasas)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(PanelCasasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelCasasLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(ScrollPanelCasas, javax.swing.GroupLayout.DEFAULT_SIZE, 999, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        PanelCasasLayout.setVerticalGroup(
            PanelCasasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCasasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelCasas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(445, Short.MAX_VALUE))
            .addGroup(PanelCasasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCasasLayout.createSequentialGroup()
                    .addContainerGap(107, Short.MAX_VALUE)
                    .addComponent(ScrollPanelCasas, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1034, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(PanelCasas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(PanelCasas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BotonNuevaCasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonNuevaCasaActionPerformed
         DefaultTableModel modelo = (DefaultTableModel) TableCasas.getModel();
    // La ID es 0 temporal, se asignará al guardar
    modelo.addRow(new Object[]{0, "", "", 0, 0.0, ""});
    // Selecciona la nueva fila
    int fila = modelo.getRowCount() - 1;
    TableCasas.setRowSelectionInterval(fila, fila);
    }//GEN-LAST:event_BotonNuevaCasaActionPerformed

    private void BotonEliminarCasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEliminarCasaActionPerformed
        int fila = TableCasas.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una casa para eliminar.");
            return;
        }

        int id = (int) TableCasas.getValueAt(fila, 0);
        int confirmar = JOptionPane.showConfirmDialog(this, "¿Seguro que quieres eliminar esta casa?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirmar != JOptionPane.YES_OPTION) return;

        String sql = "DELETE FROM casas WHERE id_casa=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Casa eliminada correctamente.");
            cargarCasas();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al eliminar casa: " + e.getMessage());
        }
    }//GEN-LAST:event_BotonEliminarCasaActionPerformed

    private void VerCasasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerCasasActionPerformed
         cargarCasas();
    }//GEN-LAST:event_VerCasasActionPerformed

    private void GuardarCasasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarCasasActionPerformed
         DefaultTableModel modelo = (DefaultTableModel) TableCasas.getModel();

    try (Connection conn = DBConnection.getConnection()) {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            Object idObj = modelo.getValueAt(i, 0);
            int id = (idObj instanceof Integer) ? (Integer) idObj : 0;

            String nombre = modelo.getValueAt(i, 1).toString();
            String ubicacion = modelo.getValueAt(i, 2).toString();
            int capacidad = Integer.parseInt(modelo.getValueAt(i, 3).toString());
            double precio = Double.parseDouble(modelo.getValueAt(i, 4).toString());
            String descripcion = modelo.getValueAt(i, 5).toString();

            if (id == 0) {
                // Insertar nueva casa
                String sql = "INSERT INTO casas(nombre, ubicacion, capacidad, precio_noche, descripcion) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setString(1, nombre);
                    ps.setString(2, ubicacion);
                    ps.setInt(3, capacidad);
                    ps.setDouble(4, precio);
                    ps.setString(5, descripcion);
                    ps.executeUpdate();
                }
            } else {
                // Actualizar casa existente
                String sql = "UPDATE casas SET nombre=?, ubicacion=?, capacidad=?, precio_noche=?, descripcion=? WHERE id_casa=?";
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setString(1, nombre);
                    ps.setString(2, ubicacion);
                    ps.setInt(3, capacidad);
                    ps.setDouble(4, precio);
                    ps.setString(5, descripcion);
                    ps.setInt(6, id);
                    ps.executeUpdate();
                }
            }
        }
        JOptionPane.showMessageDialog(this, "Cambios guardados correctamente");
        cargarCasas();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al guardar: " + e.getMessage());
    }
    }//GEN-LAST:event_GuardarCasasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonEliminarCasa;
    private javax.swing.JButton BotonNuevaCasa;
    private javax.swing.JButton GuardarCasas;
    private javax.swing.JLabel LabelCasas;
    private javax.swing.JPanel PanelCasas;
    private javax.swing.JScrollPane ScrollPanelCasas;
    private javax.swing.JTable TableCasas;
    private javax.swing.JButton VerCasas;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator4;
    // End of variables declaration//GEN-END:variables
}
