package ru.bisoft.socialservice.ejb.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ru.bisoft.socialservice.model.Organization;
import ru.bisoft.socialservice.model.PersonService;

/**
 * Session Bean implementation class PersonServiceEJB
 */
@Stateless
@LocalBean
public class PersonServiceEJB {
	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public PersonServiceEJB() {
        // TODO Auto-generated constructor stub
    }

    public void insert(PersonService arg0) {
		em.persist(arg0);
	}

	//@Override
	public void update(PersonService arg0) {
		em.merge(arg0);
	}

	//@Override
	public void delete(PersonService arg0) {
		em.remove(arg0);
	}

	//@Override
	public void delete(Integer ID) {
		em.remove(em.find(PersonService.class, ID));
	}
	
	public List<PersonService> find (Organization organization)
	{
		return em.createNamedQuery("PersonService.findByOrganization", PersonService.class).setParameter("organization", organization).getResultList();
	}
}
