
package reservaruralapp;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import util.DBConnection;


public class CalendarioOcupacion extends javax.swing.JPanel {

    private int mesActual, anioActual;
    private DefaultTableModel modeloTabla;
    
    
    public CalendarioOcupacion() {
    initComponents();
    inicializarCalendario();
    cargarCasas();
}

    private void inicializarCalendario() {
        LocalDate hoy = LocalDate.now();
        mesActual = hoy.getMonthValue();
        anioActual = hoy.getYear();

        modeloTabla = (DefaultTableModel) jTable1.getModel();
        jTable1.setRowHeight(50);

        // Permitir botones en JTable
        jTable1.setDefaultRenderer(Object.class, new JTableButtonRenderer());

        actualizarMesAnio();
        actualizarCalendario();
    }
private void actualizarMesAnio() {
        jTextPane1.setText(java.time.Month.of(mesActual)
                .getDisplayName(TextStyle.FULL, Locale.getDefault()) + " " + anioActual);
    }
  private void cambiarMes(int incremento) {
        mesActual += incremento;
        if (mesActual < 1) {
            mesActual = 12;
            anioActual--;
        }
        if (mesActual > 12) {
            mesActual = 1;
            anioActual++;
        }
        actualizarMesAnio();
        actualizarCalendario();
    }
 private void cargarCasas() {
        jComboBox1.removeAllItems();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT nombre FROM casa ORDER BY nombre");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                jComboBox1.addItem(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar casas: " + e.getMessage());
        }

        jComboBox1.addActionListener(e -> actualizarCalendario());
    }
private void actualizarCalendario() {
    String casa = (String) jComboBox1.getSelectedItem();
    if (casa == null) return;

    LocalDate primero = LocalDate.of(anioActual, mesActual, 1);
    int diaSemana = primero.getDayOfWeek().getValue(); // lunes=1
    int numDias = primero.lengthOfMonth();

    // --- Redimensionar filas según el mes ---
    int filasNecesarias = (int) Math.ceil((numDias + diaSemana - 1) / 7.0);
    if (modeloTabla.getRowCount() < filasNecesarias) {
        modeloTabla.setRowCount(filasNecesarias);
    }

    // Limpiar tabla
    for (int i = 0; i < modeloTabla.getRowCount(); i++)
        for (int j = 0; j < modeloTabla.getColumnCount(); j++)
            modeloTabla.setValueAt(null, i, j);

    // Obtener días ocupados de la BBDD
    List<Integer> diasOcupados = new ArrayList<>();

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(
                 "SELECT fecha_inicio, fecha_fin FROM reserva r JOIN casa c ON r.id_casa=c.id_casa " +
                 "WHERE c.nombre=?")) {

        ps.setString(1, casa);
        ResultSet rs = ps.executeQuery();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (rs.next()) {
            LocalDate inicio = LocalDate.parse(rs.getString("fecha_inicio"), df);
            LocalDate fin = LocalDate.parse(rs.getString("fecha_fin"), df);

            // Día final realmente ocupado (excluye día de salida)
            LocalDate ultimoDiaOcupado = fin.minusDays(1);

            LocalDate temp = inicio;
            while (!temp.isAfter(ultimoDiaOcupado)) {
                if (temp.getMonthValue() == mesActual) {
                    diasOcupados.add(temp.getDayOfMonth());
                }
                temp = temp.plusDays(1);
            }
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al cargar reservas: " + e.getMessage());
    }

    // Rellenar tabla con botones
    int col = diaSemana - 1;
    int fila = 0;

    for (int dia = 1; dia <= numDias; dia++) {
        JButton botonDia = new JButton(String.valueOf(dia));
        botonDia.setOpaque(true);
        botonDia.setBorderPainted(false);

        if (diasOcupados.contains(dia)) {
            botonDia.setBackground(java.awt.Color.RED);
        } else {
            botonDia.setBackground(java.awt.Color.GREEN);
        }

        modeloTabla.setValueAt(botonDia, fila, col);
        col++;
        if (col == 7) {
            col = 0;
            fila++;
        }
    }
}



 static class JTableButtonRenderer implements javax.swing.table.TableCellRenderer {
        @Override
        public java.awt.Component getTableCellRendererComponent(JTable table, Object value,
                                                                boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof JButton) return (JButton) value;
            return new JLabel(value == null ? "" : value.toString());
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jComboBox1 = new javax.swing.JComboBox<>();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "LUNES", "MARTES", "MIERCOLES", "JUEVES", "VIERNES", "SABADO", "DOMINGO"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("<");
        jButton1.setToolTipText("Mes anterior");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText(">");
        jButton2.setToolTipText("Mes posterior");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(jTextPane1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setToolTipText("Seleccionar Casa");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 825, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(489, 489, 489)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(345, 345, 345))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(148, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         cambiarMes(1); // Mes siguiente
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        cambiarMes(-1); // Mes anterior// Mes siguiente
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
