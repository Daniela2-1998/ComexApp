package service;

import java.sql.Date;

/**
 *
 * @author Daniela
 */
public interface OperacionesInternacionalesService {
    
    public boolean ingresoOperacionInternacional(int ID, int cantidadContenedor,
            String codigo, String numeroEmbarque, String producto,
            String tipoOperacion, String cantidadProducto, String status,
            String comprador, String precioTotal, String vendedor, String detalles,
            String paisOrigen, String nombreBuque, Date fechaRegistro, Date fechaArribo);
     
    public void modificarOperacionInternacional(int IDMod, int cantidadContenedorMod,
            String codigoMod, String numeroEmbarqueMod, 
            String productoMod, String tipoOperacionMod, String cantidadProductoMod, 
            String statusMod, String compradorMod, String precioTotalMod, 
            String vendedorMod, String detallesMod, String paisOrigenMod, 
            String nombreBuqueMod, String producto);
    
    public void modificarFechaIngreso(int ID, String producto, Date fechaArriboMod);
    
    public void cambiarStatusCuandoIngresaProducto();
     
    public boolean eliminarOperacion (String producto, int id);
}
