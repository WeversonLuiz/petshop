<%
	session = request.getSession();
%>
<nav class="navbar navbar-inverse" navbar-fixed-top" role="navigation">
  <div class="container-fluid"">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">PetShop</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="inicio.jsp">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#" >Agendamento <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="NovoAgendamentoServlet"><i class="glyphicon glyphicon-plus-sign"></i>Novo agendamento</a></li>
          <li><a href="visualizarAgendadmento"><i class="glyphicon glyphicon-search"></i>Visualizar agendamentos</a></li>
        </ul>
      </li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#" >Cadastro <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="CadastroAnimalServlet"><i class="glyphicon glyphicon-user"></i>Animais</a></li>
          <li><a href="CadastroCliente?action=cliente"><i class="glyphicon glyphicon-shopping-cart"></i>Cliente</a></li>
          <li><a href="ServicosServlet"><i class="glyphicon glyphicon-shopping-cart"></i>Serviços</a></li>
        </ul>
      </li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Administrar <span class="caret"></span></a>  
        <ul class="dropdown-menu">
          <li><a href="CadastroCliente?action=listarClientes"><i class="glyphicon glyphicon-user"></i>Visualizar clientes</a></li>
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
  <!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="class="data-toggle="modal" data-target="#myModal">Logout</h4>
      </div>
      <div class="modal-body">
        <p>Tem certeza que voçê deseja siar?</p>
      </div>
      <div class="modal-footer">
      	<a href="CadastroCliente?action=sair" class="btn btn-danger"><i class="glyphicons glyphicons-cat"></i>Sair</a>
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>
</nav>