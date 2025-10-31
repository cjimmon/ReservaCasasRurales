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
        PanelNuevaReservas = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        BoxNombreNuevaReserva = new javax.swing.JTextField();
        BoxApellidosNuevaReserva = new javax.swing.JTextField();
        BoxDniNuevaReserva = new javax.swing.JTextField();
        BoxTelefonoNuevaReserva = new javax.swing.JTextField();
        BoxEmailNuevaReserva = new javax.swing.JTextField();
        BoxCasaNuevaReserva = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        CalendarioInicioNuevaReserva = new com.toedter.calendar.JCalendar();
        CalendarioFinNuevaReserva = new com.toedter.calendar.JCalendar();
        jLabel16 = new javax.swing.JLabel();
        SpinnerNumeropersonaNuevaReserva = new javax.swing.JSpinner();
        BotonGuardarNuevaReserva = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        PanelClientes = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        BotonAgregarCliente = new javax.swing.JButton();
        BotonEditarCliente = new javax.swing.JButton();
        BotonVerDetalles = new javax.swing.JButton();
        BotonBuscarCliente = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        scrolltablaclientes = new javax.swing.JScrollPane();
        TablaClientes = new javax.swing.JTable();
        PanelCasas = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        PanelInformes = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        PanelOpciones = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        PanelBuscarReserva = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        boxBuscarReserva = new javax.swing.JComboBox<>();
        campoBusqueda = new javax.swing.JTextField();
        botonEjecutarBusqueda = new javax.swing.JButton();
        scrollTablaReservas = new javax.swing.JScrollPane();
        tablaReservas = new javax.swing.JTable();
        botonGuardarCambios = new javax.swing.JButton();
        botoneliminarReservas = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();

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
                .addGap(0, 431, Short.MAX_VALUE)
                .addComponent(Bienvenida)
                .addGap(0, 431, Short.MAX_VALUE))
        );
        PanelBienvenidaLayout.setVerticalGroup(
            PanelBienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBienvenidaLayout.createSequentialGroup()
                .addGap(0, 275, Short.MAX_VALUE)
                .addComponent(Bienvenida)
                .addGap(0, 275, Short.MAX_VALUE))
        );

        jPanel3.add(PanelBienvenida, "card7");

        jLabel1.setText("NUEVA RESERVA");

        jLabel8.setText("Nombre:");

        jLabel9.setText("Apellidos:");

        jLabel10.setText("DNI:");

        jLabel11.setText("Telefono:");

        jLabel12.setText("Email:");

        BoxNombreNuevaReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxNombreNuevaReservaActionPerformed(evt);
            }
        });

        BoxApellidosNuevaReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxApellidosNuevaReservaActionPerformed(evt);
            }
        });

        BoxDniNuevaReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxDniNuevaReservaActionPerformed(evt);
            }
        });

        BoxTelefonoNuevaReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxTelefonoNuevaReservaActionPerformed(evt);
            }
        });

        BoxEmailNuevaReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxEmailNuevaReservaActionPerformed(evt);
            }
        });

        BoxCasaNuevaReserva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Casa 1", "Casa 2" }));
        BoxCasaNuevaReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxCasaNuevaReservaActionPerformed(evt);
            }
        });

        jLabel13.setText("Casa:");

        jLabel14.setText("Fecha Inicio:");

        jLabel15.setText("Fecha Fin:");

        jLabel16.setText("Nº Personas:");

        BotonGuardarNuevaReserva.setText("Guardar Reserva");
        BotonGuardarNuevaReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGuardarNuevaReservaActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(0, 153, 51));
        jSeparator1.setForeground(new java.awt.Color(0, 102, 51));

        javax.swing.GroupLayout PanelNuevaReservasLayout = new javax.swing.GroupLayout(PanelNuevaReservas);
        PanelNuevaReservas.setLayout(PanelNuevaReservasLayout);
        PanelNuevaReservasLayout.setHorizontalGroup(
            PanelNuevaReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNuevaReservasLayout.createSequentialGroup()
                .addGroup(PanelNuevaReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelNuevaReservasLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1))
                    .addGroup(PanelNuevaReservasLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(PanelNuevaReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PanelNuevaReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel9)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(PanelNuevaReservasLayout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addGap(27, 27, 27)))
                            .addGroup(PanelNuevaReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12)
                                .addComponent(jLabel11)))
                        .addGap(18, 18, 18)
                        .addGroup(PanelNuevaReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(BoxTelefonoNuevaReserva, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                            .addComponent(BoxDniNuevaReserva, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BoxApellidosNuevaReserva, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BoxNombreNuevaReserva, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BoxEmailNuevaReserva))
                        .addGap(80, 80, 80)
                        .addGroup(PanelNuevaReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelNuevaReservasLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(BoxCasaNuevaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(SpinnerNumeropersonaNuevaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelNuevaReservasLayout.createSequentialGroup()
                                .addGroup(PanelNuevaReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15))
                                .addGap(28, 28, 28)
                                .addGroup(PanelNuevaReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(CalendarioFinNuevaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CalendarioInicioNuevaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(BotonGuardarNuevaReserva)))
                    .addGroup(PanelNuevaReservasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 839, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        PanelNuevaReservasLayout.setVerticalGroup(
            PanelNuevaReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNuevaReservasLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(PanelNuevaReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(BoxNombreNuevaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BoxCasaNuevaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel16)
                    .addComponent(SpinnerNumeropersonaNuevaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(PanelNuevaReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelNuevaReservasLayout.createSequentialGroup()
                        .addGroup(PanelNuevaReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(BoxApellidosNuevaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(25, 25, 25)
                        .addGroup(PanelNuevaReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(BoxDniNuevaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(PanelNuevaReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(BoxTelefonoNuevaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PanelNuevaReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelNuevaReservasLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(PanelNuevaReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(BoxEmailNuevaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PanelNuevaReservasLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel15))))
                    .addGroup(PanelNuevaReservasLayout.createSequentialGroup()
                        .addComponent(CalendarioInicioNuevaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CalendarioFinNuevaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(BotonGuardarNuevaReserva)
                .addGap(57, 57, 57))
        );

        jPanel3.add(PanelNuevaReservas, "card2");

        BotonAgregarCliente.setText("Agregar Cliente");
        BotonAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAgregarClienteActionPerformed(evt);
            }
        });

        BotonEditarCliente.setText("Editar");
        BotonEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEditarClienteActionPerformed(evt);
            }
        });

        BotonVerDetalles.setText("Ver Detalles");
        BotonVerDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonVerDetallesActionPerformed(evt);
            }
        });

        BotonBuscarCliente.setText("Buscar");
        BotonBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBuscarClienteActionPerformed(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(0, 102, 51));
        jSeparator2.setForeground(new java.awt.Color(0, 102, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(BotonAgregarCliente)
                .addGap(45, 45, 45)
                .addComponent(BotonEditarCliente)
                .addGap(52, 52, 52)
                .addComponent(BotonVerDetalles)
                .addGap(54, 54, 54)
                .addComponent(BotonBuscarCliente)
                .addContainerGap(334, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jSeparator2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonAgregarCliente)
                    .addComponent(BotonEditarCliente)
                    .addComponent(BotonVerDetalles)
                    .addComponent(BotonBuscarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        TablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellidos", "DNI", "Telefono", "Email", "Comentarios "
            }
        ));
        scrolltablaclientes.setViewportView(TablaClientes);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrolltablaclientes)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrolltablaclientes, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelClientesLayout = new javax.swing.GroupLayout(PanelClientes);
        PanelClientes.setLayout(PanelClientesLayout);
        PanelClientesLayout.setHorizontalGroup(
            PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        PanelClientesLayout.setVerticalGroup(
            PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
                .addContainerGap(761, Short.MAX_VALUE))
        );
        PanelCasasLayout.setVerticalGroup(
            PanelCasasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCasasLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel4)
                .addContainerGap(494, Short.MAX_VALUE))
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
                .addContainerGap(745, Short.MAX_VALUE))
        );
        PanelInformesLayout.setVerticalGroup(
            PanelInformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInformesLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel5)
                .addContainerGap(502, Short.MAX_VALUE))
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
                .addContainerGap(742, Short.MAX_VALUE))
        );
        PanelOpcionesLayout.setVerticalGroup(
            PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelOpcionesLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel6)
                .addContainerGap(495, Short.MAX_VALUE))
        );

        jPanel3.add(PanelOpciones, "card6");

        jLabel2.setText("BUSCAR RESERVA");

        jLabel7.setText("Buscar por: ");

        boxBuscarReserva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id_Reserva 1", "Nombre Cliente", "DNI", "Casa", "Telefono" }));
        boxBuscarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxBuscarReservaActionPerformed(evt);
            }
        });

        campoBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoBusquedaActionPerformed(evt);
            }
        });

        botonEjecutarBusqueda.setText("Buscar");
        botonEjecutarBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEjecutarBusquedaActionPerformed(evt);
            }
        });

        tablaReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id_Reserva ", "Nombre", "Apellidos", "DNI", "Telefono", "Email", "Casa", "Fecha", "Estado"
            }
        ));
        scrollTablaReservas.setViewportView(tablaReservas);

        botonGuardarCambios.setText("Guardar Cambios");
        botonGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarCambiosActionPerformed(evt);
            }
        });

        botoneliminarReservas.setText("Eliminar Reserva");
        botoneliminarReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoneliminarReservasActionPerformed(evt);
            }
        });

        jSeparator3.setBackground(new java.awt.Color(0, 102, 51));
        jSeparator3.setForeground(new java.awt.Color(0, 102, 51));

        javax.swing.GroupLayout PanelBuscarReservaLayout = new javax.swing.GroupLayout(PanelBuscarReserva);
        PanelBuscarReserva.setLayout(PanelBuscarReservaLayout);
        PanelBuscarReservaLayout.setHorizontalGroup(
            PanelBuscarReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBuscarReservaLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(PanelBuscarReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelBuscarReservaLayout.createSequentialGroup()
                        .addGroup(PanelBuscarReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelBuscarReservaLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(boxBuscarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelBuscarReservaLayout.createSequentialGroup()
                                .addGap(228, 228, 228)
                                .addGroup(PanelBuscarReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(campoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(PanelBuscarReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonEjecutarBusqueda)
                            .addGroup(PanelBuscarReservaLayout.createSequentialGroup()
                                .addComponent(botonGuardarCambios)
                                .addGap(18, 18, 18)
                                .addComponent(botoneliminarReservas)))
                        .addGap(143, 143, 143))
                    .addGroup(PanelBuscarReservaLayout.createSequentialGroup()
                        .addGroup(PanelBuscarReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollTablaReservas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 818, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        PanelBuscarReservaLayout.setVerticalGroup(
            PanelBuscarReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBuscarReservaLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addGap(20, 20, 20)
                .addGroup(PanelBuscarReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(boxBuscarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonEjecutarBusqueda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelBuscarReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGuardarCambios)
                    .addComponent(botoneliminarReservas))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scrollTablaReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel3.add(PanelBuscarReserva, "card8");

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonCasasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCasasActionPerformed
         mostrarPanel("card4"); 
    }//GEN-LAST:event_BotonCasasActionPerformed

    private void BotonNuevaReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonNuevaReservaActionPerformed
          mostrarPanel("card2"); 
    }//GEN-LAST:event_BotonNuevaReservaActionPerformed

    private void BotonClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonClientesActionPerformed
         mostrarPanel("card3"); 
    }//GEN-LAST:event_BotonClientesActionPerformed

    private void BotonInformesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonInformesActionPerformed
         mostrarPanel("card5"); 
    }//GEN-LAST:event_BotonInformesActionPerformed

    private void BotonOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonOpcionesActionPerformed
         mostrarPanel("card6"); 
    }//GEN-LAST:event_BotonOpcionesActionPerformed

    private void botonBuscarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarReservaActionPerformed
         mostrarPanel("card8");
    }//GEN-LAST:event_botonBuscarReservaActionPerformed

    private void boxBuscarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxBuscarReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxBuscarReservaActionPerformed

    private void campoBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoBusquedaActionPerformed

    private void botonEjecutarBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEjecutarBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonEjecutarBusquedaActionPerformed

    private void botoneliminarReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoneliminarReservasActionPerformed
          int filaSeleccionada = scrollTablaReservas.getSelectedRow();
    if (filaSeleccionada != -1) {
        DefaultTableModel model = (DefaultTableModel) scrollTablaReservas.getModel();
        int idReserva = Integer.parseInt(model.getValueAt(filaSeleccionada, 0).toString());
        model.removeRow(filaSeleccionada);
        System.out.println("Reserva eliminada -> ID: " + idReserva);
        // Más adelante haremos DELETE FROM reservas WHERE id_reserva = idReserva;
    } else {
        JOptionPane.showMessageDialog(null, "Seleccione una reserva para eliminar.", "Aviso", JOptionPane.WARNING_MESSAGE);
    }

    }//GEN-LAST:event_botoneliminarReservasActionPerformed

    private void botonGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarCambiosActionPerformed
         DefaultTableModel model = (DefaultTableModel) scrollTablaReservas.getModel();
    for (int i = 0; i < model.getRowCount(); i++) {
        int idReserva = Integer.parseInt(model.getValueAt(i, 0).toString());
        String idCliente = model.getValueAt(i, 1).toString();
        String idCasa = model.getValueAt(i, 2).toString();
        String fechaInicio = model.getValueAt(i, 3).toString();
        String fechaFin = model.getValueAt(i, 4).toString();
        
        System.out.println("Reserva modificada -> " + idReserva + " " + idCliente + " " + idCasa + " " + fechaInicio + " " + fechaFin);
    }

    }//GEN-LAST:event_botonGuardarCambiosActionPerformed

    private void BoxDniNuevaReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxDniNuevaReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BoxDniNuevaReservaActionPerformed

    private void BoxApellidosNuevaReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxApellidosNuevaReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BoxApellidosNuevaReservaActionPerformed

    private void BoxNombreNuevaReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxNombreNuevaReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BoxNombreNuevaReservaActionPerformed

    private void BoxTelefonoNuevaReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxTelefonoNuevaReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BoxTelefonoNuevaReservaActionPerformed

    private void BoxEmailNuevaReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxEmailNuevaReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BoxEmailNuevaReservaActionPerformed

    private void BoxCasaNuevaReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxCasaNuevaReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BoxCasaNuevaReservaActionPerformed

    private void BotonGuardarNuevaReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGuardarNuevaReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonGuardarNuevaReservaActionPerformed

    private void BotonAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAgregarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonAgregarClienteActionPerformed

    private void BotonEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEditarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonEditarClienteActionPerformed

    private void BotonVerDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonVerDetallesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonVerDetallesActionPerformed

    private void BotonBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBuscarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonBuscarClienteActionPerformed


    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Bienvenida;
    private javax.swing.JButton BotonAgregarCliente;
    private javax.swing.JButton BotonBuscarCliente;
    private javax.swing.JButton BotonCasas;
    private javax.swing.JButton BotonClientes;
    private javax.swing.JButton BotonEditarCliente;
    private javax.swing.JButton BotonGuardarNuevaReserva;
    private javax.swing.JButton BotonInformes;
    private javax.swing.JButton BotonNuevaReserva;
    private javax.swing.JButton BotonOpciones;
    private javax.swing.JButton BotonVerDetalles;
    private javax.swing.JTextField BoxApellidosNuevaReserva;
    private javax.swing.JComboBox<String> BoxCasaNuevaReserva;
    private javax.swing.JTextField BoxDniNuevaReserva;
    private javax.swing.JTextField BoxEmailNuevaReserva;
    private javax.swing.JTextField BoxNombreNuevaReserva;
    private javax.swing.JTextField BoxTelefonoNuevaReserva;
    private com.toedter.calendar.JCalendar CalendarioFinNuevaReserva;
    private com.toedter.calendar.JCalendar CalendarioInicioNuevaReserva;
    private javax.swing.JPanel PanelBienvenida;
    private javax.swing.JPanel PanelBuscarReserva;
    private javax.swing.JPanel PanelCasas;
    private javax.swing.JPanel PanelClientes;
    private javax.swing.JPanel PanelInformes;
    private javax.swing.JPanel PanelNuevaReservas;
    private javax.swing.JPanel PanelOpciones;
    private javax.swing.JSpinner SpinnerNumeropersonaNuevaReserva;
    private javax.swing.JTable TablaClientes;
    private javax.swing.JButton botonBuscarReserva;
    private javax.swing.JButton botonEjecutarBusqueda;
    private javax.swing.JButton botonGuardarCambios;
    private javax.swing.JButton botoneliminarReservas;
    private javax.swing.JComboBox<String> boxBuscarReserva;
    private javax.swing.JTextField campoBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel logo2;
    private javax.swing.JScrollPane scrollTablaReservas;
    private javax.swing.JScrollPane scrolltablaclientes;
    private javax.swing.JTable tablaReservas;
    // End of variables declaration//GEN-END:variables

}