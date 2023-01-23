package Daniela.ComexApp.Frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import static org.jdesktop.swingx.graphics.BlendComposite.Color;
import service.NotasService;
import service.UsuariosService;

/**
 *
 * @author Daniela
 */
public class StickyNotes extends javax.swing.JFrame {
 
    public String usuario = "", nombreCompleto = "", rol = "";
   
    
    /**
     * Creates new form StickyNotes
     */
    public StickyNotes() {
        initComponents();
        
        setSize(1050, 800);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        
        PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
        UsuariosService usuariosService = new UsuariosService();
        
        usuario = paginaPrincipal.usuario;
        nombreCompleto = usuariosService.obtenerNombreCompleto(usuario);
        rol = paginaPrincipal.rol;
        
        jMenuNombre.setText(usuario + " - " + nombreCompleto);
        setTitle("Sticky notes - " + usuario + " - sistema ComexApp");
        
        notasService.obtenerNota1(usuario, textID, textNombre, textContenido);
        notasService.obtenerNota2(usuario, textID1, textNombre1, textContenido2, Nota2, jButtonCrear1, jButtonModificar1);
        notasService.obtenerNota3(usuario, textID2, textNombre2, textContenido3, Nota3, jButtonCrear2, jButtonModificar2);
        notasService.obtenerNota4(usuario, textID3, textNombre3, textContenido4, Nota4, jButtonCrear3, jButtonModificar3);
        notasService.obtenerNota5(usuario, textID4, textNombre4, textContenido5, Nota5, jButtonCrear4, jButtonModificar4);
        notasService.obtenerNota6(usuario, textID5, textNombre5, textContenido6, Nota6, jButtonCrear5, jButtonModificar5);
        notasService.obtenerNota7(usuario, textID6, textNombre6, textContenido7, Nota7, jButtonCrear6, jButtonModificar6);
        notasService.obtenerNota8(usuario, textID7, textNombre7, textContenido8, Nota8, jButtonCrear7, jButtonModificar7);
        
        String colorRecuperado1 = notasService.obtencionColorNota(usuario, "Nota 1");
        cambioDeColor(colorRecuperado1, textContenido, textID, textNombre, 
                jButtonCrear,  jButtonModificar, Nota1);
        
        String letraRecuperada1 = notasService.obtencionFuenteNota(usuario, "Nota 1");
        Font fuenteRecuperada1 = cambioFuente(letraRecuperada1);
        textContenido.setFont(fuenteRecuperada1);
        
        String colorRecuperado2 = notasService.obtencionColorNota(usuario, "Nota 2");
        cambioDeColor(colorRecuperado2, textContenido2, textID1, textNombre1, 
                jButtonCrear1,  jButtonModificar1, Nota2);
        
        String letraRecuperada2 = notasService.obtencionFuenteNota(usuario, "Nota 2");
        Font fuenteRecuperada2 = cambioFuente(letraRecuperada2);
        textContenido2.setFont(fuenteRecuperada2);
        
        String colorRecuperado3 = notasService.obtencionColorNota(usuario, "Nota 3");
        cambioDeColor(colorRecuperado3, textContenido3, textID2, textNombre2, 
                jButtonCrear2,  jButtonModificar2, Nota3);
        
        String letraRecuperada3 = notasService.obtencionFuenteNota(usuario, "Nota 3");
        Font fuenteRecuperada3 = cambioFuente(letraRecuperada3);
        textContenido3.setFont(fuenteRecuperada3);
        
        String colorRecuperado4 = notasService.obtencionColorNota(usuario, "Nota 4");
        cambioDeColor(colorRecuperado4, textContenido4, textID3, textNombre3, 
                jButtonCrear3,  jButtonModificar3, Nota4);
        
        String letraRecuperada4 = notasService.obtencionFuenteNota(usuario, "Nota 4");
        Font fuenteRecuperada4 = cambioFuente(letraRecuperada4);
        textContenido4.setFont(fuenteRecuperada4);
        
        String colorRecuperado5 = notasService.obtencionColorNota(usuario, "Nota 5");
        cambioDeColor(colorRecuperado5, textContenido5, textID4, textNombre4, 
                jButtonCrear4,  jButtonModificar4, Nota5);
        
        String letraRecuperada5 = notasService.obtencionFuenteNota(usuario, "Nota 5");
        Font fuenteRecuperada5 = cambioFuente(letraRecuperada5);
        textContenido5.setFont(fuenteRecuperada5);
        
        String colorRecuperado6 = notasService.obtencionColorNota(usuario, "Nota 6");
        cambioDeColor(colorRecuperado6, textContenido6, textID5, textNombre5, 
                jButtonCrear5,  jButtonModificar5, Nota6);
        
        String letraRecuperada6 = notasService.obtencionFuenteNota(usuario, "Nota 6");
        Font fuenteRecuperada6 = cambioFuente(letraRecuperada6);
        textContenido6.setFont(fuenteRecuperada6);
        
        String colorRecuperado7 = notasService.obtencionColorNota(usuario, "Nota 7");
        cambioDeColor(colorRecuperado7, textContenido7, textID6, textNombre6, 
                jButtonCrear6,  jButtonModificar6, Nota7);
        
        String letraRecuperada7 = notasService.obtencionFuenteNota(usuario, "Nota 7");
        Font fuenteRecuperada7 = cambioFuente(letraRecuperada7);
        textContenido7.setFont(fuenteRecuperada7);
        
        String colorRecuperado8 = notasService.obtencionColorNota(usuario, "Nota 8");
        cambioDeColor(colorRecuperado8, textContenido8, textID7, textNombre7, 
                jButtonCrear7,  jButtonModificar7, Nota8);
        
        String letraRecuperada8 = notasService.obtencionFuenteNota(usuario, "Nota 8");
        Font fuenteRecuperada8 = cambioFuente(letraRecuperada8);
        textContenido8.setFont(fuenteRecuperada8);
        
        
        jRadioButton1.setSelected(true);
        jPanelConfiguracion.setVisible(false);    
        jButtonBuscar.setVisible(false);
        textBusqueda.setVisible(false);
        jLabel1.setVisible(false);
        
        jCheckBoxActivo.setSelected(true);
        if(jCheckBoxActivo.equals(false)){
            String ubicacion = obtenerNotaUbicacion();
            JTextField cajaNombre = cajaNombreSegunUbi(ubicacion);
            String titulo = cajaNombre.getText().trim();
            notasService.notaInactiva(titulo, ubicacion, usuario);
        }
    }
    
    // icono
    public Image getLogo(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/loguito1.png"));
        return retValue;   
    }

    NotasService notasService = new NotasService(); 
 
    
    public void LimpiarCampos(JTextPane textContenido, JTextField textID, 
            JTextField textNombre, JButton jButtonCrear, JButton jButtonModificar, 
            JPanel Nota){
        
        textContenido.setText("");
        textID.setText("");
        textNombre.setText("");
    }
    
    public String obtenerNotaUbicacion(){
        
        String ubicacion = null;
        int ubicacionNumero; 
    
        ubicacionNumero = cmbNota.getSelectedIndex() + 1;
   
        if(ubicacionNumero == 1){
           ubicacion = "Nota 1";
        } else if (ubicacionNumero == 2){
           ubicacion = "Nota 2";
        } else if (ubicacionNumero == 3){
           ubicacion = "Nota 3";
        } else if (ubicacionNumero == 4){
           ubicacion = "Nota 4";
        } else if (ubicacionNumero == 5){
           ubicacion = "Nota 5";
        } else if (ubicacionNumero == 6){
           ubicacion = "Nota 6";
        } else if (ubicacionNumero == 7){
           ubicacion = "Nota 7";
        } else if (ubicacionNumero == 8){
           ubicacion = "Nota 8";
        }
        return ubicacion;
    }

    
    
    public String eleccionDeColor(){
        
        String opcionElegidaDeColor = null;
        
        if(jRadioButton1.isSelected()){
            opcionElegidaDeColor = "Amarillo";
        } else if (jRadioButton2.isSelected()){
            opcionElegidaDeColor = "Verde agua";
        } else if (jRadioButton3.isSelected()){
            opcionElegidaDeColor = "Azul";
        } else if (jRadioButton4.isSelected()){
            opcionElegidaDeColor = "Rojo";
        } else if (jRadioButton5.isSelected()){
            opcionElegidaDeColor = "Violeta";
        } else if (jRadioButton6.isSelected()){
            opcionElegidaDeColor = "Verde";
        } else if (jRadioButton7.isSelected()){
            opcionElegidaDeColor = "Naranja";
        } else if (jRadioButton8.isSelected()){
            opcionElegidaDeColor = "Blanco";
        } else if (jRadioButton9.isSelected()){
            opcionElegidaDeColor = "Negro";
        }
        
        return opcionElegidaDeColor;
    }

   
    
    public void cambioDeColor(String color, JTextPane textContenido, JTextField textID, 
            JTextField textNombre, JButton jButtonCrear, JButton jButtonModificar, 
            JPanel Nota){

        Color colorFondo = null;
        Color colorLetra = null;
        
        if(color.equals("Amarillo")){
            colorFondo = new java.awt.Color(255,255,204);
            colorLetra = new java.awt.Color(204,204,0);  
        } else if (color.equals("Verde agua")){
            colorFondo = new java.awt.Color(204,255,204);
            colorLetra = new java.awt.Color(0,102,102);  
        } else if (color.equals("Azul")){
            colorFondo = new java.awt.Color(204,204,255);
            colorLetra = new java.awt.Color(0,102,153);  
        } else if (color.equals("Rojo")){
            colorFondo = new java.awt.Color(255,204,204);
            colorLetra = new java.awt.Color(153,0,0);  
        } else if (color.equals("Violeta")){
            colorFondo = new java.awt.Color(255,204,255);
            colorLetra = new java.awt.Color(102,0,102);  
        } else if (color.equals("Verde")){
            colorFondo = new java.awt.Color(204,255,204);
            colorLetra = new java.awt.Color(51,102,0);  
        } else if (color.equals("Naranja")){
            colorFondo = new java.awt.Color(255,204,153);
            colorLetra = new java.awt.Color(204,102,0);  
        } else if (color.equals("Blanco")){
            colorFondo = new java.awt.Color(255,255,255);
            colorLetra = new java.awt.Color(0,0,0);  
        } else if (color.equals("Negro")){
            colorFondo = new java.awt.Color(0,0,0);
            colorLetra = new java.awt.Color(255,255,255);  
        }
        
        textContenido.setBackground(colorFondo);
        textID.setBackground(colorFondo);
        textNombre.setBackground(colorFondo);

        jButtonModificar.setBackground(colorFondo);
        jButtonModificar.setForeground(colorLetra);

        jButtonCrear.setBackground(colorFondo);
        jButtonCrear.setForeground(colorLetra);

        Nota.setBackground(colorFondo); 
        
        if(color.equals("Negro")){
            Color colorContenido =  new java.awt.Color(255,255,255);  
            textContenido.setForeground(colorContenido);
            textID.setForeground(colorContenido);
            textNombre.setForeground(colorContenido);
        } else {
            Color colorContenido =  new java.awt.Color(0,0,0);  
            textContenido.setForeground(colorContenido);
            textID.setForeground(colorContenido);
            textNombre.setForeground(colorContenido);
        
        }
    }
    
    
    public String eleccionFuente(){
       
        String letra = null; 
        int fuente = cmbFuente.getSelectedIndex() + 1;
        
        if(fuente == 1){
            letra = "Segoe";
        } else if (fuente == 2){
            letra = "SimSun";
        } else if (fuente == 3){
            letra = "Segoe Emoji";
        } else if (fuente == 4){
            letra = "Serif";
        } else if (fuente == 5){
            letra = "Stencial";
        } else if (fuente == 6){
            letra = "Vivaldi";
        } else if (fuente == 7){
            letra = "Yu Gothic";
        } else if (fuente == 8){
            letra = "Lucida Sans";
        } else if (fuente == 9){
            letra = "Modern No. 20";
        } else if (fuente == 10){
            letra = "Monotype Corsiva";
        }
        return letra;
    }
    
    
    public Font cambioFuente(String letra){
     
        Font fuente = null;
        
         if(letra.equals("Segoe")){
            fuente = new java.awt.Font("Segoe UI", 0, 14);
        } else if (letra.equals("SimSun")){
            fuente = new java.awt.Font("SimSun", 0, 14);
        } else if (letra.equals("Segoe Emoji")){
            fuente = new java.awt.Font("Segoe UI Emoji", 0, 14);
        } else if (letra.equals("Serif")){
            fuente = new java.awt.Font("Serif", 0, 14);
        } else if (letra.equals("Stencial")){
            fuente = new java.awt.Font("Stencil", 0, 14); 
        } else if (letra.equals("Vivaldi")){
            fuente = new java.awt.Font("Vivaldi", 0, 14);  
        } else if (letra.equals("Yu Gothic")){
            fuente = new java.awt.Font("Yu Gothic UI Semibold", 0, 14);
        } else if (letra.equals("Lucida Sans")){
            fuente = new java.awt.Font("Lucida Sans", 0, 14);
        } else if (letra.equals("Modern No. 20")){
            fuente = new java.awt.Font("Modern No. 20", 0, 14);
        } else if (letra.equals("Monotype Corsiva")){
            fuente = new java.awt.Font("Monotype Corsiva", 0, 14);
        }
        return fuente;
    }

   
    
