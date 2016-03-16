package ru.bisoft.socialservice.model;

import static javax.persistence.GenerationType.SEQUENCE;
import static javax.persistence.TemporalType.DATE;

import java.io.Serializable;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.NamedQuery;

@Entity
@Table(name = "PERSON_SERVICE")
@SequenceGenerator(name = "PERSON_SERVICE_GEN_ID", sequenceName = "PERSON_SERVICE_GEN_ID", allocationSize = 1, initialValue = 1)
@NamedQuery(name = "PersonService.findByOrganization", query = "SELECT PS FROM PersonService PS WHERE PS.organization = :organization")
public class PersonService implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4087879923008447290L;

	@Id
	@Column(name = "KEY_PERSON_SERVICE")
	@GeneratedValue(generator = "PERSON_SERVICE_GEN_ID", strategy = SEQUENCE)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "KEY_PERSON", referencedColumnName = "KEY_PERSON")
	private Person person;
	
	@ManyToOne
	@JoinColumn(name = "KEY_SERVICE", referencedColumnName = "KEY_SERVICE")
	private Service service;
	
	@ManyToOne
	@JoinColumn(name = "KEY_ORGANIZATION", referencedColumnName = "KEY_ORGANIZATION")
	private Organization organization;
	
	@Column(name = "STATUS_PERSON_SERVICE")
	private PersonServiceStatus status;
	
	@Column(name = "COMMENT_PERSON_SERVICE")
	private String comment;
	
	@Column(name = "DATE_PERSON_SERVICE")
	@Temporal(DATE)
	private Date date;
	
	@Lob
	@Column(name = "DOCUMENT_PERSON_SERVICE")
	@Basic
	private byte[] document;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public PersonServiceStatus getStatus() {
		return status;
	}

	public void setStatus(PersonServiceStatus status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public byte[] getDocument() {
		return document;
	}

	public void setDocument(byte[] document) {
		this.document = document;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public static enum PersonServiceStatus{
		ASSIGNED("Назначено"), 
		PROCESS("В обработке"),
		DONE("Выполнено"), 
		DENIED("Отказано"),
		ATTENTION("Требует внимания");
		
		private String label;
		private PersonServiceStatus(String label)
		{
			this.label = label;
		}
		public String getLabel() {
			return label;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		//совпадают ли наши первичные ключи?
		/*FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(String.valueOf(this == obj), ""));*/
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonService other = (PersonService) obj;		
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PersonService [id=" + id + "]";
	}	
}
