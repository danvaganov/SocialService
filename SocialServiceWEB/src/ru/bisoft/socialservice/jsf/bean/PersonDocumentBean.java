package ru.bisoft.socialservice.jsf.bean;

import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;

import ru.bisoft.socialservice.ejb.dao.PersonDocumentEJB;
import ru.bisoft.socialservice.model.PersonDocument;

public class PersonDocumentBean {
	@EJB
	PersonDocumentEJB personDocumentEJB;

	PersonBean personBean;
	
	PersonDocument selection;
	
	public void prepareInsert ()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Prepare",  "") );
		selection = new PersonDocument();
	}
	
	public void update ()
	{
		if (selection.getPerson() == null)
		{
			personBean.getSelection().addPersonDocument(selection);
			selection.setPerson(personBean.getSelection());
		}
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Update",  "") );
	}
	
	public void handleFileUpload(FileUploadEvent event) throws IOException {
		selection.setCopy(IOUtils.toByteArray(event.getFile().getInputstream()));
		
        FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
	public PersonBean getPersonBean() {
		return personBean;
	}

	public void setPersonBean(PersonBean personBean) {
		this.personBean = personBean;
	}

	public PersonDocument getSelection() {
		return selection;
	}

	public void setSelection(PersonDocument selection) {
		this.selection = selection;
	}
}
