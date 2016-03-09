package ru.bisoft.socialservice.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "PERSON_PROFESSION")
@SequenceGenerator(name = "PERSON_PROFESSION_GEN_ID", sequenceName = "PERSON_PROFESSION_GEN_ID", allocationSize = 1, initialValue = 1)
public class PersonProfession {
	@Id
	@GeneratedValue(generator = "PERSON_PROFESSION_GEN_ID", strategy = SEQUENCE)
	@Column(name = "KEY_PERSON_PROFESSION")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "KEY_PERSON", referencedColumnName = "KEY_PERSON")
	private Person person;
	
	@ManyToOne
	@JoinColumn(name = "KEY_PROFESSION", referencedColumnName = "KEY_PROFESSION")
	private Profession profession;
	
	@Column(name = "ORGANIZATION_PERSON_PROFESSION")
	private String organization;
	
	@Column(name = "ADDRESS_PERSON_PROFESSION")
	private String address;

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

	public Profession getProfession() {
		return profession;
	}

	public void setProfession(Profession profession) {
		this.profession = profession;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
