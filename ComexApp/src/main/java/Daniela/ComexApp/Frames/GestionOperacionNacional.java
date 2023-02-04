package Daniela.ComexApp.Frames;

import com.toedter.calendar.JDateChooser;
import config.Conexion;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import service.OperacionesNacionalesImpl;

/**
 *
 * @author Daniela
 */
public class GestionOperacionNacional extends javax.swing.JFrame {

    String usuario = "", rol = "", nombreCompleto = "";
    /**
     * Creates new form GestionDeStock
     */
    public GestionOperacionNacional() {
        initComponents();
        
        setSize(1700, 900);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        
        PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
        
        usuario = paginaPrincipal.usuario;
        nombreCompleto = paginaPrincipal.nombreCompleto;
        
        setTitle("Gestión de operación nacional - " + usuario + " - sistema ComexApp");
        jLabelSubtitulo.setText(nombreCompleto + " aquí puedes gestionar las operaciones \n\n"
                + " nacionales registradas");
        
        operacionesNacionalesService.cambiarStatusCuandoIngresaProducto();
        
        jPanelTablaOperaciones.setVisible(true);
        jPanelTablaDetalles.setVisible(false);
        jPanelTablaFechas.setVisible(false);
        jPanelTablaContacto.setVisible(false);
        
        mostrarTodosLosDatosOperaciones();
        pasarCamposDeLasTablasAFields();
        
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

    OperacionesNacionalesImpl operacionesNacionalesService =
            new OperacionesNacionalesImpl();

    
    LocalDate fechaActual = LocalDate.now();
    LocalDate fechaDiasPlus = fechaActual.plusDays(5);
    
    Date fechaInicio = Date.valueOf(fechaActual);
    Date fechaFin = Date.valueOf(fechaDiasPlus);
    
    
    
    public void cargarTablaOperaciones(String sql){

        DefaultTableModel modelo = new DefaultTableModel();
      
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            jTableOperaciones = new JTable(modelo);
            jScrollPane1.setViewportView(jTableOperaciones);
            
            modelo.addColumn("ID");
            modelo.addColumn("Producto");
            modelo.addColumn("Cantidad producto");
            modelo.addColumn("Precio total");
            modelo.addColumn("Tipo de operación");
            modelo.addColumn("Comprador");
            modelo.addColumn("Vendedor");
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
            JOptionPane.showMessageDialog(null, "Error al cargar los datos "
                    + "básicos de la operación");
            System.err.println("Error al cargar los datos básicos de la operación" + e);
        }
    }
   
    public void mostrarTodosLosDatosOperaciones(){
         String sql = "select id_ventalocal, productos_pedidos, cantidad_producto, "
                 + "precio_total, tipo_operacion, comprador, vendedor, status "
                 + "from ventalocal order by id_ventalocal";
        cargarTablaOperaciones(sql);
    }

    public void mostrarOperacionesProximas(){
         String sql = "select id_ventalocal, productos_pedidos, cantidad_producto, "
                 + "precio_total, tipo_operacion, comprador, vendedor, status "
                 + "from ventalocal where fecha_arribo between '" + fechaActual + 
                 "' and '" + fechaDiasPlus + "' order by fecha_arribo asc";
        cargarTablaOperaciones(sql);
    }
     
    
     public void mostrarOperacionesActivas(){
         String sql = "select id_ventalocal, productos_pedidos, cantidad_producto, "
                 + "precio_total, tipo_operacion, comprador, vendedor, status "
                 + "from ventalocal where status = 'Activa' or status = 'En transito' "
                 + "order by fecha_arribo asc";
        cargarTablaOperaciones(sql);
    }
      
     
     
