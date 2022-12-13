package Daniela.ComexApp.Repository;

import Daniela.ComexApp.Entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Daniela
 */
public interface StockRepository extends JpaRepository <Stock, Integer>{
    
}
