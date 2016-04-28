<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List" %>
<%@ taglib prefix = "c" uri =  "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
<link rel="stylesheet" href="css/font-awesome/css/font-awesome.min.css"/>
<link href="css/sb-admin-2.css" rel="stylesheet"/>
<link rel=stylesheet href="css/estilo.css"/>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<title>Petshop</title>


</head>
<body>
	<%@ include file="menuTopo.jsp"%>
	 <div id="page-default">
        
            <div class="container">
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Cliente Cadastrados
                        </div>
                        </br>
                        <form action="post" class="col-md-12" id="pesquisa">
	                        <div class="col-md-12">
	                            <div class="col-md-1" style="margin-left: -30px">
	                            	<label for="focusedInput">Parametro</label>
	                            </div>
	                            <div class="col-md-3">
	                            	<input class="form-control" style="250px" id="focusedInput" type="text"/>
	                            </div>
	                            <div class="col-md-2" style="margin-left: -20px">
	                            	<button type="submit" class="btn btn-info">Buscar</button>
	                            </div>
	                            <div class="col-md-8">
	                            </div>
 							</div>
  						</form>
  						</br>
  						</br>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table width="100%" class="table table-striped table-bordered table-hover" id="clientes">
									  <thead>
									      <tr>
									        <th>Id</th>
									        <th>Nome</th>
									        <th>CPF</th>
									        <th>Telefone</th>
									        <th>Animais</th>
									        <th style="width: 50px">Editar</th>
									        <th style="width: 50px">Remover</th>
									      </tr>
									    </thead>
									    <tbody>
									   		<c:forEach items="${clientes}" var="cliente">
										      <tr>
										        <td><c:out value="${cliente.idCliente}" /></td>
										        <td><c:out value="${cliente.nome}" /></td>
										        <td><c:out value="${cliente.cpf}" /></td>
										        <td><c:out value="${cliente.telefone}" /></td>
										        <td><c:out value="${cliente.animais}" /></td>
										        <td><a href="CadastroCliente?action=alterar&idCliente=${cliente.idCliente}" class="btn btn-warning"><i class="glyphicons glyphicons-cat"></i>Alterar</a></td>
										        <td><a href="CadastroCliente?action=excluirCliente&idCliente=${cliente.idCliente}" class="btn btn-danger"><i class="glyphicons glyphicons-cat"></i>Excluir</a></td>
										      </tr>
										     </c:forEach>
									    </tbody>
									  </table>
                            	</div>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>

</body>
</html>