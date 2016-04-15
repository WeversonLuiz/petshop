package servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InicioServlet")  
public class InicioServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public InicioServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Principal userPrincipal = req.getUserPrincipal();
		String nome = userPrincipal.getName();
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("Bem vindo<h3>" + nome +"</h3>");
		
		resp.getWriter().write("Ola " + userPrincipal.getName());
		resp.flushBuffer();
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Principal userPrincipal = req.getUserPrincipal();
		String nome = userPrincipal.getName();
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("Bem vindo<h3>" + nome +"</h3>");
		
		resp.getWriter().write("Ola " + userPrincipal.getName());
		resp.flushBuffer();
	}
	
	
}