package Daniela.ComexApp.Entity;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author Daniela
 *
 */
@Entity
@Table(name = "maritimas")
public class Maritimas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_maritima")
    private Integer id;

    @NotBlank
    private String empresa;

    @NotBlank
    private String empleado;

    @NotBlank
    private String email;
    
    @NotBlank
    private String numero_contacto;
    
    @NotBlank
    private String tipo_transporte;

    @NotBlank
    private String requisitos_aviso;

   
 
    
    
    public Maritimas() {
    }
    
    public Maritimas(Integer id, String empresa, String empleado, String email, String numero_contacto, String tipo_transporte, String requisitos_aviso) {
        this.id = id;
        this.empresa = empresa;
        this.empleado = empleado;
        this.email = email;
        this.numero_contacto = numero_contacto;
        this.tipo_transporte = tipo_transporte;
        this.requisitos_aviso = requisitos_aviso;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumero_contacto() {
        return numero_contacto;
    }

    public void setNumero_contacto(String numero_contacto) {
        this.numero_contacto = numero_contacto;
    }

    public String getTipo_transporte() {
        return tipo_transporte;
    }

    public void setTipo_transporte(String tipo_transporte) {
        this.tipo_transporte = tipo_transporte;
    }

    public String getRequisitos_aviso() {
        return requisitos_aviso;
    }

    public void setRequisitos_aviso(String requisitos_aviso) {
        this.requisitos_aviso = requisitos_aviso;
    }

        
        
    
  

}
