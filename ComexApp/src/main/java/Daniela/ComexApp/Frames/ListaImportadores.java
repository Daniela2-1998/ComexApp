package Daniela.ComexApp.Frames;

import config.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniela
 */
public class ListaImportadores extends javax.swing.JFrame {

    String usuario = "", nombreCompleto = "";
    /**
     * Creates new form ListaImportadores
     */
    public ListaImportadores() {
        initComponents();
        
        setSize(1300, 800);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        
        setTitle("Lista de importadores - Sistema ComexApp");
        
        PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
        nombreCompleto = paginaPrincipal.nombreCompleto;
        jLabelPersonalizado.setText("registrados " + nombreCompleto + "!");
        
        
        mostrarTodosLosDatos();
    }
 
    public Image getLogo(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/loguito1.png"));
        return retValue;   
    }
    
    // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;
       
     
       
    public void cargarTablaImportadores(String sql){

        DefaultTableModel modelo = new DefaultTableModel();
      
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            jTableImportadores = new JTable(modelo);
            jScrollPane1.setViewportView(jTableImportadores);
            
            modelo.addColumn("ID");
            modelo.addColumn("Empleado");
            modelo.addColumn("Empresa");
            modelo.addColumn("Mail");
            modelo.addColumn("Contacto");
            modelo.addColumn("Pais");
            modelo.addColumn("Status");
            
            while(rs.next()){
                Object[] fila = new Object[7];
                for(int i = 0; i < 7; i++){
                    fila[i] = rs.getObject(i + 1);
                }
               modelo.addRow(fila);
            }
            
            conec.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al cargar tabla de importadores");
            System.err.println("Error al cargar tabla de importadores " + e);
        }
    }

   
     public void mostrarTodosLosDatos(){
         String sql = "select id_importador, empleado, empresa, mail, "
            + "numero_contacto, pais, status from importadores";
        cargarTablaImportadores(sql);
    }
    
     
     public void LimpiarBusqueda(){
         textBusqueda.setText("");
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
        jPanelOpciones = new javax.swing.JPanel();
        jLabelFijo = new javax.swing.JLabel();
        jLabelPersonalizado = new javax.swing.JLabel();
        jButtonVolver1 = new javax.swing.JButton();
        jButtonVolver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanelTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableImportadores = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jToggleButtonFiltrar = new javax.swing.JToggleButton();
        jLabelHabilitar = new javax.swing.JLabel();
        jLabelBusqueda = new javax.swing.JLabel();
        textBusqueda = new javax.swing.JTextField();
        jLabelStatus = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getLogo());
        setIconImages(getIconImages());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelTitulo.setBackground(new java.awt.Color(255, 255, 255));

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(0, 0, 153));
        jLabelTitulo.setText("Lista de importadores");

        javax.swing.GroupLayout jPanelTituloLayout = new javax.swing.GroupLayout(jPanelTitulo);
        jPanelTitulo.setLayout(jPanelTituloLayout);
        jPanelTituloLayout.setHorizontalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
            .addGroup(jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelTituloLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabelTitulo)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanelTituloLayout.setVerticalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
            .addGroup(jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelTituloLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabelTitulo)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 110));

        jPanelOpciones.setBackground(new java.awt.Color(204, 204, 204));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        jPanelOpciones.setBorder(dropShadowBorder1);
        jPanelOpciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelFijo.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabelFijo.setForeground(new java.awt.Color(0, 0, 153));
        jLabelFijo.setText("¡Aquí puedes ver la lista de importadores");
        jPanelOpciones.add(jLabelFijo, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 23, 522, -1));

        jLabelPersonalizado.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabelPersonalizado.setForeground(new java.awt.Color(0, 0, 153));
        jPanelOpciones.add(jLabelPersonalizado, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 293, 27));

        jButtonVolver1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonVolver1.setForeground(new java.awt.Color(0, 0, 153));
        jButtonVolver1.setText("Información importador");
        jButtonVolver1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolver1ActionPerformed(evt);
            }
        });
        jPanelOpciones.add(jButtonVolver1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 250, 50));

        jButtonVolver.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonVolver.setForeground(new java.awt.Color(0, 0, 153));
        jButtonVolver.setText("Volver atrás");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });
        jPanelOpciones.add(jButtonVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 560, 210, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/card.png"))); // NOI18N
        jPanelOpciones.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 70, -1));

        getContentPane().add(jPanelOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 390, 640));

        jPanelTabla.setBackground(new java.awt.Color(0, 0, 153));
        jPanelTabla.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableImportadores.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jTableImportadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Empleado", "Empresa", "Mail", "Contacto", "Pais", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableImportadores);

        jPanelTabla.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 230, 843, 384));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToggleButtonFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/no.png"))); // NOI18N
        jToggleButtonFiltrar.setBorderPainted(false);
        jToggleButtonFiltrar.setContentAreaFilled(false);
        jToggleButtonFiltrar.setFocusPainted(false);
        jToggleButtonFiltrar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/si.png"))); // NOI18N
        jToggleButtonFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonFiltrarActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButtonFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        jLabelHabilitar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabelHabilitar.setForeground(new java.awt.Color(0, 0, 153));
        jLabelHabilitar.setText("Habilitar filtros");
        jPanel1.add(jLabelHabilitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 120, 20));

        jLabelBusqueda.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabelBusqueda.setForeground(new java.awt.Color(0, 0, 153));
        jLabelBusqueda.setText("Coloca empresa o empleado:");
        jPanel1.add(jLabelBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 210, 20));

        textBusqueda.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        textBusqueda.setForeground(new java.awt.Color(0, 0, 153));
        jPanel1.add(textBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 240, 40));

        jLabelStatus.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabelStatus.setForeground(new java.awt.Color(0, 0, 153));
        jLabelStatus.setText("Status requerido:");
        jPanel1.add(jLabelStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, 130, 20));

        cmbStatus.setForeground(new java.awt.Color(0, 0, 153));
        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo", "Suspendido" }));
        jPanel1.add(cmbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 50, 170, 40));

        jToggleButton1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jToggleButton1.setForeground(new java.awt.Color(0, 0, 153));
        jToggleButton1.setText("Buscar todos/Reiniciar");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 220, 40));

        jPanelTabla.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 29, 843, 161));

        getContentPane().add(jPanelTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 910, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed

        Importadores importadores = new Importadores();
        importadores.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButtonVolverActionPerformed

    private void jToggleButtonFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonFiltrarActionPerformed
        
        int statusBusqueda = cmbStatus.getSelectedIndex() + 1;
        String statusBuscado = null;
        
        switch(statusBusqueda){
            case 1:
                statusBuscado = "Activo";
            break;
            case 2:
                statusBuscado = "Inactivo";
            break;
            case 3:
                statusBuscado = "Suspendido";
            break;
        }
        String busqueda = textBusqueda.getText().trim();
        String sql;
         
        try{

         if (!textBusqueda.equals("") && statusBuscado.equals("Activo")) {
                sql = "select id_importador, empleado, empresa, mail, "
                        + "numero_contacto, pais, status from importadores where empresa = '"
                        + busqueda + "' or empleado = '" + busqueda + "' and status = 'Activo'";
                cargarTablaImportadores(sql);
            } else if (textBusqueda.equals("") && statusBuscado.equals("Activo")) {
                sql = "select id_importador, empleado, empresa, mail, "
                        + "numero_contacto, pais, status from importadores where status = 'Activo'";
                cargarTablaImportadores(sql);
            }

     
           if (!textBusqueda.equals("") && statusBuscado.equals("Inactivo")) {
                sql = "select id_importador, empleado, empresa, mail, "
                        + "numero_contacto, pais, status from importadores where empresa = '"
                        + busqueda + "' or empleado = '" + busqueda + "' and status = 'Inactivo'";
                cargarTablaImportadores(sql);
            } else if (textBusqueda.equals("") && statusBuscado.equals("Inactivo")) {
                sql = "select id_importador, empleado, empresa, mail, "
                        + "numero_contacto, pais, status from importadores where status = 'Inactivo'";
                cargarTablaImportadores(sql);
            } else if (!textBusqueda.equals("") && statusBuscado.equals("Suspendido")) {
                sql = "select id_importador, empleado, empresa, mail, "
                        + "numero_contacto, pais, status from importadores where empresa = '"
                        + busqueda + "' or empleado = '" + busqueda + "' and status = 'Suspendido'";
                cargarTablaImportadores(sql);
            } else if (textBusqueda.equals("") && statusBuscado.equals("Suspendido")) {
                sql = "select id_importador, empleado, empresa, mail, "
                        + "numero_contacto, pais, status from importadores where status = 'Suspendido'";
                cargarTablaImportadores(sql);
            }
          
        }catch(Exception e){
            System.err.println("Error al buscar por filtros" + e);
            JOptionPane.showMessageDialog(null, "No es posibe buscar por filtros");
        }
        
        
    }//GEN-LAST:event_jToggleButtonFiltrarActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
       
        LimpiarBusqueda();
        mostrarTodosLosDatos();
        
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButtonVolver1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolver1ActionPerformed
       
        InformacionImportador infoImportador = new InformacionImportador();
        infoImportador.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButtonVolver1ActionPerformed

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
            java.util.logging.Logger.getLogger(ListaImportadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaImportadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaImportadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaImportadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaImportadores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JButton jButtonVolver1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelBusqueda;
    private javax.swing.JLabel jLabelFijo;
    private javax.swing.JLabel jLabelHabilitar;
    private javax.swing.JLabel jLabelPersonalizado;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelOpciones;
    private javax.swing.JPanel jPanelTabla;
    private javax.swing.JPanel jPanelTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableImportadores;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButtonFiltrar;
    private javax.swing.JTextField textBusqueda;
    // End of variables declaration//GEN-END:variables
}
