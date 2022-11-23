package service;

import javax.swing.JOptionPane;

/**
 *
 * @author Daniela
 */
public class Botones implements BotonesImpl{

    @Override
    public void botonSalirSistema() {
        String botones[] = {"Cerrar", "Cancelar"};
        
        int eleccion = JOptionPane.showOptionDialog(null, "Estás por salir del sistema, ¿deseas hacerlo?", "Salir del sistema", 0, 0, null, botones, this);
       
        if(eleccion == JOptionPane.YES_OPTION){
            System.exit(0);
        } else if(eleccion == JOptionPane.NO_OPTION){
            System.out.println("Se canceló el cierre, continuarás en el sistema");
            JOptionPane.showMessageDialog(null, "Se canceló el cierre, continuarás en el sistema");
        }
    }

    @Override
    public void botonCerrarVentana() {
       
    }

    
}
