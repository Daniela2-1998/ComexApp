package Daniela.ComexApp.Repository;

import Daniela.ComexApp.Entity.MensajesObjetivos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Daniela
 */
@Repository
public interface MensajesObjetivosRepository extends JpaRepository <MensajesObjetivos, Integer>{
    
    
}
