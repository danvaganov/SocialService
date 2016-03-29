package ru.bisoft.socialservice.jsf.bean;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.event.ToggleEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.primefaces.model.StreamedContent;

import ru.bisoft.socialservice.ejb.dao.PersonEJB;
import ru.bisoft.socialservice.model.Person;
import ru.bisoft.socialservice.model.PersonDocument;
import ru.bisoft.socialservice.model.PersonOrganization;
import ru.bisoft.socialservice.model.PersonService;

public class PersonBean extends LazyDataModel<Person> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	PersonEJB personEJB;

	LoginBean loginBean;

	Person selection;

	private StreamedContent foto;

	public PersonBean() {
		super();
	}

	public List<Person> complete(String query) {
		Map<String, Object> filters = new HashMap<String, Object>();
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

	public StreamedContent getFoto() {
		return new DefaultStreamedContent(new ByteArrayInputStream(selection.getFoto()), "image/png");
	}

	public void setFoto(StreamedContent foto) {
		this.foto = foto;
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
