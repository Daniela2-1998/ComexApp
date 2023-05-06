package Daniela.ComexApp.Entity;

import java.sql.Time;
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
@Table(name = "empleados")
public class Empleados {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Integer id;
    
    @NotBlank
    private String empresa;

    @NotBlank
    private String empleado;

    private String usuario;

    @NotBlank
    private String area;
    
    @NotBlank
    private String cargo;
    
    @NotBlank
    private Time horario;
    
    @NotBlank
    private Time horario_salida;
    
    @NotBlank
    private Double sueldo;

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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Time getHorario() {
        return horario;
    }

    public void setHorario(Time horario) {
        this.horario = horario;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Time getHorario_salida() {
        return horario_salida;
    }

    public void setHorario_salida(Time horario_salida) {
        this.horario_salida = horario_salida;
    }

    
    
    public Empleados() {
    }

    public Empleados(Integer id, String empresa, String empleado, String usuario, String area, String cargo, Time horario, Time horario_salida, Double sueldo, String status) {
        this.id = id;
        this.empresa = empresa;
        this.empleado = empleado;
        this.usuario = usuario;
        this.area = area;
        this.cargo = cargo;
        this.horario = horario;
        this.horario_salida = horario_salida;
        this.sueldo = sueldo;
        this.status = status;
    }
 
}
