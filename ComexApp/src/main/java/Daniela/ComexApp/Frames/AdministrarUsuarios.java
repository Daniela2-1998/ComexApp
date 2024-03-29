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
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import service.TiemposImpl;
import service.UsuariosImpl;


/**
 *
 * @author Daniela
 */
public class AdministrarUsuarios extends javax.swing.JFrame {

    String usuarioBusqueda;
    /**
     * Creates new form AdministrarUsuarios
     */
    public AdministrarUsuarios() {
        initComponents();
        
        setSize(1500, 750);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        
        setTitle("Administrar usuarios - Administrador - Sistema ComexApp");
        
        mostrarTodosLosDatos();
        pasarCamposDeLaTablaAFields();
        
        Date diaActual = Date.valueOf(LocalDate.now());
        Time horaActual = Time.valueOf(LocalTime.now());
        TiemposImpl tiemposImpl = new TiemposImpl();        
        tiemposImpl.verificarCuentasRegresivasCumplidas(diaActual, horaActual);
    }
    
        // icono
    public Image getLogo(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/loguito1.png"));
        return retValue;   
    }
    
    UsuariosImpl usuariosService = new UsuariosImpl();
    
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
            jScrollPane1.setViewportView(jTableUsuarios);
            
            modelo.addColumn("ID");
            modelo.addColumn("Usuario");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("Rol");
            modelo.addColumn("Mail");
            modelo.addColumn("Telefono");
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
            JOptionPane.showMessageDialog(null, "Error al cargar tabla de usuarios");
            System.err.println("Error al cargar tabla de usuarios " + e);
        }
    }

    
    public void mostrarTodosLosDatos(){
        String sql = "select id_usuarios, usuario, nombre, apellido, rol, mail, "
                + "telefono, status from usuarios order by id_usuarios asc";
        cargarTablaUsuarios(sql);
    }
    
    public void LimpiarFiltroBusqueda(){
        textBusqueda.setText("");
        textID.setText("");
        cmbRol.setSelectedIndex(0);
        cmbStatus.setSelectedIndex(0);
        mostrarTodosLosDatos();
    }
    
    public void LimpiarCampos(){
        textUsuario.setText("");
        textNombre.setText("");
        textApellido.setText("");
        textMail.setText("");
        textTel.setText("");
    }
    
     // método para poner los datos de la tabla en los textfields.
     public void pasarCamposDeLaTablaAFields(){
    
        jTableUsuarios.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent Mouse_evt){
                
                JTable tablaUsuarios = (JTable) Mouse_evt.getSource();
                Point point = Mouse_evt.getPoint();
    
                int filaSeleccionada = tablaUsuarios.rowAtPoint(point);

                if(Mouse_evt.getClickCount() == 1){
                  textUsuario.setText(jTableUsuarios.getValueAt(jTableUsuarios.getSelectedRow(), 1).toString());
                  textNombre.setText(jTableUsuarios.getValueAt(jTableUsuarios.getSelectedRow(), 2).toString());
                  textApellido.setText(jTableUsuarios.getValueAt(jTableUsuarios.getSelectedRow(), 3).toString());
                  textMail.setText(jTableUsuarios.getValueAt(jTableUsuarios.getSelectedRow(), 5).toString());
                  textTel.setText(jTableUsuarios.getValueAt(jTableUsuarios.getSelectedRow(), 6).toString());
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUsuarios = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanelMenu = new javax.swing.JPanel();
        jButtonBuscar = new javax.swing.JButton();
        textBusqueda = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonEliminar2 = new javax.swing.JButton();
        jLabelSubt1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbRol = new javax.swing.JComboBox<>();
        jButtonBuscarIRol = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        jLabelID = new javax.swing.JLabel();
        textID = new javax.swing.JTextField();
        jButtonBuscarID = new javax.swing.JButton();
        jButtonBuscarStatus = new javax.swing.JButton();
        jPanelOpciones = new javax.swing.JPanel();
        jLabelSubt = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        textUsuario = new javax.swing.JTextField();
        jLabelNombre = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        jLabelApellido = new javax.swing.JLabel();
        textApellido = new javax.swing.JTextField();
        jLabelMail = new javax.swing.JLabel();
        textMail = new javax.swing.JTextField();
        jLabelTelefono = new javax.swing.JLabel();
        textTel = new javax.swing.JTextField();
        jButtonVerUsuario = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonVolverAtras = new javax.swing.JButton();
        jButtonInfo3 = new javax.swing.JButton();
        jLabelTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getLogo());
        setIconImages(getIconImages());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        jScrollPane1.setBorder(dropShadowBorder1);

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder2 = new org.jdesktop.swingx.border.DropShadowBorder();
        jTableUsuarios.setBorder(dropShadowBorder2);
        jTableUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Usuario", "Nombre", "Apellido", "Rol", "Mail", "Telefono", "Status"
            }
        ));
        jScrollPane1.setViewportView(jTableUsuarios);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 152, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );

        jPanelMenu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonBuscar.setBackground(new java.awt.Color(0, 0, 153));
        jButtonBuscar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBuscar.setText("Iniciar busqueda");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        textBusqueda.setForeground(new java.awt.Color(0, 0, 153));
        textBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textBusquedaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Buscar por nombre o usuario:");

        jButtonEliminar2.setBackground(new java.awt.Color(0, 0, 153));
        jButtonEliminar2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonEliminar2.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEliminar2.setText("Recargar lista completa");
        jButtonEliminar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminar2ActionPerformed(evt);
            }
        });

        jLabelSubt1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabelSubt1.setForeground(new java.awt.Color(0, 0, 153));
        jLabelSubt1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelSubt1.setText("Filtros de búsqueda:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("Buscar por rol:");

        cmbRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Importador", "Exportador", "Agente", "Logistica", "Marketing" }));

        jButtonBuscarIRol.setBackground(new java.awt.Color(0, 0, 153));
        jButtonBuscarIRol.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonBuscarIRol.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBuscarIRol.setText("Rol");
        jButtonBuscarIRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarIRolActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("Status");

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo", "Suspendido" }));

        jLabelID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelID.setForeground(new java.awt.Color(0, 0, 153));
        jLabelID.setText("Buscar por ID");

        textID.setForeground(new java.awt.Color(0, 0, 153));
        textID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textIDActionPerformed(evt);
            }
        });

        jButtonBuscarID.setBackground(new java.awt.Color(0, 0, 153));
        jButtonBuscarID.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonBuscarID.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBuscarID.setText("ID");
        jButtonBuscarID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarIDActionPerformed(evt);
            }
        });

        jButtonBuscarStatus.setBackground(new java.awt.Color(0, 0, 153));
        jButtonBuscarStatus.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonBuscarStatus.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBuscarStatus.setText("Status");
        jButtonBuscarStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarStatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMenuLayout = new javax.swing.GroupLayout(jPanelMenu);
        jPanelMenu.setLayout(jPanelMenuLayout);
        jPanelMenuLayout.setHorizontalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMenuLayout.createSequentialGroup()
                                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(jPanelMenuLayout.createSequentialGroup()
                                        .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(textBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonBuscarID, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelID)
                                    .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMenuLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabelSubt1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMenuLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonEliminar2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)))
                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMenuLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jButtonBuscarIRol)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMenuLayout.createSequentialGroup()
                        .addComponent(jButtonBuscarStatus)
                        .addGap(6, 6, 6)))
                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(cmbRol, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addComponent(cmbStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanelMenuLayout.setVerticalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanelMenuLayout.createSequentialGroup()
                            .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jLabelSubt1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmbRol, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonBuscarIRol, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel3))
                        .addGroup(jPanelMenuLayout.createSequentialGroup()
                            .addComponent(jLabelID, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButtonBuscarID, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                                .addComponent(textID))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMenuLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)))
                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMenuLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonBuscarStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanelMenuLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButtonEliminar2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder3 = new org.jdesktop.swingx.border.DropShadowBorder();
        jPanelOpciones.setBorder(dropShadowBorder3);

        jLabelSubt.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabelSubt.setForeground(new java.awt.Color(0, 0, 153));
        jLabelSubt.setText("Datos del usuario elegido:");

        jLabelUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelUsuario.setForeground(new java.awt.Color(0, 0, 153));
        jLabelUsuario.setText("Usuario:");

        textUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textUsuario.setForeground(new java.awt.Color(0, 0, 153));
        textUsuario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNombre.setForeground(new java.awt.Color(0, 0, 153));
        jLabelNombre.setText("Nombre:");

        textNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textNombre.setForeground(new java.awt.Color(0, 0, 153));
        textNombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelApellido.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelApellido.setForeground(new java.awt.Color(0, 0, 153));
        jLabelApellido.setText("Apellido:");

        textApellido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textApellido.setForeground(new java.awt.Color(0, 0, 153));
        textApellido.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelMail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelMail.setForeground(new java.awt.Color(0, 0, 153));
        jLabelMail.setText("Mail:");

        textMail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textMail.setForeground(new java.awt.Color(0, 0, 153));
        textMail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelTelefono.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTelefono.setForeground(new java.awt.Color(0, 0, 153));
        jLabelTelefono.setText("Teléfono:");

        textTel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textTel.setForeground(new java.awt.Color(0, 0, 153));
        textTel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonVerUsuario.setBackground(new java.awt.Color(0, 0, 153));
        jButtonVerUsuario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonVerUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jButtonVerUsuario.setText("Información usuario");
        jButtonVerUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerUsuarioActionPerformed(evt);
            }
        });

        jButtonModificar.setBackground(new java.awt.Color(0, 0, 153));
        jButtonModificar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonModificar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonModificar.setText("Modificar usuario");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

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

        jButtonInfo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/signo4.png"))); // NOI18N
        jButtonInfo3.setBorder(null);
        jButtonInfo3.setBorderPainted(false);
        jButtonInfo3.setContentAreaFilled(false);
        jButtonInfo3.setFocusPainted(false);
        jButtonInfo3.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/signo5.png"))); // NOI18N
        jButtonInfo3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/signo5.png"))); // NOI18N
        jButtonInfo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInfo3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelOpcionesLayout = new javax.swing.GroupLayout(jPanelOpciones);
        jPanelOpciones.setLayout(jPanelOpcionesLayout);
        jPanelOpcionesLayout.setHorizontalGroup(
            jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(textTel)
                        .addGroup(jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(textMail)
                                .addGroup(jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(textApellido)
                                        .addComponent(textNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabelSubt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabelUsuario)
                                                .addComponent(textUsuario))
                                            .addComponent(jLabelNombre)
                                            .addComponent(jLabelApellido)))
                                    .addComponent(jLabelMail)))
                            .addComponent(jLabelTelefono)))
                    .addGroup(jPanelOpcionesLayout.createSequentialGroup()
                        .addGroup(jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButtonVolverAtras, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonModificar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                            .addComponent(jButtonVerUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonInfo3)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanelOpcionesLayout.setVerticalGroup(
            jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOpcionesLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabelSubt)
                .addGap(27, 27, 27)
                .addComponent(jLabelUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelApellido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelMail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelTelefono)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButtonVerUsuario)
                .addGap(18, 18, 18)
                .addGroup(jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonModificar)
                    .addComponent(jButtonInfo3))
                .addGap(18, 18, 18)
                .addComponent(jButtonVolverAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setText("Administrar usuarios");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelTitulo)
                        .addGap(420, 420, 420))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 921, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)))
                .addComponent(jPanelOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelTitulo)
                        .addGap(18, 18, 18)
                        .addComponent(jPanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanelOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, 0, 1560, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVerUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerUsuarioActionPerformed

        VerUsuario verUsuario = new VerUsuario();
        verUsuario.setVisible(true);
        
    }//GEN-LAST:event_jButtonVerUsuarioActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed

        try{
            
            String usuario, nombreMod, apellidoMod, telefonoMod, mailMod;
        
            usuario = textUsuario.getText().trim();
            nombreMod = textNombre.getText().trim();
            apellidoMod = textApellido.getText().trim();
            telefonoMod = textTel.getText().trim();
            mailMod = textMail.getText().trim();
        
           usuariosService.modificarAlgunosDatosDeUsuarios(usuario, nombreMod, 
                apellidoMod, mailMod, telefonoMod);
         
        }catch(Exception e){
            System.err.println("Fallo al modificar datos " + e);
            JOptionPane.showMessageDialog(null, "Fallo al modificar datos");
        }
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed

        if(!textBusqueda.equals("")){

            String busqueda = textBusqueda.getText().trim();
            
            String sql = "select id_usuarios, usuario, nombre, apellido, rol, mail, "
                + "telefono, status from usuarios where usuario = '" + busqueda 
                + "' or nombre = '" + busqueda + "' order by id_usuarios asc";
            
           cargarTablaUsuarios(sql);
        } 
     
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonEliminar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminar2ActionPerformed

        LimpiarCampos();
        LimpiarFiltroBusqueda();
       
    }//GEN-LAST:event_jButtonEliminar2ActionPerformed

    private void textBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textBusquedaActionPerformed

    private void textIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textIDActionPerformed

    private void jButtonBuscarIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarIDActionPerformed
       
        if (!textID.equals("")){
            
            String IDBuscar = textID.getText().trim();
                    
            String sql = "select id_usuarios, usuario, nombre, apellido, rol, mail, "
                + "telefono, status from usuarios where id_usuarios = '" + IDBuscar
                +  "'";
            
            cargarTablaUsuarios(sql);
        } 
    }//GEN-LAST:event_jButtonBuscarIDActionPerformed

    private void jButtonBuscarIRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarIRolActionPerformed
        
        int rolBusqueda = cmbRol.getSelectedIndex() + 1;
        String rolBuscado = null;
        
        switch(rolBusqueda){
            case 1:
                rolBuscado = "Administrador";
            break;
            case 2:
                rolBuscado = "Importador";
            break;
            case 3:
                rolBuscado = "Exportador";
            break;
            case 4:
                rolBuscado = "Agente";
            break;
            case 5:
                rolBuscado = "Logistica";
            break;
            case 6:
                rolBuscado = "Marketing";
            break;
        }
        
        String sql = "select id_usuarios, usuario, nombre, apellido, rol, mail, "
                + "telefono, status from usuarios where rol = '" + rolBuscado
                + "'";
            
        cargarTablaUsuarios(sql);
        
        
    }//GEN-LAST:event_jButtonBuscarIRolActionPerformed

    private void jButtonBuscarStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarStatusActionPerformed
       
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
        
        String sql = "select id_usuarios, usuario, nombre, apellido, rol, mail, "
                + "telefono, status from usuarios where status = '" + statusBuscado
                + "'";
            
        cargarTablaUsuarios(sql);
        
    }//GEN-LAST:event_jButtonBuscarStatusActionPerformed

    private void jButtonVolverAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverAtrasActionPerformed

        PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
        paginaPrincipal.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButtonVolverAtrasActionPerformed

    private void jButtonInfo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInfo3ActionPerformed

       InformacionModificarUsuarios infoModificarUs = new InformacionModificarUsuarios();
       infoModificarUs.setVisible(true);     
               
    }//GEN-LAST:event_jButtonInfo3ActionPerformed

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
            java.util.logging.Logger.getLogger(AdministrarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdministrarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdministrarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdministrarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdministrarUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbRol;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonBuscarID;
    private javax.swing.JButton jButtonBuscarIRol;
    private javax.swing.JButton jButtonBuscarStatus;
    private javax.swing.JButton jButtonEliminar2;
    private javax.swing.JButton jButtonInfo3;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonVerUsuario;
    private javax.swing.JButton jButtonVolverAtras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelApellido;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelMail;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelSubt;
    private javax.swing.JLabel jLabelSubt1;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelOpciones;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableUsuarios;
    private javax.swing.JTextField textApellido;
    private javax.swing.JTextField textBusqueda;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textMail;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textTel;
    private javax.swing.JTextField textUsuario;
    // End of variables declaration//GEN-END:variables

    public String getUsuarioBusqueda() {
        return usuarioBusqueda;
    }

    public void setUsuarioBusqueda(String usuarioBusqueda) {
        this.usuarioBusqueda = usuarioBusqueda;
    }

}
