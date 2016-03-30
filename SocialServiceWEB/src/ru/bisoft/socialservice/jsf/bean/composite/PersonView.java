package ru.bisoft.socialservice.jsf.bean.composite;

import java.io.ByteArrayInputStream;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

public class PersonView {

	private PersonTableView personTableView;

	public StreamedContent getFoto() {
		return new DefaultStreamedContent(new ByteArrayInputStream(personTableView.getSelection().getFoto()), "image/png");
	}

	public PersonTableView getPersonTableView() {
		return personTableView;
	}

	public void setPersonTableView(PersonTableView personTableView) {
		this.personTableView = personTableView;
	}

}
