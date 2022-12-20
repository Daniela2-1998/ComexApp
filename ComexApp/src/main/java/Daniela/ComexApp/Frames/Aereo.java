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
import javax.swing.table.DefaultTableModel;
import service.AereoService;
import service.UsuariosService;

/**
 *
 * @author Daniela
 */
public class Aereo extends javax.swing.JFrame {

    public String usuario = "", nombreCompleto = "", rol = "";
    /**
     * Creates new form Maritimas
     */
    public Aereo() {
        initComponents();
        
        setSize(1000, 820);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        
        PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
        UsuariosService usuariosService = new UsuariosService();
        
        usuario = paginaPrincipal.usuario;
        
        setTitle("Información completa de las aerolíneas - " + usuario + " - sistema ComexApp");
        jLabelTitulo.setText("Información completa de las aerolíneas");
        
        mostrarTodosLosDatos();
        
        cargarTablaRequisitosAereo();
    }
    
    // icono
    public Image getLogo(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/loguito1.png"));
        return retValue;   
    }
    
    AereoService aereoService = new AereoService();
    
     // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;
    
    
    public void LimpiarCamposRegistroAereo(){
        textID.setText("");
        textMail.setText("");
        textEmpleado.setText("");
        textEmpresa.setText("");
        textNumero.setText("");
        textRequisitos.setText("");
        textAereoBuscado.setText("");
    }

    
    public void cargarTablaAereo(String sql){

        DefaultTableModel modelo = new DefaultTableModel();
      
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            jTableAereo = new JTable(modelo);
            jScrollPane1.setViewportView(jTableAereo);
            
            modelo.addColumn("ID");
            modelo.addColumn("Empleado");
            modelo.addColumn("Aerolínea");
            modelo.addColumn("Mail");
            modelo.addColumn("Contacto");
            
            while(rs.next()){
                Object[] fila = new Object[5];
                for(int i = 0; i < 5; i++){
                    fila[i] = rs.getObject(i + 1);
                }
               modelo.addRow(fila);
            }
            
            conec.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al cargar tabla de aereo");
            System.err.println("Error al cargar tabla de aereo " + e);
        }
    }

   
     public void mostrarTodosLosDatos(){
         String sql = "select id_aereo, empleado, aerolinea, mail, "
            + "numero_contacto from aereo";
        cargarTablaAereo(sql);
    }
     
     public void cargarTablaRequisitosAereo(){

        DefaultTableModel modelo = new DefaultTableModel();
      
        String sql = "select aerolinea, requisitos from aereo";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            jTableAereo = new JTable(modelo);
            jScrollPane4.setViewportView(jTableAereo);
            
            modelo.addColumn("Empresa aerolínea");
            modelo.addColumn("Requisitos");

            while(rs.next()){
                Object[] fila = new Object[2];
                for(int i = 0; i < 2; i++){
                    fila[i] = rs.getObject(i + 1);
                }
               modelo.addRow(fila);
            }
            
            conec.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al cargar tabla de aereo");
            System.err.println("Error al cargar tabla de aerolíneas " + e);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelInfo = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelEmpresa = new javax.swing.JLabel();
        textEmpresa = new javax.swing.JTextField();
        jLabelEmpleado = new javax.swing.JLabel();
        textEmpleado = new javax.swing.JTextField();
        jLabelMail = new javax.swing.JLabel();
        textMail = new javax.swing.JTextField();
        jLabelNumero = new javax.swing.JLabel();
        textNumero = new javax.swing.JTextField();
        jLabelRequisitos = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textRequisitos = new javax.swing.JTextArea();
        jLabelID = new javax.swing.JLabel();
        textID = new javax.swing.JTextField();
        jButtonInfo = new javax.swing.JButton();
        jButtonRegistrar = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        jButtonVolver = new javax.swing.JButton();
        textAereoBuscado = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabelWallp = new javax.swing.JLabel();
        jPanelLista = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAereo = new javax.swing.JTable();
        jLabelTitulo1 = new javax.swing.JLabel();
        jLabelWallp1 = new javax.swing.JLabel();
        jPanelListaRequisitos = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableAereo1 = new javax.swing.JTable();
        jLabelTitulo2 = new javax.swing.JLabel();
        jLabelWallp2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getLogo());
        setIconImages(getIconImages());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 153));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jPanelInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jPanelInfo.add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 400, 60));

        jLabelEmpresa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEmpresa.setText("Nombre de la aerolínea:");
        jPanelInfo.add(jLabelEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        textEmpresa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textEmpresa.setForeground(new java.awt.Color(0, 0, 153));
        textEmpresa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelInfo.add(textEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 120, 190, 30));

        jLabelEmpleado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEmpleado.setText("Empleado:");
        jPanelInfo.add(jLabelEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        textEmpleado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textEmpleado.setForeground(new java.awt.Color(0, 0, 153));
        textEmpleado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelInfo.add(textEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 190, 30));

        jLabelMail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelMail.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMail.setText("Mail:");
        jPanelInfo.add(jLabelMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        textMail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textMail.setForeground(new java.awt.Color(0, 0, 153));
        textMail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelInfo.add(textMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 190, -1));

        jLabelNumero.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNumero.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNumero.setText("Número de contacto:");
        jPanelInfo.add(jLabelNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        textNumero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textNumero.setForeground(new java.awt.Color(0, 0, 153));
        textNumero.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelInfo.add(textNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 190, -1));

        jLabelRequisitos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelRequisitos.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRequisitos.setText("Requisitos:");
        jPanelInfo.add(jLabelRequisitos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, -1, -1));

        jScrollPane3.setForeground(new java.awt.Color(0, 0, 153));

        textRequisitos.setColumns(20);
        textRequisitos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textRequisitos.setForeground(new java.awt.Color(0, 0, 153));
        textRequisitos.setRows(5);
        jScrollPane3.setViewportView(textRequisitos);

        jPanelInfo.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 310, 110));

        jLabelID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelID.setForeground(new java.awt.Color(255, 255, 255));
        jLabelID.setText("ID:");
        jPanelInfo.add(jLabelID, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, -1, -1));

        textID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textID.setForeground(new java.awt.Color(0, 0, 153));
        textID.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelInfo.add(textID, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 100, -1));

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
        jPanelInfo.add(jButtonInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, -1, -1));

        jButtonRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jButtonRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/avion.png"))); // NOI18N
        jButtonRegistrar.setText("Registrar");
        jButtonRegistrar.setBorderPainted(false);
        jButtonRegistrar.setContentAreaFilled(false);
        jButtonRegistrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });
        jPanelInfo.add(jButtonRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 570, 190, 170));

        jButtonModificar.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jButtonModificar.setForeground(new java.awt.Color(102, 102, 102));
        jButtonModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/avioncirc1.png"))); // NOI18N
        jButtonModificar.setText("Modificar");
        jButtonModificar.setBorderPainted(false);
        jButtonModificar.setContentAreaFilled(false);
        jButtonModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonModificar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/avioncir.png"))); // NOI18N
        jButtonModificar.setSelected(true);
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });
        jPanelInfo.add(jButtonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 600, 160, 130));

        jButtonEliminar.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jButtonEliminar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/aviondesp.png"))); // NOI18N
        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.setBorderPainted(false);
        jButtonEliminar.setContentAreaFilled(false);
        jButtonEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });
        jPanelInfo.add(jButtonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 570, 190, 170));

        jButtonBuscar.setBackground(new java.awt.Color(0, 0, 153));
        jButtonBuscar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBuscar.setText("Buscar aerolínea");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        jPanelInfo.add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 100, 217, -1));

        jButtonVolver.setBackground(new java.awt.Color(0, 0, 153));
        jButtonVolver.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonVolver.setForeground(new java.awt.Color(255, 255, 255));
        jButtonVolver.setText("Volver");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });
        jPanelInfo.add(jButtonVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 510, 110, -1));

        textAereoBuscado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textAereoBuscadoActionPerformed(evt);
            }
        });
        jPanelInfo.add(textAereoBuscado, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 150, 217, 33));

        jToggleButton1.setBackground(new java.awt.Color(0, 0, 153));
        jToggleButton1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jToggleButton1.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton1.setText("Borrar busqueda / recargar tablas");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanelInfo.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, 300, 40));

        jLabelWallp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fa.jpg"))); // NOI18N
        jPanelInfo.add(jLabelWallp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, 1110, 870));

        jTabbedPane1.addTab("Información completa de la aerolínea", jPanelInfo);

        jPanelLista.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableAereo.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableAereo);

        jPanelLista.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 237, 600, 490));

        jLabelTitulo1.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabelTitulo1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo1.setText("Lista contactos aerolínea:");
        jPanelLista.add(jLabelTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 360, 60));

        jLabelWallp1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoavion.jpg"))); // NOI18N
        jPanelLista.add(jLabelWallp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -34, 1110, 810));

        jTabbedPane1.addTab("Aerolíneas y representantes registrados", jPanelLista);

        jPanelListaRequisitos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableAereo1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Empleado", "Empresa", "Mail", "Contacto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTableAereo1);
        if (jTableAereo1.getColumnModel().getColumnCount() > 0) {
            jTableAereo1.getColumnModel().getColumn(3).setPreferredWidth(150);
        }

        jPanelListaRequisitos.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 237, 600, 490));

        jLabelTitulo2.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabelTitulo2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo2.setText("Lista requisitos para cada aerolínea:");
        jPanelListaRequisitos.add(jLabelTitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 490, 60));

        jLabelWallp2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoavion.jpg"))); // NOI18N
        jPanelListaRequisitos.add(jLabelWallp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -34, 1110, 810));

        jTabbedPane1.addTab("Requisitos para cada aerolínea", jPanelListaRequisitos);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textAereoBuscadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textAereoBuscadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textAereoBuscadoActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed

        aereoService.obtenerDatosDeAereo(textAereoBuscado, textID, textMail, 
                textEmpleado, textEmpresa, textNumero, textRequisitos);

        String aereoABuscar = textAereoBuscado.getText().trim();

        setTitle("Informacíón completa de " + aereoABuscar + " - Sistema ComexApp");
        jLabelTitulo.setText("Información completa de " + aereoABuscar + "");
        
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed

        int id = Integer.parseInt(textID.getText().trim());
        String empleado = textEmpleado.getText().trim();

        try{
            Boolean aprobarEliminar = aereoService.eliminarAereo(empleado, id);

            if(aprobarEliminar.equals(true)){
                JOptionPane.showMessageDialog(null, "Eliminación éxitosa");
                LimpiarCamposRegistroAereo();
            }

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No pudimos eliminar al importador");
        }
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed

        String mailMod, empleadoMod, empresaMod, numeroContactoMod, requisitosMod;
        int IDMod;

        String empleado = textAereoBuscado.getText().trim();

        try{

            IDMod = Integer.parseInt(textID.getText().trim());
            empleadoMod = textEmpleado.getText().trim();
            empresaMod = textEmpresa.getText().trim();
            mailMod = textMail.getText().trim();
            numeroContactoMod = textNumero.getText().trim();
            requisitosMod = textRequisitos.getText().trim();

            aereoService.modificarAereo(empleado, IDMod, mailMod, empleadoMod, 
                    empresaMod, numeroContactoMod, requisitosMod);

        }catch(Exception e){
            System.err.println("Fallo al modificar datos " + e);
            JOptionPane.showMessageDialog(null, "Fallo al modificar datos");
        }
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed

        String mail, empleado, empresa, numeroContacto, requisitos;
        int ID;

        Boolean recepcion;

        ID = Integer.parseInt(textID.getText().trim());
        mail = textMail.getText().trim();
        empleado = textEmpleado.getText().trim();
        empresa = textEmpresa.getText().trim();
        numeroContacto = textNumero.getText().trim();
        requisitos = textRequisitos.getText().trim();

        recepcion = aereoService.registroAereo(ID, mail, empleado, empresa, 
                numeroContacto, requisitos);

        if(recepcion.equals(true)){
            LimpiarCamposRegistroAereo();
        }
    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    private void jButtonInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInfoActionPerformed

        InformacionIDAereo informacionIDAereo = new InformacionIDAereo();
        informacionIDAereo.setVisible(true);
        
    }//GEN-LAST:event_jButtonInfoActionPerformed

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
       
        PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
        paginaPrincipal.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButtonVolverActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed

        LimpiarCamposRegistroAereo();
        mostrarTodosLosDatos();
        cargarTablaRequisitosAereo();
        
    }//GEN-LAST:event_jToggleButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Aereo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aereo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aereo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aereo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Aereo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonInfo;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JLabel jLabelEmpleado;
    private javax.swing.JLabel jLabelEmpresa;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelMail;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JLabel jLabelRequisitos;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelTitulo1;
    private javax.swing.JLabel jLabelTitulo2;
    private javax.swing.JLabel jLabelWallp;
    private javax.swing.JLabel jLabelWallp1;
    private javax.swing.JLabel jLabelWallp2;
    private javax.swing.JPanel jPanelInfo;
    private javax.swing.JPanel jPanelLista;
    private javax.swing.JPanel jPanelListaRequisitos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableAereo;
    private javax.swing.JTable jTableAereo1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField textAereoBuscado;
    private javax.swing.JTextField textEmpleado;
    private javax.swing.JTextField textEmpresa;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textMail;
    private javax.swing.JTextField textNumero;
    private javax.swing.JTextArea textRequisitos;
    // End of variables declaration//GEN-END:variables
}
