<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Login</title>
</head>
<body>
	<fieldset style="width: 250px">
		<legend>Login de acesso ao sistema</legend>
		<form method="post" action="j_security_check">
			Login:<br><input type="text" name="j_username" size="20"/>
			<br>
			Senha:<br><input type="password" name="j_password" size="20"/>
			<br>
			<input type="button" value="Entrar"/>
		</form>
	</fieldset>
</body>
</html>