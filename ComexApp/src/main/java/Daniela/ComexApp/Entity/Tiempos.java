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
    private Date dia;
    
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private Time tiempo;

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

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public Time getTiempo() {
        return tiempo;
    }

    public void setTiempo(Time tiempo) {
        this.tiempo = tiempo;
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
    
    
    

    public Tiempos() {
    }

    public Tiempos(Integer id, Date dia, Time tiempo, String detalle, String tipo) {
        this.id = id;
        this.dia = dia;
        this.tiempo = tiempo;
        this.detalle = detalle;
        this.tipo = tipo;
    }
    
    
}
