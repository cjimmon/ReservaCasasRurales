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
        PanelNuevaReservas = new javax.swing.JPanel();
        LabelNuevaReserva = new javax.swing.JLabel();
        LabelNombreNR = new javax.swing.JLabel();
        LabelApellidosNR = new javax.swing.JLabel();
        LabelDNINR = new javax.swing.JLabel();
        LabelTelefonoNR = new javax.swing.JLabel();
        LabelEmailNR = new javax.swing.JLabel();
        BoxNombreNuevaReserva = new javax.swing.JTextField();
        BoxApellidosNuevaReserva = new javax.swing.JTextField();
        BoxDniNuevaReserva = new javax.swing.JTextField();
        BoxTelefonoNuevaReserva = new javax.swing.JTextField();
        BoxEmailNuevaReserva = new javax.swing.JTextField();
        BoxCasaNuevaReserva = new javax.swing.JComboBox<>();
        LabelCasaNR = new javax.swing.JLabel();
        LabelFechaInicioNR = new javax.swing.JLabel();
        LabelFechaFinNR = new javax.swing.JLabel();
        CalendarioInicioNuevaReserva = new com.toedter.calendar.JCalendar();
        CalendarioFinNuevaReserva = new com.toedter.calendar.JCalendar();
        labelNpersonasNR = new javax.swing.JLabel();
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
        LabelClientes = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        scrolltablaclientes = new javax.swing.JScrollPane();
        TablaClientes = new javax.swing.JTable();
        PanelCasas = new javax.swing.JPanel();
        LabelCasas = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        BotonNuevaCasa = new javax.swing.JButton();
        BotonEditarCasa = new javax.swing.JButton();
        BotonEliminarCasa = new javax.swing.JButton();
        BotonBuscarCasa = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        ScrollPanelCasas = new javax.swing.JScrollPane();
        TableCasas = new javax.swing.JTable();
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
        TabbedInformes = new javax.swing.JTabbedPane();
        ScrollInformes = new javax.swing.JScrollPane();
        TableInformes = new javax.swing.JTable();
        ScrollFacturas = new javax.swing.JScrollPane();
        TableFacturas = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        TotalIngresos = new javax.swing.JLabel();
        FacturasPendientes = new javax.swing.JLabel();
        PanelOpciones = new javax.swing.JPanel();
        LabelOpciones = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        BotonGuardarOpciones = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TextoNombreOpciones = new javax.swing.JTextField();
        TextoContraseñaOpciones = new javax.swing.JTextField();
        BotonBuscarOpciones = new javax.swing.JButton();
        CheckAdministrador = new javax.swing.JCheckBox();
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
        SeparadorBuscarReseva = new javax.swing.JSeparator();

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

        LabelNuevaReserva.setText("NUEVA RESERVA");

        LabelNombreNR.setText("Nombre:");

        LabelApellidosNR.setText("Apellidos:");

        LabelDNINR.setText("DNI:");

        LabelTelefonoNR.setText("Telefono:");

        LabelEmailNR.setText("Email:");

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

        LabelCasaNR.setText("Casa:");

        LabelFechaInicioNR.setText("Fecha Inicio:");

        LabelFechaFinNR.setText("Fecha Fin:");

        labelNpersonasNR.setText("Nº Personas:");

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
                        .addGap(39, 39, 39)
                        .addGroup(PanelNuevaReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PanelNuevaReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(LabelApellidosNR)
                                .addComponent(LabelNombreNR, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(PanelNuevaReservasLayout.createSequentialGroup()
                                    .addComponent(LabelDNINR)
                                    .addGap(27, 27, 27)))
                            .addGroup(PanelNuevaReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(LabelEmailNR)
                                .addComponent(LabelTelefonoNR)))
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
                                .addComponent(LabelCasaNR)
                                .addGap(18, 18, 18)
                                .addComponent(BoxCasaNuevaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(labelNpersonasNR)
                                .addGap(18, 18, 18)
                                .addComponent(SpinnerNumeropersonaNuevaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelNuevaReservasLayout.createSequentialGroup()
                                .addGroup(PanelNuevaReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelFechaInicioNR)
                                    .addComponent(LabelFechaFinNR))
                                .addGap(28, 28, 28)
                                .addGroup(PanelNuevaReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(CalendarioFinNuevaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CalendarioInicioNuevaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(BotonGuardarNuevaReserva)))
                    .addGroup(PanelNuevaReservasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 839, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelNuevaReservasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LabelNuevaReserva)))
                .addContainerGap(166, Short.MAX_VALUE))
        );
        PanelNuevaReservasLayout.setVerticalGroup(
            PanelNuevaReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNuevaReservasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelNuevaReserva)
                .addGap(29, 29, 29)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(PanelNuevaReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelNombreNR)
                    .addComponent(BoxNombreNuevaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BoxCasaNuevaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelCasaNR)
                    .addComponent(labelNpersonasNR)
                    .addComponent(SpinnerNumeropersonaNuevaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(PanelNuevaReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelNuevaReservasLayout.createSequentialGroup()
                        .addGroup(PanelNuevaReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelApellidosNR)
                            .addComponent(BoxApellidosNuevaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelFechaInicioNR))
                        .addGap(25, 25, 25)
                        .addGroup(PanelNuevaReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelDNINR)
                            .addComponent(BoxDniNuevaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(PanelNuevaReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelTelefonoNR)
                            .addComponent(BoxTelefonoNuevaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PanelNuevaReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelNuevaReservasLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(PanelNuevaReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(LabelEmailNR)
                                    .addComponent(BoxEmailNuevaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PanelNuevaReservasLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(LabelFechaFinNR))))
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

        LabelClientes.setText("CLIENTES");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(BotonAgregarCliente)
                        .addGap(54, 54, 54)
                        .addComponent(BotonEditarCliente)
                        .addGap(44, 44, 44)
                        .addComponent(BotonVerDetalles)
                        .addGap(62, 62, 62)
                        .addComponent(BotonBuscarCliente)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelClientes)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonBuscarCliente)
                    .addComponent(BotonVerDetalles)
                    .addComponent(BotonEditarCliente)
                    .addComponent(BotonAgregarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(scrolltablaclientes, javax.swing.GroupLayout.PREFERRED_SIZE, 985, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGroup(PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelClientesLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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

        LabelCasas.setText("CASAS");

        BotonNuevaCasa.setText("Nueva Casa");
        BotonNuevaCasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonNuevaCasaActionPerformed(evt);
            }
        });

        BotonEditarCasa.setText("Editar Casa");
        BotonEditarCasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEditarCasaActionPerformed(evt);
            }
        });

        BotonEliminarCasa.setText("Eliminar Casa");
        BotonEliminarCasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEliminarCasaActionPerformed(evt);
            }
        });

        BotonBuscarCasa.setText("Buscar Casa");
        BotonBuscarCasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBuscarCasaActionPerformed(evt);
            }
        });

        jSeparator4.setBackground(new java.awt.Color(0, 102, 51));
        jSeparator4.setForeground(new java.awt.Color(0, 102, 51));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(BotonNuevaCasa)
                .addGap(26, 26, 26)
                .addComponent(BotonEditarCasa)
                .addGap(32, 32, 32)
                .addComponent(BotonEliminarCasa)
                .addGap(37, 37, 37)
                .addComponent(BotonBuscarCasa)
                .addContainerGap(506, Short.MAX_VALUE))
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
                    .addComponent(BotonEditarCasa)
                    .addComponent(BotonEliminarCasa)
                    .addComponent(BotonBuscarCasa))
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

        jPanel3.add(PanelCasas, "card4");

        LabelInformes.setText("INFORMES");

        ComboBoxInformes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Reservas", "Facturas", "Clientes" }));
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

        BotonGenerarInforme.setText("Generar Informe");
        BotonGenerarInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGenerarInformeActionPerformed(evt);
            }
        });

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

        TableInformes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id_reserva", "id_cliente", "id_casa", "fecha inicio", "fecha fin", "nº Personas", "Estado reserva"
            }
        ));
        ScrollInformes.setViewportView(TableInformes);

        TabbedInformes.addTab("Reservas", ScrollInformes);

        TableFacturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id_factura", "id_reserva", "Cliente", "Casa", "Fecha", "Total (€)", "Estado"
            }
        ));
        ScrollFacturas.setViewportView(TableFacturas);

        TabbedInformes.addTab("Facturas", ScrollFacturas);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id_cliente", "Nombre", "Apellidos", "DNI", "Telefono", "Email", "Comentarios"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        TabbedInformes.addTab("Clientes", jScrollPane1);

        TotalIngresos.setText("Total Ingresos");

        FacturasPendientes.setText("Facturas Pendientes");

        javax.swing.GroupLayout PanelInformesLayout = new javax.swing.GroupLayout(PanelInformes);
        PanelInformes.setLayout(PanelInformesLayout);
        PanelInformesLayout.setHorizontalGroup(
            PanelInformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInformesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelInformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TabbedInformes, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelInformesLayout.createSequentialGroup()
                        .addGroup(PanelInformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelInformes, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SeparadorInformes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 991, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 8, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(PanelInformesLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(TotalIngresos)
                .addGap(100, 100, 100)
                .addComponent(FacturasPendientes)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(TabbedInformes, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(PanelInformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TotalIngresos)
                    .addComponent(FacturasPendientes))
                .addGap(61, 61, 61))
        );

        jPanel3.add(PanelInformes, "card5");

        LabelOpciones.setText("OPCIONES");

        jSeparator3.setBackground(new java.awt.Color(0, 102, 51));
        jSeparator3.setForeground(new java.awt.Color(0, 102, 51));

        BotonGuardarOpciones.setText("Guardar");
        BotonGuardarOpciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGuardarOpcionesActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre:");

        jLabel3.setText("Contraseña:");

        jLabel4.setText("Rol:");

        TextoNombreOpciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextoNombreOpcionesActionPerformed(evt);
            }
        });

        TextoContraseñaOpciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextoContraseñaOpcionesActionPerformed(evt);
            }
        });

        BotonBuscarOpciones.setText("Buscar");
        BotonBuscarOpciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBuscarOpcionesActionPerformed(evt);
            }
        });

        CheckAdministrador.setText("Administrador");
        CheckAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckAdministradorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelOpcionesLayout = new javax.swing.GroupLayout(PanelOpciones);
        PanelOpciones.setLayout(PanelOpcionesLayout);
        PanelOpcionesLayout.setHorizontalGroup(
            PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelOpcionesLayout.createSequentialGroup()
                .addGroup(PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelOpcionesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelOpciones)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelOpcionesLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PanelOpcionesLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(TextoNombreOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelOpcionesLayout.createSequentialGroup()
                                .addGroup(PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BotonBuscarOpciones)
                                    .addGroup(PanelOpcionesLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(26, 26, 26)
                                        .addComponent(CheckAdministrador)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotonGuardarOpciones))
                            .addGroup(PanelOpcionesLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(26, 26, 26)
                                .addComponent(TextoContraseñaOpciones)))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        PanelOpcionesLayout.setVerticalGroup(
            PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelOpciones)
                .addGap(32, 32, 32)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TextoNombreOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TextoContraseñaOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(CheckAdministrador))
                .addGap(42, 42, 42)
                .addGroup(PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonBuscarOpciones)
                    .addComponent(BotonGuardarOpciones))
                .addContainerGap(280, Short.MAX_VALUE))
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

        SeparadorBuscarReseva.setBackground(new java.awt.Color(0, 102, 51));
        SeparadorBuscarReseva.setForeground(new java.awt.Color(0, 102, 51));

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
                                .addComponent(campoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                        .addGroup(PanelBuscarReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonEjecutarBusqueda)
                            .addGroup(PanelBuscarReservaLayout.createSequentialGroup()
                                .addComponent(botonGuardarCambios)
                                .addGap(18, 18, 18)
                                .addComponent(botoneliminarReservas)))
                        .addGap(143, 143, 143))
                    .addGroup(PanelBuscarReservaLayout.createSequentialGroup()
                        .addGroup(PanelBuscarReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(scrollTablaReservas, javax.swing.GroupLayout.DEFAULT_SIZE, 972, Short.MAX_VALUE)
                            .addComponent(SeparadorBuscarReseva))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(PanelBuscarReservaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelBuscarReservaLayout.setVerticalGroup(
            PanelBuscarReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBuscarReservaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(28, 28, 28)
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
                .addComponent(SeparadorBuscarReseva, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void BotonNuevaCasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonNuevaCasaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonNuevaCasaActionPerformed

    private void BotonEditarCasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEditarCasaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonEditarCasaActionPerformed

    private void BotonEliminarCasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEliminarCasaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonEliminarCasaActionPerformed

    private void BotonBuscarCasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBuscarCasaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonBuscarCasaActionPerformed

    private void FechaInicioInformesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FechaInicioInformesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FechaInicioInformesActionPerformed

    private void FechaFinalInformesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FechaFinalInformesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FechaFinalInformesActionPerformed

    private void BotonGenerarInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGenerarInformeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonGenerarInformeActionPerformed

    private void BotonPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonPDFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonPDFActionPerformed

    private void ComboBoxInformesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxInformesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxInformesActionPerformed

    private void TextoNombreOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextoNombreOpcionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextoNombreOpcionesActionPerformed

    private void TextoContraseñaOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextoContraseñaOpcionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextoContraseñaOpcionesActionPerformed

    private void CheckAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckAdministradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckAdministradorActionPerformed

    private void BotonBuscarOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBuscarOpcionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonBuscarOpcionesActionPerformed

    private void BotonGuardarOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGuardarOpcionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonGuardarOpcionesActionPerformed


    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Bienvenida;
    private javax.swing.JButton BotonAgregarCliente;
    private javax.swing.JButton BotonBuscarCasa;
    private javax.swing.JButton BotonBuscarCliente;
    private javax.swing.JButton BotonBuscarOpciones;
    private javax.swing.JButton BotonCasas;
    private javax.swing.JButton BotonClientes;
    private javax.swing.JButton BotonEditarCasa;
    private javax.swing.JButton BotonEditarCliente;
    private javax.swing.JButton BotonEliminarCasa;
    private javax.swing.JButton BotonGenerarInforme;
    private javax.swing.JButton BotonGuardarNuevaReserva;
    private javax.swing.JButton BotonGuardarOpciones;
    private javax.swing.JButton BotonInformes;
    private javax.swing.JButton BotonNuevaCasa;
    private javax.swing.JButton BotonNuevaReserva;
    private javax.swing.JButton BotonOpciones;
    private javax.swing.JButton BotonPDF;
    private javax.swing.JButton BotonVerDetalles;
    private javax.swing.JTextField BoxApellidosNuevaReserva;
    private javax.swing.JComboBox<String> BoxCasaNuevaReserva;
    private javax.swing.JTextField BoxDniNuevaReserva;
    private javax.swing.JTextField BoxEmailNuevaReserva;
    private javax.swing.JTextField BoxNombreNuevaReserva;
    private javax.swing.JTextField BoxTelefonoNuevaReserva;
    private com.toedter.calendar.JCalendar CalendarioFinNuevaReserva;
    private com.toedter.calendar.JCalendar CalendarioInicioNuevaReserva;
    private javax.swing.JCheckBox CheckAdministrador;
    private javax.swing.JComboBox<String> ComboBoxInformes;
    private javax.swing.JLabel FacturasPendientes;
    private javax.swing.JTextField FechaFinalInformes;
    private javax.swing.JTextField FechaInicioInformes;
    private javax.swing.JLabel LabelApellidosNR;
    private javax.swing.JLabel LabelCasaNR;
    private javax.swing.JLabel LabelCasas;
    private javax.swing.JLabel LabelClientes;
    private javax.swing.JLabel LabelDNINR;
    private javax.swing.JLabel LabelEmailNR;
    private javax.swing.JLabel LabelFechaFinInformes;
    private javax.swing.JLabel LabelFechaFinNR;
    private javax.swing.JLabel LabelFechaInicioInformes;
    private javax.swing.JLabel LabelFechaInicioNR;
    private javax.swing.JLabel LabelInformes;
    private javax.swing.JLabel LabelNombreNR;
    private javax.swing.JLabel LabelNuevaReserva;
    private javax.swing.JLabel LabelOpciones;
    private javax.swing.JLabel LabelTelefonoNR;
    private javax.swing.JPanel PanelBienvenida;
    private javax.swing.JPanel PanelBuscarReserva;
    private javax.swing.JPanel PanelCasas;
    private javax.swing.JPanel PanelClientes;
    private javax.swing.JPanel PanelInformes;
    private javax.swing.JPanel PanelNuevaReservas;
    private javax.swing.JPanel PanelOpciones;
    private javax.swing.JScrollPane ScrollFacturas;
    private javax.swing.JScrollPane ScrollInformes;
    private javax.swing.JScrollPane ScrollPanelCasas;
    private javax.swing.JSeparator SeparadorBuscarReseva;
    private javax.swing.JSeparator SeparadorInformes;
    private javax.swing.JSpinner SpinnerNumeropersonaNuevaReserva;
    private javax.swing.JTabbedPane TabbedInformes;
    private javax.swing.JTable TablaClientes;
    private javax.swing.JTable TableCasas;
    private javax.swing.JTable TableFacturas;
    private javax.swing.JTable TableInformes;
    private javax.swing.JTextField TextoContraseñaOpciones;
    private javax.swing.JTextField TextoNombreOpciones;
    private javax.swing.JLabel TotalIngresos;
    private javax.swing.JButton botonBuscarReserva;
    private javax.swing.JButton botonEjecutarBusqueda;
    private javax.swing.JButton botonGuardarCambios;
    private javax.swing.JButton botoneliminarReservas;
    private javax.swing.JComboBox<String> boxBuscarReserva;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField campoBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelNpersonasNR;
    private javax.swing.JLabel logo2;
    private javax.swing.JScrollPane scrollTablaReservas;
    private javax.swing.JScrollPane scrolltablaclientes;
    private javax.swing.JTable tablaReservas;
    // End of variables declaration//GEN-END:variables

}