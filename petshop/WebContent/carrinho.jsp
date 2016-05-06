<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
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

		 <form class="form-horizontal" method="post" action="CarrinhoServlet" role="form" name="formProduto">
	
			<div class="table-responsive">         
	              <table class="table" id="produtos">
	                <thead>
	                  <tr>
	                    <th>Código</th>
	                    <th>Descrição</th>
	                    <th>Preço</th>
	                    <th>Comprar</th>
	                    <th style="width: 50px">Editar</th>
	                    <th style="width: 50px">Remover</th>
	                  </tr>
	                </thead>
	                <tbody>
	                       <c:forEach items="${produtos}" var="produto">
	                      <tr>
	                        <td><c:out value="${produto.codigo}" /></td>
	                        <td><c:out value="${produto.descricao}" /></td>
	                        <td><c:out value="${produto.preco}" /></td>
	                        <td>
	          					<form action="<c:url value="/carrinho"/>" method="POST">
	           					<input type="hidden" name="item.produto.id" value="${produto.id }"/>
	           					<input class="qtde" name="item.quantidade" value="1" style="width: 20px"/>
	            				<button type="submit" class="btn btn-success" onclick="$('#cadastroSucesso').load('cadastrar.do?nome=blabla&quantidade=1');" >Comprar</button>
	            				</form>
	                        </td>
	                        <td><a href="ProdutoServlet?action=alterar&id=${produto.id}" class="btn btn-warning" data-toggle="modal" data-target="#myModalAnimais"><i class="glyphicons glyphicons-cat"></i>Alterar</a></td>
	                        <td><a href="ProdutoServlet?action=destivar&id=${produto.id}" class="btn btn-danger" data-toggle="modal" data-target="#myModalAnimais"><i class="glyphicons glyphicons-cat"></i>Destivar</a></td>
	                      </tr>
	                     </c:forEach>
	                </tbody>
	              </table>
	         </div>
	      </form>
      </div>
</html>