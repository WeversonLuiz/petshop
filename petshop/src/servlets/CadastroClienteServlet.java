package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Animal;
import model.Cliente;
import persistence.AnimalDao;
import persistence.ClienteDao;
import util.PetshopException;

@WebServlet("/CadastroCliente")
@ServletSecurity(value=@HttpConstraint(rolesAllowed="ADMINISTRADOR")
)
public class CadastroClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Cliente cliente = new Cliente();
	private AnimalDao animalDao = new AnimalDao();
	private ClienteDao clienteDao = new ClienteDao();
	HttpSession session;
       
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String method = request.getMethod();
    	String action = request.getParameter("action");
    	session = request.getSession();
    	
    	
    	if("GET".equals(method)){
    		if (action != null && action.equalsIgnoreCase("alterar")) {
				editarCliente(request, response);
			}
    		if (action != null && action.equalsIgnoreCase("listarClientes")) {
				listarCliente(request, response);
			}
    		if (action != null && action.equalsIgnoreCase("cliente")) {
    			session.setAttribute("cliente", null);
				doGet(request, response);
			}
    		if (action != null && action.equalsIgnoreCase("excluirCliente")) {
				excluirCliente(request, response);
			}
    
        } else if("POST".equalsIgnoreCase(method)){
        	if (action.equalsIgnoreCase("salvar")) {
				salvarCadastro(request, response);
			}
        	if (action.equalsIgnoreCase("adicionarAnimal")) {
				adicionarAnimaisNaLista(request, response);
			}
        	if (action.equalsIgnoreCase("alterar")) {
				editarCliente(request, response);
			}
        } 
    }


	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("cadastroCliente.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("cadastroCliente.jsp").forward(request, response);
    }
    
    public void adicionarAnimaisNaLista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Animal animal = new Animal();
    	cliente = (Cliente) session.getAttribute("cliente");
    	if (cliente == null) {
			cliente = new Cliente();
		}
    	animal.setRaca(request.getParameter("raca"));
		animal.setCor(request.getParameter("cor"));
		animal.setNomeAnimal(request.getParameter("animal"));
		animal.setPeso(Double.parseDouble(request.getParameter("peso")));
		
		if(!cliente.getAnimais().contains(animal)){
			cliente.getAnimais().add(animal);
			session.setAttribute("cliente",cliente);
		}
    	doPost(request, response);
    }
    
    public void removerAnimaisSaLista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<Animal> animais = cliente.getAnimais();
    	String animal = request.getParameter("animal");
		animais.remove(animal);
		
		request.setAttribute("animais",animais);
    	doPost(request, response);
    }
    
    public void salvarCadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	cliente.setNome(request.getParameter("nomeCliente"));
    	cliente.setCpf(request.getParameter("cpf"));
    	cliente.setTelefone(request.getParameter("telefone"));
    	
    	if (cliente != null) {
			try {
				clienteDao.alterar(cliente);
				cliente = new Cliente();
				session.setAttribute("cliente", null);
			} catch (PetshopException e) {
				e.printStackTrace();
			}
		}
    	doPost(request, response);
    }
    
    public void editarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String idCliente = request.getParameter("idCliente");
    	session = request.getSession();
    	try {
			Cliente clienteAlterar = clienteDao.consultar(Integer.parseInt(idCliente));
			cliente = clienteAlterar;
			session.setAttribute("cliente", clienteAlterar);
			response.sendRedirect("cadastroCliente.jsp");
		} catch (PetshopException e) {
			e.printStackTrace();
		}
    	
    }
    
    public void listarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<Cliente> clientes;
		try {
			clientes = clienteDao.listar();
			request.setAttribute("clientes",clientes);
		} catch (PetshopException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("listarClientes.jsp").forward(request, response);
    }
    
    public void excluirCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String idCliente = request.getParameter("idCliente");
    	try {
			clienteDao.excluir(Integer.parseInt(idCliente));
			listarCliente(request, response);
		} catch (PetshopException e) {
			e.printStackTrace();
		}
    }
    
	
}
