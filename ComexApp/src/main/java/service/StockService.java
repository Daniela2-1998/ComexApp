package service;

/**
 *
 * @author Daniela
 */
public interface StockService {
    
    
    public boolean ingresoNuevoProductoAStock(int ID,  String codigo, String cuidados,
            String detalle, String paisOrigen, String precioUnitario, 
            String tipoProducto, String producto);
    
    public boolean ingresoNuevoProductoAStockBasico(String producto, 
             String cantidad, String comprador, String vendedor);
    
    public int obtenerCantidadDeBaseDeDatos(String producto);

    public int nuevaCantidadProductosOperacionInternacional(int cantidadProducto, 
            String producto, int id);
    
    public int nuevaCantidadProductosOperacionNacional(int cantidadProducto, 
            String producto, int id);
    
    public void asociarCantidadesAOperacionInternacional(String producto, String vendedor, 
            String codigo, int idOperacion);
    
    public void asociarCantidadesAOperacionNacional(String producto, String vendedor, 
            String codigo, int idOperacion);
    
    public void modificarStock(int IDMod, String cantidadMod, String codigoMod, 
            String cuidadosMod, String detalleMod, String paisOrigenMod, 
            String precioUnitarioMod, String statusMod, String tipoProductoMod, 
            String productoMod, String producto);
    
    public int obtenerIDProducto(String codigo, String vendedor, String producto);
    
    public void actualizacionDelProducto(String producto, String codigo, String vendedor);
    
    public boolean eliminarProductoDeStock(String producto, int id);
}
