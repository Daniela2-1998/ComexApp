package service;

import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author Daniela
 */
public interface PreguntasSeguridadService {
    
    public boolean crearPreguntasDeSeguridad(int ID, String usuario, String nombre, 
            String preguntaUno, String preguntaDos, String preguntaTres,
            String eleccionUno, String eleccionDos, String eleccionTres);
    
    public void modificarDatosContactoAgendaPersonal(String preguntaUnoMod, 
              String preguntaDosMod, String preguntaTresMod, String eleccionUnoMod, 
              String eleccionDosMod, String eleccionTresMod, String nombre, String usuario);
    
    public void recuperarLasPreguntasDeSeguridadYSusRespuestas(JTextField textPreguntaUno, 
            JTextField textPreguntaDos, JTextField textPreguntaTres, 
            JComboBox cmbPreguntaUno, JComboBox cmbPreguntaDos, JComboBox cmbPreguntaTres,
            String usuario, String nombre);
    
    public String recuperarPreguntaUno(String usuario, String nombre);
    
    public String recuperarPreguntaDos(String usuario, String nombre);
    
    public String recuperarPreguntaTres(String usuario, String nombre);
    
    public String recuperoEleccionUno(String usuario);
    
    public String recuperoEleccionDos(String usuario);
    
    public String recuperoEleccionTres(String usuario);
    
    public String recuperarContraseña(String usuario);
    
    public boolean eliminarPreguntasDeSeguridad(String nombre, int id);
    
    
}
