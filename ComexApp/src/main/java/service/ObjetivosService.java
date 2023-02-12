package service;

import java.sql.Date;
import javax.swing.JLabel;
import javax.swing.JTextArea;



/**
 *
 * @author Daniela
 */
public interface ObjetivosService {
    
    public boolean establecerObjetivo(int ID, String descripcion, String fechaLimite, 
            Date fechaRegistro, String nivelImportancia, String objetivo, 
            String status, String usuario, String visibilidad, Date fechaObjetivo);
    
    public void obtenerObjetivos(JLabel jLabelObjetivoRec1, JLabel jLabelFechaPub1, 
            JTextArea textDetalles1, JLabel jLabelImportancia1, JLabel jLabelFechaObj1, 
            JLabel jLabelID1, String sql);
    
    public String recuperarNivelImportancia(int ID);
    
    public void cambiarStatusDeObjetivosConFechaCumplida();
    
    public boolean eliminarObjetivo(String usuario, int id);
}
