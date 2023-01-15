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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import service.AgendaPersonalService;
import service.ImportadoresService;
import service.InicioSesionService;
import service.UsuariosService;

/**
 *
 * @author Daniela
 * 
 */
public class AgendaContactosPersonal extends javax.swing.JFrame {

    String nombreCompleto = "", usuario = "";
    /**
     * Creates new form VerUsuario
     */
    public AgendaContactosPersonal() {
        initComponents();
        
        setSize(870, 750);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);

        PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
        
        usuario = paginaPrincipal.usuario;
        nombreCompleto = paginaPrincipal.nombreCompleto;
        
        
        setTitle("Agenda personal de " + usuario + " - Sistema ComexApp");
        jLabelTitulo.setText("Agenda personal de " + nombreCompleto);

        
        jPanelInfo.setVisible(true);
        jPanelLista.setVisible(false);
        mostrarTodosLosDatosContacto();
        mostrarTodosLosDatosProducto();
    }
      // icono
    public Image getLogo(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/loguito1.png"));
        return retValue;   
    }
    
    AgendaPersonalService agendaPersonalService = new AgendaPersonalService();
    
    
    public void LimpiarCampos(){
        textEmpresa.setText("");
        textEmpleado.setText("");
        textMail.setText("");
        textNumero.setText("");
        textPais.setText("");
        textID.setText("");
        textProductos.setText("");
        cmbStatus.setSelectedItem(0);
        cmbCargo.setSelectedItem(0);
    }
    
    
       // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;

     public void cargarTablaContactos(String sql){

        DefaultTableModel modelo = new DefaultTableModel();
      
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            jTableAgenda = new JTable(modelo);
            jScrollPane2.setViewportView(jTableAgenda);
            
            modelo.addColumn("Empresa");
            modelo.addColumn("Nombre");
            modelo.addColumn("Mail");
            modelo.addColumn("Número de contacto");
            
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
   
     public void mostrarTodosLosDatosContacto(){
         String sql = "select empresa, nombre, mail, numero_contacto from agenda_personal";
        cargarTablaContactos(sql);
    }

     public void cargarTablaProducto(String sql){

        DefaultTableModel modelo = new DefaultTableModel();
      
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            jTableProducto = new JTable(modelo);
            jScrollPane3.setViewportView(jTableProducto);
            
            modelo.addColumn("ID");
            modelo.addColumn("Producto");
            modelo.addColumn("Empleado");
            modelo.addColumn("Status");
            
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
   
     public void mostrarTodosLosDatosProducto(){
         String sql = "select id_agenda, productos, nombre, status from agenda_personal";
        cargarTablaProducto(sql);
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
        textBuscar = new javax.swing.JTextField();
        jPanelInfo = new javax.swing.JPanel();
        jLabelEmpresa = new javax.swing.JLabel();
        textEmpresa = new javax.swing.JTextField();
        jLabelEmpleado = new javax.swing.JLabel();
        textEmpleado = new javax.swing.JTextField();
        jLabelMail = new javax.swing.JLabel();
        textMail = new javax.swing.JTextField();
        jLabelContacto = new javax.swing.JLabel();
        textNumero = new javax.swing.JTextField();
        jLabelPais = new javax.swing.JLabel();
        textPais = new javax.swing.JTextField();
        textID = new javax.swing.JTextField();
        jLabelID = new javax.swing.JLabel();
        jButtonInfo = new javax.swing.JButton();
        jLabelStatus = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        jLabelSubt = new javax.swing.JLabel();
        jLabelProductos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textProductos = new javax.swing.JTextArea();
        jLabelCargo = new javax.swing.JLabel();
        cmbCargo = new javax.swing.JComboBox<>();
        jPanelLista = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableAgenda = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableProducto = new javax.swing.JTable();
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
        jButtonModificar.setText("Modificar contacto");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });
        jPanelMenu.add(jButtonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 220, -1));

        jButtonEliminar.setBackground(new java.awt.Color(0, 0, 153));
        jButtonEliminar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonEliminar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEliminar.setText("Eliminar contacto");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });
        jPanelMenu.add(jButtonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 220, -1));

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
        jPanelMenu.add(jButtonRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 190, 140));

        jButtonBuscar.setBackground(new java.awt.Color(0, 0, 153));
        jButtonBuscar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBuscar.setText("Buscar contacto");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        jPanelMenu.add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 217, -1));

        textBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textBuscarActionPerformed(evt);
            }
        });
        jPanelMenu.add(textBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 217, 33));

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

        jLabelMail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelMail.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMail.setText("Mail:");
        jPanelInfo.add(jLabelMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 193, -1, -1));

        textMail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textMail.setForeground(new java.awt.Color(0, 0, 153));
        textMail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelInfo.add(textMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 219, 163, -1));

        jLabelContacto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelContacto.setForeground(new java.awt.Color(255, 255, 255));
        jLabelContacto.setText("Número de contacto:");
        jPanelInfo.add(jLabelContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 255, -1, -1));

        textNumero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textNumero.setForeground(new java.awt.Color(0, 0, 153));
        textNumero.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelInfo.add(textNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 281, 163, -1));

        jLabelPais.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelPais.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPais.setText("Pais:");
        jPanelInfo.add(jLabelPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 320, -1, -1));

        textPais.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textPais.setForeground(new java.awt.Color(0, 0, 153));
        textPais.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelInfo.add(textPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 350, 163, -1));

        textID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textID.setForeground(new java.awt.Color(0, 0, 153));
        textID.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelInfo.add(textID, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 420, 93, -1));

        jLabelID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelID.setForeground(new java.awt.Color(255, 255, 255));
        jLabelID.setText("ID:");
        jPanelInfo.add(jLabelID, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 390, -1, -1));

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
        jPanelInfo.add(jButtonInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, -1, -1));

        jLabelStatus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelStatus.setForeground(new java.awt.Color(255, 255, 255));
        jLabelStatus.setText("Status:");
        jPanelInfo.add(jLabelStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, -1, -1));

        cmbStatus.setForeground(new java.awt.Color(0, 0, 153));
        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo", "Suspendido" }));
        jPanelInfo.add(cmbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 120, 40));

        jLabelSubt.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabelSubt.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSubt.setText("Datos completos:");
        jPanelInfo.add(jLabelSubt, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 18, -1, -1));

        jLabelProductos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelProductos.setForeground(new java.awt.Color(255, 255, 255));
        jLabelProductos.setText("Productos asociados:");
        jPanelInfo.add(jLabelProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, -1, -1));

        jScrollPane1.setForeground(new java.awt.Color(0, 0, 153));

        textProductos.setColumns(20);
        textProductos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textProductos.setForeground(new java.awt.Color(0, 0, 153));
        textProductos.setRows(5);
        jScrollPane1.setViewportView(textProductos);

        jPanelInfo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 310, 170));

        jLabelCargo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelCargo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCargo.setText("Cargo:");
        jPanelInfo.add(jLabelCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, -1, -1));

        cmbCargo.setForeground(new java.awt.Color(0, 0, 153));
        cmbCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Importador", "Exportador", "Despachante", "Maritima", "Aereo", "Otros" }));
        jPanelInfo.add(cmbCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 350, 120, 40));

        getContentPane().add(jPanelInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 610, 660));

        jPanelLista.setBackground(new java.awt.Color(0, 0, 153));
        jPanelLista.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelLista.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableAgenda.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTableAgenda);

        jPanelLista.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 560, 220));

        jTableProducto.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTableProducto);

        jPanelLista.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 560, 320));

        getContentPane().add(jPanelLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 610, 660));

        jMenuInformacion.setForeground(new java.awt.Color(0, 0, 153));
        jMenuInformacion.setText("Información contacto específico");
        jMenuInformacion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuInformacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuInformacionMouseClicked(evt);
            }
        });
        jMenuBar.add(jMenuInformacion);

        jMenuLista.setBackground(new java.awt.Color(204, 204, 204));
        jMenuLista.setForeground(new java.awt.Color(0, 51, 153));
        jMenuLista.setText("Lista contactos personales");
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

        String nombreMod, empresaMod, mailMod, numeroContactoMod, paisMod, 
                productosAsociadosMod, statusMod = null, cargoMod = null;
         
        int statusNivel = 0, IDMod, cargoNivel = 0;   
        
        String nombre = textBuscar.getText().trim();
        
        try{        
        
            IDMod = Integer.parseInt(textID.getText().trim());
            empresaMod = textEmpresa.getText().trim();
            mailMod = textMail.getText().trim();
            nombreMod = textEmpleado.getText().trim();
            numeroContactoMod = textNumero.getText().trim();
            paisMod = textPais.getText().trim();
            productosAsociadosMod = textProductos.getText().trim();
            statusNivel = cmbStatus.getSelectedIndex() + 1;
            cargoNivel = cmbCargo.getSelectedIndex() + 1;
        
            if(statusNivel == 1){
                statusMod = "Activo";
            } else if (statusNivel == 2){
                statusMod = "Inactivo";
            } else if (statusNivel == 3){
                statusMod = "Suspendido";
            }
        
            if(cargoNivel == 1){
                cargoMod = "Importador";
            } else if (cargoNivel == 2){
                cargoMod = "Exportador";
            } else if (cargoNivel == 3){
                cargoMod = "Despachante";
            } else if (cargoNivel == 4){
                cargoMod = "Maritima";
            } else if (cargoNivel == 5){
                cargoMod = "Aereo";
            } else if (cargoNivel == 6){
                cargoMod = "Otros";
            }
            
            agendaPersonalService.modificarDatosContactoAgendaPersonal(IDMod, 
                    nombreMod, empresaMod, mailMod, numeroContactoMod, paisMod, 
                    productosAsociadosMod, statusMod, cargoMod, nombre, usuario);

        }catch(Exception e){
            System.err.println("Fallo al modificar datos " + e);
            JOptionPane.showMessageDialog(null, "Fallo al modificar datos");
        }
        mostrarTodosLosDatosContacto();
        mostrarTodosLosDatosProducto();
        
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed

        int id = Integer.parseInt(textID.getText().trim());
        String nombre = textEmpleado.getText().trim();
        
        try{
            Boolean aprobarEliminar = agendaPersonalService.eliminarContactoPersonal(nombre, id);
            
            if(aprobarEliminar.equals(true)){
                JOptionPane.showMessageDialog(null, "Eliminación éxitosa");
                LimpiarCampos();
            }
                  
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No pudimos eliminar al contacto");
        }
        mostrarTodosLosDatosContacto();
        mostrarTodosLosDatosProducto();
        
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed

        String nombre, empresa, mail, numeroContacto, pais, 
                productosAsociados, status = null, cargo = null;
        int statusNivel = 0, ID, cargoNivel = 0;
        
        Boolean recepcion;
        
        ID = Integer.parseInt(textID.getText().trim());
        empresa = textEmpresa.getText().trim();
        mail = textMail.getText().trim();
        nombre = textEmpleado.getText().trim();
        numeroContacto = textNumero.getText().trim();
        pais = textPais.getText().trim();
        productosAsociados = textProductos.getText().trim();
        statusNivel = cmbStatus.getSelectedIndex() + 1;
        cargoNivel = cmbCargo.getSelectedIndex() + 1;
        
        if(statusNivel == 1){
           status = "Activo";
        } else if (statusNivel == 2){
           status = "Inactivo";
        } else if (statusNivel == 3){
           status = "Suspendido";
        }
        
        if(cargoNivel == 1){
           cargo = "Importador";
        } else if (cargoNivel == 2){
           cargo = "Exportador";
        } else if (cargoNivel == 3){
           cargo = "Despachante";
        } else if (cargoNivel == 4){
           cargo = "Maritima";
        } else if (cargoNivel == 5){
           cargo = "Aereo";
        } else if (cargoNivel == 6){
           cargo = "Otros";
        }
           
        recepcion = agendaPersonalService.registroContactoAgendaPersonal(ID, nombre, 
                empresa, mail, numeroContacto, pais, productosAsociados, status, 
                usuario, cargo);
        
        if(recepcion.equals(true)){
           LimpiarCampos();
        }
        
        mostrarTodosLosDatosContacto();
        mostrarTodosLosDatosProducto();
        
    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed

       agendaPersonalService.obtenerDatosDelContactoPersonal(textBuscar, textID,
               textEmpleado, textEmpresa, textMail, textNumero, textPais, 
               textProductos, cmbStatus, cmbCargo);
      
       String contactoABuscar = textBuscar.getText().trim();
               
       setTitle("Informacíón completa de " + contactoABuscar + " - Sistema ComexApp");
       jLabelTitulo.setText("Información completa de " + contactoABuscar + "");
       
       String sql1 = "select id_agenda, empresa, nombre, mail, numero_contacto, "
                 + "status from agenda_personal where nombre = '" + contactoABuscar + "'";
       String sql2 = "select id_agenda, productos, nombre, status from agenda_personal "
               + "where nombre = '" + contactoABuscar + "'";
       
       cargarTablaContactos(sql1);
       cargarTablaProducto(sql2);
       
  
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void textBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(AgendaContactosPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgendaContactosPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgendaContactosPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgendaContactosPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgendaContactosPersonal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbCargo;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonInfo;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JButton jButtonVolverAtras;
    private javax.swing.JLabel jLabelCargo;
    private javax.swing.JLabel jLabelContacto;
    private javax.swing.JLabel jLabelEmpleado;
    private javax.swing.JLabel jLabelEmpresa;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelMail;
    private javax.swing.JLabel jLabelPais;
    private javax.swing.JLabel jLabelProductos;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JLabel jLabelSubt;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuInformacion;
    private javax.swing.JMenu jMenuLista;
    private javax.swing.JPanel jPanelArriba;
    private javax.swing.JPanel jPanelInfo;
    private javax.swing.JPanel jPanelLista;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableAgenda;
    private javax.swing.JTable jTableProducto;
    private javax.swing.JTextField textBuscar;
    private javax.swing.JTextField textEmpleado;
    private javax.swing.JTextField textEmpresa;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textMail;
    private javax.swing.JTextField textNumero;
    private javax.swing.JTextField textPais;
    private javax.swing.JTextArea textProductos;
    // End of variables declaration//GEN-END:variables


}