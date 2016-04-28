<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet" href="css/login.css">
<script src="js/login.js"></script>
<title>Login</title>
</head>
<body>
	<div class="cont">
  <div class="demo">
    <div class="login">
      <div class="login__check"></div>
      <form action="j_security_check" method="post">
      <div class="login__form">
        <div class="login__row">
          <svg class="login__icon name svg-icon" viewBox="0 0 20 20">
            <path d="M0,20 a10,8 0 0,1 20,0z M10,0 a4,4 0 0,1 0,8 a4,4 0 0,1 0,-8" />
          </svg>
          <input type="text" class="login__input name" placeholder="Username" name="j_username"/>
        </div>
        <div class="login__row">
          <svg class="login__icon pass svg-icon" viewBox="0 0 20 20">
            <path d="M0,20 20,20 20,8 0,8z M10,13 10,16z M4,8 a6,8 0 0,1 12,0" />
          </svg>
          <input type="password" class="login__input pass" placeholder="Password" name="j_password" autocomplete="off"/>
        </div>
         <button type="submit" class="login__submit">Sign in</button>
        <p class="login__signup">Don't have an account? &nbsp;<a>Sign up</a></p>
      </div>
      </form>
    </div>
    <div class="app">
      <div class="app__top">
        <div class="app__menu-btn">
          <span></span>
        </div>
        <svg class="app__icon search svg-icon" viewBox="0 0 20 20">
          <!-- yeap, its purely hardcoded numbers straight from the head :D (same for svg above) -->
          <path d="M20,20 15.36,15.36 a9,9 0 0,1 -12.72,-12.72 a 9,9 0 0,1 12.72,12.72" />
        </svg>
      <div class="app__logout">
        <svg class="app__logout-icon svg-icon" viewBox="0 0 20 20">
          <path d="M6,3 a8,8 0 1,0 8,0 M10,0 10,12"/>
        </svg>
      </div>
    </div>
  </div>
</div>
<!-- 
	<fieldset style="width: 250px">
		<legend>Login de acesso ao sistema</legend>
		<form method="post" action="j_security_check">
			Login:<br><input type="text" name="j_username" size="20"/>
			<br>
			Senha:<br><input type="password" name="j_password" size="20" autocomplete="off"/>
			<br>
			<input type="submit" value="Entrar"/>
		</form>
	</fieldset>
	-->
</body>
</html>