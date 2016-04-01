package ru.bisoft.socialservice.jsf.bean.composite;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import ru.bisoft.socialservice.ejb.dao.PersonServiceEJB;
import ru.bisoft.socialservice.jsf.bean.LoginBean;
import ru.bisoft.socialservice.model.PersonService;

public class PersonServiceDataGridView extends LazyDataModel<PersonService> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 451305713559942647L;

	LoginBean loginBean;
	
	@EJB
	PersonServiceEJB personServiceEJB;
	
	private String filterString;
	private Map<String, Object> globalFilters = new HashMap<String, Object> ();
	
	@Override
	public List<PersonService> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		return personServiceEJB.find(loginBean.gettUser().getEmployee().getOrganization(), first, pageSize, globalFilters);
	}
	
	@Override
	public int getRowCount() {
		return personServiceEJB.getCount(loginBean.gettUser().getEmployee().getOrganization()).intValue();
	}
	
	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public String getFilterString() {
		return filterString;
	}

	public void setFilterString(String filterString) {
		globalFilters.clear();
		globalFilters.put("surnamePerson", filterString);
		this.filterString = filterString;
	}
}
