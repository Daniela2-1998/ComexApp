package Daniela.ComexApp.Frames;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import service.ImportadoresService;
import service.UsuariosImpl;

/**
 *
 * @author Daniela
 */
public class RegistroImportadores extends javax.swing.JFrame {

    String usuario = "", nombreCompleto = "";
    /**
     * Creates new form RegistroImportadores
     */
    public RegistroImportadores() {
        initComponents();
        
        setSize(1050, 800);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        
        PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
        UsuariosImpl usuariosService = new UsuariosImpl();
        
        usuario = paginaPrincipal.usuario;
        nombreCompleto = usuariosService.obtenerNombreCompleto(usuario);
        
        setTitle("Registro de importadores - " + usuario + " - sistema ComexApp");
    }
       // icono
    public Image getLogo(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/loguito1.png"));
        return retValue;   
    }

    ImportadoresService importadoresService = new ImportadoresService();
    
    
    public void LimpiarCamposRegistroImportadores(){
        textCUIT.setText("");
        textEmpleado.setText("");
        textEmpresa.setText("");
        textMail.setText("");
        textNumero.setText("");
        textPais.setText("");
        textProductos.setText("");
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

        jPanelTitulo = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jPanelCampos = new javax.swing.JPanel();
        jLabelEmpresa = new javax.swing.JLabel();
        textEmpresa = new javax.swing.JTextField();
        jLabelEmpleado = new javax.swing.JLabel();
        textEmpleado = new javax.swing.JTextField();
        jLabelPais = new javax.swing.JLabel();
        textPais = new javax.swing.JTextField();
        jLabelCuit = new javax.swing.JLabel();
        textCUIT = new javax.swing.JTextField();
        jLabelMail = new javax.swing.JLabel();
        textMail = new javax.swing.JTextField();
        jLabelNumero = new javax.swing.JLabel();
        textNumero = new javax.swing.JTextField();
        jLabelStatus = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        jLabelProductos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textProductos = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabelID = new javax.swing.JLabel();
        textID = new javax.swing.JTextField();
        jButtonInfo = new javax.swing.JButton();
        jPanelBotones = new javax.swing.JPanel();
        jButtonVolver = new javax.swing.JButton();
        jButtonRegistro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getLogo());
        setIconImages(getIconImages());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelTitulo.setBackground(new java.awt.Color(255, 255, 255));

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(0, 0, 153));
        jLabelTitulo.setText("Registro de importadores");

        javax.swing.GroupLayout jPanelTituloLayout = new javax.swing.GroupLayout(jPanelTitulo);
        jPanelTitulo.setLayout(jPanelTituloLayout);
        jPanelTituloLayout.setHorizontalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1050, Short.MAX_VALUE)
            .addGroup(jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelTituloLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabelTitulo)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanelTituloLayout.setVerticalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelTituloLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabelTitulo)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 100));

        jPanelCampos.setBackground(new java.awt.Color(0, 0, 153));
        jPanelCampos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelEmpresa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEmpresa.setText("Empresa:");
        jPanelCampos.add(jLabelEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 56, -1, -1));

        textEmpresa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textEmpresa.setForeground(new java.awt.Color(0, 0, 153));
        textEmpresa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelCampos.add(textEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 82, 190, -1));

        jLabelEmpleado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEmpleado.setText("Empleado:");
        jPanelCampos.add(jLabelEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 126, -1, -1));

        textEmpleado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textEmpleado.setForeground(new java.awt.Color(0, 0, 153));
        textEmpleado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelCampos.add(textEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 152, 190, -1));

        jLabelPais.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelPais.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPais.setText("Pais:");
        jPanelCampos.add(jLabelPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 56, -1, -1));

        textPais.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textPais.setForeground(new java.awt.Color(0, 0, 153));
        textPais.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelCampos.add(textPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 82, 208, -1));

        jLabelCuit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelCuit.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCuit.setText("CUIT:");
        jPanelCampos.add(jLabelCuit, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 56, -1, -1));

        textCUIT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textCUIT.setForeground(new java.awt.Color(0, 0, 153));
        textCUIT.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelCampos.add(textCUIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 82, 208, -1));

        jLabelMail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelMail.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMail.setText("Mail:");
        jPanelCampos.add(jLabelMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 196, -1, -1));

        textMail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textMail.setForeground(new java.awt.Color(0, 0, 153));
        textMail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelCampos.add(textMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 222, 190, -1));

        jLabelNumero.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNumero.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNumero.setText("Número de contacto:");
        jPanelCampos.add(jLabelNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 270, -1, -1));

        textNumero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textNumero.setForeground(new java.awt.Color(0, 0, 153));
        textNumero.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelCampos.add(textNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 296, 190, -1));

        jLabelStatus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelStatus.setForeground(new java.awt.Color(255, 255, 255));
        jLabelStatus.setText("Status;");
        jPanelCampos.add(jLabelStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 140, -1, -1));

        cmbStatus.setForeground(new java.awt.Color(0, 0, 153));
        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo", "Suspendido" }));
        cmbStatus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cmbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStatusActionPerformed(evt);
            }
        });
        jPanelCampos.add(cmbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 170, 210, 40));

        jLabelProductos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelProductos.setForeground(new java.awt.Color(255, 255, 255));
        jLabelProductos.setText("Productos que suele pedir:");
        jPanelCampos.add(jLabelProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, -1, -1));

        jScrollPane1.setForeground(new java.awt.Color(0, 0, 153));

        textProductos.setColumns(20);
        textProductos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textProductos.setForeground(new java.awt.Color(0, 0, 153));
        textProductos.setRows(5);
        jScrollPane1.setViewportView(textProductos);

        jPanelCampos.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 340, 170));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/contenedor.png"))); // NOI18N
        jPanelCampos.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 320, 210, 160));

        jLabelID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelID.setForeground(new java.awt.Color(255, 255, 255));
        jLabelID.setText("ID:");
        jPanelCampos.add(jLabelID, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 230, -1, -1));

        textID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textID.setForeground(new java.awt.Color(0, 0, 153));
        textID.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelCampos.add(textID, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 260, 100, -1));

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
        jPanelCampos.add(jButtonInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 250, 40, 40));

        getContentPane().add(jPanelCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 106, 1050, 510));

        jPanelBotones.setBackground(new java.awt.Color(255, 255, 255));

        jButtonVolver.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonVolver.setForeground(new java.awt.Color(0, 0, 153));
        jButtonVolver.setText("Volver atrás");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });

        jButtonRegistro.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonRegistro.setForeground(new java.awt.Color(0, 0, 153));
        jButtonRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconoempleado.png"))); // NOI18N
        jButtonRegistro.setText("Agregar");
        jButtonRegistro.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 0, 153), new java.awt.Color(0, 0, 153)));
        jButtonRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBotonesLayout = new javax.swing.GroupLayout(jPanelBotones);
        jPanelBotones.setLayout(jPanelBotonesLayout);
        jPanelBotonesLayout.setHorizontalGroup(
            jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonesLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jButtonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(152, 152, 152)
                .addComponent(jButtonRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(441, Short.MAX_VALUE))
        );
        jPanelBotonesLayout.setVerticalGroup(
            jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonesLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRegistro))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelBotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 617, 1050, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbStatusActionPerformed

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed

       Importadores importadores = new Importadores();
       importadores.setVisible(true);
       this.dispose();

    }//GEN-LAST:event_jButtonVolverActionPerformed

    private void jButtonRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistroActionPerformed

        String cuit, empleado, empresa, mail, numeroContacto, pais, 
                productosPedidos, status = null;
        int statusNivel = 0, ID;
        
        Boolean recepcion;
        
        ID = Integer.parseInt(textID.getText().trim());
        cuit = textCUIT.getText().trim();
        empleado = textEmpleado.getText().trim();
        empresa = textEmpresa.getText().trim();
        mail = textMail.getText().trim();
        numeroContacto = textNumero.getText().trim();
        pais = textPais.getText().trim();
        productosPedidos = textProductos.getText().trim();
        statusNivel = cmbStatus.getSelectedIndex() + 1;
        
        if(statusNivel == 1){
           status = "Activo";
        } else if (statusNivel == 2){
           status = "Inactivo";
        } else if (statusNivel == 3){
           status = "Suspendido";
        }
           
        recepcion = importadoresService.registroDeImportador(ID, cuit, empleado, 
                empresa, mail, numeroContacto, pais, productosPedidos, status);
        
        if(recepcion.equals(true)){
           LimpiarCamposRegistroImportadores();
        }

    }//GEN-LAST:event_jButtonRegistroActionPerformed

    private void jButtonInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInfoActionPerformed

        InformacionIDImportadores informacionIDImportadores = new InformacionIDImportadores();
        informacionIDImportadores.setVisible(true);

    }//GEN-LAST:event_jButtonInfoActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroImportadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroImportadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroImportadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroImportadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroImportadores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JButton jButtonInfo;
    private javax.swing.JButton jButtonRegistro;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCuit;
    private javax.swing.JLabel jLabelEmpleado;
    private javax.swing.JLabel jLabelEmpresa;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelMail;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JLabel jLabelPais;
    private javax.swing.JLabel jLabelProductos;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelBotones;
    private javax.swing.JPanel jPanelCampos;
    private javax.swing.JPanel jPanelTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField textCUIT;
    private javax.swing.JTextField textEmpleado;
    private javax.swing.JTextField textEmpresa;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textMail;
    private javax.swing.JTextField textNumero;
    private javax.swing.JTextField textPais;
    private javax.swing.JTextArea textProductos;
    // End of variables declaration//GEN-END:variables
}
