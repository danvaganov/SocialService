package ru.bisoft.socialservice.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;

@Entity
@Table(name = "PERSON_INCOME")
@SequenceGenerator(name = "PERSON_INCOME_GEN_ID", sequenceName = "PERSON_INCOME_GEN_ID", allocationSize = 1, initialValue = 1)
public class PersonIncome {

	@Id
	@Column(name = "KEY_PERSON_INCOME")
	@GeneratedValue(generator = "PERSON_INCOME_GEN_ID", strategy = SEQUENCE)
	private int id;
	
	@Column(name = "SUM_PERSON_INCOME")
	private float sum;
	
	@Column(name = "DATE_PERSON_INCOME")
	@Temporal(DATE)
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "KEY_PERSON", referencedColumnName = "KEY_PERSON")
	private Person person;
	
	@ManyToOne
	@JoinColumn(name = "KEY_INCOME", referencedColumnName = "KEY_INCOME")
	private Income income;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getSum() {
		return sum;
	}

	public void setSum(float sum) {
		this.sum = sum;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Income getIncome() {
		return income;
	}

	public void setIncome(Income income) {
		this.income = income;
	}
}
