package ru.bisoft.socialservice.jsf.bean.composite;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import ru.bisoft.socialservice.ejb.dao.PersonEducationEJB;
import ru.bisoft.socialservice.model.Person;
import ru.bisoft.socialservice.model.PersonEducation;

public class PersonEducationTableView {
	@EJB
	PersonEducationEJB personEducationEJB;

	private PersonEducation selection;

	public void prepareInsert(Person person) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Insert", ""));

		selection = new PersonEducation();
		selection.setPerson(person);
	}

	public void update() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		if (selection.getId() == 0) {
			context.addMessage(null, new FacesMessage("add", ""));
			selection.getPerson().addPersonEducation(selection);
			personEducationEJB.insert(selection);
		} else
		{
			context.addMessage(null, new FacesMessage("edit", ""));
			personEducationEJB.update(selection);
		}
	}

	public PersonEducation getSelection() {
		return selection;
	}

	public void setSelection(PersonEducation selection) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(selection.toString(), ""));
		this.selection = selection;
	}
}
