package service;

import config.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniela
 */
public class TiemposImpl implements TiemposService{
    
    // conexión
    Conexion cn = new Conexion();
    Connection conec;
    PreparedStatement pst;
    ResultSet rs;
    
    Boolean existeID, hay;
    int maximoID;
    
    public void guardarTiempoRecordatorio(int horas, int minutos, int segundos, Date dia, String detalle){
        
        Date diaActual = Date.valueOf(LocalDate.now());
        Time horaActual = Time.valueOf(LocalTime.now());
        
        String tipo = "Recordatorio";
        
        int ID = recuperarMaximoID() + 1;
        Boolean yaExiste = verSiExisteID(ID);
        int IDFinal = 0;
        
        if(yaExiste.equals(true)){
            IDFinal = ID + 1;
            verSiExisteID(IDFinal);
        } else if (yaExiste.equals(false)){
            IDFinal = ID;
        }

        String tiempoObjetivos = horas + ":" + minutos + ":" + segundos;
        Time tiempoObjetivo = Time.valueOf(tiempoObjetivos);
        
        
        String sql = "insert into tiempos values(?, ?, ?, ?, ?, ?, ?)";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            
            pst.setInt(1, IDFinal);
            pst.setString(2, detalle);
            pst.setString(3, tipo);            
            pst.setDate(4, diaActual);
            pst.setDate(5, dia);
            pst.setTime(6, horaActual);
            pst.setTime(7, tiempoObjetivo);
            pst.executeUpdate();
            conec.close();
            
        }catch(SQLException e){
           System.err.print("No podemos guardar tu tiempo en la base de datos " + e);
        }
    }

    public void aplicarCuentaAtras(JLabel jLabelTiempo, int horas, int minutos, 
            int segundos) throws InterruptedException{
        
        while(!(horas == 0 && minutos == 0 && segundos == 0)){
            
            jLabelTiempo.setText("Te avisaremos al cumplir el tiempo");
            
            if (horas < 10 && minutos < 10 && segundos < 10) {
                System.out.println("0" + horas + ":" + "0" + minutos + ":" + "0" + segundos);
            } else if (horas < 10 && minutos < 10 && segundos > 10) {
                System.out.println("0" + horas + ":" + "0" + minutos + ":" + segundos);
            } else if (horas < 10 && minutos > 10 && segundos < 10) {
                System.out.println("0" + horas + ":" + minutos + ":" + "0" + segundos);
            } else if (horas < 10 && minutos > 10 && segundos > 10) {
                System.out.println("0" + horas + ":" + minutos + ":" + segundos);
            } else if (horas > 10 && minutos > 10 && segundos > 10) {
                System.out.println(horas + ":" + minutos + ":" + segundos);
            } else if (horas > 10 && minutos < 10 && segundos < 10) {
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
             if (horas == 0 && minutos == 0 && segundos == 0 ){
                jLabelTiempo.setText("Tiempo cumplido");
            }
        }
    }
    
    
    public void guardarTiempoCuenta(int horas, int minutos, int segundos, String tipo, 
            String detalle){
        
        Date diaActual = Date.valueOf(LocalDate.now());
        Time horaActual = Time.valueOf(LocalTime.now());
        
        int ID = recuperarMaximoID() + 1;
        Boolean yaExiste = verSiExisteID(ID);
        int IDFinal = 0;
        
        if(yaExiste.equals(true)){
            IDFinal = ID + 1;
            verSiExisteID(IDFinal);
        } else if (yaExiste.equals(false)){
            IDFinal = ID;
        }
        
        Date diaObjetivo = null;
        Time tiempoObjetivo = null;
        int horaExacta = LocalTime.now().getHour();
        int horasSumadas = horaExacta + horas;

        if(horas == 0){
            tiempoObjetivo = Time.valueOf(LocalTime.now().plusMinutes(minutos).plusSeconds(segundos));
        } 
        if (horasSumadas >= 24){
            int horasDiaNuevo;
            if(horasSumadas == 24){
                diaObjetivo = Date.valueOf(LocalDate.now().plusDays(1));
                horasDiaNuevo = horasSumadas - 24;
            } else if(horasSumadas > 48){
                diaObjetivo = Date.valueOf(LocalDate.now().plusDays(2));
                horasDiaNuevo = horasSumadas - 48;
            } else if (horasSumadas > 72){
                diaObjetivo = Date.valueOf(LocalDate.now().plusDays(3));
                horasDiaNuevo = horasSumadas - 72;
            } else if (horasSumadas > 96){
                diaObjetivo = Date.valueOf(LocalDate.now().plusDays(4));
                horasDiaNuevo = horasSumadas - 96;
            } else if (horasSumadas > 120){
                diaObjetivo = Date.valueOf(LocalDate.now().plusDays(5));
                horasDiaNuevo = horasSumadas - 120;
            } else if (horasSumadas > 144){
                diaObjetivo = Date.valueOf(LocalDate.now().plusDays(6));
                horasDiaNuevo = horasSumadas - 144;
            } else if (horasSumadas > 168){
                diaObjetivo = Date.valueOf(LocalDate.now().plusDays(7));
                horasDiaNuevo = horasSumadas - 168;
            }
            
            tiempoObjetivo = Time.valueOf(LocalTime.now().plusHours(horasSumadas).plusMinutes(minutos).plusSeconds(segundos));
        } else {
            diaObjetivo = diaActual;
            tiempoObjetivo = Time.valueOf(LocalTime.now().plusHours(horas).plusMinutes(minutos).plusSeconds(segundos));
        }
            
        String sql = "insert into tiempos values(?, ?, ?, ?, ?, ?, ?)";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            
            pst.setInt(1, IDFinal);
            pst.setString(2, detalle);
            pst.setString(3, tipo);            
            pst.setDate(4, diaActual);
            pst.setDate(5, diaObjetivo);
            pst.setTime(6, horaActual);
            pst.setTime(7, tiempoObjetivo);
            pst.executeUpdate();
            conec.close();
            
        }catch(SQLException e){
           System.err.print("No podemos guardar tu tiempo en la base de datos " + e);
        }
    }
    
    
    public void guardarTiempoCron(String tipo, String detalle){
        
        Date diaActual = Date.valueOf(LocalDate.now());
        Date diaObjetivo = diaActual;
        
        Time horaActual = Time.valueOf(LocalTime.now());
        Time horaObjetivo = Time.valueOf(LocalTime.now());
        
        int ID = recuperarMaximoID() + 1;
        Boolean yaExiste = verSiExisteID(ID);
        int IDFinal = 0;
        
        if(yaExiste.equals(true)){
            IDFinal = ID+ 1;
            verSiExisteID(IDFinal);
        } else if (yaExiste.equals(false)){
            IDFinal = ID;
        }
            
        String sql = "insert into tiempos values(?, ?, ?, ?, ?, ?, ?)";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            
            pst.setInt(1, IDFinal);
            pst.setString(2, detalle);
            pst.setString(3, tipo);            
            pst.setDate(4, diaActual);
            pst.setDate(5, diaObjetivo);
            pst.setTime(6, horaActual);
            pst.setTime(7, horaObjetivo);
            pst.executeUpdate();
            conec.close();
            
        }catch(SQLException e){
           System.err.print("No podemos guardar tu tiempo en la base de datos " + e);
        }
    }
    
    
    public void obtenerTiempoDePausadoOFin(String asunto){
        
        Time horaObjetivo = Time.valueOf(LocalTime.now());
        
        String sql = "update tiempos set tiempo_objetivo=? where detalle = '" + asunto + "' "
                + "and tipo = 'Cronómetro'";
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            
            pst.setTime(1, horaObjetivo);
            pst.executeUpdate();
            conec.close();
        }catch(SQLException e){
            System.err.println("No podemos cargar tiempo objetivo en la base " + e);
        }
    }
    
    public void calcularTiempoPasado(String asunto){
        
        String sql = "select tiempo_actual, tiempo_objetivo from tiempos where d"
                + "etalle = '" + asunto + "' "
                + "and tipo = 'Cronómetro'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                Time tiempoBase = rs.getTime("tiempo_actual");
                Time tiempoFinal = rs.getTime("tiempo_objetivo");
                
                int horasBase = tiempoBase.getHours();
                int horasFinal = tiempoFinal.getHours();
                
                int minutosBase = tiempoBase.getMinutes();
                int minutosFinal = tiempoFinal.getMinutes();
                
                int segundosBase = tiempoBase.getSeconds();
                int segundosFinal = tiempoFinal.getSeconds();
                
                int horas = horasFinal - horasBase;
                int minutos = minutosFinal - minutosBase;
                int segundos = segundosFinal - segundosBase;

            JOptionPane.showMessageDialog(null, horas + ":" + minutos + ":" + segundos);
            } else {
                System.out.println("No pudimos obtener los datos");
            }
        }catch(SQLException e){
            System.err.print("No se puede cálcular el tiempo transcurrido " + e);
        }
    }
    
    
    public boolean verSiExisteID(int ID){
        
        Boolean existeID = null;
        String sql = "select id_tiempo from tiempos where id_tiempo = '" + ID + "'";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                existeID = true;
            } else {
            existeID = false;
        }
        }catch(SQLException e){
            System.err.println("No podemos ver si existe el ID " + e);
        }
        return existeID;
    }
    
    public int recuperarMaximoID(){
        
        int maximoID = 0;
        String sql = "select MAX(id_tiempo) from tiempos";
        
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                maximoID = rs.getInt(1);
            }
        }catch(SQLException e){
            System.err.println("No es posible recuperar máximo ID " + e);
        }
        return maximoID;
    }
    
    
    public Boolean verificarCuentasRegresivasCumplidas(Date diaObjetivo, Time tiempoObjetivo){ 
        
        Boolean hay = null;
        
        String sql = "select detalle, dia_objetivo, tiempo_objetivo from tiempos "
                + "where tipo = 'Cuenta regresiva' and dia_objetivo = '" + diaObjetivo 
                + "' and tiempo_objetivo = '" + tiempoObjetivo + "'";
                
        try{
            conec = cn.Conexion();
            pst = conec.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                
                   String detalle = rs.getString("detalle");
                   Date diaObjetivoRec = rs.getDate("dia_objetivo");
                   Time tiempoObjetivoRec = rs.getTime("tiempo_objetivo");
                   hay = true; 
                   MensajesImpl mensajes = new MensajesImpl();
                   mensajes.notificacionTiempoCuentaRegresivaCumplida(detalle, 
                           diaObjetivo, tiempoObjetivo);     
            } else {
                hay = false;
            }
            conec.close();
            
        }catch(SQLException e){
            System.err.println("No hay mensajes disponibles " + e);
        }
  
        return hay;
    }
    

}
