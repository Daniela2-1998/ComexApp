package Daniela.ComexApp.Controller;

import Daniela.ComexApp.Repository.AereoRepository;
import Daniela.ComexApp.Repository.ContenedoresRepository;
import Daniela.ComexApp.Repository.ExportadoresRepository;
import Daniela.ComexApp.Repository.ImportadoresRepository;
import Daniela.ComexApp.Repository.MaritimasRepository;
import Daniela.ComexApp.Repository.OperacionesRepository;
import Daniela.ComexApp.Repository.VentaLocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Daniela
 */
@Controller
public class AdminController {
    
    @Autowired
    private AereoRepository aereoRepository;
    
    @Autowired
    private ContenedoresRepository contenedoresRepository;
    
    @Autowired
    private ExportadoresRepository exportadoresRepository;
    
    @Autowired
    private ImportadoresRepository importadoresRepository;
    
    @Autowired
    private MaritimasRepository maritimasRepository;
    
    @Autowired
    private OperacionesRepository operacionesRepository;
    
    @Autowired
    private VentaLocalRepository ventaLocalRepository;
}
