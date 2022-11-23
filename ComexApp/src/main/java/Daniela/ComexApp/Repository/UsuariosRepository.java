package Daniela.ComexApp.Repository;


import Daniela.ComexApp.Entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Daniela
 */
public interface UsuariosRepository extends JpaRepository <Usuarios, Integer>{
    
    
}
