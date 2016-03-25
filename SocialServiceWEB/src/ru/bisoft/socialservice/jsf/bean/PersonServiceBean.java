package ru.bisoft.socialservice.jsf.bean;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;

import ru.bisoft.socialservice.ejb.dao.PersonEJB;
import ru.bisoft.socialservice.ejb.dao.PersonServiceEJB;
import ru.bisoft.socialservice.model.PersonService;
import ru.bisoft.socialservice.model.PersonService.PersonServiceStatus;

public class PersonServiceBean {
	@EJB
	PersonServiceEJB personServiceEJB;
	@EJB
	PersonEJB personEJB;
	
	PersonBean personBean;
	
	LoginBean loginBean;

	PersonService selection;
	
	public void prepareInsert() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Prepare", ""));
		selection = new PersonService();
		selection.setPerson(personBean.getSelection());
		personBean.getSelection().addPersonService(selection);
		selection.setDate(new Date());
	}

	public void update() {
		//personServiceEJB.update(selection);
		personEJB.update(selection.getPerson());
		
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Update", ""));
	}
	
	public void handleFileUpload(FileUploadEvent event) throws IOException {
		selection.setDocument(IOUtils.toByteArray(event.getFile().getInputstream()));
		
        FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	public PersonBean getPersonBean() {
		return personBean;
	}

	public void setPersonBean(PersonBean personBean) {
		this.personBean = personBean;
	}

	public PersonService getSelection() {
		return selection;
	}

	public void setSelection(PersonService selection) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("selection", ""));
		this.selection = selection;
	}

	public PersonServiceStatus[] getStatuses() {
		return PersonServiceStatus.values();
	}

	public List<PersonService> find ()
	{
		return personServiceEJB.find(loginBean.gettUser().getEmployee().getOrganization());
	}
	
	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}
}
