package ru.bisoft.socialservice.model;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.SEQUENCE;
import static javax.persistence.TemporalType.DATE;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "PERSON")
@NamedQueries({
	@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p order by p.keyPerson"),
	@NamedQuery(name="Person.findByOrganization", query="SELECT p FROM Person p JOIN p.personOrganizationList po WHERE po.organization = :organization"),
	@NamedQuery(name="Person.findByPassport", query="SELECT p FROM Person p WHERE p.passport.serialPassport = :serialPassport AND p.passport.numberPassport = :numberPassport AND p.passport.issueDatePassport = :issueDatePassport"),
	@NamedQuery(name="Person.getCount", query="SELECT COUNT(p) FROM Person p"),
	@NamedQuery(name="Person.getCountByOrganization", query="SELECT COUNT(p) FROM Person p JOIN p.personOrganizationList po WHERE po.organization = :organization"),
	@NamedQuery(name = "Person.findByFIO", query = "SELECT P FROM Person P WHERE COALESCE(TRIM(LOWER(P.namePerson)),'') = COALESCE(TRIM(LOWER(:namePerson)),'') AND COALESCE(TRIM(LOWER(P.surnamePerson)),'') = COALESCE(TRIM(LOWER(:surnamePerson)),'') AND COALESCE(TRIM(LOWER(P.patronymicPerson)),'') = COALESCE(TRIM(LOWER(:patronymicPerson)),'')")
})
@SequenceGenerator(name = "PERSON_GEN_ID", sequenceName = "PERSON_GEN_ID", allocationSize = 1, initialValue = 1)
public class Person {
	@Id
	@Column(name = "KEY_PERSON")
	@GeneratedValue(generator = "PERSON_GEN_ID", strategy = SEQUENCE)
	private int keyPerson;
	@Column(name = "NAME_PERSON")
	private String namePerson;
	@Column(name = "SURNAME_PERSON")
	private String surnamePerson;
	@Column(name = "PATRONYMIC_PERSON")
	private String patronymicPerson;
	@Column(name = "BIRTHDAY_PERSON")
	@Temporal(DATE)
	private Date birthdayPerson;
	@Lob
	@Column(name = "FOTO_PERSON")
	@Basic(fetch = LAZY)
	private byte[] foto;
	
	@Embedded
	@AttributeOverrides({ 
		@AttributeOverride(name = "serialPassport", column = @Column(name = "SERIAL_PASSPORT_PERSON", table = "PERSON")), 
		@AttributeOverride(name = "numberPassport", column = @Column(name = "NUMBER_PASSPORT_PERSON", table = "PERSON")),
		@AttributeOverride(name = "issuePassport", column = @Column(name = "ISSUE_PASSPORT_PERSON", table = "PERSON")),
		@AttributeOverride(name = "issueDatePassport", column = @Column(name = "ISSUE_DATE_PASSPORT_PERSON", table = "PERSON")),
		@AttributeOverride(name = "registrationPassport", column = @Column(name = "REGISTRATION_POSSPORT_PERSON", table = "PERSON")) 
	})
	private Passport passport;
	@OneToMany(mappedBy = "person", orphanRemoval = true, cascade = ALL)
	private List<PersonEducation> personEducationList;
	
	@OneToMany(mappedBy = "person", orphanRemoval = true, cascade = ALL)
	private List<PersonDisability> personDisabilityList;
	
	@OneToMany(mappedBy = "person", orphanRemoval = true)
	private List<PersonOrganization> personOrganizationList;
	
	@OneToMany(mappedBy = "person", orphanRemoval = true, cascade = ALL)
	private List<PersonIncome> personIncomeList;
	
	@OneToMany(mappedBy = "person", orphanRemoval = true, cascade = ALL)
	private List<PersonProfession> personProfessionList;
	
	@OneToMany(mappedBy = "person", orphanRemoval = true, cascade = ALL)
	private List<PersonDocument> personDocumentList;
	
	@OneToMany(mappedBy = "person", orphanRemoval = true, cascade = ALL)
	private List<PersonService> personServicetList;
	
