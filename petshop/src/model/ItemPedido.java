package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class ItemPedido {
	
	@Id
	@GeneratedValue(generator="item_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="item_seq", sequenceName="item_seq", allocationSize=1, initialValue=1)
	private int idItemServico;
	
	private int quantidade = 1;
	
	@ManyToOne
	private Produto produto;
	
	@ManyToOne
    private Pedido pedido;
	
	
	public double getPrecoTotal(){
        return quantidade * produto.getPreco();
    }
	
	public ItemPedido(Produto produto, Pedido pedido) {
		this.produto = produto;
		this.pedido = pedido;
	}

	public boolean equal(Object obj){
		try {
			ItemPedido item = (ItemPedido) obj;
			return item.getProduto().equals(produto) && item.getPedido().equals(pedido);
		} catch (Exception e) {
			return false;
		}
	}
	
	public int getIdItemServico() {
		return idItemServico;
	}
	public void setIdItemServico(int idItemServico) {
		this.idItemServico = idItemServico;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
}