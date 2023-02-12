package Daniela.ComexApp.Frames;

import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import service.NotasImpl;
import service.PreguntasSeguridadImpl;
import service.UsuariosImpl;

/**
 *
 * @author Daniela
 */
public class PreguntasDeSeguridad extends javax.swing.JFrame {
 
    public String usuario = "", nombreCompleto = "", rol = "", nombre = "";
    /**
     * Creates new form Despachantes
     */
    public PreguntasDeSeguridad() {
        initComponents();
        
        setSize(500, 510);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        
        PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
        TengoUsuario tengoUsuario = new TengoUsuario();
        
        usuario = paginaPrincipal.usuario;
        nombreCompleto = usuariosService.obtenerNombreCompleto(usuario);
        nombre = usuariosService.obtenerNombre(usuario);
        rol = paginaPrincipal.rol;

        setTitle("Preguntas de seguridad - " + usuario + " - sistema ComexApp");
        
        String preguntaUno = preguntasSeguridadService.recuperarPreguntaUno(usuario, nombre);
        String preguntaDos = preguntasSeguridadService.recuperarPreguntaDos(usuario, nombre);
        String preguntaTres = preguntasSeguridadService.recuperarPreguntaTres(usuario, nombre);
        
        int eleccionUno = tengoUsuario.numeroDePreguntaUnoADevolver(preguntaUno);
        int eleccionDos = tengoUsuario.numeroDePreguntaDosADevolver(preguntaDos);
        int eleccionTres = tengoUsuario.numeroDePreguntaTresADevolver(preguntaTres);
        
        cmbPreguntaUno.setSelectedIndex(eleccionUno);
        cmbPreguntaDos.setSelectedIndex(eleccionDos);
        cmbPreguntaTres.setSelectedIndex(eleccionTres);
    }
    
    // icono
    public Image getLogo(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/loguito1.png"));
        return retValue;   
    }
    
    UsuariosImpl usuariosService = new UsuariosImpl();
    PreguntasSeguridadImpl preguntasSeguridadService = new PreguntasSeguridadImpl();
    
