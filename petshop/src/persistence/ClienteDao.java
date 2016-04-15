package persistence;
import java.util.List;

import javax.persistence.Query;

import model.Cliente;

public class ClienteDao extends Persistencia<Cliente> {
	public ClienteDao(){
		super(Cliente.class);
	}
	
	public Cliente updateCliente(Cliente cliente) throws Exception{
		return this.update(cliente);
	}
	
	public void inserirCliente(Cliente cliente){
		this.insert(cliente);
	}
	
	public void deleteCliente(int id){
		this.delete(id);
	}
	
	public Cliente consultarClientePorId(int id) throws Exception{
		return this.find(id);
	}
	
	public List<Cliente> listarClientePorNome(String nome){
		Query query = em.createQuery("SELECT c FROM CLIENTE c WHERE"
				+ " nomecliente like :nomeCliente");
		query.setParameter("nomecliente", "%"+nome+"%");
		return query.getResultList();
	}
	
	}