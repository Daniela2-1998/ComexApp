package Daniela.ComexApp.Entity;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author Daniela
 *
 */
@Entity
@Table(name = "costos")
public class Costos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_costos")
    private Integer id;

    @NotBlank
    private String producto;

    @NotBlank
    private String logistica_nacional;

    @NotBlank
    private String logistica_internacional;
    
    @NotBlank
    private String aduana;

    @NotBlank
    private String otros;

    @NotBlank
    private String tipo_operacion;

    @NotBlank
    private String impuestos;
 
    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "operaciones_costos",
            joinColumns = @JoinColumn(name = "id_operaciones"))
    List<Operaciones> operaciones;

    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getLogistica_nacional() {
        return logistica_nacional;
    }

    public void setLogistica_nacional(String logistica_nacional) {
        this.logistica_nacional = logistica_nacional;
    }

    public String getLogistica_internacional() {
        return logistica_internacional;
    }

    public void setLogistica_internacional(String logistica_internacional) {
        this.logistica_internacional = logistica_internacional;
    }

    public String getAduana() {
        return aduana;
    }

    public void setAduana(String aduana) {
        this.aduana = aduana;
    }

    public String getOtros() {
        return otros;
    }

    public void setOtros(String otros) {
        this.otros = otros;
    }

    public String getTipo_operacion() {
        return tipo_operacion;
    }

    public void setTipo_operacion(String tipo_operacion) {
        this.tipo_operacion = tipo_operacion;
    }

    public String getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(String impuestos) {
        this.impuestos = impuestos;
    }

    public List<Operaciones> getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(List<Operaciones> operaciones) {
        this.operaciones = operaciones;
    }

    
    
    
    public Costos() {
    }

    public Costos(Integer id, String producto, String logistica_nacional, String logistica_internacional, String aduana, String otros, String tipo_operacion, String impuestos, List<Operaciones> operaciones) {
        this.id = id;
        this.producto = producto;
        this.logistica_nacional = logistica_nacional;
        this.logistica_internacional = logistica_internacional;
        this.aduana = aduana;
        this.otros = otros;
        this.tipo_operacion = tipo_operacion;
        this.impuestos = impuestos;
        this.operaciones = operaciones;
    }
   
}
