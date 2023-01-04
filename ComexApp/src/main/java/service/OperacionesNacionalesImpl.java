package service;

/**
 *
 * @author Daniela
 */
public interface OperacionesNacionalesImpl {
    
    public boolean ingresoOperacionNacional(int ID, String CUIT, String empleado,
            String empresa, String mail, String numeroContacto, String productos,
            String cantidadProductos, String comprador, String fechaETA, String fechaOperacion, 
            String precioTotal, String vendedor, String status, String tipoOperacion);
    
    public void modificarOperacionInternacional(int IDMod, String CUITMod, 
            String empleadoMod, String empresaMod, String mailMod, String numeroContactoMod, 
            String productosMod, String cantidadProductosMod, String compradorMod, 
            String precioTotalMod, String vendedorMod, String status, String tipoOperacion, 
            String fechaOperacionMod, String fechaETAMod, String producto);
    
    public boolean eliminarOperacion (String producto, int id);
}
