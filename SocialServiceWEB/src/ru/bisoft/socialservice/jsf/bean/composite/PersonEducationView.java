package ru.bisoft.socialservice.jsf.bean.composite;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;

import ru.bisoft.socialservice.ejb.dao.EducationEJB;
import ru.bisoft.socialservice.model.Education;
import ru.bisoft.socialservice.model.PersonEducation;

public class PersonEducationView {
	@EJB
	EducationEJB educationEJB;
	
	private PersonEducation personEducation;

	public PersonEducation getPersonEducation() {
		return personEducation;
	}

	public void setPersonEducation(PersonEducation personEducation) {
		this.personEducation = personEducation;
	}
	
	public List<Education> complete(String query)
	{
		Map<String, Object> filters = new HashMap<String, Object> ();
		filters.put("nameEducation", query);
		//filters.put("nameArticle", query);
		return educationEJB.find(0, 10, filters);
	}
}
