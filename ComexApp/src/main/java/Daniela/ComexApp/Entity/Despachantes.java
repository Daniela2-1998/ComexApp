package Daniela.ComexApp.Entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author Daniela
 */
@Entity
@Table(name = "despachantes")
public class Despachantes {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_despachantes")
    private Integer id;
    
    @NotBlank
    private String empresa;

    @NotBlank
    private String empleado;

    @NotBlank
    private String pais;

    @NotBlank
    private String mail;

    @NotBlank
    private String numero_contacto;

    @NotBlank
    private String productos_asociados;

    @NotBlank
    private String status;
    
    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "operaciones_despachante",
            joinColumns = @JoinColumn(name = "id_operaciones"))
    List<OperacionesInternacionales> operaciones;

    
    
    
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

    public List<OperacionesInternacionales> getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(List<OperacionesInternacionales> operaciones) {
        this.operaciones = operaciones;
    }

    
    
    
    public Despachantes() {
    }

    public Despachantes(Integer id, String empresa, String empleado, String pais, String mail, String numero_contacto, String productos_asociados, String status, List<OperacionesInternacionales> operaciones) {
        this.id = id;
        this.empresa = empresa;
        this.empleado = empleado;
        this.pais = pais;
        this.mail = mail;
        this.numero_contacto = numero_contacto;
        this.productos_asociados = productos_asociados;
        this.status = status;
        this.operaciones = operaciones;
    }
    
    
}
