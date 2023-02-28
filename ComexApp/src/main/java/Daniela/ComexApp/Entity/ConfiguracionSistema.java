package Daniela.ComexApp.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author Daniela
 */
@Entity
@Table (name = "configuracion")
public class ConfiguracionSistema {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank
    private String empresa;

    @NotBlank
    private String admin_princ;

    @NotBlank
    private String admin_sec;
    
    @NotBlank
    private String admin_rep;

   
    
    
    
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

    public String getAdmin_princ() {
        return admin_princ;
    }

    public void setAdmin_princ(String admin_princ) {
        this.admin_princ = admin_princ;
    }

    public String getAdmin_sec() {
        return admin_sec;
    }

    public void setAdmin_sec(String admin_sec) {
        this.admin_sec = admin_sec;
    }

    public String getAdmin_rep() {
        return admin_rep;
    }

    public void setAdmin_rep(String admin_rep) {
        this.admin_rep = admin_rep;
    }

    
    
    
    public ConfiguracionSistema() {
    }

    public ConfiguracionSistema(Integer id, String empresa, String admin_princ, String admin_sec, String admin_rep) {
        this.id = id;
        this.empresa = empresa;
        this.admin_princ = admin_princ;
        this.admin_sec = admin_sec;
        this.admin_rep = admin_rep;
    }
    
}
