package persistence;
import java.util.List;

import javax.persistence.Query;

import util.PetshopException;
import model.Cliente;

public class ClienteDao extends Persistencia<Cliente> {
	public ClienteDao(){
		super(Cliente.class);
	}

	public List<Cliente> listarClientePorNome(String nome) throws PetshopException{
		Query query = em.createQuery("SELECT c FROM CLIENTE c WHERE"
				+ " nomecliente like :nomeCliente");
		query.setParameter("nomecliente", "%"+nome+"%");
		return query.getResultList();
	}

	public List<Cliente> listar() throws PetshopException{
		Query query = em.createQuery("select c from Cliente c");
		return query.getResultList();
	}

}