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
import service.AgendaPersonalImpl;
import service.MaritimasService;
import service.UsuariosImpl;

/**
 *
 * @author Daniela
 */
public class Maritimas extends javax.swing.JFrame {

    public String usuario = "", nombreCompleto = "", rol = "";
    /**
     * Creates new form Maritimas
     */
    public Maritimas() {
        initComponents();
        
        setSize(1000, 820);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        
        PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
        UsuariosImpl usuariosService = new UsuariosImpl();
        
        usuario = paginaPrincipal.usuario;
        
        setTitle("Información completa de las marítimas - " + usuario + " - sistema ComexApp");
        jLabelTitulo.setText("Información completa de las marítimas");
        
        mostrarTodosLosDatos();
        cargarTablaRequisitosMaritimas();
    }
    
    // icono
    public Image getLogo(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/loguito1.png"));
        return retValue;   
    }
    
    AgendaPersonalImpl agendaPersonalService = new AgendaPersonalImpl();
    MaritimasService maritimasService = new MaritimasService();
    
     // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;
    
    
    public void LimpiarCamposRegistroMaritima(){
        textID.setText("");
        textMail.setText("");
        textEmpleado.setText("");
        textEmpresa.setText("");
        textNumero.setText("");
        textRequisitosAviso.setText("");
        textTipoTransporte.setText("");
        textMaritimaBuscada.setText("");
    }

    
    public void cargarTablaMaritimas(String sql){

        DefaultTableModel modelo = new DefaultTableModel();
      
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            jTableMaritimas = new JTable(modelo);
            jScrollPane1.setViewportView(jTableMaritimas);
            
            modelo.addColumn("ID");
            modelo.addColumn("Empleado");
            modelo.addColumn("Empresa");
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
            JOptionPane.showMessageDialog(null, "Error al cargar tabla de maritimas ");
            System.err.println("Error al cargar tabla de maritimas  " + e);
        }
    }

   
     public void mostrarTodosLosDatos(){
         String sql = "select id_maritima, empleado, empresa, mail, "
            + "numero_contacto from maritimas";
        cargarTablaMaritimas(sql);
    }
     
     public void cargarTablaRequisitosMaritimas(){

        DefaultTableModel modelo = new DefaultTableModel();
      
        String sql = "select empresa, requisitos_aviso from maritimas";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            jTableMaritimas = new JTable(modelo);
            jScrollPane4.setViewportView(jTableMaritimas);
            
            modelo.addColumn("Empresa");
            modelo.addColumn("Requisitos marítima");

            while(rs.next()){
                Object[] fila = new Object[2];
                for(int i = 0; i < 2; i++){
                    fila[i] = rs.getObject(i + 1);
                }
               modelo.addRow(fila);
            }
            
            conec.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al cargar tabla de maritimas ");
            System.err.println("Error al cargar tabla de maritimas  " + e);
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
        textRequisitosAviso = new javax.swing.JTextArea();
        jLabelTransporte = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textTipoTransporte = new javax.swing.JTextArea();
        jLabelID = new javax.swing.JLabel();
        textID = new javax.swing.JTextField();
        jButtonInfo = new javax.swing.JButton();
        jButtonRegistrar = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        jButtonVolver = new javax.swing.JButton();
        textMaritimaBuscada = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jButtonAgendaPersonal = new javax.swing.JButton();
        jLabelWallp = new javax.swing.JLabel();
        jPanelLista = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMaritimas = new javax.swing.JTable();
        jLabelTitulo1 = new javax.swing.JLabel();
        jLabelWallp1 = new javax.swing.JLabel();
        jPanelListaRequisitos = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableMaritimas1 = new javax.swing.JTable();
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
        jLabelEmpresa.setText("Nombre de marítima:");
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
        jLabelRequisitos.setText("Requisitos para aviso de arribo / otro tipo de requisitos:");
        jPanelInfo.add(jLabelRequisitos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, -1, -1));

        jScrollPane3.setForeground(new java.awt.Color(0, 0, 153));

        textRequisitosAviso.setColumns(20);
        textRequisitosAviso.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textRequisitosAviso.setForeground(new java.awt.Color(0, 0, 153));
        textRequisitosAviso.setRows(5);
        jScrollPane3.setViewportView(textRequisitosAviso);

        jPanelInfo.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 310, 110));

        jLabelTransporte.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTransporte.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTransporte.setText("Detalle del transporte:");
        jPanelInfo.add(jLabelTransporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, -1, -1));

        jScrollPane2.setForeground(new java.awt.Color(0, 0, 153));

        textTipoTransporte.setColumns(20);
        textTipoTransporte.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textTipoTransporte.setForeground(new java.awt.Color(0, 0, 153));
        textTipoTransporte.setRows(5);
        jScrollPane2.setViewportView(textTipoTransporte);

        jPanelInfo.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 570, 310, 110));

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
        jButtonRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ship.png"))); // NOI18N
        jButtonRegistrar.setText("Registrar");
        jButtonRegistrar.setBorderPainted(false);
        jButtonRegistrar.setContentAreaFilled(false);
        jButtonRegistrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });
        jPanelInfo.add(jButtonRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 610, 160, 120));

        jButtonModificar.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jButtonModificar.setForeground(new java.awt.Color(102, 102, 102));
        jButtonModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/barconormal.png"))); // NOI18N
        jButtonModificar.setText("Modificar");
        jButtonModificar.setBorderPainted(false);
        jButtonModificar.setContentAreaFilled(false);
        jButtonModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonModificar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/barcomodificado.png"))); // NOI18N
        jButtonModificar.setSelected(true);
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });
        jPanelInfo.add(jButtonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 600, 160, 130));

        jButtonEliminar.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jButtonEliminar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/shipdelete.png"))); // NOI18N
        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.setBorderPainted(false);
        jButtonEliminar.setContentAreaFilled(false);
        jButtonEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });
        jPanelInfo.add(jButtonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 600, 160, 120));

        jButtonBuscar.setBackground(new java.awt.Color(0, 0, 153));
        jButtonBuscar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBuscar.setText("Buscar marítima");
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
        jPanelInfo.add(jButtonVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 490, 110, -1));

        textMaritimaBuscada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textMaritimaBuscadaActionPerformed(evt);
            }
        });
        jPanelInfo.add(textMaritimaBuscada, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 150, 217, 33));

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

        jButtonAgendaPersonal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButtonAgendaPersonal.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAgendaPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agendar.png"))); // NOI18N
        jButtonAgendaPersonal.setText("Agendar");
        jButtonAgendaPersonal.setBorderPainted(false);
        jButtonAgendaPersonal.setContentAreaFilled(false);
        jButtonAgendaPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgendaPersonalActionPerformed(evt);
            }
        });
        jPanelInfo.add(jButtonAgendaPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 200, 220, -1));

        jLabelWallp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoMaritima.jpg"))); // NOI18N
        jPanelInfo.add(jLabelWallp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, 1110, 870));

        jTabbedPane1.addTab("Información completa de marítima", jPanelInfo);

        jPanelLista.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableMaritimas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableMaritimas);

        jPanelLista.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 237, 600, 490));

        jLabelTitulo1.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabelTitulo1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo1.setText("Lista contactos marítima:");
        jPanelLista.add(jLabelTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 360, 60));

        jLabelWallp1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoMaritima.jpg"))); // NOI18N
        jPanelLista.add(jLabelWallp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -34, 1110, 810));

        jTabbedPane1.addTab("Marítimas y representantes registrados", jPanelLista);

        jPanelListaRequisitos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableMaritimas1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jTableMaritimas1);
        if (jTableMaritimas1.getColumnModel().getColumnCount() > 0) {
            jTableMaritimas1.getColumnModel().getColumn(3).setPreferredWidth(150);
        }

        jPanelListaRequisitos.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 237, 600, 490));

        jLabelTitulo2.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabelTitulo2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo2.setText("Lista requisitos para cada marítima:");
        jPanelListaRequisitos.add(jLabelTitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 490, 60));

        jLabelWallp2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoMaritima.jpg"))); // NOI18N
        jPanelListaRequisitos.add(jLabelWallp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -34, 1110, 810));

        jTabbedPane1.addTab("Requisitos para cada marítima", jPanelListaRequisitos);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textMaritimaBuscadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textMaritimaBuscadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textMaritimaBuscadaActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed

        maritimasService.obtenerDatosDeLaMaritima(textMaritimaBuscada, textID,
            textMail, textEmpleado, textEmpresa, textNumero, textRequisitosAviso, textTipoTransporte);

        String maritimaABuscar = textMaritimaBuscada.getText().trim();

        setTitle("Informacíón completa de " + maritimaABuscar + " - Sistema ComexApp");
        jLabelTitulo.setText("Información completa de " + maritimaABuscar + "");
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed

        int id = Integer.parseInt(textID.getText().trim());
        String empleado = textEmpleado.getText().trim();

        try{
            Boolean aprobarEliminar = maritimasService.eliminarMaritima(empleado, id);

            if(aprobarEliminar.equals(true)){
                JOptionPane.showMessageDialog(null, "Eliminación éxitosa");
                LimpiarCamposRegistroMaritima();
            }

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No pudimos eliminar al importador");
        }
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed

        String mailMod, empleadoMod, empresaMod, numeroContactoMod,
        requisitosAvisoMod, tipoTransporteMod;
        int IDMod;

        String empleado = textMaritimaBuscada.getText().trim();

        try{

            IDMod = Integer.parseInt(textID.getText().trim());
            empleadoMod = textEmpleado.getText().trim();
            empresaMod = textEmpresa.getText().trim();
            mailMod = textMail.getText().trim();
            numeroContactoMod = textNumero.getText().trim();
            requisitosAvisoMod = textRequisitosAviso.getText().trim();
            tipoTransporteMod= textTipoTransporte.getText().trim();

            maritimasService.modificarMaritima(mailMod, empleado, empleadoMod,
                empresaMod, numeroContactoMod, requisitosAvisoMod, tipoTransporteMod);

        }catch(Exception e){
            System.err.println("Fallo al modificar datos " + e);
            JOptionPane.showMessageDialog(null, "Fallo al modificar datos");
        }
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed

        String mail, empleado, empresa, numeroContacto, requisitosAviso, tipoTransporte;
        int ID;

        Boolean recepcion;

        ID = Integer.parseInt(textID.getText().trim());
        mail = textMail.getText().trim();
        empleado = textEmpleado.getText().trim();
        empresa = textEmpresa.getText().trim();
        numeroContacto = textNumero.getText().trim();
        requisitosAviso = textRequisitosAviso.getText().trim();
        tipoTransporte = textTipoTransporte.getText().trim();

        recepcion = maritimasService.registroDeMaritima(ID, mail, empleado,
            empresa, numeroContacto, requisitosAviso, tipoTransporte);

        if(recepcion.equals(true)){
            LimpiarCamposRegistroMaritima();
        }
    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    private void jButtonInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInfoActionPerformed

        InformacionIDMaritimas informacionIDMaritimas = new InformacionIDMaritimas();
        informacionIDMaritimas.setVisible(true);
        
    }//GEN-LAST:event_jButtonInfoActionPerformed

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
       
        PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
        paginaPrincipal.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButtonVolverActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed

        LimpiarCamposRegistroMaritima();
        mostrarTodosLosDatos();
        String sql = "select empresa, requisitos_aviso from maritimas";
        cargarTablaRequisitosMaritimas();
        
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButtonAgendaPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgendaPersonalActionPerformed

        String nombre, empresa, mail, numeroContacto, pais,
        productosAsociados, status, cargo;

        int statusNivel = 0, ID;

        Boolean recepcion;

        ID = Integer.parseInt(textID.getText().trim());
        empresa = textEmpresa.getText().trim();
        mail = textMail.getText().trim();
        nombre = textEmpleado.getText().trim();
        numeroContacto = textNumero.getText().trim();
        pais = "-";
        productosAsociados = "-";
        status = "Activo";
        cargo = "Maritima";

        recepcion = agendaPersonalService.registroContactoAgendaPersonal(ID, nombre,
            empresa, mail, numeroContacto, pais, productosAsociados, status,
            usuario, cargo);

        if(recepcion.equals(true)){
            LimpiarCamposRegistroMaritima();
        }
    }//GEN-LAST:event_jButtonAgendaPersonalActionPerformed

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
            java.util.logging.Logger.getLogger(Maritimas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Maritimas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Maritimas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Maritimas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Maritimas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgendaPersonal;
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
    private javax.swing.JLabel jLabelTransporte;
    private javax.swing.JLabel jLabelWallp;
    private javax.swing.JLabel jLabelWallp1;
    private javax.swing.JLabel jLabelWallp2;
    private javax.swing.JPanel jPanelInfo;
    private javax.swing.JPanel jPanelLista;
    private javax.swing.JPanel jPanelListaRequisitos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableMaritimas;
    private javax.swing.JTable jTableMaritimas1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField textEmpleado;
    private javax.swing.JTextField textEmpresa;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textMail;
    private javax.swing.JTextField textMaritimaBuscada;
    private javax.swing.JTextField textNumero;
    private javax.swing.JTextArea textRequisitosAviso;
    private javax.swing.JTextArea textTipoTransporte;
    // End of variables declaration//GEN-END:variables
}
