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
		selection.setPerson(personBean.getSelection());
	}

	public void update ()
	{
		if(selection.getId() == 0)
		{
			personBean.getSelection().addPersonEducation(selection);
			//personEducationEJB.insert(selection);
		}
		//else
			//personEducationEJB.update(selection);
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
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("SetSelection "+selection.toString(), ""));
		this.selection = selection;
	}
}
