<!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation" style="height: 30px">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="InicioServlet">Home</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="#">Sobre</a>
                    </li>
                    <li>
                        <a href="novoAgendamento.jsp">Agendamento</a>
                    </li>
                    <li>
                        <a href="#">Contato</a>
                    </li>
                </ul>
                <ul class="nav nav-pills pull-right">
                        <li class="dropdown " id="menuLogin" style="margin-top: 8px">
                            <div style="margin-left: 40px">
                            <a href="#" data-toggle="modal" data-target="#myModal"><i class="glyphicon glyphicon-off"></i>Logout</a>
                            </div>
                            <div class="dropdown-menu" style="padding:17px;">
                                <form id="formLogin" class="form" action="j_security_check" method="post"> 
                                    <label>Login</label> 
                                    <input name="_csrf" id="token" type="hidden" value="HHqpcK2q-_F_uaUz7xjvkQo12wVFAE_MWvTU">
    							    <input name="j_username" id="username" type="text" placeholder="Username" pattern="^[a-z,A-Z,0-9,_]{5,15}$" data-valid-min="5" title="Entre com seu usuário" required="">
    							    <input name="j_password" autocomplete="off" id="password" type="password" placeholder="Password" title="Enter your password" required=""><br>
    							    <button type="submit" id="btnLogin" class="btn">Login</button>
			            			<!-- class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal -->
    							</form>
                                <form><a href="#" title="Fast and free sign up!" id="btnNewUser" data-toggle="collapse" data-target="#formRegister">Novo usuário?</a></form>
                                <form id="formRegister" class="form collapse">
                                    <input name="_csrf" id="token" type="hidden" value="HHqpcK2q-_F_uaUz7xjvkQo12wVFAE_MWvTU">
                                    <input name="email" id="inputEmail" type="email" placeholder="Email" required="">
        						    <input name="username" id="inputUsername" type="text" placeholder="Username" pattern="^[a-z,A-Z,0-9,_]{6,15}$" data-valid-min="6" title="Choose a username" required=""><br>
    							    <input name="password" id="inputpassword" type="password" placeholder="Password" required=""> 
                                    <input name="verify" id="inputVerify" type="password" placeholder="Password (again)" required=""><br>                                  
    							    <button type="button" id="btnRegister" class="btn">Sign Up</button>
    							</form>
    							<!-- 
                                <a data-toggle="modal" role="button" href="#forgotPasswordModal">Forgot username or password?</a>
                                <a data-toggle="modal" role="button" href="#contactModal"><small>Need help? Contact us</small></a>
                                 -->
                            </div>
                        </li>
                        <li class="dropdown hide" id="menuUser">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" title="See your Bootply collection and profile">
                                <i class='icon-user icon-xxlarge'> </i> <span id="lblUsername"></span>
                                <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="/user">Dashboard</a></li>
                                <li><a href="/new">Create New Bootply</a></li>
                                
                                <li><a href="/logout">Logout</a></li>
                                <li class="divider"> </li>
                                <li><a href="/bootstrap-community">Community</a></li>
                                <li><a href="/about">About</a></li>
                            </ul>
                        </li>
                    </ul>
                <!--
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="cadastroProduto.jsp">Login</a>
                    </li>
                </ul>
                -->
                
	            <ul class="nav navbar-nav">
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
			     <!-- 
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
		      				<a href="InicioServlet?action=sair" class="btn btn-danger"><i class="glyphicons glyphicons-cat"></i>Sair</a>
		        			<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		      			</div>
		    		</div>
		
		  		</div>
			</div>
            <!-- /.navbar-collapse -->
        </div>
       </div>
       </nav>