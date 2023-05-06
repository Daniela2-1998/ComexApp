package Daniela.ComexApp.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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

    private String detalles;

    @NotBlank
    private double gastos_totales;
    
    @NotBlank
    private double gastos_pagados;
    
    @NotBlank
    private double gastos_sin_pagar;

    @NotBlank
    private String empresa;
    
    @NotBlank
    private String status;
   
    private String cuotas;
    
    private double monto_cuotas;
    
    private double intereses;
    
    

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

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public double getGastos_pagados() {
        return gastos_pagados;
    }

    public void setGastos_pagados(double gastos_pagados) {
        this.gastos_pagados = gastos_pagados;
    }

    public double getGastos_sin_pagar() {
        return gastos_sin_pagar;
    }

    public void setGastos_sin_pagar(double gastos_sin_pagar) {
        this.gastos_sin_pagar = gastos_sin_pagar;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getGastos_totales() {
        return gastos_totales;
    }

    public void setGastos_totales(double gastos_totales) {
        this.gastos_totales = gastos_totales;
    }

    public String getCuotas() {
        return cuotas;
    }

    public void setCuotas(String cuotas) {
        this.cuotas = cuotas;
    }

    public double getMonto_cuotas() {
        return monto_cuotas;
    }

    public void setMonto_cuotas(double monto_cuotas) {
        this.monto_cuotas = monto_cuotas;
    }

    public double getIntereses() {
        return intereses;
    }

    public void setIntereses(double intereses) {
        this.intereses = intereses;
    }

    
    
    
    public Gastos() {
    }

    
    public Gastos(Integer id, String conceptos, String detalles, double gastos_totales, double gastos_pagados, double gastos_sin_pagar, String empresa, String status, String cuotas, double monto_cuotas, double intereses) {
        this.id = id;
        this.conceptos = conceptos;
        this.detalles = detalles;
        this.gastos_totales = gastos_totales;
        this.gastos_pagados = gastos_pagados;
        this.gastos_sin_pagar = gastos_sin_pagar;
        this.empresa = empresa;
        this.status = status;
        this.cuotas = cuotas;
        this.monto_cuotas = monto_cuotas;
        this.intereses = intereses;
    }

}
