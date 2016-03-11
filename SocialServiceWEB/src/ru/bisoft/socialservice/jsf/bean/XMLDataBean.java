package ru.bisoft.socialservice.jsf.bean;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.primefaces.event.FileUploadEvent;

import ru.bisoft.socialservice.ejb.dao.EducationEJB;
import ru.bisoft.socialservice.ejb.dao.OrganizationEJB;
import ru.bisoft.socialservice.ejb.dao.PersonEJB;
import ru.bisoft.socialservice.jaxb.generated.ADDITIONALDATATYPE;
import ru.bisoft.socialservice.jaxb.generated.EDUCATIONPERSONTYPE;
import ru.bisoft.socialservice.jaxb.generated.IPR;
import ru.bisoft.socialservice.jaxb.generated.PERSONTYPE;
import ru.bisoft.socialservice.jaxb.generated.PHYSICALINABILITYTYPE;
import ru.bisoft.socialservice.model.Organization;
import ru.bisoft.socialservice.model.Person;
import ru.bisoft.socialservice.model.PersonDisability;
import ru.bisoft.socialservice.model.PersonDocument;
import ru.bisoft.socialservice.model.PersonEducation;
import ru.bisoft.socialservice.model.PersonOrganization;

public class XMLDataBean {
	@EJB
	PersonEJB personEJB;
	@EJB
	OrganizationEJB organizationEJB;
	@EJB
	EducationEJB educationEJB;

	IPR ipr;

	public void upload(FileUploadEvent event) {
		try {
			JAXBContext ctx = JAXBContext.newInstance(IPR.class);
			Unmarshaller unmarshaller = ctx.createUnmarshaller();
			this.ipr = (IPR) unmarshaller.unmarshal(event.getFile().getInputstream());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Success", "Success"));
			FacesContext.getCurrentInstance().getExternalContext().setResponseCharacterEncoding("UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void persist() throws Exception {
		Organization organization = null;//organizationEJB.findByName(ipr.getOrganization().getNAMEORGANIZATION());
		if (organization == null)
			organization = organizationEJB.findByINN("123123");//ipr.getOrganization().getINNORGANIZATION());
		if (organization == null) {
			organization = new Organization();
			organization.setNameOrganization(ipr.getOrganization().getNAMEORGANIZATION().trim());
			organization.setInnOrganization(ipr.getOrganization().getINNORGANIZATION().trim());
			organization.setFullNameOrganization(ipr.getOrganization().getFULLNAMEORGANIZATION().trim());
			organizationEJB.insert(organization);
		}
		for (PERSONTYPE personType : ipr.getPerson()) {
			Person person = personEJB.findByFIO(personType.getNAME(), personType.getSURNAME(), personType.getPATRONYMIC());
			if (person == null) {
				person = new Person();
				person.setNamePerson((personType.getNAME().substring(0, 1).toUpperCase() + personType.getNAME().substring(1)).trim());
				person.setSurnamePerson((personType.getSURNAME().substring(0, 1).toUpperCase() + personType.getSURNAME().substring(1)).trim());
				person.setPatronymicPerson((personType.getPATRONYMIC().substring(0, 1).toUpperCase() + personType.getPATRONYMIC().substring(1)).trim());
				person.setBirthdayPerson(personType.getBIRTHDAY());
				person.setFoto(personType.getFOTO());
				
				personEJB.insert(person);
			}
			
			PersonOrganization personOrganization = new PersonOrganization(organization, person);
			if (!organization.getPersonOrganizations().contains(personOrganization))
				person.getPersonOrganizationList().add(personOrganization);
			
			for (ADDITIONALDATATYPE additionnalDataType : personType.getADDITIONALDATALIST().getADDITIONALDATA()) {
				if (person.getPersonDocumentList().contains(additionnalDataType)) continue;
				PersonDocument personDocument = new PersonDocument();
				personDocument.setName(additionnalDataType.getNAMEDOC());
				personDocument.setCopy(additionnalDataType.getSCAN());
				person.getPersonDocumentList().add(personDocument);
				personDocument.setPerson(person);
			}
			
			for (EDUCATIONPERSONTYPE educationPersonType : personType.getEDUCATIONPERSONLIST().getEDUCATIONPERSON()) {
				if (person.getPersonEducationList().contains(educationPersonType)) continue;
				PersonEducation personEducation = new PersonEducation();
				if (educationPersonType.getSPECIALTY() != null)
					personEducation.setSpecialty(educationPersonType.getSPECIALTY().getNAME());
				personEducation.setEducation(educationEJB.find(educationPersonType.getEDUCATION().getNAME()));
				person.getPersonEducationList().add(personEducation);
				personEducation.setPerson(person);
			}
			
			for (PHYSICALINABILITYTYPE physicalInabilityType : personType.getPHYSICALINABILITYLIST().getPHYSICALINABILITY()) {
				if (person.getPersonDisabilityList().contains(physicalInabilityType)) continue;
				PersonDisability personDisability = new PersonDisability();
				personDisability.setGroup(PersonDisability.GroupDisability.values()[physicalInabilityType.getGROUPINABILITY()]);
				personDisability.setSettingType(PersonDisability.SettingType.FIRST);
				person.getPersonDisabilityList().add(personDisability);
				personDisability.setPerson(person);
			}
			
			personEJB.update(person);
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Success", "Success"));
	}

	public IPR getIpr() {
		return ipr;
	}

	public void setIpr(IPR ipr) {
		this.ipr = ipr;
	}
}
