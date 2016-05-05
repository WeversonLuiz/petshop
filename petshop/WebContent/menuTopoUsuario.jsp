<!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Home</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="#">Sobre</a>
                    </li>
                    <li>
                        <a href="#">Serviços</a>
                    </li>
                    <li>
                        <a href="#">Contato</a>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="cadastroProduto.jsp">Login</a>
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
            <!-- /.navbar-collapse -->
        </div>
       </div>
       </nav>