package service;

import javax.swing.JTextField;


/**
 *
 * @author Daniela
 */
public interface ReportesEstadisticasVentaLocalService {

    public int cantidadDeOperacionesDeVentaTotales();
    
    public String compradorMasRepetido();
    
    public String productoMasVendido();
    
    public void productosMasExportados(JTextField textProducto1, JTextField textProducto2, 
            JTextField textProducto3, JTextField textProducto4, JTextField textProducto5);
    
    
}
