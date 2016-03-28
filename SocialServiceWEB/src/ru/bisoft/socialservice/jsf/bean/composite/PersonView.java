package ru.bisoft.socialservice.jsf.bean.composite;

import java.io.ByteArrayInputStream;

import javax.ejb.EJB;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import ru.bisoft.socialservice.ejb.dao.PersonEJB;
import ru.bisoft.socialservice.jsf.bean.LoginBean;
import ru.bisoft.socialservice.model.Person;
import ru.bisoft.socialservice.model.PersonOrganization;

public class PersonView {
	@EJB
	private PersonEJB personEJB;
	private LoginBean loginBean;
	
	private Person person;
	
	public void prepareInsert()
	{
		person = new Person();
		
		PersonOrganization personOrganization = new PersonOrganization();
		personOrganization.setPerson(person);
		personOrganization.setOrganization(loginBean.gettUser().getEmployee().getOrganization());
		person.getPersonOrganizationList().add(personOrganization);
	}
	
	public void update()
	{
		if (person.getKeyPerson() == 0)
			personEJB.insert(person);
		else
			personEJB.update(person);
	}

	public StreamedContent getFoto() {
		return new DefaultStreamedContent(new ByteArrayInputStream(person.getFoto()), "image/png");
	}
	
	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
