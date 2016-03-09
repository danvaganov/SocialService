package ru.bisoft.socialservice.jsf.bean;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import ru.bisoft.socialservice.ejb.dao.PersonDisabilityEJB;
import ru.bisoft.socialservice.model.PersonDisability;
import ru.bisoft.socialservice.model.PersonDisability.GroupDisability;
import ru.bisoft.socialservice.model.PersonDisability.SettingType;

public class PersonDisabilityBean {
	@EJB
	PersonDisabilityEJB personDisabilityEJB;
	
	PersonBean personBean;
	
	PersonDisability selection;
	
	public void prepareInsert ()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Prepare",  "") );
		selection = new PersonDisability();
	}
	
	public void update ()
	{
		if (selection.getPerson() == null)
		{
			personBean.getSelection().addPersonDisability(selection);
			selection.setPerson(personBean.getSelection());
		}
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Update",  "") );
	}
	
	public PersonBean getPersonBean() {
		return personBean;
	}

	public void setPersonBean(PersonBean personBean) {
		this.personBean = personBean;
	}

	public PersonDisability getSelection() {
		return selection;
	}

	public void setSelection(PersonDisability selection) {
		this.selection = selection;
	}
	
	public SettingType[] getSettingTypes() {
		return SettingType.values();
	}
	
	public GroupDisability[] getGroups() {
		return GroupDisability.values();
	}
}
