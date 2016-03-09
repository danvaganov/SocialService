package ru.bisoft.socialservice.jsf.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;

import ru.bisoft.socialservice.ejb.dao.ProfessionEJB;
import ru.bisoft.socialservice.model.Profession;

public class ProfessionBean {
	@EJB
	ProfessionEJB professionEJB;
	
	public List<Profession> complete(String query)
	{
		Map<String, Object> filters = new HashMap<String, Object> ();
		filters.put("name", query);
		//filters.put("nameArticle", query);
		return professionEJB.find(0, 10, filters);
	}
}
