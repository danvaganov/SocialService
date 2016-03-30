package ru.bisoft.socialservice.jsf.bean.composite;

import javax.ejb.EJB;

import ru.bisoft.socialservice.ejb.dao.PersonServiceEJB;
import ru.bisoft.socialservice.model.Person;
import ru.bisoft.socialservice.model.PersonService;

public class PersonServiceTableView {
	@EJB
	PersonServiceEJB personServiceEJB;

	private PersonService selection;

	public void prepareInsert(Person person) {
		selection = new PersonService();
		selection.setPerson(person);
	}

	public void update() {
		if (selection.getId() == 0) {
			selection.getPerson().addPersonService(selection);
			personServiceEJB.insert(selection);
		} else {
			personServiceEJB.update(selection);
		}
	}

	public PersonService getSelection() {
		return selection;
	}

	public void setSelection(PersonService selection) {
		this.selection = selection;
	}
}
