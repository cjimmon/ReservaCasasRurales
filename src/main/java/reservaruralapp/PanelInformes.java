
package reservaruralapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import util.DBConnection;

public class PanelInformes extends javax.swing.JPanel {

    
    public PanelInformes() {
        initComponents();
        generarResumenAnual();
    }
    private String convertirFechaISO(String fecha) {   
    String[] partes = fecha.split("/");
    return partes[2] + "-" + partes[1] + "-" + partes[0];
}
    private void generarResumenAnual() {
    try (Connection conn = DBConnection.getConnection()) {

        // Año vigente
        java.time.Year yearActual = java.time.Year.now();
        String inicioAnio = yearActual + "-01-01";
        String finAnio = yearActual + "-12-31";

        String[] estados = {"CONFIRMADA", "PENDIENTE", "CANCELADA"};
        double ingresosTotales = 0;
        AreaInformacion2.setText("");
        AreaInformacion2.setText("=== RESUMEN ANUAL DE RESERVAS (" + yearActual + ") ===\n\n");

        for (String estado : estados) {
            int total = 0;
            double ingresos = 0;

            if (!estado.equals("CANCELADA")) {
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
                    ps.setString(2, finAnio);
                    ps.setString(3, inicioAnio);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        total = rs.getInt("total");
                        ingresos = rs.getDouble("ingresos");
                        ingresosTotales += ingresos;
                    }
                }
            } else {
                String sql =
                    "SELECT COUNT(*) AS total " +
                    "FROM reserva r " +
                    "WHERE r.estado = ? " +
                    "AND (substr(r.fecha_inicio,7,4)||'-'||substr(r.fecha_inicio,4,2)||'-'||substr(r.fecha_inicio,1,2)) <= ? " +
                    "AND (substr(r.fecha_fin,7,4)||'-'||substr(r.fecha_fin,4,2)||'-'||substr(r.fecha_fin,1,2)) >= ?";

                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setString(1, estado);
                    ps.setString(2, finAnio);
                    ps.setString(3, inicioAnio);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) total = rs.getInt("total");
                }
            }

            String label = switch (estado) {
                case "CONFIRMADA" -> "Reservas confirmadas";
                case "PENDIENTE" -> "Reservas pendientes";
                case "CANCELADA" -> "Reservas canceladas";
                default -> "";
            };

            AreaInformacion2.append("• " + label + ": " + total + "\n");
            if (!estado.equals("CANCELADA")) {
                AreaInformacion2.append("  - Ingresos: " + String.format("%.2f €", ingresos) + "\n");
            }
        }

        AreaInformacion2.append("\nIngresos totales del año: " + String.format("%.2f €", ingresosTotales));

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this,
            "Error al generar resumen anual: " + ex.getMessage());
    }
}


    private void generarResumenPeriodo(String inicioSQL, String finSQL) {
    try (Connection conn = DBConnection.getConnection()) {

        String[] estados = {"CONFIRMADA", "PENDIENTE", "CANCELADA"};

        for (String estado : estados) {
            int total = 0;
            double ingresos = 0;

            if (!estado.equals("CANCELADA")) {
              
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

    private void generarInformeHuespedes(String FechaInicioInformes, String FechaFinInformes) {
     String sql = "SELECT id_huesped, id_reserva, nombre_completo, tipo_documento, numero_documento, sexo, " +
                 "fecha_nacimiento, nacionalidad, domicilio, fecha_entrada, fecha_salida " +
                 "FROM Huespedes " +
                 "WHERE (substr(fecha_entrada, 7, 4) || '-' || substr(fecha_entrada, 4, 2) || '-' || substr(fecha_entrada, 1, 2)) " +
                 "BETWEEN ? AND ? " +
                 "ORDER BY fecha_entrada";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, convertirFechaISO(FechaInicioInformes));
        ps.setString(2, convertirFechaISO(FechaFinInformes));

        ResultSet rs = ps.executeQuery();

        jTextArea1.append("=== INFORME DE HUESPEDES EN EL PERIODO ===\n\n");

        while (rs.next()) {
            jTextArea1.append(
               
                "ID Reserva: " + rs.getInt("id_reserva") + "\n" +
                "Nombre Completo: " + rs.getString("nombre_completo") + "\n" +
                "Tipo Documento: " + rs.getString("tipo_documento") + "\n" +
                "Número Documento: " + rs.getString("numero_documento") + "\n" +
                "Sexo: " + rs.getString("sexo") + "\n" +
                "Fecha Nacimiento: " + rs.getString("fecha_nacimiento") + "\n" +
                "Nacionalidad: " + rs.getString("nacionalidad") + "\n" +
                "Domicilio: " + rs.getString("domicilio") + "\n" +
                "Fecha Entrada: " + rs.getString("fecha_entrada") + "\n" +
                "Fecha Salida: " + rs.getString("fecha_salida") + "\n" +
                "----------------------------------------\n"
            );
        }

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error al generar informe de huespedes: " + ex.getMessage());
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
        LabelFechaInicioInformes = new javax.swing.JLabel();
        LabelFechaFinInformes = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        BotonPDF = new javax.swing.JButton();
        SeparadorInformes = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        AreaInformacion = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        AreaInformacion2 = new javax.swing.JTextArea();
        btnEnviarEmail = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        PanelInformes.setBackground(new java.awt.Color(255, 255, 255));

        LabelInformes.setText("INFORMES");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        ComboBoxInformes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Reserva", "Factura", "Cliente", "Huespedes" }));
        ComboBoxInformes.setToolTipText("Selecciona el tipo de informe");
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
        BotonGenerarInforme.setText("Buscar /Actualizar");
        BotonGenerarInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGenerarInformeActionPerformed(evt);
            }
        });

        LabelFechaInicioInformes.setText("Fecha Inicio:");

        LabelFechaFinInformes.setText("Fecha Fin:");

        ID.setToolTipText("Introduzca numero de factura");

        BotonPDF.setBackground(new java.awt.Color(239, 252, 239));
        BotonPDF.setForeground(new java.awt.Color(51, 102, 0));
        BotonPDF.setText("Exportar Pdf");
        BotonPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(ComboBoxInformes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelFechaInicioInformes)
                .addGap(18, 18, 18)
                .addComponent(FechaInicioInformes, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(LabelFechaFinInformes)
                .addGap(18, 18, 18)
                .addComponent(FechaFinalInformes, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(BotonGenerarInforme)
                .addGap(107, 107, 107)
                .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BotonPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                    .addComponent(LabelFechaInicioInformes)
                    .addComponent(LabelFechaFinInformes)
                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonPDF))
                .addContainerGap())
        );

        SeparadorInformes.setBackground(new java.awt.Color(0, 102, 51));
        SeparadorInformes.setForeground(new java.awt.Color(0, 102, 51));

        jTextArea1.setBackground(new java.awt.Color(204, 255, 204));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        AreaInformacion.setColumns(20);
        AreaInformacion.setRows(5);
        jScrollPane1.setViewportView(AreaInformacion);

        AreaInformacion2.setColumns(20);
        AreaInformacion2.setRows(5);
        jScrollPane3.setViewportView(AreaInformacion2);

        btnEnviarEmail.setBackground(new java.awt.Color(241, 253, 241));
        btnEnviarEmail.setForeground(new java.awt.Color(51, 102, 0));
        btnEnviarEmail.setText("Enviar factura al Cliente");
        btnEnviarEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarEmailActionPerformed(evt);
            }
        });

        jLabel1.setText("TOTALES POR AÑO VIGENTE");

        jLabel2.setText("TOTALES POR PERIODO SELECCIONADO");

        javax.swing.GroupLayout PanelInformesLayout = new javax.swing.GroupLayout(PanelInformes);
        PanelInformes.setLayout(PanelInformesLayout);
        PanelInformesLayout.setHorizontalGroup(
            PanelInformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInformesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelInformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelInformesLayout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnEnviarEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LabelInformes)
                    .addComponent(SeparadorInformes, javax.swing.GroupLayout.PREFERRED_SIZE, 1688, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelInformesLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 806, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(PanelInformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelInformesLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(PanelInformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PanelInformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(PanelInformesLayout.createSequentialGroup()
                                .addGap(149, 149, 149)
                                .addComponent(jLabel1)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelInformesLayout.setVerticalGroup(
            PanelInformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInformesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelInformes)
                .addGroup(PanelInformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelInformesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SeparadorInformes, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelInformesLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btnEnviarEmail)))
                .addGroup(PanelInformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelInformesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(91, Short.MAX_VALUE))
                    .addGroup(PanelInformesLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(148, 148, 148))))
        );

        add(PanelInformes, java.awt.BorderLayout.CENTER);
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
            generarResumenAnual();
            String tipo = ComboBoxInformes.getSelectedItem().toString();
            String fechaInicio = FechaInicioInformes.getText().trim();
            String fechaFin = FechaFinalInformes.getText().trim();

           if (fechaInicio.isEmpty() || fechaFin.isEmpty()) {
               JOptionPane.showMessageDialog(this, "Debes introducir fecha inicio y fecha fin.");
               return;
           }
               if (!InputUtils.validaFecha(fechaInicio) || !InputUtils.validaFecha(fechaFin)) {
                JOptionPane.showMessageDialog(this, "Formato de fecha incorrecto. Use dd/MM/yyyy");
                return;
           }

           
           jTextArea1.setText("");
           AreaInformacion.setText("");

           
           String inicioSQL = convertirFechaISO(fechaInicio);
           String finSQL = convertirFechaISO(fechaFin);

          
           generarResumenPeriodo(inicioSQL, finSQL);

       
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
               case "Huespedes":
                   generarInformeHuespedes(fechaInicio, fechaFin);
                   break;
               default:
                   JOptionPane.showMessageDialog(this, "Tipo de informe desconocido.");
           }
    }//GEN-LAST:event_BotonGenerarInformeActionPerformed

    private void BotonPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonPDFActionPerformed
         String tipo = ComboBoxInformes.getSelectedItem().toString();

    switch (tipo) {
        case "Factura":
            try {
                String idFacturaStr = ID.getText().trim(); // Campo donde introduces el nº de factura
                if (idFacturaStr.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Introduce un ID de factura.");
                    return;
                }
                int idFactura = Integer.parseInt(idFacturaStr);
                GenerarFactura.generarFacturaConDialogo(idFactura); // Solo usa el número de factura
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Introduce un ID de factura válido.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al generar la factura: " + e.getMessage());
            }
            break;

        case "Cliente":
            // Para clientes sí necesitamos fechas
            String fechaInicioCliente = FechaInicioInformes.getText().trim();
            String fechaFinCliente = FechaFinalInformes.getText().trim();
            if (fechaInicioCliente.isEmpty() || fechaFinCliente.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debes introducir fecha inicio y fecha fin.");
                return;
            }
            new GenerarListadoClientes().generarPDFcliente(
                convertirFechaISO(fechaInicioCliente),
                convertirFechaISO(fechaFinCliente)
            );
            break;

        case "Reserva":
            // Para reservas también necesitamos fechas
            String fechaInicioReserva = FechaInicioInformes.getText().trim();
            String fechaFinReserva = FechaFinalInformes.getText().trim();
            if (fechaInicioReserva.isEmpty() || fechaFinReserva.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debes introducir fecha inicio y fecha fin.");
                return;
            }
            new GenerarListadoReservas().generarPDFreservas(
                convertirFechaISO(fechaInicioReserva),
                convertirFechaISO(fechaFinReserva)
            );
            break;
            
        case "Huespedes":
            String fechaInicioHuesped = FechaInicioInformes.getText().trim();
            String fechaFinHuesped = FechaFinalInformes.getText().trim();
            if (fechaInicioHuesped.isEmpty() || fechaFinHuesped.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debes introducir fecha inicio y fecha fin.");
                return;
            }
            new GenerarListadoHuespedes().generarPDFHuespedes(
                convertirFechaISO(fechaInicioHuesped),
                convertirFechaISO(fechaFinHuesped)
            );
            break;
            
    }
    }//GEN-LAST:event_BotonPDFActionPerformed

    private void btnEnviarEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarEmailActionPerformed
           try {
        int idFactura = Integer.parseInt(ID.getText().trim());

        // Creamos objeto de envío
        EnvioEmailConAdjunto envio = new EnvioEmailConAdjunto();

        // Generamos PDF en memoria
        byte[] pdfBytes = envio.generarFacturaEnMemoria(idFactura);

        // Obtenemos email del cliente
        String emailCliente = envio.obtenerEmailClientePorFactura(idFactura);

        if (emailCliente != null && pdfBytes != null) {
            envio.enviarFacturaPorEmail(emailCliente, pdfBytes, "Factura_" + idFactura + ".pdf");
        }

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Introduce un ID de factura válido.");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al generar o enviar la factura: " + e.getMessage());
        e.printStackTrace();
    }
    }//GEN-LAST:event_btnEnviarEmailActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AreaInformacion;
    private javax.swing.JTextArea AreaInformacion2;
    private javax.swing.JButton BotonGenerarInforme;
    private javax.swing.JButton BotonPDF;
    private javax.swing.JComboBox<String> ComboBoxInformes;
    private javax.swing.JTextField FechaFinalInformes;
    private javax.swing.JTextField FechaInicioInformes;
    private javax.swing.JTextField ID;
    private javax.swing.JLabel LabelFechaFinInformes;
    private javax.swing.JLabel LabelFechaInicioInformes;
    private javax.swing.JLabel LabelInformes;
    private javax.swing.JPanel PanelInformes;
    private javax.swing.JSeparator SeparadorInformes;
    private javax.swing.JButton btnEnviarEmail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
