package br.com.senaigo.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Servico {
	private int idServico;
	private Cliente cliente;
	private Double precoTotal;
	private Date dataServico;
	private SimpleDateFormat hora;
	private List<ItemServico> itensServico;
	
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
