package service;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Daniela
 */
public interface InformesPersonalizadosService {
    
  
    public void crearInformePersonalizado(int id, String usuario, String nombre, 
            String titulo1, String parrafo1);
    
    public void modificarInforme(int id, String nombre, String titulo1, String titulo2, 
            String titulo3, String titulo4, String titulo5, String parrafo1, 
            String parrafo2, String parrafo3, String parrafo4, String parrafo5);
    
    public void busquedaPorNombre(String nombre, String usuario, JTextField textNumero, 
            JTextField textNombre, JTextField textTitulo, JTextArea textParrafo);
    
    public void busquedaPorID(int ID, String usuario, JTextField textNumero, 
            JTextField textNombre, JTextField textTitulo, JTextArea textParrafo);
        
    public Boolean recuperarID(String usuario,  String titulo, JTextField textNumero);
    
    public void agregarTitulo2 (int id, String titulo2);
    
    public void agregarTitulo3 (int id, String titulo3);
    
    public void agregarTitulo4 (int id, String titulo4);
    
    public void agregarTitulo5(int id, String titulo5);
    
    public void agregarParrafo2 (int id, String parrafo2);
    
    public void agregarParrafo3 (int id, String parrafo3);
    
    public void agregarParrafo4 (int id, String parrafo4);
    
    public void agregarParrafo5 (int id, String parrafo5);
    
    public void existeTituloYParrafo1(int ID, JTextField textTitulo1, JTextField textTitulo6);
    
    public void existeTituloYParrafo2(int ID, JTextField textTitulo2, JTextField textTitulo7);
    
    public void existeTituloYParrafo3(int ID, JTextField textTitulo3, JTextField textTitulo8);
    
    public void existeTituloYParrafo4(int ID, JTextField textTitulo4, JTextField textTitulo9);
    
    public void existeTituloYParrafo5(int ID, JTextField textTitulo5, JTextField textTitulo10);
    
    public void pdfInformePersonalizado(String usuario, int id, String nombreInforme,
             String dia, String mes, String año);
    
}
