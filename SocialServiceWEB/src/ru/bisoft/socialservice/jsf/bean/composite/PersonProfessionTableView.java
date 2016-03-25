package ru.bisoft.socialservice.jsf.bean.composite;

import javax.ejb.EJB;

import ru.bisoft.socialservice.ejb.dao.PersonProfessionEJB;
import ru.bisoft.socialservice.model.Person;
import ru.bisoft.socialservice.model.PersonProfession;

public class PersonProfessionTableView {
	@EJB
	PersonProfessionEJB personProfessionEJB;

	private PersonProfession selection;

	public void prepareInsert(Person person) {
		selection = new PersonProfession();
		selection.setPerson(person);
	}

	public void update() {
		if (selection.getId() == 0) {
			selection.getPerson().addPersonProfession(selection);
			personProfessionEJB.insert(selection);
		} else
		{
			personProfessionEJB.update(selection);
		}
	}

	public PersonProfession getSelection() {
		return selection;
	}

	public void setSelection(PersonProfession selection) {
		this.selection = selection;
	}
}
