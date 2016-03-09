package ru.bisoft.socialservice.jsf.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;

import ru.bisoft.socialservice.ejb.dao.IncomeEJB;
import ru.bisoft.socialservice.model.Income;

public class IncomeBean {
	@EJB
	IncomeEJB incomeEJB;
	
	public List<Income> complete(String query)
	{
		Map<String, Object> filters = new HashMap<String, Object> ();
		filters.put("name", query);
		//filters.put("nameArticle", query);
		return incomeEJB.find(0, 10, filters);
	}
}
