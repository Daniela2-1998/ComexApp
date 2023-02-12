package Daniela.ComexApp.Repository;

import Daniela.ComexApp.Entity.ColoresPaginaPrincipal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Daniela
 */
@Repository
public interface ColoresPaginaPrincipalRepository extends JpaRepository <ColoresPaginaPrincipal, Integer>{
    
    
}
