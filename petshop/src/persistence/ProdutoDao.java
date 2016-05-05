package persistence;

import java.util.List;

import javax.persistence.Query;

import model.Produto;
import util.PetshopException;

public class ProdutoDao extends Persistencia<Produto>{

	public ProdutoDao() {
		super(Produto.class);
	}
	
	public List<Produto> listar() throws PetshopException{
		Query query = em.createQuery("select p from Produto p");
		return query.getResultList();
	}

}
