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
@Table (name = "objetivos")
public class ObjetivosEmpresa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_objetivo")
    private Integer id;
    
    @NotBlank
    private String objetivo;

    @NotBlank
    private String descripcion;

    @NotBlank
    private String importancia;
    
    @NotBlank
    private String visibilidad;

    @NotBlank
    private String status;
    
    @NotBlank
    private String usuario_creador;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fecha_registro;
    
    
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fecha_objetivo;

    
    
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }
   

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImportancia() {
        return importancia;
    }

    public void setImportancia(String importancia) {
        this.importancia = importancia;
    }

    public String getVisibilidad() {
        return visibilidad;
    }

    public void setVisibilidad(String visibilidad) {
        this.visibilidad = visibilidad;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsuario_creador() {
        return usuario_creador;
    }

    public void setUsuario_creador(String usuario_creador) {
        this.usuario_creador = usuario_creador;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public Date getFecha_objetivo() {
        return fecha_objetivo;
    }

    public void setFecha_objetivo(Date fecha_objetivo) {
        this.fecha_objetivo = fecha_objetivo;
    }



    
    
    
    public ObjetivosEmpresa() {
    }

    public ObjetivosEmpresa(Integer id, String objetivo, String descripcion, String importancia, String visibilidad, String status, String usuario_creador, Date fecha_registro, Date fecha_objetivo) {
        this.id = id;
        this.objetivo = objetivo;
        this.descripcion = descripcion;
        this.importancia = importancia;
        this.visibilidad = visibilidad;
        this.status = status;
        this.usuario_creador = usuario_creador;
        this.fecha_registro = fecha_registro;
        this.fecha_objetivo = fecha_objetivo;
    }



}
