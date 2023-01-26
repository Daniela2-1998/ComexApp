package Daniela.ComexApp.Frames;

import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Date;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import service.InformesPersonalizadosImpl;

/**
 *
 * @author Daniela
 */
public class InformesPersonalizados extends javax.swing.JFrame {

     String usuario = "", rol = "", nombreCompleto = "";
    /**
     * Creates new form EstadisticasGeneralesOperaciones
     */
    public InformesPersonalizados() {
        initComponents();
        
        setSize(950, 770);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        
        PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
        
        usuario = paginaPrincipal.usuario;
        nombreCompleto = paginaPrincipal.nombreCompleto;
        
        setTitle("Informes personalizados - " + usuario + " - sistema ComexApp");  
    }

    // icono
    public Image getLogo(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/loguito1.png"));
        return retValue;   
    }

    
    InformesPersonalizadosImpl informesPersonalizadosService = new InformesPersonalizadosImpl();

    public String obtencionMes(){
     
        String mes = null;
        int mesNivel;
        
        mesNivel = cmbMes.getSelectedIndex() + 1;
        
        if(mesNivel == 1){
            mes = "Enero";
        } else if(mesNivel == 2){
            mes = "Febrero";
        } else if(mesNivel == 3){
            mes = "Marzo";
        } else if(mesNivel == 4){
            mes = "Abril";
        } else if(mesNivel == 5){
            mes = "Mayo";
        } else if(mesNivel == 6){
            mes = "Junio";
        } else if(mesNivel == 7){
            mes = "Julio";
        } else if(mesNivel == 8){
            mes = "Agosto";
        } else if(mesNivel == 9){
            mes = "Septiembre";
        } else if(mesNivel == 10){
            mes = "Octubre";
        } else if(mesNivel == 11){
            mes = "Noviembre";
        } else if(mesNivel == 12){
            mes = "Diciembre";
        }
        
        return mes;
    }

