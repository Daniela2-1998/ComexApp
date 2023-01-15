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
@Table(name = "preguntas_seguridad")
public class PreguntasDeSeguridad {
    
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_preguntas")
    private Integer id;
    
    @NotBlank
    private String usuario;
    
    @NotBlank
    private String nombre;
    
    @NotBlank
    private String pregunta_uno;
    
    @NotBlank
    private String eleccion_uno;
    
    @NotBlank
    private String pregunta_dos;
    
    @NotBlank
    private String eleccion_dos;
    
    
    @NotBlank 
    private String pregunta_tres;
    
    @NotBlank
    private String eleccion_tres;
    
    
    @NotBlank
    private String pregunta_extra;
    
    @NotBlank
    private String eleccion_extra;
    
    
    
    
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPregunta_uno() {
        return pregunta_uno;
    }

    public void setPregunta_uno(String pregunta_uno) {
        this.pregunta_uno = pregunta_uno;
    }

    public String getPregunta_dos() {
        return pregunta_dos;
    }

    public void setPregunta_dos(String pregunta_dos) {
        this.pregunta_dos = pregunta_dos;
    }

    public String getPregunta_tres() {
        return pregunta_tres;
    }

    public void setPregunta_tres(String pregunta_tres) {
        this.pregunta_tres = pregunta_tres;
    }

    public String getPregunta_extra() {
        return pregunta_extra;
    }

    public void setPregunta_extra(String pregunta_extra) {
        this.pregunta_extra = pregunta_extra;
    }

    public String getEleccion_uno() {
        return eleccion_uno;
    }

    public void setEleccion_uno(String eleccion_uno) {
        this.eleccion_uno = eleccion_uno;
    }

    public String getEleccion_dos() {
        return eleccion_dos;
    }

    public void setEleccion_dos(String eleccion_dos) {
        this.eleccion_dos = eleccion_dos;
    }

    public String getEleccion_tres() {
        return eleccion_tres;
    }

    public void setEleccion_tres(String eleccion_tres) {
        this.eleccion_tres = eleccion_tres;
    }

    public String getEleccion_extra() {
        return eleccion_extra;
    }

    public void setEleccion_extra(String eleccion_extra) {
        this.eleccion_extra = eleccion_extra;
    }

    
    
    public PreguntasDeSeguridad() {
    }

    public PreguntasDeSeguridad(Integer id, String usuario, String nombre, String pregunta_uno, String eleccion_uno, String pregunta_dos, String eleccion_dos, String pregunta_tres, String eleccion_tres, String pregunta_extra, String eleccion_extra) {
        this.id = id;
        this.usuario = usuario;
        this.nombre = nombre;
        this.pregunta_uno = pregunta_uno;
        this.eleccion_uno = eleccion_uno;
        this.pregunta_dos = pregunta_dos;
        this.eleccion_dos = eleccion_dos;
        this.pregunta_tres = pregunta_tres;
        this.eleccion_tres = eleccion_tres;
        this.pregunta_extra = pregunta_extra;
        this.eleccion_extra = eleccion_extra;
    }

    
    
}
