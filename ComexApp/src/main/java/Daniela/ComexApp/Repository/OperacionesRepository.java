package Daniela.ComexApp.Repository;

import Daniela.ComexApp.Entity.OperacionesInternacionales;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Daniela
 */
public interface OperacionesRepository extends JpaRepository <OperacionesInternacionales, Integer>{
    
    
}
