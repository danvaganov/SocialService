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

import ru.bisoft.socialservice.model.Profession;

/**
 * Session Bean implementation class ProfessionEJB
 */
@Stateless
@LocalBean
public class ProfessionEJB {
	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public ProfessionEJB() {
        // TODO Auto-generated constructor stub
    }
    
    public Profession findById(Integer ID) {
		return em.find(Profession.class, ID);
	}
    
    public List<Profession> find(Integer startIndex, Integer pageSize, Map<String, Object> filters)
	{
		CriteriaBuilder cb = em.getCriteriaBuilder();
		List<Predicate> predicateList = new ArrayList<Predicate>();
		
		CriteriaQuery<Profession> query = cb.createQuery(Profession.class);
		Root<Profession> root = query.from(Profession.class);
		//Join<Person, PersonOrganization> join = root.join("personOrganizationList");
		query.select(root);
		query.orderBy(cb.asc(root.get("id")));
		//predicateList.add(cb.equal(join.<String>get("organization"), organization));
		
		for (Map.Entry<String, Object> entry: filters.entrySet())
			predicateList.add(cb.like(cb.lower(root.<String>get(entry.getKey())), entry.getValue().toString() + "%"));
		query.where(cb.and(predicateList.toArray(new Predicate[predicateList.size()])));
		
		return em.createQuery(query).setFirstResult(startIndex).setMaxResults(pageSize).getResultList();
	}
}
