package ru.bisoft.socialservice.jsf.bean.composite;

import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;

import ru.bisoft.socialservice.model.PersonDocument;

public class PersonDocumentView {
	
	@ManagedProperty(value="#{personDocumentTableView}")
	private PersonDocumentTableView personDocumentTableView;

	public void showDocument(PersonDocument personDocument) {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		HttpServletResponse httpServletResponse = (HttpServletResponse) externalContext.getResponse();
		try {
			httpServletResponse.reset();
			httpServletResponse.addHeader("Content-Type", "application/pdf");
			httpServletResponse.getOutputStream().write(personDocument.getCopy());
			context.responseComplete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void handleFileUpload(FileUploadEvent event){
		try
		{
			personDocumentTableView.getSelection().setCopy(IOUtils.toByteArray(event.getFile().getInputstream()));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public PersonDocumentTableView getPersonDocumentTableView() {
		return personDocumentTableView;
	}

	public void setPersonDocumentTableView(PersonDocumentTableView personDocumentTableView) {
		this.personDocumentTableView = personDocumentTableView;
	}
}
