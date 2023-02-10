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
@Table (name = "coloresPaginaPrincipal")
public class ColoresPaginaPrincipal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_colores")
    private Integer id;

    @NotBlank
    private String color;

    @NotBlank
    private String usuario;
    
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    
    
    
    public ColoresPaginaPrincipal() {
    }

    public ColoresPaginaPrincipal(Integer id, String color, String usuario) {
        this.id = id;
        this.color = color;
        this.usuario = usuario;
    }
    
    
}
