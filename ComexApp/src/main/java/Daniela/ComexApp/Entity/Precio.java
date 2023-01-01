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
@Table(name = "precioInternacional")
public class Precio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_precio")
    private Integer id;

    @NotBlank
    private String producto;

    @NotBlank
    private String precio_unitario;

    @NotBlank
    private String precio_total;
    
    @NotBlank
    private String acuerdos_internacionales_disponibles;

    @NotBlank
    private String descuento;

    @NotBlank
    private String cantidad;

    @NotBlank
    private String impuestos;

    
    
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

    public String getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(String precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public String getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(String precio_total) {
        this.precio_total = precio_total;
    }

    public String getAcuerdos_internacionales_disponibles() {
        return acuerdos_internacionales_disponibles;
    }

    public void setAcuerdos_internacionales_disponibles(String acuerdos_internacionales_disponibles) {
        this.acuerdos_internacionales_disponibles = acuerdos_internacionales_disponibles;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(String impuestos) {
        this.impuestos = impuestos;
    }


    
    
    public Precio() {
    }

    public Precio(Integer id, String producto, String precio_unitario,
            String precio_total, String acuerdos_internacionales_disponibles,
            String descuento, String cantidad, String impuestos) {
        this.id = id;
        this.producto = producto;
        this.precio_unitario = precio_unitario;
        this.precio_total = precio_total;
        this.acuerdos_internacionales_disponibles = acuerdos_internacionales_disponibles;
        this.descuento = descuento;
        this.cantidad = cantidad;
        this.impuestos = impuestos;
    }
 
}
