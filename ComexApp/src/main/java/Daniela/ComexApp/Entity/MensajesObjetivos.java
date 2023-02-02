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
@Table (name = "mensajes_objetivos")
public class MensajesObjetivos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mensaje_objetivo")
    private Integer id;
    
    @NotBlank
    private String titulo;

    @NotBlank
    private String contenido;

    @NotBlank
    private String usuario_emisor;
    
    @NotBlank
    private String objetivo_asociado;
    
    @NotBlank
    private String visibilidad;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fecha_registro;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private Time hora_registro;
    
    @NotNull
    private Boolean visto;
    
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getUsuario_emisor() {
        return usuario_emisor;
    }

    public void setUsuario_emisor(String usuario_emisor) {
        this.usuario_emisor = usuario_emisor;
    }

    public String getObjetivo_asociado() {
        return objetivo_asociado;
    }

    public void setObjetivo_asociado(String objetivo_asociado) {
        this.objetivo_asociado = objetivo_asociado;
    }

    public String getVisibilidad() {
        return visibilidad;
    }

    public void setVisibilidad(String visibilidad) {
        this.visibilidad = visibilidad;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public Time getHora_registro() {
        return hora_registro;
    }

    public void setHora_registro(Time hora_registro) {
        this.hora_registro = hora_registro;
    }

    public Boolean getVisto() {
        return visto;
    }

    public void setVisto(Boolean visto) {
        this.visto = visto;
    }

  
    
    public MensajesObjetivos() {
    }

    public MensajesObjetivos(Integer id, String titulo, String contenido, String usuario_emisor, String objetivo_asociado, String visibilidad, Date fecha_registro, Time hora_registro, Boolean visto) {
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
        this.usuario_emisor = usuario_emisor;
        this.objetivo_asociado = objetivo_asociado;
        this.visibilidad = visibilidad;
        this.fecha_registro = fecha_registro;
        this.hora_registro = hora_registro;
        this.visto = visto;
    }

}
