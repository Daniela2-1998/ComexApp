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
@Table (name = "fondoPantalla")
public class FondoPaginaPrincipal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fondo")
    private Integer id;

    @NotBlank
    private String fondo;

    @NotBlank
    private String usuario;

    
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFondo() {
        return fondo;
    }

    public void setFondo(String fondo) {
        this.fondo = fondo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    
    
    public FondoPaginaPrincipal() {
    }

    public FondoPaginaPrincipal(Integer id, String fondo, String usuario) {
        this.id = id;
        this.fondo = fondo;
        this.usuario = usuario;
    }
    

}
