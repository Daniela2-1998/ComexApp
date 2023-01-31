package Daniela.ComexApp.Frames;

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
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import service.ObjetivosImpl;

/**
 *
 * @author Daniela
 */
public class Objetivos extends javax.swing.JFrame {

     String usuario = "", rol = "", nombreCompleto = "";
    /**
     * Creates new form Objetivos
     */
    public Objetivos() {
        initComponents();
        
        setSize(1500, 900);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        
        PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
        
        usuario = paginaPrincipal.usuario;
        nombreCompleto = paginaPrincipal.nombreCompleto;
        rol = paginaPrincipal.rol;

        setTitle("Objetivos - " + usuario + " - sistema ComexApp");

        jPanelCrear.setVisible(false);
        jPanelVer.setVisible(false);
        jPanelMensajes.setVisible(false);
        jPanelProximos.setVisible(true);

        textElegirUsuario.setVisible(false);

        buttonGroupFiltro.getSelection();
        jRadioButtonTodos.setSelected(true);

        VistaObjetivosSegunRol(rol);
        VistaProximosObjetivosSegunRol(rol);
    }

    // icono
    public Image getLogo(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/loguito1.png"));
        return retValue;   
    }

    ObjetivosImpl objetivosImpl = new ObjetivosImpl();
    
    LocalDate fechaActual = LocalDate.now();
    LocalDate fechaDiasPlus = fechaActual.plusDays(5);
    
    // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;
    

