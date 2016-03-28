package ru.bisoft.socialservice.jsf.bean.composite;

import javax.ejb.EJB;

import ru.bisoft.socialservice.ejb.dao.PersonDisabilityEJB;
import ru.bisoft.socialservice.model.Person;
import ru.bisoft.socialservice.model.PersonDisability;

public class PersonDisabilityTableView {
	@EJB
	PersonDisabilityEJB personDisabilityEJB;

	private PersonDisability selection;

	public void prepareInsert(Person person) {
		selection = new PersonDisability();
		selection.setPerson(person);
	}

	public void update() {
		if (selection.getId() == 0) {
			selection.getPerson().addPersonDisability(selection);
			personDisabilityEJB.insert(selection);
		} else
		{
			personDisabilityEJB.update(selection);
		}
	}

	public PersonDisability getSelection() {
		return selection;
	}

	public void setSelection(PersonDisability selection) {
		this.selection = selection;
	}
}
