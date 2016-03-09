package ru.bisoft.socialservice.ejb.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ru.bisoft.socialservice.model.PersonProfession;

/**
 * Session Bean implementation class PersonProfessionEJB
 */
@Stateless
@LocalBean
public class PersonProfessionEJB {
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public PersonProfessionEJB() {
        // TODO Auto-generated constructor stub
    }

    public void insert(PersonProfession arg0) {
		em.persist(arg0);
	}

	//@Override
	public void update(PersonProfession arg0) {
		em.merge(arg0);
	}

	//@Override
	public void delete(PersonProfession arg0) {
		em.remove(arg0);
	}

	//@Override
	public void delete(Integer ID) {
		em.remove(em.find(PersonProfession.class, ID));
	}
}
