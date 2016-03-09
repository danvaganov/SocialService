package ru.bisoft.socialservice.ejb.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ru.bisoft.socialservice.model.PersonDocument;

/**
 * Session Bean implementation class PersonDocumentEJB
 */
@Stateless
@LocalBean
public class PersonDocumentEJB {
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public PersonDocumentEJB() {
        // TODO Auto-generated constructor stub
    }

    public void insert(PersonDocument arg0) {
		em.persist(arg0);
	}

	//@Override
	public void update(PersonDocument arg0) {
		em.merge(arg0);
	}

	//@Override
	public void delete(PersonDocument arg0) {
		em.remove(arg0);
	}

	//@Override
	public void delete(Integer ID) {
		em.remove(em.find(PersonDocument.class, ID));
	}
}
