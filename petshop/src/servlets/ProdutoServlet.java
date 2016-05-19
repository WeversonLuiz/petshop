package servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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

import model.Produto;

import org.apache.commons.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

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
	
	private static final String UPLOAD_DIRECTORY = "image_upload";
	    // upload settings
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
	
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
	
	public void tratarImagem(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		 // checks if the request actually contains upload file
        if (!ServletFileUpload.isMultipartContent(request)) {
            // if not, we stop here
            PrintWriter writer = response.getWriter();
            writer.println("Error: Form must has enctype=multipart/form-data.");
            writer.flush();
            return;
        }

        // configures upload settings
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // sets memory threshold - beyond which files are stored in disk
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // sets temporary location to store files
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);

        // sets maximum size of upload file
        upload.setFileSizeMax(MAX_FILE_SIZE);

        // sets maximum size of request (include file + form data)
        upload.setSizeMax(MAX_REQUEST_SIZE);

        // constructs the directory path to store upload file
        // this path is relative to application's directory
        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;

        // creates the directory if it does not exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        try {
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = (List)upload.parseRequest((RequestContext) request);
            String fileName1 = "";
            if (formItems != null && formItems.size() > 0) {
            	for (FileItem item : formItems) {
            	    // processes only fields that are not form fields
            	    if (!item.isFormField()) {
            	        String fileName = new File(item.getName()).getName();
            	        fileName1+=fileName;
            	        String filePath = uploadPath + File.separator + fileName;
            	        File storeFile = new File(filePath);
            	        // saves the file on disk
            	        item.write(storeFile);
            	    } else {
            	        //here...
            	        String fieldname = item.getFieldName();
            	        String fieldvalue = item.getString();
            	        if (fieldname.equals("p_data")) {
            	            //logic goes here...
            	        } else if (fieldname.equals("upload_wall_gallery")) {
            	            //next logic goes here...
            	        }
            	    }
                }
            }
            String p_text = request.getParameter("p_data");
            String gallery_nm = request.getParameter("upload_wall_gallery");
            out.println(p_text);
            out.println(gallery_nm);
            //out.println("Upload has been done successfully!"+fileName1);
        } catch (Exception ex) {
            out.println(ex.getMessage());
        }

	}


}
