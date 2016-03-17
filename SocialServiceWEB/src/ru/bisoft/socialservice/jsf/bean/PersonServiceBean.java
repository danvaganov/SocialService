package ru.bisoft.socialservice.jsf.bean;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import ru.bisoft.socialservice.ejb.dao.PersonEJB;
import ru.bisoft.socialservice.ejb.dao.PersonServiceEJB;
import ru.bisoft.socialservice.model.Person;
import ru.bisoft.socialservice.model.PersonService;
import ru.bisoft.socialservice.model.PersonService.PersonServiceStatus;

public class PersonServiceBean {
	@EJB
	PersonServiceEJB personServiceEJB;
	@EJB
	PersonEJB personEJB;
	
	PersonBean personBean;
	
	LoginBean loginBean;

	PersonService selection;
	String updateId;
	
	public void prepareInsert(Person person, String ownerId) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Prepare", ""));
		updateId = ownerId;
		selection = new PersonService();
		selection.setPerson(person);
		person.addPersonService(selection);
		selection.setDate(new Date());
	}

	public void update() {
		personEJB.update(selection.getPerson());
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

	public List<PersonService> find ()
	{
		return personServiceEJB.find(loginBean.gettUser().getEmployee().getOrganization());
	}
	
	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}
	
	
}
