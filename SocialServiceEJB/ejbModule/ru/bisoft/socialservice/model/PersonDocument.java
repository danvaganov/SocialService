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
@Table(name = "PERSON_DOCUMENT")
@SequenceGenerator(name = "PERSON_DOCUMENT_GEN_ID", sequenceName = "PERSON_DOCUMENT_GEN_ID", allocationSize = 1, initialValue = 1)
public class PersonDocument {
	@Id
	@Column(name = "KEY_PERSON_DOCUMENT")
	@GeneratedValue(generator = "PERSON_DOCUMENT_GEN_ID", strategy = SEQUENCE)
	private int id;
	
	@Column(name = "NAME_PERSON_DOCUMENT")
	private String name;
	
	@Lob
	@Column(name = "COPY_PERSON_DOCUMENT")
	@Basic
	private byte[] copy;
	
	@Column(name = "EXT_PERSON_DOCUMENT")
	private String extension;
	
	@Column(name = "SERIAL_PERSON_DOCUMENT")
	private String serial;
	
	@Column(name = "NUMBER_PERSON_DOCUMENT")
	private String number;
	
	@Column(name = "NEED_RECOVERY_PERSON_DOCUMENT")
	private boolean needRecovery;
	
	@Column(name = "FEATURE_PERSON_DOCUMENT")
	private String feature;
	
	@ManyToOne
	@JoinColumn(name = "KEY_PERSON", referencedColumnName = "KEY_PERSON")
	private Person person;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getCopy() {
		return copy;
	}

	public void setCopy(byte[] copy) {
		this.copy = copy;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public boolean isNeedRecovery() {
		return needRecovery;
	}

	public void setNeedRecovery(boolean needRecovery) {
		this.needRecovery = needRecovery;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
