package service;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Daniela
 */
public interface GastosService {
    
    public boolean registrarGasto(String conceptos, String empresa, double gastosTotales, 
            int cuotas, String detalles, double gastosPagados, double gastosSinPagar, 
            double montoCuotas, double intereses, String status);
    
    public void modificarGasto(String conceptos, String empresa, double gastosTotales, 
            int cuotas, String detalles, double gastosPagados, double gastosSinPagar, 
            double montoCuotas, String status, double intereses, String conceptoBuscado);
    
    public void obtenerGasto(String buscar, JTextField textValorCuotas, 
            JTextField textTotal, JTextField textConcepto, JTextField textPagado,
            JTextArea textDetalles, JComboBox cmbStatus, JComboBox cmbCuotas,
            JTextField textSinPagar, JTextField textID);
    
    public boolean eliminarGasto(String concepto, int id);
             
}