    public JTextPane cajaContenidoSegunUbi(String ubicacion){
        
        JTextPane cajaContenido = null;
        
        if(ubicacion.equals("Nota 1")){
            cajaContenido = textContenido;
        } else if(ubicacion.equals("Nota 2")){
            cajaContenido = textContenido2;
        } else if(ubicacion.equals("Nota 3")){
            cajaContenido = textContenido3;
        } else if(ubicacion.equals("Nota 4")){
            cajaContenido = textContenido4;
        } else if(ubicacion.equals("Nota 5")){
            cajaContenido = textContenido5;
        } else if(ubicacion.equals("Nota 6")){
            cajaContenido = textContenido6;
        } else if(ubicacion.equals("Nota 7")){
            cajaContenido = textContenido7;
        }  else if(ubicacion.equals("Nota 8")){
            cajaContenido = textContenido8;
        } 

        return cajaContenido;
    }

    public JTextField cajaNombreSegunUbi(String ubicacion){
        
        JTextField cajaNombre = null;
        
        if(ubicacion.equals("Nota 1")){
            cajaNombre = textNombre;
        } else if(ubicacion.equals("Nota 2")){
            cajaNombre = textNombre1;
        } else if(ubicacion.equals("Nota 3")){
            cajaNombre = textNombre2;
        } else if(ubicacion.equals("Nota 4")){
            cajaNombre = textNombre3;
        } else if(ubicacion.equals("Nota 5")){
            cajaNombre = textNombre4;
        } else if(ubicacion.equals("Nota 6")){
            cajaNombre = textNombre5;
        } else if(ubicacion.equals("Nota 7")){
            cajaNombre = textNombre6;
        }  else if(ubicacion.equals("Nota 8")){
            cajaNombre = textNombre7;
        } 

        return cajaNombre;
    }
    
    
     public JTextField cajaIDSegunUbi(String ubicacion){
        
        JTextField cajaID = null;
        
        if(ubicacion.equals("Nota 1")){
            cajaID = textID;
        } else if(ubicacion.equals("Nota 2")){
            cajaID = textID1;
        } else if(ubicacion.equals("Nota 3")){
            cajaID = textID2;
        } else if(ubicacion.equals("Nota 4")){
            cajaID = textID3;
        } else if(ubicacion.equals("Nota 5")){
            cajaID = textID4;
        } else if(ubicacion.equals("Nota 6")){
            cajaID = textID5;
        } else if(ubicacion.equals("Nota 7")){
            cajaID = textID6;
        }  else if(ubicacion.equals("Nota 8")){
            cajaID = textID7;
        } 

        return cajaID;
    }
     
      public JButton cajaCrearSegunUbi(String ubicacion){
        
        JButton cajaCrear = null;
        
        if(ubicacion.equals("Nota 1")){
            cajaCrear = jButtonCrear;
        } else if(ubicacion.equals("Nota 2")){
            cajaCrear = jButtonCrear1;
        } else if(ubicacion.equals("Nota 3")){
            cajaCrear = jButtonCrear2;
        } else if(ubicacion.equals("Nota 4")){
            cajaCrear = jButtonCrear3;
        } else if(ubicacion.equals("Nota 5")){
            cajaCrear = jButtonCrear4;
        } else if(ubicacion.equals("Nota 6")){
            cajaCrear = jButtonCrear5;
        } else if(ubicacion.equals("Nota 7")){
            cajaCrear = jButtonCrear6;
        }  else if(ubicacion.equals("Nota 8")){
            cajaCrear= jButtonCrear7;
        } 

        return cajaCrear;
    }
      
      public JButton cajaModificarSegunUbi(String ubicacion){
        
        JButton cajaModificar = null;
        
        if(ubicacion.equals("Nota 1")){
            cajaModificar = jButtonModificar;
        } else if(ubicacion.equals("Nota 2")){
            cajaModificar = jButtonModificar1;
        } else if(ubicacion.equals("Nota 3")){
            cajaModificar = jButtonModificar2;
        } else if(ubicacion.equals("Nota 4")){
            cajaModificar = jButtonModificar3;
        } else if(ubicacion.equals("Nota 5")){
            cajaModificar= jButtonModificar4;
        } else if(ubicacion.equals("Nota 6")){
            cajaModificar = jButtonModificar5;
        } else if(ubicacion.equals("Nota 7")){
            cajaModificar = jButtonModificar6;
        }  else if(ubicacion.equals("Nota 8")){
            cajaModificar= jButtonModificar7;
        } 

        return cajaModificar;
    }
      
