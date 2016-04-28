package util;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMConnection {
	
	public EMConnection(){}
	
	private static EntityManagerFactory em;
	
	private static EntityManagerFactory createEMF(){
		if(em == null){
			em = Persistence.createEntityManagerFactory("petshop");
		}
		return em;
	}
	
	public static EntityManager createEM(){
		return createEMF().createEntityManager();
	}
}