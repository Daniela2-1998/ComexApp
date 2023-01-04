package Daniela.ComexApp.Frames;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import service.InicioSesionService;
import service.UsuariosService;

/**
 *
 * @author Daniela
 */
public class PaginaPrincipal extends javax.swing.JFrame {

       String usuario = "", contraseña = "", rol = "", nombreCompleto = "";
    /**
     * Creates new form PaginaPrincipal
     */
    public PaginaPrincipal() {
        initComponents();
        
        setSize(1050, 850);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        
        usuario = usuariosServicio.getUsuario();
        contraseña = usuariosServicio.getContraseña();
        
        rol = usuariosServicio.obtenerRolUsuario(usuario, contraseña);
        visibilidadAdministrador();
        
        nombreCompleto = usuariosService.obtenerNombreCompleto(usuario);
        jMenuInfo.setText(nombreCompleto + " - " + usuario);
        
        setTitle("Página principal - " + usuario + " - sistema ComexApp");
    }
    
        // icono
    public Image getLogo(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/loguito1.png"));
        return retValue;   
    }

    InicioSesionService usuariosServicio = new InicioSesionService();
    InicioSesion inicioSesion = new InicioSesion();
    UsuariosService usuariosService = new UsuariosService();
   
    
    public void visibilidadAdministrador(){
        if(rol.equals("Administrador")){
            jMenuAdministrar.setVisible(true);
        }else{
            jMenuAdministrar.setVisible(false);
        } 
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel3 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jButtonImportadores = new javax.swing.JButton();
        jButtonExportadores = new javax.swing.JButton();
        jButtonIDespachantes = new javax.swing.JButton();
        jButtonMaritimas = new javax.swing.JButton();
        jButtonOperaciones = new javax.swing.JButton();
        jButtonStock = new javax.swing.JButton();
        jButtonAereo = new javax.swing.JButton();
        jButtonCerrarSesion = new javax.swing.JButton();
        jLabelTitulo1 = new javax.swing.JLabel();
        jLabelWallpaper = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuInfo = new javax.swing.JMenu();
        jMenuItemInformacion = new javax.swing.JMenuItem();
        jMenuItemCambioContraseña = new javax.swing.JMenuItem();
        jMenuItemRecupero = new javax.swing.JMenuItem();
        jMenuItemAgendar = new javax.swing.JMenuItem();
        jMenuItemNotas = new javax.swing.JMenuItem();
        jMenuItemCalendario = new javax.swing.JMenuItem();
        jMenuPreferencias = new javax.swing.JMenu();
        jMenuItemFondo = new javax.swing.JMenuItem();
        jMenuItemColores = new javax.swing.JMenuItem();
        jMenuAdministrar = new javax.swing.JMenu();
        jMenuItemDatosUsuarios = new javax.swing.JMenuItem();
        jMenuItemControl = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        jPopupMenu1.setPopupSize(new java.awt.Dimension(200, 200));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getLogo());
        setIconImages(getIconImages());
        setPreferredSize(new java.awt.Dimension(1300, 867));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 0, 153));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setText("¡Bienvenido a ComexApp!");
        jPanel3.add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 360, 60));

        jButtonImportadores.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonImportadores.setForeground(new java.awt.Color(0, 0, 153));
        jButtonImportadores.setText("Importadores");
        jButtonImportadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImportadoresActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonImportadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 210, 50));

        jButtonExportadores.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonExportadores.setForeground(new java.awt.Color(0, 0, 153));
        jButtonExportadores.setText("Exportadores");
        jButtonExportadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExportadoresActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonExportadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 210, 50));

        jButtonIDespachantes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonIDespachantes.setForeground(new java.awt.Color(0, 0, 153));
        jButtonIDespachantes.setText("Despachantes");
        jButtonIDespachantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIDespachantesActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonIDespachantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 210, 50));

        jButtonMaritimas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonMaritimas.setForeground(new java.awt.Color(0, 0, 153));
        jButtonMaritimas.setText("Marítimas");
        jButtonMaritimas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMaritimasActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonMaritimas, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 210, 50));

        jButtonOperaciones.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonOperaciones.setForeground(new java.awt.Color(0, 0, 153));
        jButtonOperaciones.setText("Operaciones");
        jButtonOperaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOperacionesActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonOperaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 570, 210, 50));

        jButtonStock.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonStock.setForeground(new java.awt.Color(0, 0, 153));
        jButtonStock.setText("Stock/producción");
        jButtonStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStockActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 500, 210, 50));

        jButtonAereo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonAereo.setForeground(new java.awt.Color(0, 0, 153));
        jButtonAereo.setText("Aereo");
        jButtonAereo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAereoActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonAereo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, 210, 50));

        jButtonCerrarSesion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonCerrarSesion.setForeground(new java.awt.Color(0, 0, 153));
        jButtonCerrarSesion.setText("Cerrar sesión");
        jButtonCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarSesionActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 740, 210, 20));

        jLabelTitulo1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabelTitulo1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo1.setText("Por favor, elige la opción que desees");
        jPanel3.add(jLabelTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 330, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, -10, 390, 820));

        jLabelWallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo3.jpg"))); // NOI18N
        getContentPane().add(jLabelWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(-21, -25, 1070, 860));

        jMenuBar1.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuBar1.setMinimumSize(new java.awt.Dimension(343, 50));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(343, 30));

        jMenuInfo.setText("Información del usuario");
        jMenuInfo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jMenuInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenuInfo.setVerifyInputWhenFocusTarget(false);

        jMenuItemInformacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItemInformacion.setText("Información de la cuenta");
        jMenuItemInformacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemInformacionActionPerformed(evt);
            }
        });
        jMenuInfo.add(jMenuItemInformacion);

        jMenuItemCambioContraseña.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItemCambioContraseña.setText("Cambiar contraseña");
        jMenuItemCambioContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCambioContraseñaActionPerformed(evt);
            }
        });
        jMenuInfo.add(jMenuItemCambioContraseña);

        jMenuItemRecupero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItemRecupero.setText("Opciones de recupero de cuenta");
        jMenuItemRecupero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRecuperoActionPerformed(evt);
            }
        });
        jMenuInfo.add(jMenuItemRecupero);

        jMenuItemAgendar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItemAgendar.setText("Agendar contactos personales");
        jMenuItemAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAgendarActionPerformed(evt);
            }
        });
        jMenuInfo.add(jMenuItemAgendar);

        jMenuItemNotas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItemNotas.setText("Tomar notas");
        jMenuItemNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNotasActionPerformed(evt);
            }
        });
        jMenuInfo.add(jMenuItemNotas);

        jMenuItemCalendario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItemCalendario.setText("Calendario");
        jMenuItemCalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCalendarioActionPerformed(evt);
            }
        });
        jMenuInfo.add(jMenuItemCalendario);

        jMenuBar1.add(jMenuInfo);

        jMenuPreferencias.setText("Preferencias");
        jMenuPreferencias.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jMenuItemFondo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItemFondo.setText("Cambiar fondo");
        jMenuItemFondo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFondoActionPerformed(evt);
            }
        });
        jMenuPreferencias.add(jMenuItemFondo);

        jMenuItemColores.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItemColores.setText("Invertir colores");
        jMenuItemColores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemColoresActionPerformed(evt);
            }
        });
        jMenuPreferencias.add(jMenuItemColores);

        jMenuBar1.add(jMenuPreferencias);

        jMenuAdministrar.setText("Administrar sistema");
        jMenuAdministrar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jMenuItemDatosUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItemDatosUsuarios.setText("Ver datos de usuarios");
        jMenuItemDatosUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDatosUsuariosActionPerformed(evt);
            }
        });
        jMenuAdministrar.add(jMenuItemDatosUsuarios);

        jMenuItemControl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItemControl.setText("Controlar funcionamiento de áreas");
        jMenuAdministrar.add(jMenuItemControl);

        jMenuItem2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem2.setText("Ver sección especial de administrador");
        jMenuAdministrar.add(jMenuItem2);

        jMenuBar1.add(jMenuAdministrar);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemInformacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemInformacionActionPerformed
       
        InformacionUsuario informacionUsuario = new InformacionUsuario();
        informacionUsuario.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jMenuItemInformacionActionPerformed

    private void jMenuItemFondoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFondoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemFondoActionPerformed

    private void jMenuItemCambioContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCambioContraseñaActionPerformed
     
        CambioContraseña cambioContraseña = new CambioContraseña();
        cambioContraseña.setVisible(true);
              
    }//GEN-LAST:event_jMenuItemCambioContraseñaActionPerformed

    private void jButtonCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarSesionActionPerformed
        
        inicioSesion.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButtonCerrarSesionActionPerformed

    private void jMenuItemColoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemColoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemColoresActionPerformed

    private void jMenuItemDatosUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDatosUsuariosActionPerformed
       
        AdministrarUsuarios administrarUsuarios = new AdministrarUsuarios();
        administrarUsuarios.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jMenuItemDatosUsuariosActionPerformed

    private void jMenuItemAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAgendarActionPerformed
      
        AgendaContactosPersonal agendaContactosPersonal = new AgendaContactosPersonal();
        agendaContactosPersonal.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jMenuItemAgendarActionPerformed

    private void jMenuItemNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNotasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemNotasActionPerformed

    private void jMenuItemRecuperoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRecuperoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemRecuperoActionPerformed

    private void jMenuItemCalendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCalendarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemCalendarioActionPerformed

    private void jButtonImportadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImportadoresActionPerformed
        
        Importadores importadores = new Importadores();
        importadores.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButtonImportadoresActionPerformed

    private void jButtonExportadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExportadoresActionPerformed
       
        Exportadores exportadores = new Exportadores();
        exportadores.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButtonExportadoresActionPerformed

    private void jButtonIDespachantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIDespachantesActionPerformed
      
        Despachantes despachantes = new Despachantes();
        despachantes.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButtonIDespachantesActionPerformed

    private void jButtonMaritimasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMaritimasActionPerformed
       
        Maritimas maritimas = new Maritimas();
        maritimas.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButtonMaritimasActionPerformed

    private void jButtonAereoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAereoActionPerformed
        
        Aereo aereo = new Aereo();
        aereo.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButtonAereoActionPerformed

    private void jButtonStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStockActionPerformed
        
        StockProduccion stockprod = new StockProduccion();
        stockprod.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButtonStockActionPerformed

    private void jButtonOperacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOperacionesActionPerformed
       
       Operaciones operaciones = new Operaciones();
       operaciones.setVisible(true);
       this.dispose();
        
    }//GEN-LAST:event_jButtonOperacionesActionPerformed

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
            java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaginaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAereo;
    private javax.swing.JButton jButtonCerrarSesion;
    private javax.swing.JButton jButtonExportadores;
    private javax.swing.JButton jButtonIDespachantes;
    private javax.swing.JButton jButtonImportadores;
    private javax.swing.JButton jButtonMaritimas;
    private javax.swing.JButton jButtonOperaciones;
    private javax.swing.JButton jButtonStock;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelTitulo1;
    private javax.swing.JLabel jLabelWallpaper;
    private javax.swing.JMenu jMenuAdministrar;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuInfo;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItemAgendar;
    private javax.swing.JMenuItem jMenuItemCalendario;
    private javax.swing.JMenuItem jMenuItemCambioContraseña;
    private javax.swing.JMenuItem jMenuItemColores;
    private javax.swing.JMenuItem jMenuItemControl;
    private javax.swing.JMenuItem jMenuItemDatosUsuarios;
    private javax.swing.JMenuItem jMenuItemFondo;
    private javax.swing.JMenuItem jMenuItemInformacion;
    private javax.swing.JMenuItem jMenuItemNotas;
    private javax.swing.JMenuItem jMenuItemRecupero;
    private javax.swing.JMenu jMenuPreferencias;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    // End of variables declaration//GEN-END:variables
}
