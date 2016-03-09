package ru.bisoft.socialservice.jsf.bean;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import ru.bisoft.socialservice.ejb.dao.PersonIncomeEJB;
import ru.bisoft.socialservice.model.PersonIncome;

public class PersonIncomeBean {
	@EJB
	PersonIncomeEJB personIncomeEJB;
	
	PersonBean personBean;
	
	PersonIncome selection;
	
	public void prepareInsert ()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Prepare",  "") );
		selection = new PersonIncome();
	}
	
	public void update ()
	{
		if (selection.getPerson() == null)
		{
			personBean.getSelection().addPersonIncome(selection);
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

	public PersonIncome getSelection() {
		return selection;
	}

	public void setSelection(PersonIncome selection) {
		this.selection = selection;
	}
}
