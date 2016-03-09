package ru.bisoft.socialservice.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "PROFESSION")
@SequenceGenerator(name = "PROFESSION_GEN_ID", sequenceName = "PROFESSION_GEN_ID", allocationSize = 1, initialValue = 1)
public class Profession {
	@Id
	@Column(name = "KEY_PROFESSION")
	@GeneratedValue(generator = "PROFESSION_GEN_ID", strategy = SEQUENCE)
	private int id;
	
	@Column(name = "NAME_PROFESSION")
	private String name;
	
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return name;
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
}
