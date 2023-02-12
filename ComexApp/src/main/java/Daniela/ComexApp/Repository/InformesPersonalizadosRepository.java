package Daniela.ComexApp.Repository;

import Daniela.ComexApp.Entity.InformesPersonalizados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Daniela
 */
@Repository
public interface InformesPersonalizadosRepository extends JpaRepository <InformesPersonalizados, Integer>{
    
    
}
