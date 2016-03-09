package ru.bisoft.socialservice.jsf.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;

import ru.bisoft.socialservice.ejb.dao.EducationEJB;
import ru.bisoft.socialservice.model.Education;

public class EducationBean {
	@EJB
	EducationEJB educationEJB;
	
	public List<Education> complete(String query)
	{
		Map<String, Object> filters = new HashMap<String, Object> ();
		filters.put("nameEducation", query);
		//filters.put("nameArticle", query);
		return educationEJB.find(0, 10, filters);
	}
}
