package Daniela.ComexApp.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

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
    
    @NotBlank
    private int id_operacion;
    
    @NotBlank
    private int id_producto;
    
    @NotBlank
    private int id_contenedor; 
    
    @NotBlank
    private int id_transporte;
    
    @NotBlank
    private int id_exportador; 
    
    @NotBlank
    private int id_despachante;
    
    @NotBlank
    private int status;

    
    
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
    

    public OperacionInternacionalConexion() {
    }

    public OperacionInternacionalConexion(Integer id, int id_operacion, int id_producto, int id_contenedor, int id_transporte, int id_exportador, int id_despachante, int status) {
        this.id = id;
        this.id_operacion = id_operacion;
        this.id_producto = id_producto;
        this.id_contenedor = id_contenedor;
        this.id_transporte = id_transporte;
        this.id_exportador = id_exportador;
        this.id_despachante = id_despachante;
        this.status = status;
    }
    

    
}
