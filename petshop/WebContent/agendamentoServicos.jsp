<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script language="JavaScript" type="text/javascript"
	src="js/carregarFrame.js"></script>
<link rel=stylesheet href="css/estilo.css">
<title>Petshop</title>


</head>
<body>
	<%@ include file="menuTopo.jsp"%>
	<div class="container">
		<div class="row">
			<div class="container">
					<div class="col-md-12">
						<h1>Agendamento de serviços</h1>
						<p>Preencha os campos abaixo informando os dados corretamente</p>
						<br />
					<form class="form-horizontal" method="post"
						action="CadastroCliente" role="form">
						<div class="col-md-8">
							<div class="form-group">
								<label for="nomeCliente" class="col-sm-1 control-label">Nome</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="nomeCliente"
										name="nomeCliente" placeholder="Digite aqui o seu nome" />
								</div>
							</div>
							<div class="form-group">
								<label for="cpf" class="col-sm-1 control-label">CPF</label>
								<div class="col-sm-8">
									<input type="text" id="cpf" class="form-control" name="cpf"
										placeholder="Digite o seu CPF" />
								</div>
							</div>
							<div class="form-group">
								<label for="telefone" class="col-sm-1 control-label">telefone</label>
								<div class="col-sm-8">
									<input type="text" id="telefone" class="form-control"
										name="telefone" placeholder="EX: (22)2222-2222" />
								</div>
							</div>
						</div>
						<div class="col-md-4" style="margin-top: -20px">
							<div class="form-group">
								<label for="sel1">Selecione o serviço</label> <select
									class="form-control" id="sel1">
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
								</select>
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label for="sel1">Selecione o horário</label> <select
									class="form-control" id="sel1">
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
								</select>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		</br>
		<div class="col-md-4">
			<div class="col-sm-offset-1">
				<button type="submit" class="btn btn-success"
					onclick="$('#cadastroSucesso').load('cadastrar.do?nome=blabla&quantidade=1');">Salvar</button>
			</div>
		</div>
		</br>
	</div>
	<div class="table-responsive">
		<table class="table" id="animais">
			<thead>
				<tr>
					<th>Numero</th>
					<th>Nome</th>
					<th>CPF</th>
					<th>Telefone</th>
					<th>Serviço</th>
					<th>Horário</th>
					<th style="width: 50px">Editar</th>
					<th style="width: 50px">Remover</th>
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
						<td><a href="#" class="btn btn-warning" data-toggle="modal"
							data-target="#myModalAnimais"><i
								class="glyphicons glyphicons-cat"></i>Alterar</a></td>
						<td><a href="#" class="btn btn-danger" data-toggle="modal"
							data-target="#myModalAnimais"><i
								class="glyphicons glyphicons-cat"></i>Remover</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	</div>
</body>
</html>