package Daniela.ComexApp.Frames;

import config.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import service.InicioSesionService;
import service.UsuariosService;

/**
 *
 * @author Daniela
 * 
 */
public class VerUsuario extends javax.swing.JFrame {

    String usuario = "", usuarioTraido = "", usuarioBuscado = "";
    /**
     * Creates new form VerUsuario
     */
    public VerUsuario() {
        initComponents();
        
        setSize(800, 750);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        
        
        //usuarioTraido = administrarUsuarios.usuarioBusqueda;
       // usuario = textUsuarioBuscado.getText().trim();
        usuario = textUsuarioBuscado.getText().trim();
        
        setTitle("Informacíón completa del usuario - Administrador - Sistema ComexApp");
        jLabelTitulo.setText("Información completa del usuario");
       // usuarioBuscado = usuarioABuscar(usuarioTraido, usuario);

       
       // personalizacionTitulos(usuarioBuscado, usuarioTraido);
        //usuariosService.obtenerDatosDelUsuario(usuarioTraido);
       
    }
      // icono
    public Image getLogo(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/loguito1.png"));
        return retValue;   
    }
    
    InicioSesionService inicioSesionService = new InicioSesionService();
    RegistroUsuarios registroUsuarios = new RegistroUsuarios();
    UsuariosService usuariosService = new UsuariosService();
    AdministrarUsuarios administrarUsuarios = new AdministrarUsuarios();
    
     
    
    public void personalizacionTitulos(String usuarioBuscado, String usuarioTraido){
          
        if(usuarioBuscado.equals(usuarioTraido)){
            setTitle("Informacíón completa de " + usuarioTraido + " - Administrador - Sistema ComexApp");
            jLabelTitulo.setText("Información completa de " + usuarioTraido + "");
        } else if (!usuarioBuscado.equals(usuarioTraido)){
             setTitle("Informacíón completa de " + usuarioBuscado + " - Administrador - Sistema ComexApp");
             jLabelTitulo.setText("Información completa de " + usuarioBuscado + "");
        }
    }
  
    
    
