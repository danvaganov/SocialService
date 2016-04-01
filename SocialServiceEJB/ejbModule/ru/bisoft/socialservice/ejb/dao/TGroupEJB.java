package ru.bisoft.socialservice.ejb.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ru.bisoft.socialservice.model.TGroup;


/**
 * Session Bean implementation class TGroupEJB
 */
@Stateless
@LocalBean
public class TGroupEJB {
	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public TGroupEJB() {
        // TODO Auto-generated constructor stub
    }

    public List<TGroup> find(Integer startIndex, Integer pageSize, Map<String, Object> filters)
	{
		CriteriaBuilder cb = em.getCriteriaBuilder();
		List<Predicate> predicateList = new ArrayList<Predicate>();
		
		CriteriaQuery<TGroup> query = cb.createQuery(TGroup.class);
		Root<TGroup> root = query.from(TGroup.class);
		query.select(root);
		query.orderBy(cb.asc(root.get("groupIDTGroup")));
		
		for (Map.Entry<String, Object> entry: filters.entrySet())
			predicateList.add(cb.like(cb.lower(root.<String>get(entry.getKey())), entry.getValue().toString() + "%"));
		query.where(cb.and(predicateList.toArray(new Predicate[predicateList.size()])));
		
		return em.createQuery(query).setFirstResult(startIndex).setMaxResults(pageSize).getResultList();
	}
    
    public TGroup findById(Integer ID) {
		return em.find(TGroup.class, ID);
	}
    
    //@Override
  	public void insert(TGroup arg0) {
  		em.persist(arg0);
  	}

  	//@Override
  	public void update(TGroup arg0) {
  		em.merge(arg0);
  	}

  	//@Override
  	public void delete(TGroup arg0) {
  		em.remove(arg0);
  	}
}
