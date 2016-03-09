package ru.bisoft.socialservice.ejb.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ru.bisoft.socialservice.model.UpdateFile;

@Stateless
@LocalBean
public class UpdateFileEJB {
	@PersistenceContext
	EntityManager em;

	public UpdateFileEJB() {
		super();
	}
	
	public UpdateFile getUpdateFile (String version)
	{
		return em.createNamedQuery("UpdateFile.getUpdateFile", UpdateFile.class).setParameter("versionUpdateFile", version).getSingleResult();
	}
	
	public String getLastVersion ()
	{
		UpdateFile u = new UpdateFile();
		u.setVersionUpdateFile("1.0.1.5");
		u.setDataUpdateFile("hello".getBytes());

		//em.persist(u);
		return em.createNamedQuery("UpdateFile.getLastVersion", String.class).getSingleResult();
	}
}
