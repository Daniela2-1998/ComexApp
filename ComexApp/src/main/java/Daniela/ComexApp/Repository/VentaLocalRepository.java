package Daniela.ComexApp.Repository;

import Daniela.ComexApp.Entity.OperacionesNacionales;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Daniela
 */
public interface VentaLocalRepository extends JpaRepository <OperacionesNacionales, Integer>{
    
    
}
