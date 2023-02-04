package service;

import java.sql.Date;

/**
 *
 * @author Daniela
 */
public interface OperacionesNacionalesService {
    
    public boolean ingresoOperacionNacional(int ID, String CUIT, String empleado,
            String empresa, String mail, String numeroContacto, String productos,
            String cantidadProductos, String comprador, String precioTotal, 
            String vendedor, String status, String tipoOperacion, Date fechaRegistro, 
            Date fechaArribo);
    
    public void modificarOperacionInternacional(int IDMod, String CUITMod, 
            String empleadoMod, String empresaMod, String mailMod, String numeroContactoMod, 
            String productosMod, String cantidadProductosMod, String compradorMod, 
            String precioTotalMod, String vendedorMod, String status, String tipoOperacion, 
            String producto);
    
    public void modificarFechaIngreso(int ID, String producto, Date fechaIngresoMod);
    
    public void cambiarStatusCuandoIngresaProducto();
    
    public boolean eliminarOperacion (String producto, int id);
}
