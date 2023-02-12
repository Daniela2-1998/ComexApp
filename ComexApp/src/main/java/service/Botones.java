package service;

import javax.swing.JOptionPane;

/**
 *
 * @author Daniela
 */
public class Botones implements BotonesService{

    Boolean aprobado;
    
    @Override
    public Boolean botonSalirSistema() {
       
        Boolean aprobado = null;
        String botones[] = {"Cerrar", "Cancelar"};
        
        int eleccion = JOptionPane.showOptionDialog(null, "Estás por salir del "
                + "sistema, ¿deseas hacerlo?", "Salir del sistema", 0, 0, null, 
                botones, this);
       
        if(eleccion == JOptionPane.YES_OPTION){
            aprobado = true;
        } else if(eleccion == JOptionPane.NO_OPTION){
            aprobado = false;
        }
        return aprobado;
    }

    @Override
    public void botonCerrarVentana() {
       
    }

    
}
