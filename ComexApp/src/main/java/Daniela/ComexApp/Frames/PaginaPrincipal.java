package Daniela.ComexApp.Frames;

import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import service.ColorPaginaPrincipalImpl;
import service.FondoPaginaPrincipalImpl;
import service.InicioSesionImp;
import service.MensajesDeObjetivosImpl;
import service.TiemposImpl;
import service.UsuariosImpl;

/**
 *
 * @author Daniela
 */
public class PaginaPrincipal extends javax.swing.JFrame {

       String usuario = "", contraseña = "", rol = "", nombreCompleto = "";
    /**
     * Creates new form PaginaPrincipal
     */
    public PaginaPrincipal() {
        initComponents();
        
        setSize(1050, 850);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        
        usuario = usuariosServicio.getUsuario();
        contraseña = usuariosServicio.getContraseña();
        
        rol = usuariosServicio.obtenerRolUsuario(usuario, contraseña);
        visibilidadAdministrador();
        
        nombreCompleto = usuariosService.obtenerNombreCompleto(usuario);
        jMenuInfo.setText(nombreCompleto + " - " + usuario);
        
        setTitle("Página principal - " + usuario + " - sistema ComexApp");
        
        mensajesDeObjetivosImpl.verificarMensajesSinVer(usuario, rol);
        Date diaActual = Date.valueOf(LocalDate.now());
        Time horaActual = Time.valueOf(LocalTime.now());
        TiemposImpl tiemposImpl = new TiemposImpl();        
        tiemposImpl.verificarCuentasRegresivasCumplidas(diaActual, horaActual);
        
        
        
        if(rol.equals("Administrador")){
            Boolean estanSolicitandoAcceso = usuariosService.solicitarAccesoAlSistema(usuario);
        }
        
        String colorElegido = colorPagina.recuperarColorElegido(usuario);
        if(colorElegido.equals("Defecto")){
            cambiarAColorDefecto();
        } else if (colorElegido.equals("Invertido")){
            cambiarAColorInvertido();
        }
        
        String fondoElegido = fondoPagina.recuperarFondoElegido(usuario);
        
        if(fondoElegido.equals("Defecto")){
            cambiarFondoDefecto();
        } else if (fondoElegido.equals("Fondo")){
            cambiarFondo();
        } else if (fondoElegido.equals("Fondo 3")){
            cambiarFondo3();
        } else if (fondoElegido.equals("Fondo 4")){
            cambiarFondo4();
        }
    }
    
        // icono
    public Image getLogo(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/loguito1.png"));
        return retValue;   
    }

    InicioSesionImp usuariosServicio = new InicioSesionImp();
    InicioSesion inicioSesion = new InicioSesion();
    UsuariosImpl usuariosService = new UsuariosImpl();
    MensajesDeObjetivosImpl mensajesDeObjetivosImpl = new MensajesDeObjetivosImpl();
    ColorPaginaPrincipalImpl colorPagina = new ColorPaginaPrincipalImpl();
    FondoPaginaPrincipalImpl fondoPagina = new FondoPaginaPrincipalImpl();
   
    
    public void visibilidadAdministrador(){
        if(rol.equals("Administrador")){
            jMenuAdministrar.setVisible(true);
        }else{
            jMenuAdministrar.setVisible(false);
        } 
    }
    
