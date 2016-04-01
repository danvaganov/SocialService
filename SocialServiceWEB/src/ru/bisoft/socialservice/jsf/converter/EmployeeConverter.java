package ru.bisoft.socialservice.jsf.converter;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import ru.bisoft.socialservice.ejb.dao.EmployeeEJB;
import ru.bisoft.socialservice.model.Employee;

public class EmployeeConverter implements Converter{

	@EJB
	EmployeeEJB employeeEJB;
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		return employeeEJB.findById(Integer.valueOf(arg2));
	}
	
	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return String.valueOf(((Employee) arg2).getKeyEmployee());
	}
}
