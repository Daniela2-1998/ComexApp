package Daniela.ComexApp.Repository;

import Daniela.ComexApp.Entity.AgendaPersonal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Daniela
 */
@Repository
public interface AgendaPersonalRepository extends JpaRepository <AgendaPersonal, Integer>{
    
    
}
