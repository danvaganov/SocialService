package ru.bisoft.socialservice.model;

import static javax.persistence.GenerationType.SEQUENCE;

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

@Entity
@Table(name = "PERSON_SERVICE")
@SequenceGenerator(name = "PERSON_SERVICE_GEN_ID", sequenceName = "PERSON_SERVICE_GEN_ID", allocationSize = 1, initialValue = 1)
public class PersonService {
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
	
	@Column(name = "STATUS_PERSON_SERVICE")
	private PersonServiceStatus status;
	
	@Column(name = "COMMENT_PERSON_SERVICE")
	private String comment;
	
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
}
