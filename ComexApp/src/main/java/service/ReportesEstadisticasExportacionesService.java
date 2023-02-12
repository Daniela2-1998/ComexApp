package service;

import javax.swing.JTextField;



/**
 *
 * @author Daniela
 */
public interface ReportesEstadisticasExportacionesService {

    public int cantidadDeOperacionesDeExportacionTotales();
    
    public String compradorMasRepetido();
    
    public String productoMasExportado();
    
    public void productosMasExportados(JTextField textProducto1, JTextField textProducto2, 
            JTextField textProducto3, JTextField textProducto4, JTextField textProducto5);
    
    
}
