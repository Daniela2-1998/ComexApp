package service;

import java.sql.Date;
import java.sql.Time;
import javax.swing.JLabel;

/**
 *
 * @author Daniela
 */
public interface TiemposService {
    
    public void guardarTiempoRecordatorio(int horas, int minutos, int segundos, 
            Date dia, String detalle);
    
    public void aplicarCuentaAtras(JLabel jLabelTiempo, int horas, int minutos, 
            int segundos) throws InterruptedException;
    
    public void guardarTiempoCuenta(int horas, int minutos, int segundos, String tipo, 
            String detalle);
    
    public void guardarTiempoCron(String tipo, String detalle);
    
    public void obtenerTiempoDePausadoOFin(String asunto);
    
    public void calcularTiempoPasado(String asunto);
    
    public boolean verSiExisteID(int ID);
    
    public int recuperarMaximoID();
    
    public Boolean verificarCuentasRegresivasCumplidas(Date diaObjetivo, Time tiempoObjetivo);
    
    
    
}
