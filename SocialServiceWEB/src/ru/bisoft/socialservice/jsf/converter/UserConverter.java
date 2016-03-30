package ru.bisoft.socialservice.jsf.converter;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import ru.bisoft.socialservice.ejb.dao.TUserEJB;
import ru.bisoft.socialservice.model.TUser;

public class UserConverter implements Converter{

	@EJB
	TUserEJB tUserEJB;
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		return tUserEJB.findById(String.valueOf(arg2));
	}
	
	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return String.valueOf(((TUser) arg2).getUserIDTUser());
	}
}
