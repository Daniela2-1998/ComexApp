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
import service.ContenedoresImpl;

/**
 *
 * @author Daniela
 */
public class GestionDeContenedores extends javax.swing.JFrame {

    String usuario = "", rol = "", nombreCompleto = "";
    /**
     * Creates new form GestionDeContenedores
     */
    public GestionDeContenedores() {
        initComponents();
        
        setSize(1700, 900);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        
        PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
        
        usuario = paginaPrincipal.usuario;
        nombreCompleto = paginaPrincipal.nombreCompleto;
        
        setTitle("Gestión de contenedores - " + usuario + " - sistema ComexApp");
        jLabelSubtitulo.setText(nombreCompleto + " aquí puedes gestionar los contenedores");
        
        mostrarTodosLosDatosContenedores();
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

    ContenedoresImpl contenedoresImpl = new ContenedoresImpl();
    
    Date fechaActual = Date.valueOf(LocalDate.now());
    Date fechaDiasPlus = Date.valueOf(LocalDate.now().plusDays(5));
    
    
    public void cargarTablaContenedores(String sql){

        DefaultTableModel modelo = new DefaultTableModel();
      
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            jTableContenedores = new JTable(modelo);
            jScrollPane1.setViewportView(jTableContenedores);
            
            modelo.addColumn("ID");
            modelo.addColumn("Contenedor");
            modelo.addColumn("Empresa del contenedor");
            modelo.addColumn("Tipo de contenedor");
            modelo.addColumn("Capacidad");
            modelo.addColumn("Status");
            modelo.addColumn("Fecha último control");
            modelo.addColumn("Fecha próximo control");
            
            while(rs.next()){
                Object[] fila = new Object[8];
                for(int i = 0; i < 8; i++){
                    fila[i] = rs.getObject(i + 1);
                }
               modelo.addRow(fila);
            }
            
            conec.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al cargar los datos de "
                    + "los contenedores registrados");
            System.err.println("Error al cargar los contenedores registrados" + e);
        }
    }
   
    public void mostrarTodosLosDatosContenedores(){
         String sql = "select id_contenedor, codigo, empresa, tipo, capacidad, "
                 + "status, ultimo_control, proximo_control from contenedores "
                 + "order by id_contenedor asc";
        cargarTablaContenedores(sql);
    }
    
    public void mostrarContenedoresDisponibles(){
         String sql = "select id_contenedor, codigo, empresa, tipo, capacidad, "
                 + "status, ultimo_control, proximo_control from contenedores where "
                 + "status = 'Disponible' order by id_contenedor asc";
        cargarTablaContenedores(sql);
    }

    public void mostrarContenedoresEnUso(){
         String sql = "select id_contenedor, codigo, empresa, tipo, capacidad, "
                 + "status, ultimo_control, proximo_control from contenedores where "
                 + "status = 'En uso' order by id_contenedor asc";
        cargarTablaContenedores(sql);
    }
    
    
    public void mostrarProximosControles(){
         String sql = "select id_contenedor, codigo, empresa, tipo, capacidad, "
                 + "status, ultimo_control, proximo_control from contenedores where "
                 + "proximo_control between '" + fechaActual + "' and '" + fechaDiasPlus 
                 + "' order by id_contenedor asc";
         
        cargarTablaContenedores(sql);
    }
    
    
     public void pasarCamposDeLasTablasAFields(){
    
        jTableContenedores.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent Mouse_evt){
                
                JTable tablaContenedores = (JTable) Mouse_evt.getSource();
                Point point = Mouse_evt.getPoint();
    
                int filaSeleccionada = tablaContenedores.rowAtPoint(point);
                
                if(Mouse_evt.getClickCount() == 1){
                  textID.setText(jTableContenedores.getValueAt(jTableContenedores.getSelectedRow(), 0).toString());
                  textCodigo.setText(jTableContenedores.getValueAt(jTableContenedores.getSelectedRow(), 1).toString());
                  textEmpresa.setText(jTableContenedores.getValueAt(jTableContenedores.getSelectedRow(), 2).toString());
                  textTipo.setText(jTableContenedores.getValueAt(jTableContenedores.getSelectedRow(), 3).toString());
                  textCapacidad.setText(jTableContenedores.getValueAt(jTableContenedores.getSelectedRow(), 4).toString());
                  cmbStatus.setSelectedItem(jTableContenedores.getValueAt(jTableContenedores.getSelectedRow(), 5).toString());                
                  textFechaUltimo.setText(jTableContenedores.getValueAt(jTableContenedores.getSelectedRow(), 6).toString());
                  textFechaProximo.setText(jTableContenedores.getValueAt(jTableContenedores.getSelectedRow(), 7).toString());
                  
                  textBuscar.setText(jTableContenedores.getValueAt(jTableContenedores.getSelectedRow(), 1).toString());
                  obtenerDatosFaltantesEnFields();
                }
            }
        });
    }
      
     
    public void obtenerDatosFaltantesEnFields(){
        
        String busqueda = textBuscar.getText().trim();
        String sql = "select productos, cantidad, compañia_transporte, reserva "
                + "from contenedores where codigo = '" + busqueda + "'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                textProducto.setText(rs.getString("productos"));
                textCantidad.setText(rs.getString("cantidad"));
                textCompañia.setText(rs.getString("compañia_transporte"));
                textReserva.setText(rs.getString("reserva"));
            }
            conec.close();
            
        }catch(SQLException e){
            System.err.println("No se pueden recuperar los datos faltantes " + e);
        }
    }
     
    public void cargarTablaDetalles(String sql){

        DefaultTableModel modelo = new DefaultTableModel();
      
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            jTableDetalles = new JTable(modelo);
            jScrollPane2.setViewportView(jTableDetalles);
             
            modelo.addColumn("ID");
            modelo.addColumn("Contenedor");
            modelo.addColumn("Reserva");
            modelo.addColumn("Productos transportando");
            modelo.addColumn("Cantidad de productos");
            
            while(rs.next()){
                Object[] fila = new Object[5];
                for(int i = 0; i < 5; i++){
                    fila[i] = rs.getObject(i + 1);
                }
               modelo.addRow(fila);
            }
            
            conec.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al cargar los detalles");
            System.err.println("Error al cargar los detalles" + e);
        }
    }

   
     public void mostrarTodosLosDatosDetalles(){
         String sql = "select id_contenedor, codigo, reserva, productos, cantidad "
                 + "from contenedores order by id_contenedor asc";
        cargarTablaDetalles(sql);
    }
 
    public void mostrarTodosLosDatosEnUso(){
         String sql = "select id_contenedor, codigo, reserva, productos, cantidad "
                 + "from contenedores where status = 'En uso' order by id_contenedor asc";
        cargarTablaDetalles(sql);
    }
    
    public void mostrarFechasDisponibles(){
         String sql = "select id_contenedor, codigo, reserva, productos, cantidad "
                 + "from contenedores where status = 'Disponible' order by id_contenedor asc";
        cargarTablaDetalles(sql);
    }
  
     public void mostrarProximosControlesDetalles(){
         String sql = "select id_contenedor, codigo, reserva, productos, cantidad "
                 + "from contenedores where proximo_control between '" + fechaActual 
                 + "' and '" + fechaDiasPlus + "' order by id_contenedor asc";
        cargarTablaDetalles(sql);
    }
     
    
     
     public void LimpiarBusqueda(){
         textBuscar.setText("");
         textID.setText("");
         textCodigo.setText("");
         textEmpresa.setText("");
         textReserva.setText("");
         textCapacidad.setText("");
         textCodigo.setText("");
         textProducto.setText("");
         textCantidad.setText("");
         textTipo.setText("");
         textFechaUltimo.setText("");
         textFechaProximo.setText("");
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
        jButtonContenedores = new javax.swing.JButton();
        jButtonDetalles = new javax.swing.JButton();
        jPanelBusqueda = new javax.swing.JPanel();
        jToggleButtonRecargar = new javax.swing.JToggleButton();
        jToggleButtonFiltrar = new javax.swing.JToggleButton();
        textBuscar = new javax.swing.JTextField();
        jButtonLimpiarBusqueda = new javax.swing.JButton();
        jButtonUso = new javax.swing.JButton();
        jButtonDisponibles = new javax.swing.JButton();
        jButtonProximos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanelCampos = new javax.swing.JPanel();
        jLabelID = new javax.swing.JLabel();
        textID = new javax.swing.JTextField();
        jButtonInfo = new javax.swing.JButton();
        textCodigo = new javax.swing.JTextField();
        textEmpresa = new javax.swing.JTextField();
        jButtonModificar = new javax.swing.JButton();
        jButtonVolver2 = new javax.swing.JButton();
        jLabelCodigo = new javax.swing.JLabel();
        jLabelNumero = new javax.swing.JLabel();
        jLabelProductos = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textProducto = new javax.swing.JTextArea();
        jLabelCantidad1 = new javax.swing.JLabel();
        textCantidad = new javax.swing.JTextField();
        jLabelTipo = new javax.swing.JLabel();
        textTipo = new javax.swing.JTextField();
        jLabelCapacidad = new javax.swing.JLabel();
        textCapacidad = new javax.swing.JTextField();
        jLabelReserva = new javax.swing.JLabel();
        textReserva = new javax.swing.JTextField();
        jLabelFechaRegistro = new javax.swing.JLabel();
        jLabelFechaRecibo = new javax.swing.JLabel();
        jLabelStatus = new javax.swing.JLabel();
        textFechaUltimo = new javax.swing.JTextField();
        textFechaProximo = new javax.swing.JTextField();
        jButtonModificarFecha = new javax.swing.JButton();
        cmbStatus = new javax.swing.JComboBox<>();
        jLabelNombreBuque = new javax.swing.JLabel();
        textCompañia = new javax.swing.JTextField();
        jPanelTablaContenedores = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableContenedores = new javax.swing.JTable();
        jPanelTablaDetalles = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableDetalles = new javax.swing.JTable();

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
        jLabelTitulo.setText("Gestión de contenedores");
        jPanel1.add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 430, 60));

        jLabelSubtitulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabelSubtitulo.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabelSubtitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 770, 40));

        jButtonContenedores.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonContenedores.setForeground(new java.awt.Color(0, 0, 153));
        jButtonContenedores.setText("Tabla datos contenedor");
        jButtonContenedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonContenedoresActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonContenedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 210, -1));

        jButtonDetalles.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonDetalles.setForeground(new java.awt.Color(0, 0, 153));
        jButtonDetalles.setText("Tabla detalles contenedor");
        jButtonDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDetallesActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonDetalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, -1, -1));

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
        jPanelBusqueda.add(jToggleButtonRecargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 220, 40));

        jToggleButtonFiltrar.setBackground(new java.awt.Color(0, 0, 153));
        jToggleButtonFiltrar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jToggleButtonFiltrar.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButtonFiltrar.setText("Buscar");
        jToggleButtonFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonFiltrarActionPerformed(evt);
            }
        });
        jPanelBusqueda.add(jToggleButtonFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 100, 30));
        jPanelBusqueda.add(textBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 310, 33));

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

        jButtonUso.setBackground(new java.awt.Color(0, 0, 153));
        jButtonUso.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonUso.setForeground(new java.awt.Color(255, 255, 255));
        jButtonUso.setText("Mostrar en uso");
        jButtonUso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUsoActionPerformed(evt);
            }
        });
        jPanelBusqueda.add(jButtonUso, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 210, 20));

        jButtonDisponibles.setBackground(new java.awt.Color(0, 0, 153));
        jButtonDisponibles.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonDisponibles.setForeground(new java.awt.Color(255, 255, 255));
        jButtonDisponibles.setText("Mostrar disponibles");
        jButtonDisponibles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDisponiblesActionPerformed(evt);
            }
        });
        jPanelBusqueda.add(jButtonDisponibles, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 210, 20));

        jButtonProximos.setBackground(new java.awt.Color(0, 0, 153));
        jButtonProximos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonProximos.setForeground(new java.awt.Color(255, 255, 255));
        jButtonProximos.setText("Próximos controles");
        jButtonProximos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProximosActionPerformed(evt);
            }
        });
        jPanelBusqueda.add(jButtonProximos, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 210, 20));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Código de contenedor o nombre de empresa:");
        jPanelBusqueda.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jPanel1.add(jPanelBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 260, 770, 160));

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

        textCodigo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textCodigo.setForeground(new java.awt.Color(0, 0, 153));
        textCodigo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelCampos.add(textCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 163, 30));

        textEmpresa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textEmpresa.setForeground(new java.awt.Color(0, 0, 153));
        textEmpresa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelCampos.add(textEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 163, 30));

        jButtonModificar.setBackground(new java.awt.Color(0, 0, 153));
        jButtonModificar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonModificar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonModificar.setText("Modificar datos del contenedor");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });
        jPanelCampos.add(jButtonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        jButtonVolver2.setBackground(new java.awt.Color(0, 0, 153));
        jButtonVolver2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonVolver2.setForeground(new java.awt.Color(255, 255, 255));
        jButtonVolver2.setText("Volver");
        jButtonVolver2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolver2ActionPerformed(evt);
            }
        });
        jPanelCampos.add(jButtonVolver2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 330, -1, -1));

        jLabelCodigo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelCodigo.setForeground(new java.awt.Color(0, 0, 153));
        jLabelCodigo.setText("Código contenedor:");
        jPanelCampos.add(jLabelCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, -1, -1));

        jLabelNumero.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNumero.setForeground(new java.awt.Color(0, 0, 153));
        jLabelNumero.setText("Empresa del contenedor:");
        jPanelCampos.add(jLabelNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, -1, -1));

        jLabelProductos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelProductos.setForeground(new java.awt.Color(0, 0, 153));
        jLabelProductos.setText("Productos:");
        jPanelCampos.add(jLabelProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setForeground(new java.awt.Color(0, 0, 153));

        textProducto.setColumns(10);
        textProducto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textProducto.setForeground(new java.awt.Color(0, 0, 153));
        textProducto.setLineWrap(true);
        textProducto.setRows(5);
        textProducto.setWrapStyleWord(true);
        jScrollPane3.setViewportView(textProducto);

        jPanelCampos.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 150, 120));

        jLabelCantidad1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelCantidad1.setForeground(new java.awt.Color(0, 0, 153));
        jLabelCantidad1.setText("Cantidad producto:");
        jPanelCampos.add(jLabelCantidad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 140, -1));

        textCantidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textCantidad.setForeground(new java.awt.Color(0, 0, 153));
        textCantidad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelCampos.add(textCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 160, 30));

        jLabelTipo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTipo.setForeground(new java.awt.Color(0, 0, 153));
        jLabelTipo.setText("Tipo de contenedor:");
        jPanelCampos.add(jLabelTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, -1));

        textTipo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textTipo.setForeground(new java.awt.Color(0, 0, 153));
        textTipo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelCampos.add(textTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 160, 30));

        jLabelCapacidad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelCapacidad.setForeground(new java.awt.Color(0, 0, 153));
        jLabelCapacidad.setText("Capacidad real:");
        jPanelCampos.add(jLabelCapacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, -1, -1));

        textCapacidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textCapacidad.setForeground(new java.awt.Color(0, 0, 153));
        textCapacidad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelCampos.add(textCapacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 160, 30));

        jLabelReserva.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelReserva.setForeground(new java.awt.Color(0, 0, 153));
        jLabelReserva.setText("Reserva:");
        jPanelCampos.add(jLabelReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, -1, -1));

        textReserva.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textReserva.setForeground(new java.awt.Color(0, 0, 153));
        textReserva.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelCampos.add(textReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 160, 30));

        jLabelFechaRegistro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelFechaRegistro.setForeground(new java.awt.Color(0, 0, 153));
        jLabelFechaRegistro.setText("Fecha último control:");
        jPanelCampos.add(jLabelFechaRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, -1, -1));

        jLabelFechaRecibo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelFechaRecibo.setForeground(new java.awt.Color(0, 0, 153));
        jLabelFechaRecibo.setText("Fecha próximo control:");
        jPanelCampos.add(jLabelFechaRecibo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, -1, -1));

        jLabelStatus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelStatus.setForeground(new java.awt.Color(0, 0, 153));
        jLabelStatus.setText("Status:");
        jPanelCampos.add(jLabelStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        textFechaUltimo.setEditable(false);
        textFechaUltimo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textFechaUltimo.setForeground(new java.awt.Color(0, 0, 153));
        textFechaUltimo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelCampos.add(textFechaUltimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 140, 30));

        textFechaProximo.setEditable(false);
        textFechaProximo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textFechaProximo.setForeground(new java.awt.Color(0, 0, 153));
        textFechaProximo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelCampos.add(textFechaProximo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 160, 30));

        jButtonModificarFecha.setBackground(new java.awt.Color(0, 0, 153));
        jButtonModificarFecha.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonModificarFecha.setForeground(new java.awt.Color(255, 255, 255));
        jButtonModificarFecha.setText("Modificar fechas");
        jButtonModificarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarFechaActionPerformed(evt);
            }
        });
        jPanelCampos.add(jButtonModificarFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 330, -1, 30));

        cmbStatus.setForeground(new java.awt.Color(0, 0, 153));
        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponible ", "Reservado", "En uso", "No disponible", "En reparación", "En control", "En limpieza", "Fuera de circulación" }));
        cmbStatus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cmbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStatusActionPerformed(evt);
            }
        });
        jPanelCampos.add(cmbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 120, 40));

        jLabelNombreBuque.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNombreBuque.setForeground(new java.awt.Color(0, 0, 153));
        jLabelNombreBuque.setText("Compañia transporte:");
        jPanelCampos.add(jLabelNombreBuque, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, -1, -1));

        textCompañia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textCompañia.setForeground(new java.awt.Color(0, 0, 153));
        textCompañia.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelCampos.add(textCompañia, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 150, 30));

        jPanel1.add(jPanelCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 20, 720, 400));

        jPanelTablaContenedores.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 153));

        jTableContenedores.setBackground(new java.awt.Color(204, 204, 204));
        jTableContenedores.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTableContenedores.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableContenedores);

        jPanelTablaContenedores.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 1480, 270));

        jPanel1.add(jPanelTablaContenedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 1520, 360));

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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1910, 900));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButtonRecargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonRecargarActionPerformed

        mostrarTodosLosDatosContenedores();
        mostrarTodosLosDatosDetalles();
        pasarCamposDeLasTablasAFields();
        
    }//GEN-LAST:event_jToggleButtonRecargarActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed

        String codigoMod, empresaMod, productoMod, tipoMod, compañiaTransporteMod, 
                reservaMod, statusMod = null, busqueda;

        int statusNivel = 0, IDMod, cantidadMod;
        Double capacidadMod;

        busqueda = textBuscar.getText().trim();

        try{
                
            IDMod = Integer.parseInt(textID.getText().trim());
            cantidadMod = Integer.parseInt(textCantidad.getText().trim());
            capacidadMod = Double.valueOf(textCapacidad.getText().trim());
            codigoMod = textCodigo.getText().trim();
            empresaMod = textEmpresa.getText().trim();
            productoMod = textProducto.getText().trim();
            tipoMod = textTipo.getText().trim();
            compañiaTransporteMod = textCompañia.getText().trim();
            reservaMod = textReserva.getText().trim();

            statusNivel = cmbStatus.getSelectedIndex() + 1;

            if (statusNivel == 1) {
                statusMod = "Disponible";
            } else if (statusNivel == 2) {
                statusMod = "Reservado";
            } else if (statusNivel == 3) {
                statusMod = "En uso";
            } else if (statusNivel == 4) {
                statusMod = "No disponible";
            } else if (statusNivel == 5) {
                statusMod = "En reparación";
            } else if (statusNivel == 6) {
                statusMod= "En control";
            } else if (statusNivel == 7) {
                statusMod = "En limpieza";
            } else if (statusNivel == 8) {
                statusMod = "Fuera de circulación";
            }
           
            contenedoresImpl.modificarContenedor(IDMod, cantidadMod, capacidadMod, 
                    codigoMod, empresaMod, productoMod, tipoMod, compañiaTransporteMod, 
                    reservaMod, statusMod, busqueda);

        }catch(Exception e){
            System.err.println("Fallo al modificar datos " + e);
            JOptionPane.showMessageDialog(null, "Fallo al modificar datos");
        }

        LimpiarBusqueda();
        mostrarTodosLosDatosContenedores();
        mostrarTodosLosDatosDetalles();
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

    private void jButtonContenedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonContenedoresActionPerformed
        
        jPanelTablaContenedores.setVisible(true);
        jPanelTablaDetalles.setVisible(false);
        mostrarTodosLosDatosContenedores();
        mostrarTodosLosDatosDetalles();
        
    }//GEN-LAST:event_jButtonContenedoresActionPerformed

    private void jButtonDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDetallesActionPerformed
       
        jPanelTablaContenedores.setVisible(false);
        jPanelTablaDetalles.setVisible(true);
        mostrarTodosLosDatosContenedores();
        mostrarTodosLosDatosDetalles();
        
    }//GEN-LAST:event_jButtonDetallesActionPerformed

    private void jButtonInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInfoActionPerformed

        InformacionIDContenedor informacionIDContenedor = new InformacionIDContenedor();
        informacionIDContenedor.setVisible(true);

    }//GEN-LAST:event_jButtonInfoActionPerformed

    private void jButtonModificarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarFechaActionPerformed

        ModificarFechasControl modificarFechasControl = new ModificarFechasControl();
        modificarFechasControl.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButtonModificarFechaActionPerformed

    private void jButtonUsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUsoActionPerformed

        mostrarContenedoresEnUso();

    }//GEN-LAST:event_jButtonUsoActionPerformed

    private void jButtonDisponiblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDisponiblesActionPerformed

        mostrarContenedoresDisponibles();
        
    }//GEN-LAST:event_jButtonDisponiblesActionPerformed

    private void jToggleButtonFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonFiltrarActionPerformed

        String busqueda = textBuscar.getText().trim();
        
        String sql = "select id_contenedor, codigo, empresa, tipo, capacidad, "
                 + "status, ultimo_control, proximo_control from contenedores "
                 + "where codigo = '" + busqueda + "' or empresa = '" + busqueda + "'";
        
        cargarTablaContenedores(sql);
        cargarTablaDetalles(sql);      

    }//GEN-LAST:event_jToggleButtonFiltrarActionPerformed

    private void jButtonProximosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProximosActionPerformed
       
        mostrarProximosControles();
        
    }//GEN-LAST:event_jButtonProximosActionPerformed

    private void cmbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbStatusActionPerformed

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
            java.util.logging.Logger.getLogger(GestionDeContenedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionDeContenedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionDeContenedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionDeContenedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new GestionDeContenedores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JButton jButtonContenedores;
    private javax.swing.JButton jButtonDetalles;
    private javax.swing.JButton jButtonDisponibles;
    private javax.swing.JButton jButtonInfo;
    private javax.swing.JButton jButtonLimpiarBusqueda;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonModificarFecha;
    private javax.swing.JButton jButtonProximos;
    private javax.swing.JButton jButtonUso;
    private javax.swing.JButton jButtonVolver2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCantidad1;
    private javax.swing.JLabel jLabelCapacidad;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelFechaRecibo;
    private javax.swing.JLabel jLabelFechaRegistro;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelNombreBuque;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JLabel jLabelProductos;
    private javax.swing.JLabel jLabelReserva;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JLabel jLabelSubtitulo;
    private javax.swing.JLabel jLabelTipo;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelBusqueda;
    private javax.swing.JPanel jPanelCampos;
    private javax.swing.JPanel jPanelTablaContenedores;
    private javax.swing.JPanel jPanelTablaDetalles;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableContenedores;
    private javax.swing.JTable jTableDetalles;
    private javax.swing.JToggleButton jToggleButtonFiltrar;
    private javax.swing.JToggleButton jToggleButtonRecargar;
    private javax.swing.JTextField textBuscar;
    private javax.swing.JTextField textCantidad;
    private javax.swing.JTextField textCapacidad;
    private javax.swing.JTextField textCodigo;
    private javax.swing.JTextField textCompañia;
    private javax.swing.JTextField textEmpresa;
    private javax.swing.JTextField textFechaProximo;
    private javax.swing.JTextField textFechaUltimo;
    private javax.swing.JTextField textID;
    private javax.swing.JTextArea textProducto;
    private javax.swing.JTextField textReserva;
    private javax.swing.JTextField textTipo;
    // End of variables declaration//GEN-END:variables
}
