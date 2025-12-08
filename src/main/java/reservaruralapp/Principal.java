package reservaruralapp;

import java.awt.CardLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;


public class Principal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Principal.class.getName());

    private String usuario;
    private String rol;
    
    
    private void configurarVentana() {
        
        setTitle("Reservas Rurales - Usuario: " + usuario + " (" + rol + ")");
        
        
        Bienvenida.setText("Bienvenido " + usuario + " (" + rol + ")");
    }
    
    
        
    private void mostrarPanel(String nombrePanel) {
        CardLayout layout = (CardLayout) jPanel3.getLayout();
        layout.show(jPanel3, nombrePanel);
    
    
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        BotonNuevaReserva = new javax.swing.JButton();
        BotonClientes = new javax.swing.JButton();
        BotonCasas = new javax.swing.JButton();
        BotonInformes = new javax.swing.JButton();
        BotonOpciones = new javax.swing.JButton();
        logo2 = new javax.swing.JLabel();
        botonBuscarReserva = new javax.swing.JButton();
        CerrarSesion = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        PanelBienvenida = new javax.swing.JPanel();
        Bienvenida = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BotonNuevaReserva.setBackground(new java.awt.Color(233, 250, 233));
        BotonNuevaReserva.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BotonNuevaReserva.setForeground(new java.awt.Color(51, 102, 0));
        BotonNuevaReserva.setText("Nueva Reserva");
        BotonNuevaReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonNuevaReservaActionPerformed(evt);
            }
        });

        BotonClientes.setBackground(new java.awt.Color(233, 250, 233));
        BotonClientes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BotonClientes.setForeground(new java.awt.Color(51, 102, 0));
        BotonClientes.setText("Clientes");
        BotonClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonClientesActionPerformed(evt);
            }
        });

        BotonCasas.setBackground(new java.awt.Color(233, 250, 233));
        BotonCasas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BotonCasas.setForeground(new java.awt.Color(51, 102, 0));
        BotonCasas.setText("Casas");
        BotonCasas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCasasActionPerformed(evt);
            }
        });

        BotonInformes.setBackground(new java.awt.Color(233, 250, 233));
        BotonInformes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BotonInformes.setForeground(new java.awt.Color(51, 102, 0));
        BotonInformes.setText("Informes / Facturas");
        BotonInformes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonInformesActionPerformed(evt);
            }
        });

        BotonOpciones.setBackground(new java.awt.Color(233, 250, 233));
        BotonOpciones.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BotonOpciones.setForeground(new java.awt.Color(51, 102, 0));
        BotonOpciones.setText("Opciones Usuario");
        BotonOpciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonOpcionesActionPerformed(evt);
            }
        });

        logo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logo2.png"))); // NOI18N

        botonBuscarReserva.setBackground(new java.awt.Color(233, 250, 233));
        botonBuscarReserva.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonBuscarReserva.setForeground(new java.awt.Color(51, 102, 0));
        botonBuscarReserva.setText("Reservas");
        botonBuscarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarReservaActionPerformed(evt);
            }
        });

        CerrarSesion.setBackground(new java.awt.Color(233, 250, 233));
        CerrarSesion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        CerrarSesion.setForeground(new java.awt.Color(51, 102, 0));
        CerrarSesion.setText("Cerrar Sesion");
        CerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarSesionActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(238, 253, 238));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 102, 0));
        jButton1.setText("Huespedes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BotonOpciones)
                            .addComponent(CerrarSesion))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonBuscarReserva, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BotonClientes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BotonCasas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(logo2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(BotonNuevaReserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BotonInformes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(15, 15, 15))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logo2)
                .addGap(50, 50, 50)
                .addComponent(BotonNuevaReserva)
                .addGap(18, 18, 18)
                .addComponent(botonBuscarReserva)
                .addGap(18, 18, 18)
                .addComponent(BotonClientes)
                .addGap(18, 18, 18)
                .addComponent(BotonCasas)
                .addGap(19, 19, 19)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(BotonInformes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 468, Short.MAX_VALUE)
                .addComponent(BotonOpciones)
                .addGap(32, 32, 32)
                .addComponent(CerrarSesion)
                .addGap(17, 17, 17))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.LINE_START);

        jPanel3.setLayout(new java.awt.CardLayout());

        PanelBienvenida.setBackground(new java.awt.Color(245, 253, 245));

        javax.swing.GroupLayout PanelBienvenidaLayout = new javax.swing.GroupLayout(PanelBienvenida);
        PanelBienvenida.setLayout(PanelBienvenidaLayout);
        PanelBienvenidaLayout.setHorizontalGroup(
            PanelBienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBienvenidaLayout.createSequentialGroup()
                .addGap(0, 889, Short.MAX_VALUE)
                .addComponent(Bienvenida)
                .addGap(0, 889, Short.MAX_VALUE))
        );
        PanelBienvenidaLayout.setVerticalGroup(
            PanelBienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBienvenidaLayout.createSequentialGroup()
                .addGap(0, 493, Short.MAX_VALUE)
                .addComponent(Bienvenida)
                .addGap(0, 494, Short.MAX_VALUE))
        );

        jPanel3.add(PanelBienvenida, "card7");

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private PanelOpciones panelOpciones;
    private PanelInformes panelInformes;
    private PanelCasas panelCasas;
    private PanelClientes panelClientes;
    private PanelNuevaReserva panelNuevaReserva;
    private PanelBuscarReserva panelBuscarReserva;
    private PanelHuespedes panelHuespedes;

    public Principal(String usuario, String rol) {
    this.usuario = usuario;
    this.rol = rol;

    
    ControlAcceso.setRol(rol);

    initComponents();
    configurarVentana();

    
    ControlAcceso.aplicarPermisos(
        BotonOpciones
        
    );

    
    panelOpciones = new PanelOpciones();
    jPanel3.add(panelOpciones, "cardOpciones");

    panelInformes = new PanelInformes();
    jPanel3.add(panelInformes, "cardInformes");
    
    panelCasas = new PanelCasas();
    jPanel3.add(panelCasas, "cardCasas");
    
    panelClientes = new PanelClientes();
    jPanel3.add(panelClientes, "cardClientes");
    
    panelNuevaReserva = new PanelNuevaReserva();
    jPanel3.add(panelNuevaReserva, "cardReserva");

    panelBuscarReserva = new PanelBuscarReserva();
    jPanel3.add(panelBuscarReserva, "cardBuscar");
    
    panelHuespedes = new PanelHuespedes();
    jPanel3.add(panelHuespedes, "cardHuespedes");
    
    }
    
    private void BotonCasasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCasasActionPerformed
         mostrarPanel("cardCasas"); 
         
    }//GEN-LAST:event_BotonCasasActionPerformed

    private void BotonNuevaReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonNuevaReservaActionPerformed
          mostrarPanel("cardReserva"); 
    }//GEN-LAST:event_BotonNuevaReservaActionPerformed

    private void BotonClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonClientesActionPerformed
         mostrarPanel("cardClientes"); 
    }//GEN-LAST:event_BotonClientesActionPerformed

    private void BotonInformesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonInformesActionPerformed
         mostrarPanel("cardInformes"); 
    }//GEN-LAST:event_BotonInformesActionPerformed

    private void BotonOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonOpcionesActionPerformed
          mostrarPanel("cardOpciones");
    
    }//GEN-LAST:event_BotonOpcionesActionPerformed

    private void botonBuscarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarReservaActionPerformed
         mostrarPanel("cardBuscar");
    }//GEN-LAST:event_botonBuscarReservaActionPerformed

    private void CerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarSesionActionPerformed
        
    rol = null; 
    usuario = null;
   
   this.dispose(); 
    
    Login login = new Login(); 
    login.setVisible(true);
    }//GEN-LAST:event_CerrarSesionActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         mostrarPanel("cardHuespedes");
    }//GEN-LAST:event_jButton1ActionPerformed


    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Bienvenida;
    private javax.swing.JButton BotonCasas;
    private javax.swing.JButton BotonClientes;
    private javax.swing.JButton BotonInformes;
    private javax.swing.JButton BotonNuevaReserva;
    private javax.swing.JButton BotonOpciones;
    private javax.swing.JButton CerrarSesion;
    private javax.swing.JPanel PanelBienvenida;
    private javax.swing.JButton botonBuscarReserva;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel logo2;
    // End of variables declaration//GEN-END:variables

}