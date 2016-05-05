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
<script type="text/javascript">jQuery(document).ready(function () {
!function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    p = /^http:/.test(d.location) ? 'http' : 'https';
    if (!d.getElementById(id)) {
        js = d.createElement(s);
        js.id = id;
        js.src = p + '://platform.twitter.com/widgets.js';
        fjs.parentNode.insertBefore(js, fjs);

    }
}
(document, "script", "twitter-wjs");
    $("#input-4").fileinput({showCaption: false});
    $("#input-6").fileinput({
        showUpload: false,
        maxFileCount: 10,
        mainClass: "input-group-lg"
    });
$('.navigate-top a').click(function () {
    $('body,html').animate({
        scrollTop: 0
    }, 800);
    return false;
});
$(function () { 
    $("[data-toggle=\'tooltip\']").tooltip(); 
});;
$(function () { 
    $("[data-toggle=\'popover\']").popover(); 
});
$('body').on('click', function (e) {
    //did not click a popover toggle or popover
    if ($(e.target).data('toggle') !== 'popover'
        && $(e.target).parents('.popover.in').length === 0) { 
        $('[data-toggle="popover"]').popover('hide');
    }
});
setTimeout(function() {
    $('.kv-webtips').removeClass('kv-animated-bell').addClass('kv-animated-bell');
}, 3000);
setTimeout(function() {
    if ($.trim($('.adsbygoogle').html()).length < 10) {
        $('.adblock-msg').slideDown('slow');
    }
}, 1000);
$('.adblock-msg .close').on('click', function(e) {
	$('.adblock-msg').slideUp('slow');
});
});
</script> 
<%@ include file="menuTopo.jsp" %>
	<div class="container" style="padding-top: 30px">
        <div class="row">
            <div class="container">
                <div class="col-md-12">
                    <h1>Cadastro de produtos</h1>
                    <p>Preencha os campos abaixo informando os dados corretamente</p>
                    <br />
                    <form class="form-horizontal" method="post" action="ProdutoServlet" role="form" name="formProduto">
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
                        		<label>Serviço?
	  								<label><input type="radio" name="servico" id="sim" value="true">Sim</label>
	  								<label><input type="radio" name="servico" id="nao" value="false">Não</label>
  								</label>
  								<label>Ativo?
	  								<label><input type="radio" name="ativo" id="sim" value="true">Sim</label>
	  								<label><input type="radio" name="ativo" id="nao" value="false">Não</label>
  								</label>
							</div>
                        </div>
                        <div>
                        	<label class="control-label">Select File</label>
							<input id="input-7" name="input7[]" multiple type="file" class="file file-loading" data-allowed-file-extensions='["jpg"]'>
                        </div>
                        <!-- 
                        <div class="fileupload fileupload-new" data-provides="fileupload">
						  <div class="fileupload-preview thumbnail" style="width: 320px; height: 150px;" id="img"></div>
						  <div>
						    <span class="btn btn-file"><span class="fileupload-new">Select image</span><span class="fileupload-exists">Change</span><input type="file" /></span>
						    <a href="#" class="btn fileupload-exists" data-dismiss="fileupload">Remove</a>
						  </div>
						</div>
						 -->        
                        
                        <div class="col-md-4">
                            <div class="col-sm-offset-3 col-sm-10">
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