    public void cambiarAColorDefecto(){
        
        jPanel3.setBackground(new java.awt.Color(0, 0, 153));
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo1.setForeground(new java.awt.Color(255, 255, 255));
 
        jButtonImportadores.setBackground(new java.awt.Color(255, 255, 255));
        jButtonImportadores.setForeground(new java.awt.Color(0, 0, 153));
        
        jButtonExportadores.setBackground(new java.awt.Color(255, 255, 255));
        jButtonExportadores.setForeground(new java.awt.Color(0, 0, 153));
        
        jButtonDespachantes.setBackground(new java.awt.Color(255, 255, 255));
        jButtonDespachantes.setForeground(new java.awt.Color(0, 0, 153));
        
        jButtonMaritimas.setBackground(new java.awt.Color(255, 255, 255));
        jButtonMaritimas.setForeground(new java.awt.Color(0, 0, 153));
        
        jButtonAereo.setBackground(new java.awt.Color(255, 255, 255));
        jButtonAereo.setForeground(new java.awt.Color(0, 0, 153));
        
        jButtonStock.setBackground(new java.awt.Color(255, 255, 255));
        jButtonStock.setForeground(new java.awt.Color(0, 0, 153));
        
        jButtonOperaciones.setBackground(new java.awt.Color(255, 255, 255));
        jButtonOperaciones.setForeground(new java.awt.Color(0, 0, 153));
        
        jButtonImportadores.setBackground(new java.awt.Color(255, 255, 255));
        jButtonImportadores.setForeground(new java.awt.Color(0, 0, 153));
        
        jButtonCerrarSesion.setBackground(new java.awt.Color(255, 255, 255));
        jButtonCerrarSesion.setForeground(new java.awt.Color(0, 0, 153));
    }
    
    public void cambiarAColorInvertido(){
        
        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setForeground(new java.awt.Color(0, 0, 153));
        jLabelTitulo1.setForeground(new java.awt.Color(0, 0, 153));
        
        jButtonImportadores.setBackground(new java.awt.Color(0, 0, 153));
        jButtonImportadores.setForeground(new java.awt.Color(255, 255, 255));
        
        jButtonExportadores.setBackground(new java.awt.Color(0, 0, 153));
        jButtonExportadores.setForeground(new java.awt.Color(255, 255, 255));
        
        jButtonDespachantes.setBackground(new java.awt.Color(0, 0, 153));
        jButtonDespachantes.setForeground(new java.awt.Color(255, 255, 255));
        
        jButtonMaritimas.setBackground(new java.awt.Color(0, 0, 153));
        jButtonMaritimas.setForeground(new java.awt.Color(255, 255, 255));
        
        jButtonAereo.setBackground(new java.awt.Color(0, 0, 153));
        jButtonAereo.setForeground(new java.awt.Color(255, 255, 255));
        
        jButtonStock.setBackground(new java.awt.Color(0, 0, 153));
        jButtonStock.setForeground(new java.awt.Color(255, 255, 255));
        
        jButtonOperaciones.setBackground(new java.awt.Color(0, 0, 153));
        jButtonOperaciones.setForeground(new java.awt.Color(255, 255, 255));
        
        jButtonImportadores.setBackground(new java.awt.Color(0, 0, 153));
        jButtonImportadores.setForeground(new java.awt.Color(255, 255, 255));
        
        jButtonCerrarSesion.setBackground(new java.awt.Color(0, 0, 153));
        jButtonCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
       
    }
    
    public void cambiarFondoDefecto(){
        jLabelWallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo3.jpg"))); // NOI18N
        getContentPane().add(jLabelWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(-21, -25, 1070, 860));
    }
    
    public void cambiarFondo(){
        jLabelWallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondopantalla.jpg"))); // NOI18N
        getContentPane().add(jLabelWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(-21, -25, 1070, 860));
    }
    
    public void cambiarFondo3(){
        jLabelWallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondopantalla3.jpg"))); // NOI18N
        getContentPane().add(jLabelWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(-21, -50, 1070, 860));
    }
    
