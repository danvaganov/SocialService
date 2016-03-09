package ru.bisoft.socialservice.ejb.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ru.bisoft.socialservice.model.PersonEducation;

/**
 * Session Bean implementation class PersonEducationEJB
 */
@Stateless
@LocalBean
public class PersonEducationEJB {
	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
	
    public PersonEducationEJB() {
        // TODO Auto-generated constructor stub
    }
    
	public void insert(PersonEducation arg0) {
		em.persist(arg0);
	}

	//@Override
	public void update(PersonEducation arg0) {
		em.merge(arg0);
	}

	//@Override
	public void delete(PersonEducation arg0) {
		em.remove(arg0);
	}

	//@Override
	public void delete(Integer ID) {
		em.remove(em.find(PersonEducation.class, ID));
	}
}
