package Daniela.ComexApp.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author Daniela
 */
@Entity
@Table(name = "contenedores")
public class Contenedores {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contenedor")
    private Integer id;

    @NotBlank
    private String empresa;

    @NotBlank
    private String tipo;
    
    @NotBlank
    private String codigo;
    
    @NotBlank
    private Integer cantidad;
    
    @NotBlank
    private Double capacidad;

    @NotBlank
    private String productos;

    
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Double capacidad) {
        this.capacidad = capacidad;
    }

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }
    
    
    

    public Contenedores() {
    }

    public Contenedores(Integer id, String empresa, String tipo, String codigo, Integer cantidad, Double capacidad, String productos) {
        this.id = id;
        this.empresa = empresa;
        this.tipo = tipo;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.capacidad = capacidad;
        this.productos = productos;
    }
    
  
    
    
    
    
}