    public String usuarioABuscar(String usuarioTraido, String usuario){
       
     if(!usuario.equals(usuarioTraido)){
        if(usuarioTraido.equals("")){
            usuarioBuscado = usuarioTraido;
        } else if(!usuarioTraido.equals("") && usuario.equals("")){
            usuarioBuscado = usuario;        
        }
     }
     return usuarioBuscado;
    }
    
   
    public void LimpiarCampos(){
        textUsuario.setText("");
        textContraseña.setText("");
        textNombre.setText("");
        textApellido.setText("");
        textMail.setText("");
        textTelefono.setText("");
        textID.setText("");
        cmbRol.setSelectedItem(0);
        cmbStatus.setSelectedItem(0);
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
        textUsuarioBuscado = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabelUsuario = new javax.swing.JLabel();
        textUsuario = new javax.swing.JTextField();
        jLabelNombre = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        jLabelApellido = new javax.swing.JLabel();
        textApellido = new javax.swing.JTextField();
        jLabelMail = new javax.swing.JLabel();
        textMail = new javax.swing.JTextField();
        jLabelTel = new javax.swing.JLabel();
        textTelefono = new javax.swing.JTextField();
        textID = new javax.swing.JTextField();
        jLabelID = new javax.swing.JLabel();
        jButtonInfo = new javax.swing.JButton();
        jLabelRol = new javax.swing.JLabel();
        cmbRol = new javax.swing.JComboBox<>();
        jLabelStatus = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        jLabelSubt = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelContraseña = new javax.swing.JLabel();
        textContraseña = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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
                .addContainerGap(634, Short.MAX_VALUE))
        );
        jPanelArribaLayout.setVerticalGroup(
            jPanelArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelArribaLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabelTitulo)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelArriba, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 90));

        jPanelMenu.setBackground(new java.awt.Color(255, 255, 255));
        jPanelMenu.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        jButtonModificar.setBackground(new java.awt.Color(0, 0, 153));
        jButtonModificar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonModificar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonModificar.setText("Modificar usuario");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jButtonEliminar.setBackground(new java.awt.Color(0, 0, 153));
        jButtonEliminar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonEliminar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEliminar.setText("Eliminar usuario");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jButtonRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButtonRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuario2.png"))); // NOI18N
        jButtonRegistrar.setText("Registrar");
        jButtonRegistrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonRegistrar.setBorderPainted(false);
        jButtonRegistrar.setContentAreaFilled(false);
        jButtonRegistrar.setFocusPainted(false);
        jButtonRegistrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });

        jButtonBuscar.setBackground(new java.awt.Color(0, 0, 153));
        jButtonBuscar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBuscar.setText("Buscar usuario");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        textUsuarioBuscado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textUsuarioBuscadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMenuLayout = new javax.swing.GroupLayout(jPanelMenu);
        jPanelMenu.setLayout(jPanelMenuLayout);
        jPanelMenuLayout.setHorizontalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMenuLayout.createSequentialGroup()
                        .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                            .addComponent(jButtonModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                            .addComponent(jButtonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                            .addComponent(textUsuarioBuscado, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMenuLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonVolverAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))))
        );
        jPanelMenuLayout.setVerticalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMenuLayout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jButtonBuscar)
                .addGap(18, 18, 18)
                .addComponent(textUsuarioBuscado, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112)
                .addComponent(jButtonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonEliminar)
                .addGap(18, 18, 18)
                .addComponent(jButtonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(jButtonVolverAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );

        getContentPane().add(jPanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 750));

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsuario.setText("Usuario:");

        textUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textUsuario.setForeground(new java.awt.Color(0, 0, 153));
        textUsuario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNombre.setText("Nombre:");

        textNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textNombre.setForeground(new java.awt.Color(0, 0, 153));
        textNombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelApellido.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelApellido.setForeground(new java.awt.Color(255, 255, 255));
        jLabelApellido.setText("Apellido:");

        textApellido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textApellido.setForeground(new java.awt.Color(0, 0, 153));
        textApellido.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelMail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelMail.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMail.setText("Mail:");

        textMail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textMail.setForeground(new java.awt.Color(0, 0, 153));
        textMail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelTel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTel.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTel.setText("Teléfono:");

        textTelefono.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textTelefono.setForeground(new java.awt.Color(0, 0, 153));
        textTelefono.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        textID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textID.setForeground(new java.awt.Color(0, 0, 153));
        textID.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelID.setForeground(new java.awt.Color(255, 255, 255));
        jLabelID.setText("ID:");

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

        jLabelRol.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelRol.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRol.setText("Rol:");

        cmbRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Importador", "Exportador", "Agente", "Logistica", "Marketing" }));
        cmbRol.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelStatus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelStatus.setForeground(new java.awt.Color(255, 255, 255));
        jLabelStatus.setText("Status:");

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo", "Suspendido" }));

        jLabelSubt.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabelSubt.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSubt.setText("Datos completos:");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/empleados3.png"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(150, 150));
        jLabel1.setMinimumSize(new java.awt.Dimension(150, 150));
        jLabel1.setPreferredSize(new java.awt.Dimension(150, 150));

        jLabelContraseña.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelContraseña.setForeground(new java.awt.Color(255, 255, 255));
        jLabelContraseña.setText("Contraseña:");

        textContraseña.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textContraseña.setForeground(new java.awt.Color(0, 0, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabelUsuario)
                        .addComponent(textNombre)
                        .addComponent(textUsuario)
                        .addComponent(textApellido)
                        .addComponent(textMail)
                        .addComponent(textTelefono)
                        .addComponent(jLabelSubt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelTel)
                        .addComponent(jLabelMail)
                        .addComponent(jLabelApellido)
                        .addComponent(jLabelNombre)
                        .addComponent(jLabelContraseña)
                        .addComponent(textContraseña))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelID)
                            .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButtonInfo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelRol)
                            .addComponent(cmbRol, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelStatus)
                            .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabelSubt)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUsuario)
                    .addComponent(jLabelRol))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(textUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jLabelNombre))
                    .addComponent(cmbRol, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelApellido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jLabelMail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabelTel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelContraseña)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonInfo, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 590, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVolverAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverAtrasActionPerformed

        this.dispose();
        
    }//GEN-LAST:event_jButtonVolverAtrasActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed

        try{        
        
            String usuarioMod, contraseñaMod, nombreMod, apellidoMod, rolMod = null, 
                mailMod, telefonoMod, statusMod = null;
            int idMod, rolStatusMod = 0, statusNivelMod = 0;
        
            usuario = textUsuarioBuscado.getText().trim();
            
            idMod= Integer.parseInt(textID.getText().trim());
            usuarioMod = textUsuario.getText().trim();
            contraseñaMod = textContraseña.getText().trim();
            nombreMod = textNombre.getText().trim();
            apellidoMod = textApellido.getText().trim();
            mailMod = textMail.getText().trim();
            telefonoMod = textTelefono.getText().trim();
            rolStatusMod = cmbRol.getSelectedIndex() + 1;
            statusNivelMod = cmbStatus.getSelectedIndex() + 1;

            if(rolStatusMod == 1){
                rolMod = "Administrador";
            } else if(rolStatusMod == 2){
                rolMod = "Importador";
            } else if(rolStatusMod == 3){
                rolMod = "Exportador";
            } else if(rolStatusMod == 4){
                rolMod = "Agente";
            } else if(rolStatusMod == 5){
                rolMod = "Logistica";
            } else if(rolStatusMod == 6){
                rolMod = "Marketing";
            }

            if(statusNivelMod == 1){
               statusMod = "Activo";
            } else if (statusNivelMod == 2){
               statusMod = "Inactivo";
            } else if (statusNivelMod == 3){
               statusMod = "Suspendido";
            }
     
            usuariosService.modificarTodosLosDatosDeUsuarios(idMod, usuario, 
                    usuarioMod, contraseñaMod, nombreMod, apellidoMod, rolMod, 
                    mailMod, telefonoMod, statusMod);
       
        }catch(Exception e){
            System.err.println("Fallo al modificar datos " + e);
            JOptionPane.showMessageDialog(null, "Fallo al modificar datos");
        }
        
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed

        int id = Integer.parseInt(textID.getText().trim());
        String usuario = textUsuario.getText().trim();
        
        try{
            Boolean aprobarEliminar = usuariosService.eliminarUsuario(usuario, id);
            
            if(aprobarEliminar.equals(true)){
                JOptionPane.showMessageDialog(null, "Eliminación éxitosa");
                LimpiarCampos();
            }
                  
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No pudimos eliminar al usuario");
        }
        
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed

        String usuario, contraseña, nombre, apellido, rol = null, mail, telefono, status = null;
        int id, rolStatus = 0, statusNivel = 0;

        String recepcion;

        id = Integer.parseInt(textID.getText().trim());
        usuario = textUsuario.getText().trim();
        contraseña = textContraseña.getText().trim();
        nombre = textNombre.getText().trim();
        apellido = textApellido.getText().trim();
        mail = textMail.getText().trim();
        telefono = textTelefono.getText().trim();
        rolStatus = cmbRol.getSelectedIndex() + 1;
        statusNivel = cmbStatus.getSelectedIndex() + 1;

        if(rolStatus == 1){
            rol = "Administrador";
        } else if(rolStatus == 2){
            rol = "Importador";
        } else if(rolStatus == 3){
            rol = "Exportador";
        } else if(rolStatus == 4){
            rol = "Agente";
        } else if(rolStatus == 5){
            rol = "Logistica";
        } else if(rolStatus == 6){
            rol = "Marketing";
        }

        if(statusNivel == 1){
            status = "Activo";
        } else if (statusNivel == 2){
            status = "Inactivo";
        } else if (statusNivel == 3){
            status = "Suspendido";
        }

        recepcion = inicioSesionService.agregarUsuario(id, usuario, contraseña, nombre, apellido, rol, mail, telefono, status).toString();

        if(!recepcion.isEmpty()){
            JOptionPane.showMessageDialog(null, "Se creó correctamente el usuario de " + usuario);
            registroUsuarios.LimpiarCamposRegistroUsuarios();
        } else if (recepcion.isEmpty()){
            JOptionPane.showMessageDialog(null, "No es posible crear el usuario solicitado");
        }
    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    private void jButtonInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInfoActionPerformed

        InformacionID informacionID = new InformacionID();
        informacionID.setVisible(true);

    }//GEN-LAST:event_jButtonInfoActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed

      usuariosService.obtenerDatosDelUsuario(textUsuarioBuscado, textID, 
              textUsuario, textNombre, textNombre, textApellido, textMail, 
              textTelefono, cmbRol, cmbStatus);
      
       setTitle("Informacíón completa de " + usuario + " - Administrador - Sistema ComexApp");
       jLabelTitulo.setText("Información completa de " + usuario + "");
  
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void textUsuarioBuscadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textUsuarioBuscadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textUsuarioBuscadoActionPerformed

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
            java.util.logging.Logger.getLogger(VerUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbRol;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonInfo;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JButton jButtonVolverAtras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelApellido;
    private javax.swing.JLabel jLabelContraseña;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelMail;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelRol;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JLabel jLabelSubt;
    private javax.swing.JLabel jLabelTel;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelArriba;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JTextField textApellido;
    private javax.swing.JPasswordField textContraseña;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textMail;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textTelefono;
    private javax.swing.JTextField textUsuario;
    private javax.swing.JTextField textUsuarioBuscado;
    // End of variables declaration//GEN-END:variables


}