	public int getKeyPerson() {
		return keyPerson;
	}
	public void setKeyPerson(int keyPerson) {
		this.keyPerson = keyPerson;
	}
	public String getNamePerson() {
		return namePerson;
	}
	public void setNamePerson(String namePerson) {
		this.namePerson = namePerson;
	}
	public String getSurnamePerson() {
		return surnamePerson;
	}
	public void setSurnamePerson(String surnamePerson) {
		this.surnamePerson = surnamePerson;
	}
	public String getPatronymicPerson() {
		return patronymicPerson;
	}
	public void setPatronymicPerson(String patronymicPerson) {
		this.patronymicPerson = patronymicPerson;
	}
	public Date getBirthdayPerson() {
		return birthdayPerson;
	}
	public void setBirthdayPerson(Date birthdayPerson) {
		this.birthdayPerson = birthdayPerson;
	}
	public List<PersonEducation> getPersonEducationList() {
		return personEducationList;
	}
	public void setPersonEducationList(List<PersonEducation> personEducationList) {
		this.personEducationList = personEducationList;
	}
	public Passport getPassport() {
		if (passport == null)
			this.passport = new Passport();
		return passport;
	}
	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	public List<PersonOrganization> getPersonOrganizationList() {
		return personOrganizationList;
	}
	public void setPersonOrganizationList(List<PersonOrganization> personOrganizationList) {
		this.personOrganizationList = personOrganizationList;
	}
	public List<PersonDisability> getPersonDisabilityList() {
		return personDisabilityList;
	}
	public void setPersonDisabilityList(List<PersonDisability> personDisabilityList) {
		this.personDisabilityList = personDisabilityList;
	}
	public List<PersonIncome> getPersonIncomeList() {
		return personIncomeList;
	}
	public void setPersonIncomeList(List<PersonIncome> personIncomeList) {
		this.personIncomeList = personIncomeList;
	}
	public List<PersonProfession> getPersonProfessionList() {
		return personProfessionList;
	}
	public void setPersonProfessionList(List<PersonProfession> personProfessionList) {
		this.personProfessionList = personProfessionList;
	}
	public List<PersonDocument> getPersonDocumentList() {
		return personDocumentList;
	}
	public void setPersonDocumentList(List<PersonDocument> personDocumentList) {
		this.personDocumentList = personDocumentList;
	}
	
	public List<PersonService> getPersonServicetList() {
		return personServicetList;
	}
	public void setPersonServicetList(List<PersonService> personServicetList) {
		this.personServicetList = personServicetList;
	}
	public Person() {
		super();
		this.passport = new Passport();
		this.personOrganizationList = new ArrayList<PersonOrganization>();
	}
	public void removePersonEducation(PersonEducation personEducation)
	{
		this.personEducationList.remove(personEducation);
	}
	public void addPersonEducation(PersonEducation personEducation)
	{
		this.personEducationList.add(personEducation);
	}
	public void addPersonDisability(PersonDisability personDisability)
	{
		this.personDisabilityList.add(personDisability);
	}
	public void removePersonDisability(PersonDisability personDisability)
	{
		this.personDisabilityList.remove(personDisability);
	}
	public void addPersonProfession(PersonProfession personProfession)
	{
		this.personProfessionList.add(personProfession);
	}
	public void removePersonProfession(PersonProfession personProfession)
	{
		this.personProfessionList.remove(personProfession);
	}
	public void addPersonIncome(PersonIncome personIncome)
	{
		this.personIncomeList.add(personIncome);
	}
	public void removePersonIncome(PersonIncome personIncome)
	{
		this.personIncomeList.remove(personIncome);
	}
	public void addPersonDocument(PersonDocument personDocument)
	{
		this.personDocumentList.add(personDocument);
	}
	public void removePersonDocument(PersonDocument personDocument)
	{
		this.personDocumentList.remove(personDocument);
	}
	public void addPersonService(PersonService personService)
	{
		this.personServicetList.add(personService);
	}
	public void removePersonService(PersonService personService)
	{
		this.personServicetList.remove(personService);
	}
	public void addPersonOrganization(PersonOrganization personOrganization)
	{
		this.personOrganizationList.add(personOrganization);
	}
}
