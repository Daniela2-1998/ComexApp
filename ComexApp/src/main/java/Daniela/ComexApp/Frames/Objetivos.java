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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import service.MensajesDeObjetivosImpl;
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
        
        setSize(1500, 930);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        
        PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
        
        usuario = paginaPrincipal.usuario;
        nombreCompleto = paginaPrincipal.nombreCompleto;
        rol = paginaPrincipal.rol;

        mensajesObjetivosImpl.verificarMensajesSinVer(usuario, rol);
        objetivosImpl.cambiarStatusDeObjetivosConFechaCumplida();
        
        setTitle("Objetivos - " + usuario + " - sistema ComexApp");

        jPanelCrear.setVisible(false);
        jPanelVer.setVisible(false);
        jPanelMensajes.setVisible(false);
        jPanelProximos.setVisible(true);

        buttonGroupFiltro.getSelection();
        jRadioButtonTodos.setSelected(true);

        VistaObjetivosSegunRol(rol);
        
        VistaProximosObjetivosSegunRol(rol);
        pasarCamposDeLaTablaProximosAFields();
        
        cargarTablaMensajes(fechaActual);
        pasarCamposDeLaTablaMensajesAFields();
    }

    // icono
    public Image getLogo(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/loguito1.png"));
        return retValue;   
    }

    ObjetivosImpl objetivosImpl = new ObjetivosImpl();
    MensajesDeObjetivosImpl mensajesObjetivosImpl = new MensajesDeObjetivosImpl();
    
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
                + "visibilidad, fecha_creacion, status from objetivos where "
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
             llenadoPrimerObjetivoProximo();
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
                + "visibilidad, fecha_creacion, status from objetivos where "
                + "fecha_objetivo between '" + fechaActual + "' and '" + fechaDiasPlus + "' "
                + "order by fecha_objetivo asc";

        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if (rs.next()) {

                jTableProximos = new JTable(modelo);
                jScrollPane6.setViewportView(jTableProximos);

                modelo.addColumn("Fecha del objetivo");
                modelo.addColumn("Objetivo");
                modelo.addColumn("Creador");
                modelo.addColumn("Importancia");
                modelo.addColumn("Usuarios afectados");
                modelo.addColumn("Fecha creación");
                modelo.addColumn("Status");

                while (rs.next()) {
                    Object[] fila = new Object[7];
                    for (int i = 0; i < 7; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }
                    modelo.addRow(fila);
                }
             
            } else {
                JOptionPane.showMessageDialog(null, "No hay objetivos disponibles "
                        + "en los próximos 5 días");
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
                + "visibilidad, fecha_creacion, status from objetivos where "
                + "visibilidad = '" + rol + "' order by fecha_objetivo asc";
        cargarTablaObjetivos(sql);
    }
     
    public void mostrarTodosLosObjetivosAdmin(){
         String sql = "select fecha_objetivo, objetivo, usuario_creador, importancia, "
                 + "visibilidad, fecha_creacion, status from objetivos order by "
                 + "fecha_objetivo asc";
        cargarTablaObjetivos(sql);
    }
     
    public void mostrarTodosLosObjetivosEnProgreso(){
         String sql = "select fecha_objetivo, objetivo, usuario_creador, importancia, "
                 + "visibilidad, fecha_creacion, status from objetivos where "
                 + "status = 'En progreso' order by fecha_objetivo asc";
        cargarTablaObjetivos(sql);
    }
    
  
    public void mostrarTodosLosObjetivosProximos(){
         String sql = "select fecha_objetivo, objetivo, usuario_creador, importancia, "
                 + "visibilidad, fecha_creacion, status from objetivos where "
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
                  jLabelFechaObj2.setText("Fecha objetivo: " + jTableProximos.getValueAt
        (jTableProximos.getSelectedRow(), 0).toString());
                  jLabelObjetivoRec2.setText(jTableProximos.getValueAt(jTableProximos.getSelectedRow(), 1).toString());
                  jLabelImportancia2.setText(jTableProximos.getValueAt(jTableProximos.getSelectedRow(), 3).toString());
                  jLabelFechaPub2.setText("Fecha de registro: " + jTableProximos.getValueAt
        (jTableProximos.getSelectedRow(), 5).toString());
                  recuperarDatosFaltantesDelProximoMensaje(jLabelObjetivoRec2, jLabelFechaPub2, 
                jLabelID2, textDetalles2);
                }
            }
        });
    }
    
    public void llenadoPrimerObjetivoProximo(){
        jLabelFechaObj1.setText("Fecha objetivo: " + jTableProximos.getValueAt(1, 0).toString());
        jLabelObjetivoRec1.setText(jTableProximos.getValueAt(1, 1).toString());
        jLabelImportancia1.setText(jTableProximos.getValueAt(1, 3).toString());
        jLabelFechaPub1.setText("Fecha de registro: " + jTableProximos.getValueAt(1, 4).toString());
        recuperarDatosFaltantesDelProximoMensaje(jLabelObjetivoRec1, jLabelFechaPub1, 
                jLabelID1, textDetalles1);
    }
  

     
    public void recuperarDatosFaltantesDelProximoMensaje(JLabel jLabelObjetivoRec, 
            JLabel jLabelFechaPub, JLabel jLabelID, JTextArea textDetalles){
        
        String objetivo = jLabelObjetivoRec.getText().trim();
        
        String sql = "select id_objetivo, descripcion from objetivos where "
                + "objetivo = '" + objetivo + "'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                int id = rs.getInt("id_objetivo");
                jLabelID.setText(String.valueOf(id));
                textDetalles.setText(rs.getString("descripcion"));  
            }
            conec.close();
            
        }catch(SQLException e){
            System.err.println("No se pueden completar los datos faltante " + e);
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
        jButtonInfo = new javax.swing.JButton();
        textUsuario = new javax.swing.JTextField();
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
        jLabel4 = new javax.swing.JLabel();
        jButtonBuscarMensaje = new javax.swing.JButton();
        jPanelMensaje3 = new javax.swing.JPanel();
        jLabelTituloMensaje = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        textMensaje = new javax.swing.JTextArea();
        jLabelUsuario = new javax.swing.JLabel();
        jLabelFechaMensaje = new javax.swing.JLabel();
        jLabelObjetivoAsociado = new javax.swing.JLabel();
        textBusqueda = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButtonCrearMensaje = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableMensajes = new javax.swing.JTable();
        jPanelMensaje4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        textContenido = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        textTituloMensaje = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        textObjetivoAsociado = new javax.swing.JTextField();
        cmbVisibilidad1 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        textIDMensaje = new javax.swing.JTextField();
        textUsuarioElegidoMensaje = new javax.swing.JTextField();
        jButtonInfo4 = new javax.swing.JButton();
        jPanelProximos = new javax.swing.JPanel();
        jPanelMensaje1 = new javax.swing.JPanel();
        jLabelObjetivoRec1 = new javax.swing.JLabel();
        jLabelFechaPub1 = new javax.swing.JLabel();
        jLabelImportancia1 = new javax.swing.JLabel();
        jLabelFechaObj1 = new javax.swing.JLabel();
        jLabelID1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        textDetalles1 = new javax.swing.JTextArea();
        jLabelTitulo1 = new javax.swing.JLabel();
        jPanelMensaje2 = new javax.swing.JPanel();
        jLabelObjetivoRec2 = new javax.swing.JLabel();
        jLabelFechaPub2 = new javax.swing.JLabel();
        jLabelImportancia2 = new javax.swing.JLabel();
        jLabelFechaObj2 = new javax.swing.JLabel();
        jLabelID2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textDetalles2 = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableProximos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
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
        jPanelBase.add(jButtonInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, 50, -1));

        textUsuario.setForeground(new java.awt.Color(102, 102, 102));
        jPanelBase.add(textUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 120, -1));

        jPanelCrear.add(jPanelBase, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 590, 130));

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
        jPanelContenido.add(jMonthChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 210, -1, -1));

        jYearChooser.setDayChooser(jDayChooser);
        jPanelContenido.add(jYearChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 240, -1, 20));

        jDayChooser.setForeground(new java.awt.Color(102, 102, 102));
        jPanelContenido.add(jDayChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 440, 160));

        jPanelCrear.add(jPanelContenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 910, 380));

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

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Mensajes ");
        jPanelMensajes.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jButtonBuscarMensaje.setBackground(new java.awt.Color(102, 102, 102));
        jButtonBuscarMensaje.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonBuscarMensaje.setForeground(new java.awt.Color(204, 204, 204));
        jButtonBuscarMensaje.setText("Buscar objetivo");
        jButtonBuscarMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarMensajeActionPerformed(evt);
            }
        });
        jPanelMensajes.add(jButtonBuscarMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 120, -1));

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder4 = new org.jdesktop.swingx.border.DropShadowBorder();
        jPanelMensaje3.setBorder(dropShadowBorder4);
        jPanelMensaje3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTituloMensaje.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTituloMensaje.setForeground(new java.awt.Color(102, 102, 102));
        jPanelMensaje3.add(jLabelTituloMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jScrollPane7.setBackground(new java.awt.Color(204, 204, 204));
        jScrollPane7.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane7.setHorizontalScrollBar(null);

        textMensaje.setEditable(false);
        textMensaje.setBackground(new java.awt.Color(204, 204, 204));
        textMensaje.setColumns(5);
        textMensaje.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        textMensaje.setForeground(new java.awt.Color(255, 255, 255));
        textMensaje.setLineWrap(true);
        textMensaje.setRows(5);
        textMensaje.setTabSize(5);
        textMensaje.setWrapStyleWord(true);
        jScrollPane7.setViewportView(textMensaje);

        jPanelMensaje3.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 660, 90));

        jLabelUsuario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelUsuario.setForeground(new java.awt.Color(102, 102, 102));
        jPanelMensaje3.add(jLabelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 140, -1, -1));

        jLabelFechaMensaje.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelFechaMensaje.setForeground(new java.awt.Color(102, 102, 102));
        jPanelMensaje3.add(jLabelFechaMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, -1, -1));

        jLabelObjetivoAsociado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelObjetivoAsociado.setForeground(new java.awt.Color(102, 102, 102));
        jPanelMensaje3.add(jLabelObjetivoAsociado, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        jPanelMensajes.add(jPanelMensaje3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 710, 170));

        textBusqueda.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textBusqueda.setForeground(new java.awt.Color(102, 102, 102));
        jPanelMensajes.add(textBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 120, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Mensaje recuperado");
        jPanelMensajes.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, -1, -1));

        jButtonCrearMensaje.setBackground(new java.awt.Color(102, 102, 102));
        jButtonCrearMensaje.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonCrearMensaje.setForeground(new java.awt.Color(204, 204, 204));
        jButtonCrearMensaje.setText("Crear mensaje");
        jButtonCrearMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearMensajeActionPerformed(evt);
            }
        });
        jPanelMensajes.add(jButtonCrearMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, 120, -1));

        jTableMensajes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTableMensajes);

        jPanelMensajes.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 1170, 270));

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder5 = new org.jdesktop.swingx.border.DropShadowBorder();
        jPanelMensaje4.setBorder(dropShadowBorder5);
        jPanelMensaje4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Contenido del mensaje:");
        jPanelMensaje4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jScrollPane8.setBackground(new java.awt.Color(204, 204, 204));
        jScrollPane8.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane8.setHorizontalScrollBar(null);

        textContenido.setBackground(new java.awt.Color(204, 204, 204));
        textContenido.setColumns(5);
        textContenido.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        textContenido.setForeground(new java.awt.Color(255, 255, 255));
        textContenido.setLineWrap(true);
        textContenido.setRows(5);
        textContenido.setTabSize(5);
        textContenido.setWrapStyleWord(true);
        jScrollPane8.setViewportView(textContenido);

        jPanelMensaje4.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 680, 160));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Titulo del mensaje:");
        jPanelMensaje4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, -1, -1));

        textTituloMensaje.setBackground(new java.awt.Color(204, 204, 204));
        textTituloMensaje.setForeground(new java.awt.Color(102, 102, 102));
        jPanelMensaje4.add(textTituloMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 40, 140, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Objetivo asociado:");
        jPanelMensaje4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 80, -1, -1));

        textObjetivoAsociado.setBackground(new java.awt.Color(204, 204, 204));
        textObjetivoAsociado.setForeground(new java.awt.Color(102, 102, 102));
        jPanelMensaje4.add(textObjetivoAsociado, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 100, 140, -1));

        cmbVisibilidad1.setForeground(new java.awt.Color(102, 102, 102));
        cmbVisibilidad1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Administrador", "Importador", "Exportador", "Agente", "Logistica", "Marketing", "Elegir un usuario" }));
        jPanelMensaje4.add(cmbVisibilidad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 160, 120, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Visibilidad:");
        jPanelMensaje4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 140, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("N°:");
        jPanelMensaje4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, -1, -1));

        textIDMensaje.setBackground(new java.awt.Color(204, 204, 204));
        textIDMensaje.setForeground(new java.awt.Color(102, 102, 102));
        jPanelMensaje4.add(textIDMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 40, 70, -1));

        textUsuarioElegidoMensaje.setBackground(new java.awt.Color(204, 204, 204));
        textUsuarioElegidoMensaje.setForeground(new java.awt.Color(102, 102, 102));
        jPanelMensaje4.add(textUsuarioElegidoMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 190, 140, -1));

        jButtonInfo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/signo4.png"))); // NOI18N
        jButtonInfo4.setBorder(null);
        jButtonInfo4.setBorderPainted(false);
        jButtonInfo4.setContentAreaFilled(false);
        jButtonInfo4.setFocusPainted(false);
        jButtonInfo4.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/signo5.png"))); // NOI18N
        jButtonInfo4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/signo5.png"))); // NOI18N
        jButtonInfo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInfo4ActionPerformed(evt);
            }
        });
        jPanelMensaje4.add(jButtonInfo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 70, 20, 30));

        jPanelMensajes.add(jPanelMensaje4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 520, 1030, 240));

        getContentPane().add(jPanelMensajes, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 1250, 880));

        jPanelProximos.setBackground(new java.awt.Color(204, 204, 204));
        jPanelProximos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder6 = new org.jdesktop.swingx.border.DropShadowBorder();
        jPanelMensaje1.setBorder(dropShadowBorder6);
        jPanelMensaje1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelObjetivoRec1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelObjetivoRec1.setForeground(new java.awt.Color(102, 102, 102));
        jPanelMensaje1.add(jLabelObjetivoRec1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabelFechaPub1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelFechaPub1.setForeground(new java.awt.Color(102, 102, 102));
        jPanelMensaje1.add(jLabelFechaPub1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, 200, -1));
        jPanelMensaje1.add(jLabelImportancia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, -1, -1));
        jPanelMensaje1.add(jLabelFechaObj1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, -1, -1));

        jLabelID1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelID1.setForeground(new java.awt.Color(102, 102, 102));
        jPanelMensaje1.add(jLabelID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jScrollPane4.setBackground(new java.awt.Color(204, 204, 204));
        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setHorizontalScrollBar(null);

        textDetalles1.setEditable(false);
        textDetalles1.setBackground(new java.awt.Color(204, 204, 204));
        textDetalles1.setColumns(5);
        textDetalles1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        textDetalles1.setForeground(new java.awt.Color(255, 255, 255));
        textDetalles1.setLineWrap(true);
        textDetalles1.setRows(5);
        textDetalles1.setTabSize(5);
        textDetalles1.setWrapStyleWord(true);
        jScrollPane4.setViewportView(textDetalles1);

        jPanelMensaje1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 660, 90));

        jPanelProximos.add(jPanelMensaje1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 710, 170));

        jLabelTitulo1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelTitulo1.setForeground(new java.awt.Color(102, 102, 102));
        jLabelTitulo1.setText("Próximos objetivos registrados en el sistema");
        jPanelProximos.add(jLabelTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 530, 50));

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder7 = new org.jdesktop.swingx.border.DropShadowBorder();
        jPanelMensaje2.setBorder(dropShadowBorder7);
        jPanelMensaje2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelObjetivoRec2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelObjetivoRec2.setForeground(new java.awt.Color(102, 102, 102));
        jPanelMensaje2.add(jLabelObjetivoRec2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabelFechaPub2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelFechaPub2.setForeground(new java.awt.Color(102, 102, 102));
        jPanelMensaje2.add(jLabelFechaPub2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, 200, -1));
        jPanelMensaje2.add(jLabelImportancia2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, -1, -1));
        jPanelMensaje2.add(jLabelFechaObj2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, -1, -1));

        jLabelID2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelID2.setForeground(new java.awt.Color(102, 102, 102));
        jPanelMensaje2.add(jLabelID2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jScrollPane2.setBackground(new java.awt.Color(204, 204, 204));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setHorizontalScrollBar(null);

        textDetalles2.setEditable(false);
        textDetalles2.setBackground(new java.awt.Color(204, 204, 204));
        textDetalles2.setColumns(5);
        textDetalles2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        textDetalles2.setForeground(new java.awt.Color(255, 255, 255));
        textDetalles2.setLineWrap(true);
        textDetalles2.setRows(5);
        textDetalles2.setTabSize(5);
        textDetalles2.setWrapStyleWord(true);
        jScrollPane2.setViewportView(textDetalles2);

        jPanelMensaje2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 660, 80));

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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Objetivo próximo:");
        jPanelProximos.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Elije un objetivo y podrás verlo aquí:");
        jPanelProximos.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, -1, -1));

        getContentPane().add(jPanelProximos, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 1250, 880));

        jPanelMenu.setBackground(new java.awt.Color(153, 153, 153));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder8 = new org.jdesktop.swingx.border.DropShadowBorder();
        jPanelMenu.setBorder(dropShadowBorder8);
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

        String descripcion, fechaLimite, nivelImportancia, 
                objetivo, status, visibilidad = null;
       
        int ID, visibilidadNivel, mesNum;
        
        Date fechaObjetivo;
                
        LocalDate fechaActual = LocalDate.now();
        Date ahora = Date.valueOf(fechaActual);
        
         int dia = jDayChooser.getDay();
         int mes = jMonthChooser.getMonth() + 1;
         int año = jYearChooser.getYear();
        
        fechaLimite = año + "-" + mes + "-" + dia;
        
        Date fechaRegistro = Date.valueOf(fechaActual);
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
        } else if(visibilidadNivel == 8){
            visibilidad = textUsuario.getSelectedText().trim();
        }
        
        
        objetivosImpl.establecerObjetivo(ID, descripcion, fechaLimite, fechaRegistro, 
                nivelImportancia, objetivo, status, usuario, visibilidad, fechaObjetivo);
        
        VistaObjetivosSegunRol(rol);
        mostrarTodosLosObjetivosRol();
        
    }//GEN-LAST:event_jButtonEstablecerActionPerformed

    private void jButtonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearActionPerformed
        
       jPanelCrear.setVisible(true);
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

    private void jButtonInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInfoActionPerformed

        InformacionIDObjetivo informacionIDObjetivo = new InformacionIDObjetivo();
        informacionIDObjetivo.setVisible(true);

    }//GEN-LAST:event_jButtonInfoActionPerformed

    private void jButtonCrearMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearMensajeActionPerformed
       
        String contenido, objetivoAsociado, titulo, visibilidad = null;
        int ID, visibilidadNivel = 0;
        Date fechaPublicacion;
        
        ID = Integer.parseInt(textIDMensaje.getText().trim());
        contenido = textContenido.getText().trim();
        objetivoAsociado = textObjetivoAsociado.getText().trim();
        titulo = textTituloMensaje.getText().trim();
        
        fechaPublicacion = Date.valueOf(LocalDate.now());
        
        visibilidadNivel = cmbVisibilidad1.getSelectedIndex() + 1;
        
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
        } else if(visibilidadNivel == 8){
            visibilidad = textUsuarioElegidoMensaje.getSelectedText().trim();
        }
        
        Boolean aprobado = mensajesObjetivosImpl.crearMensaje(ID, contenido, objetivoAsociado, titulo, 
                usuario, visibilidad, fechaPublicacion);
        if(aprobado == false){
            JOptionPane.showMessageDialog(null, "No pudimos crear tu mensaje");
            cargarTablaMensajes(fechaActual);
        }
        
        
    }//GEN-LAST:event_jButtonCrearMensajeActionPerformed

    private void jButtonBuscarMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarMensajeActionPerformed
       
        String busquedaMensaje = textBusqueda.getText().trim();
        
        mensajesObjetivosImpl.obtenerMensajeBuscado(busquedaMensaje, jLabelFechaMensaje, 
                jLabelObjetivoAsociado, jLabelTituloMensaje, textMensaje, jLabelUsuario);
        
        cargarTablaMensajes(fechaActual);
        pasarCamposDeLaTablaMensajesAFields();    
        
    }//GEN-LAST:event_jButtonBuscarMensajeActionPerformed

    private void jButtonInfo4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInfo4ActionPerformed
        
        InformacionIDMensajeObjetivo IDMensajeObjetivo = new InformacionIDMensajeObjetivo();
        IDMensajeObjetivo.setVisible(true);
        
    }//GEN-LAST:event_jButtonInfo4ActionPerformed

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
    private javax.swing.JComboBox<String> cmbVisibilidad1;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonBuscarMensaje;
    private javax.swing.JButton jButtonCrear;
    private javax.swing.JButton jButtonCrearMensaje;
    private javax.swing.JButton jButtonEstablecer;
    private javax.swing.JButton jButtonInfo;
    private javax.swing.JButton jButtonInfo4;
    private javax.swing.JButton jButtonMensajes;
    private javax.swing.JButton jButtonRegresar;
    private javax.swing.JButton jButtonUltimos;
    private javax.swing.JButton jButtonVer;
    private com.toedter.calendar.JDayChooser jDayChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelDescripcion;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelFechaMensaje;
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
    private javax.swing.JLabel jLabelObjetivoAsociado;
    private javax.swing.JLabel jLabelObjetivoRec1;
    private javax.swing.JLabel jLabelObjetivoRec2;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelTitulo1;
    private javax.swing.JLabel jLabelTituloMensaje;
    private javax.swing.JLabel jLabelTituloVer;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JLabel jLabelVisibilidad;
    private com.toedter.calendar.JMonthChooser jMonthChooser;
    private javax.swing.JPanel jPanelBase;
    private javax.swing.JPanel jPanelBusqueda;
    private javax.swing.JPanel jPanelContenido;
    private javax.swing.JPanel jPanelCrear;
    private javax.swing.JPanel jPanelMensaje1;
    private javax.swing.JPanel jPanelMensaje2;
    private javax.swing.JPanel jPanelMensaje3;
    private javax.swing.JPanel jPanelMensaje4;
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
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable jTableMensajes;
    private javax.swing.JTable jTableObjetivos;
    private javax.swing.JTable jTableProximos;
    private com.toedter.calendar.JYearChooser jYearChooser;
    private javax.swing.JTextField textBusqueda;
    private javax.swing.JTextArea textContenido;
    private javax.swing.JTextArea textDescripcion;
    private javax.swing.JTextArea textDetalles1;
    private javax.swing.JTextArea textDetalles2;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textIDMensaje;
    private javax.swing.JTextArea textMensaje;
    private javax.swing.JTextField textObjetivo;
    private javax.swing.JTextField textObjetivoAsociado;
    private javax.swing.JTextField textRol;
    private javax.swing.JTextField textTituloMensaje;
    private javax.swing.JTextField textUsuario;
    private javax.swing.JTextField textUsuarioElegidoMensaje;
    // End of variables declaration//GEN-END:variables

    public void cargarTablaMensajes (LocalDate fechaActual) {

        DefaultTableModel modelo = new DefaultTableModel();

        String sql = "select fecha_publicacion, hora_registro, objetivo_asociado, "
                + "titulo, contenido, usuario_emisor, visibilidad from mensajes_objetivos "
                + "where visibilidad = '" + rol + "' or visibilidad = '" + usuario + "' "
                + "or visibilidad = 'Todos' order by fecha_publicacion asc";

        try {
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();

            jTableMensajes = new JTable(modelo);
            jScrollPane3.setViewportView(jTableMensajes);

            modelo.addColumn("Fecha de publicación");
            modelo.addColumn("Hora de publicación");
            modelo.addColumn("Objetivo asociado");
            modelo.addColumn("Título");
            modelo.addColumn("Contenido");
            modelo.addColumn("Creador");
            modelo.addColumn("Visibilidad");

            while (rs.next()) {
                Object[] fila = new Object[7];
                for (int i = 0; i < 7; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(fila);
            }

            conec.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos "
                    + "de la tabla");
            System.err.println("Error al cargar los datos de la tabla" + e);
        }
    }
    
    
    public void pasarCamposDeLaTablaMensajesAFields(){
    
        jTableMensajes.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent Mouse_evt){
                
                JTable tablaMensajes = (JTable) Mouse_evt.getSource();
                Point point = Mouse_evt.getPoint();
    
                int filaSeleccionada = tablaMensajes.rowAtPoint(point);

                if(Mouse_evt.getClickCount() == 1){
                  jLabelFechaMensaje.setText (jTableMensajes.getValueAt(jTableProximos.getSelectedRow(), 0).toString());
                  jLabelObjetivoAsociado.setText(jTableProximos.getValueAt(jTableMensajes.getSelectedRow(), 1).toString());
                  jLabelTituloMensaje.setText(jTableProximos.getValueAt(jTableMensajes.getSelectedRow(), 2).toString());
                  textMensaje.setText(jTableMensajes.getValueAt(jTableProximos.getSelectedRow(), 3).toString());
                  jLabelUsuario.setText(jTableMensajes.getValueAt(jTableProximos.getSelectedRow(), 4).toString());

                }
            }
        });
    }
}
