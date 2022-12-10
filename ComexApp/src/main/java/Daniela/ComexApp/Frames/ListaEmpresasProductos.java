package Daniela.ComexApp.Frames;

import config.Conexion;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
public class ListaEmpresasProductos extends javax.swing.JFrame {

    /**
     * Creates new form ListaEmpresasProductos
     */
    public ListaEmpresasProductos() {
        initComponents();
        
        setSize(1200, 750);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        
        setTitle("Lista de productos pedidos de empresas importadoras - Sistema ComexApp");
        
        mostrarTodosLosDatos();
        pasarCamposDeLaTablaAFields();
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
       
       
       
    public void cargarTablaUsuarios(String sql){

        DefaultTableModel modelo = new DefaultTableModel();
      
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            jTableLista = new JTable(modelo);
            jScrollPane1.setViewportView(jTableLista);
            
            modelo.addColumn("ID");
            modelo.addColumn("CUIT");
            modelo.addColumn("Empresa");
            modelo.addColumn("Productos pedidos");
            
            while(rs.next()){
                Object[] fila = new Object[4];
                for(int i = 0; i < 4; i++){
                    fila[i] = rs.getObject(i + 1);
                }
               modelo.addRow(fila);
            }
            
            conec.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al cargar tabla de empresas importadoras");
            System.err.println("Error al cargar tabla de empresas importadoras " + e);
        }
    }

    //  String sql = "select id_importador, cuit, empleado, empresa, mail, "
             //   + "numero_contacto, pais, productos_pedidos, status from importadores";
     public void mostrarTodosLosDatos(){
        String sql = "select id_importador, cuit, empresa, productos_pedidos from importadores";
        cargarTablaUsuarios(sql);
    }
    
     // método para poner los datos de la tabla en los textfields.
     public void pasarCamposDeLaTablaAFields(){
    
        jTableLista.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent Mouse_evt){
                
                JTable tablaLista = (JTable) Mouse_evt.getSource();
                Point point = Mouse_evt.getPoint();
    
                int filaSeleccionada = tablaLista.rowAtPoint(point);

                if(Mouse_evt.getClickCount() == 1){
                  textID.setText(jTableLista.getValueAt(jTableLista.getSelectedRow(), 0).toString()); 
                  textCUIT.setText(jTableLista.getValueAt(jTableLista.getSelectedRow(), 1).toString());
                  textEmpresa.setText(jTableLista.getValueAt(jTableLista.getSelectedRow(), 2).toString());
                  textProductos.setText(jTableLista.getValueAt(jTableLista.getSelectedRow(), 3).toString());
                }
            }
        });
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
        jLabelTitulo1 = new javax.swing.JLabel();
        jPanelTabla = new javax.swing.JPanel();
        jLabelSubt = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLista = new javax.swing.JTable();
        jLabelEmpresa = new javax.swing.JLabel();
        textEmpresa = new javax.swing.JTextField();
        jLabelCuit = new javax.swing.JLabel();
        textCUIT = new javax.swing.JTextField();
        jLabelID = new javax.swing.JLabel();
        textID = new javax.swing.JTextField();
        jLabelProductos = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textProductos = new javax.swing.JTextArea();
        jPanelBotones = new javax.swing.JPanel();
        jButtonVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getLogo());
        setIconImages(getIconImages());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(0, 0, 153));
        jLabelTitulo.setText("Lista de productos pedidos ");
        jPanelTitulo.add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, -1));

        jLabelTitulo1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabelTitulo1.setForeground(new java.awt.Color(0, 0, 153));
        jLabelTitulo1.setText("por las empresas importadoras");
        jPanelTitulo.add(jLabelTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, -1, -1));

        getContentPane().add(jPanelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 140));

        jPanelTabla.setBackground(new java.awt.Color(0, 0, 153));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        jPanelTabla.setBorder(dropShadowBorder1);
        jPanelTabla.setForeground(new java.awt.Color(0, 0, 153));
        jPanelTabla.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelSubt.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabelSubt.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSubt.setText("Datos de la empresa elegida:");
        jPanelTabla.add(jLabelSubt, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, -1, -1));

        jTableLista.setBackground(new java.awt.Color(204, 204, 204));
        jTableLista.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTableLista.setForeground(new java.awt.Color(0, 0, 153));
        jTableLista.setModel(jTableLista.getModel());
        jScrollPane1.setViewportView(jTableLista);

        jPanelTabla.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 589, -1));

        jLabelEmpresa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEmpresa.setText("Empresa:");
        jPanelTabla.add(jLabelEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 50, -1, -1));

        textEmpresa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textEmpresa.setForeground(new java.awt.Color(0, 0, 153));
        textEmpresa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelTabla.add(textEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 80, 190, -1));

        jLabelCuit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelCuit.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCuit.setText("CUIT:");
        jPanelTabla.add(jLabelCuit, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 50, -1, -1));

        textCUIT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textCUIT.setForeground(new java.awt.Color(0, 0, 153));
        textCUIT.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelTabla.add(textCUIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 80, 208, -1));

        jLabelID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelID.setForeground(new java.awt.Color(255, 255, 255));
        jLabelID.setText("ID:");
        jPanelTabla.add(jLabelID, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 340, -1, -1));

        textID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textID.setForeground(new java.awt.Color(0, 0, 153));
        textID.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelTabla.add(textID, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 370, 100, -1));

        jLabelProductos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelProductos.setForeground(new java.awt.Color(255, 255, 255));
        jLabelProductos.setText("Productos que suele pedir:");
        jPanelTabla.add(jLabelProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 130, -1, 20));

        jScrollPane2.setForeground(new java.awt.Color(0, 0, 153));

        textProductos.setColumns(20);
        textProductos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textProductos.setForeground(new java.awt.Color(0, 0, 153));
        textProductos.setRows(5);
        jScrollPane2.setViewportView(textProductos);

        jPanelTabla.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 160, 470, 170));

        getContentPane().add(jPanelTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 1200, 460));

        jPanelBotones.setBackground(new java.awt.Color(255, 255, 255));

        jButtonVolver.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonVolver.setForeground(new java.awt.Color(0, 0, 153));
        jButtonVolver.setText("Volver atrás");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBotonesLayout = new javax.swing.GroupLayout(jPanelBotones);
        jPanelBotones.setLayout(jPanelBotonesLayout);
        jPanelBotonesLayout.setHorizontalGroup(
            jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonesLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jButtonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(971, Short.MAX_VALUE))
        );
        jPanelBotonesLayout.setVerticalGroup(
            jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonesLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jButtonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelBotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, 1200, 150));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed

        Importadores importadores = new Importadores();
        importadores.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButtonVolverActionPerformed

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
            java.util.logging.Logger.getLogger(ListaEmpresasProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaEmpresasProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaEmpresasProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaEmpresasProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaEmpresasProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JLabel jLabelCuit;
    private javax.swing.JLabel jLabelEmpresa;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelProductos;
    private javax.swing.JLabel jLabelSubt;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelTitulo1;
    private javax.swing.JPanel jPanelBotones;
    private javax.swing.JPanel jPanelTabla;
    private javax.swing.JPanel jPanelTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableLista;
    private javax.swing.JTextField textCUIT;
    private javax.swing.JTextField textEmpresa;
    private javax.swing.JTextField textID;
    private javax.swing.JTextArea textProductos;
    // End of variables declaration//GEN-END:variables
}
