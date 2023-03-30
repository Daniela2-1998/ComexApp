package Daniela.ComexApp.Entity;

import java.util.List;
import java.util.logging.Logger;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author Daniela
 *
 */
@Entity
@Table(name = "costosProd")
public class CostosProduccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_costosp")
    private Integer id;

    @NotBlank
    private String producto;

    @NotBlank
    private int materia_prima;

    @NotBlank
    private int mano_de_obra;
    
    @NotBlank
    private int costo_total;

    @NotBlank
    private int cantidad;

    @NotBlank
    private String costo_unitario;

    @NotBlank
    private int gastos_extra;

    
    
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getMateria_prima() {
        return materia_prima;
    }

    public void setMateria_prima(int materia_prima) {
        this.materia_prima = materia_prima;
    }

    public int getMano_de_obra() {
        return mano_de_obra;
    }

    public void setMano_de_obra(int mano_de_obra) {
        this.mano_de_obra = mano_de_obra;
    }

    public int getCosto_total() {
        return costo_total;
    }

    public void setCosto_total(int costo_total) {
        this.costo_total = costo_total;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCosto_unitario() {
        return costo_unitario;
    }

    public void setCosto_unitario(String costo_unitario) {
        this.costo_unitario = costo_unitario;
    }

    public int getGastos_extra() {
        return gastos_extra;
    }

    public void setGastos_extra(int gastos_extra) {
        this.gastos_extra = gastos_extra;
    }

    
    
    public CostosProduccion() {
    }

    public CostosProduccion(Integer id, String producto, int materia_prima, int mano_de_obra, int costo_total, int cantidad, String costo_unitario, int gastos_extra) {
        this.id = id;
        this.producto = producto;
        this.materia_prima = materia_prima;
        this.mano_de_obra = mano_de_obra;
        this.costo_total = costo_total;
        this.cantidad = cantidad;
        this.costo_unitario = costo_unitario;
        this.gastos_extra = gastos_extra;
    }
   
  
    
   
}
