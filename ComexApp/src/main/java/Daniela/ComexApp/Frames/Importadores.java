package Daniela.ComexApp.Frames;

import java.awt.Image;
import java.awt.Toolkit;
import service.UsuariosService;

/**
 *
 * @author Daniela
 */
public class Importadores extends javax.swing.JFrame {

    public String usuario = "", nombreCompleto = "";
    /**
     * Creates new form Importadores
     */
    public Importadores() {
        initComponents();
        
        setSize(1050, 800);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        
        PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
        UsuariosService usuariosService = new UsuariosService();
        
        usuario = paginaPrincipal.usuario;
        nombreCompleto = usuariosService.obtenerNombreCompleto(usuario);
        
        setTitle("Importadores - " + usuario + " - sistema ComexApp");
        jLabelBienvenida.setText("Menú de importadores de " + nombreCompleto);
    }
          // icono
    public Image getLogo(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/loguito1.png"));
        return retValue;   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelRegistro = new javax.swing.JPanel();
        jButtonRegistro = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanelLista = new javax.swing.JPanel();
        jButtonListaImportadores = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanelAgenda = new javax.swing.JPanel();
        jButtonAgenda = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanelOpciones = new javax.swing.JPanel();
        jButtonVolverAtras = new javax.swing.JButton();
        jPanelSesion = new javax.swing.JPanel();
        jLabelBienvenida = new javax.swing.JLabel();
        jPanelPedidos = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButtonListaEmpresas = new javax.swing.JButton();
        jLabelWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getLogo());
        setIconImages(getIconImages());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        jPanelRegistro.setBorder(dropShadowBorder1);

        jButtonRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconoempleado.png"))); // NOI18N
        jButtonRegistro.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistroActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Registrar importador");

        javax.swing.GroupLayout jPanelRegistroLayout = new javax.swing.GroupLayout(jPanelRegistro);
        jPanelRegistro.setLayout(jPanelRegistroLayout);
        jPanelRegistroLayout.setHorizontalGroup(
            jPanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegistroLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanelRegistroLayout.setVerticalGroup(
            jPanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegistroLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jButtonRegistro)
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 200, 200));

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder2 = new org.jdesktop.swingx.border.DropShadowBorder();
        jPanelLista.setBorder(dropShadowBorder2);

        jButtonListaImportadores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lista.png"))); // NOI18N
        jButtonListaImportadores.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonListaImportadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListaImportadoresActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("Lista de importadores");

        javax.swing.GroupLayout jPanelListaLayout = new javax.swing.GroupLayout(jPanelLista);
        jPanelLista.setLayout(jPanelListaLayout);
        jPanelListaLayout.setHorizontalGroup(
            jPanelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListaLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonListaImportadores, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanelListaLayout.setVerticalGroup(
            jPanelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListaLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jButtonListaImportadores)
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 200, 200));

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder3 = new org.jdesktop.swingx.border.DropShadowBorder();
        jPanelAgenda.setBorder(dropShadowBorder3);

        jButtonAgenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agenda.png"))); // NOI18N
        jButtonAgenda.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("Agenda personal");

        javax.swing.GroupLayout jPanelAgendaLayout = new javax.swing.GroupLayout(jPanelAgenda);
        jPanelAgenda.setLayout(jPanelAgendaLayout);
        jPanelAgendaLayout.setHorizontalGroup(
            jPanelAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAgendaLayout.createSequentialGroup()
                .addGroup(jPanelAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelAgendaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelAgendaLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jButtonAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanelAgendaLayout.setVerticalGroup(
            jPanelAgendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAgendaLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jButtonAgenda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(17, 17, 17))
        );

        getContentPane().add(jPanelAgenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, -1, 200));

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder4 = new org.jdesktop.swingx.border.DropShadowBorder();
        jPanelOpciones.setBorder(dropShadowBorder4);

        jButtonVolverAtras.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonVolverAtras.setForeground(new java.awt.Color(0, 0, 153));
        jButtonVolverAtras.setText("Volver atrás");
        jButtonVolverAtras.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonVolverAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelOpcionesLayout = new javax.swing.GroupLayout(jPanelOpciones);
        jPanelOpciones.setLayout(jPanelOpcionesLayout);
        jPanelOpcionesLayout.setHorizontalGroup(
            jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
            .addGroup(jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelOpcionesLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jButtonVolverAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanelOpcionesLayout.setVerticalGroup(
            jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
            .addGroup(jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelOpcionesLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jButtonVolverAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanelOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 650, -1, 70));

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder5 = new org.jdesktop.swingx.border.DropShadowBorder();
        jPanelSesion.setBorder(dropShadowBorder5);

        jLabelBienvenida.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelBienvenida.setForeground(new java.awt.Color(0, 0, 153));

        javax.swing.GroupLayout jPanelSesionLayout = new javax.swing.GroupLayout(jPanelSesion);
        jPanelSesion.setLayout(jPanelSesionLayout);
        jPanelSesionLayout.setHorizontalGroup(
            jPanelSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSesionLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabelBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanelSesionLayout.setVerticalGroup(
            jPanelSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSesionLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabelBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 650, 380, 70));

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder6 = new org.jdesktop.swingx.border.DropShadowBorder();
        jPanelPedidos.setBorder(dropShadowBorder6);
        jPanelPedidos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setText("Lista de empresas");
        jPanelPedidos.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 142, 132, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        jLabel5.setText("y productos pedidos");
        jPanelPedidos.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 158, -1));

        jButtonListaEmpresas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/import2.png"))); // NOI18N
        jButtonListaEmpresas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonListaEmpresas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListaEmpresasActionPerformed(evt);
            }
        });
        jPanelPedidos.add(jButtonListaEmpresas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 140, 100));

        getContentPane().add(jPanelPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 330, 200, 200));

        jLabelWallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo3.jpg"))); // NOI18N
        getContentPane().add(jLabelWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVolverAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverAtrasActionPerformed

        PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
        paginaPrincipal.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButtonVolverAtrasActionPerformed

    private void jButtonRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistroActionPerformed
       
        RegistroImportadores registroImportadores = new RegistroImportadores();
        registroImportadores.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButtonRegistroActionPerformed

    private void jButtonListaImportadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListaImportadoresActionPerformed
        
        ListaImportadores listaImportadores = new ListaImportadores();
        listaImportadores.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButtonListaImportadoresActionPerformed

    private void jButtonListaEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListaEmpresasActionPerformed

        ListaEmpresasProductos listaEmpresasProductos = new ListaEmpresasProductos();
        listaEmpresasProductos.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButtonListaEmpresasActionPerformed

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
            java.util.logging.Logger.getLogger(Importadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Importadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Importadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Importadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Importadores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgenda;
    private javax.swing.JButton jButtonListaEmpresas;
    private javax.swing.JButton jButtonListaImportadores;
    private javax.swing.JButton jButtonRegistro;
    private javax.swing.JButton jButtonVolverAtras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelBienvenida;
    private javax.swing.JLabel jLabelWallpaper;
    private javax.swing.JPanel jPanelAgenda;
    private javax.swing.JPanel jPanelLista;
    private javax.swing.JPanel jPanelOpciones;
    private javax.swing.JPanel jPanelPedidos;
    private javax.swing.JPanel jPanelRegistro;
    private javax.swing.JPanel jPanelSesion;
    // End of variables declaration//GEN-END:variables
}
