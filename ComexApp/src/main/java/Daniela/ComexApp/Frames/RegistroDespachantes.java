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
import service.DespachantesService;
import service.UsuariosService;

/**
 *
 * @author Daniela
 */
public class RegistroDespachantes extends javax.swing.JFrame {
 
    String usuario = "", nombreCompleto = "";
    /**
     * Creates new form RegistroDespachantes
     */
    public RegistroDespachantes() {
        initComponents();
        
        setSize(1500, 820);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        
        PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
        UsuariosService usuariosService = new UsuariosService();
        
        usuario = paginaPrincipal.usuario;
        nombreCompleto = usuariosService.obtenerNombreCompleto(usuario);
        jLabelNombre.setText(nombreCompleto);
        
        setTitle("Menú de despachantes - " + usuario + " - sistema ComexApp");
        
        mostrarTodosLosDatos();
        mostrarTodosLosDatosDespachantes();
    }
    
        // icono
    public Image getLogo(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/loguito1.png"));
        return retValue;   
    }
    
     
    // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;
    
    DespachantesService despachantesService = new DespachantesService();

    public void LimpiarCamposRegistroDespachantes(){
        textID.setText("");
        textEmpleado.setText("");
        textEmpresa.setText("");
        textMail.setText("");
        textNumero.setText("");
        textPais.setText("");
        textProductos.setText("");
        cmbStatus.setSelectedIndex(0);
    }
    
