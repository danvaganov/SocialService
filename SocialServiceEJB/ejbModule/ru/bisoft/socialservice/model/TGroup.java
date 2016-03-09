package ru.bisoft.socialservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: TGroup
 *
 */
@Entity
@Table(name = "TGROUP")
public class TGroup implements Serializable {
	
	@Column(name = "GROUPID_TGROUP")
	private String groupIDTGroup;
	
	@Id
	@OneToOne
	@JoinColumn(name = "USERID_TUSER", referencedColumnName = "USERID_TUSER")
	private TUser tUser;
	
	private static final long serialVersionUID = 1L;

	public TGroup() {
		super();
	}   
	
	public String getGroupIDTGroup() {
		return this.groupIDTGroup;
	}

	public void setGroupIDTGroup(String groupIDTGroup) {
		this.groupIDTGroup = groupIDTGroup;
	}   
	public TUser getTUser() {
		return this.tUser;
	}

	public void setTUser(TUser tUser) {
		this.tUser = tUser;
	}
}
