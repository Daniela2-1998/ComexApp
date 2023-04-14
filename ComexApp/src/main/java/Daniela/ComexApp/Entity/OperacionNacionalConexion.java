package Daniela.ComexApp.Entity;

import java.util.logging.Logger;
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
@Table(name = "participantes_opnac_con")
public class OperacionNacionalConexion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_op_nac")
    private Integer id;
    
    private int id_operacion;

    private int id_producto;

    private String comprador;

    private String vendedor;

    private String status;

    
    
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

    public String getComprador() {
        return comprador;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    
    
    public OperacionNacionalConexion() {
    }

    public OperacionNacionalConexion(Integer id, int id_operacion, int id_producto, String comprador, String vendedor, String status) {
        this.id = id;
        this.id_operacion = id_operacion;
        this.id_producto = id_producto;
        this.comprador = comprador;
        this.vendedor = vendedor;
        this.status = status;
    }
    
}
