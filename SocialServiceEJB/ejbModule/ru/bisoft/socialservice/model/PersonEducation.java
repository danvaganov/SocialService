package ru.bisoft.socialservice.model;

import static javax.persistence.GenerationType.SEQUENCE;
import static javax.persistence.TemporalType.DATE;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "PERSON_EDUCATION")
@SequenceGenerator(name = "PERSON_EDUCATION_GEN_ID", allocationSize = 1, initialValue = 1)
public class PersonEducation {
	
	@Id
	@Column(name = "KEY_PERSON_EDUCATION")
	@GeneratedValue(generator = "PERSON_EDUCATION_GEN_ID", strategy = SEQUENCE)
	private int id;
	
	@Column(name = "INSTITUTION_PERSON_EDUCATION")
	private String institution;
	
	@Column(name = "EXP_DATE_PERSON_EDUCATION")
	@Temporal(DATE)
	private Date expiration;
	
	@Column(name = "SPECIALTY_PERSON_EDUCATION")
	private String specialty;
	
	@ManyToOne
	@JoinColumn(name = "KEY_PERSON", referencedColumnName = "KEY_PERSON")
	private Person person;
	
	@ManyToOne
	@JoinColumn(name = "KEY_EDUCATION", referencedColumnName = "KEY_EDUCATION")
	private Education education;


	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Education getEducation() {
		return education;
	}

	public void setEducation(Education education) {
		this.education = education;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