    public void cambiarFondo4(){
        jLabelWallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondopantalla4.jpg"))); // NOI18N
        getContentPane().add(jLabelWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(-21, -40, 1070, 860));
    }
    
  
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupColor = new javax.swing.ButtonGroup();
        buttonGroupFondo = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jButtonImportadores = new javax.swing.JButton();
        jButtonExportadores = new javax.swing.JButton();
        jButtonDespachantes = new javax.swing.JButton();
        jButtonMaritimas = new javax.swing.JButton();
        jButtonOperaciones = new javax.swing.JButton();
        jButtonStock = new javax.swing.JButton();
        jButtonAereo = new javax.swing.JButton();
        jButtonCerrarSesion = new javax.swing.JButton();
        jLabelTitulo1 = new javax.swing.JLabel();
        jLabelWallpaper = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuInfo = new javax.swing.JMenu();
        jMenuItemInformacion = new javax.swing.JMenuItem();
        jMenuItemCambioContraseña = new javax.swing.JMenuItem();
        jMenuItemRecupero = new javax.swing.JMenuItem();
        jMenuPreferencias1 = new javax.swing.JMenu();
        jMenuItemAgendar = new javax.swing.JMenuItem();
        jMenuItemEnvio = new javax.swing.JMenuItem();
        jMenuItemNotas = new javax.swing.JMenuItem();
        jMenuItemObjetivos = new javax.swing.JMenuItem();
        jMenuItemTiempos = new javax.swing.JMenuItem();
        jMenuPreferencias = new javax.swing.JMenu();
        jRadioButtonMenuItemDefecto = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItemInvertidos = new javax.swing.JRadioButtonMenuItem();
        jMenuCambiarFondo = new javax.swing.JMenu();
        jRadioButtonMenuItemFondoDef = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItemFondo = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItemFondo3 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItemFondo4 = new javax.swing.JRadioButtonMenuItem();
        jMenuInformes = new javax.swing.JMenu();
        jMenuItemCrearInforme = new javax.swing.JMenuItem();
        jMenuAdministrar = new javax.swing.JMenu();
        jMenuItemDatosUsuarios = new javax.swing.JMenuItem();
        jMenuItemConfiguracion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getLogo());
        setIconImages(getIconImages());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 0, 153));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setText("¡Bienvenido a ComexApp!");
        jPanel3.add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 360, 60));

        jButtonImportadores.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonImportadores.setForeground(new java.awt.Color(0, 0, 153));
        jButtonImportadores.setText("Importadores");
        jButtonImportadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImportadoresActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonImportadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 210, 50));

        jButtonExportadores.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonExportadores.setForeground(new java.awt.Color(0, 0, 153));
        jButtonExportadores.setText("Exportadores");
        jButtonExportadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExportadoresActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonExportadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 210, 50));

        jButtonDespachantes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonDespachantes.setForeground(new java.awt.Color(0, 0, 153));
        jButtonDespachantes.setText("Despachantes");
        jButtonDespachantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDespachantesActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonDespachantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 210, 50));

        jButtonMaritimas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonMaritimas.setForeground(new java.awt.Color(0, 0, 153));
        jButtonMaritimas.setText("Marítimas");
        jButtonMaritimas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMaritimasActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonMaritimas, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 210, 50));

        jButtonOperaciones.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonOperaciones.setForeground(new java.awt.Color(0, 0, 153));
        jButtonOperaciones.setText("Operaciones");
        jButtonOperaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOperacionesActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonOperaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 570, 210, 50));

        jButtonStock.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonStock.setForeground(new java.awt.Color(0, 0, 153));
        jButtonStock.setText("Stock/producción");
        jButtonStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStockActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 500, 210, 50));

        jButtonAereo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonAereo.setForeground(new java.awt.Color(0, 0, 153));
        jButtonAereo.setText("Aereo");
        jButtonAereo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAereoActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonAereo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, 210, 50));

        jButtonCerrarSesion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonCerrarSesion.setForeground(new java.awt.Color(0, 0, 153));
        jButtonCerrarSesion.setText("Cerrar sesión");
        jButtonCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarSesionActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 740, 210, 20));

        jLabelTitulo1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabelTitulo1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo1.setText("Por favor, elige la opción que desees");
        jPanel3.add(jLabelTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 330, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, -10, 390, 820));

        jLabelWallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo3.jpg"))); // NOI18N
        getContentPane().add(jLabelWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -40, 1070, 860));

        jMenuBar1.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuBar1.setMinimumSize(new java.awt.Dimension(343, 50));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(343, 30));

        jMenuInfo.setText("Información del usuario");
        jMenuInfo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jMenuInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenuInfo.setVerifyInputWhenFocusTarget(false);

        jMenuItemInformacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItemInformacion.setText("Información de la cuenta");
        jMenuItemInformacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemInformacionActionPerformed(evt);
            }
        });
        jMenuInfo.add(jMenuItemInformacion);

        jMenuItemCambioContraseña.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItemCambioContraseña.setText("Cambiar contraseña");
        jMenuItemCambioContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCambioContraseñaActionPerformed(evt);
            }
        });
        jMenuInfo.add(jMenuItemCambioContraseña);

        jMenuItemRecupero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItemRecupero.setText("Opciones de recupero de cuenta");
        jMenuItemRecupero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRecuperoActionPerformed(evt);
            }
        });
        jMenuInfo.add(jMenuItemRecupero);

        jMenuBar1.add(jMenuInfo);

        jMenuPreferencias1.setText("Funciones extra");
        jMenuPreferencias1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jMenuItemAgendar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItemAgendar.setText("Agendar contactos personales");
        jMenuItemAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAgendarActionPerformed(evt);
            }
        });
        jMenuPreferencias1.add(jMenuItemAgendar);

        jMenuItemEnvio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItemEnvio.setText("Envio de mails");
        jMenuItemEnvio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEnvioActionPerformed(evt);
            }
        });
        jMenuPreferencias1.add(jMenuItemEnvio);

        jMenuItemNotas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItemNotas.setText("Tomar notas");
        jMenuItemNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNotasActionPerformed(evt);
            }
        });
        jMenuPreferencias1.add(jMenuItemNotas);

        jMenuItemObjetivos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItemObjetivos.setText("Objetivos ");
        jMenuItemObjetivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemObjetivosActionPerformed(evt);
            }
        });
        jMenuPreferencias1.add(jMenuItemObjetivos);

        jMenuItemTiempos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItemTiempos.setText("Medición de tiempos");
        jMenuItemTiempos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTiemposActionPerformed(evt);
            }
        });
        jMenuPreferencias1.add(jMenuItemTiempos);

        jMenuBar1.add(jMenuPreferencias1);

        jMenuPreferencias.setText("Preferencias");
        jMenuPreferencias.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        buttonGroupColor.add(jRadioButtonMenuItemDefecto);
        jRadioButtonMenuItemDefecto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButtonMenuItemDefecto.setText("Colores por defecto");
        jRadioButtonMenuItemDefecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItemDefectoActionPerformed(evt);
            }
        });
        jMenuPreferencias.add(jRadioButtonMenuItemDefecto);

        buttonGroupColor.add(jRadioButtonMenuItemInvertidos);
        jRadioButtonMenuItemInvertidos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButtonMenuItemInvertidos.setText("Colores invertidos");
        jRadioButtonMenuItemInvertidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItemInvertidosActionPerformed(evt);
            }
        });
        jMenuPreferencias.add(jRadioButtonMenuItemInvertidos);

        jMenuCambiarFondo.setText("Cambiar fondo");
        jMenuCambiarFondo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        buttonGroupFondo.add(jRadioButtonMenuItemFondoDef);
        jRadioButtonMenuItemFondoDef.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButtonMenuItemFondoDef.setText("Por defecto");
        jRadioButtonMenuItemFondoDef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItemFondoDefActionPerformed(evt);
            }
        });
        jMenuCambiarFondo.add(jRadioButtonMenuItemFondoDef);

        buttonGroupFondo.add(jRadioButtonMenuItemFondo);
        jRadioButtonMenuItemFondo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButtonMenuItemFondo.setText("Fondo contenedores atardecer ");
        jRadioButtonMenuItemFondo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItemFondoActionPerformed(evt);
            }
        });
        jMenuCambiarFondo.add(jRadioButtonMenuItemFondo);

        buttonGroupFondo.add(jRadioButtonMenuItemFondo3);
        jRadioButtonMenuItemFondo3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButtonMenuItemFondo3.setText("Fondo marítima");
        jRadioButtonMenuItemFondo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItemFondo3ActionPerformed(evt);
            }
        });
        jMenuCambiarFondo.add(jRadioButtonMenuItemFondo3);

        buttonGroupFondo.add(jRadioButtonMenuItemFondo4);
        jRadioButtonMenuItemFondo4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButtonMenuItemFondo4.setText("Fondo barco");
        jRadioButtonMenuItemFondo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItemFondo4ActionPerformed(evt);
            }
        });
        jMenuCambiarFondo.add(jRadioButtonMenuItemFondo4);

        jMenuPreferencias.add(jMenuCambiarFondo);

        jMenuBar1.add(jMenuPreferencias);

        jMenuInformes.setText("Informes y documentos");
        jMenuInformes.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jMenuItemCrearInforme.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItemCrearInforme.setText("Crear informes y reportes");
        jMenuItemCrearInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCrearInformeActionPerformed(evt);
            }
        });
        jMenuInformes.add(jMenuItemCrearInforme);

        jMenuBar1.add(jMenuInformes);

        jMenuAdministrar.setText("Administrar sistema");
        jMenuAdministrar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jMenuItemDatosUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItemDatosUsuarios.setText("Ver datos de usuarios");
        jMenuItemDatosUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDatosUsuariosActionPerformed(evt);
            }
        });
        jMenuAdministrar.add(jMenuItemDatosUsuarios);

        jMenuItemConfiguracion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItemConfiguracion.setText("Establecer configuración del sistema");
        jMenuItemConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConfiguracionActionPerformed(evt);
            }
        });
        jMenuAdministrar.add(jMenuItemConfiguracion);

        jMenuBar1.add(jMenuAdministrar);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemInformacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemInformacionActionPerformed
       
        InformacionUsuario informacionUsuario = new InformacionUsuario();
        informacionUsuario.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jMenuItemInformacionActionPerformed

    private void jMenuItemCambioContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCambioContraseñaActionPerformed
     
        CambioContraseña cambioContraseña = new CambioContraseña();
        cambioContraseña.setVisible(true);
              
    }//GEN-LAST:event_jMenuItemCambioContraseñaActionPerformed

    private void jButtonCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarSesionActionPerformed
        
        inicioSesion.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButtonCerrarSesionActionPerformed

    private void jMenuItemDatosUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDatosUsuariosActionPerformed
       
        AdministrarUsuarios administrarUsuarios = new AdministrarUsuarios();
        administrarUsuarios.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jMenuItemDatosUsuariosActionPerformed

    private void jMenuItemAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAgendarActionPerformed
      
        AgendaContactosPersonal agendaContactosPersonal = new AgendaContactosPersonal();
        agendaContactosPersonal.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jMenuItemAgendarActionPerformed

    private void jMenuItemNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNotasActionPerformed
        
        StickyNotes stickyNotes = new StickyNotes();
        stickyNotes.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jMenuItemNotasActionPerformed

    private void jMenuItemRecuperoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRecuperoActionPerformed
        
        PreguntasDeSeguridad preguntasDeSeguridad = new PreguntasDeSeguridad();
        preguntasDeSeguridad.setVisible(true);
        this.dispose();
                
    }//GEN-LAST:event_jMenuItemRecuperoActionPerformed

    private void jButtonImportadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImportadoresActionPerformed
        
        Importadores importadores = new Importadores();
        importadores.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButtonImportadoresActionPerformed

    private void jButtonExportadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExportadoresActionPerformed
       
        Exportadores exportadores = new Exportadores();
        exportadores.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButtonExportadoresActionPerformed

    private void jButtonDespachantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDespachantesActionPerformed
      
        Despachantes despachantes = new Despachantes();
        despachantes.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButtonDespachantesActionPerformed

    private void jButtonMaritimasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMaritimasActionPerformed
       
        Maritimas maritimas = new Maritimas();
        maritimas.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButtonMaritimasActionPerformed

    private void jButtonAereoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAereoActionPerformed
        
        Aereo aereo = new Aereo();
        aereo.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButtonAereoActionPerformed

    private void jButtonStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStockActionPerformed
        
        StockProduccion stockprod = new StockProduccion();
        stockprod.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButtonStockActionPerformed

    private void jButtonOperacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOperacionesActionPerformed
       
       Operaciones operaciones = new Operaciones();
       operaciones.setVisible(true);
       this.dispose();
        
    }//GEN-LAST:event_jButtonOperacionesActionPerformed

    private void jMenuItemCrearInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCrearInformeActionPerformed
       
        Informes informes = new Informes();
        informes.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jMenuItemCrearInformeActionPerformed

    private void jMenuItemObjetivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemObjetivosActionPerformed
      
        Objetivos objetivos = new Objetivos();
        objetivos.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jMenuItemObjetivosActionPerformed

    private void jRadioButtonMenuItemDefectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItemDefectoActionPerformed
        
        cambiarAColorDefecto();
        colorPagina.cambiarAColorDefecto(usuario);

    }//GEN-LAST:event_jRadioButtonMenuItemDefectoActionPerformed

    private void jRadioButtonMenuItemInvertidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItemInvertidosActionPerformed
    
        cambiarAColorInvertido();
        colorPagina.cambiarAColorInvertido(usuario);
    
    }//GEN-LAST:event_jRadioButtonMenuItemInvertidosActionPerformed

    private void jRadioButtonMenuItemFondoDefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItemFondoDefActionPerformed
       
        cambiarFondoDefecto();
        fondoPagina.cambiarAFondoDefecto(usuario);
        
    }//GEN-LAST:event_jRadioButtonMenuItemFondoDefActionPerformed

    private void jRadioButtonMenuItemFondoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItemFondoActionPerformed
        
        cambiarFondo();
        fondoPagina.cambiarAFondo(usuario);
        
    }//GEN-LAST:event_jRadioButtonMenuItemFondoActionPerformed

    private void jRadioButtonMenuItemFondo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItemFondo3ActionPerformed
        
        cambiarFondo3();
        fondoPagina.cambiarAFondo3(usuario);
        
    }//GEN-LAST:event_jRadioButtonMenuItemFondo3ActionPerformed

    private void jRadioButtonMenuItemFondo4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItemFondo4ActionPerformed
       
        cambiarFondo4();
        fondoPagina.cambiarAFondo4(usuario);
        
    }//GEN-LAST:event_jRadioButtonMenuItemFondo4ActionPerformed

    private void jMenuItemTiemposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTiemposActionPerformed
        
        Tiempos tiempos = new Tiempos();
        tiempos.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jMenuItemTiemposActionPerformed

    private void jMenuItemEnvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEnvioActionPerformed
        
        EnvioMail envioMail = new EnvioMail();
        envioMail.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jMenuItemEnvioActionPerformed

    private void jMenuItemConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConfiguracionActionPerformed

        ConfiguracionSistema config = new ConfiguracionSistema();
        config.setVisible(true);
        
    }//GEN-LAST:event_jMenuItemConfiguracionActionPerformed

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
            java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaginaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupColor;
    private javax.swing.ButtonGroup buttonGroupFondo;
    private javax.swing.JButton jButtonAereo;
    private javax.swing.JButton jButtonCerrarSesion;
    private javax.swing.JButton jButtonDespachantes;
    private javax.swing.JButton jButtonExportadores;
    private javax.swing.JButton jButtonImportadores;
    private javax.swing.JButton jButtonMaritimas;
    private javax.swing.JButton jButtonOperaciones;
    private javax.swing.JButton jButtonStock;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelTitulo1;
    private javax.swing.JLabel jLabelWallpaper;
    private javax.swing.JMenu jMenuAdministrar;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCambiarFondo;
    private javax.swing.JMenu jMenuInfo;
    private javax.swing.JMenu jMenuInformes;
    private javax.swing.JMenuItem jMenuItemAgendar;
    private javax.swing.JMenuItem jMenuItemCambioContraseña;
    private javax.swing.JMenuItem jMenuItemConfiguracion;
    private javax.swing.JMenuItem jMenuItemCrearInforme;
    private javax.swing.JMenuItem jMenuItemDatosUsuarios;
    private javax.swing.JMenuItem jMenuItemEnvio;
    private javax.swing.JMenuItem jMenuItemInformacion;
    private javax.swing.JMenuItem jMenuItemNotas;
    private javax.swing.JMenuItem jMenuItemObjetivos;
    private javax.swing.JMenuItem jMenuItemRecupero;
    private javax.swing.JMenuItem jMenuItemTiempos;
    private javax.swing.JMenu jMenuPreferencias;
    private javax.swing.JMenu jMenuPreferencias1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItemDefecto;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItemFondo;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItemFondo3;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItemFondo4;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItemFondoDef;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItemInvertidos;
    // End of variables declaration//GEN-END:variables
}
