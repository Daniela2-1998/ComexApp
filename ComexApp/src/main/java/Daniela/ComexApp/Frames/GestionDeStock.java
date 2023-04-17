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
import service.OperacionNacionalParticipantesImpl;
import service.OperacionesInternacionalesImpl;
import service.StockImpl;

/**
 *
 * @author Daniela
 */
public class GestionDeStock extends javax.swing.JFrame {

    String usuario = "", rol = "", nombreCompleto = "";
    /**
     * Creates new form GestionDeStock
     */
    public GestionDeStock() {
        initComponents();
        
        setSize(1600, 900);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        
        PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
        
        usuario = paginaPrincipal.usuario;
        nombreCompleto = paginaPrincipal.nombreCompleto;
        
        setTitle("Gestión de stock - " + usuario + " - sistema ComexApp");
        
        mostrarTodosLosDatos();
        pasarCamposDeLaTablaAFields();
        
        OperacionesInternacionalesImpl opsInt = new OperacionesInternacionalesImpl();
        opsInt.recuperarStockQueSeActualizaHoy();
        OperacionNacionalParticipantesImpl opsNac = new OperacionNacionalParticipantesImpl();
        opsNac.recuperarStockQueSeActualizaHoy();
       
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

    StockImpl stockService = new StockImpl();
    
    
    public void cargarTablaStock(String sql){

        DefaultTableModel modelo = new DefaultTableModel();
      
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            jTableStock = new JTable(modelo);
            jScrollPane1.setViewportView(jTableStock);
            
            modelo.addColumn("ID");
            modelo.addColumn("Código");
            modelo.addColumn("Producto");
            modelo.addColumn("Tipo Producto");
            modelo.addColumn("Detalle");
            modelo.addColumn("Cuidados");
            modelo.addColumn("Cantidad");
            modelo.addColumn("Precio unitario");
            modelo.addColumn("Pais orígen");
            modelo.addColumn("Status");
            
            while(rs.next()){
                Object[] fila = new Object[10];
                for(int i = 0; i < 10; i++){
                    fila[i] = rs.getObject(i + 1);
                }
               modelo.addRow(fila);
            }
            
            conec.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al cargar el stock");
            System.err.println("Error al cargar el stock " + e);
        }
    }

   
     public void mostrarTodosLosDatos(){
         String sql = "select id_producto, codigo_producto, nombre_producto, "
                 + "tipo_producto, detalle, cuidados_requeridos, cantidad, "
                 + "precio_unitario, pais_origen, status from stock order by "
                 + "id_producto asc";
        cargarTablaStock(sql);
    }
    
     
     public void pasarCamposDeLaTablaAFields(){
    
        jTableStock.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent Mouse_evt){
                
                JTable tablaStock = (JTable) Mouse_evt.getSource();
                Point point = Mouse_evt.getPoint();
    
                int filaSeleccionada = tablaStock.rowAtPoint(point);

                if(Mouse_evt.getClickCount() == 1){
                  textID.setText(jTableStock.getValueAt(jTableStock.getSelectedRow(), 0).toString());
                  textCodigo.setText(jTableStock.getValueAt(jTableStock.getSelectedRow(), 1).toString());
                  textProducto.setText(jTableStock.getValueAt(jTableStock.getSelectedRow(), 2).toString());
                  textTipoProducto.setText(jTableStock.getValueAt(jTableStock.getSelectedRow(), 3).toString());
                  textDetalle.setText(jTableStock.getValueAt(jTableStock.getSelectedRow(), 4).toString());
                  textCuidados.setText(jTableStock.getValueAt(jTableStock.getSelectedRow(), 5).toString());
                  textCantidad.setText(jTableStock.getValueAt(jTableStock.getSelectedRow(), 6).toString());
                  textPrecioUnitario.setText(jTableStock.getValueAt(jTableStock.getSelectedRow(), 7).toString());
                  textPaisOrigen.setText(jTableStock.getValueAt(jTableStock.getSelectedRow(), 8).toString());
                  cmbStatus.setSelectedItem(jTableStock.getValueAt(jTableStock.getSelectedRow(), 9).toString());
                  
                  textBuscar.setText(jTableStock.getValueAt(jTableStock.getSelectedRow(), 2).toString());
                }
            }
        });
    }
     
     
     
     public void LimpiarBusqueda(){
         textBuscar.setText("");
     }
     
  
     public void agregarCantidad(){
        int cantidadModif = 0;
        
        try{
     
            int agregar = 1;
            int cantidad = Integer.parseInt(textCantidad.getText());
            int cantidadNueva = cantidad + agregar;
            String cantidadTotalAAgregar = String.valueOf(cantidadNueva);
            textCantidad.setText(cantidadTotalAAgregar);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se puede agregar la cantidad "
                    + "deseada al stock");
            System.err.print("No se puede agregar a stock " + e);
        }
        
     }
   
      public void disminuirCantidad(){
        int cantidadModif = 0;
        
        try{
     
            int disminuir = 1;
            int cantidad = Integer.parseInt(textCantidad.getText());
            int cantidadNueva = cantidad - disminuir;
            String cantidadTotalConDisminucion = String.valueOf(cantidadNueva);
            textCantidad.setText(cantidadTotalConDisminucion);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se puede disminuir la cantidad "
                    + "deseada al stock");
            System.err.print("No se puede disminuir el stock " + e);
        }
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableStock = new javax.swing.JTable();
        jLabelTitulo = new javax.swing.JLabel();
        jPanelBusqueda = new javax.swing.JPanel();
        jToggleButtonRecargar = new javax.swing.JToggleButton();
        jToggleButtonFiltrar = new javax.swing.JToggleButton();
        jLabelBusqueda = new javax.swing.JLabel();
        textBuscar = new javax.swing.JTextField();
        jButtonLimpiarBusqueda = new javax.swing.JButton();
        jPanelCampos = new javax.swing.JPanel();
        jLabelID = new javax.swing.JLabel();
        textID = new javax.swing.JTextField();
        jButtonInfo = new javax.swing.JButton();
        jLabelCodigo = new javax.swing.JLabel();
        textCodigo = new javax.swing.JTextField();
        jLabelPaisOrigen = new javax.swing.JLabel();
        textPaisOrigen = new javax.swing.JTextField();
        jLabelProducto = new javax.swing.JLabel();
        textProducto = new javax.swing.JTextField();
        jLabelTipo = new javax.swing.JLabel();
        textTipoProducto = new javax.swing.JTextField();
        jLabelDetalle = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textDetalle = new javax.swing.JTextArea();
        jLabelCuidados = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        textCuidados = new javax.swing.JTextArea();
        jLabelPrecio = new javax.swing.JLabel();
        textPrecioUnitario = new javax.swing.JTextField();
        jLabelStatus = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        jPanelCantidad = new javax.swing.JPanel();
        jButtonAgregar = new javax.swing.JButton();
        jButtonBajar = new javax.swing.JButton();
        jLabelCantidad = new javax.swing.JLabel();
        textCantidad = new javax.swing.JTextField();
        jButtonModificar = new javax.swing.JButton();
        jButtonVolver2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getLogo());
        setIconImages(getIconImages());
        setSize(new java.awt.Dimension(2000, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 153));

        jTableStock.setBackground(new java.awt.Color(204, 204, 204));
        jTableStock.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTableStock.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableStock);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 1480, 330));

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setText("Stock");
        jPanel1.add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 110, 60));

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
        jPanelBusqueda.add(jToggleButtonFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 240, 30));

        jLabelBusqueda.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabelBusqueda.setForeground(new java.awt.Color(0, 0, 153));
        jLabelBusqueda.setText("Nombre producto o código de producto:");
        jPanelBusqueda.add(jLabelBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 320, 20));
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

        jLabelCodigo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelCodigo.setForeground(new java.awt.Color(0, 0, 153));
        jLabelCodigo.setText("Código del producto;");
        jPanelCampos.add(jLabelCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, -1, -1));

        textCodigo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textCodigo.setForeground(new java.awt.Color(0, 0, 153));
        textCodigo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelCampos.add(textCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 163, -1));

        jLabelPaisOrigen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelPaisOrigen.setForeground(new java.awt.Color(0, 0, 153));
        jLabelPaisOrigen.setText("País de orígen:");
        jPanelCampos.add(jLabelPaisOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, -1, -1));

        textPaisOrigen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textPaisOrigen.setForeground(new java.awt.Color(0, 0, 153));
        textPaisOrigen.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelCampos.add(textPaisOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 110, 30));

        jLabelProducto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelProducto.setForeground(new java.awt.Color(0, 0, 153));
        jLabelProducto.setText("Producto:");
        jPanelCampos.add(jLabelProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, -1, -1));

        textProducto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textProducto.setForeground(new java.awt.Color(0, 0, 153));
        textProducto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelCampos.add(textProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 163, 30));

        jLabelTipo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTipo.setForeground(new java.awt.Color(0, 0, 153));
        jLabelTipo.setText("Tipo de producto:");
        jPanelCampos.add(jLabelTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        textTipoProducto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textTipoProducto.setForeground(new java.awt.Color(0, 0, 153));
        textTipoProducto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelCampos.add(textTipoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 163, 30));

        jLabelDetalle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelDetalle.setForeground(new java.awt.Color(0, 0, 153));
        jLabelDetalle.setText("Detalles:");
        jPanelCampos.add(jLabelDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, -1, -1));

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setForeground(new java.awt.Color(0, 0, 153));

        textDetalle.setColumns(10);
        textDetalle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textDetalle.setForeground(new java.awt.Color(0, 0, 153));
        textDetalle.setLineWrap(true);
        textDetalle.setRows(5);
        textDetalle.setWrapStyleWord(true);
        jScrollPane3.setViewportView(textDetalle);

        jPanelCampos.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 260, 110));

        jLabelCuidados.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelCuidados.setForeground(new java.awt.Color(0, 0, 153));
        jLabelCuidados.setText("Cuidados requeridos:");
        jPanelCampos.add(jLabelCuidados, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, -1, -1));

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setForeground(new java.awt.Color(0, 0, 153));

        textCuidados.setColumns(10);
        textCuidados.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textCuidados.setForeground(new java.awt.Color(0, 0, 153));
        textCuidados.setLineWrap(true);
        textCuidados.setRows(5);
        textCuidados.setWrapStyleWord(true);
        jScrollPane4.setViewportView(textCuidados);

        jPanelCampos.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 180, 110));

        jLabelPrecio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelPrecio.setForeground(new java.awt.Color(0, 0, 153));
        jLabelPrecio.setText("Precio unitario:");
        jPanelCampos.add(jLabelPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        textPrecioUnitario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textPrecioUnitario.setForeground(new java.awt.Color(0, 0, 153));
        textPrecioUnitario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelCampos.add(textPrecioUnitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 110, 30));

        jLabelStatus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelStatus.setForeground(new java.awt.Color(0, 0, 153));
        jLabelStatus.setText("Status;");
        jPanelCampos.add(jLabelStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        cmbStatus.setForeground(new java.awt.Color(0, 0, 153));
        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo", "Suspendido" }));
        cmbStatus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cmbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStatusActionPerformed(evt);
            }
        });
        jPanelCampos.add(cmbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 180, 40));

        jPanelCantidad.setBackground(new java.awt.Color(204, 204, 204));
        jPanelCantidad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelCantidad.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonAgregar.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jButtonAgregar.setForeground(new java.awt.Color(0, 0, 153));
        jButtonAgregar.setText("+");
        jButtonAgregar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonAgregar.setContentAreaFilled(false);
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });
        jPanelCantidad.add(jButtonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 80, 40));

        jButtonBajar.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jButtonBajar.setForeground(new java.awt.Color(0, 0, 153));
        jButtonBajar.setText("-");
        jButtonBajar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonBajar.setContentAreaFilled(false);
        jButtonBajar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBajarActionPerformed(evt);
            }
        });
        jPanelCantidad.add(jButtonBajar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 80, 40));

        jLabelCantidad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelCantidad.setForeground(new java.awt.Color(0, 0, 153));
        jLabelCantidad.setText("Cantidad disponible:");
        jPanelCantidad.add(jLabelCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        textCantidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textCantidad.setForeground(new java.awt.Color(0, 0, 153));
        textCantidad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelCantidad.add(textCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 140, 30));

        jPanelCampos.add(jPanelCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 360, 140));

        jButtonModificar.setBackground(new java.awt.Color(0, 0, 153));
        jButtonModificar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonModificar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonModificar.setText("Modificar stock");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });
        jPanelCampos.add(jButtonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 250, -1, -1));

        jButtonVolver2.setBackground(new java.awt.Color(0, 0, 153));
        jButtonVolver2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonVolver2.setForeground(new java.awt.Color(255, 255, 255));
        jButtonVolver2.setText("Volver");
        jButtonVolver2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolver2ActionPerformed(evt);
            }
        });
        jPanelCampos.add(jButtonVolver2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 320, -1, -1));

        jPanel1.add(jPanelCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 20, 690, 400));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1910, 900));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButtonRecargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonRecargarActionPerformed

        mostrarTodosLosDatos();
        
    }//GEN-LAST:event_jToggleButtonRecargarActionPerformed

    private void jToggleButtonFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonFiltrarActionPerformed

        String busqueda = textBuscar.getText().trim();
        String sql;

        if(!textBuscar.equals("")){
        
            try{

            sql = "select id_producto, codigo_producto, nombre_producto, "
                 + "tipo_producto, detalle, cuidados_requeridos, cantidad, "
                 + "precio_unitario, pais_origen, status from stock where "
                    + "nombre_producto = '" + busqueda + "' or codigo_producto = '"
                    + busqueda + "'"; 
            cargarTablaStock(sql);

            }catch(Exception e){
                System.err.println("Error al buscar por filtros" + e);
                JOptionPane.showMessageDialog(null, "No es posibe buscar por filtros");
                }
        } else if (textBuscar.equals("")){
            JOptionPane.showMessageDialog(null, "Debes colocar un nombre o código de producto");
        }
    
   
    }//GEN-LAST:event_jToggleButtonFiltrarActionPerformed

    private void jButtonInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInfoActionPerformed

        InformacionIDProductos informacionIDProductos = new InformacionIDProductos();
        informacionIDProductos.setVisible(true);

    }//GEN-LAST:event_jButtonInfoActionPerformed

    private void cmbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbStatusActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed

        String codigoMod, cuidadosMod, detalleMod, paisOrigenMod, cantidadMod,
            precioUnitarioMod, statusMod = null, tipoProductoMod, productoMod, producto;
        
        int IDMod, statusNivel;
        
        producto = textBuscar.getText().trim();

        try{

            IDMod = Integer.parseInt(textID.getText().trim());
            cantidadMod = textCantidad.getText().trim();
            codigoMod = textCodigo.getText().trim();
            cuidadosMod = textCuidados.getText().trim();
            detalleMod = textDetalle.getText().trim();
            paisOrigenMod = textPaisOrigen.getText().trim();
            precioUnitarioMod = textPrecioUnitario.getText().trim();
            tipoProductoMod = textTipoProducto.getText().trim();
            productoMod = textProducto.getText();
            statusNivel = cmbStatus.getSelectedIndex() + 1;

            if (statusNivel == 1) {
                statusMod = "Activo";
            } else if (statusNivel == 2) {
                statusMod = "Inactivo";
            } else if (statusNivel == 3) {
                statusMod = "Suspendido";
            }

            stockService.modificarStock(IDMod, cantidadMod, codigoMod, cuidadosMod, 
                    detalleMod, paisOrigenMod, precioUnitarioMod, statusMod, 
                    tipoProductoMod, productoMod, producto);

        }catch(Exception e){
            System.err.println("Fallo al modificar datos " + e);
            JOptionPane.showMessageDialog(null, "Fallo al modificar datos");
        }

    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonVolver2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolver2ActionPerformed

        StockProduccion stockProduccion= new StockProduccion();
        stockProduccion.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButtonVolver2ActionPerformed

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed

        agregarCantidad();
        
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jButtonLimpiarBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarBusquedaActionPerformed
        
        LimpiarBusqueda();
       
    }//GEN-LAST:event_jButtonLimpiarBusquedaActionPerformed

    private void jButtonBajarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBajarActionPerformed

        disminuirCantidad();
        
    }//GEN-LAST:event_jButtonBajarActionPerformed

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
            java.util.logging.Logger.getLogger(GestionDeStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionDeStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionDeStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionDeStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionDeStock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonBajar;
    private javax.swing.JButton jButtonInfo;
    private javax.swing.JButton jButtonLimpiarBusqueda;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonVolver2;
    private javax.swing.JLabel jLabelBusqueda;
    private javax.swing.JLabel jLabelCantidad;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelCuidados;
    private javax.swing.JLabel jLabelDetalle;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelPaisOrigen;
    private javax.swing.JLabel jLabelPrecio;
    private javax.swing.JLabel jLabelProducto;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JLabel jLabelTipo;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelBusqueda;
    private javax.swing.JPanel jPanelCampos;
    private javax.swing.JPanel jPanelCantidad;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTableStock;
    private javax.swing.JToggleButton jToggleButtonFiltrar;
    private javax.swing.JToggleButton jToggleButtonRecargar;
    private javax.swing.JTextField textBuscar;
    private javax.swing.JTextField textCantidad;
    private javax.swing.JTextField textCodigo;
    private javax.swing.JTextArea textCuidados;
    private javax.swing.JTextArea textDetalle;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textPaisOrigen;
    private javax.swing.JTextField textPrecioUnitario;
    private javax.swing.JTextField textProducto;
    private javax.swing.JTextField textTipoProducto;
    // End of variables declaration//GEN-END:variables
}
