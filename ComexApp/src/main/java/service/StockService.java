package service;

/**
 *
 * @author Daniela
 */
public interface StockService {
    
    
    public boolean ingresoNuevoProductoAStock(int ID,  String codigo, String cuidados,
            String detalle, String paisOrigen, String precioUnitario, 
            String tipoProducto, String producto);
    
    public int obtenerCantidadDeBaseDeDatos(String producto);

    public void modificarStock(int IDMod, String cantidadMod, String codigoMod, 
            String cuidadosMod, String detalleMod, String paisOrigenMod, 
            String precioUnitarioMod, String statusMod, String tipoProductoMod, 
            String productoMod, String producto);
    
    public int obtenerIDProducto(String codigo, String vendedor, String producto);
    
    public boolean eliminarProductoDeStock(String producto, int id);
}
