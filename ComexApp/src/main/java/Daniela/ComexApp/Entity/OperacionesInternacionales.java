package Daniela.ComexApp.Entity;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


/**
 *
 * @author Daniela
 */
@Entity
@Table(name="operaciones")
public class OperacionesInternacionales {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_operaciones")
    private Integer id;
    
    @NotBlank
    private String tipo_operacion;
    
    @NotNull
    @DateTimeFormat(iso = ISO.DATE)
    private String fecha_operacion;
    
    @NotNull
    @DateTimeFormat(iso = ISO.DATE)
    private String fecha_ETA;

    @NotEmpty
    private String producto;
    
    @NotEmpty
    private String detalles;
    
    @NotEmpty
    private String cantidadProducto;
    
    @NotEmpty
    private String precioTotal;
    
    @NotEmpty
    private String comprador;
    
    @NotEmpty
    private String vendedor;
    
    @NotEmpty
    private String paisOrigen;
    
    @NotEmpty
    private String codigo_contenedores;
    
    @NotBlank
    private Integer cantidad_contenedores;
    
    @NotBlank
    private String numero_embarque;
    
    @NotBlank
    private String nombreBuque;
    
   @NotBlank
   private String status;
    
    
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo_operacion() {
        return tipo_operacion;
    }

    public void setTipo_operacion(String tipo_operacion) {
        this.tipo_operacion = tipo_operacion;
    }

    public String getFecha_operacion() {
        return fecha_operacion;
    }

    public void setFecha_operacion(String fecha_operacion) {
        this.fecha_operacion = fecha_operacion;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getCodigo_contenedores() {
        return codigo_contenedores;
    }

    public void setCodigo_contenedores(String codigo_contenedores) {
        this.codigo_contenedores = codigo_contenedores;
    }

    public Integer getCantidad_contenedores() {
        return cantidad_contenedores;
    }

    public void setCantidad_contenedores(Integer cantidad_contenedores) {
        this.cantidad_contenedores = cantidad_contenedores;
    }

    public String getNumero_embarque() {
        return numero_embarque;
    }

    public void setNumero_embarque(String numero_embarque) {
        this.numero_embarque = numero_embarque;
    }

    public String getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(String cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public String getFecha_ETA() {
        return fecha_ETA;
    }

    public void setFecha_ETA(String fecha_ETA) {
        this.fecha_ETA = fecha_ETA;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(String precioTotal) {
        this.precioTotal = precioTotal;
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

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public String getNombreBuque() {
        return nombreBuque;
    }

    public void setNombreBuque(String nombreBuque) {
        this.nombreBuque = nombreBuque;
    }

    
    
    
    
    
    
    public OperacionesInternacionales() {
    }

    public OperacionesInternacionales(Integer id, String tipo_operacion, String fecha_operacion, 
            String fecha_ETA, String producto, String detalles, String cantidadProducto,
            String precioTotal, String comprador, String vendedor, String paisOrigen,
            String codigo_contenedores, Integer cantidad_contenedores, String numero_embarque, 
            String nombreBuque, String status) {
        this.id = id;
        this.tipo_operacion = tipo_operacion;
        this.fecha_operacion = fecha_operacion;
        this.fecha_ETA = fecha_ETA;
        this.producto = producto;
        this.detalles = detalles;
        this.cantidadProducto = cantidadProducto;
        this.precioTotal = precioTotal;
        this.comprador = comprador;
        this.vendedor = vendedor;
        this.paisOrigen = paisOrigen;
        this.codigo_contenedores = codigo_contenedores;
        this.cantidad_contenedores = cantidad_contenedores;
        this.numero_embarque = numero_embarque;
        this.nombreBuque = nombreBuque;
        this.status = status;
    }



    
}
