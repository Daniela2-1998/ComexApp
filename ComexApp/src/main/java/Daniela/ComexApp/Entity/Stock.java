package Daniela.ComexApp.Entity;

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
    
    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "operaciones_productos",
            joinColumns = @JoinColumn(name = "id_operaciones"))
    List<Operaciones> operaciones;

    
    
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

    public List<Operaciones> getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(List<Operaciones> operaciones) {
        this.operaciones = operaciones;
    }

    
    
    
    public Stock() {
    }

    public Stock(Integer id, String comprador, String vendedor, String paisOrigen, String codigoProducto, String detalle, String tipo_producto, String cuidados_requeridos, String reserva, String cantidad, String precio_unitario, String status, List<Operaciones> operaciones) {
        this.id = id;
        this.comprador = comprador;
        this.vendedor = vendedor;
        this.paisOrigen = paisOrigen;
        this.codigoProducto = codigoProducto;
        this.detalle = detalle;
        this.tipo_producto = tipo_producto;
        this.cuidados_requeridos = cuidados_requeridos;
        this.reserva = reserva;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
        this.status = status;
        this.operaciones = operaciones;
    }

    
}
