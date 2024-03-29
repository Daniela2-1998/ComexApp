package Daniela.ComexApp.Frames;

import Daniela.ComexApp.Controller.UsuariosController;
import Daniela.ComexApp.Entity.Usuarios;
import Daniela.ComexApp.Repository.UsuariosRepository;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import service.ConfiguracionImpl;
import service.InicioSesionImp;
import service.MailImpl;
import service.MensajesImpl;
import service.UsuariosImpl;

/**
 *
 * @author Daniela
 */
public class RegistroUsuarios extends javax.swing.JFrame {

    /**
     * Creates new form RegistroUsuarios
     */
    public RegistroUsuarios() {
        initComponents();
        
        setSize(750, 750);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        
        setTitle("Registro de usuarios - sistema ComexApp");
    }

    
    Usuarios usuarios = new Usuarios();
    UsuariosRepository usuariosRepository;
    UsuariosImpl usuariosImpl = new UsuariosImpl();
    InicioSesionImp inicioSesionService = new InicioSesionImp();
    MensajesImpl mensajesImpl = new MensajesImpl();
    MailImpl mailImpl = new MailImpl();
    ConfiguracionImpl configImpl = new ConfiguracionImpl();
    
    public void LimpiarCamposRegistroUsuarios(){
        textID.setText("");
        textUsuario.setText("");
        textContraseña.setText("");
        textNombre.setText("");
        textApellido.setText("");
        textMail.setText("");
        textTelefono.setText("");
        cmbRol.setSelectedIndex(0);
        cmbStatus.setSelectedIndex(0);
    }
    
    public void envioDeMailAAdmin(String usuario, String nombre, String apellido){
        String adminPrincipal, mailAdmin, mailApp, mensaje, asunto, contraseña;
        
        adminPrincipal = configImpl.obtenerAdminPrincipal();
        mailAdmin = usuariosImpl.obtenerMailUsuario(adminPrincipal);
        
        contraseña = "fahbuzfhzpsqnyqm";
        mailApp = "comexappj@gmail.com";
        
        asunto = "Nuevo registro de usuario detectado";
        mensaje = adminPrincipal + " hemos detectado un nuevo registro de usuario "
                + "en el sistema ComexApp. \n\n A continuación te dejamos más "
                + "detalles para que puedas saber de quién se trata:  \n\n "
                + "-Usuario: " + usuario + " \n\n -Nombre completo: " + nombre 
                + " " + apellido + "\n\nEntra en el sistema para aceptar su ingreso, "
        + "o bien, entra en la sección de 'Administración de usuarios' para "
                + "eliminar su cuenta. De todas formas, recuerda que " + usuario + 
                " aún no tiene acceso al sistema ya que el usuario se encuentra "
                + "inactivo hasta que le des permiso o decidas eliminarlo del "
                + "sistema ComexApp.\n\n \n\n Atentamente, \n\n  equipo de ComexApp";
        
        mailImpl.envioDeMensajes(mailApp, mailAdmin, asunto, mensaje, contraseña);
    }
    
