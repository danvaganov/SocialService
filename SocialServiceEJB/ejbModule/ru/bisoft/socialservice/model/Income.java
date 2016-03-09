package ru.bisoft.socialservice.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "INCOME")
@SequenceGenerator(name = "INCOME_GEN_ID", sequenceName = "INCOME_GEN_ID", allocationSize = 1, initialValue = 1)
public class Income {

	@Id
	@Column(name = "KEY_INCOME")
	@GeneratedValue(generator = "INCOME_GEN_ID", strategy = SEQUENCE)
	private int id;
	
	@Column(name = "NAME_INCOME")
	private String name;
	
	@OneToMany(mappedBy = "income")
	private List<PersonIncome> personIncomeList;
	
	@Override
	public String toString() {
		return name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<PersonIncome> getPersonIncomeList() {
		return personIncomeList;
	}
	public void setPersonIncomeList(List<PersonIncome> personIncomeList) {
		this.personIncomeList = personIncomeList;
	}
}
