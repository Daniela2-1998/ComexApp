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
@Table(name = "participantes_nacionales")
public class ParticipantesNacionales {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_part_nac")
    private Integer id;
    
    @NotBlank
    private String nombre;

    @NotBlank
    private String empresa;

    @NotBlank
    private String pais;
    
    @NotBlank
    private String tipo_operacion;

    @NotBlank
    private String mail;

    @NotBlank
    private String numero_contacto;

    @NotBlank
    private String productos_asociados;

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

    public String getTipo_operacion() {
        return tipo_operacion;
    }

    public void setTipo_operacion(String tipo_operacion) {
        this.tipo_operacion = tipo_operacion;
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

    public String getProductos_asociados() {
        return productos_asociados;
    }

    public void setProductos_asociados(String productos_asociados) {
        this.productos_asociados = productos_asociados;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    
    public ParticipantesNacionales() {
    }

    public ParticipantesNacionales(Integer id, String nombre, String empresa, 
            String pais, String tipo_operacion, String mail, String numero_contacto, 
            String productos_asociados, String status) {
        this.id = id;
        this.nombre = nombre;
        this.empresa = empresa;
        this.pais = pais;
        this.tipo_operacion = tipo_operacion;
        this.mail = mail;
        this.numero_contacto = numero_contacto;
        this.productos_asociados = productos_asociados;
        this.status = status;
    }
    
  
    
}
