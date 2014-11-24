/**
 * 
 */
package com.alfa.click.domain.schema.adapter;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * @author Aleh Adapter for converting string into date and vise versa.
 */
public class DateAdapter extends XmlAdapter<String, Date> {

	/**
	 * String for date formatting. Sample 01.01.2014.
	 * 
	 * @see SimpleDateFormat
	 */
	private static final String DATE_FORMAT = "dd.MM.yyyy";

	/**
	 * Date format.
	 */
	private final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.xml.bind.annotation.adapters.XmlAdapter#marshal(java.lang.Object)
	 */
	@Override
	public String marshal(final Date v) throws Exception {
		return dateFormat.format(v);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.xml.bind.annotation.adapters.XmlAdapter#unmarshal(java.lang.Object)
	 */
	@Override
	public Date unmarshal(final String v) throws Exception {
		return dateFormat.parse(v);
	}

}