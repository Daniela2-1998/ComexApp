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
@Table (name = "objetivos")
public class ObjetivosEmpresa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_objetivo")
    private Integer id;
    
    @NotBlank
    private String nombre;

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

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private String fecha_registro;
    
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private String fecha_fin;

    
    
    
    
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

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    
    
    
    public ObjetivosEmpresa() {
    }

    public ObjetivosEmpresa(Integer id, String nombre, String descripcion, String importancia, String visibilidad, String status, String usuario_creador, String fecha_registro, String fecha_fin) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.importancia = importancia;
        this.visibilidad = visibilidad;
        this.status = status;
        this.usuario_creador = usuario_creador;
        this.fecha_registro = fecha_registro;
        this.fecha_fin = fecha_fin;
    }
    
    
}
