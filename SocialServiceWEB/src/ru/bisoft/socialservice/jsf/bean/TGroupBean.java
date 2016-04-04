package ru.bisoft.socialservice.jsf.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;

import ru.bisoft.socialservice.ejb.dao.TGroupEJB;
import ru.bisoft.socialservice.model.Service;
import ru.bisoft.socialservice.model.TGroup;

public class TGroupBean extends LazyDataModel<Service>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	TGroupEJB tGroupEJB;
	
	TGroup selection;

	public TGroupBean() {
		super();
	}
	
	public List<TGroup> complete(String query)
	{
		Map<String, Object> filters = new HashMap<String, Object> ();
		filters.put("groupIDTGroup", query);
		return tGroupEJB.find(0, 10);
	}
}
