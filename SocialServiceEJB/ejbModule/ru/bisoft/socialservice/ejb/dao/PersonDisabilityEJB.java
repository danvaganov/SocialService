package ru.bisoft.socialservice.ejb.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ru.bisoft.socialservice.model.PersonDisability;

/**
 * Session Bean implementation class PersonDisabilityEJB
 */
@Stateless
@LocalBean
public class PersonDisabilityEJB {
	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
	
    public PersonDisabilityEJB() {
        // TODO Auto-generated constructor stub
    }
    
	public void insert(PersonDisability arg0) {
		em.persist(arg0);
	}

	//@Override
	public void update(PersonDisability arg0) {
		em.merge(arg0);
	}

	//@Override
	public void delete(PersonDisability arg0) {
		em.remove(arg0);
	}

	//@Override
	public void delete(Integer ID) {
		em.remove(em.find(PersonDisability.class, ID));
	}

}
