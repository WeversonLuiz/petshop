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
    private String descricao;
    private double preco;
    private boolean servico;
     
    public boolean equals(Object obj) {
        try {
            Produto p = (Produto) obj;
            return p.getDescricao().equals(descricao) && p.getId() == id;
        } catch (Exception e) {
            return false;
        }
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
    public int getId() {
        return id;
    }
	public boolean isServico() {
		return servico;
	}
	public void setServico(boolean servico) {
		this.servico = servico;
	}
    
     
}