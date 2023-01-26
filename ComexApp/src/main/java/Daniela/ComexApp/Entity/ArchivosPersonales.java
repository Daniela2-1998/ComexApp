package Daniela.ComexApp.Entity;

import java.io.File;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author Daniela
 */
@Entity
@Table (name = "archivosPersonales")
public class ArchivosPersonales {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_archivo_pers")
    private Integer id;

    @NotBlank
    private String nombre;

    @NotBlank
    private File archivo;

    @NotBlank
    private String fecha_carga;

    
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public String getFecha_carga() {
        return fecha_carga;
    }

    public void setFecha_carga(String fecha_carga) {
        this.fecha_carga = fecha_carga;
    }
    

    
    
    public ArchivosPersonales() {
    }

    public ArchivosPersonales(Integer id, String nombre, File archivo, String fecha_carga) {
        this.id = id;
        this.nombre = nombre;
        this.archivo = archivo;
        this.fecha_carga = fecha_carga;
    }


    
}
