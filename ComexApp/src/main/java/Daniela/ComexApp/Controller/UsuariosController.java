package Daniela.ComexApp.Controller;

import Daniela.ComexApp.Entity.Usuarios;
import Daniela.ComexApp.Repository.UsuariosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


/**
 *
 * @author Daniela
 */
@Controller
public class UsuariosController {
    
    @Autowired
    private UsuariosRepository usuariosRepository;
    
    Usuarios usuarios = new Usuarios();
    
    @GetMapping
    public String listAll(Model model){
        List <Usuarios> listaUsuarios = usuariosRepository.findAll();
        return "usuarios";
    }
    
   
    
    @PostMapping
    public Usuarios save(String usuario, String contraseña, String nombre, String apellido, 
            String rol, String mail, String telefono, String status, int id){

        usuarios.setId(id);
        usuarios.setNombre(nombre);
        usuarios.setApellido(apellido);
        usuarios.setRol(rol);
        usuarios.setMail(mail);
        usuarios.setTelefono(telefono);
        usuarios.setUsuario(usuario);
        usuarios.setContraseña(contraseña);
        usuarios.setStatus(status);
        
        return usuariosRepository.save(usuarios);
    }
            
        
            
            
           
}