    public int cantidadDiasMes(String mes){
        
        int diasMes = 0;
        
        if(mes.equals("Enero")){
            diasMes = 31;
        } else if(mes.equals("Febrero")){
            diasMes = 28;
        } else if(mes.equals("Marzo")){
            diasMes = 31;
        } else if(mes.equals("Abril")){
            diasMes = 30;
        } else if(mes.equals("Mayo")){
            diasMes = 31;
        } else if(mes.equals("Junio")){
            diasMes = 30;
        } else if(mes.equals("Julio")){
            diasMes = 31;
        } else if(mes.equals("Agosto")){
            diasMes = 31;
        } else if(mes.equals("Septiembre")){
            diasMes = 30;
        } else if(mes.equals("Octubre")){
            diasMes = 31;
        } else if(mes.equals("Noviembre")){
            diasMes = 30;
        } else if(mes.equals("Diciembre")){
            diasMes = 31;
        }
        
        return diasMes;
    }
    
    
    public int obtencionDelDia(String mes){
        
       int dia = 0;
       int diaNivel;
       
       diaNivel = cmbDia.getSelectedIndex() + 1;
       
       if(diaNivel == 1){
           dia = 01;
       } else if(diaNivel == 2){
           dia = 02;
       } else if(diaNivel == 3){
           dia = 03;
       } else if(diaNivel == 4){
           dia = 04;
       } else if(diaNivel == 5){
           dia = 05;
       } else if(diaNivel == 6){
           dia = 06;
       } else if(diaNivel == 7){
           dia = 07;
       } else if(diaNivel == 8){
           dia = 8;
       } else if(diaNivel == 9){
           dia = 9;
       } else if(diaNivel == 10){
           dia = 10;
       } else if(diaNivel == 11){
           dia = 11;
       } else if(diaNivel == 12){
           dia = 12;
       } else if(diaNivel == 13){
           dia = 13;
       } else if(diaNivel == 14){
           dia = 14;
       } else if(diaNivel == 15){
           dia = 15;
       } else if(diaNivel == 16){
           dia = 16;
       } else if(diaNivel == 17){
           dia = 17;
       } else if(diaNivel == 18){
           dia = 18;
       } else if(diaNivel == 19){
           dia = 19;
       } else if(diaNivel == 20){
           dia = 20;
       } else if(diaNivel == 21){
           dia = 21;
       }  else if(diaNivel == 22){
           dia = 22;
       } else if(diaNivel == 23){
           dia = 23;
       } else if(diaNivel == 24){
           dia = 24;
       } else if(diaNivel == 25){
           dia = 25;
       } else if(diaNivel == 26){
           dia = 26;
       } else if(diaNivel == 27){
           dia = 27;
       } else if(diaNivel == 28){
           dia = 28;
       } else if(diaNivel == 29){
           dia = 29;
       } else if(diaNivel == 30){
           dia = 30;
       } else if(diaNivel == 31){
           dia = 31;
       }

       return dia;
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
        jButtonVolver = new javax.swing.JButton();
        jButtonPDF = new javax.swing.JButton();
        jLabelTitulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabelTitulos = new javax.swing.JLabel();
        textTitulo = new javax.swing.JTextField();
        jLabelNumero = new javax.swing.JLabel();
        textNumero = new javax.swing.JTextField();
        jLabelParrafos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textParrafo = new javax.swing.JTextArea();
        jScrollBar1 = new javax.swing.JScrollBar();
        jButtonTitulo = new javax.swing.JButton();
        textTituloEspacio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButtonParrafo = new javax.swing.JButton();
        textParrafoEspacio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButtonCrear = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        jButtonInfo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        textTitulo1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textTitulo2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        textTitulo3 = new javax.swing.JTextField();
        textTitulo4 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        textTitulo5 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        textTitulo6 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        textTitulo7 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        textTitulo8 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        textTitulo9 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        textTitulo10 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanelBusqueda = new javax.swing.JPanel();
        jButtonBuscar = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        textBusqueda = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jButtonBuscarN = new javax.swing.JButton();
        textBusquedaN = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        textAño = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        cmbMes = new javax.swing.JComboBox<>();
        cmbDia = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getLogo());
        setIconImages(getIconImages());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonVolver.setBackground(new java.awt.Color(102, 102, 102));
        jButtonVolver.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonVolver.setForeground(new java.awt.Color(255, 255, 255));
        jButtonVolver.setText("Volver");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 640, 94, -1));

        jButtonPDF.setBackground(new java.awt.Color(102, 102, 102));
        jButtonPDF.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonPDF.setForeground(new java.awt.Color(255, 255, 255));
        jButtonPDF.setText("Descargar PDF");
        jButtonPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPDFActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 590, 160, -1));

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setText("Creación de informes");
        jPanel1.add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, -1, -1));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitulos.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelTitulos.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulos.setText("Titulos:");
        jPanel2.add(jLabelTitulos, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        textTitulo.setBackground(new java.awt.Color(102, 102, 102));
        textTitulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        textTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(textTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 120, 30));

        jLabelNumero.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelNumero.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNumero.setText("N° informe:");
        jPanel2.add(jLabelNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, -1, -1));

        textNumero.setBackground(new java.awt.Color(102, 102, 102));
        textNumero.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        textNumero.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(textNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 120, 30));

        jLabelParrafos.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelParrafos.setForeground(new java.awt.Color(255, 255, 255));
        jLabelParrafos.setText("Párrafos:");
        jPanel2.add(jLabelParrafos, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, -1, -1));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setHorizontalScrollBar(null);
        jScrollPane1.setVerticalScrollBar(jScrollBar1);

        textParrafo.setBackground(new java.awt.Color(102, 102, 102));
        textParrafo.setColumns(5);
        textParrafo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        textParrafo.setForeground(new java.awt.Color(255, 255, 255));
        textParrafo.setLineWrap(true);
        textParrafo.setRows(5);
        textParrafo.setTabSize(5);
        textParrafo.setWrapStyleWord(true);
        jScrollPane1.setViewportView(textParrafo);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 390, 250));

        jScrollBar1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.add(jScrollBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, -1, 250));

        jButtonTitulo.setBackground(new java.awt.Color(102, 102, 102));
        jButtonTitulo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jButtonTitulo.setText("Añadir");
        jButtonTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTituloActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, -1, 30));

        textTituloEspacio.setBackground(new java.awt.Color(102, 102, 102));
        textTituloEspacio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textTituloEspacio.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(textTituloEspacio, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 30, 40, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Espacio:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, -1, 20));

        jButtonParrafo.setBackground(new java.awt.Color(102, 102, 102));
        jButtonParrafo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonParrafo.setForeground(new java.awt.Color(255, 255, 255));
        jButtonParrafo.setText("Añadir");
        jButtonParrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonParrafoActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonParrafo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, -1, -1));

        textParrafoEspacio.setBackground(new java.awt.Color(102, 102, 102));
        textParrafoEspacio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textParrafoEspacio.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(textParrafoEspacio, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 40, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Espacio:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, 20));

        jButtonCrear.setBackground(new java.awt.Color(102, 102, 102));
        jButtonCrear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonCrear.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCrear.setText("Crear informe base");
        jButtonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 420, -1, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Nombre informe:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, -1, -1));

        textNombre.setBackground(new java.awt.Color(102, 102, 102));
        textNombre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textNombre.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(textNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, 130, -1));

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
        jPanel2.add(jButtonInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 20, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cuadro.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 510, 490));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 530, 500));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textTitulo1.setEditable(false);
        textTitulo1.setBackground(new java.awt.Color(102, 102, 102));
        textTitulo1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textTitulo1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(textTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 70, 80, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("1");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 20, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("2");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 20, -1));

        textTitulo2.setEditable(false);
        textTitulo2.setBackground(new java.awt.Color(102, 102, 102));
        textTitulo2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textTitulo2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(textTitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 110, 80, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("3");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 20, -1));

        textTitulo3.setEditable(false);
        textTitulo3.setBackground(new java.awt.Color(102, 102, 102));
        textTitulo3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textTitulo3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(textTitulo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 150, 80, -1));

        textTitulo4.setEditable(false);
        textTitulo4.setBackground(new java.awt.Color(102, 102, 102));
        textTitulo4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textTitulo4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(textTitulo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 190, 80, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("4");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 20, -1));

        textTitulo5.setEditable(false);
        textTitulo5.setBackground(new java.awt.Color(102, 102, 102));
        textTitulo5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textTitulo5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(textTitulo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 230, 80, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("5");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 20, -1));

        textTitulo6.setEditable(false);
        textTitulo6.setBackground(new java.awt.Color(102, 102, 102));
        textTitulo6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textTitulo6.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(textTitulo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 270, 80, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("6");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 20, -1));

        textTitulo7.setEditable(false);
        textTitulo7.setBackground(new java.awt.Color(102, 102, 102));
        textTitulo7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textTitulo7.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(textTitulo7, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 310, 80, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("7");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 20, -1));

        textTitulo8.setEditable(false);
        textTitulo8.setBackground(new java.awt.Color(102, 102, 102));
        textTitulo8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textTitulo8.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(textTitulo8, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 350, 80, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("8");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 20, -1));

        textTitulo9.setEditable(false);
        textTitulo9.setBackground(new java.awt.Color(102, 102, 102));
        textTitulo9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textTitulo9.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(textTitulo9, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 390, 80, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("9");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 20, -1));

        textTitulo10.setEditable(false);
        textTitulo10.setBackground(new java.awt.Color(102, 102, 102));
        textTitulo10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textTitulo10.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(textTitulo10, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 430, 80, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("10");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 20, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Espacios del informe");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("5 titulos y 5 párrafos");
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/opcionescuadro.png"))); // NOI18N
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 210, 480));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 80, 230, 510));

        jPanelBusqueda.setBackground(new java.awt.Color(51, 51, 51));
        jPanelBusqueda.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonBuscar.setBackground(new java.awt.Color(102, 102, 102));
        jButtonBuscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        jPanelBusqueda.add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Por nombre informe:");
        jPanelBusqueda.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        textBusqueda.setBackground(new java.awt.Color(102, 102, 102));
        textBusqueda.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textBusqueda.setForeground(new java.awt.Color(255, 255, 255));
        jPanelBusqueda.add(textBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 110, 25));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Por N°:");
        jPanelBusqueda.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, -1));

        jButtonBuscarN.setBackground(new java.awt.Color(102, 102, 102));
        jButtonBuscarN.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonBuscarN.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBuscarN.setText("N°");
        jButtonBuscarN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarNActionPerformed(evt);
            }
        });
        jPanelBusqueda.add(jButtonBuscarN, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 50, 25));

        textBusquedaN.setBackground(new java.awt.Color(102, 102, 102));
        textBusquedaN.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textBusquedaN.setForeground(new java.awt.Color(255, 255, 255));
        jPanelBusqueda.add(textBusquedaN, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 70, 25));

        jLabel17.setBackground(new java.awt.Color(51, 51, 51));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/busquedacuadro.png"))); // NOI18N
        jPanelBusqueda.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 480, 110));

        jPanel1.add(jPanelBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 580, 480, 110));

        textAño.setBackground(new java.awt.Color(102, 102, 102));
        textAño.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textAño.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(textAño, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 50, 40, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Dia:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, -1, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Mes:");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 30, -1, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Año:");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 30, -1, -1));

        cmbMes.setBackground(new java.awt.Color(102, 102, 102));
        cmbMes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmbMes.setForeground(new java.awt.Color(255, 255, 255));
        cmbMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        jPanel1.add(cmbMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 50, 90, -1));

        cmbDia.setBackground(new java.awt.Color(102, 102, 102));
        cmbDia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmbDia.setForeground(new java.awt.Color(255, 255, 255));
        cmbDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jPanel1.add(cmbDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 50, 50, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 1500, 880));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed

        Informes informes = new Informes();
        informes.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButtonVolverActionPerformed

    private void jButtonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearActionPerformed
        
        int id = Integer.parseInt(textNumero.getText().trim());
        
        String nombre, titulo1, parrafo1;
        
        nombre = textNombre.getText().trim();
        titulo1 = textTitulo.getText().trim();
        parrafo1 = textParrafo.getText().trim();
        
        informesPersonalizadosService.crearInformePersonalizado(id, usuario, nombre, titulo1, parrafo1);
        
        int ID = Integer.parseInt(textNumero.getText().trim());
        informesPersonalizadosService.existeTituloYParrafo1(ID, textTitulo1, textTitulo6);
        informesPersonalizadosService.existeTituloYParrafo2(ID, textTitulo2, textTitulo7);
        informesPersonalizadosService.existeTituloYParrafo3(ID, textTitulo3, textTitulo8);
        informesPersonalizadosService.existeTituloYParrafo4(ID, textTitulo4, textTitulo9);
        informesPersonalizadosService.existeTituloYParrafo5(ID, textTitulo5, textTitulo10);
        
    }//GEN-LAST:event_jButtonCrearActionPerformed

    private void jButtonTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTituloActionPerformed

        int id = Integer.parseInt(textNumero.getText().trim());
        String titulo = textTitulo.getText().trim();
        
        String ubicacion = textTituloEspacio.getText().trim();
        
        if(ubicacion.equals("0") || ubicacion.equals("1")){
            JOptionPane.showMessageDialog(null, "Opción inválida");
        } else if(ubicacion.equals("2")){
            informesPersonalizadosService.agregarTitulo2(id, titulo);
        } else if(ubicacion.equals("3")){
            informesPersonalizadosService.agregarTitulo3(id, titulo);
        } else if(ubicacion.equals("4")){
            informesPersonalizadosService.agregarTitulo4(id, titulo);
        } else if(ubicacion.equals("5")){
            informesPersonalizadosService.agregarTitulo5(id, titulo);
        } else {
            JOptionPane.showMessageDialog(null, "Coloca una ubicación válida "
                    + "entre 2 y 5.");
        }
        
        
    }//GEN-LAST:event_jButtonTituloActionPerformed

    private void jButtonInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInfoActionPerformed

        InformacionIDInformePersonalizado informacionIDInformePersonalizado = 
                new InformacionIDInformePersonalizado();
        informacionIDInformePersonalizado.setVisible(true);
        
    }//GEN-LAST:event_jButtonInfoActionPerformed

    private void jButtonBuscarNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarNActionPerformed
       
        int ID = Integer.parseInt(textBusquedaN.getText().trim());
        
        informesPersonalizadosService.busquedaPorID(ID, usuario, textNumero, 
                textNombre, textTitulo, textParrafo);
        
        informesPersonalizadosService.existeTituloYParrafo1(ID, textTitulo1, textTitulo6);
        informesPersonalizadosService.existeTituloYParrafo2(ID, textTitulo2, textTitulo7);
        informesPersonalizadosService.existeTituloYParrafo3(ID, textTitulo3, textTitulo8);
        informesPersonalizadosService.existeTituloYParrafo4(ID, textTitulo4, textTitulo9);
        informesPersonalizadosService.existeTituloYParrafo5(ID, textTitulo5, textTitulo10);
        
    }//GEN-LAST:event_jButtonBuscarNActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        
        String nombre = textBusqueda.getText().trim();
        
        informesPersonalizadosService.busquedaPorNombre(nombre, usuario, 
                textNumero, textNombre, textTitulo, textParrafo);
        
        int ID = Integer.parseInt(textNumero.getText().trim());
        informesPersonalizadosService.existeTituloYParrafo1(ID, textTitulo1, textTitulo6);
        informesPersonalizadosService.existeTituloYParrafo2(ID, textTitulo2, textTitulo7);
        informesPersonalizadosService.existeTituloYParrafo3(ID, textTitulo3, textTitulo8);
        informesPersonalizadosService.existeTituloYParrafo4(ID, textTitulo4, textTitulo9);
        informesPersonalizadosService.existeTituloYParrafo5(ID, textTitulo5, textTitulo10);

    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonParrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonParrafoActionPerformed
       
        int id = Integer.parseInt(textNumero.getText().trim());
        String parrafo = textParrafo.getText().trim();
        
        String ubicacion = textParrafoEspacio.getText().trim();
        
        if(ubicacion.equals("0") || ubicacion.equals("1")){
            JOptionPane.showMessageDialog(null, "Opción inválida");
        } else if(ubicacion.equals("2")){
            informesPersonalizadosService.agregarParrafo2(id, parrafo);
        } else if(ubicacion.equals("3")){
            informesPersonalizadosService.agregarParrafo3(id, parrafo);
        } else if(ubicacion.equals("4")){
            informesPersonalizadosService.agregarParrafo4(id, parrafo);
        } else if(ubicacion.equals("5")){
            informesPersonalizadosService.agregarParrafo5(id, parrafo);
        } else {
            JOptionPane.showMessageDialog(null, "Coloca una ubicación válida "
                    + "entre 2 y 5.");
        }
        
    }//GEN-LAST:event_jButtonParrafoActionPerformed

    private void jButtonPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPDFActionPerformed
        
        int id = Integer.parseInt(textNumero.getText().trim());
        String nombre = textNombre.getText().trim();
        
        int dia, diasMes;
        String mes;
        int diaNivel, mesNivel;
      
        mes = obtencionMes();
        dia = obtencionDelDia(mes);
        diasMes = cantidadDiasMes(mes);
        String año = textAño.getText().trim();
        
        if(dia > diasMes){
            JOptionPane.showMessageDialog(null, "Ingresa un dia válido acorde al mes.");
        } else if(dia <= diasMes){
            String diaElegido = String.valueOf(dia);
            informesPersonalizadosService.pdfInformePersonalizado(usuario, id, nombre,
                diaElegido, mes, año);
        }
        
    }//GEN-LAST:event_jButtonPDFActionPerformed

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
            java.util.logging.Logger.getLogger(InformesPersonalizados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformesPersonalizados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformesPersonalizados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformesPersonalizados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new InformesPersonalizados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbDia;
    private javax.swing.JComboBox<String> cmbMes;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonBuscarN;
    private javax.swing.JButton jButtonCrear;
    private javax.swing.JButton jButtonInfo;
    private javax.swing.JButton jButtonPDF;
    private javax.swing.JButton jButtonParrafo;
    private javax.swing.JButton jButtonTitulo;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JLabel jLabelParrafos;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelTitulos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelBusqueda;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField textAño;
    private javax.swing.JTextField textBusqueda;
    private javax.swing.JTextField textBusquedaN;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textNumero;
    private javax.swing.JTextArea textParrafo;
    private javax.swing.JTextField textParrafoEspacio;
    private javax.swing.JTextField textTitulo;
    private javax.swing.JTextField textTitulo1;
    private javax.swing.JTextField textTitulo10;
    private javax.swing.JTextField textTitulo2;
    private javax.swing.JTextField textTitulo3;
    private javax.swing.JTextField textTitulo4;
    private javax.swing.JTextField textTitulo5;
    private javax.swing.JTextField textTitulo6;
    private javax.swing.JTextField textTitulo7;
    private javax.swing.JTextField textTitulo8;
    private javax.swing.JTextField textTitulo9;
    private javax.swing.JTextField textTituloEspacio;
    // End of variables declaration//GEN-END:variables


}
