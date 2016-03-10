package ru.bisoft.socialservice.ejb.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
