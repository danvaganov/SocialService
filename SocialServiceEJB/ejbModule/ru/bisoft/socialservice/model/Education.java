package ru.bisoft.socialservice.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.OneToMany;

@Entity
@Table(name = "EDUCATION")
@SequenceGenerator(name = "EDUCATION_GEN_ID", sequenceName = "EDUCATION_GEN_ID", allocationSize = 1, initialValue = 1)
public class Education implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2367586731073054708L;

	@Id
	@Column(name = "KEY_EDUCATION")
	@GeneratedValue(generator = "EDUCATION_GEN_ID", strategy = SEQUENCE)
	private int keyEducation;
	
	@Column(name = "NAME_EDUCATION")
	private String nameEducation;
	
	@OneToMany(mappedBy = "education")
	private List<PersonEducation> personEducationList;

	public Education() {
		super();
	}

	public int getKeyEducation() {
		return keyEducation;
	}

	public void setKeyEducation(int keyEducation) {
		this.keyEducation = keyEducation;
	}

	public String getNameEducation() {
		return nameEducation;
	}

	public void setNameEducation(String nameEducation) {
		this.nameEducation = nameEducation;
	}

	@Override
	public String toString() {
		return nameEducation;
	}
}
