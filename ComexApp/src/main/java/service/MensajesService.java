package service;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Daniela
 */
public interface MensajesService {
    
    public void mensajeErrorAlIniciarSesion();
    
    public void mensajeIngresandoAlSistema();

    public void avisoEsperarConfirmacionDeAcceso(String usuario);
    
    public void notificacionMensajesDeObjetivosSinVer(String titulo, Date 
            fechaPublicacion, Time horaPublicacion);
    
    public void notificacionOperacionesInternacionalesDelDia(int 
            cantidadOperacionesInternacionales);
    
    public void notificacionOperacionesNacionalesDelDia(int 
            cantidadOperacionesNacionales);
    
    public void notificacionUsuariosSolicitandoAccesoAlSistema(String usuario, 
            String usuarioSolicitando);
}
