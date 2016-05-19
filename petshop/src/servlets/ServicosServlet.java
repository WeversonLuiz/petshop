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

import model.Produto;
import persistence.ProdutoDao;
import util.PetshopException;

/**
 * Servlet implementation class ServicosServlet
 */
@WebServlet("/ServicosServlet")
@ServletSecurity(value=@HttpConstraint(rolesAllowed="ADMINISTRADOR, USUARIO")
)
public class ServicosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProdutoDao produtoDao = new ProdutoDao();
	HttpSession session;

    public ServicosServlet() {
        super();
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String method = request.getMethod();
    	String action = request.getParameter("action");
    	String name = request.getParameter("name");
    	session = request.getSession();
    	
    	if("GET".equals(method)){
    		if (name != null && name.equalsIgnoreCase("servicos")) {
    				listarServicos(request, response);
    		}
    		if (action != null && action.equalsIgnoreCase("sair")) {
    			
    		}
    		
        } else if("POST".equalsIgnoreCase(method)){
        	
        } 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("servicos.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void listarServicos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Produto> servicos;
		try {
			servicos = produtoDao.listarServicos();
			request.setAttribute("servicos", servicos);
		} catch (PetshopException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("servicos.jsp").forward(request, response);
	}

}
