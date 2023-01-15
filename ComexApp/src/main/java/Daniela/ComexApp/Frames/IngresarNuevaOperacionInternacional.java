package Daniela.ComexApp.Frames;

import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Date;
import java.util.Calendar;
import service.OperacionesInternacionalesService;


/**
 *
 * @author Daniela
 */
public class IngresarNuevaOperacionInternacional extends javax.swing.JFrame {

     String usuario = "", nombreCompleto = "";
    /**
     * Creates new form IngresarNuevosProductosAStock
     */
    public IngresarNuevaOperacionInternacional() {
        initComponents();
        
        setSize(750, 460);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        
        PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
        
        usuario = paginaPrincipal.usuario;
        nombreCompleto = paginaPrincipal.nombreCompleto;
        
        setTitle("Ingresar nueva operación - " + usuario + " - sistema ComexApp");
    }
    // icono
    public Image getLogo(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/loguito1.png"));
        return retValue;   
    }
    
    OperacionesInternacionalesService operacionesService = new OperacionesInternacionalesService();

    public void LimpiarCampos(){
        textID.setText("");
        textContenedores.setText("");
        textCodigo.setText("");
        jDateChooserRegistro.setDateFormatString("01/01/2020");
        textNumeroEmbarque.setText("");
        textProductos.setText("");
        cmbTipoOperacion.setSelectedIndex(0);
        textCantidad.setText("");
        jDateChooserRecibo.setDateFormatString("01/01/2020");
        cmbStatus1.setSelectedIndex(0);
        textComprador.setText("");
        textPrecioTotal.setText("");
        textVendedor.setText("");
        textDetalle.setText("");
        textPaisOrigen.setText("");
        textBuque.setText("");
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
        jButtonIngresar = new javax.swing.JButton();
        jPanelRegistro = new javax.swing.JPanel();
        jLabelID = new javax.swing.JLabel();
        textID = new javax.swing.JTextField();
        jButtonInfo = new javax.swing.JButton();
        jLabelDetalle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textDetalle = new javax.swing.JTextArea();
        jLabelProductos = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textProductos = new javax.swing.JTextArea();
        jLabelCodigo = new javax.swing.JLabel();
        textCodigo = new javax.swing.JTextField();
        jLabelContenedores = new javax.swing.JLabel();
        textContenedores = new javax.swing.JTextField();
        jLabelPaisOrigen = new javax.swing.JLabel();
        textPaisOrigen = new javax.swing.JTextField();
        jLabelPrecio1 = new javax.swing.JLabel();
        textPrecioTotal = new javax.swing.JTextField();
        jLabelFechaRegistro = new javax.swing.JLabel();
        jDateChooserRegistro = new com.toedter.calendar.JDateChooser();
        jLabelFechaRecibo = new javax.swing.JLabel();
        jDateChooserRecibo = new com.toedter.calendar.JDateChooser();
        jLabelCantidad = new javax.swing.JLabel();
        textCantidad = new javax.swing.JTextField();
        jLabelNumero = new javax.swing.JLabel();
        textNumeroEmbarque = new javax.swing.JTextField();
        jLabelStatus = new javax.swing.JLabel();
        cmbStatus1 = new javax.swing.JComboBox<>();
        jLabelTipoOperacion = new javax.swing.JLabel();
        cmbTipoOperacion = new javax.swing.JComboBox<>();
        jLabelComprador = new javax.swing.JLabel();
        textComprador = new javax.swing.JTextField();
        jLabelVendedor = new javax.swing.JLabel();
        textVendedor = new javax.swing.JTextField();
        jLabelNombreBuque = new javax.swing.JLabel();
        textBuque = new javax.swing.JTextField();
        jButtonAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getLogo());
        setIconImages(getIconImages());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonIngresar.setBackground(new java.awt.Color(0, 0, 153));
        jButtonIngresar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonIngresar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonIngresar.setText("Ingresar producto al sistema");
        jButtonIngresar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        jButtonIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIngresarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, -1, -1));

        jPanelRegistro.setBackground(new java.awt.Color(204, 204, 204));
        jPanelRegistro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelID.setForeground(new java.awt.Color(0, 0, 153));
        jLabelID.setText("ID:");
        jPanelRegistro.add(jLabelID, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        textID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textID.setForeground(new java.awt.Color(0, 0, 153));
        textID.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelRegistro.add(textID, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 60, -1));

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
        jPanelRegistro.add(jButtonInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        jLabelDetalle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelDetalle.setForeground(new java.awt.Color(0, 0, 153));
        jLabelDetalle.setText("Detalles:");
        jPanelRegistro.add(jLabelDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, -1, -1));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setForeground(new java.awt.Color(0, 0, 153));

        textDetalle.setColumns(20);
        textDetalle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textDetalle.setForeground(new java.awt.Color(0, 0, 153));
        textDetalle.setRows(5);
        jScrollPane1.setViewportView(textDetalle);

        jPanelRegistro.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 180, 80));

        jLabelProductos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelProductos.setForeground(new java.awt.Color(0, 0, 153));
        jLabelProductos.setText("Productos:");
        jPanelRegistro.add(jLabelProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setForeground(new java.awt.Color(0, 0, 153));

        textProductos.setColumns(20);
        textProductos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textProductos.setForeground(new java.awt.Color(0, 0, 153));
        textProductos.setRows(5);
        jScrollPane2.setViewportView(textProductos);

        jPanelRegistro.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 150, 120));

        jLabelCodigo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelCodigo.setForeground(new java.awt.Color(0, 0, 153));
        jLabelCodigo.setText("Código contenedor:");
        jPanelRegistro.add(jLabelCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, -1, -1));

        textCodigo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textCodigo.setForeground(new java.awt.Color(0, 0, 153));
        textCodigo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelRegistro.add(textCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 163, 30));

        jLabelContenedores.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelContenedores.setForeground(new java.awt.Color(0, 0, 153));
        jLabelContenedores.setText("Cantidad contenedores:");
        jPanelRegistro.add(jLabelContenedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, -1, -1));

        textContenedores.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textContenedores.setForeground(new java.awt.Color(0, 0, 153));
        textContenedores.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelRegistro.add(textContenedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 163, 30));

        jLabelPaisOrigen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelPaisOrigen.setForeground(new java.awt.Color(0, 0, 153));
        jLabelPaisOrigen.setText("País de orígen:");
        jPanelRegistro.add(jLabelPaisOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, -1, -1));

        textPaisOrigen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textPaisOrigen.setForeground(new java.awt.Color(0, 0, 153));
        textPaisOrigen.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelRegistro.add(textPaisOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 110, 30));

        jLabelPrecio1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelPrecio1.setForeground(new java.awt.Color(0, 0, 153));
        jLabelPrecio1.setText("Precio total:");
        jPanelRegistro.add(jLabelPrecio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, -1, -1));

        textPrecioTotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textPrecioTotal.setForeground(new java.awt.Color(0, 0, 153));
        textPrecioTotal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelRegistro.add(textPrecioTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, 110, 30));

        jLabelFechaRegistro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelFechaRegistro.setForeground(new java.awt.Color(0, 0, 153));
        jLabelFechaRegistro.setText("Fecha registro:");
        jPanelRegistro.add(jLabelFechaRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, -1, -1));
        jPanelRegistro.add(jDateChooserRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, 120, 30));

        jLabelFechaRecibo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelFechaRecibo.setForeground(new java.awt.Color(0, 0, 153));
        jLabelFechaRecibo.setText("Fecha arribo:");
        jPanelRegistro.add(jLabelFechaRecibo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, -1, -1));
        jPanelRegistro.add(jDateChooserRecibo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 140, 120, 30));

        jLabelCantidad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelCantidad.setForeground(new java.awt.Color(0, 0, 153));
        jLabelCantidad.setText("Cantidad producto:");
        jPanelRegistro.add(jLabelCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 140, -1));

        textCantidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textCantidad.setForeground(new java.awt.Color(0, 0, 153));
        textCantidad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelRegistro.add(textCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 160, 30));

        jLabelNumero.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNumero.setForeground(new java.awt.Color(0, 0, 153));
        jLabelNumero.setText("Número de embarque:");
        jPanelRegistro.add(jLabelNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, -1, -1));

        textNumeroEmbarque.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textNumeroEmbarque.setForeground(new java.awt.Color(0, 0, 153));
        textNumeroEmbarque.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelRegistro.add(textNumeroEmbarque, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 150, 30));

        jLabelStatus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelStatus.setForeground(new java.awt.Color(0, 0, 153));
        jLabelStatus.setText("Status:");
        jPanelRegistro.add(jLabelStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, -1, -1));

        cmbStatus1.setForeground(new java.awt.Color(0, 0, 153));
        cmbStatus1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activa", "En transito", "Pendiente de cierre", "Completada", "Suspendida", "Inactiva" }));
        cmbStatus1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cmbStatus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStatus1ActionPerformed(evt);
            }
        });
        jPanelRegistro.add(cmbStatus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 200, 120, 40));

        jLabelTipoOperacion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTipoOperacion.setForeground(new java.awt.Color(0, 0, 153));
        jLabelTipoOperacion.setText("Tipo de operación:");
        jPanelRegistro.add(jLabelTipoOperacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        cmbTipoOperacion.setForeground(new java.awt.Color(0, 0, 153));
        cmbTipoOperacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Importación", "Exportación", "Logística internacional", "Despacho aduanero" }));
        cmbTipoOperacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cmbTipoOperacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoOperacionActionPerformed(evt);
            }
        });
        jPanelRegistro.add(cmbTipoOperacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 150, 40));

        jLabelComprador.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelComprador.setForeground(new java.awt.Color(0, 0, 153));
        jLabelComprador.setText("Comprador:");
        jPanelRegistro.add(jLabelComprador, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 100, -1));

        textComprador.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textComprador.setForeground(new java.awt.Color(0, 0, 153));
        textComprador.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelRegistro.add(textComprador, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 160, 30));

        jLabelVendedor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelVendedor.setForeground(new java.awt.Color(0, 0, 153));
        jLabelVendedor.setText("Vendedor:");
        jPanelRegistro.add(jLabelVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 100, -1));

        textVendedor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textVendedor.setForeground(new java.awt.Color(0, 0, 153));
        textVendedor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelRegistro.add(textVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 160, 30));

        jLabelNombreBuque.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNombreBuque.setForeground(new java.awt.Color(0, 0, 153));
        jLabelNombreBuque.setText("Nombre buque:");
        jPanelRegistro.add(jLabelNombreBuque, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, -1, -1));

        textBuque.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textBuque.setForeground(new java.awt.Color(0, 0, 153));
        textBuque.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelRegistro.add(textBuque, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 160, 30));

        jPanel1.add(jPanelRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 680, 330));

        jButtonAtras.setBackground(new java.awt.Color(0, 0, 153));
        jButtonAtras.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonAtras.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAtras.setText("Volver atrás");
        jButtonAtras.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtrasActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 370, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIngresarActionPerformed

        String codigo, fechaOperacion, numeroEmbarque, producto,
            tipoOperacion = null, cantidadProducto, fechaETA, status = null, comprador, 
                precioTotal, vendedor, detalles, paisOrigen, nombreBuque;
        
        int statusNivel = 0, tipoOperacionNivel = 0, ID, cantidadContenedor;
        
        
        Boolean recepcionFuncion;
        
        ID = Integer.parseInt(textID.getText().trim());
        cantidadContenedor = Integer.parseInt(textContenedores.getText().trim());
        codigo = textCodigo.getText().trim();
        fechaOperacion = jDateChooserRegistro.getDate().toString();
        numeroEmbarque = textNumeroEmbarque.getText().trim();
        producto = textProductos.getText().trim();
        tipoOperacionNivel = cmbTipoOperacion.getSelectedIndex() + 1;
        cantidadProducto = textCantidad.getText().trim();
        fechaETA = jDateChooserRecibo.getDate().toString();
        statusNivel = cmbStatus1.getSelectedIndex() + 1;
        comprador = textComprador.getText().trim();
        precioTotal = textPrecioTotal.getText().trim();
        vendedor = textVendedor.getText().trim();
        detalles = textDetalle.getText().trim();
        paisOrigen = textPaisOrigen.getText().trim();
        nombreBuque = textBuque.getText().trim();
   
        if(statusNivel == 1){
           status = "Activa";
        } else if (statusNivel == 2){
           status = "En transito";
        } else if (statusNivel == 3){
           status = "Pendiente de cierre";
        } else if (statusNivel == 4){
           status = "Completada";
        } else if (statusNivel == 5){
           status = "Suspendida";
        } else if (statusNivel == 6){
           status = "Inactiva";
        }


        if(tipoOperacionNivel == 1){
           tipoOperacion = "Importación";
        } else if (statusNivel == 2){
           tipoOperacion = "Exportación";
        } else if (statusNivel == 3){
           tipoOperacion = "Logística internacional";
        } else if (statusNivel == 4){
           tipoOperacion = "Despacho aduanero";
        }
       
        recepcionFuncion = operacionesService.ingresoOperacionInternacional(ID, 
                cantidadContenedor, codigo, numeroEmbarque, producto, tipoOperacion, 
                cantidadProducto, status, comprador, precioTotal, vendedor, detalles, 
                paisOrigen, nombreBuque, fechaOperacion, fechaETA);

         if(recepcionFuncion.equals(true)){
           LimpiarCampos();
        }

    }//GEN-LAST:event_jButtonIngresarActionPerformed

    private void jButtonInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInfoActionPerformed

        InformacionIDOperacionInternacional informacionIDOperacionInternacional = new InformacionIDOperacionInternacional();
        informacionIDOperacionInternacional.setVisible(true);
        
    }//GEN-LAST:event_jButtonInfoActionPerformed

    private void jButtonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtrasActionPerformed
        
        Operaciones operaciones = new Operaciones();
        operaciones.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButtonAtrasActionPerformed

    private void cmbStatus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStatus1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbStatus1ActionPerformed

    private void cmbTipoOperacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoOperacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoOperacionActionPerformed

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
            java.util.logging.Logger.getLogger(IngresarNuevaOperacionInternacional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresarNuevaOperacionInternacional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresarNuevaOperacionInternacional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresarNuevaOperacionInternacional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngresarNuevaOperacionInternacional().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbStatus1;
    private javax.swing.JComboBox<String> cmbTipoOperacion;
    private javax.swing.JButton jButtonAtras;
    private javax.swing.JButton jButtonInfo;
    private javax.swing.JButton jButtonIngresar;
    private com.toedter.calendar.JDateChooser jDateChooserRecibo;
    private com.toedter.calendar.JDateChooser jDateChooserRegistro;
    private javax.swing.JLabel jLabelCantidad;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelComprador;
    private javax.swing.JLabel jLabelContenedores;
    private javax.swing.JLabel jLabelDetalle;
    private javax.swing.JLabel jLabelFechaRecibo;
    private javax.swing.JLabel jLabelFechaRegistro;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelNombreBuque;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JLabel jLabelPaisOrigen;
    private javax.swing.JLabel jLabelPrecio1;
    private javax.swing.JLabel jLabelProductos;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JLabel jLabelTipoOperacion;
    private javax.swing.JLabel jLabelVendedor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelRegistro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField textBuque;
    private javax.swing.JTextField textCantidad;
    private javax.swing.JTextField textCodigo;
    private javax.swing.JTextField textComprador;
    private javax.swing.JTextField textContenedores;
    private javax.swing.JTextArea textDetalle;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textNumeroEmbarque;
    private javax.swing.JTextField textPaisOrigen;
    private javax.swing.JTextField textPrecioTotal;
    private javax.swing.JTextArea textProductos;
    private javax.swing.JTextField textVendedor;
    // End of variables declaration//GEN-END:variables
}