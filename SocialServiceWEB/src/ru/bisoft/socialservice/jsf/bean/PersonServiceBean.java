package ru.bisoft.socialservice.jsf.bean;

import java.util.Date;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import ru.bisoft.socialservice.ejb.dao.PersonServiceEJB;
import ru.bisoft.socialservice.model.PersonService;
import ru.bisoft.socialservice.model.PersonService.PersonServiceStatus;

public class PersonServiceBean {
	@EJB
	PersonServiceEJB personServiceEJB;

	PersonBean personBean;
	
	PersonService selection;
	
	public void prepareInsert ()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Prepare",  "") );
		selection = new PersonService();
		selection.setDate(new Date());
	}
	
	public void update ()
	{
		if (selection.getPerson() == null)
		{
			personBean.getSelection().addPersonService(selection);
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

	public PersonService getSelection() {
		return selection;
	}

	public void setSelection(PersonService selection) {
		this.selection = selection;
	}
	
	public PersonServiceStatus[] getStatuses() {
		return PersonServiceStatus.values();
	}
}
