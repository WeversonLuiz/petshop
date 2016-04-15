<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script language="JavaScript" type="text/javascript" src="js/carregarFrame.js"></script>
<link rel=stylesheet href="css/estilo.css">
<title>Insert title here</title>
</head>
<body>
<%@ include file="menuTopo.jsp" %>
	<div class="container" style="padding-top: 80px;">
        <div class="row">
            <div class="container">
                <div class="col-md-8">
                    <h1>Cadastro de animais</h1>
                    <p>Preencha os campos abaixo informando os dados corretamente</p>
                    <br />
                    <form class="form-horizontal" method="post" action="CadastroAnimalServlet" role="form">
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
                                <input type="textarea" id="observacao" class="form-control" name="observacao"
                                    placeholder="Descreva as observações que achar necessárias" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-10">
                                <button type="submit" class="btn btn-default">Cadastrar</button>
                            </div>
                        </div>
 
                    </form>
                </div>
            </div>
        </div>
    </div>
	

</body>
</html>