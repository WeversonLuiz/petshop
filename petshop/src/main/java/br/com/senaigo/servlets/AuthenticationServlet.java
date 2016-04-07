package br.com.senaigo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.login.LoginContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.senaigo.security.SecurityCallbackHandler;

@WebServlet("/AuthenticationServlet")
public class AuthenticationServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		printWriter.println("<html><head><title>JAAS Web Authentication Tutorial</title></head><body>");
		
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		if (user != null && password != null) {
			SecurityCallbackHandler securityCallbackHandler = new SecurityCallbackHandler(user, password);
			boolean authenticatedFlag = true;
			try {
				LoginContext loginContext = new LoginContext("JaasTutorial", securityCallbackHandler);
				loginContext.login();
			} catch (Exception e) {
				authenticatedFlag = false;
				e.printStackTrace();
			}
			
			if(authenticatedFlag) printWriter.println("authentication success...");
			else printWriter.println("Authentication failure...");
			
		}else{
			printWriter.println("invalid authentication");
		}
		printWriter.println("</body></html>");
		
		
	}

}
