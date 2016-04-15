package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class ItemServico {
	
	@Id
	@GeneratedValue(generator="item_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="item_seq", sequenceName="item_seq", allocationSize=1, initialValue=1)
	private int idItemServico;
	
	@ManyToOne
	private Servico servico;
	@ManyToOne
	private Animal animal;
	
	private int quantidade;
	
	private Double totalItem;
	
	public ItemServico(Animal animal, Servico servico) {
		this.animal = animal;
		this.servico = servico;
	}
	
	public boolean equal(Object obj){
		try {
			ItemServico item = (ItemServico) obj;
			return item.getAnimal().equals(animal) && item.getServico().equals(servico);
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
	public Servico getServico() {
		return servico;
	}
	public void setServico(Servico servico) {
		this.servico = servico;
	}
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Double getTotalItem() {
		return totalItem;
	}
	public void setTotalItem(Double totalItem) {
		this.totalItem = totalItem;
	}
	
}