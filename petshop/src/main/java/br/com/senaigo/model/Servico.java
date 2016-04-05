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
}