     public void cargarTablaDespachantes(String sql){

        DefaultTableModel modelo = new DefaultTableModel();
      
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            jTableDespachantes = new JTable(modelo);
            jScrollPane2.setViewportView(jTableDespachantes);
            
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
            JOptionPane.showMessageDialog(null, "Error al cargar tabla de despachantes");
            System.err.println("Error al cargar tabla de despachantes " + e);
        }
    }

   
     public void mostrarTodosLosDatos(){
         String sql = "select id_despachantes, empleado, empresa, mail, "
            + "numero_contacto, pais, status from despachantes";
        cargarTablaDespachantes(sql);
    }
    
     
     public void LimpiarBusqueda(){
         textBuscar.setText("");
         textDespachanteBuscado.setText("");
         cmbStatus.setSelectedItem(0);
         cmbStatus2.setSelectedItem(0);
     }
    
     
     
     // TABLA DE DATOS DESPACHANTES
     
    public void cargarTablaDatos(String sql){

        DefaultTableModel modelo = new DefaultTableModel();
      
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            jTableDatos = new JTable(modelo);
            jScrollPane3.setViewportView(jTableDatos);
            
            modelo.addColumn("Empleado");
            modelo.addColumn("Empresa");
            modelo.addColumn("Mail");
            modelo.addColumn("Contacto");
            modelo.addColumn("Status");
            
            while(rs.next()){
                Object[] fila = new Object[5];
                for(int i = 0; i < 5; i++){
                    fila[i] = rs.getObject(i + 1);
                }
               modelo.addRow(fila);
            }
            
            conec.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al cargar tabla de datos de despachantes");
            System.err.println("Error al cargar tabla de datos de despachantes " + e);
        }
    }
    
    public void mostrarTodosLosDatosDespachantes(){
         String sql = "select empleado, empresa, mail, " + "numero_contacto, "
                 + "status from despachantes";
        cargarTablaDatos(sql);
      }
        
    public void pasarCamposDeLaTablaDatosAFields(){
    
        jTableDatos.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent Mouse_evt){
                
                JTable tablaDatos = (JTable) Mouse_evt.getSource();
                Point point = Mouse_evt.getPoint();
    
                int filaSeleccionada = tablaDatos.rowAtPoint(point);

                if(Mouse_evt.getClickCount() == 1){
                  textEmpresa1.setText(jTableDatos.getValueAt(jTableDatos.getSelectedRow(), 0).toString());
                  textEmpleado1.setText(jTableDatos.getValueAt(jTableDatos.getSelectedRow(), 1).toString());
                  textMail1.setText(jTableDatos.getValueAt(jTableDatos.getSelectedRow(), 2).toString());
                  textNumero1.setText(jTableDatos.getValueAt(jTableDatos.getSelectedRow(), 3).toString()); 
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

        jPanelOpciones = new javax.swing.JPanel();
        jLabelNombre = new javax.swing.JLabel();
        jButtonVolver = new javax.swing.JButton();
        jButtonRegistrar = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        textDespachanteBuscado = new javax.swing.JTextField();
        jTabbedPane = new javax.swing.JTabbedPane();
        jPanelContenido = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelSubTitulo = new javax.swing.JLabel();
        jLabelID = new javax.swing.JLabel();
        textID = new javax.swing.JTextField();
        jButtonInfo = new javax.swing.JButton();
        jLabelEmpresa = new javax.swing.JLabel();
        textEmpresa = new javax.swing.JTextField();
        jLabelEmpleado = new javax.swing.JLabel();
        textEmpleado = new javax.swing.JTextField();
        jLabelMail = new javax.swing.JLabel();
        textMail = new javax.swing.JTextField();
        jLabelNumero = new javax.swing.JLabel();
        textNumero = new javax.swing.JTextField();
        jLabelPais = new javax.swing.JLabel();
        textPais = new javax.swing.JTextField();
        jLabelStatus = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        jLabelProductos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textProductos = new javax.swing.JTextArea();
        jButtonInfo1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanelTabla = new javax.swing.JPanel();
        jPanelBusqueda = new javax.swing.JPanel();
        textBuscar = new javax.swing.JTextField();
        jToggleButtonFiltrar = new javax.swing.JToggleButton();
        jLabelStatus1 = new javax.swing.JLabel();
        cmbStatus1 = new javax.swing.JComboBox<>();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabelBusqueda = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableDespachantes = new javax.swing.JTable();
        jLabelTitulo1 = new javax.swing.JLabel();
        jPanelContacto = new javax.swing.JPanel();
        jLabelNombre1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableDatos = new javax.swing.JTable();
        jLabelStatus2 = new javax.swing.JLabel();
        cmbStatus2 = new javax.swing.JComboBox<>();
        jToggleButton2 = new javax.swing.JToggleButton();
        jLabelEmpresa1 = new javax.swing.JLabel();
        textEmpresa1 = new javax.swing.JTextField();
        jLabelEmpleado1 = new javax.swing.JLabel();
        textEmpleado1 = new javax.swing.JTextField();
        jLabelMail1 = new javax.swing.JLabel();
        textMail1 = new javax.swing.JTextField();
        jLabelNumero1 = new javax.swing.JLabel();
        textNumero1 = new javax.swing.JTextField();
        jPanelProductos = new javax.swing.JPanel();
        jLabelDespachante = new javax.swing.JLabel();
        jLabelProduc = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        textProductos1 = new javax.swing.JTextArea();
        textDespachante = new javax.swing.JTextField();
        jToggleButtonBusqueda = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getLogo());
        setIconImages(getIconImages());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelOpciones.setBackground(new java.awt.Color(255, 255, 255));
        jPanelOpciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNombre.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabelNombre.setForeground(new java.awt.Color(0, 0, 153));
        jPanelOpciones.add(jLabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 256, 60));

        jButtonVolver.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonVolver.setForeground(new java.awt.Color(0, 0, 153));
        jButtonVolver.setText("Volver atrás");
        jPanelOpciones.add(jButtonVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 720, 210, 50));

        jButtonRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButtonRegistrar.setForeground(new java.awt.Color(0, 0, 153));
        jButtonRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/card.png"))); // NOI18N
        jButtonRegistrar.setText("Registrar");
        jButtonRegistrar.setFocusPainted(false);
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });
        jPanelOpciones.add(jButtonRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 240, -1));

        jButtonModificar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButtonModificar.setForeground(new java.awt.Color(0, 0, 153));
        jButtonModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/formu1.png"))); // NOI18N
        jButtonModificar.setText("Modificar ");
        jButtonModificar.setFocusPainted(false);
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });
        jPanelOpciones.add(jButtonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 240, -1));

        jButtonEliminar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButtonEliminar.setForeground(new java.awt.Color(0, 0, 153));
        jButtonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete.png"))); // NOI18N
        jButtonEliminar.setText("Eliminar ");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });
        jPanelOpciones.add(jButtonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 240, -1));

        jButtonBuscar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonBuscar.setForeground(new java.awt.Color(0, 0, 153));
        jButtonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/listado.png"))); // NOI18N
        jButtonBuscar.setText("Buscar despachante");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        jPanelOpciones.add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 250, -1));
        jPanelOpciones.add(textDespachanteBuscado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 250, 33));

        getContentPane().add(jPanelOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 800));

        jTabbedPane.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153)));
        jTabbedPane.setForeground(new java.awt.Color(0, 0, 153));
        jTabbedPane.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jPanelContenido.setBackground(new java.awt.Color(0, 0, 153));
        jPanelContenido.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jPanelContenido.add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 630, 60));

        jLabelSubTitulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabelSubTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSubTitulo.setText("Por favor, elige una opción para que puedas organizar tu trabajo dentro del sistema.");
        jPanelContenido.add(jLabelSubTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 980, 30));

        jLabelID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelID.setForeground(new java.awt.Color(255, 255, 255));
        jLabelID.setText("ID:");
        jPanelContenido.add(jLabelID, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        textID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textID.setForeground(new java.awt.Color(0, 0, 153));
        textID.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelContenido.add(textID, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 100, -1));

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
        jPanelContenido.add(jButtonInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 40, 40));

        jLabelEmpresa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEmpresa.setText("Empresa:");
        jPanelContenido.add(jLabelEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        textEmpresa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textEmpresa.setForeground(new java.awt.Color(0, 0, 153));
        textEmpresa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelContenido.add(textEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 190, -1));

        jLabelEmpleado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEmpleado.setText("Empleado:");
        jPanelContenido.add(jLabelEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, -1));

        textEmpleado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textEmpleado.setForeground(new java.awt.Color(0, 0, 153));
        textEmpleado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelContenido.add(textEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 190, -1));

        jLabelMail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelMail.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMail.setText("Mail:");
        jPanelContenido.add(jLabelMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, -1, -1));

        textMail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textMail.setForeground(new java.awt.Color(0, 0, 153));
        textMail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelContenido.add(textMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 190, -1));

        jLabelNumero.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNumero.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNumero.setText("Número de contacto:");
        jPanelContenido.add(jLabelNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, -1, -1));

        textNumero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textNumero.setForeground(new java.awt.Color(0, 0, 153));
        textNumero.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelContenido.add(textNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, 190, -1));

        jLabelPais.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelPais.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPais.setText("Pais:");
        jPanelContenido.add(jLabelPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, -1, -1));

        textPais.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textPais.setForeground(new java.awt.Color(0, 0, 153));
        textPais.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelContenido.add(textPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, 208, -1));

        jLabelStatus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelStatus.setForeground(new java.awt.Color(255, 255, 255));
        jLabelStatus.setText("Status;");
        jPanelContenido.add(jLabelStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 180, -1, -1));

        cmbStatus.setForeground(new java.awt.Color(0, 0, 153));
        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo", "Suspendido" }));
        cmbStatus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cmbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStatusActionPerformed(evt);
            }
        });
        jPanelContenido.add(cmbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 210, 210, 40));

        jLabelProductos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelProductos.setForeground(new java.awt.Color(255, 255, 255));
        jLabelProductos.setText("Productos asociados a sus operaciones:");
        jPanelContenido.add(jLabelProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 310, -1, -1));

        jScrollPane1.setForeground(new java.awt.Color(0, 0, 153));

        textProductos.setColumns(20);
        textProductos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textProductos.setForeground(new java.awt.Color(0, 0, 153));
        textProductos.setRows(5);
        jScrollPane1.setViewportView(textProductos);

        jPanelContenido.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, 530, 190));

        jButtonInfo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/signo4.png"))); // NOI18N
        jButtonInfo1.setBorder(null);
        jButtonInfo1.setBorderPainted(false);
        jButtonInfo1.setContentAreaFilled(false);
        jButtonInfo1.setFocusPainted(false);
        jButtonInfo1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/signo5.png"))); // NOI18N
        jButtonInfo1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/signo5.png"))); // NOI18N
        jButtonInfo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInfo1ActionPerformed(evt);
            }
        });
        jPanelContenido.add(jButtonInfo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 370, 40, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mail.png"))); // NOI18N
        jPanelContenido.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 470, 50, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/celu.png"))); // NOI18N
        jPanelContenido.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 540, -1, -1));

        jTabbedPane.addTab("Sección de información completa", jPanelContenido);

        jPanelTabla.setBackground(new java.awt.Color(0, 0, 153));
        jPanelTabla.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelBusqueda.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanelBusqueda.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanelBusqueda.add(textBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 250, 33));

        jToggleButtonFiltrar.setBackground(new java.awt.Color(0, 0, 153));
        jToggleButtonFiltrar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jToggleButtonFiltrar.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButtonFiltrar.setText("Activar filtros de busqueda");
        jToggleButtonFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonFiltrarActionPerformed(evt);
            }
        });
        jPanelBusqueda.add(jToggleButtonFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 240, 30));

        jLabelStatus1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabelStatus1.setForeground(new java.awt.Color(0, 0, 153));
        jLabelStatus1.setText("Status requerido:");
        jPanelBusqueda.add(jLabelStatus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 130, 20));

        cmbStatus1.setForeground(new java.awt.Color(0, 0, 153));
        cmbStatus1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo", "Suspendido" }));
        jPanelBusqueda.add(cmbStatus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 170, 40));

        jToggleButton1.setBackground(new java.awt.Color(0, 0, 153));
        jToggleButton1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jToggleButton1.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton1.setText("Buscar todos/Reiniciar");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanelBusqueda.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, 240, 40));

        jLabelBusqueda.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabelBusqueda.setForeground(new java.awt.Color(0, 0, 153));
        jLabelBusqueda.setText("Coloca empresa o empleado:");
        jPanelBusqueda.add(jLabelBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 210, 20));

        jPanelTabla.add(jPanelBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 1110, 110));

        jTableDespachantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTableDespachantes);

        jPanelTabla.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 1110, -1));

        jLabelTitulo1.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabelTitulo1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo1.setText("Lista de despachantes registrados");
        jPanelTabla.add(jLabelTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 460, 60));

        jTabbedPane.addTab("Sección de tabla y listado", jPanelTabla);

        jPanelContacto.setBackground(new java.awt.Color(0, 0, 153));
        jPanelContacto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNombre1.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabelNombre1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNombre1.setText("Datos del despachante:");
        jPanelContacto.add(jLabelNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 320, 60));

        jTableDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTableDatos);

        jPanelContacto.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 1140, -1));

        jLabelStatus2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabelStatus2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelStatus2.setText("Status requerido:");
        jPanelContacto.add(jLabelStatus2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 130, 20));

        cmbStatus2.setForeground(new java.awt.Color(0, 0, 153));
        cmbStatus2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo", "Suspendido" }));
        jPanelContacto.add(cmbStatus2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 170, 40));

        jToggleButton2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jToggleButton2.setForeground(new java.awt.Color(0, 0, 153));
        jToggleButton2.setText("Buscar todos/Reiniciar");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        jPanelContacto.add(jToggleButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 240, 40));

        jLabelEmpresa1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelEmpresa1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEmpresa1.setText("Empresa:");
        jPanelContacto.add(jLabelEmpresa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        textEmpresa1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textEmpresa1.setForeground(new java.awt.Color(0, 0, 153));
        textEmpresa1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelContacto.add(textEmpresa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 190, -1));

        jLabelEmpleado1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelEmpleado1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEmpleado1.setText("Empleado:");
        jPanelContacto.add(jLabelEmpleado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, -1, -1));

        textEmpleado1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textEmpleado1.setForeground(new java.awt.Color(0, 0, 153));
        textEmpleado1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelContacto.add(textEmpleado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 190, -1));

        jLabelMail1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelMail1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMail1.setText("Mail:");
        jPanelContacto.add(jLabelMail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 100, -1, -1));

        textMail1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textMail1.setForeground(new java.awt.Color(0, 0, 153));
        textMail1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelContacto.add(textMail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 120, 190, -1));

        jLabelNumero1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNumero1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNumero1.setText("Número de contacto:");
        jPanelContacto.add(jLabelNumero1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 100, -1, -1));

        textNumero1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textNumero1.setForeground(new java.awt.Color(0, 0, 153));
        textNumero1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelContacto.add(textNumero1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 120, 190, -1));

        jTabbedPane.addTab("Sección de contacto despachante", jPanelContacto);

        jPanelProductos.setBackground(new java.awt.Color(0, 0, 153));
        jPanelProductos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDespachante.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelDespachante.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDespachante.setText("Despachante:");
        jPanelProductos.add(jLabelDespachante, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, 20));

        jLabelProduc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelProduc.setForeground(new java.awt.Color(255, 255, 255));
        jLabelProduc.setText("Productos asociados:");
        jPanelProductos.add(jLabelProduc, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, -1, 20));

        jScrollPane4.setForeground(new java.awt.Color(0, 0, 153));

        textProductos1.setColumns(20);
        textProductos1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textProductos1.setForeground(new java.awt.Color(0, 0, 153));
        textProductos1.setRows(5);
        jScrollPane4.setViewportView(textProductos1);

        jPanelProductos.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 700, 190));

        textDespachante.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textDespachante.setForeground(new java.awt.Color(0, 0, 153));
        textDespachante.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        textDespachante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDespachanteActionPerformed(evt);
            }
        });
        jPanelProductos.add(textDespachante, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 190, -1));

        jToggleButtonBusqueda.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jToggleButtonBusqueda.setForeground(new java.awt.Color(0, 0, 153));
        jToggleButtonBusqueda.setText("Reiniciar busqueda de despachante");
        jToggleButtonBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonBusquedaActionPerformed(evt);
            }
        });
        jPanelProductos.add(jToggleButtonBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 330, 40));

        jTabbedPane.addTab("Sección de despachantes-productos", jPanelProductos);

        getContentPane().add(jTabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 1210, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInfoActionPerformed

        InformacionIDDespachantes informacionIDDespachantes= new InformacionIDDespachantes();
        informacionIDDespachantes.setVisible(true);
        
    }//GEN-LAST:event_jButtonInfoActionPerformed

    private void cmbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbStatusActionPerformed

    private void jButtonInfo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInfo1ActionPerformed
        
        JOptionPane.showConfirmDialog(null, "Aquí colocarás los productos "
                + "asociados a este despachante. \n\n Se recomienda colocarlos "
                + "en formato de lista para mejor visualización.", "Información "
                        + "sobre campo de productos", 0, 0);
        
    }//GEN-LAST:event_jButtonInfo1ActionPerformed

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
        String busqueda = textBuscar.getText().trim();
        String sql;
         
        try{

         if (!textBuscar.equals("") && statusBuscado.equals("Activo")) {
                sql = "select id_despachantes, empleado, empresa, mail, "
                        + "numero_contacto, pais, status from despachantes "
                        + "where empresa = '" + busqueda + "' or empleado = '" 
                        + busqueda + "' and status = 'Activo'";
                cargarTablaDespachantes(sql);
            } else if (textBuscar.equals("") && statusBuscado.equals("Activo")) {
                sql = "select id_despachantes, empleado, empresa, mail, "
                        + "numero_contacto, pais, status from despachantes "
                        + "where status = 'Activo'";
                cargarTablaDespachantes(sql);
            }

     
           if (!textBuscar.equals("") && statusBuscado.equals("Inactivo")) {
                sql = "select id_despachantes, empleado, empresa, mail, "
                        + "numero_contacto, pais, status from despachantes "
                        + "where empresa = '" + busqueda + "' or empleado = '" + 
                        busqueda + "' and status = 'Inactivo'";
                cargarTablaDespachantes(sql);
            } else if (textBuscar.equals("") && statusBuscado.equals("Inactivo")) {
                sql = "select id_despachantes, empleado, empresa, mail, "
                        + "numero_contacto, pais, status from despachantes "
                        + "where status = 'Inactivo'";
                cargarTablaDespachantes(sql);
            } else if (!textBuscar.equals("") && statusBuscado.equals("Suspendido")) {
                sql = "select id_despachantes, empleado, empresa, mail, "
                        + "numero_contacto, pais, status from despachantes "
                        + "where empresa = '" + busqueda + "' or empleado = '" +
                        busqueda + "' and status = 'Suspendido'";
                cargarTablaDespachantes(sql);
            } else if (textBuscar.equals("") && statusBuscado.equals("Suspendido")) {
                sql = "select id_despachantes, empleado, empresa, mail, "
                        + "numero_contacto, pais, status from despachantes"
                        + " where status = 'Suspendido'";
                cargarTablaDespachantes(sql);
            }
          
        }catch(Exception e){
            System.err.println("Error al buscar por filtros" + e);
            JOptionPane.showMessageDialog(null, "No es posibe buscar por filtros");
        }
        
      
        
        
        // PASAR TODO ESTO DE DATOS A OTRO BOTON
        
        String datosBuscados = textDespachanteBuscado.getText().trim();
        
        if(jScrollPane3.isVisible()){
         try{

             if (!textDespachanteBuscado.equals("") && statusBuscado.equals("Activo")) {
                sql = "select empleado, empresa, mail, numero_contacto, status " 
                        + "from despachantes where empresa = '" + busqueda + 
                        "' or empleado = '" + datosBuscados  + "' and status = 'Activo'";
                cargarTablaDatos(sql);
                pasarCamposDeLaTablaDatosAFields();
              } else if (textDespachanteBuscado.equals("") && statusBuscado.equals("Activo")) {
                sql = "select empleado, empresa, mail, numero_contacto, status from despachantes "
                        + "where status = 'Activo'";
                cargarTablaDatos(sql);
                pasarCamposDeLaTablaDatosAFields();
               }

     
            if (!textDespachanteBuscado.equals("") && statusBuscado.equals("Inactivo")) {
                sql = "select empleado, empresa, mail, numero_contacto, status "
                        + "from despachantes where empresa = '" + datosBuscados  
                        + "' or empleado = '" + datosBuscados + "' and status = 'Inactivo'";
                cargarTablaDatos(sql);
                pasarCamposDeLaTablaDatosAFields();
             } else if (textDespachanteBuscado.equals("") && statusBuscado.equals("Inactivo")) {
                sql = "select empleado, empresa, mail, numero_contacto, status "
                        + "from despachantes where status = 'Inactivo'";
                cargarTablaDatos(sql);
                pasarCamposDeLaTablaDatosAFields();
             } else if (!textDespachanteBuscado.equals("") && statusBuscado.equals("Suspendido")) {
                sql = "select empleado, empresa, mail, numero_contacto, status " 
                        + "from despachantes where empresa = '" + datosBuscados + 
                        "' or empleado = '" + datosBuscados  + "' and status = 'Suspendido'";
                cargarTablaDatos(sql);
                pasarCamposDeLaTablaDatosAFields();
             } else if (textDespachanteBuscado.equals("") && statusBuscado.equals("Suspendido")) {
                sql = "select empleado, empresa, mail, numero_contacto, status "
                        + "from despachantes where status = 'Suspendido'";
                cargarTablaDatos(sql);
                pasarCamposDeLaTablaDatosAFields();
            }
          
        }catch(Exception e){
            System.err.println("Error al buscar por filtros" + e);
            JOptionPane.showMessageDialog(null, "No es posibe buscar por filtros");
        }
        }
    }//GEN-LAST:event_jToggleButtonFiltrarActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed

        LimpiarBusqueda();
        mostrarTodosLosDatos();

    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed
       
        String empleado, empresa, mail, numeroContacto, pais, productosAsociados, status = null;
        int statusNivel = 0, ID;
        
        Boolean recepcion;
        
        ID = Integer.parseInt(textID.getText().trim());
        empleado = textEmpleado.getText().trim();
        empresa = textEmpresa.getText().trim();
        mail = textMail.getText().trim();
        numeroContacto = textNumero.getText().trim();
        pais = textPais.getText().trim();
        productosAsociados = textProductos.getText().trim();
        statusNivel = cmbStatus.getSelectedIndex() + 1;
        
        if(statusNivel == 1){
           status = "Activo";
        } else if (statusNivel == 2){
           status = "Inactivo";
        } else if (statusNivel == 3){
           status = "Suspendido";
        }
           
        recepcion = despachantesService.registroDeDespachante(ID, empleado, 
                empresa, mail, numeroContacto, pais, productosAsociados, status);
        
        if(recepcion.equals(true)){
           LimpiarCamposRegistroDespachantes();
        }
    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
       
        String empleadoMod, empresaMod, mailMod, numeroContactoMod, paisMod, 
                productosAsociadosMod, statusMod = null;
        
        int statusNivel = 0, IDMod; 
        
        String empleado = textDespachanteBuscado.getText().trim();
        
        try{        
        
            IDMod = Integer.parseInt(textID.getText().trim());
            empleadoMod = textEmpleado.getText().trim();
            empresaMod = textEmpresa.getText().trim();
            mailMod = textMail.getText().trim();
            numeroContactoMod = textNumero.getText().trim();
            paisMod = textPais.getText().trim();
            productosAsociadosMod = textProductos.getText().trim();
            statusNivel = cmbStatus.getSelectedIndex() + 1;

            if (statusNivel == 1) {
                statusMod = "Activo";
            } else if (statusNivel == 2) {
                statusMod = "Inactivo";
            } else if (statusNivel == 3) {
                statusMod = "Suspendido";
            }

            despachantesService.modificarDatosDespachante(empleado, empleadoMod,
                     empresaMod, mailMod, numeroContactoMod, paisMod, productosAsociadosMod, statusMod);

        }catch(Exception e){
            System.err.println("Fallo al modificar datos " + e);
            JOptionPane.showMessageDialog(null, "Fallo al modificar datos");
        }
                
  
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        
        int id = Integer.parseInt(textID.getText().trim());
        String empleado = textEmpleado.getText().trim();
        
        try{
            Boolean aprobarEliminar = despachantesService.eliminarDespachante(empleado, id);
            
            if(aprobarEliminar.equals(true)){
                JOptionPane.showMessageDialog(null, "Eliminación éxitosa");
                LimpiarCamposRegistroDespachantes();
            }
                  
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No pudimos eliminar al importador");
        }
        
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
     
        despachantesService.obtenerDatosDelDespachante(textDespachanteBuscado, 
               textID, textEmpleado, textEmpresa, textMail, textNumero, 
               textPais, textProductos, cmbStatus);
      
       String despachanteABuscar = textDespachanteBuscado.getText().trim();
               
       setTitle("Informacíón completa de " + despachanteABuscar + " - Sistema ComexApp");
       jLabelTitulo.setText("Información completa de " + despachanteABuscar + "");
       
       if(jPanelProductos.isVisible()){
           despachantesService.obtenerDatosDeProductosDelDespachante(
                   textDespachanteBuscado, textDespachante, textProductos1);
       }
  
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        
        LimpiarBusqueda();
        mostrarTodosLosDatosDespachantes();
        
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButtonBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonBusquedaActionPerformed
        
        LimpiarBusqueda();
        mostrarTodosLosDatosDespachantes();
        
    }//GEN-LAST:event_jToggleButtonBusquedaActionPerformed

    private void textDespachanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDespachanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDespachanteActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroDespachantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroDespachantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroDespachantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroDespachantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */  
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroDespachantes().setVisible(true);
            }
        });
    }
        
      

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JComboBox<String> cmbStatus1;
    private javax.swing.JComboBox<String> cmbStatus2;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonInfo;
    private javax.swing.JButton jButtonInfo1;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelBusqueda;
    private javax.swing.JLabel jLabelDespachante;
    private javax.swing.JLabel jLabelEmpleado;
    private javax.swing.JLabel jLabelEmpleado1;
    private javax.swing.JLabel jLabelEmpresa;
    private javax.swing.JLabel jLabelEmpresa1;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelMail;
    private javax.swing.JLabel jLabelMail1;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelNombre1;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JLabel jLabelNumero1;
    private javax.swing.JLabel jLabelPais;
    private javax.swing.JLabel jLabelProduc;
    private javax.swing.JLabel jLabelProductos;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JLabel jLabelStatus1;
    private javax.swing.JLabel jLabelStatus2;
    private javax.swing.JLabel jLabelSubTitulo;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelTitulo1;
    private javax.swing.JPanel jPanelBusqueda;
    private javax.swing.JPanel jPanelContacto;
    private javax.swing.JPanel jPanelContenido;
    private javax.swing.JPanel jPanelOpciones;
    private javax.swing.JPanel jPanelProductos;
    private javax.swing.JPanel jPanelTabla;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTable jTableDatos;
    private javax.swing.JTable jTableDespachantes;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButtonBusqueda;
    private javax.swing.JToggleButton jToggleButtonFiltrar;
    private javax.swing.JTextField textBuscar;
    private javax.swing.JTextField textDespachante;
    private javax.swing.JTextField textDespachanteBuscado;
    private javax.swing.JTextField textEmpleado;
    private javax.swing.JTextField textEmpleado1;
    private javax.swing.JTextField textEmpresa;
    private javax.swing.JTextField textEmpresa1;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textMail;
    private javax.swing.JTextField textMail1;
    private javax.swing.JTextField textNumero;
    private javax.swing.JTextField textNumero1;
    private javax.swing.JTextField textPais;
    private javax.swing.JTextArea textProductos;
    private javax.swing.JTextArea textProductos1;
    // End of variables declaration//GEN-END:variables
}
