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
import service.ContenedoresImpl;
import service.DespachantesImpl;
import service.ExportadoresImpl;
import service.ImportadoresImpl;
import service.OperacionInternacionalParticipantesImpl;
import service.StockImpl;

/**
 *
 * @author Daniela
 */
public class CompradoresVendedoresNacionales extends javax.swing.JFrame {

     String usuario = "", rol = "", nombreCompleto = "";
    /**
     * Creates new form CompradoresVendedoresNacionales
     */
    public CompradoresVendedoresNacionales() {
        initComponents();
        
        setSize(850, 500);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        
        PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
        
        usuario = paginaPrincipal.usuario;
        nombreCompleto = paginaPrincipal.nombreCompleto;
        
        setTitle("Compradores y vendedores nacionales - " + usuario + " - sistema ComexApp");

        jPanelRegistrar.setVisible(false);
        jPanelModificar.setVisible(false);
        jPanelEliminar.setVisible(false);
        jPanelVer.setVisible(true);

        mostrarTodosLasAsociaciones();
    }

    // icono
    public Image getLogo(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/loguito1.png"));
        return retValue;   
    }
    
    ContenedoresImpl contenedoresImpl = new ContenedoresImpl();
    StockImpl stockImpl = new StockImpl();
    DespachantesImpl despachantesImpl = new DespachantesImpl();
    ExportadoresImpl exportadoresImpl = new ExportadoresImpl();
    ImportadoresImpl importadoresImpl = new ImportadoresImpl();
    OperacionInternacionalParticipantesImpl participantes = new OperacionInternacionalParticipantesImpl();
    
    // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;

    
    
