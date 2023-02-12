package Daniela.ComexApp.Repository;

import Daniela.ComexApp.Entity.PreguntasDeSeguridad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Daniela
 */
@Repository
public interface PreguntasDeSeguridadRepository extends JpaRepository <PreguntasDeSeguridad, Integer>{
    
    
}
