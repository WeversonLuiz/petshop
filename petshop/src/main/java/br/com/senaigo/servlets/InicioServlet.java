package br.com.senaigo.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InicioServlet") 
@ServletSecurity(value=@HttpConstraint(rolesAllowed = {"NORMAL"}), httpMethodConstraints={ 
	@HttpMethodConstraint(value="GET", rolesAllowed="USUARIO"), 
	@HttpMethodConstraint(value="POST", rolesAllowed={"ADMINISTRADOR", "GERENTE"}) } ) 
public class InicioServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public InicioServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	
}


