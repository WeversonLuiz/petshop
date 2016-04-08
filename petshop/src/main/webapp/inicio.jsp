<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">PetShop</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="inicio.jsp">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Agendamento <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="novoAgendamento.jsp"><i class="glyphicon glyphicon-plus-sign"></i>Novo agendamento</a></li>
          <li><a href="listarAgendamentos.jsp"><i class="glyphicon glyphicon-search"></i>Visualizar agendamentos</a></li>
        </ul>
      </li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Cadastro <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="cadastroAnimais.jsp"><i class="glyphicon glyphicon-user"></i>Animais</a></li>
          <li><a href="servicos.jsp"><i class="glyphicon glyphicon-shopping-cart"></i>Serviços</a></li>
        </ul>
      </li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Administrar <span class="caret"></span></a>  
        <ul class="dropdown-menu">
          <li><a href="visualizarCliente.jsp"><i class="glyphicon glyphicon-wrench"></i>Visualizar clientes</a></li>
        </ul>
      </li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
       <li class="dropdown"><a  class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-cog"></span> Usuário</a>
         <ul class="dropdown-menu">
          <li>
             <a href="#"><i class="glyphicon glyphicon-user"></i> Meu cadastro</a>
           </li>
           <li>
             <a href="#"><i class="glyphicon glyphicon-lock"></i> Redefinir senha</a>
           </li>
           <li>
             <a href="#" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal"><i class="glyphicon glyphicon-off"></i> Sair</a>
             <!-- class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal -->
           </li>
        </ul>
       </li>     
     </ul>
    </ul>
  </div>
  <!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="class="data-toggle="modal" data-target="#myModal">Modal Header</h4>
      </div>
      <div class="modal-body">
        <p>Some text in the modal.</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>
</nav>

</body>
</html>
<!-- 
<head>
	<title>Menu Horizontal</title>
	<style type="text/css">
	<!--
		body {
			padding:0px;
			margin:0px;
		}
 
		#menu ul {
			padding:0px;
			margin:0px;
			float: left;
			width: 100%;
			background-color:#EDEDED;
			list-style:none;
			font:80% Tahoma;
		}
 
		#menu ul li { display: inline; }
 
		#menu ul li a {
			background-color:#EDEDED;
			color: #333;
			text-decoration: none;
			border-bottom:3px solid #EDEDED;
			padding: 2px 10px;
			float:left;
		}
 
		#menu ul li a:hover {
			background-color:#D6D6D6;
			color: #6D6D6D;
			border-bottom:3px solid #EA0000;
		}
	</style>
</head>
 
<body>
	<div id="menu">
		<ul>
			<li><a href="">Home</a></li>
			<li><a href="">Sobre</a></li>
			<li><a href="">Artigos</a></li>
			<li><a href="">Estudos</a></li>
			<li><a href="">Diretório</a></li>
			<li><a href="">CURSO</a></li>
			<li><a href="">Links</a></li>
			<li><a href="">Contato</a></li>
		</ul>
	</div>
</body>
</html>
-->
