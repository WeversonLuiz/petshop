package br.com.senaigo.servlets;

import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;

@WebServlet("/InicioServlet") 
@ServletSecurity(value=@HttpConstraint(rolesAllowed = {"NORMAL"}), httpMethodConstraints={ 
	@HttpMethodConstraint(value="GET", rolesAllowed="USUARIO"), 
	@HttpMethodConstraint(value="POST", rolesAllowed={"ADMINISTRADOR", "GERENTE"}) } ) 
public class InicioServlet extends javax.servlet.http.HttpServlet { 
	//. . . 
}


