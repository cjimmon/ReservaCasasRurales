package reservaruralapp;

import javax.swing.*;
import java.awt.*;

public class PantallaInicio extends JWindow {

    private final JProgressBar progressBar = new JProgressBar(0, 100);
    private final JLabel lblLogo = new JLabel();
    private final int WIDTH = 1175;
    private final int HEIGHT = 800;

    public PantallaInicio() {
        initUI();
    }

    private void initUI() {
        
        JPanel content = new JPanel(new BorderLayout());
        content.setBackground(Color.WHITE);

        
        java.net.URL imgUrl = getClass().getResource("/resources/logo.png");
        if (imgUrl != null) {
            ImageIcon icon = new ImageIcon(imgUrl);
            lblLogo.setIcon(icon);
            lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
        } else {
            lblLogo.setText("Reservas Rurales");
            lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
            lblLogo.setFont(new Font("SansSerif", Font.BOLD, 24));
        }

        
        progressBar.setStringPainted(true);
        progressBar.setPreferredSize(new Dimension(WIDTH, 24));
        progressBar.setValue(0);

       
        JLabel lblStatus = new JLabel("Iniciando...");
        lblStatus.setBorder(BorderFactory.createEmptyBorder(6, 10, 6, 10));

        
        content.add(lblLogo, BorderLayout.CENTER);
        JPanel south = new JPanel(new BorderLayout());
        south.add(progressBar, BorderLayout.CENTER);
        south.add(lblStatus, BorderLayout.SOUTH);
        content.add(south, BorderLayout.SOUTH);

        setContentPane(content);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
    }

    
    public void showSplashAndInit() {
        setVisible(true);

        SwingWorker<Void, Integer> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
               
                for (int i = 0; i <= 100; i++) {
                    Thread.sleep(25);            
                    publish(i);                 
                    if (i == 10) {
                   
                        try {
                            util.DBConnection.getConnection();
                        } catch (Exception ex) {
                            
                        }
                    }
                }
                return null;
            }

            @Override
            protected void process(java.util.List<Integer> chunks) {
                int latest = chunks.get(chunks.size() - 1);
                progressBar.setValue(latest);
                progressBar.setString("Cargando " + latest + "%");
            }

            @Override
            protected void done() {
             
                SwingUtilities.invokeLater(() -> {
                    dispose();
                    new Login().setVisible(true);
                });
            }
        };

        worker.execute();
    }
}
