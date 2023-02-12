package Daniela.ComexApp.Repository;

import Daniela.ComexApp.Entity.Notas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Daniela
 */
@Repository
public interface NotasRepository extends JpaRepository <Notas, Integer>{
    
    
}
