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

import ru.bisoft.socialservice.model.Organization;

/**
 * Session Bean implementation class PersonEducationEJB
 */
@Stateless
@LocalBean
public class OrganizationEJB {
	@PersistenceContext
	EntityManager em;

	public OrganizationEJB() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Organization findByName(String nameOrganization) {
		try {
			return em.createNamedQuery("Organization.findByName", Organization.class).setParameter("nameOrganization", nameOrganization).getSingleResult();
		} catch (Exception e) {

		}
		return null;
	}

	public Organization findByINN(String innOrganization) {
		try {
			return em.createNamedQuery("Organization.findByINN", Organization.class).setParameter("innOrganization", innOrganization).getSingleResult();
		} catch (Exception e) {

		}
		return null;
	}
	
	public Organization findById(Integer ID) {
		return em.find(Organization.class, ID);
	}
	
	public List<Organization> find(Integer startIndex, Integer pageSize, Map<String, Object> filters)
	{
		CriteriaBuilder cb = em.getCriteriaBuilder();
		List<Predicate> predicateList = new ArrayList<Predicate>();
		
		CriteriaQuery<Organization> query = cb.createQuery(Organization.class);
		Root<Organization> root = query.from(Organization.class);
		query.select(root);
		query.orderBy(cb.asc(root.get("id")));
		
		for (Map.Entry<String, Object> entry: filters.entrySet())
			predicateList.add(cb.like(cb.lower(root.<String>get(entry.getKey())), entry.getValue().toString() + "%"));
		query.where(cb.and(predicateList.toArray(new Predicate[predicateList.size()])));
		
		return em.createQuery(query).setFirstResult(startIndex).setMaxResults(pageSize).getResultList();
	}

	public void insert(Organization arg0) {
		em.persist(arg0);
	}

	// @Override
	public void update(Organization arg0) {
		em.merge(arg0);
	}

	// @Override
	public void delete(Organization arg0) {
		em.remove(arg0);
	}

	// @Override
	public void delete(Integer ID) {
		em.remove(em.find(Organization.class, ID));
	}
}
