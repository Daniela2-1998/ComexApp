package Daniela.ComexApp.Entity;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author Daniela
 */
@Entity
@Table(name="importadores")
public class Importadores {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_importador")
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

    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "operaciones_compraint",
            joinColumns = @JoinColumn(name = "id_operaciones"))
    List<Operaciones> operaciones;

    
    
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

    public List<Operaciones> getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(List<Operaciones> operaciones) {
        this.operaciones = operaciones;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    
    
    
    public Importadores() {
    }

    public Importadores(Integer id, String empresa, String empleado, String pais, String CUIT, String mail, String numero_contacto, String productos_pedidos, List<Operaciones> operaciones) {
        this.id = id;
        this.empresa = empresa;
        this.empleado = empleado;
        this.pais = pais;
        this.CUIT = CUIT;
        this.mail = mail;
        this.numero_contacto = numero_contacto;
        this.productos_pedidos = productos_pedidos;
        this.operaciones = operaciones;
    }

    
}
