package Daniela.ComexApp.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author Daniela
 */
@Entity
@Table (name = "mail")
public class Mail {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mail")
    private Integer id;

    @NotBlank
    private String correoOrigen;

    @NotBlank
    private String correoDestino;

    @NotBlank
    private String asunto;
    
    @NotBlank
    private String mensaje;
    
    @NotBlank
    private String contraseña16Digitos;

    private String espacio1;
    
    private String espacio2;
    
    
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCorreoOrigen() {
        return correoOrigen;
    }

    public void setCorreoOrigen(String correoOrigen) {
        this.correoOrigen = correoOrigen;
    }

    public String getCorreoDestino() {
        return correoDestino;
    }

    public void setCorreoDestino(String correoDestino) {
        this.correoDestino = correoDestino;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getContraseña16Digitos() {
        return contraseña16Digitos;
    }

    public void setContraseña16Digitos(String contraseña16Digitos) {
        this.contraseña16Digitos = contraseña16Digitos;
    }

    public String getEspacio1() {
        return espacio1;
    }

    public void setEspacio1(String espacio1) {
        this.espacio1 = espacio1;
    }

    public String getEspacio2() {
        return espacio2;
    }

    public void setEspacio2(String espacio2) {
        this.espacio2 = espacio2;
    }

    
    
    
    public Mail() {
    }

    public Mail(Integer id, String correoOrigen, String correoDestino, String asunto, String mensaje, String contraseña16Digitos, String espacio1, String espacio2) {
        this.id = id;
        this.correoOrigen = correoOrigen;
        this.correoDestino = correoDestino;
        this.asunto = asunto;
        this.mensaje = mensaje;
        this.contraseña16Digitos = contraseña16Digitos;
        this.espacio1 = espacio1;
        this.espacio2 = espacio2;
    }

  
    
}
