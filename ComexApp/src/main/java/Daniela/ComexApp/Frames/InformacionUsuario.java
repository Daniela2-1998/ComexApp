package Daniela.ComexApp.Frames;

import config.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import service.PreguntasSeguridadImpl;
import service.UsuariosImpl;

/**
 *
 * @author Daniela
 * 
 */
public class InformacionUsuario extends javax.swing.JFrame {

    String usuario = "", nombreCompleto = "", rol = "", contraseña = "", nombre = "";
    /**
     * Creates new form VerUsuario
     */
    public InformacionUsuario() {
        initComponents();
        
        setSize(870, 750);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);

        PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
        usuario = paginaPrincipal.usuario;
        nombreCompleto = paginaPrincipal.nombreCompleto;
        rol = paginaPrincipal.rol;    
        contraseña = paginaPrincipal.contraseña;
        nombre = usuariosService.obtenerNombre(usuario);
        
        setTitle("Informacíón completa de " + usuario + " - Sistema ComexApp");
        jLabelTitulo.setText("Información completa de " + nombreCompleto);
        
        jLabelUsuario1.setText(usuario);
        jLabelUsuario2.setText(rol);
        
        usuariosService.obtenerDatosDelUsuario(usuario, textID, textUsuario,
                textContraseña, textNombre, textApellido, textMail, textNumero, 
                cmbRol, cmbStatus);
    }
      // icono
    public Image getLogo(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/loguito1.png"));
        return retValue;   
    }
    UsuariosImpl usuariosService = new UsuariosImpl();
    PreguntasSeguridadImpl preguntasSeguridadService = new PreguntasSeguridadImpl();
    
    public void LimpiarCampos(){
        textUsuario.setText("");
        textNombre.setText("");
        textContraseña.setText("");
        textApellido.setText("");
        textMail.setText("");
        textNumero.setText("");
        textID.setText("");
        cmbRol.setSelectedItem(0);
        cmbStatus.setSelectedItem(0);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelArriba = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jPanelMenu = new javax.swing.JPanel();
        jButtonVolverAtras = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jLabelUsuario1 = new javax.swing.JLabel();
        jLabelUsuario2 = new javax.swing.JLabel();
        jButtonPreguntas = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabelUsuario = new javax.swing.JLabel();
        textUsuario = new javax.swing.JTextField();
        jLabelNombre = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        jLabelApellido = new javax.swing.JLabel();
        textApellido = new javax.swing.JTextField();
        jLabelMail = new javax.swing.JLabel();
        textMail = new javax.swing.JTextField();
        jLabelTelefono = new javax.swing.JLabel();
        textNumero = new javax.swing.JTextField();
        textID = new javax.swing.JTextField();
        jLabelID = new javax.swing.JLabel();
        jButtonInfo = new javax.swing.JButton();
        jLabelStatus = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        jLabelSubt = new javax.swing.JLabel();
        jLabelRol = new javax.swing.JLabel();
        cmbRol = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabelContraseña = new javax.swing.JLabel();
        textContraseña = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getLogo());
        setIconImages(getIconImages());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelArriba.setBackground(new java.awt.Color(255, 255, 255));
        jPanelArriba.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(0, 0, 153));

        javax.swing.GroupLayout jPanelArribaLayout = new javax.swing.GroupLayout(jPanelArriba);
        jPanelArriba.setLayout(jPanelArribaLayout);
        jPanelArribaLayout.setHorizontalGroup(
            jPanelArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelArribaLayout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(jLabelTitulo)
                .addContainerGap(704, Short.MAX_VALUE))
        );
        jPanelArribaLayout.setVerticalGroup(
            jPanelArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelArribaLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabelTitulo)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelArriba, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 90));

        jPanelMenu.setBackground(new java.awt.Color(255, 255, 255));
        jPanelMenu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonVolverAtras.setBackground(new java.awt.Color(0, 0, 153));
        jButtonVolverAtras.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonVolverAtras.setForeground(new java.awt.Color(255, 255, 255));
        jButtonVolverAtras.setText("Volver atrás");
        jButtonVolverAtras.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 153), new java.awt.Color(0, 0, 153), new java.awt.Color(0, 0, 153), new java.awt.Color(0, 0, 153)));
        jButtonVolverAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverAtrasActionPerformed(evt);
            }
        });
        jPanelMenu.add(jButtonVolverAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 646, 140, 30));

        jButtonModificar.setBackground(new java.awt.Color(0, 0, 153));
        jButtonModificar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonModificar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonModificar.setText("Modificar datos");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });
        jPanelMenu.add(jButtonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 240, -1));

        jLabelUsuario1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelUsuario1.setForeground(new java.awt.Color(0, 0, 153));
        jLabelUsuario1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUsuario1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanelMenu.add(jLabelUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 150, 200, 40));

        jLabelUsuario2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelUsuario2.setForeground(new java.awt.Color(0, 0, 153));
        jLabelUsuario2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUsuario2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanelMenu.add(jLabelUsuario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 200, 40));

        jButtonPreguntas.setBackground(new java.awt.Color(0, 0, 153));
        jButtonPreguntas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonPreguntas.setForeground(new java.awt.Color(255, 255, 255));
        jButtonPreguntas.setText("Preguntas de seguridad ");
        jButtonPreguntas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPreguntasActionPerformed(evt);
            }
        });
        jPanelMenu.add(jButtonPreguntas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 240, 30));

        getContentPane().add(jPanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 750));

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsuario.setText("Usuario:");
        jPanel1.add(jLabelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 63, -1, -1));

        textUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textUsuario.setForeground(new java.awt.Color(0, 0, 153));
        textUsuario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(textUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 89, 163, -1));

        jLabelNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNombre.setText("Nombre:");
        jPanel1.add(jLabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 126, -1, -1));

        textNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textNombre.setForeground(new java.awt.Color(0, 0, 153));
        textNombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(textNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 152, 163, -1));

        jLabelApellido.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelApellido.setForeground(new java.awt.Color(255, 255, 255));
        jLabelApellido.setText("Apellido:");
        jPanel1.add(jLabelApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 126, -1, -1));

        textApellido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textApellido.setForeground(new java.awt.Color(0, 0, 153));
        textApellido.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(textApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 152, 163, -1));

        jLabelMail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelMail.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMail.setText("Mail:");
        jPanel1.add(jLabelMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 200, -1, -1));

        textMail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textMail.setForeground(new java.awt.Color(0, 0, 153));
        textMail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(textMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 225, 163, -1));

        jLabelTelefono.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTelefono.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTelefono.setText("Teléfono:");
        jPanel1.add(jLabelTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, -1, -1));

        textNumero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textNumero.setForeground(new java.awt.Color(0, 0, 153));
        textNumero.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(textNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 225, 163, -1));

        textID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textID.setForeground(new java.awt.Color(0, 0, 153));
        textID.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(textID, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 89, 93, -1));

        jLabelID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelID.setForeground(new java.awt.Color(255, 255, 255));
        jLabelID.setText("ID:");
        jPanel1.add(jLabelID, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 63, -1, -1));

        jButtonInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/signo4.png"))); // NOI18N
        jButtonInfo.setBorder(null);
        jButtonInfo.setBorderPainted(false);
        jButtonInfo.setContentAreaFilled(false);
        jButtonInfo.setFocusPainted(false);
        jButtonInfo.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/signo5.png"))); // NOI18N
        jButtonInfo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/signo5.png"))); // NOI18N
        jButtonInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInfoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, -1, -1));

        jLabelStatus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelStatus.setForeground(new java.awt.Color(255, 255, 255));
        jLabelStatus.setText("Status:");
        jPanel1.add(jLabelStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, -1, -1));

        cmbStatus.setForeground(new java.awt.Color(0, 0, 153));
        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo", "Suspendido" }));
        jPanel1.add(cmbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 120, 40));

        jLabelSubt.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabelSubt.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSubt.setText("Datos completos:");
        jPanel1.add(jLabelSubt, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 18, -1, -1));

        jLabelRol.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelRol.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRol.setText("Rol:");
        jPanel1.add(jLabelRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, -1, -1));

        cmbRol.setForeground(new java.awt.Color(0, 0, 153));
        cmbRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Importador", "Exportador", "Agente", "Logistica", "Marketing" }));
        jPanel1.add(cmbRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 120, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/empleados3.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 430, -1, -1));

        jLabelContraseña.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelContraseña.setForeground(new java.awt.Color(255, 255, 255));
        jLabelContraseña.setText("Contraseña:");
        jPanel1.add(jLabelContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 410, -1, -1));

        textContraseña.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textContraseña.setForeground(new java.awt.Color(0, 0, 153));
        textContraseña.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(textContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 440, 163, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 610, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVolverAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverAtrasActionPerformed

        PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
        paginaPrincipal.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButtonVolverAtrasActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed

        try{        
        
            String usuarioMod, nombreMod, apellidoMod, rolMod = null, 
                mailMod, telefonoMod, statusMod = null;
            int idMod, rolStatusMod = 0, statusNivelMod = 0;
        
            
            idMod= Integer.parseInt(textID.getText().trim());
            usuarioMod = textUsuario.getText().trim();
            nombreMod = textNombre.getText().trim();
            apellidoMod = textApellido.getText().trim();
            mailMod = textMail.getText().trim();
            telefonoMod = textNumero.getText().trim();
            rolStatusMod = cmbRol.getSelectedIndex() + 1;
            statusNivelMod = cmbStatus.getSelectedIndex() + 1;

            if(rolStatusMod == 1){
                rolMod = "Administrador";
            } else if(rolStatusMod == 2){
                rolMod = "Importador";
            } else if(rolStatusMod == 3){
                rolMod = "Exportador";
            } else if(rolStatusMod == 4){
                rolMod = "Agente";
            } else if(rolStatusMod == 5){
                rolMod = "Logistica";
            } else if(rolStatusMod == 6){
                rolMod = "Marketing";
            }

            if(statusNivelMod == 1){
               statusMod = "Activo";
            } else if (statusNivelMod == 2){
               statusMod = "Inactivo";
            } else if (statusNivelMod == 3){
               statusMod = "Suspendido";
            }
     
            usuariosService.modificarTodosLosDatosDeUsuarios(idMod, usuario, 
                    usuarioMod, contraseña, nombreMod, apellidoMod, rolMod, 
                    mailMod, telefonoMod, statusMod);
       
        }catch(Exception e){
            System.err.println("Fallo al modificar datos " + e);
            JOptionPane.showMessageDialog(null, "Fallo al modificar datos");
        }
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInfoActionPerformed

        InformacionID informacionID = new InformacionID();
        informacionID.setVisible(true);

    }//GEN-LAST:event_jButtonInfoActionPerformed

    private void jButtonPreguntasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPreguntasActionPerformed
        
        PreguntasDeSeguridad preguntasSeguridad = new PreguntasDeSeguridad();
        preguntasSeguridad.setVisible(true);
        this.dispose();
        preguntasSeguridadService.recuperarLasPreguntasDeSeguridadYSusRespuestas
        (textUsuario, textApellido, textNombre, cmbStatus, cmbStatus, cmbStatus, usuario, nombre);
      
    }//GEN-LAST:event_jButtonPreguntasActionPerformed

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
            java.util.logging.Logger.getLogger(InformacionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbRol;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JButton jButtonInfo;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonPreguntas;
    private javax.swing.JButton jButtonVolverAtras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelApellido;
    private javax.swing.JLabel jLabelContraseña;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelMail;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelRol;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JLabel jLabelSubt;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JLabel jLabelUsuario1;
    private javax.swing.JLabel jLabelUsuario2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelArriba;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JTextField textApellido;
    private javax.swing.JTextField textContraseña;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textMail;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textNumero;
    private javax.swing.JTextField textUsuario;
    // End of variables declaration//GEN-END:variables


}
