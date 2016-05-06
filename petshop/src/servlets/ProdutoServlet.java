package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cliente;
import model.Produto;
import persistence.ProdutoDao;
import util.ManipulaImagem;
import util.PetshopException;


@WebServlet("/ProdutoServlet")
@ServletSecurity(value=@HttpConstraint(rolesAllowed="ADMINISTRADOR")
)
public class ProdutoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private Produto produto = new Produto();
	
	private ProdutoDao produtoDao = new ProdutoDao();
	
	private List<Produto> listaProdutos = new ArrayList<>();
	
	ManipulaImagem manipulaImagem = new ManipulaImagem();
	
	HttpSession session;
	
    public ProdutoServlet() {
        super();
    }
    
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String method = request.getMethod();
    	String action = request.getParameter("action");
    	session = request.getSession();
    	
    	
    	if("GET".equals(method)){
    		if (action != null && action.equalsIgnoreCase("alterar")) {
				//editarProduto(request, response);
			}
    		if (action != null && action.equalsIgnoreCase("listarClientes")) {
				//editarProduto(request, response);
			}
    		if (action != null && action.equalsIgnoreCase("produto")) {
    			session.setAttribute("produto", null);
				doGet(request, response);
			}
    
        } else if("POST".equalsIgnoreCase(method)){
        	if (action.equalsIgnoreCase("salvar")) {
				salvarCadastro(request, response);
			}
//        	if (action.equalsIgnoreCase("adicionarProduto")) {
//				adicionarProdutoNaLista(request, response);
//			}
        } 
    }
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("cadastroProduto.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("cadastroProduto.jsp").forward(request, response);
    }
    
    public void salvarCadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	boolean servTemp = false;
    	boolean ativTemp = false;
    	produto.setCodigo(request.getParameter("codigo"));
    	produto.setDescricao(request.getParameter("descricao"));
    	produto.setPreco(Double.parseDouble(request.getParameter("preco")));
    	
    	
//    	B
//    	manipulaImagem.getImgBytes(image);
//    	produto.setImagem(Byte.parseByte[](request.getParameter("input7[]")));
    	String servico = request.getParameter("servico");
    	
    	if (servico == null || servico.equals(false)) {
    		servTemp = false;
		}else{
			servTemp = true;
		}
    	produto.setServico(servTemp);
    	
    	String ativo =  request.getParameter("ativo");
    	if (ativo.equals(false)) {
    		ativTemp = false;
		}else{
			ativTemp = true;
		}
    
    	produto.setAtivo(ativTemp);
    	
    	if (produto != null) {
			try {
				produtoDao.alterar(produto);
				produto = new Produto();
				listarProduto();
				request.setAttribute("produtos", null);
				session.setAttribute("produto", null);
			} catch (PetshopException e) {
				e.printStackTrace();
			}
		}
    	doPost(request, response);
    }

	private void listarProduto() {
		// TODO Auto-generated method stub
		
	}


}
