package com.rrrs.config.annotationvalidator;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class JsonLongDateFormat extends JsonDeserializer<Date>{

	private static Logger LOGGER = LoggerFactory.getLogger(JsonLongDateFormat.class);

	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");

	@Override
	public Date deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
			throws IOException {
		
		LOGGER.debug("Inside deserialize in JsonLongDateFormat class ");

		if(paramJsonParser==null || paramJsonParser.getText().trim().equals("") ){	return null;}
		
		String stringDate = paramJsonParser.getText().trim();
		
		LOGGER.debug(" JsonLongDateFormat :  "+stringDate);
		
		try {
			return dateFormat.parse(stringDate);
		} catch (ParseException e) {
           LOGGER.debug(" ParseException in  JsonLongDateFormat  : "+e.getMessage());
		}
		return paramDeserializationContext.parseDate(stringDate);
	}

}
