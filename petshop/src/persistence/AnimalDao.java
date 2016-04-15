package persistence;
import java.util.List;

import javax.persistence.Query;

import model.Animal;

public class AnimalDao extends Persistencia<Animal>{
	public AnimalDao(){
		super(Animal.class);
	}
	
	public Animal updateAnimal(Animal animal) throws Exception{
		return this.update(animal);
	}
	
	public void inserirAnimal(Animal animal){
		this.insert(animal);
	}
	
	public void deleteAnimal(int id){
		this.delete(id);
	}
	
	public Animal consultarAnimalPorId(int id) throws Exception{
		return this.find(id);
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