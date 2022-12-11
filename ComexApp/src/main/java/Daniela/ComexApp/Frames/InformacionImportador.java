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
import service.ImportadoresService;
import service.InicioSesionService;
import service.UsuariosService;

/**
 *
 * @author Daniela
 * 
 */
public class InformacionImportador extends javax.swing.JFrame {

    String importadorBuscado = "";
    /**
     * Creates new form VerUsuario
     */
    public InformacionImportador() {
        initComponents();
        
        setSize(850, 750);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);

        
        importadorBuscado = textImportadorBuscado.getText().trim();
        
        setTitle("Informacíón completa del importador - Sistema ComexApp");
        jLabelTitulo.setText("Información completa del importador");

    }
      // icono
    public Image getLogo(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/loguito1.png"));
        return retValue;   
    }
    
    ImportadoresService importadoresService = new ImportadoresService();
   
   
    public void LimpiarCampos(){
        textEmpresa.setText("");
        textCUIT.setText("");
        textEmpleado.setText("");
        textMail.setText("");
        textNumero.setText("");
        textPais.setText("");
        textID.setText("");
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

        jPanelArriba = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jPanelMenu = new javax.swing.JPanel();
        jButtonVolverAtras = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonRegistrar = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        textImportadorBuscado = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabelEmpresa = new javax.swing.JLabel();
        textEmpresa = new javax.swing.JTextField();
        jLabelEmpleado = new javax.swing.JLabel();
        textEmpleado = new javax.swing.JTextField();
        jLabelMail = new javax.swing.JLabel();
        textMail = new javax.swing.JTextField();
        jLabelContacto = new javax.swing.JLabel();
        textNumero = new javax.swing.JTextField();
        jLabelPais = new javax.swing.JLabel();
        textPais = new javax.swing.JTextField();
        textID = new javax.swing.JTextField();
        jLabelID = new javax.swing.JLabel();
        jButtonInfo = new javax.swing.JButton();
        jLabelStatus = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        jLabelSubt = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelCUIT = new javax.swing.JLabel();
        textCUIT = new javax.swing.JPasswordField();
        jLabelProductos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textProductos = new javax.swing.JTextArea();

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
                .addContainerGap(684, Short.MAX_VALUE))
        );
        jPanelArribaLayout.setVerticalGroup(
            jPanelArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelArribaLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabelTitulo)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelArriba, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 90));

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
        jButtonModificar.setText("Modificar importador");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });
        jPanelMenu.add(jButtonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jButtonEliminar.setBackground(new java.awt.Color(0, 0, 153));
        jButtonEliminar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonEliminar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEliminar.setText("Eliminar importador");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });
        jPanelMenu.add(jButtonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 220, -1));

        jButtonRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButtonRegistrar.setForeground(new java.awt.Color(0, 0, 153));
        jButtonRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/card.png"))); // NOI18N
        jButtonRegistrar.setText("Registrar");
        jButtonRegistrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonRegistrar.setBorderPainted(false);
        jButtonRegistrar.setContentAreaFilled(false);
        jButtonRegistrar.setFocusPainted(false);
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });
        jPanelMenu.add(jButtonRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 190, 140));

        jButtonBuscar.setBackground(new java.awt.Color(0, 0, 153));
        jButtonBuscar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBuscar.setText("Buscar importador");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        jPanelMenu.add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 217, -1));

        textImportadorBuscado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textImportadorBuscadoActionPerformed(evt);
            }
        });
        jPanelMenu.add(textImportadorBuscado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 217, 33));

        getContentPane().add(jPanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 750));

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelEmpresa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEmpresa.setText("Empresa:");
        jPanel1.add(jLabelEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 63, -1, -1));

        textEmpresa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textEmpresa.setForeground(new java.awt.Color(0, 0, 153));
        textEmpresa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(textEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 89, 163, -1));

        jLabelEmpleado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEmpleado.setText("Empleado:");
        jPanel1.add(jLabelEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 126, -1, -1));

        textEmpleado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textEmpleado.setForeground(new java.awt.Color(0, 0, 153));
        textEmpleado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(textEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 152, 163, -1));

        jLabelMail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelMail.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMail.setText("Mail:");
        jPanel1.add(jLabelMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 193, -1, -1));

        textMail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textMail.setForeground(new java.awt.Color(0, 0, 153));
        textMail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(textMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 219, 163, -1));

        jLabelContacto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelContacto.setForeground(new java.awt.Color(255, 255, 255));
        jLabelContacto.setText("Número de contacto:");
        jPanel1.add(jLabelContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 255, -1, -1));

        textNumero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textNumero.setForeground(new java.awt.Color(0, 0, 153));
        textNumero.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(textNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 281, 163, -1));

        jLabelPais.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelPais.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPais.setText("Pais:");
        jPanel1.add(jLabelPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 318, -1, -1));

        textPais.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textPais.setForeground(new java.awt.Color(0, 0, 153));
        textPais.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(textPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 344, 163, -1));

        textID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textID.setForeground(new java.awt.Color(0, 0, 153));
        textID.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(textID, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 480, 93, -1));

        jLabelID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelID.setForeground(new java.awt.Color(255, 255, 255));
        jLabelID.setText("ID:");
        jPanel1.add(jLabelID, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 448, -1, -1));

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
        jPanel1.add(jButtonInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 466, -1, -1));

        jLabelStatus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelStatus.setForeground(new java.awt.Color(255, 255, 255));
        jLabelStatus.setText("Status:");
        jPanel1.add(jLabelStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, -1, -1));

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo", "Suspendido" }));
        jPanel1.add(cmbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 120, 40));

        jLabelSubt.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabelSubt.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSubt.setText("Datos completos:");
        jPanel1.add(jLabelSubt, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 18, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/empleados3.png"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(150, 150));
        jLabel1.setMinimumSize(new java.awt.Dimension(150, 150));
        jLabel1.setPreferredSize(new java.awt.Dimension(150, 150));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 423, 341, 187));

        jLabelCUIT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelCUIT.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCUIT.setText("CUIT:");
        jPanel1.add(jLabelCUIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 382, -1, -1));

        textCUIT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textCUIT.setForeground(new java.awt.Color(0, 0, 153));
        jPanel1.add(textCUIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 408, 163, 28));

        jLabelProductos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelProductos.setForeground(new java.awt.Color(255, 255, 255));
        jLabelProductos.setText("Productos que suele pedir:");
        jPanel1.add(jLabelProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, -1, -1));

        jScrollPane1.setForeground(new java.awt.Color(0, 0, 153));

        textProductos.setColumns(20);
        textProductos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textProductos.setForeground(new java.awt.Color(0, 0, 153));
        textProductos.setRows(5);
        jScrollPane1.setViewportView(textProductos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 310, 170));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 590, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVolverAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverAtrasActionPerformed

        ListaImportadores listaImportadores = new ListaImportadores();
        listaImportadores.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButtonVolverAtrasActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed

        String cuitMod, empleadoMod, empresaMod, mailMod, numeroContactoMod, paisMod, 
                productosPedidosMod, statusMod = null;
        
        int statusNivel = 0, IDMod; 
        
        String empleado = textImportadorBuscado.getText().trim();
        
        try{        
        
            IDMod = Integer.parseInt(textID.getText().trim());
            cuitMod = textCUIT.getText().trim();
            empleadoMod = textEmpleado.getText().trim();
            empresaMod = textEmpresa.getText().trim();
            mailMod = textNumero.getText().trim();
            numeroContactoMod = textNumero.getText().trim();
            paisMod = textPais.getText().trim();
            productosPedidosMod = textProductos.getText().trim();
            statusNivel = cmbStatus.getSelectedIndex() + 1;

            if (statusNivel == 1) {
                statusMod = "Activo";
            } else if (statusNivel == 2) {
                statusMod = "Inactivo";
            } else if (statusNivel == 3) {
                statusMod = "Suspendido";
            }

            importadoresService.modificarDatosImportador(cuitMod, empleado, empleadoMod,
                     empresaMod, mailMod, numeroContactoMod, paisMod, productosPedidosMod, statusMod);

        }catch(Exception e){
            System.err.println("Fallo al modificar datos " + e);
            JOptionPane.showMessageDialog(null, "Fallo al modificar datos");
        }
        
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed

        int id = Integer.parseInt(textID.getText().trim());
        String empleado = textEmpleado.getText().trim();
        
        try{
            Boolean aprobarEliminar = importadoresService.eliminarImportador(empleado, id);
            
            if(aprobarEliminar.equals(true)){
                JOptionPane.showMessageDialog(null, "Eliminación éxitosa");
                LimpiarCampos();
            }
                  
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No pudimos eliminar al importador");
        }
        
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed

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
           LimpiarCampos();
        }
    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    private void jButtonInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInfoActionPerformed

        InformacionIDImportadores informacionIDImportadores = new InformacionIDImportadores();
        informacionIDImportadores.setVisible(true);

    }//GEN-LAST:event_jButtonInfoActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed

       importadoresService.obtenerDatosDelImportador(textImportadorBuscado, 
               textID, textCUIT, textEmpleado, textEmpresa, textMail, textNumero, 
               textPais, textProductos, cmbStatus);
      
       String importadorABuscar = textImportadorBuscado.getText().trim();
               
       setTitle("Informacíón completa de " + importadorABuscar + " - Sistema ComexApp");
       jLabelTitulo.setText("Información completa de " + importadorABuscar + "");
  
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void textImportadorBuscadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textImportadorBuscadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textImportadorBuscadoActionPerformed

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
            java.util.logging.Logger.getLogger(InformacionImportador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionImportador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionImportador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionImportador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionImportador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonInfo;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JButton jButtonVolverAtras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCUIT;
    private javax.swing.JLabel jLabelContacto;
    private javax.swing.JLabel jLabelEmpleado;
    private javax.swing.JLabel jLabelEmpresa;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelMail;
    private javax.swing.JLabel jLabelPais;
    private javax.swing.JLabel jLabelProductos;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JLabel jLabelSubt;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelArriba;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPasswordField textCUIT;
    private javax.swing.JTextField textEmpleado;
    private javax.swing.JTextField textEmpresa;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textImportadorBuscado;
    private javax.swing.JTextField textMail;
    private javax.swing.JTextField textNumero;
    private javax.swing.JTextField textPais;
    private javax.swing.JTextArea textProductos;
    // End of variables declaration//GEN-END:variables


}