package Daniela.ComexApp.Entity;

import java.sql.Date;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

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

    @NotBlank
    private String status;
    
    @NotBlank
    private String reserva;
    
    @NotBlank
    private String compañia_transporte;
    
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date ultimo_control;
    
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date proximo_control;
    
    
    
    
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReserva() {
        return reserva;
    }

    public void setReserva(String reserva) {
        this.reserva = reserva;
    }

    public String getCompañia_transporte() {
        return compañia_transporte;
    }

    public void setCompañia_transporte(String compañia_transporte) {
        this.compañia_transporte = compañia_transporte;
    }

    public Date getUltimo_control() {
        return ultimo_control;
    }

    public void setUltimo_control(Date ultimo_control) {
        this.ultimo_control = ultimo_control;
    }

    public Date getProximo_control() {
        return proximo_control;
    }

    public void setProximo_control(Date proximo_control) {
        this.proximo_control = proximo_control;
    }
    
    
    

    public Contenedores() {
    }

    public Contenedores(Integer id, String empresa, String tipo, String codigo, Integer cantidad, Double capacidad, String productos, String status, String reserva, String compañia_transporte, Date ultimo_control, Date proximo_control) {
        this.id = id;
        this.empresa = empresa;
        this.tipo = tipo;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.capacidad = capacidad;
        this.productos = productos;
        this.status = status;
        this.reserva = reserva;
        this.compañia_transporte = compañia_transporte;
        this.ultimo_control = ultimo_control;
        this.proximo_control = proximo_control;
    }

    
    
}
