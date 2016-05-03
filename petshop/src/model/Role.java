package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Role {

	@Id
	@GeneratedValue(generator="role_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="role_seq", sequenceName="role_seq", allocationSize=1, initialValue=1)
	private int id;
	
	private String role;
	
	public Role(){
		
	}
	
	public Role(String role){
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
