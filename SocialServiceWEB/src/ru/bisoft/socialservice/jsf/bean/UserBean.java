package ru.bisoft.socialservice.jsf.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import ru.bisoft.socialservice.ejb.dao.EmployeeEJB;
import ru.bisoft.socialservice.ejb.dao.OrganizationEJB;
import ru.bisoft.socialservice.ejb.dao.TUserEJB;
import ru.bisoft.socialservice.model.TUser;

public class UserBean extends  LazyDataModel<TUser> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	TUserEJB tUserEJB;
	
	OrganizationEJB organizationEJB;
	
	EmployeeEJB employeeEJB;
	
	TUser selection;
	
	//
	
	public UserBean() {
		super();
	}

	public List<TUser> complete(String query)
	{
		Map<String, Object> filters = new HashMap<String, Object> ();
		filters.put("surnamePerson", query);
		return tUserEJB.find(0, 10, filters);
	}
	
	@Override
	public List<TUser> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		return tUserEJB.find(first, pageSize, filters);
	}
	
	@Override
	public int getRowCount() {
		return tUserEJB.getCount().intValue();
	}
	
	@Override
	public Object getRowKey(TUser object) {
		return object.getUserIDTUser();
	}
	
	@Override
	public TUser getRowData(String rowKey) {
		return tUserEJB.findById(rowKey);
	}

	public TUser getSelection() {
		return selection;
	}

	public void setSelection(TUser selection) {
		this.selection = selection;
	}
	
	public void updateTUser()
	{
		tUserEJB.update(selection);
	}
	
	public void deleteTUser(TUser person)
	{
		tUserEJB.delete(person.getUserIDTUser());
	}
	
	public void prepareInsert()
	{
		selection = new TUser();
	}
	
	public void onOrganizationChange() {
		System.err.println("Organization select");
	}
}
