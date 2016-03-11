package ru.bisoft.socialservice.jsf.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;

import org.primefaces.model.LazyDataModel;

import ru.bisoft.socialservice.ejb.dao.OrganizationEJB;
import ru.bisoft.socialservice.model.Organization;
import ru.bisoft.socialservice.model.Service;

public class OrganizationBean extends LazyDataModel<Service>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	OrganizationEJB organizationEJB;
	
	Organization selection;
	
	public OrganizationBean() {
		super();
	}
	
	public List<Organization> complete(String query)
	{
		Map<String, Object> filters = new HashMap<String, Object> ();
		filters.put("name", query);
		return organizationEJB.find(0, 10, filters);
	}
}
