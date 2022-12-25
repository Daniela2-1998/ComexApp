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
@Table(name = "gastosOperaciones")
public class Gastos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gasto")
    private Integer id;

    @NotBlank
    private String conceptos;

    @NotBlank
    private String gastos_totales;

    @NotBlank
    private String empresa;
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConceptos() {
        return conceptos;
    }

    public void setConceptos(String conceptos) {
        this.conceptos = conceptos;
    }

    public String getGastos_totales() {
        return gastos_totales;
    }

    public void setGastos_totales(String gastos_totales) {
        this.gastos_totales = gastos_totales;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    
    public Gastos() {
    }

    public Gastos(Integer id, String conceptos, String gastos_totales, String empresa) {
        this.id = id;
        this.conceptos = conceptos;
        this.gastos_totales = gastos_totales;
        this.empresa = empresa;
    }
    

 

    
   
 
}
