package reservaruralapp;

import java.awt.CardLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

/**
 *
 * @author jimen
 */
public class Principal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Principal.class.getName());

    private String usuario;
    private String rol;
    
    


    private void configurarVentana() {
        // Cambiar título dinámicamente
        setTitle("Reservas Rurales - Usuario: " + usuario + " (" + rol + ")");
        
        // Cambiar etiqueta de bienvenida
        Bienvenida.setText("Bienvenido " + usuario + " (" + rol + ")");
    }
    
    
     // Método para mostrar un panel según el botón pulsado
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
        jPanel3 = new javax.swing.JPanel();
        PanelBienvenida = new javax.swing.JPanel();
        Bienvenida = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BotonNuevaReserva.setText("Nueva Reserva");
        BotonNuevaReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonNuevaReservaActionPerformed(evt);
            }
        });

        BotonClientes.setText("Clientes");
        BotonClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonClientesActionPerformed(evt);
            }
        });

        BotonCasas.setText("Casas");
        BotonCasas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCasasActionPerformed(evt);
            }
        });

        BotonInformes.setText("Informes");
        BotonInformes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonInformesActionPerformed(evt);
            }
        });

        BotonOpciones.setText("Opciones");
        BotonOpciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonOpcionesActionPerformed(evt);
            }
        });

        logo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logo2.png"))); // NOI18N

        botonBuscarReserva.setText("Buscar Reserva");
        botonBuscarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarReservaActionPerformed(evt);
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
                        .addComponent(BotonOpciones)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addComponent(botonBuscarReserva)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BotonNuevaReserva)
                .addGap(18, 18, 18)
                .addComponent(BotonClientes)
                .addGap(18, 18, 18)
                .addComponent(BotonCasas)
                .addGap(18, 18, 18)
                .addComponent(BotonInformes)
                .addGap(75, 75, 75)
                .addComponent(BotonOpciones)
                .addGap(14, 14, 14))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.LINE_START);

        jPanel3.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout PanelBienvenidaLayout = new javax.swing.GroupLayout(PanelBienvenida);
        PanelBienvenida.setLayout(PanelBienvenidaLayout);
        PanelBienvenidaLayout.setHorizontalGroup(
            PanelBienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBienvenidaLayout.createSequentialGroup()
                .addGap(0, 505, Short.MAX_VALUE)
                .addComponent(Bienvenida)
                .addGap(0, 506, Short.MAX_VALUE))
        );
        PanelBienvenidaLayout.setVerticalGroup(
            PanelBienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBienvenidaLayout.createSequentialGroup()
                .addGap(0, 275, Short.MAX_VALUE)
                .addComponent(Bienvenida)
                .addGap(0, 275, Short.MAX_VALUE))
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

    public Principal(String usuario, String rol) {
    this.usuario = usuario;
    this.rol = rol;
    initComponents();
    configurarVentana();

    
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
    
    }
    
    private void BotonCasasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCasasActionPerformed
         mostrarPanel("cardCasas"); 
    }//GEN-LAST:event_BotonCasasActionPerformed

    private void BotonNuevaReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonNuevaReservaActionPerformed
          mostrarPanel("cardBuscar"); 
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
         mostrarPanel("cardReserva");
    }//GEN-LAST:event_botonBuscarReservaActionPerformed


    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Bienvenida;
    private javax.swing.JButton BotonCasas;
    private javax.swing.JButton BotonClientes;
    private javax.swing.JButton BotonInformes;
    private javax.swing.JButton BotonNuevaReserva;
    private javax.swing.JButton BotonOpciones;
    private javax.swing.JPanel PanelBienvenida;
    private javax.swing.JButton botonBuscarReserva;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel logo2;
    // End of variables declaration//GEN-END:variables

}