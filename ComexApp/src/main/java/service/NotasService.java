package service;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 *
 * @author Daniela
 */
public interface NotasService {
    
    public void crearNota(String usuario, String titulo, int id, String contenido, 
            String ubicacion, String colorElegido, String letraElegida);
    
    public void cambiarStatusNota(String usuario, String titulo, int id);
    
    public void modificarNota(String usuario, String tituloMod, String contenidoMod, 
            String ubicacionMod, String color, String letra);
    
    public void notaInactiva(String titulo, String ubicacion, String usuario);
    
    public void modificarUbicacionNota(String ubicacion, String usuario, String titulo);
    
    public void obtenerNota1(String usuario, JTextField textID, 
            JTextField textNombre, JTextPane textContenido);
    
    public void obtenerNota2(String usuario, JTextField textID1, 
            JTextField textNombre1, JTextPane textContenido2, JPanel Nota2, 
            JButton jButtonAgregar1, JButton jButtonModificar1);
    
    public void obtenerNota3(String usuario, JTextField textID2, 
            JTextField textNombre2, JTextPane textContenido3, JPanel Nota3, 
            JButton jButtonAgregar2, JButton jButtonModificar2);
    
    public void obtenerNota4(String usuario, JTextField textID3, 
            JTextField textNombre3, JTextPane textContenido4, JPanel Nota4, 
            JButton jButtonAgregar3, JButton jButtonModificar3);
    
    public void obtenerNota5(String usuario, JTextField textID4, 
            JTextField textNombre4, JTextPane textContenido5, JPanel Nota5, 
            JButton jButtonAgregar4, JButton jButtonModificar4);
    
    public void obtenerNota6(String usuario, JTextField textID5, 
            JTextField textNombre5, JTextPane textContenido6, JPanel Nota6, 
            JButton jButtonAgregar5, JButton jButtonModificar5);
    
    public void obtenerNota7(String usuario, JTextField textID6, 
            JTextField textNombre6, JTextPane textContenido7, JPanel Nota7, 
            JButton jButtonAgregar6, JButton jButtonModificar6);
    
    public void obtenerNota8(String usuario, JTextField textID7, 
            JTextField textNombre7, JTextPane textContenido8, JPanel Nota8, 
            JButton jButtonAgregar7, JButton jButtonModificar7);
    
    public void obtenerNotaPedida(String usuario, JTextField textID, 
            JTextField textNombre, JTextPane textContenido);
    
    public String obtencionColorNota(String usuario, String ubicacion);
    
    public String obtencionFuenteNota(String usuario, String ubicacion);
    
    public void cambiarColorNota (String usuario, String ubicacion, String color);
    
    public void cambiarFuenteNota (String usuario, String ubicacion, String letra);
    
    public boolean eliminarNota(int ID, String usuario, String titulo, String ubicacion);
}
