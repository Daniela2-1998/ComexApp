package Daniela.ComexApp.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author Daniela
 */

@Entity
@Table(name = "notas")
public class Notas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nota")
    private Integer id;
    
    @NotBlank
    private String usuario;
    
    @NotBlank
    private String titulo;
    
    @NotBlank
    private String contenido;
    
    @NotBlank
    private String color;

    @NotBlank
    private String colorLetra;
    
    @NotBlank
    private String letra;
    
    @NotBlank
    private String ubicacion;
    
    @NotBlank
    private String status;
    
    @NotBlank
    private String fecha;
    
    @NotBlank
    private String visibilidad;
    
    
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getVisibilidad() {
        return visibilidad;
    }

    public void setVisibilidad(String visibilidad) {
        this.visibilidad = visibilidad;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public String getColorLetra() {
        return colorLetra;
    }

    public void setColorLetra(String colorLetra) {
        this.colorLetra = colorLetra;
    }

    
    
    
    public Notas() {
    }

    public Notas(Integer id, String usuario, String titulo, String contenido, String color, String colorLetra, String letra, String ubicacion, String status, String fecha, String visibilidad) {
        this.id = id;
        this.usuario = usuario;
        this.titulo = titulo;
        this.contenido = contenido;
        this.color = color;
        this.colorLetra = colorLetra;
        this.letra = letra;
        this.ubicacion = ubicacion;
        this.status = status;
        this.fecha = fecha;
        this.visibilidad = visibilidad;
    }


}
