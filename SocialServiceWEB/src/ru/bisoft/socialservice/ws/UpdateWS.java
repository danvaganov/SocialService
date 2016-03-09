package ru.bisoft.socialservice.ws;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import ru.bisoft.socialservice.ejb.dao.UpdateFileEJB;
import ru.bisoft.socialservice.model.UpdateFile;

@WebService(name="UpdateService")
public class UpdateWS {
	@EJB
	UpdateFileEJB updateFileEJB;
	
	@WebMethod
	public String getLastVersion ()
	{
		return updateFileEJB.getLastVersion();
	}
	
	@WebMethod
	public UpdateFile getUpdateFile (@WebParam(name="version", mode=WebParam.Mode.IN, targetNamespace="http://ws.socialservice.bisoft.ru/") String version)
	{
		System.err.println("000000000000000000000000000000000000000000000000000000");
		System.err.println(version);
		return updateFileEJB.getUpdateFile(version);
	}
}
