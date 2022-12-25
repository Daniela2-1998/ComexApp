package Daniela.ComexApp.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author Daniela
 */
@Entity
@Table (name = "aereo")
public class Aereo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aereo")
    private Integer id;

    @NotBlank
    private String aerolinea;

    @NotBlank
    private String empleado;

    @NotBlank
    private String mail;
    
    @NotBlank
    private String numero_contacto;
    
    @NotBlank
    private String requisitos;

    
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String email) {
        this.mail = email;
    }

    public String getNumero_contacto() {
        return numero_contacto;
    }

    public void setNumero_contacto(String numero_contacto) {
        this.numero_contacto = numero_contacto;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    
    
    
    public Aereo() {
    }

    public Aereo(Integer id, String aerolinea, String empleado, String mail, String numero_contacto, String requisitos) {
        this.id = id;
        this.aerolinea = aerolinea;
        this.empleado = empleado;
        this.mail = mail;
        this.numero_contacto = numero_contacto;
        this.requisitos = requisitos;
    }
    

    
    
    
    
    
}
