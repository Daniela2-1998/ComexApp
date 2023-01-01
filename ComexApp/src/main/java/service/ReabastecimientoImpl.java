package service;

import java.util.Calendar;

/**
 *
 * @author Daniela
 */
public interface ReabastecimientoImpl {
    
    
    public boolean ingresoSuministrosReabastecimiento(int ID, String cuidados,
            String detalle, String paisOrigen, String precioUnitario, String precioTotal,
            String cantidad, String tipoProducto, String producto, 
            String fechaRegistro, String fechaRecibo);
    
     public void obtenerDatosTablas(String producto);
     
     public void modificarSuministros(int IDMod, String cantidadMod, String precioTotalMod, 
            String cuidadosMod, String detalleMod, String paisOrigenMod, 
            String precioUnitarioMod, String statusMod, String tipoProductoMod, 
            String fechaRegistroMod, String fechaReciboMod, String descuentoMod,
            String destinoMod, String productoMod, String producto);
     
     
     public boolean eliminarSuministros(String producto, int id);
}
