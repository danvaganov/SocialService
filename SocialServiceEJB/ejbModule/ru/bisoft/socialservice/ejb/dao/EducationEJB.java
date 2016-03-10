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

import ru.bisoft.socialservice.model.Education;

/**
 * Session Bean implementation class EducationEJB
 */
@Stateless
@LocalBean
public class EducationEJB {
	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public EducationEJB() {
		// TODO Auto-generated constructor stub
	}

	// @Override
	public Education findById(Integer ID) {
		return em.find(Education.class, ID);
	}

	public Education find(String name) {
		try {
			return em.createNamedQuery("Education.findByName", Education.class).setParameter("nameEducation", name).getSingleResult();
		} catch (Exception e) {

		}
		return null;
	}

	public List<Education> find(Integer startIndex, Integer pageSize, Map<String, Object> filters) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		List<Predicate> predicateList = new ArrayList<Predicate>();

		CriteriaQuery<Education> query = cb.createQuery(Education.class);
		Root<Education> root = query.from(Education.class);
		// Join<Person, PersonOrganization> join =
		// root.join("personOrganizationList");
		query.select(root);
		query.orderBy(cb.asc(root.get("keyEducation")));
		// predicateList.add(cb.equal(join.<String>get("organization"),
		// organization));

		for (Map.Entry<String, Object> entry : filters.entrySet())
			predicateList.add(cb.like(cb.lower(root.<String> get(entry.getKey())), entry.getValue().toString() + "%"));
		query.where(cb.and(predicateList.toArray(new Predicate[predicateList.size()])));

		return em.createQuery(query).setFirstResult(startIndex).setMaxResults(pageSize).getResultList();
	}
}
