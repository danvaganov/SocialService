package ru.bisoft.socialservice.jaxb.adapter;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter <String, Date>{
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

	@Override
	public Date unmarshal(String v) throws Exception {
		return formatter.parse(v);
	}

	@Override
	public String marshal(Date v) throws Exception {
		// TODO Auto-generated method stub
		return formatter.format(v);
	}
}
