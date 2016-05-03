package listners;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.Cliente;
import model.Role;
import model.Usuario;
import persistence.ClienteDao;
import persistence.RoleDao;
import util.PetshopException;

@WebListener
public class Inicializador implements ServletContextListener{
    
    private ClienteDao clienteDao = new ClienteDao();
    private RoleDao roleDao = new RoleDao();
    Usuario usuario = new Usuario();

    @Override
    public void contextInitialized(ServletContextEvent contextEvent) {
        Cliente cliente = new Cliente();
        
        try {
            
            List<Cliente> pessoas = clienteDao.listar();
            if (pessoas.isEmpty()) {
                cliente.setNome("administrador");
                cliente.setCpf("111.111.111-11");
                cliente.setTelefone("(11)1111-1111");
                
                usuario.setLogin("admin");
                usuario.setSenha("admin");
                
                List<Role> roles = roleDao.listar();
                if (roles.isEmpty()) {
                    usuario.getRoles().add(new Role("ADMIISTRADOR"));
                    usuario.getRoles().add(new Role("USUARIO"));
                }
                cliente.setUsuario(usuario);
                
                clienteDao.alterar(cliente);
            }
            
        } catch (PetshopException e) {
            e.printStackTrace();
        }
        
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent contextEvent) {
        
    }


}