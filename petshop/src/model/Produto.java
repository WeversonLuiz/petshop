package model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
 
@Entity
public class Produto {
 
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="produto_seq")
    @SequenceGenerator(name="produto_seq", sequenceName="produto_seq", allocationSize=1, initialValue=1)
    private int id;
    
    private String codigo;
    
    private String descricao;
    
    private double preco;
    
    private byte[] imagem;
    
    private Boolean servico;
    
    private Boolean ativo;
    
    public Produto(){
    	
    }
     
    public boolean equals(Object obj) {
        try {
            Produto p = (Produto) obj;
            return p.getDescricao().equals(descricao) && p.getId() == id;
        } catch (Exception e) {
            return false;
        }
    }
 
    public int getId() {
    	return id;
    }
    public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
	public Boolean isServico() {
		return servico;
	}
	public void setServico(Boolean servico) {
		this.servico = servico;
	}

	public Boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public byte[] getFoto() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}
	
	
     
}