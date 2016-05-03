package persistence;
import java.util.List;

import javax.persistence.Query;

import model.Role;
import util.PetshopException;

public class RoleDao extends Persistencia<Role>{

    public RoleDao() {
        super(Role.class);
    }

    public List<Role> listar() throws PetshopException{
        Query query = em.createQuery("select r from Role r");
        return query.getResultList();
    }
}