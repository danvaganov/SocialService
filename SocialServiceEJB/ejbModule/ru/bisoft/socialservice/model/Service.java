package ru.bisoft.socialservice.model;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SERVICE")
@NamedQueries({
	@NamedQuery(name="Service.findAll", query="SELECT s FROM Service s order by s.id"),
	@NamedQuery(name="Service.getCount", query="SELECT COUNT(s) FROM Service s")
})
@SequenceGenerator(name = "SERVICE_GEN_ID", sequenceName = "SERVICE_GEN_ID", allocationSize = 1, initialValue = 1)
public class Service {
	@Id
	@Column(name = "KEY_SERVICE")
	@GeneratedValue(generator = "SERVICE_GEN_ID", strategy = SEQUENCE)
	private int id;
	
	@Column(name = "NAME_SERVICE")
	private String name;
	
	@Column(name = "FULLNAME_SERVICE")
	private String fullname;

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

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
}
