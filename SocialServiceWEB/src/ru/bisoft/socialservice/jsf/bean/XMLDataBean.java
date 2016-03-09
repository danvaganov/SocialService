package ru.bisoft.socialservice.jsf.bean;

import java.io.File;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import ru.bisoft.socialservice.jaxb.generated.IPR;

public class XMLDataBean {
	private UploadedFile file;
	
	public void importXML(FileUploadEvent event)
	{
		try
		{
			JAXBContext ctx = JAXBContext.newInstance(IPR.class);
			Unmarshaller unmarshaller = ctx.createUnmarshaller();
			Reader reader = new InputStreamReader(event.getFile().getInputstream(), "iso-8859-1");
			
			IPR ipr = (IPR) unmarshaller.unmarshal(reader);
			
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(ipr.getOrganization().getNAMEORGANIZATION(),  "") );
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}
}
