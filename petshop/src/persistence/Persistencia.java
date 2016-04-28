package persistence;
import javax.persistence.EntityManager;

import util.EMConnection;
import util.PetshopException;

public class Persistencia <E>{
	private Class<E> classe;
	protected EntityManager em;
	
	public Persistencia(Class<E> classe) {
		this.classe = classe;
		em = EMConnection.createEM();
	}
	
	public void abrirTransacao(){
		em.getTransaction().begin();
	}
	
	public void commitTransacao(){
		em.getTransaction().commit();
	}
	
	public void fechar(){
		em.close();
	}
	

	public void incluir(E v) throws PetshopException{
		try {
			if (em == null) {
				em = EMConnection.createEM();
			}
			abrirTransacao();
			em.merge(v);
			commitTransacao();
		} catch (Exception e) {
			throw new PetshopException("Erro ao realizar a inclusão");
		}
	}
	
	public void excluir(Object id) throws PetshopException{
		try {
			abrirTransacao();
			E obj = em.find(classe, id);
			em.remove(obj);
			commitTransacao();
		} catch (Exception e) {
			throw new PetshopException("Erro ao realizar a exclusão");
		}
	}
	
	public E alterar(E v) throws PetshopException{
		try {
			abrirTransacao();
			E obj = em.merge(v);
			commitTransacao();
			return obj;
		} catch (Exception e) {
			throw new PetshopException("Erro ao realizar a alteração");
		}
	}
	
	public E consultar(Object id) throws PetshopException{
		try {
			return em.find(classe, id);
		} catch (Exception e) {
			throw new PetshopException("Erro ao realizar a consulta");
		}
	}

}