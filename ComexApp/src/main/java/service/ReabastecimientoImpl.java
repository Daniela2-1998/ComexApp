package service;

import java.util.Calendar;

/**
 *
 * @author Daniela
 */
public interface ReabastecimientoImpl {
    
    
    public boolean ingresoSuministrosReabastecimiento(int ID, String cuidados,
            String detalle, String paisOrigen, String precioUnitario, String precioTotal,
            String tipoProducto, String producto, Calendar fechaRegistro, Calendar fechaRecibo);
}
