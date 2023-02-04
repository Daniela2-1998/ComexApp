package Daniela.ComexApp.Entity;

import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Daniela
 */
@Entity
@Table(name = "reabastecimiento")
public class Reabastecimiento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Integer id;
    
    @NotBlank
    private String producto;
    
    @NotBlank
    private String cantidad;
    
    @NotBlank
    private String precioTotal;
    
    @NotBlank
    private String descuento;
    
    @NotBlank
    private String destino;
    
    @NotBlank
    private String paisOrigen;
    
    @NotBlank
    private String detalle;
    
    @NotBlank
    private String cuidados_requeridos;
    
    @NotBlank
    private String tipo_producto;
    
    @NotBlank
    private String precio_unitario;
     
    @NotBlank
    private String status;
    
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fecha_registro;
    
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fecha_ingreso;

 
    
    
    
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

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(String precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getTipo_producto() {
        return tipo_producto;
    }

    public void setTipo_producto(String tipo_producto) {
        this.tipo_producto = tipo_producto;
    }

    public String getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(String precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCuidados_requeridos() {
        return cuidados_requeridos;
    }

    public void setCuidados_requeridos(String cuidados_requeridos) {
        this.cuidados_requeridos = cuidados_requeridos;
    }

    
    
    
    
    public Reabastecimiento() {
    }

    public Reabastecimiento(Integer id, String producto, String cantidad, String precioTotal, String descuento, String destino, String paisOrigen, String detalle, String cuidados_requeridos, String tipo_producto, String precio_unitario, String status, Date fecha_registro, Date fecha_ingreso) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioTotal = precioTotal;
        this.descuento = descuento;
        this.destino = destino;
        this.paisOrigen = paisOrigen;
        this.detalle = detalle;
        this.cuidados_requeridos = cuidados_requeridos;
        this.tipo_producto = tipo_producto;
        this.precio_unitario = precio_unitario;
        this.status = status;
        this.fecha_registro = fecha_registro;
        this.fecha_ingreso = fecha_ingreso;
    }



}
