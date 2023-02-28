package service;

import javax.swing.JTextField;

/**
 *
 * @author Daniela
 */
public interface ConfiguracionService {
    
    public boolean aplicarConfiguracion(String empresa, String adminPrincipal, 
            String adminSecundario, String adminExtra);
    
    public void modificarConfiguracion(String empresaMod, String adminPrincipalMod, 
            String adminSecundarioMod, String adminExtraMod);
    
    public void verSiHayConfiguracion(JTextField textAdminPrin, JTextField textAdminSec,
            JTextField textAdminRep, JTextField textEmpresa);
}