       public JPanel cajaPanelSegunUbi(String ubicacion){
        
        JPanel cajaPanel = null;
        
        if(ubicacion.equals("Nota 1")){
            cajaPanel = Nota1;
        } else if(ubicacion.equals("Nota 2")){
            cajaPanel = Nota2;
        } else if(ubicacion.equals("Nota 3")){
            cajaPanel = Nota3;
        } else if(ubicacion.equals("Nota 4")){
            cajaPanel = Nota4;
        } else if(ubicacion.equals("Nota 5")){
            cajaPanel= Nota5;
        } else if(ubicacion.equals("Nota 6")){
            cajaPanel = Nota6;
        } else if(ubicacion.equals("Nota 7")){
            cajaPanel = Nota7;
        }  else if(ubicacion.equals("Nota 8")){
            cajaPanel = Nota8;
        } 

        return cajaPanel;
    }
       

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoColores = new javax.swing.ButtonGroup();
        jPanelOpciones = new javax.swing.JPanel();
        jButtonVolverAtras = new javax.swing.JButton();
        Nota1 = new javax.swing.JPanel();
        jLabelNum = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textContenido = new javax.swing.JTextPane();
        jScrollBar1 = new javax.swing.JScrollBar();
        jButtonConfiguracion = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        textID = new javax.swing.JTextField();
        jButtonModificar = new javax.swing.JButton();
        textNombre = new javax.swing.JTextField();
        jButtonActualizar = new javax.swing.JButton();
        jButtonCrear = new javax.swing.JButton();
        Nota2 = new javax.swing.JPanel();
        jLabelNum1 = new javax.swing.JLabel();
        textID1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        textContenido2 = new javax.swing.JTextPane();
        jButtonConfiguracion1 = new javax.swing.JButton();
        jButtonEliminar1 = new javax.swing.JButton();
        jLabelID1 = new javax.swing.JLabel();
        jButtonModificar1 = new javax.swing.JButton();
        textNombre1 = new javax.swing.JTextField();
        jButtonCrear1 = new javax.swing.JButton();
        jButtonActualizar1 = new javax.swing.JButton();
        Nota3 = new javax.swing.JPanel();
        jLabelNum2 = new javax.swing.JLabel();
        textID2 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        textContenido3 = new javax.swing.JTextPane();
        jButtonConfiguracion2 = new javax.swing.JButton();
        jButtonEliminar2 = new javax.swing.JButton();
        jLabelID2 = new javax.swing.JLabel();
        jButtonModificar2 = new javax.swing.JButton();
        textNombre2 = new javax.swing.JTextField();
        jButtonCrear2 = new javax.swing.JButton();
        jButtonActualizar2 = new javax.swing.JButton();
        Nota4 = new javax.swing.JPanel();
        jLabelNum3 = new javax.swing.JLabel();
        textID3 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        textContenido4 = new javax.swing.JTextPane();
        jButtonConfiguracion3 = new javax.swing.JButton();
        jButtonEliminar3 = new javax.swing.JButton();
        jLabelID3 = new javax.swing.JLabel();
        jButtonModificar3 = new javax.swing.JButton();
        textNombre3 = new javax.swing.JTextField();
        jButtonCrear3 = new javax.swing.JButton();
        jButtonActualizar3 = new javax.swing.JButton();
        Nota5 = new javax.swing.JPanel();
        jLabelNum4 = new javax.swing.JLabel();
        textID4 = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        textContenido5 = new javax.swing.JTextPane();
        jButtonConfiguracion4 = new javax.swing.JButton();
        jButtonEliminar4 = new javax.swing.JButton();
        jLabelID4 = new javax.swing.JLabel();
        jButtonModificar4 = new javax.swing.JButton();
        textNombre4 = new javax.swing.JTextField();
        jButtonCrear4 = new javax.swing.JButton();
        jButtonActualizar4 = new javax.swing.JButton();
        Nota6 = new javax.swing.JPanel();
        jLabelNum5 = new javax.swing.JLabel();
        textID5 = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        textContenido6 = new javax.swing.JTextPane();
        jButtonConfiguracion5 = new javax.swing.JButton();
        jButtonEliminar5 = new javax.swing.JButton();
        jLabelID5 = new javax.swing.JLabel();
        jButtonModificar5 = new javax.swing.JButton();
        textNombre5 = new javax.swing.JTextField();
        jButtonCrear5 = new javax.swing.JButton();
        jButtonActualizar5 = new javax.swing.JButton();
        Nota7 = new javax.swing.JPanel();
        jLabelNum6 = new javax.swing.JLabel();
        textID6 = new javax.swing.JTextField();
        jButtonConfiguracion6 = new javax.swing.JButton();
        jButtonEliminar6 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        textContenido7 = new javax.swing.JTextPane();
        jLabelID6 = new javax.swing.JLabel();
        jButtonModificar6 = new javax.swing.JButton();
        textNombre6 = new javax.swing.JTextField();
        jButtonCrear6 = new javax.swing.JButton();
        jButtonActualizar6 = new javax.swing.JButton();
        Nota8 = new javax.swing.JPanel();
        jLabelNum7 = new javax.swing.JLabel();
        textID7 = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        textContenido8 = new javax.swing.JTextPane();
        jButtonConfiguracion7 = new javax.swing.JButton();
        jButtonEliminar7 = new javax.swing.JButton();
        jLabelID7 = new javax.swing.JLabel();
        jButtonModificar7 = new javax.swing.JButton();
        textNombre7 = new javax.swing.JTextField();
        jButtonCrear7 = new javax.swing.JButton();
        jButtonActualizar7 = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        textBusqueda = new javax.swing.JTextField();
        cmbNota = new javax.swing.JComboBox<>();
        jPanelConfiguracion = new javax.swing.JPanel();
        jLabelAviso1 = new javax.swing.JLabel();
        jButtonNota = new javax.swing.JButton();
        jButtonNotaLetra = new javax.swing.JButton();
        textColorNota = new javax.swing.JTextField();
        textColorLetra = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cmbFuente = new javax.swing.JComboBox<>();
        jButtonConfirmacion = new javax.swing.JButton();
        jToggleButtonCambio = new javax.swing.JToggleButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jCheckBoxActivo = new javax.swing.JCheckBox();
        jLabelWallpaper = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuNotas = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItemLista = new javax.swing.JMenuItem();
        jMenuVacio = new javax.swing.JMenu();
        jMenuNombre = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getLogo());
        setIconImages(getIconImages());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        jPanelOpciones.setBorder(dropShadowBorder1);

        jButtonVolverAtras.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonVolverAtras.setForeground(new java.awt.Color(0, 0, 153));
        jButtonVolverAtras.setText("Volver atrás");
        jButtonVolverAtras.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonVolverAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelOpcionesLayout = new javax.swing.GroupLayout(jPanelOpciones);
        jPanelOpciones.setLayout(jPanelOpcionesLayout);
        jPanelOpcionesLayout.setHorizontalGroup(
            jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonVolverAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelOpcionesLayout.setVerticalGroup(
            jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonVolverAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 640, -1, 70));

        Nota1.setBackground(new java.awt.Color(255, 255, 204));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder2 = new org.jdesktop.swingx.border.DropShadowBorder();
        Nota1.setBorder(dropShadowBorder2);
        Nota1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                Nota1MouseDragged(evt);
            }
        });
        Nota1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNum.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelNum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNum.setText("N°");
        Nota1.add(jLabelNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 20, 20));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 204));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setHorizontalScrollBar(null);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(50, 10));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(64, 10));
        jScrollPane1.setVerticalScrollBar(jScrollBar1);

        textContenido.setBackground(new java.awt.Color(255, 255, 204));
        textContenido.setBorder(null);
        textContenido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textContenido.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textContenido.setMaximumSize(new java.awt.Dimension(60, 10));
        textContenido.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(textContenido);

        Nota1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 150, 140));

        jScrollBar1.setBackground(new java.awt.Color(255, 255, 204));
        Nota1.add(jScrollBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, -1, 140));

        jButtonConfiguracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/configuracion.png"))); // NOI18N
        jButtonConfiguracion.setBorderPainted(false);
        jButtonConfiguracion.setContentAreaFilled(false);
        jButtonConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfiguracionActionPerformed(evt);
            }
        });
        Nota1.add(jButtonConfiguracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 20));

        jButtonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sacar.png"))); // NOI18N
        jButtonEliminar.setBorderPainted(false);
        jButtonEliminar.setContentAreaFilled(false);
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });
        Nota1.add(jButtonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, 10));

        textID.setBackground(new java.awt.Color(255, 255, 204));
        textID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Nota1.add(textID, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 40, 25));

        jButtonModificar.setBackground(new java.awt.Color(255, 255, 204));
        jButtonModificar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonModificar.setForeground(new java.awt.Color(204, 204, 0));
        jButtonModificar.setText("Modificar");
        jButtonModificar.setBorderPainted(false);
        jButtonModificar.setContentAreaFilled(false);
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });
        Nota1.add(jButtonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, 20));

        textNombre.setBackground(new java.awt.Color(255, 255, 204));
        textNombre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Nota1.add(textNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 150, 30));

        jButtonActualizar.setForeground(new java.awt.Color(204, 204, 0));
        jButtonActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cargar.png"))); // NOI18N
        jButtonActualizar.setBorderPainted(false);
        jButtonActualizar.setContentAreaFilled(false);
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });
        Nota1.add(jButtonActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 220, -1, -1));

        jButtonCrear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonCrear.setForeground(new java.awt.Color(204, 204, 0));
        jButtonCrear.setText("Crear nota");
        jButtonCrear.setBorderPainted(false);
        jButtonCrear.setContentAreaFilled(false);
        jButtonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearActionPerformed(evt);
            }
        });
        Nota1.add(jButtonCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 120, 20));

        getContentPane().add(Nota1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 190, 280));

        Nota2.setBackground(new java.awt.Color(255, 255, 204));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder3 = new org.jdesktop.swingx.border.DropShadowBorder();
        Nota2.setBorder(dropShadowBorder3);
        Nota2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                Nota2MouseDragged(evt);
            }
        });
        Nota2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNum1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelNum1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNum1.setText("N°");
        Nota2.add(jLabelNum1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 30, 20));

        textID1.setBackground(new java.awt.Color(255, 255, 204));
        textID1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Nota2.add(textID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 40, 25));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 204));

        textContenido2.setBackground(new java.awt.Color(255, 255, 204));
        textContenido2.setBorder(null);
        textContenido2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textContenido2.setAutoscrolls(false);
        jScrollPane2.setViewportView(textContenido2);

        Nota2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 150, 140));

        jButtonConfiguracion1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/configuracion.png"))); // NOI18N
        jButtonConfiguracion1.setBorderPainted(false);
        jButtonConfiguracion1.setContentAreaFilled(false);
        jButtonConfiguracion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfiguracion1ActionPerformed(evt);
            }
        });
        Nota2.add(jButtonConfiguracion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 20));

        jButtonEliminar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sacar.png"))); // NOI18N
        jButtonEliminar1.setBorderPainted(false);
        jButtonEliminar1.setContentAreaFilled(false);
        jButtonEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminar1ActionPerformed(evt);
            }
        });
        Nota2.add(jButtonEliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, 10));

        jLabelID1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelID1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Nota2.add(jLabelID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 20, -1));

        jButtonModificar1.setBackground(new java.awt.Color(255, 255, 204));
        jButtonModificar1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonModificar1.setForeground(new java.awt.Color(204, 204, 0));
        jButtonModificar1.setText("Modificar");
        jButtonModificar1.setBorderPainted(false);
        jButtonModificar1.setContentAreaFilled(false);
        jButtonModificar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificar1ActionPerformed(evt);
            }
        });
        Nota2.add(jButtonModificar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, 20));

        textNombre1.setBackground(new java.awt.Color(255, 255, 204));
        textNombre1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textNombre1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Nota2.add(textNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 150, 30));

        jButtonCrear1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonCrear1.setForeground(new java.awt.Color(204, 204, 0));
        jButtonCrear1.setText("Crear nota");
        jButtonCrear1.setBorderPainted(false);
        jButtonCrear1.setContentAreaFilled(false);
        jButtonCrear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrear1ActionPerformed(evt);
            }
        });
        Nota2.add(jButtonCrear1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, 20));

        jButtonActualizar1.setForeground(new java.awt.Color(204, 204, 0));
        jButtonActualizar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cargar.png"))); // NOI18N
        jButtonActualizar1.setBorderPainted(false);
        jButtonActualizar1.setContentAreaFilled(false);
        jButtonActualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizar1ActionPerformed(evt);
            }
        });
        Nota2.add(jButtonActualizar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 220, -1, -1));

        getContentPane().add(Nota2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 190, 280));

        Nota3.setBackground(new java.awt.Color(255, 255, 204));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder4 = new org.jdesktop.swingx.border.DropShadowBorder();
        Nota3.setBorder(dropShadowBorder4);
        Nota3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                Nota3MouseDragged(evt);
            }
        });
        Nota3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNum2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelNum2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNum2.setText("N°");
        Nota3.add(jLabelNum2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 30, 20));

        textID2.setBackground(new java.awt.Color(255, 255, 204));
        textID2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Nota3.add(textID2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 40, 25));

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 204));

        textContenido3.setBackground(new java.awt.Color(255, 255, 204));
        textContenido3.setBorder(null);
        textContenido3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textContenido3.setAutoscrolls(false);
        jScrollPane3.setViewportView(textContenido3);

        Nota3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 150, 140));

        jButtonConfiguracion2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/configuracion.png"))); // NOI18N
        jButtonConfiguracion2.setBorderPainted(false);
        jButtonConfiguracion2.setContentAreaFilled(false);
        jButtonConfiguracion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfiguracion2ActionPerformed(evt);
            }
        });
        Nota3.add(jButtonConfiguracion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 20));

        jButtonEliminar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sacar.png"))); // NOI18N
        jButtonEliminar2.setBorderPainted(false);
        jButtonEliminar2.setContentAreaFilled(false);
        jButtonEliminar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminar2ActionPerformed(evt);
            }
        });
        Nota3.add(jButtonEliminar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, 10));

        jLabelID2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelID2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Nota3.add(jLabelID2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 20, -1));

        jButtonModificar2.setBackground(new java.awt.Color(255, 255, 204));
        jButtonModificar2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonModificar2.setForeground(new java.awt.Color(204, 204, 0));
        jButtonModificar2.setText("Modificar");
        jButtonModificar2.setBorderPainted(false);
        jButtonModificar2.setContentAreaFilled(false);
        jButtonModificar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificar2ActionPerformed(evt);
            }
        });
        Nota3.add(jButtonModificar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, 20));

        textNombre2.setBackground(new java.awt.Color(255, 255, 204));
        textNombre2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textNombre2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Nota3.add(textNombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 150, 30));

        jButtonCrear2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonCrear2.setForeground(new java.awt.Color(204, 204, 0));
        jButtonCrear2.setText("Crear nota");
        jButtonCrear2.setBorderPainted(false);
        jButtonCrear2.setContentAreaFilled(false);
        jButtonCrear2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrear2ActionPerformed(evt);
            }
        });
        Nota3.add(jButtonCrear2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, 20));

        jButtonActualizar2.setForeground(new java.awt.Color(204, 204, 0));
        jButtonActualizar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cargar.png"))); // NOI18N
        jButtonActualizar2.setBorderPainted(false);
        jButtonActualizar2.setContentAreaFilled(false);
        jButtonActualizar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizar2ActionPerformed(evt);
            }
        });
        Nota3.add(jButtonActualizar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 220, -1, -1));

        getContentPane().add(Nota3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 190, 280));

        Nota4.setBackground(new java.awt.Color(255, 255, 204));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder5 = new org.jdesktop.swingx.border.DropShadowBorder();
        Nota4.setBorder(dropShadowBorder5);
        Nota4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                Nota4MouseDragged(evt);
            }
        });
        Nota4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNum3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelNum3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNum3.setText("N°");
        Nota4.add(jLabelNum3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 30, 20));

        textID3.setBackground(new java.awt.Color(255, 255, 204));
        textID3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Nota4.add(textID3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 40, 25));

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 204));

        textContenido4.setBackground(new java.awt.Color(255, 255, 204));
        textContenido4.setBorder(null);
        textContenido4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textContenido4.setAutoscrolls(false);
        jScrollPane4.setViewportView(textContenido4);

        Nota4.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 150, 140));

        jButtonConfiguracion3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/configuracion.png"))); // NOI18N
        jButtonConfiguracion3.setBorderPainted(false);
        jButtonConfiguracion3.setContentAreaFilled(false);
        jButtonConfiguracion3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfiguracion3ActionPerformed(evt);
            }
        });
        Nota4.add(jButtonConfiguracion3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 20));

        jButtonEliminar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sacar.png"))); // NOI18N
        jButtonEliminar3.setBorderPainted(false);
        jButtonEliminar3.setContentAreaFilled(false);
        jButtonEliminar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminar3ActionPerformed(evt);
            }
        });
        Nota4.add(jButtonEliminar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, 10));

        jLabelID3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelID3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Nota4.add(jLabelID3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 20, -1));

        jButtonModificar3.setBackground(new java.awt.Color(255, 255, 204));
        jButtonModificar3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonModificar3.setForeground(new java.awt.Color(204, 204, 0));
        jButtonModificar3.setText("Modificar");
        jButtonModificar3.setBorderPainted(false);
        jButtonModificar3.setContentAreaFilled(false);
        jButtonModificar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificar3ActionPerformed(evt);
            }
        });
        Nota4.add(jButtonModificar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, 20));

        textNombre3.setBackground(new java.awt.Color(255, 255, 204));
        textNombre3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textNombre3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Nota4.add(textNombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 150, 30));

        jButtonCrear3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonCrear3.setForeground(new java.awt.Color(204, 204, 0));
        jButtonCrear3.setText("Crear nota");
        jButtonCrear3.setBorderPainted(false);
        jButtonCrear3.setContentAreaFilled(false);
        jButtonCrear3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrear3ActionPerformed(evt);
            }
        });
        Nota4.add(jButtonCrear3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, 20));

        jButtonActualizar3.setForeground(new java.awt.Color(204, 204, 0));
        jButtonActualizar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cargar.png"))); // NOI18N
        jButtonActualizar3.setBorderPainted(false);
        jButtonActualizar3.setContentAreaFilled(false);
        jButtonActualizar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizar3ActionPerformed(evt);
            }
        });
        Nota4.add(jButtonActualizar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 220, -1, -1));

        getContentPane().add(Nota4, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 50, 190, 280));

        Nota5.setBackground(new java.awt.Color(255, 255, 204));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder6 = new org.jdesktop.swingx.border.DropShadowBorder();
        Nota5.setBorder(dropShadowBorder6);
        Nota5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                Nota5MouseDragged(evt);
            }
        });
        Nota5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNum4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelNum4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNum4.setText("N°");
        Nota5.add(jLabelNum4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 30, 20));

        textID4.setBackground(new java.awt.Color(255, 255, 204));
        textID4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Nota5.add(textID4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 40, 25));

        jScrollPane5.setBackground(new java.awt.Color(255, 255, 204));

        textContenido5.setBackground(new java.awt.Color(255, 255, 204));
        textContenido5.setBorder(null);
        textContenido5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textContenido5.setAutoscrolls(false);
        jScrollPane5.setViewportView(textContenido5);

        Nota5.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 150, 140));

        jButtonConfiguracion4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/configuracion.png"))); // NOI18N
        jButtonConfiguracion4.setBorderPainted(false);
        jButtonConfiguracion4.setContentAreaFilled(false);
        jButtonConfiguracion4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfiguracion4ActionPerformed(evt);
            }
        });
        Nota5.add(jButtonConfiguracion4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 20));

        jButtonEliminar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sacar.png"))); // NOI18N
        jButtonEliminar4.setBorderPainted(false);
        jButtonEliminar4.setContentAreaFilled(false);
        jButtonEliminar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminar4ActionPerformed(evt);
            }
        });
        Nota5.add(jButtonEliminar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, 10));

        jLabelID4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelID4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Nota5.add(jLabelID4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 20, -1));

        jButtonModificar4.setBackground(new java.awt.Color(255, 255, 204));
        jButtonModificar4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonModificar4.setForeground(new java.awt.Color(204, 204, 0));
        jButtonModificar4.setText("Modificar");
        jButtonModificar4.setBorderPainted(false);
        jButtonModificar4.setContentAreaFilled(false);
        jButtonModificar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificar4ActionPerformed(evt);
            }
        });
        Nota5.add(jButtonModificar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, 20));

        textNombre4.setBackground(new java.awt.Color(255, 255, 204));
        textNombre4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textNombre4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Nota5.add(textNombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 150, 30));

        jButtonCrear4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonCrear4.setForeground(new java.awt.Color(204, 204, 0));
        jButtonCrear4.setText("Crear nota");
        jButtonCrear4.setBorderPainted(false);
        jButtonCrear4.setContentAreaFilled(false);
        jButtonCrear4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrear4ActionPerformed(evt);
            }
        });
        Nota5.add(jButtonCrear4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, 20));

        jButtonActualizar4.setForeground(new java.awt.Color(204, 204, 0));
        jButtonActualizar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cargar.png"))); // NOI18N
        jButtonActualizar4.setBorderPainted(false);
        jButtonActualizar4.setContentAreaFilled(false);
        jButtonActualizar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizar4ActionPerformed(evt);
            }
        });
        Nota5.add(jButtonActualizar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 220, -1, -1));

        getContentPane().add(Nota5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 190, 280));

        Nota6.setBackground(new java.awt.Color(255, 255, 204));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder7 = new org.jdesktop.swingx.border.DropShadowBorder();
        Nota6.setBorder(dropShadowBorder7);
        Nota6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                Nota6MouseDragged(evt);
            }
        });
        Nota6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNum5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelNum5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNum5.setText("N°");
        Nota6.add(jLabelNum5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 20, 20));

        textID5.setBackground(new java.awt.Color(255, 255, 204));
        textID5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textID5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textID5ActionPerformed(evt);
            }
        });
        Nota6.add(textID5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 40, 25));

        jScrollPane6.setBackground(new java.awt.Color(255, 255, 204));

        textContenido6.setBackground(new java.awt.Color(255, 255, 204));
        textContenido6.setBorder(null);
        textContenido6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textContenido6.setAutoscrolls(false);
        jScrollPane6.setViewportView(textContenido6);

        Nota6.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 150, 140));

        jButtonConfiguracion5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/configuracion.png"))); // NOI18N
        jButtonConfiguracion5.setBorderPainted(false);
        jButtonConfiguracion5.setContentAreaFilled(false);
        jButtonConfiguracion5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfiguracion5ActionPerformed(evt);
            }
        });
        Nota6.add(jButtonConfiguracion5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 20));

        jButtonEliminar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sacar.png"))); // NOI18N
        jButtonEliminar5.setBorderPainted(false);
        jButtonEliminar5.setContentAreaFilled(false);
        jButtonEliminar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminar5ActionPerformed(evt);
            }
        });
        Nota6.add(jButtonEliminar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, 10));

        jLabelID5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelID5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Nota6.add(jLabelID5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 20, -1));

        jButtonModificar5.setBackground(new java.awt.Color(255, 255, 204));
        jButtonModificar5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonModificar5.setForeground(new java.awt.Color(204, 204, 0));
        jButtonModificar5.setText("Modificar");
        jButtonModificar5.setBorderPainted(false);
        jButtonModificar5.setContentAreaFilled(false);
        jButtonModificar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificar5ActionPerformed(evt);
            }
        });
        Nota6.add(jButtonModificar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, 20));

        textNombre5.setBackground(new java.awt.Color(255, 255, 204));
        textNombre5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textNombre5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Nota6.add(textNombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 150, 30));

        jButtonCrear5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonCrear5.setForeground(new java.awt.Color(204, 204, 0));
        jButtonCrear5.setText("Crear nota");
        jButtonCrear5.setBorderPainted(false);
        jButtonCrear5.setContentAreaFilled(false);
        jButtonCrear5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrear5ActionPerformed(evt);
            }
        });
        Nota6.add(jButtonCrear5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, 20));

        jButtonActualizar5.setForeground(new java.awt.Color(204, 204, 0));
        jButtonActualizar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cargar.png"))); // NOI18N
        jButtonActualizar5.setBorderPainted(false);
        jButtonActualizar5.setContentAreaFilled(false);
        jButtonActualizar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizar5ActionPerformed(evt);
            }
        });
        Nota6.add(jButtonActualizar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 220, -1, -1));

        getContentPane().add(Nota6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, 190, 280));

        Nota7.setBackground(new java.awt.Color(255, 255, 204));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder8 = new org.jdesktop.swingx.border.DropShadowBorder();
        Nota7.setBorder(dropShadowBorder8);
        Nota7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                Nota7MouseDragged(evt);
            }
        });
        Nota7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNum6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelNum6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNum6.setText("N°");
        Nota7.add(jLabelNum6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 20, 20));

        textID6.setBackground(new java.awt.Color(255, 255, 204));
        textID6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Nota7.add(textID6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 40, 25));

        jButtonConfiguracion6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/configuracion.png"))); // NOI18N
        jButtonConfiguracion6.setBorderPainted(false);
        jButtonConfiguracion6.setContentAreaFilled(false);
        jButtonConfiguracion6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfiguracion6ActionPerformed(evt);
            }
        });
        Nota7.add(jButtonConfiguracion6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 20));

        jButtonEliminar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sacar.png"))); // NOI18N
        jButtonEliminar6.setBorderPainted(false);
        jButtonEliminar6.setContentAreaFilled(false);
        jButtonEliminar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminar6ActionPerformed(evt);
            }
        });
        Nota7.add(jButtonEliminar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, 10));

        jScrollPane7.setBackground(new java.awt.Color(255, 255, 204));

        textContenido7.setBackground(new java.awt.Color(255, 255, 204));
        textContenido7.setBorder(null);
        textContenido7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textContenido7.setAutoscrolls(false);
        jScrollPane7.setViewportView(textContenido7);

        Nota7.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 150, 140));

        jLabelID6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelID6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Nota7.add(jLabelID6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 20, -1));

        jButtonModificar6.setBackground(new java.awt.Color(255, 255, 204));
        jButtonModificar6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonModificar6.setForeground(new java.awt.Color(204, 204, 0));
        jButtonModificar6.setText("Modificar");
        jButtonModificar6.setBorderPainted(false);
        jButtonModificar6.setContentAreaFilled(false);
        jButtonModificar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificar6ActionPerformed(evt);
            }
        });
        Nota7.add(jButtonModificar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, 20));

        textNombre6.setBackground(new java.awt.Color(255, 255, 204));
        textNombre6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textNombre6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Nota7.add(textNombre6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 150, 30));

        jButtonCrear6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonCrear6.setForeground(new java.awt.Color(204, 204, 0));
        jButtonCrear6.setText("Crear nota");
        jButtonCrear6.setBorderPainted(false);
        jButtonCrear6.setContentAreaFilled(false);
        jButtonCrear6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrear6ActionPerformed(evt);
            }
        });
        Nota7.add(jButtonCrear6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, 20));

        jButtonActualizar6.setForeground(new java.awt.Color(204, 204, 0));
        jButtonActualizar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cargar.png"))); // NOI18N
        jButtonActualizar6.setBorderPainted(false);
        jButtonActualizar6.setContentAreaFilled(false);
        jButtonActualizar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizar6ActionPerformed(evt);
            }
        });
        Nota7.add(jButtonActualizar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 220, -1, -1));

        getContentPane().add(Nota7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 340, 190, 280));

        Nota8.setBackground(new java.awt.Color(255, 255, 204));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder9 = new org.jdesktop.swingx.border.DropShadowBorder();
        Nota8.setBorder(dropShadowBorder9);
        Nota8.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                Nota8MouseDragged(evt);
            }
        });
        Nota8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNum7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelNum7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNum7.setText("N°");
        Nota8.add(jLabelNum7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 20, 20));

        textID7.setBackground(new java.awt.Color(255, 255, 204));
        textID7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Nota8.add(textID7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 40, 25));

        jScrollPane8.setBackground(new java.awt.Color(255, 255, 204));

        textContenido8.setBackground(new java.awt.Color(255, 255, 204));
        textContenido8.setBorder(null);
        textContenido8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textContenido8.setAutoscrolls(false);
        jScrollPane8.setViewportView(textContenido8);

        Nota8.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 150, 140));

        jButtonConfiguracion7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/configuracion.png"))); // NOI18N
        jButtonConfiguracion7.setBorderPainted(false);
        jButtonConfiguracion7.setContentAreaFilled(false);
        jButtonConfiguracion7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfiguracion7ActionPerformed(evt);
            }
        });
        Nota8.add(jButtonConfiguracion7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 20));

        jButtonEliminar7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sacar.png"))); // NOI18N
        jButtonEliminar7.setBorderPainted(false);
        jButtonEliminar7.setContentAreaFilled(false);
        jButtonEliminar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminar7ActionPerformed(evt);
            }
        });
        Nota8.add(jButtonEliminar7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, 10));

        jLabelID7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelID7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Nota8.add(jLabelID7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 20, -1));

        jButtonModificar7.setBackground(new java.awt.Color(255, 255, 204));
        jButtonModificar7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonModificar7.setForeground(new java.awt.Color(204, 204, 0));
        jButtonModificar7.setText("Modificar");
        jButtonModificar7.setBorderPainted(false);
        jButtonModificar7.setContentAreaFilled(false);
        jButtonModificar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificar7ActionPerformed(evt);
            }
        });
        Nota8.add(jButtonModificar7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, 20));

        textNombre7.setBackground(new java.awt.Color(255, 255, 204));
        textNombre7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textNombre7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Nota8.add(textNombre7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 150, 30));

        jButtonCrear7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonCrear7.setForeground(new java.awt.Color(204, 204, 0));
        jButtonCrear7.setText("Crear nota");
        jButtonCrear7.setBorderPainted(false);
        jButtonCrear7.setContentAreaFilled(false);
        jButtonCrear7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrear7ActionPerformed(evt);
            }
        });
        Nota8.add(jButtonCrear7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, 20));

        jButtonActualizar7.setForeground(new java.awt.Color(204, 204, 0));
        jButtonActualizar7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cargar.png"))); // NOI18N
        jButtonActualizar7.setBorderPainted(false);
        jButtonActualizar7.setContentAreaFilled(false);
        jButtonActualizar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizar7ActionPerformed(evt);
            }
        });
        Nota8.add(jButtonActualizar7, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 220, -1, -1));

        getContentPane().add(Nota8, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 340, 190, 280));

        jButtonBuscar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonBuscar.setForeground(new java.awt.Color(0, 0, 153));
        jButtonBuscar.setText("Elegir nota");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 660, 170, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar por titulo:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 640, 170, -1));

        textBusqueda.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textBusqueda.setForeground(new java.awt.Color(0, 0, 153));
        getContentPane().add(textBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 660, 150, 30));

        cmbNota.setForeground(new java.awt.Color(0, 0, 153));
        cmbNota.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nota 1", "Nota 2", "Nota 3", "Nota 4", "Nota 5", "Nota 6", "Nota 7", "Nota 8" }));
        getContentPane().add(cmbNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 660, 130, 30));

        jPanelConfiguracion.setBackground(new java.awt.Color(255, 255, 204));
        jPanelConfiguracion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelAviso1.setBackground(new java.awt.Color(204, 204, 0));
        jLabelAviso1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelAviso1.setForeground(new java.awt.Color(204, 204, 0));
        jLabelAviso1.setText("Establecer colores ");
        jPanelConfiguracion.add(jLabelAviso1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 160, -1));

        jButtonNota.setBackground(new java.awt.Color(255, 255, 204));
        jButtonNota.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButtonNota.setForeground(new java.awt.Color(204, 204, 0));
        jButtonNota.setText("Nota");
        jButtonNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNotaActionPerformed(evt);
            }
        });
        jPanelConfiguracion.add(jButtonNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

        jButtonNotaLetra.setBackground(new java.awt.Color(255, 255, 204));
        jButtonNotaLetra.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButtonNotaLetra.setForeground(new java.awt.Color(204, 204, 0));
        jButtonNotaLetra.setText("Letra");
        jButtonNotaLetra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNotaLetraActionPerformed(evt);
            }
        });
        jPanelConfiguracion.add(jButtonNotaLetra, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, -1));
        jPanelConfiguracion.add(textColorNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 70, -1));
        jPanelConfiguracion.add(textColorLetra, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 70, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 0));
        jLabel2.setText("Cambiar fuente");
        jPanelConfiguracion.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 510, -1, -1));

        cmbFuente.setBackground(new java.awt.Color(255, 255, 204));
        cmbFuente.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmbFuente.setForeground(new java.awt.Color(204, 204, 0));
        cmbFuente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Segoe UI 14 Plain", "SimSun 14 Plain", "Segoe UI Emoji 14 Plain", "Serif 14 Plain", "Stencil 14 Plain", "Vivaldi 14 Plain", "Yu Gothic UI Semibold 14 Plain", "Lucida Sans 14 Plain", "Modern No. 20 14 Plain", "Monotype Corsiva 14 Plain" }));
        cmbFuente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFuenteActionPerformed(evt);
            }
        });
        jPanelConfiguracion.add(cmbFuente, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 560, 220, 30));

        jButtonConfirmacion.setBackground(new java.awt.Color(255, 255, 204));
        jButtonConfirmacion.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButtonConfirmacion.setForeground(new java.awt.Color(204, 204, 0));
        jButtonConfirmacion.setText("Confirmar cambios");
        jButtonConfirmacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmacionActionPerformed(evt);
            }
        });
        jPanelConfiguracion.add(jButtonConfirmacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 650, -1, -1));

        jToggleButtonCambio.setBackground(new java.awt.Color(255, 255, 204));
        jToggleButtonCambio.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jToggleButtonCambio.setForeground(new java.awt.Color(204, 204, 0));
        jToggleButtonCambio.setText("Cambio de elección");
        jToggleButtonCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonCambioActionPerformed(evt);
            }
        });
        jPanelConfiguracion.add(jToggleButtonCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 460, 180, -1));

        jRadioButton1.setBackground(new java.awt.Color(255, 255, 204));
        grupoColores.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(204, 204, 0));
        jRadioButton1.setText("Amarillo y dorado");
        jPanelConfiguracion.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 210, -1));

        jRadioButton2.setBackground(new java.awt.Color(204, 255, 204));
        grupoColores.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(0, 102, 102));
        jRadioButton2.setText("Verde y verde agua");
        jPanelConfiguracion.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 210, -1));

        jRadioButton3.setBackground(new java.awt.Color(204, 204, 255));
        grupoColores.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRadioButton3.setForeground(new java.awt.Color(0, 102, 153));
        jRadioButton3.setText("Azul claro y turqueza");
        jPanelConfiguracion.add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 210, -1));

        jRadioButton4.setBackground(new java.awt.Color(255, 204, 204));
        grupoColores.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRadioButton4.setForeground(new java.awt.Color(153, 0, 0));
        jRadioButton4.setText("Rojo claro y bordo");
        jPanelConfiguracion.add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 210, -1));

        jRadioButton5.setBackground(new java.awt.Color(255, 204, 255));
        grupoColores.add(jRadioButton5);
        jRadioButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRadioButton5.setForeground(new java.awt.Color(102, 0, 102));
        jRadioButton5.setText("Lila y violeta oscuro");
        jPanelConfiguracion.add(jRadioButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 210, -1));

        jRadioButton6.setBackground(new java.awt.Color(204, 255, 204));
        grupoColores.add(jRadioButton6);
        jRadioButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRadioButton6.setForeground(new java.awt.Color(51, 102, 0));
        jRadioButton6.setText("Verde claro y oscuro");
        jPanelConfiguracion.add(jRadioButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 210, -1));

        jRadioButton7.setBackground(new java.awt.Color(255, 204, 153));
        grupoColores.add(jRadioButton7);
        jRadioButton7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRadioButton7.setForeground(new java.awt.Color(204, 102, 0));
        jRadioButton7.setText("Naranja claro y naranja ");
        jPanelConfiguracion.add(jRadioButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 210, -1));

        jRadioButton8.setBackground(new java.awt.Color(255, 255, 255));
        grupoColores.add(jRadioButton8);
        jRadioButton8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRadioButton8.setText("Blanco y negro");
        jPanelConfiguracion.add(jRadioButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, 210, -1));

        jRadioButton9.setBackground(new java.awt.Color(0, 0, 0));
        grupoColores.add(jRadioButton9);
        jRadioButton9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRadioButton9.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton9.setText("Negro y blanco");
        jPanelConfiguracion.add(jRadioButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, 210, -1));

        jCheckBoxActivo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jCheckBoxActivo.setForeground(new java.awt.Color(153, 153, 0));
        jCheckBoxActivo.setText("Nota activa");
        jPanelConfiguracion.add(jCheckBoxActivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 610, -1, -1));

        getContentPane().add(jPanelConfiguracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 0, 570, 770));

        jLabelWallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo3.jpg"))); // NOI18N
        getContentPane().add(jLabelWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -30, 1530, 800));

        jMenuNotas.setForeground(new java.awt.Color(0, 0, 153));
        jMenuNotas.setText("Notas");
        jMenuNotas.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem1.setForeground(new java.awt.Color(0, 0, 153));
        jMenuItem1.setText("Devolver a tamaño normal");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuNotas.add(jMenuItem1);

        jMenuItemLista.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItemLista.setForeground(new java.awt.Color(0, 0, 153));
        jMenuItemLista.setText("Ver notas ingresadas en el sistema");
        jMenuItemLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListaActionPerformed(evt);
            }
        });
        jMenuNotas.add(jMenuItemLista);

        jMenuBar1.add(jMenuNotas);

        jMenuVacio.setBorderPainted(false);
        jMenuVacio.setContentAreaFilled(false);
        jMenuVacio.setEnabled(false);
        jMenuVacio.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jMenuVacio.setMaximumSize(new java.awt.Dimension(800, 32767));
        jMenuVacio.setMinimumSize(new java.awt.Dimension(470, 6));
        jMenuVacio.setPreferredSize(new java.awt.Dimension(500, 6));
        jMenuBar1.add(jMenuVacio);

        jMenuNombre.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jMenuBar1.add(jMenuNombre);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVolverAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverAtrasActionPerformed

        PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
        paginaPrincipal.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButtonVolverAtrasActionPerformed

    private void jButtonConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfiguracionActionPerformed

       this.setSize(1400, 800);
       jPanelConfiguracion.setVisible(true);
       
    }//GEN-LAST:event_jButtonConfiguracionActionPerformed

    private void Nota1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Nota1MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_Nota1MouseDragged

    private void jButtonConfiguracion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfiguracion1ActionPerformed
        
       this.setSize(1600, 800);
       jPanelConfiguracion.setVisible(true);
       
    }//GEN-LAST:event_jButtonConfiguracion1ActionPerformed

    private void Nota2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Nota2MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_Nota2MouseDragged

    private void jButtonConfiguracion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfiguracion2ActionPerformed
        
       this.setSize(1600, 800);
       jPanelConfiguracion.setVisible(true);
        
    }//GEN-LAST:event_jButtonConfiguracion2ActionPerformed

    private void Nota3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Nota3MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_Nota3MouseDragged

    private void jButtonConfiguracion3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfiguracion3ActionPerformed

       this.setSize(1600, 800);
       jPanelConfiguracion.setVisible(true);
       
    }//GEN-LAST:event_jButtonConfiguracion3ActionPerformed

    private void Nota4MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Nota4MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_Nota4MouseDragged

    private void jButtonConfiguracion4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfiguracion4ActionPerformed

       this.setSize(1600, 800);
       jPanelConfiguracion.setVisible(true);
       
    }//GEN-LAST:event_jButtonConfiguracion4ActionPerformed

    private void Nota5MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Nota5MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_Nota5MouseDragged

    private void jButtonConfiguracion5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfiguracion5ActionPerformed

       this.setSize(1600, 800);
       jPanelConfiguracion.setVisible(true);
        
    }//GEN-LAST:event_jButtonConfiguracion5ActionPerformed

    private void Nota6MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Nota6MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_Nota6MouseDragged

    private void jButtonConfiguracion6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfiguracion6ActionPerformed
        
       this.setSize(1600, 800);
       jPanelConfiguracion.setVisible(true);
        
    }//GEN-LAST:event_jButtonConfiguracion6ActionPerformed

    private void Nota7MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Nota7MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_Nota7MouseDragged

    private void jButtonConfiguracion7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfiguracion7ActionPerformed

       this.setSize(1600, 800);
       jPanelConfiguracion.setVisible(true);        

    }//GEN-LAST:event_jButtonConfiguracion7ActionPerformed

    private void Nota8MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Nota8MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_Nota8MouseDragged

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed

        int ubicacion = cmbNota.getSelectedIndex() + 1;
        String titulo = null;
        String ubicacionNota = obtenerNotaUbicacion();
        JTextPane cajaContenido = cajaContenidoSegunUbi(ubicacionNota);
        
        if(cajaContenido.equals("")){
            titulo = JOptionPane.showInputDialog(null, "Ingresa el titulo que deseas dejar inactivo", 
                "Desactivar nota previa");
            notasService.notaInactiva(titulo, ubicacionNota, usuario);
        }
        
        if(ubicacion == 1){
            LimpiarCampos(textContenido, textID, textNombre, jButtonCrear, jButtonModificar, 
            Nota1);
            
            notasService.obtenerNotaPedida(usuario, textID, textNombre, textContenido);
            String colorRecuperado1 = notasService.obtencionColorNota(usuario, "Nota 1");
            cambioDeColor(colorRecuperado1, textContenido, textID, textNombre,
                    jButtonCrear, jButtonModificar, Nota1);
            String letraRecuperada1 = notasService.obtencionFuenteNota(usuario, "Nota 1");
            Font fuenteRecuperada1 = cambioFuente(letraRecuperada1);
            textContenido.setFont(fuenteRecuperada1);

        } else if (ubicacion == 2){  
            LimpiarCampos(textContenido2, textID1, textNombre1, jButtonCrear1, 
                    jButtonModificar1, Nota2);
            
            notasService.obtenerNotaPedida(usuario, textID1, textNombre1, textContenido2);
            String colorRecuperado2 = notasService.obtencionColorNota(usuario, "Nota 2");
            cambioDeColor(colorRecuperado2, textContenido2, textID1, textNombre1,
                    jButtonCrear1, jButtonModificar1, Nota2);
            String letraRecuperada2 = notasService.obtencionFuenteNota(usuario, "Nota 2");
            Font fuenteRecuperada2 = cambioFuente(letraRecuperada2);
            textContenido2.setFont(fuenteRecuperada2);
            
        } else if (ubicacion == 3){
            LimpiarCampos(textContenido3, textID2, textNombre2, jButtonCrear2, 
                    jButtonModificar2, Nota3);
            
           notasService.obtenerNotaPedida(usuario, textID2, textNombre2, textContenido3);
           String colorRecuperado3 = notasService.obtencionColorNota(usuario, "Nota 3");
           cambioDeColor(colorRecuperado3, textContenido3, textID2, textNombre2,
                    jButtonCrear2, jButtonModificar2, Nota3);
            String letraRecuperada3 = notasService.obtencionFuenteNota(usuario, "Nota 3");
            Font fuenteRecuperada3 = cambioFuente(letraRecuperada3);
            textContenido3.setFont(fuenteRecuperada3);
            
        } else if (ubicacion == 4){
            LimpiarCampos(textContenido4, textID3, textNombre3, jButtonCrear3, 
                    jButtonModificar3, Nota4);
            
            notasService.obtenerNotaPedida(usuario, textID3, textNombre3, textContenido4);
       
            String colorRecuperado4 = notasService.obtencionColorNota(usuario, "Nota 4");
            cambioDeColor(colorRecuperado4, textContenido4, textID3, textNombre3,
                    jButtonCrear3, jButtonModificar3, Nota4);
            String letraRecuperada4 = notasService.obtencionFuenteNota(usuario, "Nota 4");
            Font fuenteRecuperada4 = cambioFuente(letraRecuperada4);
            textContenido4.setFont(fuenteRecuperada4);
            
        } else if (ubicacion == 5){
            LimpiarCampos(textContenido5, textID4, textNombre4, jButtonCrear4, 
                    jButtonModificar4, Nota5);
            
            notasService.obtenerNotaPedida(usuario, textID4, textNombre4, textContenido5);

            String colorRecuperado5 = notasService.obtencionColorNota(usuario, "Nota 5");
            cambioDeColor(colorRecuperado5, textContenido5, textID4, textNombre4,
                    jButtonCrear4, jButtonModificar4, Nota5);
            String letraRecuperada5 = notasService.obtencionFuenteNota(usuario, "Nota 5");
            Font fuenteRecuperada5 = cambioFuente(letraRecuperada5);
            textContenido5.setFont(fuenteRecuperada5);
            
        } else if (ubicacion == 6){
            LimpiarCampos(textContenido6, textID5, textNombre5, jButtonCrear5, 
                    jButtonModificar5, Nota6);
            
            notasService.obtenerNotaPedida(usuario, textID5, textNombre5, textContenido6);
 
            String colorRecuperado6 = notasService.obtencionColorNota(usuario, "Nota 6");
            cambioDeColor(colorRecuperado6, textContenido6, textID5, textNombre5,
                    jButtonCrear5, jButtonModificar5, Nota6);
            String letraRecuperada6 = notasService.obtencionFuenteNota(usuario, "Nota 6");
            Font fuenteRecuperada6 = cambioFuente(letraRecuperada6);
            textContenido6.setFont(fuenteRecuperada6);
            
        } else if (ubicacion == 7){    
            LimpiarCampos(textContenido7, textID6, textNombre6, jButtonCrear6, 
                    jButtonModificar6, Nota7);
            
            notasService.obtenerNotaPedida(usuario, textID6, textNombre6, textContenido7);
            
            String colorRecuperado7 = notasService.obtencionColorNota(usuario, "Nota 7");
            cambioDeColor(colorRecuperado7, textContenido7, textID6, textNombre6,
                    jButtonCrear6, jButtonModificar6, Nota7);
            String letraRecuperada7 = notasService.obtencionFuenteNota(usuario, "Nota 7");
            Font fuenteRecuperada7 = cambioFuente(letraRecuperada7);
            textContenido7.setFont(fuenteRecuperada7);
 
        } else if (ubicacion == 8){
            LimpiarCampos(textContenido8, textID7, textNombre7, jButtonCrear7,
                    jButtonModificar7, Nota8);
            
            notasService.obtenerNotaPedida(usuario, textID7, textNombre7, textContenido8);
           
            String colorRecuperado8 = notasService.obtencionColorNota(usuario, "Nota 8");
            cambioDeColor(colorRecuperado8, textContenido8, textID7, textNombre7,
                    jButtonCrear7, jButtonModificar7, Nota8);
            String letraRecuperada8 = notasService.obtencionFuenteNota(usuario, "Nota 8");
            Font fuenteRecuperada8 = cambioFuente(letraRecuperada8);
            textContenido8.setFont(fuenteRecuperada8);
             
        }

    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearActionPerformed

        String ubicacion = "Nota 1";
        
        String titulo = null, contenido = null;  
        int id = 0;
        String color;
        String letra;
         
        id = Integer.parseInt(textID.getText().trim());
        titulo = textNombre.getText().trim();
        contenido = textContenido.getText().trim();

        
        color = eleccionDeColor();
        letra = eleccionFuente();

        notasService.crearNota(usuario, titulo, id, contenido, ubicacion, color, letra);
        
    }//GEN-LAST:event_jButtonCrearActionPerformed

    private void textID5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textID5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textID5ActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        
       String ubicacion = "Nota 1";
       String tituloMod, contenidoMod;
       String color;
       String letra;
        
       tituloMod = textNombre.getText().trim();
       contenidoMod = textContenido.getText().trim();
       
       color = eleccionDeColor();
       letra = eleccionFuente();
           
       notasService.modificarNota(usuario, tituloMod, contenidoMod, ubicacion, color, letra);
      
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed

        String titulo;
        int ID;
        
        String ubicacion = "Nota 1";
        titulo = textNombre.getText().trim();
        ID = Integer.parseInt(textID.getText().trim());
                 
        try{
            Boolean aprobado;
            aprobado = notasService.eliminarNota(ID, usuario, titulo, ubicacion);

        if(aprobado = true){
            textID.setText("");
            textNombre.setText("");
            textContenido.setText("");
        }
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar nota");
        }
        
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminar1ActionPerformed
       
        String titulo;
        int ID;
        
        String ubicacion = "Nota 2";
        titulo = textNombre1.getText().trim();
        ID = Integer.parseInt(textID1.getText().trim());
                
        notasService.eliminarNota(ID, usuario, titulo, ubicacion);
        
        try{
            Boolean aprobado;
            aprobado = notasService.eliminarNota(ID, usuario, titulo, ubicacion);

        if(aprobado = true){
            textID1.setText("");
            textNombre1.setText("");
            textContenido2.setText("");
        }
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar nota");
        }
        
    }//GEN-LAST:event_jButtonEliminar1ActionPerformed

    private void jButtonEliminar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminar2ActionPerformed
        
        String titulo;
        int ID;
        
        String ubicacion = "Nota 3";
        titulo = textNombre2.getText().trim();
        ID = Integer.parseInt(textID2.getText().trim());
                
        notasService.eliminarNota(ID, usuario, titulo, ubicacion);
        
        try{
            Boolean aprobado;
            aprobado = notasService.eliminarNota(ID, usuario, titulo, ubicacion);

        if(aprobado = true){
            textID2.setText("");
            textNombre2.setText("");
            textContenido3.setText("");
        }
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar nota");
        }
        
    }//GEN-LAST:event_jButtonEliminar2ActionPerformed

    private void jButtonEliminar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminar3ActionPerformed
        
        String titulo;
        int ID;
        
        String ubicacion = "Nota 4";
        titulo = textNombre3.getText().trim();
        ID = Integer.parseInt(textID3.getText().trim());
                
        notasService.eliminarNota(ID, usuario, titulo, ubicacion);
        
        try{
            Boolean aprobado;
            aprobado = notasService.eliminarNota(ID, usuario, titulo, ubicacion);

        if(aprobado = true){
            textID3.setText("");
            textNombre3.setText("");
            textContenido4.setText("");
        }
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar nota");
        }
        
    }//GEN-LAST:event_jButtonEliminar3ActionPerformed

    private void jButtonEliminar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminar4ActionPerformed
        
        String titulo;
        int ID;
        
        String ubicacion = "Nota 5";
        titulo = textNombre4.getText().trim();
        ID = Integer.parseInt(textID4.getText().trim());
                
        notasService.eliminarNota(ID, usuario, titulo, ubicacion);
        
        try{
            Boolean aprobado;
            aprobado = notasService.eliminarNota(ID, usuario, titulo, ubicacion);

        if(aprobado = true){
            textID4.setText("");
            textNombre4.setText("");
            textContenido5.setText("");
        }
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar nota");
        }
        
    }//GEN-LAST:event_jButtonEliminar4ActionPerformed

    private void jButtonEliminar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminar5ActionPerformed
        
        String titulo;
        int ID;
        
        String ubicacion = "Nota 6";
        titulo = textNombre5.getText().trim();
        ID = Integer.parseInt(textID5.getText().trim());
                
        notasService.eliminarNota(ID, usuario, titulo, ubicacion);
        
        try{
            Boolean aprobado;
            aprobado = notasService.eliminarNota(ID, usuario, titulo, ubicacion);

        if(aprobado = true){
            textID5.setText("");
            textNombre5.setText("");
            textContenido6.setText("");
        }
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar nota");
        }
        
    }//GEN-LAST:event_jButtonEliminar5ActionPerformed

    private void jButtonEliminar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminar6ActionPerformed
        
        String titulo;
        int ID;
        
        String ubicacion = "Nota 7";
        titulo = textNombre6.getText().trim();
        ID = Integer.parseInt(textID6.getText().trim());
                
        notasService.eliminarNota(ID, usuario, titulo, ubicacion);
        
        try{
            Boolean aprobado;
            aprobado = notasService.eliminarNota(ID, usuario, titulo, ubicacion);

        if(aprobado = true){
            textID6.setText("");
            textNombre6.setText("");
            textContenido7.setText("");
        }
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar nota");
        }
        
    }//GEN-LAST:event_jButtonEliminar6ActionPerformed

    private void jButtonEliminar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminar7ActionPerformed
        
        String titulo;
        int ID;
        
        String ubicacion = "Nota 8";
        titulo = textNombre7.getText().trim();
        ID = Integer.parseInt(textID7.getText().trim());
                
        notasService.eliminarNota(ID, usuario, titulo, ubicacion);
        
        try{
            Boolean aprobado;
            aprobado = notasService.eliminarNota(ID, usuario, titulo, ubicacion);

        if(aprobado = true){
            textID7.setText("");
            textNombre7.setText("");
            textContenido8.setText("");
        }
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar nota");
        }
        
    }//GEN-LAST:event_jButtonEliminar7ActionPerformed

    private void jButtonModificar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificar1ActionPerformed
        
       String ubicacion = "Nota 2";
       String tituloMod, contenidoMod;
       String color;
       String letra;
       
       tituloMod = textNombre1.getText().trim();
       contenidoMod = textContenido2.getText().trim();
       color = eleccionDeColor();
       letra = eleccionFuente();

       notasService.modificarNota(usuario, tituloMod, contenidoMod, ubicacion, color, letra);
        
    }//GEN-LAST:event_jButtonModificar1ActionPerformed

    private void jButtonModificar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificar2ActionPerformed
        
       String ubicacion = "Nota 3";
       String tituloMod, contenidoMod;
       String color;
       String letra;
       
       tituloMod = textNombre2.getText().trim();
       contenidoMod = textContenido3.getText().trim();
       color = eleccionDeColor();
       letra = eleccionFuente();

       notasService.modificarNota(usuario, tituloMod, contenidoMod, ubicacion, color, letra);
        
    }//GEN-LAST:event_jButtonModificar2ActionPerformed

    private void jButtonModificar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificar3ActionPerformed
       
       String ubicacion = "Nota 4";
       String tituloMod, contenidoMod;
       String color;
       String letra;
       
       tituloMod = textNombre3.getText().trim();
       contenidoMod = textContenido4.getText().trim();
       color = eleccionDeColor();
       letra = eleccionFuente();

       notasService.modificarNota(usuario, tituloMod, contenidoMod, ubicacion, color, letra);
        
    }//GEN-LAST:event_jButtonModificar3ActionPerformed

    private void jButtonModificar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificar4ActionPerformed
        
       String ubicacion = "Nota 5";
       String tituloMod, contenidoMod;
       String color;
       String letra;
 
       tituloMod = textNombre4.getText().trim();
       contenidoMod = textContenido5.getText().trim();
       color = eleccionDeColor();
       letra = eleccionFuente();

       notasService.modificarNota(usuario, tituloMod, contenidoMod, ubicacion, color, letra);
        
    }//GEN-LAST:event_jButtonModificar4ActionPerformed

    private void jButtonModificar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificar5ActionPerformed
        
       String ubicacion = "Nota 6";
       String tituloMod, contenidoMod;
       String color;
       String letra;
       
       tituloMod = textNombre5.getText().trim();
       contenidoMod = textContenido6.getText().trim();
       color = eleccionDeColor();
       letra = eleccionFuente();

       notasService.modificarNota(usuario, tituloMod, contenidoMod, ubicacion, color, letra);

    }//GEN-LAST:event_jButtonModificar5ActionPerformed

    private void jButtonModificar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificar6ActionPerformed
             
       String ubicacion = "Nota 7";
       String tituloMod, contenidoMod;
       String color;
       String letra;
       
       tituloMod = textNombre6.getText().trim();
       contenidoMod = textContenido7.getText().trim();
       color = eleccionDeColor();
       letra = eleccionFuente();

       notasService.modificarNota(usuario, tituloMod, contenidoMod, ubicacion, color, letra);

    }//GEN-LAST:event_jButtonModificar6ActionPerformed

    private void jButtonModificar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificar7ActionPerformed
        
       String ubicacion = "Nota 8";
       String tituloMod, contenidoMod;
       String color;
       String letra;
       
       tituloMod = textNombre7.getText().trim();
       contenidoMod = textContenido8.getText().trim();
       color = eleccionDeColor();
       letra = eleccionFuente();

       notasService.modificarNota(usuario, tituloMod, contenidoMod, ubicacion, color, letra);

    }//GEN-LAST:event_jButtonModificar7ActionPerformed

    private void jButtonCrear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrear1ActionPerformed

        String ubicacion = "Nota 2";
        
        String titulo = null, contenido = null;  
        int id = 0;
        String color;
        String letra;

        id = Integer.parseInt(textID1.getText().trim());
        titulo = textNombre1.getText().trim();
        contenido = textContenido2.getText().trim();
        color = eleccionDeColor();
        letra = eleccionFuente();
  
        notasService.crearNota(usuario, titulo, id, contenido, ubicacion, color, letra);
          
    }//GEN-LAST:event_jButtonCrear1ActionPerformed

    private void jButtonCrear2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrear2ActionPerformed
        
        String ubicacion = "Nota 3";
        
        String titulo = null, contenido = null;  
        int id = 0;
        String color;
        String letra;
        
           id = Integer.parseInt(textID2.getText().trim());
           titulo = textNombre2.getText().trim();
           contenido = textContenido3.getText().trim();
           color = eleccionDeColor();
           letra = eleccionFuente();
        
        notasService.crearNota(usuario, titulo, id, contenido, ubicacion, color, letra);
 
    }//GEN-LAST:event_jButtonCrear2ActionPerformed

    private void jButtonCrear3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrear3ActionPerformed
       
        String ubicacion = "Nota 4";
        
        String titulo = null, contenido = null;  
        int id = 0;
        String color;
        String letra;
        
        id = Integer.parseInt(textID3.getText().trim());
        titulo = textNombre3.getText().trim();
        contenido = textContenido4.getText().trim();
        color = eleccionDeColor();
        letra = eleccionFuente();
           
        notasService.crearNota(usuario, titulo, id, contenido, ubicacion, color, letra);
        
    }//GEN-LAST:event_jButtonCrear3ActionPerformed

    private void jButtonCrear4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrear4ActionPerformed
        
        String ubicacion = "Nota 5";
        
        String titulo = null, contenido = null;  
        int id = 0;
        String color;
        String letra;
        
        id = Integer.parseInt(textID4.getText().trim());
        titulo = textNombre4.getText().trim();
        contenido = textContenido5.getText().trim();
        color = eleccionDeColor();
        letra = eleccionFuente();
           
        notasService.crearNota(usuario, titulo, id, contenido, ubicacion, color, letra);
        
    }//GEN-LAST:event_jButtonCrear4ActionPerformed

    private void jButtonCrear5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrear5ActionPerformed
         
        String ubicacion = "Nota 6";
        
        String titulo = null, contenido = null;  
        int id = 0;
        String color;
        String letra;
        
        id = Integer.parseInt(textID5.getText().trim());
        titulo = textNombre5.getText().trim();
        contenido = textContenido6.getText().trim();
        color = eleccionDeColor();
        letra = eleccionFuente();
           
        notasService.crearNota(usuario, titulo, id, contenido, ubicacion, color, letra);
        
    }//GEN-LAST:event_jButtonCrear5ActionPerformed

    private void jButtonCrear6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrear6ActionPerformed
        
        String ubicacion = "Nota 7";
        
        String titulo = null, contenido = null;  
        int id = 0;
        String color, colorLetra;
        String letra;
        
        id = Integer.parseInt(textID6.getText().trim());
        titulo = textNombre6.getText().trim();
        contenido = textContenido7.getText().trim();
        color = eleccionDeColor();
        letra = eleccionFuente();
           
        notasService.crearNota(usuario, titulo, id, contenido, ubicacion, color, letra);
        
    }//GEN-LAST:event_jButtonCrear6ActionPerformed

    private void jButtonCrear7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrear7ActionPerformed
       
        String ubicacion = "Nota 8";
        
        String titulo = null, contenido = null;  
        int id = 0;
        String color, colorLetra;
        String letra;
        
        id = Integer.parseInt(textID7.getText().trim());
        titulo = textNombre7.getText().trim();
        contenido = textContenido8.getText().trim();
        color = eleccionDeColor();
        letra = eleccionFuente();
           
        notasService.crearNota(usuario, titulo, id, contenido, ubicacion, color, letra);
        
    }//GEN-LAST:event_jButtonCrear7ActionPerformed

    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed
        
        String color = eleccionDeColor();
        
        cambioDeColor(color, textContenido, textID, textNombre, jButtonCrear, 
                jButtonModificar, Nota1);
        
    }//GEN-LAST:event_jButtonActualizarActionPerformed

    private void jButtonActualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizar1ActionPerformed
        
        String color = eleccionDeColor();

        cambioDeColor(color, textContenido2, textID1, textNombre1,
                jButtonCrear1, jButtonModificar1, Nota2);

    }//GEN-LAST:event_jButtonActualizar1ActionPerformed

    private void jButtonActualizar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizar2ActionPerformed
       
        String color = eleccionDeColor();

        cambioDeColor(color, textContenido3, textID2, textNombre2,
                jButtonCrear2, jButtonModificar2, Nota3);

    }//GEN-LAST:event_jButtonActualizar2ActionPerformed

    private void jButtonActualizar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizar3ActionPerformed
       
        String color = eleccionDeColor();
        
        cambioDeColor(color, textContenido4, textID3, textNombre3,
                jButtonCrear3, jButtonModificar3, Nota4);

    }//GEN-LAST:event_jButtonActualizar3ActionPerformed

    private void jButtonActualizar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizar4ActionPerformed
        
        String color = eleccionDeColor();
        
        cambioDeColor(color, textContenido5, textID4, textNombre4,
                jButtonCrear4, jButtonModificar4, Nota5);

    }//GEN-LAST:event_jButtonActualizar4ActionPerformed

    private void jButtonActualizar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizar5ActionPerformed
       
      String color = eleccionDeColor();
        
      cambioDeColor(color, textContenido6, textID5, textNombre5,
                jButtonCrear5, jButtonModificar5, Nota6);
        
    }//GEN-LAST:event_jButtonActualizar5ActionPerformed

    private void jButtonActualizar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizar6ActionPerformed
 
      String color = eleccionDeColor();
        
      cambioDeColor(color, textContenido7, textID6, textNombre6,
                jButtonCrear6, jButtonModificar6, Nota7);
      
    }//GEN-LAST:event_jButtonActualizar6ActionPerformed

    private void jButtonActualizar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizar7ActionPerformed
      
      String color = eleccionDeColor();
        
      cambioDeColor(color, textContenido8, textID7, textNombre7,
                jButtonCrear7, jButtonModificar7, Nota8);
       
    }//GEN-LAST:event_jButtonActualizar7ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        this.setSize(1050, 800);
        jPanelConfiguracion.setVisible(false);

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButtonNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNotaActionPerformed

    }//GEN-LAST:event_jButtonNotaActionPerformed

    private void jButtonNotaLetraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNotaLetraActionPerformed


    }//GEN-LAST:event_jButtonNotaLetraActionPerformed

    private void cmbFuenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFuenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbFuenteActionPerformed

    private void jButtonConfirmacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmacionActionPerformed

        try{
            String ubicacion = obtenerNotaUbicacion();
            JTextPane cajaContenido = cajaContenidoSegunUbi(ubicacion);
            JTextField cajaID = cajaIDSegunUbi(ubicacion), 
                    cajaNombre = cajaNombreSegunUbi(ubicacion);
            JButton cajaCrear = cajaCrearSegunUbi(ubicacion), 
                    cajaModificar = cajaModificarSegunUbi(ubicacion);
            JPanel cajaPanel = cajaPanelSegunUbi(ubicacion);
            
            
            String color = eleccionDeColor();
            JOptionPane.showMessageDialog(null, color);
            cambioDeColor(color, cajaContenido, cajaID, cajaNombre, cajaCrear, 
                    cajaModificar, cajaPanel);
            
            notasService.cambiarColorNota(usuario, ubicacion, color);  
           
            String letra = eleccionFuente();
            Font fuente = cambioFuente(letra);
            JOptionPane.showMessageDialog(null, letra + " + " + fuente);
            cajaContenido.setFont(fuente);
            
            
            notasService.cambiarFuenteNota(usuario, ubicacion, letra);

            JOptionPane.showMessageDialog(null, "Cambio de letra y color éxitoso");
        }catch(Exception e){
            System.err.println("No se puede cambiar la letra ni color " + e);
            JOptionPane.showMessageDialog(null, "No es posible cambiar el diseño de la nota");
        }
        
       

    }//GEN-LAST:event_jButtonConfirmacionActionPerformed

    private void jToggleButtonCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonCambioActionPerformed

        String ubicacion = obtenerNotaUbicacion();
        JTextPane cajaContenido = cajaContenidoSegunUbi(ubicacion);
        JTextField cajaID =  cajaIDSegunUbi(ubicacion);
        JTextField cajaNombre =  cajaNombreSegunUbi(ubicacion);
        JButton cajaCrear = cajaCrearSegunUbi(ubicacion);
        JButton cajaModificar = cajaModificarSegunUbi(ubicacion);
        JPanel cajaPanel = cajaPanelSegunUbi(ubicacion);
    
        String color = eleccionDeColor(); 
        JOptionPane.showMessageDialog(null, color);
        
        cambioDeColor(color, cajaContenido, cajaID, cajaNombre, cajaCrear, cajaModificar, 
            cajaPanel);

    }//GEN-LAST:event_jToggleButtonCambioActionPerformed

    private void jMenuItemListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListaActionPerformed
        
        ListaNotas listaNotas = new ListaNotas();
        listaNotas.setVisible(true);
        
    }//GEN-LAST:event_jMenuItemListaActionPerformed

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
            java.util.logging.Logger.getLogger(StickyNotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StickyNotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StickyNotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StickyNotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StickyNotes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Nota1;
    private javax.swing.JPanel Nota2;
    private javax.swing.JPanel Nota3;
    private javax.swing.JPanel Nota4;
    private javax.swing.JPanel Nota5;
    private javax.swing.JPanel Nota6;
    private javax.swing.JPanel Nota7;
    private javax.swing.JPanel Nota8;
    private javax.swing.JComboBox<String> cmbFuente;
    private javax.swing.JComboBox<String> cmbNota;
    private javax.swing.ButtonGroup grupoColores;
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JButton jButtonActualizar1;
    private javax.swing.JButton jButtonActualizar2;
    private javax.swing.JButton jButtonActualizar3;
    private javax.swing.JButton jButtonActualizar4;
    private javax.swing.JButton jButtonActualizar5;
    private javax.swing.JButton jButtonActualizar6;
    private javax.swing.JButton jButtonActualizar7;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonConfiguracion;
    private javax.swing.JButton jButtonConfiguracion1;
    private javax.swing.JButton jButtonConfiguracion2;
    private javax.swing.JButton jButtonConfiguracion3;
    private javax.swing.JButton jButtonConfiguracion4;
    private javax.swing.JButton jButtonConfiguracion5;
    private javax.swing.JButton jButtonConfiguracion6;
    private javax.swing.JButton jButtonConfiguracion7;
    private javax.swing.JButton jButtonConfirmacion;
    private javax.swing.JButton jButtonCrear;
    private javax.swing.JButton jButtonCrear1;
    private javax.swing.JButton jButtonCrear2;
    private javax.swing.JButton jButtonCrear3;
    private javax.swing.JButton jButtonCrear4;
    private javax.swing.JButton jButtonCrear5;
    private javax.swing.JButton jButtonCrear6;
    private javax.swing.JButton jButtonCrear7;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonEliminar1;
    private javax.swing.JButton jButtonEliminar2;
    private javax.swing.JButton jButtonEliminar3;
    private javax.swing.JButton jButtonEliminar4;
    private javax.swing.JButton jButtonEliminar5;
    private javax.swing.JButton jButtonEliminar6;
    private javax.swing.JButton jButtonEliminar7;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonModificar1;
    private javax.swing.JButton jButtonModificar2;
    private javax.swing.JButton jButtonModificar3;
    private javax.swing.JButton jButtonModificar4;
    private javax.swing.JButton jButtonModificar5;
    private javax.swing.JButton jButtonModificar6;
    private javax.swing.JButton jButtonModificar7;
    private javax.swing.JButton jButtonNota;
    private javax.swing.JButton jButtonNotaLetra;
    private javax.swing.JButton jButtonVolverAtras;
    private javax.swing.JCheckBox jCheckBoxActivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelAviso1;
    private javax.swing.JLabel jLabelID1;
    private javax.swing.JLabel jLabelID2;
    private javax.swing.JLabel jLabelID3;
    private javax.swing.JLabel jLabelID4;
    private javax.swing.JLabel jLabelID5;
    private javax.swing.JLabel jLabelID6;
    private javax.swing.JLabel jLabelID7;
    private javax.swing.JLabel jLabelNum;
    private javax.swing.JLabel jLabelNum1;
    private javax.swing.JLabel jLabelNum2;
    private javax.swing.JLabel jLabelNum3;
    private javax.swing.JLabel jLabelNum4;
    private javax.swing.JLabel jLabelNum5;
    private javax.swing.JLabel jLabelNum6;
    private javax.swing.JLabel jLabelNum7;
    private javax.swing.JLabel jLabelWallpaper;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItemLista;
    private javax.swing.JMenu jMenuNombre;
    private javax.swing.JMenu jMenuNotas;
    private javax.swing.JMenu jMenuVacio;
    private javax.swing.JPanel jPanelConfiguracion;
    private javax.swing.JPanel jPanelOpciones;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JToggleButton jToggleButtonCambio;
    private javax.swing.JTextField textBusqueda;
    private javax.swing.JTextField textColorLetra;
    private javax.swing.JTextField textColorNota;
    private javax.swing.JTextPane textContenido;
    private javax.swing.JTextPane textContenido2;
    private javax.swing.JTextPane textContenido3;
    private javax.swing.JTextPane textContenido4;
    private javax.swing.JTextPane textContenido5;
    private javax.swing.JTextPane textContenido6;
    private javax.swing.JTextPane textContenido7;
    private javax.swing.JTextPane textContenido8;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textID1;
    private javax.swing.JTextField textID2;
    private javax.swing.JTextField textID3;
    private javax.swing.JTextField textID4;
    private javax.swing.JTextField textID5;
    private javax.swing.JTextField textID6;
    private javax.swing.JTextField textID7;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textNombre1;
    private javax.swing.JTextField textNombre2;
    private javax.swing.JTextField textNombre3;
    private javax.swing.JTextField textNombre4;
    private javax.swing.JTextField textNombre5;
    private javax.swing.JTextField textNombre6;
    private javax.swing.JTextField textNombre7;
    // End of variables declaration//GEN-END:variables
}
