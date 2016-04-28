package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Animal;
import model.Cliente;
import persistence.AnimalDao;
import persistence.ClienteDao;

@WebServlet("/CadastroAnimalServlet")
@ServletSecurity(value=@HttpConstraint(rolesAllowed="ADMINISTRADOR")
)
public class CadastroAnimalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
    public CadastroAnimalServlet() {
        super();
    }
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("cadastroAnimais.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
