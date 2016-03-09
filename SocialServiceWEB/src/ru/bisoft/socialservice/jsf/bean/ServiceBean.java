package ru.bisoft.socialservice.jsf.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import ru.bisoft.socialservice.ejb.dao.ServiceEJB;
import ru.bisoft.socialservice.model.Service;

public class ServiceBean extends LazyDataModel<Service>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	ServiceEJB serviceEJB;
	
	LoginBean loginBean;
	
	Service selection;
	
	public ServiceBean() {
		super();
	}
	
	public List<Service> complete(String query)
	{
		Map<String, Object> filters = new HashMap<String, Object> ();
		filters.put("name", query);
		return serviceEJB.find(0, 10, filters);
	}
	
	@Override
	public int getRowCount() {
		return serviceEJB.getCount().intValue();
	}

	@Override
	public Service getRowData(String rowKey) {
		return serviceEJB.findById(Integer.valueOf(rowKey));
	}

	@Override
	public Object getRowKey(Service object) {
		return Integer.valueOf(object.getId());
	}

	@Override
	public List<Service> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		return serviceEJB.find(first, pageSize, filters);
	}
	
	public void updateService()
	{
		System.err.println(selection);
		serviceEJB.update(selection);
	}
	
	public void deleteService(Service service)
	{
		serviceEJB.delete(service.getId());
	}
	
	public Service getSelection() {
		return selection;
	}
	
	public void setSelection(Service selection) {
		this.selection = selection;
	}
	
	public void prepareInsert ()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Prepare",  "") );
		selection = new Service();
	}
	
	
}
