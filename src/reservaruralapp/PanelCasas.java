package reservaruralapp;

import util.DBConnection;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;


public class PanelCasas extends javax.swing.JPanel {
  
    public PanelCasas() {
    initComponents(); 
    }
    public void cargarCasas() {
        DefaultTableModel modelo = (DefaultTableModel) TableCasas.getModel();
        modelo.setRowCount(0); // Limpiar tabla

        String sql = "SELECT * FROM casa";

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
        CampoBuscarCasa = new javax.swing.JTextField();
        BotonLupaCasas = new javax.swing.JButton();
        ScrollPanelCasas = new javax.swing.JScrollPane();
        TableCasas = new javax.swing.JTable();

        LabelCasas.setText("CASAS");

        BotonNuevaCasa.setBackground(new java.awt.Color(239, 252, 239));
        BotonNuevaCasa.setForeground(new java.awt.Color(51, 102, 0));
        BotonNuevaCasa.setText("Agregar Casa");
        BotonNuevaCasa.setToolTipText("Añadir Nueva Linea");
        BotonNuevaCasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonNuevaCasaActionPerformed(evt);
            }
        });

        BotonEliminarCasa.setBackground(new java.awt.Color(239, 252, 239));
        BotonEliminarCasa.setForeground(new java.awt.Color(51, 102, 0));
        BotonEliminarCasa.setText("Eliminar Casa");
        BotonEliminarCasa.setToolTipText("Elimina linea completa");
        BotonEliminarCasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEliminarCasaActionPerformed(evt);
            }
        });

        VerCasas.setBackground(new java.awt.Color(239, 252, 239));
        VerCasas.setForeground(new java.awt.Color(51, 102, 0));
        VerCasas.setText("Ver");
        VerCasas.setToolTipText("Ver Listado Casas");
        VerCasas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerCasasActionPerformed(evt);
            }
        });

        jSeparator4.setBackground(new java.awt.Color(0, 102, 51));
        jSeparator4.setForeground(new java.awt.Color(0, 102, 51));

        GuardarCasas.setBackground(new java.awt.Color(239, 252, 239));
        GuardarCasas.setForeground(new java.awt.Color(51, 102, 0));
        GuardarCasas.setText("Guardar");
        GuardarCasas.setToolTipText("Guarda linea completa o modificaciones");
        GuardarCasas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarCasasActionPerformed(evt);
            }
        });

        CampoBuscarCasa.setToolTipText("Busca en cualquier campo");
        CampoBuscarCasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoBuscarCasaActionPerformed(evt);
            }
        });

        BotonLupaCasas.setBackground(new java.awt.Color(239, 252, 239));
        BotonLupaCasas.setForeground(new java.awt.Color(51, 102, 0));
        BotonLupaCasas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/lupa.png"))); // NOI18N
        BotonLupaCasas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonLupaCasasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(VerCasas)
                .addGap(73, 73, 73)
                .addComponent(BotonNuevaCasa)
                .addGap(84, 84, 84)
                .addComponent(GuardarCasas)
                .addGap(27, 27, 27)
                .addComponent(BotonEliminarCasa)
                .addGap(119, 119, 119)
                .addComponent(CampoBuscarCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotonLupaCasas, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator4)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BotonNuevaCasa)
                            .addComponent(BotonEliminarCasa)
                            .addComponent(VerCasas)
                            .addComponent(GuardarCasas)
                            .addComponent(CampoBuscarCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap(15, Short.MAX_VALUE)
                        .addComponent(BotonLupaCasas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        ScrollPanelCasas.setBackground(new java.awt.Color(204, 255, 204));

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
                    .addGroup(PanelCasasLayout.createSequentialGroup()
                        .addGroup(PanelCasasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(PanelCasasLayout.createSequentialGroup()
                                .addComponent(LabelCasas)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(PanelCasasLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(ScrollPanelCasas, javax.swing.GroupLayout.PREFERRED_SIZE, 1073, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(22, Short.MAX_VALUE))))
        );
        PanelCasasLayout.setVerticalGroup(
            PanelCasasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCasasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelCasas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollPanelCasas, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(PanelCasas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelCasas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BotonLupaCasasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonLupaCasasActionPerformed
         String textoBusqueda = InputUtils.normalizarMayusculas(CampoBuscarCasa.getText().trim());

    
    if (textoBusqueda.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Introduce un texto para buscar.");
        return;
    }

    DefaultTableModel modelo = (DefaultTableModel) TableCasas.getModel();
    modelo.setRowCount(0); // Limpiar la tabla antes de mostrar resultados

    String sql = "SELECT * FROM casa WHERE "
               + "nombre LIKE ? OR "
               + "ubicacion LIKE ? OR "
               + "CAST(capacidad AS CHAR) LIKE ? OR "
               + "CAST(precio_noche AS CHAR) LIKE ? OR "
               + "descripcion LIKE ?";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        // Añadimos el comodín %texto%
        for (int i = 1; i <= 5; i++) {
            ps.setString(i, "%" + InputUtils.normalizarMayusculas(textoBusqueda) + "%");

        }

        ResultSet rs = ps.executeQuery();
        boolean hayResultados = false;

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
            hayResultados = true;
        }

        if (!hayResultados) {
            JOptionPane.showMessageDialog(this, "No se encontraron casas con ese criterio.");
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al buscar casas: " + e.getMessage());
    }
    }//GEN-LAST:event_BotonLupaCasasActionPerformed

    private void CampoBuscarCasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoBuscarCasaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoBuscarCasaActionPerformed

    private void GuardarCasasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarCasasActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) TableCasas.getModel();

    try (Connection conn = DBConnection.getConnection()) {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            Object idObj = modelo.getValueAt(i, 0);
            int id = (idObj instanceof Integer) ? (Integer) idObj : 0;

            String nombre = InputUtils.normalizarMayusculas(modelo.getValueAt(i, 1).toString());
            String ubicacion = InputUtils.normalizarMayusculas(modelo.getValueAt(i, 2).toString());
            int capacidad = Integer.parseInt(modelo.getValueAt(i, 3).toString());
            double precio = Double.parseDouble(modelo.getValueAt(i, 4).toString());
            String descripcion = InputUtils.normalizarMayusculas(modelo.getValueAt(i, 5).toString());

            if (id == 0) {
                // Insertar nueva casa
                String sql = "INSERT INTO casa(nombre, ubicacion, capacidad, precio_noche, descripcion) VALUES (?, ?, ?, ?, ?)";
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
                String sql = "UPDATE casa SET nombre=?, ubicacion=?, capacidad=?, precio_noche=?, descripcion=? WHERE id_casa=?";
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

    private void VerCasasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerCasasActionPerformed
        cargarCasas();
    }//GEN-LAST:event_VerCasasActionPerformed

    private void BotonEliminarCasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEliminarCasaActionPerformed
       int fila = TableCasas.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una casa para eliminar.");
            return;
        }

        int id = (int) TableCasas.getValueAt(fila, 0);
        int confirmar = JOptionPane.showConfirmDialog(this, "¿Seguro que quieres eliminar esta casa?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirmar != JOptionPane.YES_OPTION) return;

        String sql = "DELETE FROM casa WHERE id_casa=?";
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

    private void BotonNuevaCasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonNuevaCasaActionPerformed
    DefaultTableModel modelo = (DefaultTableModel) TableCasas.getModel();
    
    modelo.addRow(new Object[]{0, "", "", 0, 0.0, ""});
    
    int fila = modelo.getRowCount() - 1;
    TableCasas.setRowSelectionInterval(fila, fila);
    }//GEN-LAST:event_BotonNuevaCasaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonEliminarCasa;
    private javax.swing.JButton BotonLupaCasas;
    private javax.swing.JButton BotonNuevaCasa;
    private javax.swing.JTextField CampoBuscarCasa;
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
