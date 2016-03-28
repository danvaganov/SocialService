package ru.bisoft.socialservice.jsf.bean.composite;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import ru.bisoft.socialservice.model.PersonDocument;

public class PersonDocumentView {
	
	private PersonDocument personDocument;
	
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
	
	public PersonDocument getPersonDocument() {
		return personDocument;
	}

	public void setPersonDocument(PersonDocument personDocument) {
		this.personDocument = personDocument;
	}
}
