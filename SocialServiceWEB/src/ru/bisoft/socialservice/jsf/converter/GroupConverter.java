package ru.bisoft.socialservice.jsf.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import ru.bisoft.socialservice.model.TGroup;

public class GroupConverter implements Converter{
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		return new TGroup(arg2);
	}
	
	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return ((TGroup) arg2).getGroupIDTGroup();
	}
}
