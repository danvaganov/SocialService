package ru.bisoft.socialservice.ejb.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ru.bisoft.socialservice.model.PersonIncome;

/**
 * Session Bean implementation class PersonIncomeEJB
 */
@Stateless
@LocalBean
public class PersonIncomeEJB {
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public PersonIncomeEJB() {
        // TODO Auto-generated constructor stub
    }
    
    public void insert(PersonIncome arg0) {
		em.persist(arg0);
	}

	//@Override
	public void update(PersonIncome arg0) {
		em.merge(arg0);
	}

	//@Override
	public void delete(PersonIncome arg0) {
		em.remove(arg0);
	}

	//@Override
	public void delete(Integer ID) {
		em.remove(em.find(PersonIncome.class, ID));
	}
}
