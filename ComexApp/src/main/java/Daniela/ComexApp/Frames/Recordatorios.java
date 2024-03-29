package Daniela.ComexApp.Frames;

import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Date;
import java.time.LocalDate;
import service.TiemposImpl;

/**
 *
 * @author Daniela
 */
public class Recordatorios extends javax.swing.JFrame {

     String usuario = "", rol = "", nombreCompleto = "";
    /**
     * Creates new form Recordatorios
     */
    public Recordatorios() {
        initComponents();
        
        setSize(500, 250);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        
        PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
        
        usuario = paginaPrincipal.usuario;
        nombreCompleto = paginaPrincipal.nombreCompleto;
        
        setTitle("Recordatorios - " + usuario + " - sistema ComexApp");
        
    }

    // icono
    public Image getLogo(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/loguito1.png"));
        return retValue;   
    }
    
    TiemposImpl tiemposImpl = new TiemposImpl();
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonCerrar = new javax.swing.JButton();
        textHora = new javax.swing.JTextField();
        textMinutos = new javax.swing.JTextField();
        textSegundos = new javax.swing.JTextField();
        jButtonGuardar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbDia = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textDetalle = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getLogo());
        setIconImages(getIconImages());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonCerrar.setBackground(new java.awt.Color(0, 0, 153));
        jButtonCerrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonCerrar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCerrar.setText("Cerrar");
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 94, 30));

        textHora.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textHora.setForeground(new java.awt.Color(0, 51, 153));
        jPanel1.add(textHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 90, 20));

        textMinutos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textMinutos.setForeground(new java.awt.Color(0, 51, 153));
        jPanel1.add(textMinutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 90, 20));

        textSegundos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textSegundos.setForeground(new java.awt.Color(0, 51, 153));
        jPanel1.add(textSegundos, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 90, 20));

        jButtonGuardar.setBackground(new java.awt.Color(0, 0, 153));
        jButtonGuardar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonGuardar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 130, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setText("Horas:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 153));
        jLabel2.setText("Minutos:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 153));
        jLabel3.setText("Segundos:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, -1, -1));

        cmbDia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmbDia.setForeground(new java.awt.Color(0, 51, 153));
        cmbDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hoy", "Mañana", "En 2 días", "En 3 días", "En 4 días", "En 5 días", "En 6 días", "En una semana" }));
        jPanel1.add(cmbDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 153));
        jLabel4.setText("Día:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, -1, 20));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 153));
        jLabel5.setText("Recordatorio");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        textDetalle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textDetalle.setForeground(new java.awt.Color(0, 51, 153));
        jPanel1.add(textDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 260, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 153));
        jLabel6.setText("Detalle;");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 880));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed

        this.dispose();

    }//GEN-LAST:event_jButtonCerrarActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        
        int horas, minutos, segundos, diaEleccionIn;
        Date eleccion = null;
        String detalle;
        
        detalle = textDetalle.getText().trim();
        
        horas = Integer.parseInt(textHora.getText().trim());
        minutos = Integer.parseInt(textMinutos.getText().trim());
        segundos = Integer.parseInt(textSegundos.getText().trim());
        
        diaEleccionIn = cmbDia.getSelectedIndex() + 1;
        
        if(diaEleccionIn == 1){
            eleccion = Date.valueOf(LocalDate.now());
        } else if(diaEleccionIn == 2){
            eleccion = Date.valueOf(LocalDate.now().plusDays(1));
        } else if(diaEleccionIn == 3){
            eleccion = Date.valueOf(LocalDate.now().plusDays(2));
        } else if(diaEleccionIn == 4){
            eleccion = Date.valueOf(LocalDate.now().plusDays(3));
        } else if(diaEleccionIn == 5){
            eleccion = Date.valueOf(LocalDate.now().plusDays(4));
        } else if(diaEleccionIn == 6){
            eleccion = Date.valueOf(LocalDate.now().plusDays(5));
        } else if(diaEleccionIn == 7){
            eleccion = Date.valueOf(LocalDate.now().plusDays(6));
        } else if(diaEleccionIn == 8){
            eleccion = Date.valueOf(LocalDate.now().plusDays(7));
        }
        
        tiemposImpl.guardarTiempoRecordatorio(horas, minutos, segundos, eleccion, detalle);
        
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Recordatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Recordatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Recordatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Recordatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Recordatorios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbDia;
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField textDetalle;
    private javax.swing.JTextField textHora;
    private javax.swing.JTextField textMinutos;
    private javax.swing.JTextField textSegundos;
    // End of variables declaration//GEN-END:variables
}