    public String obtenerNivelImportancia(){
       
        String importanciaElegida = null;
        
        if(jRadioButtonAlta.isSelected()){
            importanciaElegida = "Alta";
        }
        if(jRadioButtonMedia.isSelected()){
            importanciaElegida = "Media";
        }
        if(jRadioButtonBaja.isSelected()){
            importanciaElegida = "Baja";
        }
        
        return importanciaElegida;
    }

    
    public void cargarTablaProximosObjetivosRol(LocalDate fechaActual, LocalDate fechaDiasPlus){

        DefaultTableModel modelo = new DefaultTableModel();
        
    
        Date fechaInicio = Date.valueOf(fechaActual);
        Date fechaFin = Date.valueOf(fechaDiasPlus);

        
        String sql = "select fecha_objetivo, objetivo, usuario_creador, importancia, "
                + "visibilidad, fecha_registro, status from objetivos where "
                + "fecha_objetivo between '" + fechaActual + "' and '" + fechaDiasPlus + "' "
                + " and visibilidad = '" + rol + "' order by fecha_objetivo asc";

        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            jTableProximos = new JTable(modelo);
            jScrollPane6.setViewportView(jTableProximos);
            
            modelo.addColumn("Fecha del objetivo");
            modelo.addColumn("Objetivo");
            modelo.addColumn("Creador");
            modelo.addColumn("Importancia");
            modelo.addColumn("Usuarios afectados");
            modelo.addColumn("Fecha creación");
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
            JOptionPane.showMessageDialog(null, "Error al cargar los datos "
                    + "de la tabla");
            System.err.println("Error al cargar los datos de la tabla" + e);
        }
    }
    
    
    
    public void cargarTablaProximosObjetivosAdmin(LocalDate fechaActual, LocalDate fechaDiasPlus){

        DefaultTableModel modelo = new DefaultTableModel();
        
    
        Date fechaInicio = Date.valueOf(fechaActual);
        Date fechaFin = Date.valueOf(fechaDiasPlus);

        
        String sql = "select fecha_objetivo, objetivo, usuario_creador, importancia, "
                + "visibilidad, fecha_registro, status from objetivos where "
                + "fecha_objetivo between '" + fechaActual + "' and '" + fechaDiasPlus + "' "
                + "order by fecha_objetivo asc";

        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            jTableProximos = new JTable(modelo);
            jScrollPane6.setViewportView(jTableProximos);
            
            modelo.addColumn("Fecha del objetivo");
            modelo.addColumn("Objetivo");
            modelo.addColumn("Creador");
            modelo.addColumn("Importancia");
            modelo.addColumn("Usuarios afectados");
            modelo.addColumn("Fecha creación");
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
            JOptionPane.showMessageDialog(null, "Error al cargar los datos "
                    + "de la tabla");
            System.err.println("Error al cargar los datos de la tabla" + e);
        }
    }
    
    public void cargarTablaObjetivos(String sql){

        DefaultTableModel modelo = new DefaultTableModel();
      
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            jTableObjetivos = new JTable(modelo);
            jScrollPane5.setViewportView(jTableObjetivos);
            
            modelo.addColumn("Fecha del objetivo");
            modelo.addColumn("Objetivo");
            modelo.addColumn("Creador");
            modelo.addColumn("Importancia");
            modelo.addColumn("Usuarios afectados");
            modelo.addColumn("Fecha creación");
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
            JOptionPane.showMessageDialog(null, "Error al cargar los datos "
                    + "de la tabla");
            System.err.println("Error al cargar los datos de la tabla" + e);
        }
    }
   
    public void mostrarTodosLosObjetivosRol(){
        String sql = "select fecha_objetivo, objetivo, usuario_creador, importancia, "
                + "visibilidad, fecha_registro, status from objetivos where "
                + "visibilidad = '" + rol + "'";
        cargarTablaObjetivos(sql);
    }
     
    public void mostrarTodosLosObjetivosAdmin(){
         String sql = "select fecha_objetivo, objetivo, usuario_creador, importancia, "
                 + "visibilidad, fecha_registro, status from objetivos";
        cargarTablaObjetivos(sql);
    }
     
    public void mostrarTodosLosObjetivosEnProgreso(){
         String sql = "select fecha_objetivo, objetivo, usuario_creador, importancia, "
                 + "visibilidad, fecha_registro, status from objetivos where "
                 + "status = 'En progreso'";
        cargarTablaObjetivos(sql);
    }
    
  
    public void mostrarTodosLosObjetivosProximos(){
         String sql = "select fecha_objetivo, objetivo, usuario_creador, importancia, "
                 + "visibilidad, fecha_registro, status from objetivos where "
                 + "fecha_objetivo >= '" + fechaActual + "' order by fecha_objetivo asc";
        cargarTablaObjetivos(sql);
    }
     
    public void VistaObjetivosSegunRol(String rol){
        if(rol.equals("Administrador")){
           mostrarTodosLosObjetivosAdmin();
       } else {
           mostrarTodosLosObjetivosRol();
       }
    }
    
    public void VistaProximosObjetivosSegunRol(String rol){
        if(rol.equals("Administrador")){
           cargarTablaProximosObjetivosAdmin(fechaActual, fechaDiasPlus);
       } else {
           cargarTablaProximosObjetivosRol(fechaActual, fechaDiasPlus);
       }
    }
    
    public void pasarCamposDeLaTablaProximosAFields(){
    
        jTableProximos.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent Mouse_evt){
                
                JTable tablaProximos = (JTable) Mouse_evt.getSource();
                Point point = Mouse_evt.getPoint();
    
                int filaSeleccionada = tablaProximos.rowAtPoint(point);

                if(Mouse_evt.getClickCount() == 1){
                  jLabelFechaObj1.setText(jTableProximos.getValueAt(jTableProximos.getSelectedRow(), 0).toString());
                  jLabelObjetivoRec1.setText(jTableProximos.getValueAt(jTableProximos.getSelectedRow(), 1).toString());
                  jLabelImportancia1.setText(jTableProximos.getValueAt(jTableProximos.getSelectedRow(), 3).toString());
                  jLabelFechaObj1.setText(jTableProximos.getValueAt(jTableProximos.getSelectedRow(), 5).toString());
                }
            }
        });
    }

     
    public void recuperarDatosFaltantesDelProximoMensaje(){
        
    }
 // ID, Detalles y status
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupImportancia = new javax.swing.ButtonGroup();
        buttonGroupFiltro = new javax.swing.ButtonGroup();
        jPanelCrear = new javax.swing.JPanel();
        jPanelBase = new javax.swing.JPanel();
        textObjetivo = new javax.swing.JTextField();
        jLabelObjetivo = new javax.swing.JLabel();
        jLabelN = new javax.swing.JLabel();
        textID = new javax.swing.JTextField();
        jLabelVisibilidad = new javax.swing.JLabel();
        cmbVisibilidad = new javax.swing.JComboBox<>();
        textElegirUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanelContenido = new javax.swing.JPanel();
        jLabelDescripcion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textDescripcion = new javax.swing.JTextArea();
        jLabelFecha = new javax.swing.JLabel();
        jLabelImportancia = new javax.swing.JLabel();
        jRadioButtonAlta = new javax.swing.JRadioButton();
        jRadioButtonMedia = new javax.swing.JRadioButton();
        jRadioButtonBaja = new javax.swing.JRadioButton();
        jButtonEstablecer = new javax.swing.JButton();
        jMonthChooser = new com.toedter.calendar.JMonthChooser();
        jYearChooser = new com.toedter.calendar.JYearChooser();
        jDayChooser = new com.toedter.calendar.JDayChooser();
        jPanelVer = new javax.swing.JPanel();
        jLabelTituloVer = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableObjetivos = new javax.swing.JTable();
        jPanelBusqueda = new javax.swing.JPanel();
        jLabelFiltro = new javax.swing.JLabel();
        jRadioButtonFecha = new javax.swing.JRadioButton();
        jRadioButtonEnProgreso = new javax.swing.JRadioButton();
        jRadioButtonRol = new javax.swing.JRadioButton();
        textRol = new javax.swing.JTextField();
        jRadioButtonTodos = new javax.swing.JRadioButton();
        jButtonBuscar = new javax.swing.JButton();
        jPanelMensajes = new javax.swing.JPanel();
        jPanelProximos = new javax.swing.JPanel();
        jPanelMensaje1 = new javax.swing.JPanel();
        jLabelObjetivoRec1 = new javax.swing.JLabel();
        jLabelFechaPub1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textDetalles1 = new javax.swing.JTextArea();
        jLabelImportancia1 = new javax.swing.JLabel();
        jLabelFechaObj1 = new javax.swing.JLabel();
        jLabelID1 = new javax.swing.JLabel();
        jLabelTitulo1 = new javax.swing.JLabel();
        jPanelMensaje2 = new javax.swing.JPanel();
        jLabelObjetivoRec2 = new javax.swing.JLabel();
        jLabelFechaPub2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textDetalles2 = new javax.swing.JTextArea();
        jLabelImportancia2 = new javax.swing.JLabel();
        jLabelFechaObj2 = new javax.swing.JLabel();
        jLabelID2 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableProximos = new javax.swing.JTable();
        jPanelMenu = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jButtonCrear = new javax.swing.JButton();
        jButtonUltimos = new javax.swing.JButton();
        jButtonVer = new javax.swing.JButton();
        jButtonMensajes = new javax.swing.JButton();
        jButtonRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getLogo());
        setIconImages(getIconImages());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelCrear.setBackground(new java.awt.Color(204, 204, 204));
        jPanelCrear.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        jPanelBase.setBorder(dropShadowBorder1);
        jPanelBase.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textObjetivo.setForeground(new java.awt.Color(102, 102, 102));
        jPanelBase.add(textObjetivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 200, -1));

        jLabelObjetivo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelObjetivo.setForeground(new java.awt.Color(102, 102, 102));
        jLabelObjetivo.setText("Objetivo:");
        jPanelBase.add(jLabelObjetivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabelN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelN.setForeground(new java.awt.Color(102, 102, 102));
        jLabelN.setText("N°:");
        jPanelBase.add(jLabelN, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, -1, -1));

        textID.setForeground(new java.awt.Color(102, 102, 102));
        jPanelBase.add(textID, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 50, -1));

        jLabelVisibilidad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelVisibilidad.setForeground(new java.awt.Color(102, 102, 102));
        jLabelVisibilidad.setText("Visibilidad:");
        jPanelBase.add(jLabelVisibilidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, -1, -1));

        cmbVisibilidad.setForeground(new java.awt.Color(102, 102, 102));
        cmbVisibilidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Administrador", "Importador", "Exportador", "Agente", "Logistica", "Marketing", "Elegir un usuario" }));
        jPanelBase.add(cmbVisibilidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 120, -1));

        textElegirUsuario.setForeground(new java.awt.Color(102, 102, 102));
        jPanelBase.add(textElegirUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 120, -1));

        jPanelCrear.add(jPanelBase, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 540, 130));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Establezca un objetivo:");
        jPanelCrear.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder2 = new org.jdesktop.swingx.border.DropShadowBorder();
        jPanelContenido.setBorder(dropShadowBorder2);
        jPanelContenido.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDescripcion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelDescripcion.setForeground(new java.awt.Color(102, 102, 102));
        jLabelDescripcion.setText("Descripción del objetivo:");
        jPanelContenido.add(jLabelDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 20));

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 204));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setHorizontalScrollBar(null);

        textDescripcion.setBackground(new java.awt.Color(204, 204, 204));
        textDescripcion.setColumns(5);
        textDescripcion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        textDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        textDescripcion.setLineWrap(true);
        textDescripcion.setRows(5);
        textDescripcion.setTabSize(5);
        textDescripcion.setWrapStyleWord(true);
        jScrollPane1.setViewportView(textDescripcion);

        jPanelContenido.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 390, 320));

        jLabelFecha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelFecha.setForeground(new java.awt.Color(102, 102, 102));
        jLabelFecha.setText("Fecha objetiva:");
        jPanelContenido.add(jLabelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, -1, 20));

        jLabelImportancia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelImportancia.setForeground(new java.awt.Color(102, 102, 102));
        jLabelImportancia.setText("Nivel de importancia:");
        jPanelContenido.add(jLabelImportancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, -1, 20));

        buttonGroupImportancia.add(jRadioButtonAlta);
        jRadioButtonAlta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRadioButtonAlta.setForeground(new java.awt.Color(255, 0, 0));
        jRadioButtonAlta.setSelected(true);
        jRadioButtonAlta.setText("Importancia alta");
        jPanelContenido.add(jRadioButtonAlta, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 250, -1, 20));

        buttonGroupImportancia.add(jRadioButtonMedia);
        jRadioButtonMedia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRadioButtonMedia.setForeground(new java.awt.Color(204, 204, 0));
        jRadioButtonMedia.setText("Importancia regular o media");
        jPanelContenido.add(jRadioButtonMedia, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, -1, -1));

        buttonGroupImportancia.add(jRadioButtonBaja);
        jRadioButtonBaja.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRadioButtonBaja.setForeground(new java.awt.Color(0, 204, 0));
        jRadioButtonBaja.setText("Importancia baja");
        jPanelContenido.add(jRadioButtonBaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 290, -1, -1));

        jButtonEstablecer.setBackground(new java.awt.Color(204, 204, 204));
        jButtonEstablecer.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButtonEstablecer.setForeground(new java.awt.Color(102, 102, 102));
        jButtonEstablecer.setText("Establecer");
        jButtonEstablecer.setBorder(null);
        jButtonEstablecer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEstablecerActionPerformed(evt);
            }
        });
        jPanelContenido.add(jButtonEstablecer, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 310, 160, 40));

        jMonthChooser.setForeground(new java.awt.Color(102, 102, 102));
        jMonthChooser.setDayChooser(jDayChooser);
        jMonthChooser.setYearChooser(jYearChooser);
        jPanelContenido.add(jMonthChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 70, -1, -1));

        jYearChooser.setDayChooser(jDayChooser);
        jPanelContenido.add(jYearChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 110, -1, 20));

        jDayChooser.setForeground(new java.awt.Color(102, 102, 102));
        jPanelContenido.add(jDayChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 320, 160));

        jPanelCrear.add(jPanelContenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 890, 380));

        getContentPane().add(jPanelCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 1250, 880));

        jPanelVer.setBackground(new java.awt.Color(204, 204, 204));
        jPanelVer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTituloVer.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelTituloVer.setForeground(new java.awt.Color(102, 102, 102));
        jLabelTituloVer.setText("Objetivos establecidos en el sistema ComexApp.");
        jPanelVer.add(jLabelTituloVer, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, -1));

        jTableObjetivos.setModel(jTableObjetivos.getModel());
        jScrollPane5.setViewportView(jTableObjetivos);
        if (jTableObjetivos.getColumnModel().getColumnCount() > 0) {
            jTableObjetivos.getColumnModel().getColumn(0).setMinWidth(200);
            jTableObjetivos.getColumnModel().getColumn(0).setPreferredWidth(200);
            jTableObjetivos.getColumnModel().getColumn(0).setHeaderValue("Title 1");
            jTableObjetivos.getColumnModel().getColumn(1).setHeaderValue("Title 2");
            jTableObjetivos.getColumnModel().getColumn(2).setHeaderValue("Title 3");
            jTableObjetivos.getColumnModel().getColumn(3).setHeaderValue("Title 4");
        }

        jPanelVer.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 1150, 420));

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder3 = new org.jdesktop.swingx.border.DropShadowBorder();
        jPanelBusqueda.setBorder(dropShadowBorder3);
        jPanelBusqueda.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelFiltro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelFiltro.setForeground(new java.awt.Color(102, 102, 102));
        jLabelFiltro.setText("Filtrar lista de objetivos:");
        jPanelBusqueda.add(jLabelFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        buttonGroupFiltro.add(jRadioButtonFecha);
        jRadioButtonFecha.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRadioButtonFecha.setForeground(new java.awt.Color(102, 102, 102));
        jRadioButtonFecha.setText("Más cercanos a fecha limite");
        jPanelBusqueda.add(jRadioButtonFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, -1));

        buttonGroupFiltro.add(jRadioButtonEnProgreso);
        jRadioButtonEnProgreso.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRadioButtonEnProgreso.setForeground(new java.awt.Color(102, 102, 102));
        jRadioButtonEnProgreso.setText("Objetivos en progreso");
        jPanelBusqueda.add(jRadioButtonEnProgreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, -1, -1));

        buttonGroupFiltro.add(jRadioButtonRol);
        jRadioButtonRol.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRadioButtonRol.setForeground(new java.awt.Color(102, 102, 102));
        jRadioButtonRol.setText("Según rol o usuario: ");
        jPanelBusqueda.add(jRadioButtonRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, -1, -1));

        textRol.setForeground(new java.awt.Color(102, 102, 102));
        jPanelBusqueda.add(textRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 40, 140, -1));

        buttonGroupFiltro.add(jRadioButtonTodos);
        jRadioButtonTodos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRadioButtonTodos.setForeground(new java.awt.Color(102, 102, 102));
        jRadioButtonTodos.setSelected(true);
        jRadioButtonTodos.setText("Todos los objetivos");
        jPanelBusqueda.add(jRadioButtonTodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 40, -1, -1));

        jButtonBuscar.setBackground(new java.awt.Color(204, 204, 204));
        jButtonBuscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonBuscar.setForeground(new java.awt.Color(102, 102, 102));
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        jPanelBusqueda.add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 40, -1, -1));

        jPanelVer.add(jPanelBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 1150, 100));

        getContentPane().add(jPanelVer, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 1250, 880));

        jPanelMensajes.setBackground(new java.awt.Color(204, 204, 204));
        jPanelMensajes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanelMensajes, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 1250, 880));

        jPanelProximos.setBackground(new java.awt.Color(204, 204, 204));
        jPanelProximos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder4 = new org.jdesktop.swingx.border.DropShadowBorder();
        jPanelMensaje1.setBorder(dropShadowBorder4);
        jPanelMensaje1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelObjetivoRec1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelObjetivoRec1.setForeground(new java.awt.Color(102, 102, 102));
        jPanelMensaje1.add(jLabelObjetivoRec1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabelFechaPub1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelFechaPub1.setForeground(new java.awt.Color(102, 102, 102));
        jPanelMensaje1.add(jLabelFechaPub1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 150, 150, -1));

        textDetalles1.setColumns(20);
        textDetalles1.setRows(5);
        jScrollPane2.setViewportView(textDetalles1);

        jPanelMensaje1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 660, -1));
        jPanelMensaje1.add(jLabelImportancia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, -1, -1));
        jPanelMensaje1.add(jLabelFechaObj1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, -1, -1));

        jLabelID1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelID1.setForeground(new java.awt.Color(102, 102, 102));
        jPanelMensaje1.add(jLabelID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jPanelProximos.add(jPanelMensaje1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 710, 170));

        jLabelTitulo1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelTitulo1.setForeground(new java.awt.Color(102, 102, 102));
        jLabelTitulo1.setText("Últimos 3 objetivos registrados en el sistema.");
        jPanelProximos.add(jLabelTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 530, 50));

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder5 = new org.jdesktop.swingx.border.DropShadowBorder();
        jPanelMensaje2.setBorder(dropShadowBorder5);
        jPanelMensaje2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelObjetivoRec2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelObjetivoRec2.setForeground(new java.awt.Color(102, 102, 102));
        jPanelMensaje2.add(jLabelObjetivoRec2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabelFechaPub2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelFechaPub2.setForeground(new java.awt.Color(102, 102, 102));
        jPanelMensaje2.add(jLabelFechaPub2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 150, 150, -1));

        textDetalles2.setColumns(20);
        textDetalles2.setRows(5);
        jScrollPane3.setViewportView(textDetalles2);

        jPanelMensaje2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 660, -1));
        jPanelMensaje2.add(jLabelImportancia2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, -1, -1));
        jPanelMensaje2.add(jLabelFechaObj2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, -1, -1));

        jLabelID2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelID2.setForeground(new java.awt.Color(102, 102, 102));
        jPanelMensaje2.add(jLabelID2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jPanelProximos.add(jPanelMensaje2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 710, 170));

        jTableProximos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(jTableProximos);

        jPanelProximos.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, 1170, 300));

        getContentPane().add(jPanelProximos, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 1250, 880));

        jPanelMenu.setBackground(new java.awt.Color(153, 153, 153));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder6 = new org.jdesktop.swingx.border.DropShadowBorder();
        jPanelMenu.setBorder(dropShadowBorder6);
        jPanelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(204, 204, 204));
        jLabelTitulo.setText("Objetivos establecidos");
        jPanelMenu.add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 230, 70));

        jButtonCrear.setBackground(new java.awt.Color(204, 204, 204));
        jButtonCrear.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButtonCrear.setForeground(new java.awt.Color(102, 102, 102));
        jButtonCrear.setText("Crear objetivo");
        jButtonCrear.setBorder(null);
        jButtonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearActionPerformed(evt);
            }
        });
        jPanelMenu.add(jButtonCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 170, 40));

        jButtonUltimos.setBackground(new java.awt.Color(204, 204, 204));
        jButtonUltimos.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButtonUltimos.setForeground(new java.awt.Color(102, 102, 102));
        jButtonUltimos.setText("Próximos objetivos");
        jButtonUltimos.setBorder(null);
        jButtonUltimos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUltimosActionPerformed(evt);
            }
        });
        jPanelMenu.add(jButtonUltimos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 170, 40));

        jButtonVer.setBackground(new java.awt.Color(204, 204, 204));
        jButtonVer.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButtonVer.setForeground(new java.awt.Color(102, 102, 102));
        jButtonVer.setText("Visualizar objetivos");
        jButtonVer.setBorder(null);
        jButtonVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerActionPerformed(evt);
            }
        });
        jPanelMenu.add(jButtonVer, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 170, 40));

        jButtonMensajes.setBackground(new java.awt.Color(204, 204, 204));
        jButtonMensajes.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButtonMensajes.setForeground(new java.awt.Color(102, 102, 102));
        jButtonMensajes.setText("Mensajes");
        jButtonMensajes.setBorder(null);
        jButtonMensajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMensajesActionPerformed(evt);
            }
        });
        jPanelMenu.add(jButtonMensajes, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 170, 40));

        jButtonRegresar.setBackground(new java.awt.Color(204, 204, 204));
        jButtonRegresar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButtonRegresar.setForeground(new java.awt.Color(102, 102, 102));
        jButtonRegresar.setText("Regresar");
        jButtonRegresar.setBorder(null);
        jButtonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegresarActionPerformed(evt);
            }
        });
        jPanelMenu.add(jButtonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 640, 170, 30));

        getContentPane().add(jPanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEstablecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEstablecerActionPerformed

        String descripcion, fechaLimite, fechaRegistro, nivelImportancia, 
                objetivo, status, visibilidad = null;
       
        int ID, visibilidadNivel, mesNum;
        
        Date fechaObjetivo;
                
        LocalDate fechaActual = LocalDate.now();
        Date ahora = Date.valueOf(fechaActual);
        
         int dia = jDayChooser.getDay();
         int mes = jMonthChooser.getMonth() + 1;
         int año = jYearChooser.getYear();
        
        fechaLimite = año + "-" + mes + "-" + dia;
        
        fechaRegistro = fechaActual.toString();
        fechaObjetivo = Date.valueOf(fechaLimite);
        
        ID = Integer.parseInt(textID.getText().trim());
        descripcion = textDescripcion.getText().trim();
        objetivo = textObjetivo.getText().trim();
        status = "En progreso";
        nivelImportancia = obtenerNivelImportancia();
        visibilidadNivel = cmbVisibilidad.getSelectedIndex() + 1;
        
        if(visibilidadNivel == 1){
            visibilidad = "Todos";
        } else if(visibilidadNivel == 2){
            visibilidad = "Administrador";
        } else if(visibilidadNivel == 3){
            visibilidad = "Importador";
        } else if(visibilidadNivel == 4){
            visibilidad = "Exportador";
        } else if(visibilidadNivel == 5){
            visibilidad = "Agente";
        } else if(visibilidadNivel == 6){
            visibilidad = "Logistica";
        } else if(visibilidadNivel == 7){
            visibilidad = "Marketing";
        } else if(visibilidadNivel == 7){
            textElegirUsuario.setVisible(true);
            visibilidad = textElegirUsuario.getSelectedText().trim();
        }
        
        
        objetivosImpl.establecerObjetivo(ID, descripcion, fechaLimite, fechaRegistro, 
                nivelImportancia, objetivo, status, usuario, visibilidad, fechaObjetivo);
        
        VistaObjetivosSegunRol(rol);
        mostrarTodosLosObjetivosRol();
        
    }//GEN-LAST:event_jButtonEstablecerActionPerformed

    private void jButtonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearActionPerformed
        
       jPanelCrear.setVisible(true);
       textElegirUsuario.setVisible(false);
       jPanelVer.setVisible(false);
       jPanelMensajes.setVisible(false);
       jPanelProximos.setVisible(false);
        
    }//GEN-LAST:event_jButtonCrearActionPerformed

    private void jButtonUltimosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUltimosActionPerformed
        
       jPanelCrear.setVisible(false);
       jPanelVer.setVisible(false);
       jPanelMensajes.setVisible(false);
       jPanelProximos.setVisible(true);
       
    }//GEN-LAST:event_jButtonUltimosActionPerformed

    private void jButtonVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerActionPerformed
       
       jPanelCrear.setVisible(false);
       jPanelVer.setVisible(true);
       jPanelMensajes.setVisible(false);
       jPanelProximos.setVisible(false);
       
       jRadioButtonTodos.setSelected(true);
       
       VistaObjetivosSegunRol(rol);
       
    }//GEN-LAST:event_jButtonVerActionPerformed

    private void jButtonMensajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMensajesActionPerformed
        
       jPanelCrear.setVisible(false);
       jPanelVer.setVisible(false);
       jPanelMensajes.setVisible(true);
       jPanelProximos.setVisible(false);
       
    }//GEN-LAST:event_jButtonMensajesActionPerformed

    private void jButtonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegresarActionPerformed
        
        PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
        paginaPrincipal.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButtonRegresarActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        
        buttonGroupFiltro.getSelection();
        
        if (jRadioButtonFecha.isSelected() == true) {
            mostrarTodosLosObjetivosProximos();
            jRadioButtonEnProgreso.setSelected(false);
            jRadioButtonRol.setSelected(false);
            jRadioButtonTodos.setSelected(false);
        }
        if (jRadioButtonEnProgreso.isSelected() == true) {
            mostrarTodosLosObjetivosEnProgreso();
            jRadioButtonFecha.setSelected(false);
            jRadioButtonRol.setSelected(false);
            jRadioButtonTodos.setSelected(false);
        }
        if (jRadioButtonRol.isSelected() == true) {
            mostrarTodosLosObjetivosRol();
            jRadioButtonFecha.setSelected(false);
            jRadioButtonEnProgreso.setSelected(false);
            jRadioButtonTodos.setSelected(false);
        }
        if (jRadioButtonTodos.isSelected() == true) {
            VistaObjetivosSegunRol(rol);
            jRadioButtonFecha.setSelected(false);
            jRadioButtonEnProgreso.setSelected(false);
            jRadioButtonRol.setSelected(false);
        }

        
    }//GEN-LAST:event_jButtonBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(Objetivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Objetivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Objetivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Objetivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Objetivos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupFiltro;
    private javax.swing.ButtonGroup buttonGroupImportancia;
    private javax.swing.JComboBox<String> cmbVisibilidad;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCrear;
    private javax.swing.JButton jButtonEstablecer;
    private javax.swing.JButton jButtonMensajes;
    private javax.swing.JButton jButtonRegresar;
    private javax.swing.JButton jButtonUltimos;
    private javax.swing.JButton jButtonVer;
    private com.toedter.calendar.JDayChooser jDayChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelDescripcion;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelFechaObj1;
    private javax.swing.JLabel jLabelFechaObj2;
    private javax.swing.JLabel jLabelFechaPub1;
    private javax.swing.JLabel jLabelFechaPub2;
    private javax.swing.JLabel jLabelFiltro;
    private javax.swing.JLabel jLabelID1;
    private javax.swing.JLabel jLabelID2;
    private javax.swing.JLabel jLabelImportancia;
    private javax.swing.JLabel jLabelImportancia1;
    private javax.swing.JLabel jLabelImportancia2;
    private javax.swing.JLabel jLabelN;
    private javax.swing.JLabel jLabelObjetivo;
    private javax.swing.JLabel jLabelObjetivoRec1;
    private javax.swing.JLabel jLabelObjetivoRec2;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelTitulo1;
    private javax.swing.JLabel jLabelTituloVer;
    private javax.swing.JLabel jLabelVisibilidad;
    private com.toedter.calendar.JMonthChooser jMonthChooser;
    private javax.swing.JPanel jPanelBase;
    private javax.swing.JPanel jPanelBusqueda;
    private javax.swing.JPanel jPanelContenido;
    private javax.swing.JPanel jPanelCrear;
    private javax.swing.JPanel jPanelMensaje1;
    private javax.swing.JPanel jPanelMensaje2;
    private javax.swing.JPanel jPanelMensajes;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelProximos;
    private javax.swing.JPanel jPanelVer;
    private javax.swing.JRadioButton jRadioButtonAlta;
    private javax.swing.JRadioButton jRadioButtonBaja;
    private javax.swing.JRadioButton jRadioButtonEnProgreso;
    private javax.swing.JRadioButton jRadioButtonFecha;
    private javax.swing.JRadioButton jRadioButtonMedia;
    private javax.swing.JRadioButton jRadioButtonRol;
    private javax.swing.JRadioButton jRadioButtonTodos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTableObjetivos;
    private javax.swing.JTable jTableProximos;
    private com.toedter.calendar.JYearChooser jYearChooser;
    private javax.swing.JTextArea textDescripcion;
    private javax.swing.JTextArea textDetalles1;
    private javax.swing.JTextArea textDetalles2;
    private javax.swing.JTextField textElegirUsuario;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textObjetivo;
    private javax.swing.JTextField textRol;
    // End of variables declaration//GEN-END:variables
}
