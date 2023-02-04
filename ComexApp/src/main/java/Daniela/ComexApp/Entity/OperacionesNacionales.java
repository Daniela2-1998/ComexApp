package Daniela.ComexApp.Entity;

import java.sql.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Daniela
 *
 */
@Entity
@Table(name = "ventalocal")
public class OperacionesNacionales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ventalocal")
    private Integer id;

    @NotBlank
    private String empresa;

    @NotBlank
    private String empleado;

    @NotBlank
    private String CUIT;

    @NotBlank
    private String mail;

    @NotBlank
    private String numero_contacto;

    @NotBlank
    private String productos_pedidos;
    
    @NotBlank
    private String status;
    
    @NotBlank
    private String tipo_operacion;
    
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fecha_registro;
    
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fecha_arribo;
    
    @NotEmpty
    private String cantidadProducto;
    
    @NotEmpty
    private String precioTotal;
    
    @NotEmpty
    private String comprador;
    
    @NotEmpty
    private String vendedor;

    
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

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getCUIT() {
        return CUIT;
    }

    public void setCUIT(String CUIT) {
        this.CUIT = CUIT;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNumero_contacto() {
        return numero_contacto;
    }

    public void setNumero_contacto(String numero_contacto) {
        this.numero_contacto = numero_contacto;
    }

    public String getProductos_pedidos() {
        return productos_pedidos;
    }

    public void setProductos_pedidos(String productos_pedidos) {
        this.productos_pedidos = productos_pedidos;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public Date getFecha_arribo() {
        return fecha_arribo;
    }

    public void setFecha_arribo(Date fecha_arribo) {
        this.fecha_arribo = fecha_arribo;
    }


    public String getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(String cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipo_operacion() {
        return tipo_operacion;
    }

    public void setTipo_operacion(String tipo_operacion) {
        this.tipo_operacion = tipo_operacion;
    }

    
    
    
    public OperacionesNacionales() {
    }

    public OperacionesNacionales(Integer id, String empresa, String empleado, String CUIT, String mail, String numero_contacto, String productos_pedidos, String status, String tipo_operacion, Date fecha_registro, Date fecha_arribo, String cantidadProducto, String precioTotal, String comprador, String vendedor) {
        this.id = id;
        this.empresa = empresa;
        this.empleado = empleado;
        this.CUIT = CUIT;
        this.mail = mail;
        this.numero_contacto = numero_contacto;
        this.productos_pedidos = productos_pedidos;
        this.status = status;
        this.tipo_operacion = tipo_operacion;
        this.fecha_registro = fecha_registro;
        this.fecha_arribo = fecha_arribo;
        this.cantidadProducto = cantidadProducto;
        this.precioTotal = precioTotal;
        this.comprador = comprador;
        this.vendedor = vendedor;
    }


}
