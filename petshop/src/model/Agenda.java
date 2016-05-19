package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Agenda {
	
	@Id
	@GeneratedValue(generator="agenda_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="agenda_seq", sequenceName="agenda_seq", allocationSize=1, initialValue=1)
	private int id;
	
	@OneToMany
	private List<Produto> produtos;
	
	@OneToMany
	private List<Cliente> clientes;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataServico;
	
	private String procedmento;
	
	public Agenda(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Date getDataServico() {
		return dataServico;
	}

	public void setDataServico(Date dataServico) {
		this.dataServico = dataServico;
	}

	public String getProcedmento() {
		return procedmento;
	}

	public void setProcedmento(String procedmento) {
		this.procedmento = procedmento;
	}
	

}
