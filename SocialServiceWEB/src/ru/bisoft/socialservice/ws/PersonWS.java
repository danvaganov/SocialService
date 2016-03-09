package ru.bisoft.socialservice.ws;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;

import ru.bisoft.socialservice.ejb.dao.PersonEJB;

@WebService(name="Person")
public class PersonWS {
	@EJB
	PersonEJB personEJB;
	
	@WebMethod
	public Message doRequest(Message message) {
		//message.value = new Message();
		
		//message.value.setExchangeType("сам hello");
		
		//requestEJB.insert(new ru.bisoft.requestservice.model.Request());
		Message m = new Message();
		m.setData("asdfasdfasdfaf");
		return m;
	}
}
