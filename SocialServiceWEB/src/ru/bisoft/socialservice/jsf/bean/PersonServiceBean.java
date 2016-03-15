package ru.bisoft.socialservice.jsf.bean;

import java.util.Date;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import ru.bisoft.socialservice.ejb.dao.PersonServiceEJB;
import ru.bisoft.socialservice.model.Person;
import ru.bisoft.socialservice.model.PersonService;
import ru.bisoft.socialservice.model.PersonService.PersonServiceStatus;

public class PersonServiceBean {
	@EJB
	PersonServiceEJB personServiceEJB;

	PersonBean personBean;

	PersonService selection;

	public void prepareInsert(Person person) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Prepare", ""));
		selection = new PersonService();
		selection.setPerson(person);
		selection.setDate(new Date());
	}

	public void update() {
		selection.getPerson().addPersonService(selection);
		personServiceEJB.update(selection);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Update", ""));
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
