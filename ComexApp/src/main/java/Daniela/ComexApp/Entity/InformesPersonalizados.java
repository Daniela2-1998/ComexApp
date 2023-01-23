package Daniela.ComexApp.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author Daniela
 */
@Entity
@Table (name = "informesPersonalizados")
public class InformesPersonalizados {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_informePers")
    private Integer id;
    
    @NotBlank
    private String nombre;

    @NotBlank
    private String titulo1;

    @NotBlank
    private String titulo2;
    
    @NotBlank
    private String titulo3;
    
    @NotBlank
    private String titulo4;
    
    @NotBlank
    private String titulo5;
    
    @NotBlank
    private String parrafo1;
    
    @NotBlank
    private String parrafo2;
    
    @NotBlank
    private String parrafo3;
    
    @NotBlank
    private String parrafo4;
    
    @NotBlank
    private String parrafo5;
    
    @NotBlank
    private String usuario_creador;

    
    
    
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

    public String getTitulo1() {
        return titulo1;
    }

    public void setTitulo1(String titulo1) {
        this.titulo1 = titulo1;
    }

    public String getTitulo2() {
        return titulo2;
    }

    public void setTitulo2(String titulo2) {
        this.titulo2 = titulo2;
    }

    public String getTitulo3() {
        return titulo3;
    }

    public void setTitulo3(String titulo3) {
        this.titulo3 = titulo3;
    }

    public String getTitulo4() {
        return titulo4;
    }

    public void setTitulo4(String titulo4) {
        this.titulo4 = titulo4;
    }

    public String getTitulo5() {
        return titulo5;
    }

    public void setTitulo5(String titulo5) {
        this.titulo5 = titulo5;
    }

    public String getParrafo1() {
        return parrafo1;
    }

    public void setParrafo1(String parrafo1) {
        this.parrafo1 = parrafo1;
    }

    public String getParrafo2() {
        return parrafo2;
    }

    public void setParrafo2(String parrafo2) {
        this.parrafo2 = parrafo2;
    }

    public String getParrafo3() {
        return parrafo3;
    }

    public void setParrafo3(String parrafo3) {
        this.parrafo3 = parrafo3;
    }

    public String getParrafo4() {
        return parrafo4;
    }

    public void setParrafo4(String parrafo4) {
        this.parrafo4 = parrafo4;
    }

    public String getParrafo5() {
        return parrafo5;
    }

    public void setParrafo5(String parrafo5) {
        this.parrafo5 = parrafo5;
    }

    public String getUsuario_creador() {
        return usuario_creador;
    }

    public void setUsuario_creador(String usuario_creador) {
        this.usuario_creador = usuario_creador;
    }

    
    
    
    public InformesPersonalizados() {
    }

    public InformesPersonalizados(Integer id, String nombre, String titulo1, String titulo2, String titulo3, String titulo4, String titulo5, String parrafo1, String parrafo2, String parrafo3, String parrafo4, String parrafo5, String usuario_creador) {
        this.id = id;
        this.nombre = nombre;
        this.titulo1 = titulo1;
        this.titulo2 = titulo2;
        this.titulo3 = titulo3;
        this.titulo4 = titulo4;
        this.titulo5 = titulo5;
        this.parrafo1 = parrafo1;
        this.parrafo2 = parrafo2;
        this.parrafo3 = parrafo3;
        this.parrafo4 = parrafo4;
        this.parrafo5 = parrafo5;
        this.usuario_creador = usuario_creador;
    }

    
}
