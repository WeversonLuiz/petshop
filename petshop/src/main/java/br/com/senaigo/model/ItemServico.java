package br.com.senaigo.model;

public class ItemServico {
	private int idItemServico;
	private Servico servico;
	private String descricao;
	private Double precoUnitario;
	
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(Double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	
}
