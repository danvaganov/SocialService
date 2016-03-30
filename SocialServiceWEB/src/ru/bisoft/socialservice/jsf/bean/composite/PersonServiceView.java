package ru.bisoft.socialservice.jsf.bean.composite;

import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;

import ru.bisoft.socialservice.model.PersonService;

public class PersonServiceView {
	
	private PersonServiceTableView personServiceTableView;

	public void showDocument(PersonService personService) {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		HttpServletResponse httpServletResponse = (HttpServletResponse) externalContext.getResponse();
		try {
			httpServletResponse.reset();
			httpServletResponse.addHeader("Content-Type", "application/pdf");
			httpServletResponse.getOutputStream().write(personService.getDocument());
			context.responseComplete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void handleFileUpload(FileUploadEvent event)
	{
		try {
			personServiceTableView.getSelection().setDocument(IOUtils.toByteArray(event.getFile().getInputstream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	public PersonServiceTableView getPersonServiceTableView() {
		return personServiceTableView;
	}

	public void setPersonServiceTableView(PersonServiceTableView personServiceTableView) {
		this.personServiceTableView = personServiceTableView;
	}
}
