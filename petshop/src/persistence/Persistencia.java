package persistence;
import javax.persistence.EntityManager;

public class Persistencia <E>{
	private Class<E> classe;
	protected EntityManager em;
	
	public Persistencia(Class<E> classe){
		this.classe = classe;
		em = EMConnection.createEM();
	}
	
	public void abrirTransacao(){
		em.getTransaction().begin();
	}

	public void close(){
		em.close();
	}
	
	public void commit(){
		em.getTransaction().commit();
	}
	
	public void rollback(){
		em.getTransaction().rollback();
	}
	
	public void insert(E model){
		try{
			this.abrirTransacao();
			em.persist(model);
			this.commit();
		}catch(Exception ex){
			this.rollback();
		}finally {
			this.close();
		}
	}
	
	public void delete(Object id){
		try{
			this.abrirTransacao();
			E model = em.find(classe, id);
			em.remove(model);
			this.commit();
		}catch(Exception ex){
			this.rollback();
		}finally{
			this.close();
		}
	}
	
	public E update(E model) throws Exception{
		try{
			this.abrirTransacao();
			E obj = em.merge(model);
			this.commit();
			return obj;
		}catch(Exception e){
			this.rollback();
			throw new Exception("");
		}finally{
			this.close();
		}
	}
	
	public E find(Object id) throws Exception{
		try{
			return em.find(classe, id);
		}catch(Exception ex){
			throw new Exception("");
		}
	}
	
}