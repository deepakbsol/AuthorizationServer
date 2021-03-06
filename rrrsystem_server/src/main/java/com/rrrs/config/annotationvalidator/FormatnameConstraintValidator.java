package com.rrrs.config.annotationvalidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rrrs.config.annotation.ValidFormatName;

public class FormatnameConstraintValidator implements ConstraintValidator<ValidFormatName, String> {
	Logger log=LoggerFactory.getLogger(FormatnameConstraintValidator.class);
	@Override
	public void initialize(ValidFormatName constraintAnnotation) {
		log.debug("Inside FormatnameConstraintValidator validator class");
	}

	@Override
	public boolean isValid(String formatname, ConstraintValidatorContext context) {
		log.debug("Inside isValid method in FormatnameConstraintValidator class");
		if(formatname == null || "".equals(formatname)){
			log.debug(formatname +" Format name should be an empty or null");
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("Format Name should not violate naming convention ")
			.addConstraintViolation();
			return false;
		}

		if(formatname.indexOf('_')==0||formatname.lastIndexOf('_')==formatname.length()-1) {
			log.debug(formatname +" Format name should not contain underscore(_)");
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("Format Name should not violate naming convention ")
			.addConstraintViolation();
			return false;
		}

		Pattern pattern = Pattern.compile("\\s");
		Matcher matcher = pattern.matcher(formatname);

		while (matcher.find()) {
			log.debug(formatname +" Format name should not contain underscore(_)");
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(" Remove space from format name ")
			.addConstraintViolation();
			return false;
		}
		return true;
	}

}
