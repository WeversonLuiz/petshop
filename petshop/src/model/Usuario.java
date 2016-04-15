package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

//@Entity
public class Usuario {
	
//	@Id
//	@GeneratedValue(generator="usuario_seq", strategy=GenerationType.SEQUENCE)
//	@SequenceGenerator(name="usuario_seq", sequenceName="usuario_seq", allocationSize=1, initialValue=1)
	private int idUsuario;
	
	private int login;
	
	private int senha;
	
	public Usuario(){
		
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getLogin() {
		return login;
	}

	public void setLogin(int login) {
		this.login = login;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}
	
}