package ru.bisoft.socialservice.jsf.converter;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import ru.bisoft.socialservice.ejb.dao.EducationEJB;
import ru.bisoft.socialservice.model.Education;

public class EducationConverter implements Converter{

	@EJB
	EducationEJB educationEJB;
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		return educationEJB.findById(Integer.valueOf(arg2));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return String.valueOf(((Education) arg2).getKeyEducation());
	}
}
