package service;

import javax.swing.JLabel;

/**
 *
 * @author Daniela
 */
public class TiemposImpl {
    
    public void aplicarCuentaAtras(JLabel jLabelTiempo, int horas, int minutos, 
            int segundos) throws InterruptedException{
        
        while(!(horas == 0 && minutos == 0 && segundos == 0)){

                if(horas < 10 && minutos < 10 && segundos < 10){
                    jLabelTiempo.setText("0" + horas + ":" + "0" + minutos + ":" + "0" + segundos);
                    System.out.println("0" + horas + ":" + "0" + minutos + ":" + "0" + segundos);
                } else if (horas < 10 && minutos < 10 && segundos > 10){
                    jLabelTiempo.setText("0" + horas + ":" + "0" + minutos + ":" + segundos);
                    System.out.println("0" + horas + ":" + "0" + minutos + ":" + segundos);
                } else if (horas < 10 && minutos > 10 && segundos < 10){
                    jLabelTiempo.setText("0" + horas + ":" + minutos + ":" + "0" + segundos);
                    System.out.println("0" + horas + ":" + minutos + ":" + "0" + segundos);
                } else if (horas < 10 && minutos > 10 && segundos > 10){
                    jLabelTiempo.setText("0" + horas + ":" + minutos + ":" + segundos);
                    System.out.println("0" + horas + ":" + minutos + ":" + segundos);
                } else if (horas > 10 && minutos > 10 && segundos > 10){
                    jLabelTiempo.setText(horas + ":" + minutos + ":" + segundos);
                    System.out.println(horas + ":" + minutos + ":" + segundos);
                } else if (horas > 10 && minutos < 10 && segundos < 10){
                    jLabelTiempo.setText(horas + ":" + "0" + minutos + ":" + "0" + segundos);
                    System.out.println(horas + ":" + "0" + minutos + ":" + "0" + segundos);
                }
 
            if (segundos == 0) {

                if (minutos == 0) {
                    horas--;
                    minutos = 59;
                    segundos = 59;
                } else if (minutos != 0) {
                    minutos--;
                    segundos = 59;
                }

            } else {
                segundos--;
            }
            
            Thread.sleep(1000);
        }
    }
}
