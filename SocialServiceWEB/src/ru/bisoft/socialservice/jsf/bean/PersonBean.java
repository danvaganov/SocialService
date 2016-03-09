package ru.bisoft.socialservice.jsf.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import ru.bisoft.socialservice.ejb.dao.PersonEJB;
import ru.bisoft.socialservice.model.Person;
import ru.bisoft.socialservice.model.PersonDocument;
import ru.bisoft.socialservice.model.PersonOrganization;

public class PersonBean extends LazyDataModel<Person> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	PersonEJB personEJB;
	
	LoginBean loginBean;
	
	Person selection;
	
	public PersonBean() {
		super();
	}

	public List<Person> complete(String query)
	{
		Map<String, Object> filters = new HashMap<String, Object> ();
		filters.put("surnamePerson", query);
		return personEJB.find(loginBean.gettUser().getEmployee().getOrganization(), 0, 10, filters);
	}
	
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
	
	public void updatePerson()
	{
		personEJB.update(selection);
	}
	
	public void deletePerson(Person person)
	{
		personEJB.delete(person.getKeyPerson());
	}
	
	public void prepareInsert()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Successful",  "Your message: " + selection) );
		
		selection = new Person();
		PersonOrganization personOrganization = new PersonOrganization();
		personOrganization.setPerson(selection);
		personOrganization.setOrganization(loginBean.gettUser().getEmployee().getOrganization());
		selection.getPersonOrganizationList().add(personOrganization);
	}
	
	public void showDocument(PersonDocument personDocument) {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		HttpServletResponse httpServletResponse = (HttpServletResponse) externalContext.getResponse();
		try {
			httpServletResponse.reset();
			httpServletResponse.addHeader("Content-Type", "application/pdf");
			httpServletResponse.getOutputStream().write(personDocument.getCopy());
			context.responseComplete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
