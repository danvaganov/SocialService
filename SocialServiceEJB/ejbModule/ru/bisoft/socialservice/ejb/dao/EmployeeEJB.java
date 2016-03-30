package ru.bisoft.socialservice.ejb.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ru.bisoft.socialservice.model.Employee;

/**
 * Session Bean implementation class EmployeeEJB
 */
@Stateless
@LocalBean
public class EmployeeEJB {
	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public EmployeeEJB() {
        // TODO Auto-generated constructor stub
    }
    
    
    
    //@Override
  	public void insert(Employee arg0) {
  		em.persist(arg0);
  	}

  	//@Override
  	public void update(Employee arg0) {
  		em.merge(arg0);
  	}

  	//@Override
  	public void delete(Employee arg0) {
  		em.remove(arg0);
  	}
}