     public void pasarCamposDeLasTablasAFields(){
    
        jTableOperaciones.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent Mouse_evt){
                
                JTable tablaOperaciones= (JTable) Mouse_evt.getSource();
                Point point = Mouse_evt.getPoint();
    
                int filaSeleccionada = tablaOperaciones.rowAtPoint(point);
                
                if(Mouse_evt.getClickCount() == 1){
                  textID.setText(jTableOperaciones.getValueAt(jTableOperaciones.getSelectedRow(), 0).toString());
                  textProductos.setText(jTableOperaciones.getValueAt(jTableOperaciones.getSelectedRow(), 1).toString());
                  textCantidadProducto.setText(jTableOperaciones.getValueAt(jTableOperaciones.getSelectedRow(), 2).toString());
                  textPrecioTotal.setText(jTableOperaciones.getValueAt(jTableOperaciones.getSelectedRow(), 3).toString());
                  cmbTipoOperacion.setSelectedItem(jTableOperaciones.getValueAt(jTableOperaciones.getSelectedRow(), 4).toString());
                  textComprador.setText(jTableOperaciones.getValueAt(jTableOperaciones.getSelectedRow(), 5).toString());
                  textVendedor.setText(jTableOperaciones.getValueAt(jTableOperaciones.getSelectedRow(), 6).toString());
                  cmbStatus1.setSelectedItem(jTableOperaciones.getValueAt(jTableOperaciones.getSelectedRow(), 7).toString());
                  
                  textBuscar.setText(jTableOperaciones.getValueAt(jTableOperaciones.getSelectedRow(), 1).toString());
                }
             
                try{
                    String producto = textBuscar.getText().trim();
                    obtenerDatosTablas(producto);
                }catch(Exception e){
                    System.err.println("No se pueden obtener los datos " + e);
                }
                
            }
        });
    }


      public void obtenerDatosTablas(String producto){
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement("select cuit, empleado, empresa, mail, "
                    + "numero_contacto, fecha_registro, fecha_arribo from ventalocal "
                    + "where productos_pedidos = '" + producto + "'");
            rs = pst.executeQuery();
            
            if(rs.next()){
                
                    textCUIT.setText(rs.getString("cuit"));
                    textEmpleado.setText(rs.getString("empleado"));
                    textEmpresa.setText(rs.getString("empresa"));
                    textMail.setText(rs.getString("mail"));
                    textNumero.setText(rs.getString("numero_contacto"));
                    textRegistro.setText(rs.getDate("fecha_registro").toString());
                    textRecibo.setText(rs.getDate("fecha_arribo").toString());

            }
            conec.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "No se puede obtener la información "
                    + "relacionada con el producto " + producto);
            System.err.println("Error al completar datos " + e);
        }
    }


     
     public void cargarTablaFechas(String sql){

        DefaultTableModel modelo = new DefaultTableModel();
      
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            jTableFechas = new JTable(modelo);
            jScrollPane5.setViewportView(jTableFechas);
             
            modelo.addColumn("Producto");
            modelo.addColumn("Comprador");
            modelo.addColumn("Vendedor");
            modelo.addColumn("Fecha pedido");
            modelo.addColumn("Fecha llegada");
            modelo.addColumn("Status");
            
            while(rs.next()){
                Object[] fila = new Object[6];
                for(int i = 0; i < 6; i++){
                    fila[i] = rs.getObject(i + 1);
                }
               modelo.addRow(fila);
            }
            
            conec.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al cargar las fechas");
            System.err.println("Error al cargar fechas" + e);
        }
    }

   
    public void mostrarTodosLosDatosFechas(){
         String sql = "select productos_pedidos, comprador, vendedor, fecha_registro, "
                 + "fecha_arribo, status from ventalocal order by fecha_arribo asc";
        cargarTablaFechas(sql);
    }
     
     public void mostrarFechasProximas(){
         String sql = "select productos_pedidos, comprador, vendedor, fecha_registro, "
                 + "fecha_arribo, status from ventalocal where fecha_arribo between '" 
                 + fechaActual + "' and '" + fechaDiasPlus + "' order by fecha_arribo asc";
        cargarTablaFechas(sql);
    }
  
     public void mostrarFechasActivas(){
         String sql = "select productos_pedidos, comprador, vendedor, fecha_registro, "
                 + "fecha_arribo, status from ventalocal where status = 'Activa' "
                 + "or status = 'En transito' order by fecha_arribo asc";
        cargarTablaFechas(sql);
    }
     
    
     
     public void cargarTablaContacto(String sql){

        DefaultTableModel modelo = new DefaultTableModel();
      
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            jTableContacto = new JTable(modelo);
            jScrollPane6.setViewportView(jTableContacto);
             
            modelo.addColumn("ID");
            modelo.addColumn("Producto");
            modelo.addColumn("Comprador");
            modelo.addColumn("Vendedor");
            modelo.addColumn("CUIT");
            modelo.addColumn("Empleado contacto");
            modelo.addColumn("Número de contacto");
            modelo.addColumn("Mail");
            
            while(rs.next()){
                Object[] fila = new Object[8];
                for(int i = 0; i < 8; i++){
                    fila[i] = rs.getObject(i + 1);
                }
               modelo.addRow(fila);
            }
            
            conec.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al cargar los contactos");
            System.err.println("Error al cargar contactos" + e);
        }
    }

   
     public void mostrarTodosLosDatosContacto(){
         String sql = "select id_ventalocal, productos_pedidos, comprador, vendedor, CUIT, empleado, "
                 + "numero_contacto, mail from ventalocal order by id_ventalocal";
         cargarTablaContacto(sql);
    }
     
     
    
     
     public void LimpiarBusqueda(){
         textBuscar.setText("");
         textID.setText("");
         textCUIT.setText("");
         textEmpleado.setText("");
         textEmpresa.setText("");
         textMail.setText("");
         textNumero.setText("");
         textPrecioTotal.setText("");
         textProductos.setText("");
         textCantidadProducto.setText("");
         textComprador.setText("");
         textVendedor.setText("");
         cmbTipoOperacion.setSelectedIndex(0);
         cmbStatus1.setSelectedIndex(0);
         textRegistro.setText("");
         textRecibo.setText("");
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
        jLabelTitulo = new javax.swing.JLabel();
        jLabelSubtitulo = new javax.swing.JLabel();
        jButtonOperaciones = new javax.swing.JButton();
        jButtonContacto = new javax.swing.JButton();
        jButtonFechas = new javax.swing.JButton();
        jPanelBusqueda = new javax.swing.JPanel();
        jToggleButtonRecargar = new javax.swing.JToggleButton();
        jToggleButtonFiltrar = new javax.swing.JToggleButton();
        textBuscar = new javax.swing.JTextField();
        jButtonLimpiarBusqueda = new javax.swing.JButton();
        cmbCategoria = new javax.swing.JComboBox<>();
        jButtonProximos = new javax.swing.JButton();
        jButtonOcultar = new javax.swing.JButton();
        jPanelCampos = new javax.swing.JPanel();
        jLabelID = new javax.swing.JLabel();
        textID = new javax.swing.JTextField();
        jButtonInfo = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonVolver2 = new javax.swing.JButton();
        jLabelProductos = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textProductos = new javax.swing.JTextArea();
        jLabelFechaRegistro = new javax.swing.JLabel();
        jLabelFechaRecibo = new javax.swing.JLabel();
        jLabelStatus = new javax.swing.JLabel();
        cmbStatus1 = new javax.swing.JComboBox<>();
        jLabelCUIT = new javax.swing.JLabel();
        textCUIT = new javax.swing.JTextField();
        jLabelEmpleado = new javax.swing.JLabel();
        textEmpleado = new javax.swing.JTextField();
        jLabelEmpresa = new javax.swing.JLabel();
        textEmpresa = new javax.swing.JTextField();
        jLabelMail = new javax.swing.JLabel();
        textMail = new javax.swing.JTextField();
        jLabelCantidad = new javax.swing.JLabel();
        textNumero = new javax.swing.JTextField();
        jLabelComprador = new javax.swing.JLabel();
        textComprador = new javax.swing.JTextField();
        jLabelVendedor = new javax.swing.JLabel();
        textVendedor = new javax.swing.JTextField();
        jLabelCantidadProducto = new javax.swing.JLabel();
        textCantidadProducto = new javax.swing.JTextField();
        jLabelPrecio1 = new javax.swing.JLabel();
        textPrecioTotal = new javax.swing.JTextField();
        jLabelTipoOperacion = new javax.swing.JLabel();
        cmbTipoOperacion = new javax.swing.JComboBox<>();
        textRegistro = new javax.swing.JTextField();
        textRecibo = new javax.swing.JTextField();
        jButtonModificarFecha = new javax.swing.JButton();
        jPanelTablaOperaciones = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableOperaciones = new javax.swing.JTable();
        jPanelTablaDetalles = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableDetalles = new javax.swing.JTable();
        jPanelTablaFechas = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableFechas = new javax.swing.JTable();
        jPanelTablaContacto = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableContacto = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getLogo());
        setIconImages(getIconImages());
        setSize(new java.awt.Dimension(2000, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setText("Operaciones internacionales");
        jPanel1.add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 590, 60));

        jLabelSubtitulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabelSubtitulo.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabelSubtitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 770, 40));

        jButtonOperaciones.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonOperaciones.setForeground(new java.awt.Color(0, 0, 153));
        jButtonOperaciones.setText("Tabla datos operaciones");
        jButtonOperaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOperacionesActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonOperaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 210, -1));

        jButtonContacto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonContacto.setForeground(new java.awt.Color(0, 0, 153));
        jButtonContacto.setText("Tabla datos de contacto");
        jButtonContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonContactoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, -1, -1));

        jButtonFechas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonFechas.setForeground(new java.awt.Color(0, 0, 153));
        jButtonFechas.setText("Tabla fechas");
        jButtonFechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFechasActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonFechas, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 190, 200, -1));

        jPanelBusqueda.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBusqueda.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToggleButtonRecargar.setBackground(new java.awt.Color(0, 0, 153));
        jToggleButtonRecargar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jToggleButtonRecargar.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButtonRecargar.setText("Recargar tabla completa");
        jToggleButtonRecargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonRecargarActionPerformed(evt);
            }
        });
        jPanelBusqueda.add(jToggleButtonRecargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 220, 40));

        jToggleButtonFiltrar.setBackground(new java.awt.Color(0, 0, 153));
        jToggleButtonFiltrar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jToggleButtonFiltrar.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButtonFiltrar.setText("Activar filtros de busqueda");
        jToggleButtonFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonFiltrarActionPerformed(evt);
            }
        });
        jPanelBusqueda.add(jToggleButtonFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 240, 30));
        jPanelBusqueda.add(textBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 290, 33));

        jButtonLimpiarBusqueda.setBackground(new java.awt.Color(0, 0, 153));
        jButtonLimpiarBusqueda.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonLimpiarBusqueda.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLimpiarBusqueda.setText("Limpiar busqueda");
        jButtonLimpiarBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarBusquedaActionPerformed(evt);
            }
        });
        jPanelBusqueda.add(jButtonLimpiarBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        cmbCategoria.setForeground(new java.awt.Color(0, 0, 153));
        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Producto", "Comprador", "Vendedor" }));
        cmbCategoria.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cmbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoriaActionPerformed(evt);
            }
        });
        jPanelBusqueda.add(cmbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 150, 40));

        jButtonProximos.setBackground(new java.awt.Color(0, 0, 153));
        jButtonProximos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonProximos.setForeground(new java.awt.Color(255, 255, 255));
        jButtonProximos.setText("Próximos arribos");
        jButtonProximos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProximosActionPerformed(evt);
            }
        });
        jPanelBusqueda.add(jButtonProximos, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 190, 20));

        jButtonOcultar.setBackground(new java.awt.Color(0, 0, 153));
        jButtonOcultar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonOcultar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonOcultar.setText("Ocultar completas");
        jButtonOcultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOcultarActionPerformed(evt);
            }
        });
        jPanelBusqueda.add(jButtonOcultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 190, 20));

        jPanel1.add(jPanelBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 260, 760, 160));

        jPanelCampos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelID.setForeground(new java.awt.Color(0, 0, 153));
        jLabelID.setText("ID:");
        jPanelCampos.add(jLabelID, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        textID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textID.setForeground(new java.awt.Color(0, 0, 153));
        textID.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelCampos.add(textID, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 60, -1));

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
        jPanelCampos.add(jButtonInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        jButtonModificar.setBackground(new java.awt.Color(0, 0, 153));
        jButtonModificar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonModificar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonModificar.setText("Modificar datos de la operación");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });
        jPanelCampos.add(jButtonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, -1, -1));

        jButtonVolver2.setBackground(new java.awt.Color(0, 0, 153));
        jButtonVolver2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonVolver2.setForeground(new java.awt.Color(255, 255, 255));
        jButtonVolver2.setText("Volver");
        jButtonVolver2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolver2ActionPerformed(evt);
            }
        });
        jPanelCampos.add(jButtonVolver2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 330, -1, -1));

        jLabelProductos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelProductos.setForeground(new java.awt.Color(0, 0, 153));
        jLabelProductos.setText("Productos:");
        jPanelCampos.add(jLabelProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setForeground(new java.awt.Color(0, 0, 153));

        textProductos.setColumns(10);
        textProductos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textProductos.setForeground(new java.awt.Color(0, 0, 153));
        textProductos.setLineWrap(true);
        textProductos.setRows(5);
        textProductos.setWrapStyleWord(true);
        jScrollPane3.setViewportView(textProductos);

        jPanelCampos.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 150, 120));

        jLabelFechaRegistro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelFechaRegistro.setForeground(new java.awt.Color(0, 0, 153));
        jLabelFechaRegistro.setText("Fecha registro:");
        jPanelCampos.add(jLabelFechaRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, -1, -1));

        jLabelFechaRecibo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelFechaRecibo.setForeground(new java.awt.Color(0, 0, 153));
        jLabelFechaRecibo.setText("Fecha arribo:");
        jPanelCampos.add(jLabelFechaRecibo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, -1, -1));

        jLabelStatus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelStatus.setForeground(new java.awt.Color(0, 0, 153));
        jLabelStatus.setText("Status:");
        jPanelCampos.add(jLabelStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, -1, -1));

        cmbStatus1.setForeground(new java.awt.Color(0, 0, 153));
        cmbStatus1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activa", "En transito", "Pendiente de cierre", "Completada", "Suspendida", "Inactiva" }));
        cmbStatus1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cmbStatus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStatus1ActionPerformed(evt);
            }
        });
        jPanelCampos.add(cmbStatus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 120, 40));

        jLabelCUIT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelCUIT.setForeground(new java.awt.Color(0, 0, 153));
        jLabelCUIT.setText("CUIT:");
        jPanelCampos.add(jLabelCUIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, -1, -1));

        textCUIT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textCUIT.setForeground(new java.awt.Color(0, 0, 153));
        textCUIT.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelCampos.add(textCUIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 163, 30));

        jLabelEmpleado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelEmpleado.setForeground(new java.awt.Color(0, 0, 153));
        jLabelEmpleado.setText("Empleado:");
        jPanelCampos.add(jLabelEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, -1, -1));

        textEmpleado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textEmpleado.setForeground(new java.awt.Color(0, 0, 153));
        textEmpleado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelCampos.add(textEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 160, 30));

        jLabelEmpresa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelEmpresa.setForeground(new java.awt.Color(0, 0, 153));
        jLabelEmpresa.setText("Empresa:");
        jPanelCampos.add(jLabelEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, -1, -1));

        textEmpresa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textEmpresa.setForeground(new java.awt.Color(0, 0, 153));
        textEmpresa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelCampos.add(textEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 110, 30));

        jLabelMail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelMail.setForeground(new java.awt.Color(0, 0, 153));
        jLabelMail.setText("Mail:");
        jPanelCampos.add(jLabelMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, -1, -1));

        textMail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textMail.setForeground(new java.awt.Color(0, 0, 153));
        textMail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelCampos.add(textMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 163, 30));

        jLabelCantidad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelCantidad.setForeground(new java.awt.Color(0, 0, 153));
        jLabelCantidad.setText("Número de contacto:");
        jPanelCampos.add(jLabelCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 170, -1));

        textNumero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textNumero.setForeground(new java.awt.Color(0, 0, 153));
        textNumero.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelCampos.add(textNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 160, 30));

        jLabelComprador.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelComprador.setForeground(new java.awt.Color(0, 0, 153));
        jLabelComprador.setText("Comprador:");
        jPanelCampos.add(jLabelComprador, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 100, -1));

        textComprador.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textComprador.setForeground(new java.awt.Color(0, 0, 153));
        textComprador.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelCampos.add(textComprador, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 160, 30));

        jLabelVendedor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelVendedor.setForeground(new java.awt.Color(0, 0, 153));
        jLabelVendedor.setText("Vendedor:");
        jPanelCampos.add(jLabelVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 100, -1));

        textVendedor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textVendedor.setForeground(new java.awt.Color(0, 0, 153));
        textVendedor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelCampos.add(textVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 160, 30));

        jLabelCantidadProducto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelCantidadProducto.setForeground(new java.awt.Color(0, 0, 153));
        jLabelCantidadProducto.setText("Cantidad producto:");
        jPanelCampos.add(jLabelCantidadProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        textCantidadProducto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textCantidadProducto.setForeground(new java.awt.Color(0, 0, 153));
        textCantidadProducto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelCampos.add(textCantidadProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 150, 30));

        jLabelPrecio1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelPrecio1.setForeground(new java.awt.Color(0, 0, 153));
        jLabelPrecio1.setText("Precio total:");
        jPanelCampos.add(jLabelPrecio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, -1, -1));

        textPrecioTotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textPrecioTotal.setForeground(new java.awt.Color(0, 0, 153));
        textPrecioTotal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelCampos.add(textPrecioTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 110, 30));

        jLabelTipoOperacion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTipoOperacion.setForeground(new java.awt.Color(0, 0, 153));
        jLabelTipoOperacion.setText("Tipo de operación:");
        jPanelCampos.add(jLabelTipoOperacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, -1, -1));

        cmbTipoOperacion.setForeground(new java.awt.Color(0, 0, 153));
        cmbTipoOperacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Compra", "Venta" }));
        cmbTipoOperacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cmbTipoOperacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoOperacionActionPerformed(evt);
            }
        });
        jPanelCampos.add(cmbTipoOperacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, 150, 40));

        textRegistro.setEditable(false);
        textRegistro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textRegistro.setForeground(new java.awt.Color(0, 0, 153));
        textRegistro.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelCampos.add(textRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, 150, 30));

        textRecibo.setEditable(false);
        textRecibo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textRecibo.setForeground(new java.awt.Color(0, 0, 153));
        textRecibo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelCampos.add(textRecibo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 140, 150, 30));

        jButtonModificarFecha.setBackground(new java.awt.Color(0, 0, 153));
        jButtonModificarFecha.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonModificarFecha.setForeground(new java.awt.Color(255, 255, 255));
        jButtonModificarFecha.setText("Modificar fecha");
        jButtonModificarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarFechaActionPerformed(evt);
            }
        });
        jPanelCampos.add(jButtonModificarFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 190, -1, 30));

        jPanel1.add(jPanelCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 20, 720, 400));

        jPanelTablaOperaciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 153));

        jTableOperaciones.setBackground(new java.awt.Color(204, 204, 204));
        jTableOperaciones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTableOperaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableOperaciones);

        jPanelTablaOperaciones.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 1480, 270));

        jPanel1.add(jPanelTablaOperaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 1520, 360));

        jPanelTablaDetalles.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setBackground(new java.awt.Color(0, 0, 153));

        jTableDetalles.setBackground(new java.awt.Color(204, 204, 204));
        jTableDetalles.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTableDetalles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableDetalles);

        jPanelTablaDetalles.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 1480, 270));

        jPanel1.add(jPanelTablaDetalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 1520, 360));

        jPanelTablaFechas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane5.setBackground(new java.awt.Color(0, 0, 153));

        jTableFechas.setBackground(new java.awt.Color(204, 204, 204));
        jTableFechas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTableFechas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTableFechas);

        jPanelTablaFechas.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 1480, 270));

        jPanel1.add(jPanelTablaFechas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 1520, 360));

        jPanelTablaContacto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane6.setBackground(new java.awt.Color(0, 0, 153));

        jTableContacto.setBackground(new java.awt.Color(204, 204, 204));
        jTableContacto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTableContacto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(jTableContacto);

        jPanelTablaContacto.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 1480, 270));

        jPanel1.add(jPanelTablaContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 1520, 360));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1910, 900));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButtonRecargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonRecargarActionPerformed

        mostrarTodosLosDatosOperaciones();
        mostrarTodosLosDatosFechas();
        mostrarTodosLosDatosContacto();
        pasarCamposDeLasTablasAFields();
        
    }//GEN-LAST:event_jToggleButtonRecargarActionPerformed

    private void jToggleButtonFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonFiltrarActionPerformed

        String busqueda = textBuscar.getText().trim();
        String sql = null, sql1 = null, sql2 = null, sql3 = null;

        int tipoBusquedaCategoria = cmbCategoria.getSelectedIndex() + 1;

        
        if (!textBuscar.equals("")) {

            if (tipoBusquedaCategoria == 1) {

                sql = "select id_ventalocal, productos_pedidos, cantidad_producto, "
                        + "precio_total, tipo_operacion, comprador, vendedor, status "
                        + "from ventalocal where productos_pedidos = '" + busqueda + "'";
                cargarTablaOperaciones(sql);
                pasarCamposDeLasTablasAFields();

                sql1 = "select productos_pedidos, comprador, vendedor, fecha_operacion, "
                        + "fecha_eta, status from ventalocal where productos_pedidos = '"
                        + busqueda + "'";
                cargarTablaFechas(sql1);

                sql2 = "select id_ventalocal, productos_pedidos, comprador, vendedor, CUIT, empleado, "
                        + "numero_contacto, mail from ventalocal where productos_pedidos = '" 
                        + busqueda + "'";
                cargarTablaContacto(sql2);

            } else if (tipoBusquedaCategoria == 2) {

                sql = "select id_ventalocal, productos_pedidos, cantidad_producto, "
                        + "precio_total, tipo_operacion, comprador, vendedor, status "
                        + "from ventalocal where comprador = '" + busqueda + "'";
                cargarTablaOperaciones(sql);
                pasarCamposDeLasTablasAFields();

                sql1 = "select productos_pedidos, comprador, vendedor, fecha_operacion, "
                        + "fecha_eta, status from ventalocal where comprador = '" 
                        + busqueda + "'";
                cargarTablaFechas(sql1);

                sql2 = "select id_ventalocal, productos_pedidos, comprador, vendedor, CUIT, empleado, "
                        + "numero_contacto, mail from ventalocal where comprador = '" 
                        + busqueda + "'";
                cargarTablaContacto(sql2);
                      
                      
            } else if (tipoBusquedaCategoria == 3){
                      
                      sql = "select id_ventalocal, productos_pedidos, cantidad_producto, "
                        + "precio_total, tipo_operacion, comprador, vendedor, status "
                        + "from ventalocal where vendedor = '" + busqueda + "'"; 
                      cargarTablaOperaciones(sql);
                      pasarCamposDeLasTablasAFields();
                      
                      sql1 = "select productos_pedidos, comprador, vendedor, fecha_operacion, "
                        + "fecha_eta, status from ventalocal where vendedor = '" + busqueda + "'"; 
                      cargarTablaFechas(sql1);
                      
                      sql2 = "select id_ventalocal, productos_pedidos, comprador, vendedor, CUIT, empleado, "
                        + "numero_contacto, mail from ventalocal where vendedor = '" 
                              + busqueda + "'";
                      cargarTablaContacto(sql2);
            }
            
            try{
            
                conec = cn.Conexion();
                pst = conec.prepareStatement(sql);
                rs = pst.executeQuery();
                
                conec.close();
               
            }catch(Exception e){
                System.err.println("Error al buscar por filtros" + e);
                JOptionPane.showMessageDialog(null, "No es posibe buscar por filtros");
            }
        } else if (textBuscar.equals("")){
            JOptionPane.showMessageDialog(null, "Debes colocar un nombre de producto"
                    + " o alguna de las otras busquedas posibles");
        }
    
   
    }//GEN-LAST:event_jToggleButtonFiltrarActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed

         String CUITMod, empleadoMod, empresaMod, mailMod, numeroContactoMod, productosMod,
            cantidadProductosMod, compradorMod, precioTotalMod, vendedorMod, 
                 tipoOperacion = null, status = null, producto;
                    
        int statusNivel = 0, IDMod, tipoOperacionNivel = 0;
        
        producto = textBuscar.getText().trim();

        try{
                
            IDMod = Integer.parseInt(textID.getText().trim());
            CUITMod = textCUIT.getText().trim();
            empleadoMod = textEmpleado.getText().trim();
            empresaMod = textEmpresa.getText().trim();
            mailMod = textMail.getText().trim();
            numeroContactoMod = textNumero.getText().trim();
            productosMod = textProductos.getText().trim();
            cantidadProductosMod = textCantidadProducto.getText().trim();
            compradorMod = textComprador.getText().trim();
            precioTotalMod = textPrecioTotal.getText().trim();
            vendedorMod = textVendedor.getText().trim();
            statusNivel = cmbStatus1.getSelectedIndex() + 1;
            tipoOperacionNivel = cmbTipoOperacion.getSelectedIndex() + 1;
            
            if (statusNivel == 1) {
                status = "Activa";
            } else if (statusNivel == 2) {
                status = "En transito";
            } else if (statusNivel == 3) {
                status = "Pendiente de cierre";
            } else if (statusNivel == 4) {
                status = "Completada";
            } else if (statusNivel == 5) {
                status = "Suspendida";
            } else if (statusNivel == 6) {
                status = "Inactiva";
            }

            if (tipoOperacionNivel == 1) {
                tipoOperacion = "Compra";
            } else if (statusNivel == 2) {
                tipoOperacion = "Venta";
            }

            operacionesNacionalesService.modificarOperacionInternacional(IDMod,
                    CUITMod, empleadoMod, empresaMod, mailMod, numeroContactoMod, 
                    productosMod, cantidadProductosMod, compradorMod, 
                    precioTotalMod, vendedorMod, status, tipoOperacion, producto);

        }catch(Exception e){
            System.err.println("Fallo al modificar datos " + e);
            JOptionPane.showMessageDialog(null, "Fallo al modificar datos");
        }

        LimpiarBusqueda();
        mostrarTodosLosDatosOperaciones();
        pasarCamposDeLasTablasAFields();
        
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonVolver2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolver2ActionPerformed

        Operaciones operaciones = new Operaciones();
        operaciones.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButtonVolver2ActionPerformed

    private void jButtonLimpiarBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarBusquedaActionPerformed
        
        LimpiarBusqueda();
       
    }//GEN-LAST:event_jButtonLimpiarBusquedaActionPerformed

    private void jButtonOperacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOperacionesActionPerformed
        
        jPanelTablaOperaciones.setVisible(true);
        jPanelTablaFechas.setVisible(false);
        jPanelTablaContacto.setVisible(false);
        mostrarTodosLosDatosOperaciones();
        pasarCamposDeLasTablasAFields();
        
    }//GEN-LAST:event_jButtonOperacionesActionPerformed

    private void jButtonContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonContactoActionPerformed
        
        jPanelTablaOperaciones.setVisible(false);
        jPanelTablaFechas.setVisible(false);
        jPanelTablaContacto.setVisible(true);
        mostrarTodosLosDatosContacto();
        
    }//GEN-LAST:event_jButtonContactoActionPerformed

    private void jButtonFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFechasActionPerformed
        
        jPanelTablaOperaciones.setVisible(false);
        jPanelTablaFechas.setVisible(true);
        jPanelTablaContacto.setVisible(false);
        mostrarTodosLosDatosFechas();
        
    }//GEN-LAST:event_jButtonFechasActionPerformed

    private void jButtonInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInfoActionPerformed

        InformacionIDOperacionNacional informacionIDOperacionNacional = new InformacionIDOperacionNacional();
        informacionIDOperacionNacional.setVisible(true);

    }//GEN-LAST:event_jButtonInfoActionPerformed

    private void cmbStatus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStatus1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbStatus1ActionPerformed

    private void cmbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCategoriaActionPerformed

    private void cmbTipoOperacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoOperacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoOperacionActionPerformed

    private void jButtonModificarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarFechaActionPerformed

        ModificarFechaStockYSumi modificarFechasOpNac = new ModificarFechaStockYSumi();
        modificarFechasOpNac.setVisible(true);
        
    }//GEN-LAST:event_jButtonModificarFechaActionPerformed

    private void jButtonProximosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProximosActionPerformed

        mostrarOperacionesProximas();
        mostrarFechasProximas();

    }//GEN-LAST:event_jButtonProximosActionPerformed

    private void jButtonOcultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOcultarActionPerformed

        mostrarOperacionesActivas();
        mostrarFechasActivas();

    }//GEN-LAST:event_jButtonOcultarActionPerformed

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
            java.util.logging.Logger.getLogger(GestionOperacionNacional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionOperacionNacional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionOperacionNacional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionOperacionNacional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new GestionOperacionNacional().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbStatus1;
    private javax.swing.JComboBox<String> cmbTipoOperacion;
    private javax.swing.JButton jButtonContacto;
    private javax.swing.JButton jButtonFechas;
    private javax.swing.JButton jButtonInfo;
    private javax.swing.JButton jButtonLimpiarBusqueda;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonModificarFecha;
    private javax.swing.JButton jButtonOcultar;
    private javax.swing.JButton jButtonOperaciones;
    private javax.swing.JButton jButtonProximos;
    private javax.swing.JButton jButtonVolver2;
    private javax.swing.JLabel jLabelCUIT;
    private javax.swing.JLabel jLabelCantidad;
    private javax.swing.JLabel jLabelCantidadProducto;
    private javax.swing.JLabel jLabelComprador;
    private javax.swing.JLabel jLabelEmpleado;
    private javax.swing.JLabel jLabelEmpresa;
    private javax.swing.JLabel jLabelFechaRecibo;
    private javax.swing.JLabel jLabelFechaRegistro;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelMail;
    private javax.swing.JLabel jLabelPrecio1;
    private javax.swing.JLabel jLabelProductos;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JLabel jLabelSubtitulo;
    private javax.swing.JLabel jLabelTipoOperacion;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelVendedor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelBusqueda;
    private javax.swing.JPanel jPanelCampos;
    private javax.swing.JPanel jPanelTablaContacto;
    private javax.swing.JPanel jPanelTablaDetalles;
    private javax.swing.JPanel jPanelTablaFechas;
    private javax.swing.JPanel jPanelTablaOperaciones;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTableContacto;
    private javax.swing.JTable jTableDetalles;
    private javax.swing.JTable jTableFechas;
    private javax.swing.JTable jTableOperaciones;
    private javax.swing.JToggleButton jToggleButtonFiltrar;
    private javax.swing.JToggleButton jToggleButtonRecargar;
    private javax.swing.JTextField textBuscar;
    private javax.swing.JTextField textCUIT;
    private javax.swing.JTextField textCantidadProducto;
    private javax.swing.JTextField textComprador;
    private javax.swing.JTextField textEmpleado;
    private javax.swing.JTextField textEmpresa;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textMail;
    private javax.swing.JTextField textNumero;
    private javax.swing.JTextField textPrecioTotal;
    private javax.swing.JTextArea textProductos;
    private javax.swing.JTextField textRecibo;
    private javax.swing.JTextField textRegistro;
    private javax.swing.JTextField textVendedor;
    // End of variables declaration//GEN-END:variables
}
