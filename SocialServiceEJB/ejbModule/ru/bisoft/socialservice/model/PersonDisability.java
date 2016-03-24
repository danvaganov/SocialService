package ru.bisoft.socialservice.model;

import static javax.persistence.TemporalType.DATE;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "PERSON_DISABILITY")
@SequenceGenerator(name = "PERSON_DISABILITY_GEN_ID", sequenceName = "PERSON_DISABILITY_GEN_ID", allocationSize = 1, initialValue = 1)
public class PersonDisability {

	@Id
	@Column(name = "KEY_PERSON_DISABILITY")
	@GeneratedValue(generator = "PERSON_DISABILITY_GEN_ID", strategy = SEQUENCE)
	private int id;
	
	@Column(name = "GROUP_PERSON_DISABILITY")
	private GroupDisability group;
	
	@Column(name = "DOCUMENT_SERIAL_PERSON_DISABILITY")
	private String documentSerial;
	
	@Column(name = "DOCUMENT_NUMBER_PERSON_DISABILITY")
	private String documentNumber;
	
	@Column(name = "SETTING_TYPE_PERSON_DISABILITY")
	private SettingType settingType;
	
	@Column(name = "SETTING_DATE_PERSON_DISABILITY")
	@Temporal(DATE)
	private Date settingDate;
	
	@Column(name = "REASON_PERSON_DISABILITY")
	private String reason;
	
	@Column(name = "LIMITATION_DATE_PERSON_DISABILITY")
	@Temporal(DATE)
	private Date limitation;
	
	@Column(name = "DOCUMENT_CREATE_DATE_PERSON_DISABILITY")
	@Temporal(DATE)
	private Date documentCreateDate;
	
	@ManyToOne
	@JoinColumn(name = "KEY_PERSON", referencedColumnName = "KEY_PERSON")
	private Person person;

	public String getDocumentSerial() {
		return documentSerial;
	}

	public void setDocumentSerial(String documentSerial) {
		this.documentSerial = documentSerial;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getLimitation() {
		return limitation;
	}

	public void setLimitation(Date limitation) {
		this.limitation = limitation;
	}

	public Date getDocumentCreateDate() {
		return documentCreateDate;
	}

	public void setDocumentCreateDate(Date documentCreateDate) {
		this.documentCreateDate = documentCreateDate;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	

	public GroupDisability getGroup() {
		return group;
	}

	public void setGroup(GroupDisability group) {
		this.group = group;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SettingType getSettingType() {
		return settingType;
	}

	public void setSettingType(SettingType settingType) {
		this.settingType = settingType;
	}
	
	public Date getSettingDate() {
		return settingDate;
	}

	public void setSettingDate(Date settingDate) {
		this.settingDate = settingDate;
	}
	public static enum GroupDisability{
		GROUP_1("1 Группа"), 
		GROUP_2("2 Группа"),
		GROUP_3("3 Группа"), 
		DISABLED_CHILD("Ребенок - инвалид");
		
		private String label;
		private GroupDisability(String label)
		{
			this.label = label;
		}
		public String getLabel() {
			return label;
		}
	}
	public static GroupDisability[] getGroupDisabilityArray()
	{
		return GroupDisability.values();
	}
	public static enum SettingType{
		FIRST("Первично"), 
		REPEATEDLY("Повторно");
		
		private String label;
		private SettingType(String label)
		{
			this.label = label;
		}
		public String getLabel() {
			return label;
		}
	}
	public static SettingType[] getSettingTypeArray()
	{
		return SettingType.values();
	}
}
