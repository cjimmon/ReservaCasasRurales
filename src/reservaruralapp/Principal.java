package reservaruralapp;

import java.awt.CardLayout;

/**
 *
 * @author jimen
 */
public class Principal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Principal.class.getName());

    private String usuario;
    private String rol;
    
    
    public Principal(String usuario, String rol) {
        this.usuario = usuario;
        this.rol = rol;
        initComponents();
        configurarVentana();
    }

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

        jPanel2 = new javax.swing.JPanel();
        BotonReservas = new javax.swing.JButton();
        BotonClientes = new javax.swing.JButton();
        BotonCasas = new javax.swing.JButton();
        BotonInformes = new javax.swing.JButton();
        BotonOpciones = new javax.swing.JButton();
        logo2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        PanelBienvenida = new javax.swing.JPanel();
        Bienvenida = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        PanelReservas = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        PanelClientes = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        PanelCasas = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        PanelInformes = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        PanelOpciones = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BotonReservas.setText("Reservas");
        BotonReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonReservasActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(BotonOpciones)
                        .addGap(23, 23, 23))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BotonClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BotonCasas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(logo2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(BotonReservas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BotonInformes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(15, 15, 15))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logo2)
                .addGap(28, 28, 28)
                .addComponent(BotonReservas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BotonClientes)
                .addGap(18, 18, 18)
                .addComponent(BotonCasas)
                .addGap(18, 18, 18)
                .addComponent(BotonInformes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                .addComponent(BotonOpciones)
                .addGap(14, 14, 14))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.LINE_START);

        jPanel3.setLayout(new java.awt.CardLayout());

        jLabel1.setText("Comenzar");

        javax.swing.GroupLayout PanelBienvenidaLayout = new javax.swing.GroupLayout(PanelBienvenida);
        PanelBienvenida.setLayout(PanelBienvenidaLayout);
        PanelBienvenidaLayout.setHorizontalGroup(
            PanelBienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBienvenidaLayout.createSequentialGroup()
                .addGap(281, 281, 281)
                .addComponent(jLabel1)
                .addContainerGap(386, Short.MAX_VALUE))
            .addGroup(PanelBienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelBienvenidaLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Bienvenida)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        PanelBienvenidaLayout.setVerticalGroup(
            PanelBienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBienvenidaLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addContainerGap(441, Short.MAX_VALUE))
            .addGroup(PanelBienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelBienvenidaLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Bienvenida)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel3.add(PanelBienvenida, "card7");

        jLabel2.setText("reservas");

        javax.swing.GroupLayout PanelReservasLayout = new javax.swing.GroupLayout(PanelReservas);
        PanelReservas.setLayout(PanelReservasLayout);
        PanelReservasLayout.setHorizontalGroup(
            PanelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelReservasLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel2)
                .addContainerGap(628, Short.MAX_VALUE))
        );
        PanelReservasLayout.setVerticalGroup(
            PanelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelReservasLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addContainerGap(466, Short.MAX_VALUE))
        );

        jPanel3.add(PanelReservas, "card2");

        jLabel3.setText("Clientes");

        javax.swing.GroupLayout PanelClientesLayout = new javax.swing.GroupLayout(PanelClientes);
        PanelClientes.setLayout(PanelClientesLayout);
        PanelClientesLayout.setHorizontalGroup(
            PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelClientesLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jLabel3)
                .addContainerGap(584, Short.MAX_VALUE))
        );
        PanelClientesLayout.setVerticalGroup(
            PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelClientesLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel3)
                .addContainerGap(449, Short.MAX_VALUE))
        );

        jPanel3.add(PanelClientes, "card3");

        jLabel4.setText("Casas");

        javax.swing.GroupLayout PanelCasasLayout = new javax.swing.GroupLayout(PanelCasas);
        PanelCasas.setLayout(PanelCasasLayout);
        PanelCasasLayout.setHorizontalGroup(
            PanelCasasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCasasLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel4)
                .addContainerGap(620, Short.MAX_VALUE))
        );
        PanelCasasLayout.setVerticalGroup(
            PanelCasasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCasasLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel4)
                .addContainerGap(448, Short.MAX_VALUE))
        );

        jPanel3.add(PanelCasas, "card4");

        jLabel5.setText("Informes");

        javax.swing.GroupLayout PanelInformesLayout = new javax.swing.GroupLayout(PanelInformes);
        PanelInformes.setLayout(PanelInformesLayout);
        PanelInformesLayout.setHorizontalGroup(
            PanelInformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInformesLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel5)
                .addContainerGap(604, Short.MAX_VALUE))
        );
        PanelInformesLayout.setVerticalGroup(
            PanelInformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInformesLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel5)
                .addContainerGap(456, Short.MAX_VALUE))
        );

        jPanel3.add(PanelInformes, "card5");

        jLabel6.setText("Opciones");

        javax.swing.GroupLayout PanelOpcionesLayout = new javax.swing.GroupLayout(PanelOpciones);
        PanelOpciones.setLayout(PanelOpcionesLayout);
        PanelOpcionesLayout.setHorizontalGroup(
            PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelOpcionesLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel6)
                .addContainerGap(601, Short.MAX_VALUE))
        );
        PanelOpcionesLayout.setVerticalGroup(
            PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelOpcionesLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel6)
                .addContainerGap(449, Short.MAX_VALUE))
        );

        jPanel3.add(PanelOpciones, "card6");

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonCasasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCasasActionPerformed
         mostrarPanel("card4"); 
    }//GEN-LAST:event_BotonCasasActionPerformed

    private void BotonReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonReservasActionPerformed
          mostrarPanel("card2"); 
    }//GEN-LAST:event_BotonReservasActionPerformed

    private void BotonClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonClientesActionPerformed
         mostrarPanel("card3"); 
    }//GEN-LAST:event_BotonClientesActionPerformed

    private void BotonInformesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonInformesActionPerformed
         mostrarPanel("card5"); 
    }//GEN-LAST:event_BotonInformesActionPerformed

    private void BotonOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonOpcionesActionPerformed
         mostrarPanel("card6"); 
    }//GEN-LAST:event_BotonOpcionesActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Bienvenida;
    private javax.swing.JButton BotonCasas;
    private javax.swing.JButton BotonClientes;
    private javax.swing.JButton BotonInformes;
    private javax.swing.JButton BotonOpciones;
    private javax.swing.JButton BotonReservas;
    private javax.swing.JPanel PanelBienvenida;
    private javax.swing.JPanel PanelCasas;
    private javax.swing.JPanel PanelClientes;
    private javax.swing.JPanel PanelInformes;
    private javax.swing.JPanel PanelOpciones;
    private javax.swing.JPanel PanelReservas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel logo2;
    // End of variables declaration//GEN-END:variables
}
