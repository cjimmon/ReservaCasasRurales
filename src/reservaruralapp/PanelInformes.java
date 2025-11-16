/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package reservaruralapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import util.DBConnection;
/**
 *
 * @author jimen
 */
public class PanelInformes extends javax.swing.JPanel {

    /**
     * Creates new form PanelInformes
     */
    public PanelInformes() {
        initComponents();
    }
    private String convertirFechaISO(String fecha) {
    // Convierte de "dd/MM/yyyy" a "yyyy-MM-dd"
    String[] partes = fecha.split("/");
    return partes[2] + "-" + partes[1] + "-" + partes[0];
}

private void generarResumenPeriodo(String inicioSQL, String finSQL) {
    try (Connection conn = DBConnection.getConnection()) {

        String[] estados = {"CONFIRMADA", "PENDIENTE", "CANCELADA"};

        for (String estado : estados) {
            int total = 0;
            double ingresos = 0;

            if (!estado.equals("CANCELADA")) {
                // Calcular total e ingresos
                String sql =
                    "SELECT COUNT(*) AS total, " +
                    "SUM((julianday(substr(r.fecha_fin,7,4)||'-'||substr(r.fecha_fin,4,2)||'-'||substr(r.fecha_fin,1,2)) - " +
                    "julianday(substr(r.fecha_inicio,7,4)||'-'||substr(r.fecha_inicio,4,2)||'-'||substr(r.fecha_inicio,1,2))) * c.precio_noche) AS ingresos " +
                    "FROM reserva r JOIN casa c ON r.id_casa = c.id_casa " +
                    "WHERE r.estado = ? " +
                    "AND (substr(r.fecha_inicio,7,4)||'-'||substr(r.fecha_inicio,4,2)||'-'||substr(r.fecha_inicio,1,2)) <= ? " +
                    "AND (substr(r.fecha_fin,7,4)||'-'||substr(r.fecha_fin,4,2)||'-'||substr(r.fecha_fin,1,2)) >= ?";

                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setString(1, estado);
                    ps.setString(2, finSQL);
                    ps.setString(3, inicioSQL);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        total = rs.getInt("total");
                        ingresos = rs.getDouble("ingresos");
                    }
                }
            } else {
                // Solo contar canceladas
                String sql =
                    "SELECT COUNT(*) AS total " +
                    "FROM reserva r " +
                    "WHERE r.estado = ? " +
                    "AND (substr(r.fecha_inicio,7,4)||'-'||substr(r.fecha_inicio,4,2)||'-'||substr(r.fecha_inicio,1,2)) <= ? " +
                    "AND (substr(r.fecha_fin,7,4)||'-'||substr(r.fecha_fin,4,2)||'-'||substr(r.fecha_fin,1,2)) >= ?";

                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setString(1, estado);
                    ps.setString(2, finSQL);
                    ps.setString(3, inicioSQL);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) total = rs.getInt("total");
                }
            }

            // Mostrar resultados
            String label = switch (estado) {
                case "CONFIRMADA" -> "Reservas confirmadas";
                case "PENDIENTE" -> "Reservas pendientes";
                case "CANCELADA" -> "Reservas canceladas";
                default -> "";
            };

            AreaInformacion.append("• " + label + ": " + total + "\n");
            if (!estado.equals("CANCELADA")) {
                AreaInformacion.append("  - Ingresos: " + String.format("%.2f €", ingresos) + "\n");
            }
        }

        // Casa más alquilada (solo confirmadas y pendientes)
        String sqlCasa =
            "SELECT c.nombre, COUNT(*) AS veces " +
            "FROM reserva r JOIN casa c ON r.id_casa = c.id_casa " +
            "WHERE r.estado IN ('CONFIRMADA','PENDIENTE') " +
            "AND (substr(r.fecha_inicio,7,4)||'-'||substr(r.fecha_inicio,4,2)||'-'||substr(r.fecha_inicio,1,2)) <= ? " +
            "AND (substr(r.fecha_fin,7,4)||'-'||substr(r.fecha_fin,4,2)||'-'||substr(r.fecha_fin,1,2)) >= ? " +
            "GROUP BY c.id_casa ORDER BY veces DESC LIMIT 1";

        String casaMas = "Sin datos";
        int veces = 0;
        try (PreparedStatement ps = conn.prepareStatement(sqlCasa)) {
            ps.setString(1, finSQL);
            ps.setString(2, inicioSQL);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                casaMas = rs.getString("nombre");
                veces = rs.getInt("veces");
            }
        }

        AreaInformacion.append("• Casa más alquilada: " + casaMas + " (" + veces + " veces)\n");

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this,
            "Error al generar resumen: " + ex.getMessage());
    }
}

 private void generarInformeReservas(String FechaInicioInformes, String FechaFinInformes) {
    String sql = "SELECT id_reserva, id_cliente, id_casa, fecha_inicio, fecha_fin, num_personas, estado "
           + "FROM reserva "
           + "WHERE (substr(fecha_inicio, 7, 4) || '-' || substr(fecha_inicio, 4, 2) || '-' || substr(fecha_inicio, 1, 2)) "
           + "BETWEEN ? AND ? "
           + "ORDER BY fecha_inicio";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, convertirFechaISO(FechaInicioInformes));
        ps.setString(2, convertirFechaISO(FechaFinInformes));

        ResultSet rs = ps.executeQuery();

        jTextArea1.append("=== INFORME DE RESERVAS ===\n\n");

        while (rs.next()) {
            jTextArea1.append(
                "ID Reserva: " + rs.getInt("id_reserva") + "\n" +
                "Cliente: " + rs.getInt("id_cliente") + "\n" +
                "Casa: " + rs.getInt("id_casa") + "\n" +
                "Desde: " + rs.getString("fecha_inicio") + "\n" +
                "Hasta: " + rs.getString("fecha_fin") + "\n" +
                "Numero Personas: " + rs.getInt("num_personas") + "\n" +
                "Estado: " + rs.getString("estado") + "\n" +
                "----------------------------------------\n"
            );
        }

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this,
            "Error al generar informe de reservas: " + ex.getMessage());
    }
}
 private void generarInformeClientes(String FechaInicioInformes, String FechaFinInformes) {
    String sql = "SELECT c.id_cliente, c.nombre, c.apellidos, c.DNI, c.telefono, c.email, c.comentarios " +
             "FROM cliente c " +
             "JOIN reserva r ON c.id_cliente = r.id_cliente " +
             "WHERE (substr(r.fecha_inicio, 7, 4) || '-' || substr(r.fecha_inicio, 4, 2) || '-' || substr(r.fecha_inicio, 1, 2)) " +
             "BETWEEN ? AND ? " +
             "GROUP BY c.id_cliente, c.nombre, c.apellidos, c.DNI, c.telefono, c.email, c.comentarios " +
             "ORDER BY r.fecha_inicio";


    try (Connection con = DBConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, convertirFechaISO(FechaInicioInformes));
        ps.setString(2, convertirFechaISO(FechaFinInformes));

        ResultSet rs = ps.executeQuery();

        jTextArea1.append("=== INFORME DE CLIENTES CON RESERVAS EN EL PERIODO ===\n\n");

        while (rs.next()) {
            jTextArea1.append(
                "ID Cliente: " + rs.getInt("id_cliente") + "\n" +
                "Nombre: " + rs.getString("nombre") + "\n" +
                "Apellidos: " + rs.getString("apellidos") + "\n" +
                "DNI: " + rs.getString("dni") + "\n" +
                "Teléfono: " + rs.getString("telefono") + "\n" +
                "Email: " + rs.getString("email") + "\n" +
                "Comentarios: " + rs.getString("Comentarios") + "\n" +
                "----------------------------------------\n"
            );
        }

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error al generar informe de clientes: " + ex.getMessage());
    }
}

  private void generarInformeFacturas(String FechaInicioInformes, String FechaFinInformes) {
    String sql = "SELECT f.id_factura, f.id_reserva, f.fecha_emision, f.importe_total, r.estado " +
         "FROM Factura f " +
         "INNER JOIN reserva r ON f.id_reserva = r.id_reserva " +
         "WHERE (substr(f.fecha_emision, 7, 4) || '-' || substr(f.fecha_emision, 4, 2) || '-' || substr(f.fecha_emision, 1, 2)) " +
         "BETWEEN ? AND ? " +
         "ORDER BY f.fecha_emision";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, convertirFechaISO(FechaInicioInformes));
        ps.setString(2, convertirFechaISO(FechaFinInformes));

        ResultSet rs = ps.executeQuery();

        jTextArea1.append("=== INFORME DE FACTURAS ===\n\n");

        while (rs.next()) {
            jTextArea1.append(
                "ID Factura: " + rs.getInt("id_factura") + "\n" +
                "Reserva: " + rs.getInt("id_reserva") + "\n" +
                "Fecha Emisión: " + rs.getString("fecha_emision") + "\n" +
                "Total: " + rs.getDouble("importe_total") + " €\n" +
                "Estado reserva: " + rs.getString("estado") + "\n" +
                "----------------------------------------\n"
            );
        }

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this,
            "Error al generar informe de facturas: " + ex.getMessage());
    }
}

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelInformes = new javax.swing.JPanel();
        LabelInformes = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        ComboBoxInformes = new javax.swing.JComboBox<>();
        FechaInicioInformes = new javax.swing.JTextField();
        FechaFinalInformes = new javax.swing.JTextField();
        BotonGenerarInforme = new javax.swing.JButton();
        BotonPDF = new javax.swing.JButton();
        LabelFechaInicioInformes = new javax.swing.JLabel();
        LabelFechaFinInformes = new javax.swing.JLabel();
        SeparadorInformes = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        AreaInformacion = new javax.swing.JTextArea();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelInformes.setText("INFORMES");

        ComboBoxInformes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Reserva", "Factura", "Cliente" }));
        ComboBoxInformes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxInformesActionPerformed(evt);
            }
        });

        FechaInicioInformes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FechaInicioInformesActionPerformed(evt);
            }
        });

        FechaFinalInformes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FechaFinalInformesActionPerformed(evt);
            }
        });

        BotonGenerarInforme.setBackground(new java.awt.Color(239, 252, 239));
        BotonGenerarInforme.setForeground(new java.awt.Color(51, 102, 0));
        BotonGenerarInforme.setText("Generar Informe");
        BotonGenerarInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGenerarInformeActionPerformed(evt);
            }
        });

        BotonPDF.setBackground(new java.awt.Color(239, 252, 239));
        BotonPDF.setForeground(new java.awt.Color(51, 102, 0));
        BotonPDF.setText("Exportar Pdf");
        BotonPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonPDFActionPerformed(evt);
            }
        });

        LabelFechaInicioInformes.setText("Fecha Inicio:");

        LabelFechaFinInformes.setText("Fecha Fin:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(ComboBoxInformes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(LabelFechaInicioInformes)
                .addGap(18, 18, 18)
                .addComponent(FechaInicioInformes, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LabelFechaFinInformes)
                .addGap(18, 18, 18)
                .addComponent(FechaFinalInformes, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(BotonGenerarInforme)
                .addGap(42, 42, 42)
                .addComponent(BotonPDF)
                .addGap(65, 65, 65))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBoxInformes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FechaInicioInformes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FechaFinalInformes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonGenerarInforme)
                    .addComponent(BotonPDF)
                    .addComponent(LabelFechaInicioInformes)
                    .addComponent(LabelFechaFinInformes))
                .addContainerGap())
        );

        SeparadorInformes.setBackground(new java.awt.Color(0, 102, 51));
        SeparadorInformes.setForeground(new java.awt.Color(0, 102, 51));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        AreaInformacion.setColumns(20);
        AreaInformacion.setRows(5);
        jScrollPane1.setViewportView(AreaInformacion);

        javax.swing.GroupLayout PanelInformesLayout = new javax.swing.GroupLayout(PanelInformes);
        PanelInformes.setLayout(PanelInformesLayout);
        PanelInformesLayout.setHorizontalGroup(
            PanelInformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInformesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelInformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelInformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LabelInformes, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(SeparadorInformes, javax.swing.GroupLayout.PREFERRED_SIZE, 991, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1088, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        PanelInformesLayout.setVerticalGroup(
            PanelInformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInformesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelInformes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SeparadorInformes, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        add(PanelInformes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 710));
    }// </editor-fold>//GEN-END:initComponents

    private void ComboBoxInformesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxInformesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxInformesActionPerformed

    private void FechaInicioInformesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FechaInicioInformesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FechaInicioInformesActionPerformed

    private void FechaFinalInformesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FechaFinalInformesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FechaFinalInformesActionPerformed

    private void BotonGenerarInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGenerarInformeActionPerformed
            String tipo = ComboBoxInformes.getSelectedItem().toString();
           String fechaInicio = FechaInicioInformes.getText().trim();
           String fechaFin = FechaFinalInformes.getText().trim();

           if (fechaInicio.isEmpty() || fechaFin.isEmpty()) {
               JOptionPane.showMessageDialog(this, "Debes introducir fecha inicio y fecha fin.");
               return;
           }

           // LIMPIAR ÁREAS
           jTextArea1.setText("");
           AreaInformacion.setText("");

           // Convertir a formato SQL
           String inicioSQL = convertirFechaISO(fechaInicio);
           String finSQL = convertirFechaISO(fechaFin);

           // Resumen en AreaInformacion
           generarResumenPeriodo(inicioSQL, finSQL);

           // Informe detallado
           switch (tipo) {
               case "Reserva":
                   generarInformeReservas(fechaInicio, fechaFin);
                   break;
               case "Cliente":
                   generarInformeClientes(fechaInicio, fechaFin);
                   break;
               case "Factura":
                   generarInformeFacturas(fechaInicio, fechaFin);
                   break;
               default:
                   JOptionPane.showMessageDialog(this, "Tipo de informe desconocido.");
           }
    }//GEN-LAST:event_BotonGenerarInformeActionPerformed

    private void BotonPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonPDFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonPDFActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AreaInformacion;
    private javax.swing.JButton BotonGenerarInforme;
    private javax.swing.JButton BotonPDF;
    private javax.swing.JComboBox<String> ComboBoxInformes;
    private javax.swing.JTextField FechaFinalInformes;
    private javax.swing.JTextField FechaInicioInformes;
    private javax.swing.JLabel LabelFechaFinInformes;
    private javax.swing.JLabel LabelFechaInicioInformes;
    private javax.swing.JLabel LabelInformes;
    private javax.swing.JPanel PanelInformes;
    private javax.swing.JSeparator SeparadorInformes;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
