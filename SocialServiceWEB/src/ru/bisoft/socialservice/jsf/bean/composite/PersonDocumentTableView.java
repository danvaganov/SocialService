package ru.bisoft.socialservice.jsf.bean.composite;

import javax.ejb.EJB;

import ru.bisoft.socialservice.ejb.dao.PersonDocumentEJB;
import ru.bisoft.socialservice.model.Person;
import ru.bisoft.socialservice.model.PersonDocument;

public class PersonDocumentTableView {
	@EJB
	PersonDocumentEJB personDocumentEJB;

	private PersonDocument selection;

	public void prepareInsert(Person person) {
		selection = new PersonDocument();
		selection.setPerson(person);
	}

	public void update() {
		if (selection.getId() == 0) {
			selection.getPerson().addPersonDocument(selection);
			//personDocumentEJB.insert(selection);
		} else
		{
			//personDocumentEJB.update(selection);
		}
	}

	public PersonDocument getSelection() {
		return selection;
	}

	public void setSelection(PersonDocument selection) {
		this.selection = selection;
	}
}
