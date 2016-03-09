package ru.bisoft.socialservice.jsf.bean;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import ru.bisoft.socialservice.ejb.dao.PersonProfessionEJB;
import ru.bisoft.socialservice.model.PersonProfession;

public class PersonProfessionBean {
	@EJB
	PersonProfessionEJB personProfessionEJB;
	
	PersonBean personBean;
	
	PersonProfession selection;
	
	public void prepareInsert ()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Prepare",  "") );
		selection = new PersonProfession();
	}
	
	public void update ()
	{
		if (selection.getPerson() == null)
		{
			personBean.getSelection().addPersonProfession(selection);
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

	public PersonProfession getSelection() {
		return selection;
	}

	public void setSelection(PersonProfession selection) {
		this.selection = selection;
	}
}
