<%@page import="model.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome/css/font-awesome.css">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link rel=stylesheet href="css/estilo.css">
<title>Insert title here</title>
</head>
<body>
<%@ include file="menuTopo.jsp" %>
	<div class="container" style="padding-top: 30px;">
        <div class="row">
            <div class="container">
                <div class="col-md-12">
                    <h1>Cadastro de clientes</h1>
                    <p>Preencha os campos abaixo informando os dados corretamente</p>
                    <br />
                    <form class="form-horizontal" method="post" action="CadastroCliente" role="form">
                    <input type="hidden" name="action" value="salvar"/>
                        <div class="form-group">
                            <label for="nomeCliente" class="col-sm-1 control-label">Nome</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="nomeCliente" name="nomeCliente" value="${cliente.nome}" placeholder="Digite aqui o seu nome" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="cpf" class="col-sm-1 control-label">CPF</label>
                            <div class="col-sm-6">
                                <input type="text" id="cpf" class="form-control" name="cpf" value="${cliente.cpf}" placeholder="Digite o seu CPF" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="telefone" class="col-sm-1 control-label">telefone</label>
                            <div class="col-sm-6">
                                <input type="text" id="telefone" class="form-control" name="telefone" value="${cliente.telefone }" placeholder="EX: (22)2222-2222" />
                            </div>
                        </div>
 						<div class="form-group">
                            <label for="login" class="col-sm-1 control-label">Login</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="login" name="login" value="${cliente.usuario.login}" placeholder="Digite aqui o seu nome" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="senha" class="col-sm-1 control-label">Senha</label>
                            <div class="col-sm-6">
                                <input type="password" id="senha" class="form-control" name="senha" value="${cliente.usuario.senha}" placeholder="Digite sua senha" />
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="col-sm-offset-3 col-sm-10">
                                <button type="submit" class="btn btn-success" onclick="$('#cadastroSucesso').load('cadastrar.do?nome=blabla&quantidade=1');" >Cadastrar</button>
                           
                            	<a href="#" class="btn btn-info" data-toggle="modal" data-target="#myModalAnimais"><i class="glyphicons glyphicons-cat"></i>Adicionar</a>
                            </div>
 						</div>
                </div>
            </div>
        </div>
        </br>
        <div class="table-responsive">          
			  <table class="table" id="animais">
			    <thead>
			      <tr>
			        <th>Nome</th>
			        <th>Raça</th>
			        <th>Cor</th>
			        <th>Peso</th>
			        <th style="width: 50px">Editar</th>
			        <th style="width: 50px">Remover</th>
			      </tr>
			    </thead>
			    <tbody>
			   		<c:forEach items="${cliente.animais}" var="animal">
				      <tr>
				        <td><c:out value="${animal.nomeAnimal}" /></td>
				        <td><c:out value="${animal.raca}" /></td>
				        <td><c:out value="${animal.cor}" /></td>
				        <td><c:out value="${animal.peso}" /></td>
				        <td><a href="#myModalAnimais?action=alterar&idAnimal=${animal.idAnimal}" class="btn btn-warning" data-toggle="modal" data-target="#myModalAnimais"><i class="glyphicons glyphicons-cat"></i>Alterar</a></td>
				        <td><a href="CadastroCliente?action=removerAnimal&placa=${animal.idAnimal}" class="btn btn-danger" data-toggle="modal" data-target="#myModalAnimais"><i class="glyphicons glyphicons-cat"></i>Remover</a></td>
				      </tr>
				     </c:forEach>
			    </tbody>
			  </table>
  		</div>
  		</form>
    </div>
     </br>

      <!-- Modal -->
<div id="myModalAnimais" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="class="data-toggle="modal" data-target="#myModal"><h2>Cadastro de animais</h2></h4>
      </div>
      <div class="modal-body">
       			 <form class="form-horizontal" method="post" action="CadastroCliente?action=adicionarAnimal" role="form">
                        <div class="form-group">
                            <label for="nome" class="col-sm-3 control-label">Nome do animal</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="animal" name="animal"
                                    placeholder="Digite aqui o nome do animal" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="raca" class="col-sm-3 control-label">Raça</label>
                            <div class="col-sm-6">
                                <input type="text" id="raca" class="form-control" name="raca"
                                    placeholder="Digite aqui a raça do animal" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="cor" class="col-sm-3 control-label">Cor</label>
                            <div class="col-sm-6">
                                <input type="text" id="cor" class="form-control" name="cor"
                                    placeholder="Digite a cor do animal" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="peso" class="col-sm-3 control-label">Peso</label>
                            <div class="col-sm-6">
                                <input type="text" id="peso" class="form-control" name="peso"
                                    placeholder="Informe o peso do animal" />
                            </div>
                        </div>
                           <div class="form-group">
                            <label for="observacao" class="col-sm-3 control-label">Observações</label>
                            <div class="col-sm-6">
                                <input type="textarea" id="observacao" class="form-control" name="observacao" placeholder="Descreva as observações que achar necessárias" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-10">
                                <button type="submit" class="btn btn-sucess" id="adicionarAnimal">Cadastrar</button>
                            </div>
                        </div>
                    </form>
                <div id="cadastroSucesso"></div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>
	

</body>
</html>