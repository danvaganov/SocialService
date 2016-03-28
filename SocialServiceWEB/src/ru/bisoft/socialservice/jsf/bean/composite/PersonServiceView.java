package ru.bisoft.socialservice.jsf.bean.composite;

import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import ru.bisoft.socialservice.ejb.dao.PersonServiceEJB;
import ru.bisoft.socialservice.model.PersonService;

public class PersonServiceView {
	@EJB
	PersonServiceEJB personServiceEJB;

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
}