    public void envioDeMailAUsuario(String usuario, String nombre, String apellido, 
            String contraseña, String rol, String mail){
        String contraseñaM, mailApp, asunto, mensaje;
        contraseñaM = "fahbuzfhzpsqnyqm";
        mailApp = "comexappj@gmail.com";
        
        String info = "ComexApp es un software diseñado para empresas que se "
                + "dediquen a la comercialización internacional y/o nacional. "
                + "Surge con la idea de facilitar y agrupar la mayoría de las "
                + "operaciones que realizan estas empresas, permitiendole realizar "
                + "de forma más práctica y cómoda, tareas como: gestión de stock, "
                + "gestión de pedidos de suministros, gestión de operaciones nacionales "
                + "e internacionales, administración de usuarios, creación de usuarios, "
                + "registro de participantes de la operación (importadores, exportadores, "
                + "despachantes, transporte), control de contenedores, asociar operaciones "
                + "con participantes/contenedores/productos, toma de notas personales, "
                + "creación de una agenda personal, establecimiento y control del "
                + "cumplimiento de objetivos, personalización de la pantalla principal, etc.";
        
        asunto = "Registro éxitoso en el sistema ComexApp";
        mensaje = usuario + " tu registro en el sistema ComexApp fue éxitoso. "
                + "Dependiendo de como esté configurada la aplicación, es probable "
                + "que todavía tengas que esperar que el administrador designado "
                + "confirme tu usuario para que puedas ingresar y utilizarlo para "
                + "realizar tus operaciones normalmente. \n\n A continuación, "
                + "te enviamos los datos de tu cuenta para que puedas ingresar:"
                + "\n\nUsuario: " + usuario + "\n\nContraseña: " + contraseña + 
                "\n\nNombre completo: " + nombre + " " + apellido + "\n\n" + info + 
                "\n\n\n\nMuchas gracias por registrarte\n\n      equipo de ComexApp";
        
        mailImpl.envioDeMensajes(mailApp, mail, asunto, mensaje, contraseña);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jLabelInicio = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        textUsuario = new javax.swing.JTextField();
        jLabelContraseña = new javax.swing.JLabel();
        textContraseña = new javax.swing.JTextField();
        jLabelNombre = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        jLabelApellido = new javax.swing.JLabel();
        textApellido = new javax.swing.JTextField();
        jLabelMail = new javax.swing.JLabel();
        textMail = new javax.swing.JTextField();
        jLabelTelefono = new javax.swing.JLabel();
        textTelefono = new javax.swing.JTextField();
        jLabelRol = new javax.swing.JLabel();
        cmbRol = new javax.swing.JComboBox<>();
        jButtonRegistrar = new javax.swing.JButton();
        jLabelID = new javax.swing.JLabel();
        textID = new javax.swing.JTextField();
        jLabelStatus = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        jButtonInfo = new javax.swing.JButton();
        jButtonVolverAtras = new javax.swing.JButton();
        jLabelWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(0, 0, 153));
        jLabelTitulo.setText("Registro de usuarios");
        getContentPane().add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 540, 103));

        jLabelInicio.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabelInicio.setForeground(new java.awt.Color(0, 0, 153));
        jLabelInicio.setText("Por favor, completa los datos");
        getContentPane().add(jLabelInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 460, 50));

        jLabelUsuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelUsuario.setForeground(new java.awt.Color(0, 0, 153));
        jLabelUsuario.setText("Usuario:");
        getContentPane().add(jLabelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 70, 50));

        textUsuario.setForeground(new java.awt.Color(0, 0, 153));
        getContentPane().add(textUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 210, 40));

        jLabelContraseña.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelContraseña.setForeground(new java.awt.Color(0, 0, 153));
        jLabelContraseña.setText("Contraseña:");
        getContentPane().add(jLabelContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 140, 50));

        textContraseña.setForeground(new java.awt.Color(0, 0, 153));
        getContentPane().add(textContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 210, 40));

        jLabelNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelNombre.setForeground(new java.awt.Color(0, 0, 153));
        jLabelNombre.setText("Nombre:");
        getContentPane().add(jLabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 140, 50));

        textNombre.setForeground(new java.awt.Color(0, 0, 153));
        getContentPane().add(textNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 210, 40));

        jLabelApellido.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelApellido.setForeground(new java.awt.Color(0, 0, 153));
        jLabelApellido.setText("Apellido:");
        getContentPane().add(jLabelApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 80, 50));

        textApellido.setForeground(new java.awt.Color(0, 0, 153));
        getContentPane().add(textApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 210, 40));

        jLabelMail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelMail.setForeground(new java.awt.Color(0, 0, 153));
        jLabelMail.setText("Mail:");
        getContentPane().add(jLabelMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 140, 50));

        textMail.setForeground(new java.awt.Color(0, 0, 153));
        getContentPane().add(textMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 210, 40));

        jLabelTelefono.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelTelefono.setForeground(new java.awt.Color(0, 0, 153));
        jLabelTelefono.setText("Telefono:");
        getContentPane().add(jLabelTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 450, 90, 50));

        textTelefono.setForeground(new java.awt.Color(0, 0, 153));
        getContentPane().add(textTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 490, 210, 40));

        jLabelRol.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelRol.setForeground(new java.awt.Color(0, 0, 153));
        jLabelRol.setText("Rol:");
        getContentPane().add(jLabelRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 50, 50));

        cmbRol.setForeground(new java.awt.Color(0, 0, 153));
        cmbRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Importador", "Exportador", "Agente", "Logistica", "Marketing" }));
        getContentPane().add(cmbRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 210, 40));

        jButtonRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 100)); // NOI18N
        jButtonRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuario2.png"))); // NOI18N
        jButtonRegistrar.setText("+");
        jButtonRegistrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonRegistrar.setBorderPainted(false);
        jButtonRegistrar.setContentAreaFilled(false);
        jButtonRegistrar.setFocusPainted(false);
        jButtonRegistrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 560, 120, 140));

        jLabelID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelID.setForeground(new java.awt.Color(0, 0, 153));
        jLabelID.setText("ID:");
        getContentPane().add(jLabelID, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 30, 50));

        textID.setForeground(new java.awt.Color(0, 0, 153));
        textID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textIDActionPerformed(evt);
            }
        });
        getContentPane().add(textID, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 80, 40));

        jLabelStatus.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelStatus.setForeground(new java.awt.Color(0, 0, 153));
        jLabelStatus.setText("Status:");
        getContentPane().add(jLabelStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 70, 50));

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        getContentPane().add(cmbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 120, 40));

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
        getContentPane().add(jButtonInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, 40, 40));

        jButtonVolverAtras.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonVolverAtras.setForeground(new java.awt.Color(0, 0, 153));
        jButtonVolverAtras.setText("Volver atrás");
        jButtonVolverAtras.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 153), new java.awt.Color(0, 0, 153), new java.awt.Color(0, 0, 153), new java.awt.Color(0, 0, 153)));
        jButtonVolverAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverAtrasActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonVolverAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 640, 140, 30));

        jLabelWallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo9.jpg"))); // NOI18N
        getContentPane().add(jLabelWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(-190, -40, 1002, 835));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed

       String usuario, contraseña, nombre, apellido, rol = null, mail, telefono, status = null;
       int id, rolStatus = 0, statusNivel = 0;
       
       String recepcion;
      
       id = Integer.parseInt(textID.getText().trim());
       usuario = textUsuario.getText().trim();
       contraseña = textContraseña.getText().trim();
       nombre = textNombre.getText().trim();
       apellido = textApellido.getText().trim();
       mail = textMail.getText().trim();
       telefono = textTelefono.getText().trim();
       rolStatus = cmbRol.getSelectedIndex() + 1;
       statusNivel = cmbStatus.getSelectedIndex() + 1;
       
       if(rolStatus == 1){
           rol = "Administrador";
       } else if(rolStatus == 2){
           rol = "Importador";
       } else if(rolStatus == 3){
           rol = "Exportador";
       } else if(rolStatus == 4){
           rol = "Agente";
       } else if(rolStatus == 5){
           rol = "Logistica";
       } else if(rolStatus == 6){
           rol = "Marketing";
       }
       
       if(statusNivel == 1){
           status = "Activo";
       } else if (statusNivel == 2){
           status = "Inactivo";
       } 
       
       Boolean noExiste = inicioSesionService.verificarQueNoExistaUsuario(usuario);
       
        if (noExiste.equals(true)) {
            recepcion = inicioSesionService.agregarUsuario(id, usuario, contraseña,
                    nombre, apellido, rol, mail, telefono, status).toString();

            if (!recepcion.isEmpty() && !rol.equals("Administrador")) {
                envioDeMailAAdmin(usuario, nombre, apellido);
                envioDeMailAUsuario(usuario, nombre, apellido, contraseña, rol,  mail);
                mensajesImpl.avisoEsperarConfirmacionDeAcceso(usuario);
                LimpiarCamposRegistroUsuarios();
            } else if (recepcion.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No es posible crear el usuario solicitado");
            }
        } 
     
      

    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    private void jButtonInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInfoActionPerformed

        InformacionID informacionID = new InformacionID();
        informacionID.setVisible(true);
        
    }//GEN-LAST:event_jButtonInfoActionPerformed

    private void jButtonVolverAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverAtrasActionPerformed

        this.dispose();

    }//GEN-LAST:event_jButtonVolverAtrasActionPerformed

    private void textIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textIDActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbRol;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JButton jButtonInfo;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JButton jButtonVolverAtras;
    private javax.swing.JLabel jLabelApellido;
    private javax.swing.JLabel jLabelContraseña;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelInicio;
    private javax.swing.JLabel jLabelMail;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelRol;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JLabel jLabelWallpaper;
    private javax.swing.JTextField textApellido;
    private javax.swing.JTextField textContraseña;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textMail;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textTelefono;
    private javax.swing.JTextField textUsuario;
    // End of variables declaration//GEN-END:variables
}
