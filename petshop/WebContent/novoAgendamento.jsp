<%@page import="model.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="js/jquery.js"></script>
<script src="js/login.js"></script>
<script src="js/login2.min.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome/css/font-awesome.css">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link rel=stylesheet href="css/estilo.css">

<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
<link href="css/fileinput.css" media="all" rel="stylesheet" type="text/css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="js/fileinput.js" type="text/javascript"></script>
<script src="js/fileinput_locale_pt-BR.js" type="text/javascript"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js" type="text/javascript"></script>

<title>Insert title here</title>
</head>
<body>
<%@ include file="menuTopoUsuario.jsp" %>
	<div class="container" style="padding-top: 80px;">
        <div class="row">
            <div class="container">
                <div class="col-md-12">
                    <h1>Agendamento de serviços</h1>
                    <p>Preencha os campos abaixo informando os dados corretamente</p>
                    <br />
                    <form class="form-horizontal" method="post" action="ServicoServlet" role="form" >
                    	<div class="col-md-12">
	                    	<input type="hidden" name="action" value="salvar"/>
							<div class="col-md-6">
								<div class="form-group">
									<label for="nomeCliente" class="col-sm-3 control-label">Nome</label>
									<div class="col-sm-6">
										<input type="text" class="form-control" id="nomeCliente" name="nomeCliente" value="${cliente.nome}" placeholder="Digite aqui o seu nome" />
									</div>
								</div>
								<div class="form-group">
									<label for="cpf" class="col-sm-3 control-label">CPF</label>
									<div class="col-sm-6">
										<input type="text" id="cpf" class="form-control" name="cpf" value="${cliente.cpf}" placeholder="Digite o seu CPF" />
									</div>
								</div>
								<div class="form-group">
									<label for="telefone" class="col-sm-3 control-label">telefone</label>
									<div class="col-sm-6">
										<input type="text" id="telefone" class="form-control" name="telefone" value="${cliente.telefone }" placeholder="EX: (22)2222-2222" />
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label for="sel1" class="col-sm-3 control-label">Serviço</label> 
										<div class="col-sm-6">
											<select class="form-control" id="sel1">
												<option>1</option>
												<option>2</option>
												<option>3</option>
												<option>4</option>
											</select>
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label for="sel2" class="col-sm-3 control-label">Horário</label> 
										<div class="col-sm-6">
											<select class="form-control" id="sel2" style="margin-left: 10px">
												<option>1</option>
												<option>2</option>
												<option>3</option>
												<option>4</option>
											</select>
										</div>
									</div>
								</div>
						</div>
                        <div class="col-md-4">
                            <div class="col-sm-offset-3 col-sm-10">
                                <button type="submit" class="btn btn-success" onclick="$('#cadastroSucesso').load('cadastrar.do?nome=blabla&quantidade=1');" >Cadastrar</button>
                            </div>
 						</div>
						</br>
					</form>
					</br>
				</div>
			</div>
		</div>	
		<div class="table-responsive">
			<table class="table" id="produtos">
				<thead>
					<tr>
						<th>Numero</th>
						<th>Nome</th>
						<th>CPF</th>
						<th>Telefone</th>
						<th>Serviço</th>
						<th>Horário</th>
						<th style="width: 50px">Editar</th>
						<th style="width: 50px">Cancelar</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="animais" var="animal">
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td><a href="#" class="btn btn-warning" data-toggle="modal" data-target="#myModalAnimais"><i class="glyphicons glyphicons-cat"></i>Alterar</a></td>
							<td><a href="#" class="btn btn-danger" data-toggle="modal" data-target="#myModalAnimais"><i class="glyphicons glyphicons-cat"></i>Cancelar</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
</body>
</html>