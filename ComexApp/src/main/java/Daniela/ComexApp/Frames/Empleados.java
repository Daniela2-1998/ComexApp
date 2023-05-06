package Daniela.ComexApp.Frames;

import config.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import service.ConfiguracionImpl;
import service.EmpleadosImpl;
import service.InicioSesionImp;

/**
 *
 * @author Daniela
 * 
 */
public class Empleados extends javax.swing.JFrame {

    String nombreCompleto = "", usuario = "";
    /**
     * Creates new form Empleados
     */
    public Empleados() {
        initComponents();
        
        setSize(870, 750);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);

        PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
        
        usuario = paginaPrincipal.usuario;
        nombreCompleto = paginaPrincipal.nombreCompleto;
        
        
        setTitle("Empleados - " + usuario + " - Sistema ComexApp");
        jLabelTitulo.setText("Empleados - " + nombreCompleto);

        ConfiguracionImpl config = new ConfiguracionImpl();
        String nombreEmpresa = config.obtenerNombreEmpresa();
        textEmpresa.setText(nombreEmpresa);
        
        jPanelInfo.setVisible(true);
        jPanelLista.setVisible(false);
        mostrarTodosLosDatosUsuario();
        mostrarTodosLosDatosEmpleados();
    }
      // icono
    public Image getLogo(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/loguito1.png"));
        return retValue;   
    }
    
    EmpleadosImpl empleados = new EmpleadosImpl();
    
    
    public void LimpiarCampos(){
        textEmpresa.setText("");
        textEmpleado.setText("");
        textArea.setText("");
        textCargo.setText("");
        textHorario.setText("");
        textID.setText("");
        textSueldo.setText("");
        cmbStatus.setSelectedItem(0);
        textCargo.setText("");
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
            
            jTableUsuarios = new JTable(modelo);
            jScrollPane2.setViewportView(jTableUsuarios);
            
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("Número de contacto");
            modelo.addColumn("Mail");
            
            while(rs.next()){
                Object[] fila = new Object[4];
                for(int i = 0; i < 4; i++){
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
   
     public void mostrarTodosLosDatosUsuario(){
         String sql = "select nombre, apellido, telefono, mail "
                 + "from usuarios order by id_usuarios asc";
        cargarTablaUsuarios(sql);
    }

     public void cargarTablaEmpleados(String sql){

        DefaultTableModel modelo = new DefaultTableModel();
      
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            jTableEmpleados = new JTable(modelo);
            jScrollPane3.setViewportView(jTableEmpleados);
            
            modelo.addColumn("ID");
            modelo.addColumn("Empleado");
            modelo.addColumn("Empresa");
            modelo.addColumn("Area");
            modelo.addColumn("Cargo");
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
            JOptionPane.showMessageDialog(null, "Error al cargar los datos "
                    + "de la tabla");
            System.err.println("Error al cargar los datos de la tabla" + e);
        }
    }
   
     public void mostrarTodosLosDatosEmpleados(){
         String sql = "select id_empleado, empleado, empresa, area, cargo, status "
                 + "from empleados order by id_empleado asc";
        cargarTablaEmpleados(sql);
    }

    public int recuperarValorNumDelStatus(String status){
        int statusNivel = 0;
        
        switch(status){
            case "Activo":
                statusNivel = 1;
                break;
            case "Inactivo":
                statusNivel = 2;
                break;    
            case "Suspendido":
                statusNivel = 3;
                break;  
            default:
                statusNivel = 1; 
        }
        
        return statusNivel;
    }

     
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelArriba = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jPanelMenu = new javax.swing.JPanel();
        jButtonVolverAtras = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonRegistrar = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        textBuscarN = new javax.swing.JTextField();
        jButtonLimpiar = new javax.swing.JButton();
        jLabelEmpleado1 = new javax.swing.JLabel();
        jLabelEmpleado2 = new javax.swing.JLabel();
        textBuscarA = new javax.swing.JTextField();
        jPanelInfo = new javax.swing.JPanel();
        jLabelEmpresa = new javax.swing.JLabel();
        textEmpresa = new javax.swing.JTextField();
        jLabelEmpleado = new javax.swing.JLabel();
        textEmpleado = new javax.swing.JTextField();
        jLabelArea = new javax.swing.JLabel();
        textArea = new javax.swing.JTextField();
        jLabelCargo = new javax.swing.JLabel();
        textCargo = new javax.swing.JTextField();
        jLabelHorario = new javax.swing.JLabel();
        textHorario = new javax.swing.JTextField();
        textID = new javax.swing.JTextField();
        jLabelID = new javax.swing.JLabel();
        jButtonInfo = new javax.swing.JButton();
        jLabelStatus = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        jLabelSubt = new javax.swing.JLabel();
        jLabelSueldo = new javax.swing.JLabel();
        textSueldo = new javax.swing.JTextField();
        jLabelUsuario = new javax.swing.JLabel();
        textUsuario = new javax.swing.JTextField();
        jLabelEmpleado3 = new javax.swing.JLabel();
        textHorarioSalida = new javax.swing.JTextField();
        jPanelLista = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableUsuarios = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableEmpleados = new javax.swing.JTable();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuInformacion = new javax.swing.JMenu();
        jMenuLista = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getLogo());
        setIconImages(getIconImages());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelArriba.setBackground(new java.awt.Color(255, 255, 255));
        jPanelArriba.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(0, 0, 153));

        javax.swing.GroupLayout jPanelArribaLayout = new javax.swing.GroupLayout(jPanelArriba);
        jPanelArriba.setLayout(jPanelArribaLayout);
        jPanelArribaLayout.setHorizontalGroup(
            jPanelArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelArribaLayout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(jLabelTitulo)
                .addContainerGap(704, Short.MAX_VALUE))
        );
        jPanelArribaLayout.setVerticalGroup(
            jPanelArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelArribaLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabelTitulo)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelArriba, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 90));

        jPanelMenu.setBackground(new java.awt.Color(255, 255, 255));
        jPanelMenu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonVolverAtras.setBackground(new java.awt.Color(0, 0, 153));
        jButtonVolverAtras.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonVolverAtras.setForeground(new java.awt.Color(255, 255, 255));
        jButtonVolverAtras.setText("Volver atrás");
        jButtonVolverAtras.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 153), new java.awt.Color(0, 0, 153), new java.awt.Color(0, 0, 153), new java.awt.Color(0, 0, 153)));
        jButtonVolverAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverAtrasActionPerformed(evt);
            }
        });
        jPanelMenu.add(jButtonVolverAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 646, 140, 30));

        jButtonModificar.setBackground(new java.awt.Color(0, 0, 153));
        jButtonModificar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonModificar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonModificar.setText("Modificar empleado");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });
        jPanelMenu.add(jButtonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 220, -1));

        jButtonEliminar.setBackground(new java.awt.Color(0, 0, 153));
        jButtonEliminar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonEliminar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEliminar.setText("Eliminar empleado");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });
        jPanelMenu.add(jButtonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 220, -1));

        jButtonRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButtonRegistrar.setForeground(new java.awt.Color(0, 0, 153));
        jButtonRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agendar.png"))); // NOI18N
        jButtonRegistrar.setText("Registrar");
        jButtonRegistrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonRegistrar.setBorderPainted(false);
        jButtonRegistrar.setContentAreaFilled(false);
        jButtonRegistrar.setFocusPainted(false);
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });
        jPanelMenu.add(jButtonRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 190, 140));

        jButtonBuscar.setBackground(new java.awt.Color(0, 0, 153));
        jButtonBuscar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBuscar.setText("Buscar empleado");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        jPanelMenu.add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 217, -1));

        textBuscarN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textBuscarNActionPerformed(evt);
            }
        });
        jPanelMenu.add(textBuscarN, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 217, 30));

        jButtonLimpiar.setBackground(new java.awt.Color(0, 0, 153));
        jButtonLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLimpiar.setText("Limpiar busqueda");
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });
        jPanelMenu.add(jButtonLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 217, 20));

        jLabelEmpleado1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelEmpleado1.setForeground(new java.awt.Color(0, 0, 153));
        jLabelEmpleado1.setText("Nombre:");
        jPanelMenu.add(jLabelEmpleado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabelEmpleado2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelEmpleado2.setForeground(new java.awt.Color(0, 0, 153));
        jLabelEmpleado2.setText("Apellido:");
        jPanelMenu.add(jLabelEmpleado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        textBuscarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textBuscarAActionPerformed(evt);
            }
        });
        jPanelMenu.add(textBuscarA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 217, 30));

        getContentPane().add(jPanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 750));

        jPanelInfo.setBackground(new java.awt.Color(0, 0, 153));
        jPanelInfo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelEmpresa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEmpresa.setText("Empresa:");
        jPanelInfo.add(jLabelEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 63, -1, -1));

        textEmpresa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textEmpresa.setForeground(new java.awt.Color(0, 0, 153));
        textEmpresa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelInfo.add(textEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 89, 163, -1));

        jLabelEmpleado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEmpleado.setText("Empleado:");
        jPanelInfo.add(jLabelEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 126, -1, -1));

        textEmpleado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textEmpleado.setForeground(new java.awt.Color(0, 0, 153));
        textEmpleado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelInfo.add(textEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 152, 163, -1));

        jLabelArea.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelArea.setForeground(new java.awt.Color(255, 255, 255));
        jLabelArea.setText("Área:");
        jPanelInfo.add(jLabelArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 193, -1, -1));

        textArea.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textArea.setForeground(new java.awt.Color(0, 0, 153));
        textArea.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelInfo.add(textArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 219, 163, -1));

        jLabelCargo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelCargo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCargo.setText("Cargo:");
        jPanelInfo.add(jLabelCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 255, -1, -1));

        textCargo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textCargo.setForeground(new java.awt.Color(0, 0, 153));
        textCargo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelInfo.add(textCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 281, 163, -1));

        jLabelHorario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelHorario.setForeground(new java.awt.Color(255, 255, 255));
        jLabelHorario.setText("Horario entrada:");
        jPanelInfo.add(jLabelHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 63, -1, -1));

        textHorario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textHorario.setForeground(new java.awt.Color(0, 0, 153));
        textHorario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelInfo.add(textHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 89, 163, -1));

        textID.setEditable(false);
        textID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textID.setForeground(new java.awt.Color(0, 0, 153));
        textID.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelInfo.add(textID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 93, -1));

        jLabelID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelID.setForeground(new java.awt.Color(255, 255, 255));
        jLabelID.setText("ID:");
        jPanelInfo.add(jLabelID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

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
        jPanelInfo.add(jButtonInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, -1, -1));

        jLabelStatus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelStatus.setForeground(new java.awt.Color(255, 255, 255));
        jLabelStatus.setText("Status:");
        jPanelInfo.add(jLabelStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, -1, -1));

        cmbStatus.setForeground(new java.awt.Color(0, 0, 153));
        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo", "Suspendido" }));
        jPanelInfo.add(cmbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, 120, 40));

        jLabelSubt.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabelSubt.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSubt.setText("Datos completos:");
        jPanelInfo.add(jLabelSubt, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 18, -1, -1));

        jLabelSueldo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelSueldo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSueldo.setText("Sueldo:");
        jPanelInfo.add(jLabelSueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 193, -1, -1));

        textSueldo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textSueldo.setForeground(new java.awt.Color(0, 0, 153));
        textSueldo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelInfo.add(textSueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 219, 163, -1));

        jLabelUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsuario.setText("Usuario:");
        jPanelInfo.add(jLabelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 255, -1, -1));

        textUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textUsuario.setForeground(new java.awt.Color(0, 0, 153));
        textUsuario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelInfo.add(textUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 281, 163, -1));

        jLabelEmpleado3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelEmpleado3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEmpleado3.setText("Horario salida:");
        jPanelInfo.add(jLabelEmpleado3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 126, -1, -1));

        textHorarioSalida.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textHorarioSalida.setForeground(new java.awt.Color(0, 0, 153));
        textHorarioSalida.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelInfo.add(textHorarioSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 152, 163, -1));

        getContentPane().add(jPanelInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 610, 660));

        jPanelLista.setBackground(new java.awt.Color(0, 0, 153));
        jPanelLista.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelLista.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTableUsuarios);

        jPanelLista.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 560, 220));

        jTableEmpleados.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTableEmpleados);

        jPanelLista.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 560, 320));

        getContentPane().add(jPanelLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 610, 660));

        jMenuInformacion.setForeground(new java.awt.Color(0, 0, 153));
        jMenuInformacion.setText("Información empleado específico");
        jMenuInformacion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuInformacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuInformacionMouseClicked(evt);
            }
        });
        jMenuBar.add(jMenuInformacion);

        jMenuLista.setBackground(new java.awt.Color(204, 204, 204));
        jMenuLista.setForeground(new java.awt.Color(0, 51, 153));
        jMenuLista.setText("Lista empleados");
        jMenuLista.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuListaMouseClicked(evt);
            }
        });
        jMenuBar.add(jMenuLista);

        setJMenuBar(jMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVolverAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverAtrasActionPerformed

        PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
        paginaPrincipal.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButtonVolverAtrasActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed

        String area, cargo, empleado, empresa, usuario, status = null;
        Time horario, horarioSalida;
        double sueldo;
        int statusNivel = 0;
        
        Boolean recepcion;
        
        empresa = textEmpresa.getText().trim();
        empleado = textEmpleado.getText().trim();
        area = textArea.getText().trim();
        cargo = textCargo.getText().trim();
        usuario = textUsuario.getText().trim();
        horario = Time.valueOf(textHorario.getText().trim());
        horarioSalida = Time.valueOf(textHorarioSalida.getText().trim());
        sueldo = Double.parseDouble(textSueldo.getText().trim());
        statusNivel = cmbStatus.getSelectedIndex() + 1;
        
        if(statusNivel == 1){
           status = "Activo";
        } else if (statusNivel == 2){
           status = "Inactivo";
        } else if (statusNivel == 3){
           status = "Suspendido";
        }

        boolean empleadoYaAsociadoAntes = empleados.empleadoAsociadoANombre(usuario);
        
        if(empleadoYaAsociadoAntes == false){
            empleados.modificarEmpleado(area, cargo, empleado, empresa, horario, 
                    horarioSalida, status, sueldo, usuario);
            LimpiarCampos();
        }

        mostrarTodosLosDatosUsuario();
        mostrarTodosLosDatosEmpleados();
        
        
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed

        int id = Integer.parseInt(textID.getText().trim());
        String nombre = textEmpleado.getText().trim();
        
        try{
            Boolean aprobarEliminar = empleados.eliminarEmpleado(nombre, id);
            
            if(aprobarEliminar.equals(true)){
                JOptionPane.showMessageDialog(null, "Eliminación éxitosa");
                LimpiarCampos();
            }
                  
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No pudimos eliminar al empleado");
        }
        mostrarTodosLosDatosEmpleados();
        mostrarTodosLosDatosUsuario();
        
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed

        String area, cargo, empleado, empresa, usuario, status = null;
        Time horario, horarioSalida;
        Double sueldo;
        int statusNivel = 0;
        
        Boolean recepcion;
        
        empresa = textEmpresa.getText().trim();
        empleado = textEmpleado.getText().trim();
        area = textArea.getText().trim();
        cargo = textCargo.getText().trim();
        usuario = textUsuario.getText().trim();
        horario = Time.valueOf(textHorario.getText().trim());
        horarioSalida = Time.valueOf(textHorarioSalida.getText().trim());
        sueldo = Double.parseDouble(textSueldo.getText().trim());
        statusNivel = cmbStatus.getSelectedIndex() + 1;
        
        if(statusNivel == 1){
           status = "Activo";
        } else if (statusNivel == 2){
           status = "Inactivo";
        } else if (statusNivel == 3){
           status = "Suspendido";
        }

        InicioSesionImp  inicioSesion = new InicioSesionImp ();
        boolean noExisteUsuario = inicioSesion.verificarQueNoExistaUsuario(usuario);
        
        boolean empleadoYaAsociadoAntes = empleados.empleadoAsociadoANombre(usuario);
        
        if (noExisteUsuario == false && empleadoYaAsociadoAntes == false) {
            recepcion = empleados.registroEmpleado(area, cargo, empleado, empresa, 
                    horario, horarioSalida, status, sueldo, usuario);

            if (recepcion == true) {
                LimpiarCampos();
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "El usuario otorgado no existe", 
                    "Usuario incorrecto", 0);
        }
        
        mostrarTodosLosDatosUsuario();
        mostrarTodosLosDatosEmpleados();
        
    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed

       String nombreABuscar = textBuscarN.getText().trim();
       String apellidoABuscar = textBuscarA.getText().trim();
       String empleadoABuscar = nombreABuscar + " " + apellidoABuscar;
       
       empleados.obtenerDatosDelEmpleado(empleadoABuscar, textID, textEmpleado, 
               textEmpresa, textUsuario, textCargo, textArea, textHorario, 
               textHorarioSalida, textSueldo, cmbStatus);
       
       String nombreAcortado = empleadoABuscar;
       
       System.out.println(nombreAcortado);
           
       setTitle("Informacíón completa de " + empleadoABuscar + " - Sistema ComexApp");
       jLabelTitulo.setText("Información completa de " + empleadoABuscar + "");
       
       
       String sql1 =  "select id_empleado, empleado, empresa, area, cargo, status "
                 + "from empleados where empleado = '" + empleadoABuscar + "' or "
               + "empresa = '" + empleadoABuscar + "'order by id_empleado asc";
       String sql2 = "select nombre, apellido, telefono, mail "
                 + "from usuarios where nombre = '" + nombreABuscar + 
               "' and apellido = '" + apellidoABuscar + "' order by id_usuarios asc";
       
       cargarTablaEmpleados(sql1);
       cargarTablaUsuarios(sql2);
       
  
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void textBuscarNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textBuscarNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textBuscarNActionPerformed

    private void jButtonInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInfoActionPerformed

        InformacionIDAgenda informacionIDAgenda = new InformacionIDAgenda();
        informacionIDAgenda.setVisible(true);
        
    }//GEN-LAST:event_jButtonInfoActionPerformed

    private void jMenuInformacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuInformacionMouseClicked
       
        jPanelInfo.setVisible(true);
        jPanelLista.setVisible(false);
        
    }//GEN-LAST:event_jMenuInformacionMouseClicked

    private void jMenuListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuListaMouseClicked
    
        jPanelInfo.setVisible(false);
        jPanelLista.setVisible(true);
        
    }//GEN-LAST:event_jMenuListaMouseClicked

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        
        LimpiarCampos();
        mostrarTodosLosDatosEmpleados();
        mostrarTodosLosDatosUsuario();
        
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    private void textBuscarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textBuscarAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textBuscarAActionPerformed

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
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Empleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonInfo;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JButton jButtonVolverAtras;
    private javax.swing.JLabel jLabelArea;
    private javax.swing.JLabel jLabelCargo;
    private javax.swing.JLabel jLabelEmpleado;
    private javax.swing.JLabel jLabelEmpleado1;
    private javax.swing.JLabel jLabelEmpleado2;
    private javax.swing.JLabel jLabelEmpleado3;
    private javax.swing.JLabel jLabelEmpresa;
    private javax.swing.JLabel jLabelHorario;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JLabel jLabelSubt;
    private javax.swing.JLabel jLabelSueldo;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuInformacion;
    private javax.swing.JMenu jMenuLista;
    private javax.swing.JPanel jPanelArriba;
    private javax.swing.JPanel jPanelInfo;
    private javax.swing.JPanel jPanelLista;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableEmpleados;
    private javax.swing.JTable jTableUsuarios;
    private javax.swing.JTextField textArea;
    private javax.swing.JTextField textBuscarA;
    private javax.swing.JTextField textBuscarN;
    private javax.swing.JTextField textCargo;
    private javax.swing.JTextField textEmpleado;
    private javax.swing.JTextField textEmpresa;
    private javax.swing.JTextField textHorario;
    private javax.swing.JTextField textHorarioSalida;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textSueldo;
    private javax.swing.JTextField textUsuario;
    // End of variables declaration//GEN-END:variables


}
