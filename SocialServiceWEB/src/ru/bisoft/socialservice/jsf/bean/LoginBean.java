package ru.bisoft.socialservice.jsf.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import ru.bisoft.socialservice.ejb.dao.TUserEJB;
import ru.bisoft.socialservice.model.TUser;

public class LoginBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;

	@EJB
	TUserEJB tUserEJB;

	private TUser tUser;

	public TUser gettUser() {
	    FacesContext context = FacesContext.getCurrentInstance();
	    ExternalContext externalContext = context.getExternalContext();
		if (externalContext.getUserPrincipal() == null)
			this.tUser = null;
		else if (this.tUser == null)
			this.tUser = tUserEJB.findById(externalContext.getUserPrincipal().getName());
		return this.tUser;
	}

	public void settUser(TUser tUser) {
		this.tUser = tUser;
	}

	public void login() throws IOException {
	    FacesContext context = FacesContext.getCurrentInstance();
	    ExternalContext externalContext = context.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();

		try {
			request.login(username, password);
			tUser = gettUser();
			externalContext.getSessionMap().put("user", tUser);
			externalContext.redirect(externalContext.getRequestContextPath() + "/private/index.xhtml");
		} catch (ServletException e) {
			context.addMessage(null, new FacesMessage("Unknown login"));
		}
	}

	public void logout() throws IOException {
	    FacesContext context = FacesContext.getCurrentInstance();
	    ExternalContext externalContext = context.getExternalContext();
		externalContext.invalidateSession();
		externalContext.redirect(externalContext.getRequestContextPath() + "/login.xhtml");
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
