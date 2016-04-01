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
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ru.bisoft.socialservice.model.Organization;
import ru.bisoft.socialservice.model.Person;
import ru.bisoft.socialservice.model.PersonOrganization;
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
	
	public Long getCount(Organization organization) {
		return (Long) em.createNamedQuery("PersonService.getCountByOrganization").setParameter("organization", organization).getSingleResult();
	}
	
	public List<PersonService> find(Organization organization, Integer startIndex, Integer pageSize, Map<String, Object> filters) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		List<Predicate> predicateList = new ArrayList<Predicate>();

		CriteriaQuery<PersonService> query = cb.createQuery(PersonService.class);
		Root<PersonService> root = query.from(PersonService.class);
		Join<Person, PersonOrganization> join = root.join("person");
		query.select(root);
		query.orderBy(cb.desc(root.get("id")));
		predicateList.add(cb.equal(root.<String> get("organization"), organization));

		for (Map.Entry<String, Object> entry : filters.entrySet())
			predicateList.add(cb.like(cb.lower(join.<String> get(entry.getKey())), entry.getValue().toString() + "%"));
		query.where(cb.and(predicateList.toArray(new Predicate[predicateList.size()])));

		return em.createQuery(query).setFirstResult(startIndex).setMaxResults(pageSize).getResultList();
	}
}