    public void cargarTablaAsociados(String sql){

        DefaultTableModel modelo = new DefaultTableModel();
      
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            jTableCompradorVendedor = new JTable(modelo);
            jScrollPane1.setViewportView(jTableCompradorVendedor);
            
            modelo.addColumn("N° operación internacional");
            modelo.addColumn("Contenedor");
            modelo.addColumn("Despachante");
            modelo.addColumn("Exportador");
            modelo.addColumn("Importador");
            modelo.addColumn("Producto");
            modelo.addColumn("Transporte");
            
            while(rs.next()){
                Object[] fila = new Object[7];
                for(int i = 0; i < 7; i++){
                    fila[i] = rs.getObject(i + 1);
                }
               modelo.addRow(fila);
            }
            
            conec.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al cargar tabla");
            System.err.println("Error al cargar la tabla " + e);
        }
    }

   
     public void mostrarTodosLasAsociaciones(){
         String sql = "select numero_opint, id_contenedor, id_despachante, "
                 + "id_exportador, id_importador, id_producto, id_transporte "
                 + "from participantes_opint order by numero_opint asc";
        cargarTablaAsociados(sql);
    }
     
     
   
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelVer = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCompradorVendedor = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButtonVolver = new javax.swing.JButton();
        jButtonRegistrar = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonVer = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanelRegistrar = new javax.swing.JPanel();
        jButtonAsociarCont = new javax.swing.JButton();
        textCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanelModificar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButtonAsociarStock = new javax.swing.JButton();
        textProducto = new javax.swing.JTextField();
        textCodigoProducto = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        textVendedor = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanelEliminar = new javax.swing.JPanel();
        textExportador = new javax.swing.JTextField();
        jButtonAsociarExp = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButtonAsociarImp = new javax.swing.JButton();
        textImportador = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButtonAsociarDesp = new javax.swing.JButton();
        textEmpresaDes = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        textDespachante = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        textEmpresaIm = new javax.swing.JTextField();
        textEmpresaEx = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getLogo());
        setIconImages(getIconImages());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelVer.setBackground(new java.awt.Color(255, 255, 255));
        jPanelVer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableCompradorVendedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jTableCompradorVendedor.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTableCompradorVendedor.setEnabled(false);
        jTableCompradorVendedor.setSelectionBackground(new java.awt.Color(0, 0, 153));
        jTableCompradorVendedor.setSelectionForeground(new java.awt.Color(0, 0, 153));
        jTableCompradorVendedor.setShowHorizontalLines(true);
        jScrollPane1.setViewportView(jTableCompradorVendedor);

        jPanelVer.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 30, 610, -1));

        getContentPane().add(jPanelVer, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 640, 500));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 153));
        jPanel2.setForeground(new java.awt.Color(0, 0, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonVolver.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonVolver.setForeground(new java.awt.Color(0, 0, 153));
        jButtonVolver.setText("Volver");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 110, -1));

        jButtonRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonRegistrar.setForeground(new java.awt.Color(0, 0, 153));
        jButtonRegistrar.setText("Registrar");
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 170, 20));

        jButtonModificar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonModificar.setForeground(new java.awt.Color(0, 0, 153));
        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 170, 20));

        jButtonEliminar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonEliminar.setForeground(new java.awt.Color(0, 0, 153));
        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 170, 20));

        jButtonVer.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonVer.setForeground(new java.awt.Color(0, 0, 153));
        jButtonVer.setText("Visualizar");
        jButtonVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonVer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 170, 20));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Participantes");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 140, 20));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("nacionales");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 100, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 500));

        jPanelRegistrar.setBackground(new java.awt.Color(255, 255, 255));
        jPanelRegistrar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonAsociarCont.setBackground(new java.awt.Color(0, 0, 153));
        jButtonAsociarCont.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonAsociarCont.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAsociarCont.setText("Registrar");
        jButtonAsociarCont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAsociarContActionPerformed(evt);
            }
        });
        jPanelRegistrar.add(jButtonAsociarCont, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, -1, 25));

        textCodigo.setForeground(new java.awt.Color(0, 0, 153));
        jPanelRegistrar.add(textCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 140, 150, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Código de contenedor:");
        jPanelRegistrar.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        jPanel1.add(jPanelRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 490, 500));

        jPanelModificar.setBackground(new java.awt.Color(255, 255, 255));
        jPanelModificar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("Producto:");
        jPanelModificar.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        jButtonAsociarStock.setBackground(new java.awt.Color(0, 0, 153));
        jButtonAsociarStock.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonAsociarStock.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAsociarStock.setText("Asociar al stock");
        jButtonAsociarStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAsociarStockActionPerformed(evt);
            }
        });
        jPanelModificar.add(jButtonAsociarStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, -1, 25));

        textProducto.setForeground(new java.awt.Color(0, 0, 153));
        jPanelModificar.add(textProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 150, -1));

        textCodigoProducto.setForeground(new java.awt.Color(0, 0, 153));
        jPanelModificar.add(textCodigoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 150, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 153));
        jLabel9.setText("Código del producto:");
        jPanelModificar.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        textVendedor.setForeground(new java.awt.Color(0, 0, 153));
        jPanelModificar.add(textVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 150, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 153));
        jLabel10.setText("Vendedor:");
        jPanelModificar.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 153));
        jLabel11.setText("Es necesario completar todos estos datos para asociar al producto debido.");
        jPanelModificar.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        jPanel1.add(jPanelModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 490, 500));

        jPanelEliminar.setBackground(new java.awt.Color(255, 255, 255));
        jPanelEliminar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textExportador.setForeground(new java.awt.Color(0, 0, 153));
        jPanelEliminar.add(textExportador, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 150, -1));

        jButtonAsociarExp.setBackground(new java.awt.Color(0, 0, 153));
        jButtonAsociarExp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonAsociarExp.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAsociarExp.setText("Asociar al exportador");
        jButtonAsociarExp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAsociarExpActionPerformed(evt);
            }
        });
        jPanelEliminar.add(jButtonAsociarExp, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 190, 25));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("Exportador:");
        jPanelEliminar.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        jButtonAsociarImp.setBackground(new java.awt.Color(0, 0, 153));
        jButtonAsociarImp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonAsociarImp.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAsociarImp.setText("Asociar al importador");
        jButtonAsociarImp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAsociarImpActionPerformed(evt);
            }
        });
        jPanelEliminar.add(jButtonAsociarImp, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 190, 25));

        textImportador.setForeground(new java.awt.Color(0, 0, 153));
        jPanelEliminar.add(textImportador, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 150, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        jLabel5.setText("Importador:");
        jPanelEliminar.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, -1));

        jButtonAsociarDesp.setBackground(new java.awt.Color(0, 0, 153));
        jButtonAsociarDesp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonAsociarDesp.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAsociarDesp.setText("Asociar al despachante");
        jButtonAsociarDesp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAsociarDespActionPerformed(evt);
            }
        });
        jPanelEliminar.add(jButtonAsociarDesp, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, -1, 25));

        textEmpresaDes.setForeground(new java.awt.Color(0, 0, 153));
        jPanelEliminar.add(textEmpresaDes, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 150, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 153));
        jLabel6.setText("Empresa despachante:");
        jPanelEliminar.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 153));
        jLabel7.setText("Por favor, elige un participante ");
        jPanelEliminar.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 153));
        jLabel8.setText("de la operación internacional");
        jPanelEliminar.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 153));
        jLabel12.setText("Despachante:");
        jPanelEliminar.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        textDespachante.setForeground(new java.awt.Color(0, 0, 153));
        jPanelEliminar.add(textDespachante, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 150, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 153));
        jLabel13.setText("Empresa importador:");
        jPanelEliminar.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, -1));

        textEmpresaIm.setForeground(new java.awt.Color(0, 0, 153));
        jPanelEliminar.add(textEmpresaIm, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 150, -1));

        textEmpresaEx.setForeground(new java.awt.Color(0, 0, 153));
        jPanelEliminar.add(textEmpresaEx, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 150, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 153));
        jLabel14.setText("Empresa exportador:");
        jPanelEliminar.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));

        jPanel1.add(jPanelEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 490, 500));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 880));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
        
        this.dispose();
        
    }//GEN-LAST:event_jButtonVolverActionPerformed

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed
        
        jPanelRegistrar.setVisible(true);
        jPanelModificar.setVisible(false);
        jPanelEliminar.setVisible(false);
        jPanelVer.setVisible(false);
                
    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        
        jPanelRegistrar.setVisible(false);
        jPanelModificar.setVisible(true);
        jPanelEliminar.setVisible(false);
        jPanelVer.setVisible(false);
        
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        
        jPanelRegistrar.setVisible(false);
        jPanelModificar.setVisible(false);
        jPanelEliminar.setVisible(true);
        jPanelVer.setVisible(false);
        
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerActionPerformed
        
        jPanelRegistrar.setVisible(false);
        jPanelModificar.setVisible(false);
        jPanelEliminar.setVisible(false);
        jPanelVer.setVisible(false);
        
    }//GEN-LAST:event_jButtonVerActionPerformed

    private void jButtonAsociarStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAsociarStockActionPerformed
        
        String producto, vendedor, codigo;
        int ID;
        
        producto = textProducto.getText().trim();
        vendedor = textVendedor.getText().trim();
        codigo = textCodigoProducto.getText().trim();
        
        ID = Integer.parseInt(textID.getText().trim());
        
        int IDProducto = stockImpl.obtenerIDProducto(codigo, vendedor, producto);
        participantes.agregarIDProducto(IDProducto, ID);
        stockImpl.asociarCantidadesAOperacionInternacional(producto, vendedor, codigo, ID);
        
    }//GEN-LAST:event_jButtonAsociarStockActionPerformed

    private void jButtonAsociarContActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAsociarContActionPerformed
        
        String codigo = textCodigo.getText().trim();
        int ID = Integer.parseInt(textID.getText().trim());
        
        int IDContenedor = contenedoresImpl.obtenerIDConCodigoDelContenedor(codigo);
        participantes.agregarIDContenedor(IDContenedor, ID);
        
    }//GEN-LAST:event_jButtonAsociarContActionPerformed

    private void jButtonAsociarDespActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAsociarDespActionPerformed
        
        String empresaDes, despachante;
        int ID;
        
        empresaDes = textEmpresaDes.getText().trim();
        despachante = textDespachante.getText().trim();
        
        ID = Integer.parseInt(textID.getText().trim());
        
        int IDDespachante = despachantesImpl.obtenerIDDespachante(empresaDes, despachante);
        participantes.agregarIDDespachante(IDDespachante, ID);
        
    }//GEN-LAST:event_jButtonAsociarDespActionPerformed

    private void jButtonAsociarExpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAsociarExpActionPerformed
       
        String empresaEx, exportador;
        int ID;
        
        empresaEx = textEmpresaEx.getText().trim();
        exportador = textExportador.getText().trim();
        
        ID = Integer.parseInt(textID.getText().trim());
        
        int IDExportador = exportadoresImpl.obtenerIDExportador(empresaEx, exportador);
        participantes.agregarIDExportador(IDExportador, ID);
        
    }//GEN-LAST:event_jButtonAsociarExpActionPerformed

    private void jButtonAsociarImpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAsociarImpActionPerformed
        
        String empresaImp, importador;
        int ID;
        
        empresaImp = textEmpresaIm.getText().trim();
        importador = textImportador.getText().trim();
        
        ID = Integer.parseInt(textID.getText().trim());
        
        int IDImportador = importadoresImpl.obtenerIDImportador(empresaImp, importador);
        participantes.agregarIDImportador(IDImportador, ID);
        
    }//GEN-LAST:event_jButtonAsociarImpActionPerformed

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
            java.util.logging.Logger.getLogger(CompradoresVendedoresNacionales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CompradoresVendedoresNacionales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CompradoresVendedoresNacionales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CompradoresVendedoresNacionales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CompradoresVendedoresNacionales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAsociarCont;
    private javax.swing.JButton jButtonAsociarDesp;
    private javax.swing.JButton jButtonAsociarExp;
    private javax.swing.JButton jButtonAsociarImp;
    private javax.swing.JButton jButtonAsociarStock;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JButton jButtonVer;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelEliminar;
    private javax.swing.JPanel jPanelModificar;
    private javax.swing.JPanel jPanelRegistrar;
    private javax.swing.JPanel jPanelVer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCompradorVendedor;
    private javax.swing.JTextField textCodigo;
    private javax.swing.JTextField textCodigoProducto;
    private javax.swing.JTextField textDespachante;
    private javax.swing.JTextField textEmpresaDes;
    private javax.swing.JTextField textEmpresaEx;
    private javax.swing.JTextField textEmpresaIm;
    private javax.swing.JTextField textExportador;
    private javax.swing.JTextField textImportador;
    private javax.swing.JTextField textProducto;
    private javax.swing.JTextField textVendedor;
    // End of variables declaration//GEN-END:variables
}