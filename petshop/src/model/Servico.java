package model;
import java.text.SimpleDateFormat;
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
public class Servico {
	
	@Id
	@GeneratedValue(generator="servico_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="servico_seq", sequenceName="servico_seq", allocationSize=1, initialValue=1)
	private int idServico;
	
	@ManyToOne
	private Cliente cliente;
	
	private Double precoTotal;
	
	private Date dataServico;
	
	private SimpleDateFormat hora;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="servico")
	private List<ItemServico> itensServico;
	
	public void addAnimal(Animal animal){
		ItemServico novoItem = new ItemServico(animal, this);
		if (itensServico.contains(novoItem)) {
			ItemServico item = itensServico.get(itensServico.indexOf(novoItem));
			item.setQuantidade(item.getQuantidade() + 1);
		}else{
			itensServico.add(novoItem);
		}
	}
	
	public void removerItem(ItemServico item){
		itensServico.remove(item);
	}
	
	public Servico(){
		
	}

	public int getIdServico() {
		return idServico;
	}

	public void setIdServico(int idServico) {
		this.idServico = idServico;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(Double precoTotal) {
		this.precoTotal = precoTotal;
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

	public List<ItemServico> getItensServico() {
		return itensServico;
	}

	public void setItensServico(List<ItemServico> itensServico) {
		this.itensServico = itensServico;
	}
	
}