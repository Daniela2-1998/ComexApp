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
import service.CompradoresVendedoresNacionalesImpl;

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

         mostrarTodosLosNacionales();
    }

    // icono
    public Image getLogo(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/loguito1.png"));
        return retValue;   
    }
    
    CompradoresVendedoresNacionalesImpl comVenNacImpl = new CompradoresVendedoresNacionalesImpl();

    
    // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;

    
    
    public void cargarTablaNacionales(String sql){

        DefaultTableModel modelo = new DefaultTableModel();
      
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            jTableCompradorVendedor = new JTable(modelo);
            jScrollPane1.setViewportView(jTableCompradorVendedor);
            
            modelo.addColumn("ID");
            modelo.addColumn("Nombre");
            modelo.addColumn("Empresa");
            modelo.addColumn("País");
            modelo.addColumn("Cargo");
            modelo.addColumn("Mail");
            modelo.addColumn("Número");
            modelo.addColumn("Status");
            
            while(rs.next()){
                Object[] fila = new Object[8];
                for(int i = 0; i < 8; i++){
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

   
     public void mostrarTodosLosNacionales(){
         String sql = "select id_part_nac, nombre, empresa, pais, tipo_operacion, "
                 + "mail, numero_contacto, status from participantes_nacionales "
                 + "order by id_part_nac asc";
        cargarTablaNacionales(sql);
    }
     
     
   public void LimpiarCampos(){
       textNombre.setText("");
       textEmpresa.setText("");
       textPais.setText("");
       textMail.setText("");
       textTel.setText("");
       textProductos.setText("");
       cmbStatus.setSelectedIndex(0);
       cmbOperacion.setSelectedIndex(0);
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
        jButtonActualizar = new javax.swing.JButton();
        jPanelRegistrar = new javax.swing.JPanel();
        jButtonAsociarCont = new javax.swing.JButton();
        textEmpresa = new javax.swing.JTextField();
        jLabelEmpresa = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        jLabelPais = new javax.swing.JLabel();
        textPais = new javax.swing.JTextField();
        jLabelOp = new javax.swing.JLabel();
        cmbOperacion = new javax.swing.JComboBox<>();
        jLabelMail = new javax.swing.JLabel();
        textMail = new javax.swing.JTextField();
        jLabelTel = new javax.swing.JLabel();
        textTel = new javax.swing.JTextField();
        jLabelProductos = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textProductos = new javax.swing.JTextArea();
        jLabelOp1 = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        jPanelModificar = new javax.swing.JPanel();
        jButtonModificar1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabelNombre1 = new javax.swing.JLabel();
        textNombre2 = new javax.swing.JTextField();
        jLabelEmpresa1 = new javax.swing.JLabel();
        textEmpresa1 = new javax.swing.JTextField();
        jLabelPais1 = new javax.swing.JLabel();
        textPais1 = new javax.swing.JTextField();
        cmbOperacion1 = new javax.swing.JComboBox<>();
        jLabelOp2 = new javax.swing.JLabel();
        cmbStatus1 = new javax.swing.JComboBox<>();
        jLabelOp3 = new javax.swing.JLabel();
        jLabelMail1 = new javax.swing.JLabel();
        textMail1 = new javax.swing.JTextField();
        jLabelTel1 = new javax.swing.JLabel();
        textTel1 = new javax.swing.JTextField();
        jLabelProductos1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textProductos1 = new javax.swing.JTextArea();
        textBuscar = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jPanelEliminar = new javax.swing.JPanel();
        textNombre1 = new javax.swing.JTextField();
        jButtonEliminar1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textID = new javax.swing.JTextField();
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

        jButtonActualizar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonActualizar.setForeground(new java.awt.Color(0, 0, 153));
        jButtonActualizar.setText("Recargar tabla");
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 170, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 500));

        jPanelRegistrar.setBackground(new java.awt.Color(255, 255, 255));
        jPanelRegistrar.setForeground(new java.awt.Color(0, 0, 153));
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
        jPanelRegistrar.add(jButtonAsociarCont, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, -1, 25));

        textEmpresa.setForeground(new java.awt.Color(0, 0, 153));
        jPanelRegistrar.add(textEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 150, -1));

        jLabelEmpresa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelEmpresa.setForeground(new java.awt.Color(0, 0, 153));
        jLabelEmpresa.setText("Empresa:");
        jPanelRegistrar.add(jLabelEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setText("Completa los datos para el registro");
        jPanelRegistrar.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 310, 30));

        jLabelNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNombre.setForeground(new java.awt.Color(0, 0, 153));
        jLabelNombre.setText("Nombre:");
        jPanelRegistrar.add(jLabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        textNombre.setForeground(new java.awt.Color(0, 0, 153));
        jPanelRegistrar.add(textNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 150, -1));

        jLabelPais.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelPais.setForeground(new java.awt.Color(0, 0, 153));
        jLabelPais.setText("País:");
        jPanelRegistrar.add(jLabelPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        textPais.setForeground(new java.awt.Color(0, 0, 153));
        jPanelRegistrar.add(textPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 150, -1));

        jLabelOp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelOp.setForeground(new java.awt.Color(0, 0, 153));
        jLabelOp.setText("Tipo de operaciones:");
        jPanelRegistrar.add(jLabelOp, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        cmbOperacion.setForeground(new java.awt.Color(0, 0, 153));
        cmbOperacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Comprador", "Vendedor" }));
        cmbOperacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOperacionActionPerformed(evt);
            }
        });
        jPanelRegistrar.add(cmbOperacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 150, -1));

        jLabelMail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelMail.setForeground(new java.awt.Color(0, 0, 153));
        jLabelMail.setText("Mail:");
        jPanelRegistrar.add(jLabelMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, -1, -1));

        textMail.setForeground(new java.awt.Color(0, 0, 153));
        jPanelRegistrar.add(textMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 190, -1));

        jLabelTel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTel.setForeground(new java.awt.Color(0, 0, 153));
        jLabelTel.setText("Teléfono/celular:");
        jPanelRegistrar.add(jLabelTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, -1, -1));

        textTel.setForeground(new java.awt.Color(0, 0, 153));
        jPanelRegistrar.add(textTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 190, -1));

        jLabelProductos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelProductos.setForeground(new java.awt.Color(0, 0, 153));
        jLabelProductos.setText("Productos asociados:");
        jPanelRegistrar.add(jLabelProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, -1, -1));

        jScrollPane2.setForeground(new java.awt.Color(0, 0, 153));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        textProductos.setColumns(20);
        textProductos.setForeground(new java.awt.Color(0, 0, 153));
        textProductos.setRows(5);
        jScrollPane2.setViewportView(textProductos);

        jPanelRegistrar.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 200, -1));

        jLabelOp1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelOp1.setForeground(new java.awt.Color(0, 0, 153));
        jLabelOp1.setText("Status:");
        jPanelRegistrar.add(jLabelOp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        cmbStatus.setForeground(new java.awt.Color(0, 0, 153));
        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        jPanelRegistrar.add(cmbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 150, -1));

        jPanel1.add(jPanelRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 490, 500));

        jPanelModificar.setBackground(new java.awt.Color(255, 255, 255));
        jPanelModificar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonModificar1.setBackground(new java.awt.Color(0, 0, 153));
        jButtonModificar1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonModificar1.setForeground(new java.awt.Color(255, 255, 255));
        jButtonModificar1.setText("Modificar");
        jButtonModificar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificar1ActionPerformed(evt);
            }
        });
        jPanelModificar.add(jButtonModificar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, -1, 25));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        jLabel5.setText("Completa los datos a modificar de");
        jPanelModificar.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 270, 30));

        jLabelNombre1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNombre1.setForeground(new java.awt.Color(0, 0, 153));
        jLabelNombre1.setText("Nombre:");
        jPanelModificar.add(jLabelNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        textNombre2.setForeground(new java.awt.Color(0, 0, 153));
        jPanelModificar.add(textNombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 150, -1));

        jLabelEmpresa1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelEmpresa1.setForeground(new java.awt.Color(0, 0, 153));
        jLabelEmpresa1.setText("Empresa:");
        jPanelModificar.add(jLabelEmpresa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        textEmpresa1.setForeground(new java.awt.Color(0, 0, 153));
        jPanelModificar.add(textEmpresa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 150, -1));

        jLabelPais1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelPais1.setForeground(new java.awt.Color(0, 0, 153));
        jLabelPais1.setText("País:");
        jPanelModificar.add(jLabelPais1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        textPais1.setForeground(new java.awt.Color(0, 0, 153));
        jPanelModificar.add(textPais1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 150, -1));

        cmbOperacion1.setForeground(new java.awt.Color(0, 0, 153));
        cmbOperacion1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Comprador", "Vendedor" }));
        jPanelModificar.add(cmbOperacion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 150, -1));

        jLabelOp2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelOp2.setForeground(new java.awt.Color(0, 0, 153));
        jLabelOp2.setText("Tipo de operaciones:");
        jPanelModificar.add(jLabelOp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        cmbStatus1.setForeground(new java.awt.Color(0, 0, 153));
        cmbStatus1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        jPanelModificar.add(cmbStatus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 150, -1));

        jLabelOp3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelOp3.setForeground(new java.awt.Color(0, 0, 153));
        jLabelOp3.setText("Status:");
        jPanelModificar.add(jLabelOp3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        jLabelMail1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelMail1.setForeground(new java.awt.Color(0, 0, 153));
        jLabelMail1.setText("Mail:");
        jPanelModificar.add(jLabelMail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, -1, -1));

        textMail1.setForeground(new java.awt.Color(0, 0, 153));
        jPanelModificar.add(textMail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 190, -1));

        jLabelTel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabelTel1.setText("Teléfono/celular:");
        jPanelModificar.add(jLabelTel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, -1, -1));

        textTel1.setForeground(new java.awt.Color(0, 0, 153));
        jPanelModificar.add(textTel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 190, -1));

        jLabelProductos1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelProductos1.setForeground(new java.awt.Color(0, 0, 153));
        jLabelProductos1.setText("Productos asociados:");
        jPanelModificar.add(jLabelProductos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, -1, -1));

        jScrollPane3.setForeground(new java.awt.Color(0, 0, 153));
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        textProductos1.setColumns(20);
        textProductos1.setForeground(new java.awt.Color(0, 0, 153));
        textProductos1.setRows(5);
        jScrollPane3.setViewportView(textProductos1);

        jPanelModificar.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 200, -1));

        textBuscar.setForeground(new java.awt.Color(0, 0, 153));
        jPanelModificar.add(textBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 160, -1));

        jButtonBuscar.setBackground(new java.awt.Color(0, 0, 153));
        jButtonBuscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        jPanelModificar.add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, -1, 20));

        jPanel1.add(jPanelModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 490, 500));

        jPanelEliminar.setBackground(new java.awt.Color(255, 255, 255));
        jPanelEliminar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textNombre1.setForeground(new java.awt.Color(0, 0, 153));
        jPanelEliminar.add(textNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 150, -1));

        jButtonEliminar1.setBackground(new java.awt.Color(0, 0, 153));
        jButtonEliminar1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonEliminar1.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEliminar1.setText("Eliminar");
        jButtonEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminar1ActionPerformed(evt);
            }
        });
        jPanelEliminar.add(jButtonEliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 190, 25));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("Nombre:");
        jPanelEliminar.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 153));
        jLabel7.setText("Coloca nombre del contacto a eliminar");
        jPanelEliminar.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        textID.setForeground(new java.awt.Color(0, 0, 153));
        jPanelEliminar.add(textID, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 150, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 153));
        jLabel14.setText("ID:");
        jPanelEliminar.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));

        jPanel1.add(jPanelEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 490, 500));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 880));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
        
        Operaciones operaciones = new Operaciones();
        operaciones.setVisible(true);
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
        jPanelVer.setVisible(true);
        
    }//GEN-LAST:event_jButtonVerActionPerformed

    private void jButtonAsociarContActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAsociarContActionPerformed
       
        String nombre, empresa, mail, pais, productos, status = null, 
                operacion = null, telefono;
        int statusNivel = 0, operacionNivel = 0;
        Boolean recepcion;
        
        nombre = textNombre.getText().trim();
        empresa = textEmpresa.getText().trim();
        mail = textMail.getText().trim();
        productos = textProductos.getText().trim();
        telefono = textTel.getText().trim();
        pais = textPais.getText().trim();
        
        statusNivel = cmbStatus.getSelectedIndex() + 1;
        operacionNivel = cmbOperacion.getSelectedIndex() + 1;
        
        if(statusNivel == 1){
           status = "Activo";
        } else if (statusNivel == 2){
           status = "Inactivo";
        } 
         
        if(operacionNivel == 1){
           operacion = "Comprador";
        } else if (operacionNivel == 2){
           operacion = "Vendedor";
        } 
        
        recepcion = comVenNacImpl.registroCompradorVendedor(nombre, empresa, 
                pais, mail, telefono, productos, status, operacion);
        if(recepcion.equals(true)){
           LimpiarCampos();
        }
         
    }//GEN-LAST:event_jButtonAsociarContActionPerformed

    private void jButtonEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminar1ActionPerformed

        String nombre = textNombre1.getText().trim();
        int ID = Integer.parseInt(textID.getText().trim());
        
        comVenNacImpl.eliminar(nombre, ID);
    
    }//GEN-LAST:event_jButtonEliminar1ActionPerformed

    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed
        
        mostrarTodosLosNacionales();
        
    }//GEN-LAST:event_jButtonActualizarActionPerformed

    private void jButtonModificar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificar1ActionPerformed

        String nombre, empresa, mail, pais, productos, status = null,
        operacion = null, telefono;
        int statusNivel = 0, operacionNivel = 0;

        String buscado = textBuscar.getText().trim();
        nombre = textNombre2.getText().trim();
        empresa = textEmpresa1.getText().trim();
        mail = textMail1.getText().trim();
        productos = textProductos1.getText().trim();
        telefono = textTel1.getText().trim();
        pais = textPais1.getText().trim();

        statusNivel = cmbStatus1.getSelectedIndex() + 1;
        operacionNivel = cmbOperacion1.getSelectedIndex() + 1;

        if(statusNivel == 1){
            status = "Activo";
        } else if (statusNivel == 2){
            status = "Inactivo";
        }

        if(operacionNivel == 1){
            operacion = "Comprador";
        } else if (operacionNivel == 2){
            operacion = "Vendedor";
        }

        comVenNacImpl.modificarDatos(buscado, nombre, empresa, pais, mail, telefono, 
                productos, status, operacion);

    }//GEN-LAST:event_jButtonModificar1ActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
       
        String buscado = textBuscar.getText().trim();
        
        comVenNacImpl.obtenerDatosCompradorVendedor(buscado, textNombre1, textEmpresa1, 
                textMail1, textTel1, textPais1, textProductos1, cmbStatus1, cmbOperacion1);
        
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void cmbOperacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOperacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbOperacionActionPerformed

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
    private javax.swing.JComboBox<String> cmbOperacion;
    private javax.swing.JComboBox<String> cmbOperacion1;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JComboBox<String> cmbStatus1;
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JButton jButtonAsociarCont;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonEliminar1;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonModificar1;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JButton jButtonVer;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelEmpresa;
    private javax.swing.JLabel jLabelEmpresa1;
    private javax.swing.JLabel jLabelMail;
    private javax.swing.JLabel jLabelMail1;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelNombre1;
    private javax.swing.JLabel jLabelOp;
    private javax.swing.JLabel jLabelOp1;
    private javax.swing.JLabel jLabelOp2;
    private javax.swing.JLabel jLabelOp3;
    private javax.swing.JLabel jLabelPais;
    private javax.swing.JLabel jLabelPais1;
    private javax.swing.JLabel jLabelProductos;
    private javax.swing.JLabel jLabelProductos1;
    private javax.swing.JLabel jLabelTel;
    private javax.swing.JLabel jLabelTel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelEliminar;
    private javax.swing.JPanel jPanelModificar;
    private javax.swing.JPanel jPanelRegistrar;
    private javax.swing.JPanel jPanelVer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableCompradorVendedor;
    private javax.swing.JTextField textBuscar;
    private javax.swing.JTextField textEmpresa;
    private javax.swing.JTextField textEmpresa1;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textMail;
    private javax.swing.JTextField textMail1;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textNombre1;
    private javax.swing.JTextField textNombre2;
    private javax.swing.JTextField textPais;
    private javax.swing.JTextField textPais1;
    private javax.swing.JTextArea textProductos;
    private javax.swing.JTextArea textProductos1;
    private javax.swing.JTextField textTel;
    private javax.swing.JTextField textTel1;
    // End of variables declaration//GEN-END:variables
}
