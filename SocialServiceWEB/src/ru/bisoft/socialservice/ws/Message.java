package ru.bisoft.socialservice.ws;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Message {
	@XmlElement(name="Status", required=true)
	private MessageStatus status;
	@XmlElement(name="Date", required=true)
	private Date date;
	@XmlElement(name="Data", required=false)
	private String data;
	
	public MessageStatus getStatus() {
		return status;
	}
	public void setStatus(MessageStatus status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public enum MessageStatus
	{
		ACCEPT,
		CANCEL,
		FAILURE,
		INVALID,
		NOTIFY,
		PACKET,
		PING,
		PROCESS,
		REJECT,
		REQUEST,
		RESULT,
		STATE,
	}

	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}
