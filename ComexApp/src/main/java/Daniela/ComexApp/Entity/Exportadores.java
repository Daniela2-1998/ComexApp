package Daniela.ComexApp.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author Daniela
 *
 */
@Entity
@Table(name = "exportadores")
public class Exportadores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_exportador")
    private Integer id;

    @NotBlank
    private String empresa;

    @NotBlank
    private String empleado;

    @NotBlank
    private String pais;
    
    @NotBlank
    private String CUIT;

    @NotBlank
    private String mail;

    @NotBlank
    private String numero_contacto;

    @NotBlank
    private String productos_pedidos;

    @NotBlank
    private String status;
    
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getCUIT() {
        return CUIT;
    }

    public void setCUIT(String CUIT) {
        this.CUIT = CUIT;
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

    public String getProductos_pedidos() {
        return productos_pedidos;
    }

    public void setProductos_pedidos(String productos_pedidos) {
        this.productos_pedidos = productos_pedidos;
    }
    
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    
    public Exportadores() {
    }

    public Exportadores(Integer id, String empresa, String empleado, String pais, String CUIT,
            String mail, String numero_contacto, String productos_pedidos, String status) {
        this.id = id;
        this.empresa = empresa;
        this.empleado = empleado;
        this.pais = pais;
        this.CUIT = CUIT;
        this.mail = mail;
        this.numero_contacto = numero_contacto;
        this.productos_pedidos = productos_pedidos;
        this.status = status;
    }

}
