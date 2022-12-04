package Daniela.ComexApp.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author Daniela
 */
@Entity
@Table(name = "usuarios")
public class Usuarios {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_usuarios")
    private Integer id;
    
    @NotBlank
    private String nombre;
    
    @NotBlank
    private String apellido;
    
    @NotBlank
    private String mail;
    
    @NotBlank
    private String telefono;
    
    @NotBlank
    private String rol;
    
    @NotBlank
    private String usuario;
    
    @NotBlank
    private String contraseña;

    @NotBlank
    private String status;
   

    
    
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    
    
    public Usuarios() {
    }

    public Usuarios(Integer id, String nombre, String apellido, String mail, String telefono, String rol, String usuario, String contraseña, String status) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.telefono = telefono;
        this.rol = rol;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.status = status;
    }

    
}
