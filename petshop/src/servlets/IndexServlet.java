package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Produto;
import persistence.ProdutoDao;
import util.PetshopException;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProdutoDao produtoDao = new ProdutoDao();
	
//	private List<Produto> listaProdutos = new ArrayList<>();
	HttpSession session;

    public IndexServlet() {
        super();
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String method = request.getMethod();
    	String action = request.getParameter("action");
    	session = request.getSession();
    	
    	if ("GET".equals(method)) {
			if (action == null) {
				listarProdutos(request, response);
			}
		}
    }

	private void listarProdutos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		List<Produto> produtos;
		try {
			produtos = produtoDao.listar();
			request.setAttribute("produtos",produtos);
		} catch (PetshopException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("inicio.jsp").forward(request, response);
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("inicio.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
