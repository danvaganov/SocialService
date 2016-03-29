package ru.bisoft.socialservice.jsf.bean.composite;

import java.util.List;

import javax.ejb.EJB;

import ru.bisoft.socialservice.ejb.dao.PersonServiceEJB;
import ru.bisoft.socialservice.jsf.bean.LoginBean;
import ru.bisoft.socialservice.model.PersonService;

public class PersonServiceDataGridView {
	
	LoginBean loginBean;
	
	@EJB
	PersonServiceEJB personServiceEJB;
	
	public List<PersonService> find ()
	{
		System.err.println(loginBean.gettUser().getEmployee().getOrganization().getNameOrganization());
		return personServiceEJB.find(loginBean.gettUser().getEmployee().getOrganization());
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}
}
