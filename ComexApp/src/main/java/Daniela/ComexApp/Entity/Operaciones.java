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
public class Operaciones {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_operaciones")
    private Integer id;
    
    @NotBlank
    private String tipo_operacion;
    
    @NotNull
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate fecha_operacion;

    @NotEmpty
    private String producto;
    
    @NotEmpty
    private String codigo_contenedores;
    
    @NotBlank
    private Integer cantidad_contenedores;
    
    @NotBlank
    private String numero_embarque;
            
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "operaciones_maritimas",
            joinColumns = @JoinColumn(name = "id_operaciones"))
    List<Maritimas> maritimas;
    private String numero_embarqueop;
    
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "operaciones_aereo",
            joinColumns = @JoinColumn(name = "id_operaciones"))
    List<Aereo> aereo;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "operaciones_contenedores",
            joinColumns = @JoinColumn(name = "id_operaciones"))
    List<Contenedores> contenedores;
    
    
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

    public LocalDate getFecha_operacion() {
        return fecha_operacion;
    }

    public void setFecha_operacion(LocalDate fecha_operacion) {
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

    public List<Maritimas> getMaritimas() {
        return maritimas;
    }

    public void setMaritimas(List<Maritimas> maritimas) {
        this.maritimas = maritimas;
    }

    public String getNumero_embarqueop() {
        return numero_embarqueop;
    }

    public void setNumero_embarqueop(String numero_embarqueop) {
        this.numero_embarqueop = numero_embarqueop;
    }

    public List<Aereo> getAereo() {
        return aereo;
    }

    public void setAereo(List<Aereo> aereo) {
        this.aereo = aereo;
    }

    public List<Contenedores> getContenedores() {
        return contenedores;
    }

    public void setContenedores(List<Contenedores> contenedores) {
        this.contenedores = contenedores;
    }

    
    
    
    
    public Operaciones() {
    }

    public Operaciones(Integer id, String tipo_operacion, LocalDate fecha_operacion, String producto, String codigo_contenedores, Integer cantidad_contenedores, String numero_embarque, List<Maritimas> maritimas, String numero_embarqueop, List<Aereo> aereo, List<Contenedores> contenedores) {
        this.id = id;
        this.tipo_operacion = tipo_operacion;
        this.fecha_operacion = fecha_operacion;
        this.producto = producto;
        this.codigo_contenedores = codigo_contenedores;
        this.cantidad_contenedores = cantidad_contenedores;
        this.numero_embarque = numero_embarque;
        this.maritimas = maritimas;
        this.numero_embarqueop = numero_embarqueop;
        this.aereo = aereo;
        this.contenedores = contenedores;
    }


    
    
    
    
}
