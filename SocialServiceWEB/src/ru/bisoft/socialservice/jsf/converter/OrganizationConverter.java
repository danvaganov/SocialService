package ru.bisoft.socialservice.jsf.converter;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import ru.bisoft.socialservice.ejb.dao.OrganizationEJB;
import ru.bisoft.socialservice.model.Organization;

public class OrganizationConverter implements Converter{

	@EJB
	OrganizationEJB organizationEJB;
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		return organizationEJB.findById(Integer.valueOf(arg2));
	}
	
	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return String.valueOf(((Organization) arg2).getKeyOrganization());
	}
}
