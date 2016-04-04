package ru.bisoft.socialservice.jsf.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import ru.bisoft.socialservice.ejb.dao.EmployeeEJB;
import ru.bisoft.socialservice.ejb.dao.OrganizationEJB;
import ru.bisoft.socialservice.ejb.dao.TGroupEJB;
import ru.bisoft.socialservice.ejb.dao.TUserEJB;
import ru.bisoft.socialservice.model.Employee;
import ru.bisoft.socialservice.model.Organization;
import ru.bisoft.socialservice.model.TGroup;
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
	
	Organization organization;
	
	TGroup group;
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
	
	public List<Employee> completeEmployee(String query)
	{
		return organization.getEmployees();
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
		organization = selection.getEmployee().getOrganization();
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
	
	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	
	public TGroup getGroup() {
		return group;
	}

	public void setGroup(TGroup group) {
		this.group = group;
	}

	public void onOrganizationChange(SelectEvent e) {
		organization = (Organization) e.getObject();
		//selection.setEmployee(organization.getEmployees().get(0));
		selection.setEmployee(null);
	}
}
