package service;

/**
 *
 * @author Daniela
 */
public interface OperacionesInternacionalesImpl {
    
     public boolean ingresoOperacionInternacional(int ID, int cantidadContenedor,
            String codigo, String fechaOperacion, String numeroEmbarque, String producto,
            String tipoOperacion, String cantidadProducto, String fechaETA, String status,
            String comprador, String precioTotal, String vendedor, String detalles,
            String paisOrigen, String nombreBuque);
     
     public void modificarOperacionInternacional(int IDMod, int cantidadContenedorMod,
            String codigoMod, String fechaOperacionMod, String numeroEmbarqueMod, 
            String productoMod, String tipoOperacionMod, String cantidadProductoMod, 
            String fechaETAMod, String statusMod, String compradorMod, 
            String precioTotalMod, String vendedorMod, String detallesMod,
            String paisOrigenMod, String nombreBuqueMod, String producto);
     
      public boolean eliminarOperacion (String producto, int id);
}
