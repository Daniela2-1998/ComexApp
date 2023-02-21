package Daniela.ComexApp.Entity;

import java.sql.Date;
import java.sql.Time;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Daniela
 */
@Entity
@Table (name = "tiempos")
public class Tiempos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tiempo")
    private Integer id;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date diaActual;
    
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private Time tiempoActual;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date diaObjetivo;
    
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private Time tiempoObjetivo;
    
    @NotBlank
    private String detalle;
    
    @NotBlank
    private String tipo;

    
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getDiaActual() {
        return diaActual;
    }

    public void setDiaActual(Date diaActual) {
        this.diaActual = diaActual;
    }

    public Time getTiempoActual() {
        return tiempoActual;
    }

    public void setTiempoActual(Time tiempoActual) {
        this.tiempoActual = tiempoActual;
    }

    public Date getDiaObjetivo() {
        return diaObjetivo;
    }

    public void setDiaObjetivo(Date diaObjetivo) {
        this.diaObjetivo = diaObjetivo;
    }

    public Time getTiempoObjetivo() {
        return tiempoObjetivo;
    }

    public void setTiempoObjetivo(Time tiempoObjetivo) {
        this.tiempoObjetivo = tiempoObjetivo;
    }
    
    
    

    public Tiempos() {
    }

    public Tiempos(Integer id, Date diaActual, Time tiempoActual, Date diaObjetivo, Time tiempoObjetivo, String detalle, String tipo) {
        this.id = id;
        this.diaActual = diaActual;
        this.tiempoActual = tiempoActual;
        this.diaObjetivo = diaObjetivo;
        this.tiempoObjetivo = tiempoObjetivo;
        this.detalle = detalle;
        this.tipo = tipo;
    }
    
    
}
