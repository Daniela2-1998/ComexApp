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
@Table(name = "agenda_personal")
public class AgendaPersonal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agenda")
    private Integer id;
    
    @NotBlank
    private String nombre;
    
    @NotBlank
    private String empresa;
    
    @NotBlank
    private String cargo;
    
    @NotBlank
    private String pais;
    
    @NotBlank
    private String mail;
    
    @NotBlank
    private String numero_contacto;
    
    @NotBlank
    private String productos;
    
    @NotBlank
    private String usuarioRegistrador;
    
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

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNumero_contacto() {
        return numero_contacto;
    }

    public void setNumero_contacto(String numero_contacto) {
        this.numero_contacto = numero_contacto;
    }

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsuarioRegistrador() {
        return usuarioRegistrador;
    }

    public void setUsuarioRegistrador(String usuarioRegistrador) {
        this.usuarioRegistrador = usuarioRegistrador;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    

    
    public AgendaPersonal() {
    }

    public AgendaPersonal(Integer id, String nombre, String empresa, String cargo, String pais, String mail, String numero_contacto, String productos, String usuarioRegistrador, String status) {
        this.id = id;
        this.nombre = nombre;
        this.empresa = empresa;
        this.cargo = cargo;
        this.pais = pais;
        this.mail = mail;
        this.numero_contacto = numero_contacto;
        this.productos = productos;
        this.usuarioRegistrador = usuarioRegistrador;
        this.status = status;
    }
     
}
