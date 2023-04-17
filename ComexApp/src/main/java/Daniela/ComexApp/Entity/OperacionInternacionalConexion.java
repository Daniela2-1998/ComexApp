package Daniela.ComexApp.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Daniela
 */
@Entity
@Table(name = "participantes_opint")
public class OperacionInternacionalConexion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_opint")
    private Integer id;
    
    private int id_operacion;
    
    private int id_producto;
    
    private int id_contenedor; 
    
    private int id_transporte;
    
    private int id_exportador; 

    private int id_importador; 

    private int id_despachante;

    private String status;
    
    private boolean stockModificado;

    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getId_operacion() {
        return id_operacion;
    }

    public void setId_operacion(int id_operacion) {
        this.id_operacion = id_operacion;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_contenedor() {
        return id_contenedor;
    }

    public void setId_contenedor(int id_contenedor) {
        this.id_contenedor = id_contenedor;
    }

    public int getId_transporte() {
        return id_transporte;
    }

    public void setId_transporte(int id_transporte) {
        this.id_transporte = id_transporte;
    }

    public int getId_exportador() {
        return id_exportador;
    }

    public void setId_exportador(int id_exportador) {
        this.id_exportador = id_exportador;
    }

    public int getId_despachante() {
        return id_despachante;
    }

    public void setId_despachante(int id_despachante) {
        this.id_despachante = id_despachante;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId_importador() {
        return id_importador;
    }

    public void setId_importador(int id_importador) {
        this.id_importador = id_importador;
    }

    public boolean isStockModificado() {
        return stockModificado;
    }

    public void setStockModificado(boolean stockModificado) {
        this.stockModificado = stockModificado;
    }

    
    

    public OperacionInternacionalConexion() {
    }

    public OperacionInternacionalConexion(Integer id, int id_operacion, int id_producto, int id_contenedor, int id_transporte, int id_exportador, int id_importador, int id_despachante, String status, boolean stockModificado) {
        this.id = id;
        this.id_operacion = id_operacion;
        this.id_producto = id_producto;
        this.id_contenedor = id_contenedor;
        this.id_transporte = id_transporte;
        this.id_exportador = id_exportador;
        this.id_importador = id_importador;
        this.id_despachante = id_despachante;
        this.status = status;
        this.stockModificado = stockModificado;
    }
    
}
