package ru.bisoft.socialservice.jsf.bean.composite;

import javax.ejb.EJB;

import ru.bisoft.socialservice.ejb.dao.PersonIncomeEJB;
import ru.bisoft.socialservice.model.Person;
import ru.bisoft.socialservice.model.PersonIncome;

public class PersonIncomeTableView {
	@EJB
	PersonIncomeEJB personIncomeEJB;

	private PersonIncome selection;

	public void prepareInsert(Person person) {
		selection = new PersonIncome();
		selection.setPerson(person);
	}

	public void update() {
		if (selection.getId() == 0) {
			selection.getPerson().addPersonIncome(selection);
			personIncomeEJB.insert(selection);
		} else
		{
			personIncomeEJB.update(selection);
		}
	}

	public PersonIncome getSelection() {
		return selection;
	}

	public void setSelection(PersonIncome selection) {
		this.selection = selection;
	}
}
