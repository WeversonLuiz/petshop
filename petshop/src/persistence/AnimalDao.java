package persistence;
import java.util.List;

import javax.persistence.Query;

import model.Animal;

public class AnimalDao extends Persistencia<Animal>{
	public AnimalDao(){
		super(Animal.class);
	}
	
	public List<Animal> listarAnimalPorNome(String nome){
		Query query = em.createQuery("SELECT a FROM ANIMAL a WHERE"
				+ " nomeanimal like :nomeAnimal");
		query.setParameter("nomeAnimal", "%"+nome+"%");
		return query.getResultList();
	}
	
	public List<Animal> listarAnimalPorRaca(String raca){
		Query query = em.createQuery("SELECT a FROM ANIMAL a WHERE"
				+ " racaanimal like :racaAnimal");
		query.setParameter("racaAnimal", "%"+raca+"%");
		return query.getResultList();
	}
}