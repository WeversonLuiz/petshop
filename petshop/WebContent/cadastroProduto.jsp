<%@page import="model.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="css/fileinput.css" media="all" rel="stylesheet" type="text/css" />
<script src="js/google_apis_jquery.min.js"></script>
<script src="js/fileinput.js" type="text/javascript"></script>
<script src="js/fileinput_locale_pt-BR.js" type="text/javascript"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js" type="text/javascript"></script>


<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome/css/font-awesome.css">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link rel=stylesheet href="css/estilo.css">

<title>Petshop</title>

</head>
<body>
<%@ include file="menuTopo.jsp" %>
    <div class="container">
        <div class="row">
            <div class="container">
                <div class="col-md-12">
                    <div class="col-md-6">
                        <h1>Cadastro de produtos</h1>
                        <p>Preencha os campos abaixo informando os dados corretamente</p>
                        <br />
                        <form class="form-horizontal" method="post" action="ProdutoServlet?action=salvar" role="form" name="formProduto" >
                        <input type="hidden" name="action" value="salvar"/>
                            <div class="form-group">
                                <label for="codigo" class="col-sm-3 control-label">Código</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" id="codigo" name="codigo" value="${produto.codigo}" placeholder="Digite aqui o código do produto" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="descricao" class="col-sm-3 control-label">Descrição</label>
                                <div class="col-sm-6">
                                    <input type="text" id="descricao" class="form-control" name="descricao" value="${produto.descricao}" placeholder="Digite a descrição do produto" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="preco" class="col-sm-3 control-label">Preço</label>
                                <div class="col-sm-6">
                                    <input type="text" id="preco" class="form-control" name="preco" value="${produto.preco }" placeholder="Digite o valor do produoto" />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="radio">
                                    <div>
                                        <label for="servico" class="col-sm-5 control-label">Serviço?
                                              <label><input type="radio" name="servico" id="sim" value="true"/>Sim</label>
                                              <label><input type="radio" name="servico" id="nao" value="false"/>Não</label>
                                          </label>
                                      </div>
                                      <div>
                                          <label for="ativo" class="col-sm-5 control-label">Ativo?
                                              <label><input type="radio" name="ativo" id="sim" value="true">Sim</label>
                                              <label><input type="radio" name="ativo" id="nao" value="false">Não</label>
                                          </label>
                                      </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6" style="margin-top: 100px">
                     		    <label class="control-label">Select File</label>
    							<input id="input-2" name="file" type="file" class="file" multiple data-show-upload="false" data-show-caption="true">
                        </div>
                        </div>
                     <div class="col-md-4">
                         <div class="col-sm-offset-1 col-sm-10">
                         <button type="submit" class="btn btn-success" onclick="$('#cadastroSucesso').load('cadastrar.do?nome=blabla&quantidade=1');" >Cadastrar</button>
                     </div>
            </div>
            </div>
        </div>
        </br>
        <div class="table-responsive">         
              <table class="table" id="produtos">
                <thead>
                  <tr>
                    <th>ID</th>
                    <th>Código</th>
                    <th>Descrição</th>
                    <th>Preço</th>
                    <th>Serviço</th>
                    <th>Ativo</th>
                    <th style="width: 50px">Editar</th>
                    <th style="width: 50px">Desativar</th>
                  </tr>
                </thead>
                <tbody>
                       <c:forEach items="${produtos}" var="produto">
                      <tr>
                        <td><c:out value="${produto.id}" /></td>
                        <td><c:out value="${produto.codigo}" /></td>
                        <td><c:out value="${produto.descricao}" /></td>
                        <td><c:out value="${produto.preco}" /></td>
                        <td><c:out value="${produto.servico}" /></td>
                        <td><c:out value="${produto.ativo}" /></td>
                        <td><a href="ProdutoServlet?action=alterar&id=${produto.id}" class="btn btn-warning" data-toggle="modal" data-target="#myModalAnimais"><i class="glyphicons glyphicons-cat"></i>Alterar</a></td>
                        <td><a href="ProdutoServlet?action=destivar&id=${produto.id}" class="btn btn-danger" data-toggle="modal" data-target="#myModalAnimais"><i class="glyphicons glyphicons-cat"></i>Destivar</a></td>
                      </tr>
                     </c:forEach>
                </tbody>
              </table>
          </div>
          </form>
    </div>
     </br>

</body>
</html>