package Daniela.ComexApp.Entity;

import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Daniela
 */
@Entity
@Table(name = "stock")
public class Stock {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer id;

    @NotBlank
    private String comprador;

    @NotBlank
    private String vendedor;
    
    @NotBlank
    private String nombreProducto;

    @NotBlank
    private String paisOrigen;
    
    @NotBlank
    private String codigoProducto;

    @NotBlank
    private String detalle;
    
    @NotBlank
    private String tipo_producto;
    
    @NotBlank
    private String cuidados_requeridos;
    
    @NotBlank
    private String reserva;

    @NotBlank
    private String cantidad;

    @NotBlank
    private String precio_unitario;

    @NotBlank
    private String status;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date ultima_actualizacion;
    
    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "operaciones_productos",
            joinColumns = @JoinColumn(name = "id_operaciones"))
    List<OperacionesInternacionales> operaciones;

    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
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

    public String getCuidados_requeridos() {
        return cuidados_requeridos;
    }

    public void setCuidados_requeridos(String cuidados_requeridos) {
        this.cuidados_requeridos = cuidados_requeridos;
    }

    public String getReserva() {
        return reserva;
    }

    public void setReserva(String reserva) {
        this.reserva = reserva;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
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

    public List<OperacionesInternacionales> getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(List<OperacionesInternacionales> operaciones) {
        this.operaciones = operaciones;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Date getUltima_actualizacion() {
        return ultima_actualizacion;
    }

    public void setUltima_actualizacion(Date ultima_actualizacion) {
        this.ultima_actualizacion = ultima_actualizacion;
    }

    
    
    
    
    public Stock() {
    }

    public Stock(Integer id, String comprador, String vendedor, String nombreProducto, String paisOrigen, String codigoProducto, String detalle, String tipo_producto, String cuidados_requeridos, String reserva, String cantidad, String precio_unitario, String status, Date ultima_actualizacion, List<OperacionesInternacionales> operaciones) {
        this.id = id;
        this.comprador = comprador;
        this.vendedor = vendedor;
        this.nombreProducto = nombreProducto;
        this.paisOrigen = paisOrigen;
        this.codigoProducto = codigoProducto;
        this.detalle = detalle;
        this.tipo_producto = tipo_producto;
        this.cuidados_requeridos = cuidados_requeridos;
        this.reserva = reserva;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
        this.status = status;
        this.ultima_actualizacion = ultima_actualizacion;
        this.operaciones = operaciones;
    }


}
