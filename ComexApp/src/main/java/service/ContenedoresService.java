package service;

import java.sql.Date;

/**
 *
 * @author Daniela
 */
public interface ContenedoresService {
    
    public boolean registrarContenedor(int ID, int cantidadProductos, double capacidad, 
            String codigo, String empresa, String producto, String tipo, 
            String compañiaTransporte, Date proximoControl, String reserva, 
            String status, Date ultimoControl);
    
    public void modificarContenedor(int IDMod, int cantidadProductosMod, double capacidadMod, 
            String codigoMod, String empresaMod, String productoMod, String tipoMod, 
            String compañiaTransporteMod, String reservaMod, String statusMod,  String codigo);
    
    public void modificarFechasProximo(Date proximoControlMod, String codigo);
    
    public void modificarFechaUltimo(Date ultimoControlMod, String codigo);
    
    public int obtenerIDConCodigoDelContenedor(String codigo);
    
    public boolean eliminarRegistroContenedor(String codigo, int id);
   
}
