package Daniela.ComexApp.Repository;

import Daniela.ComexApp.Entity.ObjetivosEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Daniela
 */
@Repository
public interface ObjetivosEmpresaRepository extends JpaRepository <ObjetivosEmpresa, Integer>{
    
    
}
