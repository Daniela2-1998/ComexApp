package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Daniela
 */
public class Conexion {
    
    Connection cn;
    String url = "jdbc:postgresql://localhost:5432/comexapp";
    String user = "dan";
    String pass = "dani";
    
    public Connection Conexion(){
        try{
            cn = DriverManager.getConnection(url, user, pass);
        }catch(SQLException e){
            System.err.println("No se pudo establecer conexión con la base de datos");
        }
        return cn;
    }
}
