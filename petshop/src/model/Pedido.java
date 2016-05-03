package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
 
@Entity
public class Pedido {
 
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pedido_seq")
    @SequenceGenerator(name="pedido_seq", sequenceName="pedido_seq", allocationSize=1, initialValue=1)
    private int id;
    
    private Date data;
    
    private Date dataServico;
    
    private SimpleDateFormat hora;
     
    @ManyToOne
    private Cliente cliente;
     
    @OneToMany(cascade=CascadeType.ALL, mappedBy="pedido")
    private List<ItemPedido> itens = new ArrayList<ItemPedido>();
    
    public Pedido(){
    	
    }
     
    public void addProduto(Produto produto){
        ItemPedido novoItem = new ItemPedido(produto, this);
        if(itens.contains(novoItem)){
            ItemPedido item = itens.get(itens.indexOf(novoItem));
            item.setQuantidade(item.getQuantidade()+1);
        }else{
            itens.add(novoItem);
        }
    }

    public void removerItem(ItemPedido item){
        itens.remove(item);
    }
     
    public double getPrecoTotal(){
        double preco = 0;
        for(ItemPedido item : itens){
            preco += item.getPrecoTotal();
        }
        return preco;
    }
     
    public boolean equals(Object obj) {
        try {
            Pedido p = (Pedido) obj;
            return p.getId() == id;
        } catch (Exception e) {
            return false;
        }
    }
 
    public Date getData() {
        return data;
    }
 
    public void setData(Date data) {
        this.data = data;
    }
 
    public Cliente getCliente() {
        return cliente;
    }
 
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
 
    public List<ItemPedido> getItens() {
        return itens;
    }
 
    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }
 
    public int getId() {
        return id;
    }

	public Date getDataServico() {
		return dataServico;
	}

	public void setDataServico(Date dataServico) {
		this.dataServico = dataServico;
	}

	public SimpleDateFormat getHora() {
		return hora;
	}

	public void setHora(SimpleDateFormat hora) {
		this.hora = hora;
	}
    
}