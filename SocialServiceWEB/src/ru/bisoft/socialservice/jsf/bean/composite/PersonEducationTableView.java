package ru.bisoft.socialservice.jsf.bean.composite;

import javax.ejb.EJB;

import ru.bisoft.socialservice.ejb.dao.PersonEducationEJB;
import ru.bisoft.socialservice.model.Person;
import ru.bisoft.socialservice.model.PersonEducation;

public class PersonEducationTableView {
	@EJB
	PersonEducationEJB personEducationEJB;

	private PersonEducation selection;

	public void prepareInsert(Person person) {
		selection = new PersonEducation();
		selection.setPerson(person);
	}

	public void update() {
		if (selection.getId() == 0) {
			selection.getPerson().addPersonEducation(selection);
			//personEducationEJB.insert(selection);
		} else {
			//personEducationEJB.update(selection);
		}
	}

	public PersonEducation getSelection() {
		return selection;
	}

	public void setSelection(PersonEducation selection) {
		this.selection = selection;
	}
}
