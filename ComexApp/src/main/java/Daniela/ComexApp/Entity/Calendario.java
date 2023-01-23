package Daniela.ComexApp.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Daniela
 */
@Entity
@Table (name = "calendario")
public class Calendario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evento")
    private Integer id;
    
    @NotBlank
    private String nombre;

    @NotBlank
    private String tipo_evento;

    @NotBlank
    private String nivel_prioridad;

    @NotBlank
    private String visibilidad;
    
    @NotBlank
    private String detalles;
    
    @NotBlank
    private String creador;
    
    @NotBlank
    private String alerta;
    
    @NotBlank
    private String status;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private String fecha_registro;
    
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private String fecha_evento;
    
    
    
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo_evento() {
        return tipo_evento;
    }

    public void setTipo_evento(String tipo_evento) {
        this.tipo_evento = tipo_evento;
    }

    public String getNivel_prioridad() {
        return nivel_prioridad;
    }

    public void setNivel_prioridad(String nivel_prioridad) {
        this.nivel_prioridad = nivel_prioridad;
    }

    public String getVisibilidad() {
        return visibilidad;
    }

    public void setVisibilidad(String visibilidad) {
        this.visibilidad = visibilidad;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public String getAlerta() {
        return alerta;
    }

    public void setAlerta(String alerta) {
        this.alerta = alerta;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getFecha_evento() {
        return fecha_evento;
    }

    public void setFecha_evento(String fecha_evento) {
        this.fecha_evento = fecha_evento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    
    
    public Calendario() {
    }

    public Calendario(Integer id, String nombre, String tipo_evento, String nivel_prioridad, String visibilidad, String detalles, String creador, String alerta, String status, String fecha_registro, String fecha_evento) {
        this.id = id;
        this.nombre = nombre;
        this.tipo_evento = tipo_evento;
        this.nivel_prioridad = nivel_prioridad;
        this.visibilidad = visibilidad;
        this.detalles = detalles;
        this.creador = creador;
        this.alerta = alerta;
        this.status = status;
        this.fecha_registro = fecha_registro;
        this.fecha_evento = fecha_evento;
    }
  
    
}
