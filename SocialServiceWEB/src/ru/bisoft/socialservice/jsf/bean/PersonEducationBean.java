package ru.bisoft.socialservice.jsf.bean;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import ru.bisoft.socialservice.ejb.dao.PersonEducationEJB;
import ru.bisoft.socialservice.model.PersonEducation;

public class PersonEducationBean {
	@EJB
	PersonEducationEJB personEducationEJB;
	
	PersonBean personBean;
	
	PersonEducation selection;
	
	public void prepareInsert ()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Prepare",  "") );
		selection = new PersonEducation();
	}

	public void update ()
	{
		if (selection.getPerson() == null)
		{
			personBean.getSelection().addPersonEducation(selection);
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


	public PersonEducation getSelection() {
		return selection;
	}


	public void setSelection(PersonEducation selection) {
		this.selection = selection;
	}
}