    public void LimpiarCampos(){
        textPreguntaUno.setText("");
        textPreguntaDos.setText("");
        textPreguntaTres.setText("");
        cmbPreguntaUno.setSelectedItem(0);
        cmbPreguntaDos.setSelectedItem(0);
        cmbPreguntaTres.setSelectedItem(0);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelPreg1 = new javax.swing.JLabel();
        cmbPreguntaUno = new javax.swing.JComboBox<>();
        textPreguntaUno = new javax.swing.JTextField();
        jLabelPreg2 = new javax.swing.JLabel();
        jButtonConfirmar1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        cmbPreguntaDos = new javax.swing.JComboBox<>();
        textPreguntaDos = new javax.swing.JTextField();
        jLabelPreg3 = new javax.swing.JLabel();
        cmbPreguntaTres = new javax.swing.JComboBox<>();
        textPreguntaTres = new javax.swing.JTextField();
        jButtonConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getLogo());
        setIconImages(getIconImages());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(0, 0, 153));
        jLabelTitulo.setText("Preguntas de seguridad");
        jPanel1.add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 330, 50));

        jLabelPreg1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabelPreg1.setForeground(new java.awt.Color(0, 0, 153));
        jLabelPreg1.setText("Pregunta de seguridad N°1:");
        jPanel1.add(jLabelPreg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 200, 40));

        cmbPreguntaUno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbPreguntaUno.setForeground(new java.awt.Color(0, 0, 153));
        cmbPreguntaUno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "¿Cúal es el nombre de tu primera mascota?", "¿En que ciudad naciste?", "¿Nombre de tus abuelos?", "¿En que año terminaste el secundario?", "¿Cúal es el nombre de tu primer amor?", "¿En que empresa tuviste tu primer empleo?", "¿Cúal fue tu primer show en vivo?" }));
        jPanel1.add(cmbPreguntaUno, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 95, 380, 30));

        textPreguntaUno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textPreguntaUno.setForeground(new java.awt.Color(0, 0, 153));
        jPanel1.add(textPreguntaUno, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 250, 30));

        jLabelPreg2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabelPreg2.setForeground(new java.awt.Color(0, 0, 153));
        jLabelPreg2.setText("Pregunta de seguridad N°2:");
        jPanel1.add(jLabelPreg2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 200, 30));

        jButtonConfirmar1.setBackground(new java.awt.Color(0, 0, 153));
        jButtonConfirmar1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButtonConfirmar1.setForeground(new java.awt.Color(255, 255, 255));
        jButtonConfirmar1.setText("Volver");
        jButtonConfirmar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmar1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonConfirmar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 80, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 230));

        jPanel2.setBackground(new java.awt.Color(0, 0, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbPreguntaDos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbPreguntaDos.setForeground(new java.awt.Color(0, 0, 153));
        cmbPreguntaDos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "¿Cúal es el nombre de tu mascota?", "¿En que ciudad vives?", "¿Nombre de tu videojuego favorito?", "¿Nombre de tu serie favorita?", "¿Cúal es tu hobbie favorito?", "¿Cúal es el nombre de tu banda/artista favorito?", "¿Qué deporte practicas?", " " }));
        jPanel2.add(cmbPreguntaDos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, -10, 380, 30));

        textPreguntaDos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textPreguntaDos.setForeground(new java.awt.Color(0, 0, 153));
        jPanel2.add(textPreguntaDos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 250, 30));

        jLabelPreg3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabelPreg3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPreg3.setText("Pregunta de seguridad N°3:");
        jPanel2.add(jLabelPreg3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 200, 30));

        cmbPreguntaTres.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbPreguntaTres.setForeground(new java.awt.Color(0, 0, 153));
        cmbPreguntaTres.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "¿Qué mascota te gustaría tener?", "¿En que ciudad te gustaría vivir?", "¿Cúal es tu sueño principal?", "¿Qué otra carrera o estudios estudiarías?", "¿Cúal es el nombre de tu pareja?", "¿Que banda/artista te gustaría ver en vivo?" }));
        jPanel2.add(cmbPreguntaTres, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 380, 30));

        textPreguntaTres.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textPreguntaTres.setForeground(new java.awt.Color(0, 0, 153));
        jPanel2.add(textPreguntaTres, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 250, 30));

        jButtonConfirmar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButtonConfirmar.setForeground(new java.awt.Color(0, 0, 153));
        jButtonConfirmar.setText("Confirmar ");
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 170, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 520, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        
        String preguntaUno, preguntaDos, preguntaTres, eleccionUno = null, 
                 eleccionDos = null, eleccionTres = null;
         
        int eleccionUnoNivel = 0, eleccionDosNivel = 0, eleccionTresNivel = 0, ID;
        
        Boolean recepcion;
        
        ID = usuariosService.obtenerIDUsuario(usuario);
        preguntaUno = textPreguntaUno.getText().trim();
        preguntaDos = textPreguntaDos.getText().trim();
        preguntaTres = textPreguntaTres.getText().trim();
        
        eleccionUnoNivel = cmbPreguntaUno.getSelectedIndex() + 1;
        eleccionDosNivel = cmbPreguntaDos.getSelectedIndex() + 1;
        eleccionTresNivel = cmbPreguntaTres.getSelectedIndex() + 1;
        
        if(eleccionUnoNivel == 1){
           eleccionUno = "¿Cúal es el nombre de tu primera mascota?";
        } else if (eleccionUnoNivel == 2){
           eleccionUno = "¿En que ciudad naciste?";
        } else if (eleccionUnoNivel == 3){
           eleccionUno = "¿Nombre de tus abuelos?";
        } else if (eleccionUnoNivel == 4){
           eleccionUno = "¿En que año terminaste el secundario?";
        } else if (eleccionUnoNivel == 5){
           eleccionUno = "¿Cúal es el nombre de tu primer amor?";
        } else if (eleccionUnoNivel == 6){
           eleccionUno = "¿En que empresa tuviste tu primer empleo?";
        } else if (eleccionUnoNivel == 7){
           eleccionUno = "¿Cúal fue tu primer show en vivo?";
        }
           

        if(eleccionDosNivel == 1){
           eleccionDos = "¿Cúal es el nombre de tu mascota?";
        } else if (eleccionDosNivel == 2){
           eleccionDos = "¿En que ciudad vives?";
        } else if (eleccionDosNivel == 3){
           eleccionDos= "¿Nombre de tu videojuego favorito?";
        } else if (eleccionDosNivel == 4){
           eleccionDos = "¿Nombre de tu serie favorita?";
        } else if (eleccionDosNivel == 5){
           eleccionDos = "¿Cúal es tu hobbie favorito?";
        } else if (eleccionDosNivel == 6){
           eleccionDos = "¿Cúal es el nombre de tu banda/artista favorito?";
        } else if (eleccionDosNivel == 7){
           eleccionDos = "¿Qué deporte practicas?";
        }
        
        if(eleccionTresNivel == 1){
           eleccionTres = "¿Qué mascota te gustaría tener?";
        } else if (eleccionTresNivel == 2){
           eleccionTres = "¿En que ciudad te gustaría vivir?";
        } else if (eleccionTresNivel == 3){
           eleccionTres = "¿Cúal es tu sueño principal?";
        } else if (eleccionTresNivel == 4){
           eleccionTres = "¿Qué otra carrera o estudios estudiarías?";
        } else if (eleccionTresNivel == 5){
           eleccionTres = "¿Cúal es el nombre de tu pareja?";
        } else if (eleccionTresNivel == 6){
           eleccionTres = "¿Que banda/artista te gustaría ver en vivo?";
        }
        
        
        recepcion = preguntasSeguridadService.crearPreguntasDeSeguridad(ID, usuario, 
                nombre, preguntaUno, preguntaDos, preguntaTres, eleccionUno, 
                eleccionDos, eleccionTres);
        
        if(recepcion.equals(true)){
           LimpiarCampos();
        }

        
    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    private void jButtonConfirmar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmar1ActionPerformed
        
        PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
        paginaPrincipal.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButtonConfirmar1ActionPerformed

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
            java.util.logging.Logger.getLogger(PreguntasDeSeguridad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PreguntasDeSeguridad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PreguntasDeSeguridad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PreguntasDeSeguridad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PreguntasDeSeguridad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbPreguntaDos;
    private javax.swing.JComboBox<String> cmbPreguntaTres;
    private javax.swing.JComboBox<String> cmbPreguntaUno;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JButton jButtonConfirmar1;
    private javax.swing.JLabel jLabelPreg1;
    private javax.swing.JLabel jLabelPreg2;
    private javax.swing.JLabel jLabelPreg3;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField textPreguntaDos;
    private javax.swing.JTextField textPreguntaTres;
    private javax.swing.JTextField textPreguntaUno;
    // End of variables declaration//GEN-END:variables
}
