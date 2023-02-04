package service;

import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author Daniela
 */
public interface ReabastecimientoService {
    
    
    public boolean ingresoSuministrosReabastecimiento(int ID, String cuidados,
            String detalle, String paisOrigen, String precioUnitario, String precioTotal,
            String cantidad, String tipoProducto, String producto, 
            Date fechaRegistro, Date fechaRecibo);
    
    public void obtenerDatosTablas(String producto);
     
    public void modificarSuministros(int IDMod, String cantidadMod, String precioTotalMod, 
            String cuidadosMod, String detalleMod, String paisOrigenMod, 
            String precioUnitarioMod, String statusMod, String tipoProductoMod, 
            String descuentoMod, String destinoMod, String productoMod, String producto);
    
    public void modificarFechaIngreso(int ID, String producto, Date fechaIngresoMod);
    
    public void cambiarStatusCuandoIngresaProducto();
     
    public boolean eliminarSuministros(String producto, int id);
}
