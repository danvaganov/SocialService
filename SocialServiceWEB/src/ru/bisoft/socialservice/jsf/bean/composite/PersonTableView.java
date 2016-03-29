package ru.bisoft.socialservice.jsf.bean.composite;

import java.util.List;
import java.util.Map;

import javax.ejb.EJB;

import org.primefaces.event.ToggleEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import ru.bisoft.socialservice.ejb.dao.PersonEJB;
import ru.bisoft.socialservice.jsf.bean.LoginBean;
import ru.bisoft.socialservice.model.Person;
import ru.bisoft.socialservice.model.PersonOrganization;

public class PersonTableView extends LazyDataModel<Person>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5482470382255953315L;
	
	@EJB
	PersonEJB personEJB;
	LoginBean loginBean;

	private Person selection;

	@Override
	public List<Person> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		return personEJB.find(loginBean.gettUser().getEmployee().getOrganization(), first, pageSize, filters);
	}

	@Override
	public int getRowCount() {
		return personEJB.getCount(loginBean.gettUser().getEmployee().getOrganization()).intValue();
	}

	@Override
	public Object getRowKey(Person object) {
		return Integer.valueOf(object.getKeyPerson());
	}

	@Override
	public Person getRowData(String rowKey) {
		return personEJB.findById(Integer.valueOf(rowKey));
	}
	
	public void prepareInsert(Person person) {
		selection = new Person();
		PersonOrganization personOrganization = new PersonOrganization();
		personOrganization.setPerson(selection);
		personOrganization.setOrganization(loginBean.gettUser().getEmployee().getOrganization());
		selection.getPersonOrganizationList().add(personOrganization);
	}

	public void update() {
		if (selection.getKeyPerson() == 0) {
			personEJB.insert(selection);
		} else
		{
			personEJB.update(selection);
		}
	}

	public void deletePerson(Person person) {
		personEJB.delete(person.getKeyPerson());
	}
	
	public void onRowToggle(ToggleEvent event) {
		selection = (Person) event.getData();
	}
	
	public Person getSelection() {
		return selection;
	}

	public void setSelection(Person selection) {
		this.selection = selection;
	}
	
	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}
}
