
package reservaruralapp;

import javax.swing.JFrame;

public class VentanaCalendario extends javax.swing.JFrame {
    
   
      public VentanaCalendario() {
        setTitle("Calendario de Ocupación");
        setSize(1200, 700);
        setLocationRelativeTo(null); // Centrar la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 

        CalendarioOcupacion panel = new CalendarioOcupacion();
        add(panel);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}