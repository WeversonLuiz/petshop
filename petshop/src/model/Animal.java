package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Animal {
	
	@Id
	@GeneratedValue(generator="animal_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="animal_seq", sequenceName="animal_seq", allocationSize=1, initialValue=1)
	private int idAnimal;
	
	private String raca;
	
	private String cor;
	
	private String nomeAnimal;
	
	private double peso;
	
	public Animal(){
		
	}

	public int getIdAnimal() {
		return idAnimal;
	}
	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public String getNomeAnimal() {
		return nomeAnimal;
	}
	public void setNomeAnimal(String nomeAnimal) {
		this.nomeAnimal = nomeAnimal;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return nomeAnimal;
	}
	
}