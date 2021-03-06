package com.rrrs.config.annotationvalidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rrrs.config.annotation.ValidDatatype;
import com.rrrs.util.OracleSqlKeywordCheck;

public class OracleDatatypeValidator implements ConstraintValidator<ValidDatatype, String>{
	Logger LOGGER = LoggerFactory.getLogger(OracleDatatypeValidator.class);

	@Override
	public void initialize(ValidDatatype constraintAnnotation) {
		LOGGER.debug("Inside Oracle data type Validator class");		
	}

	@Override
	public boolean isValid(String datatype, ConstraintValidatorContext context) {
		if (OracleSqlKeywordCheck.checkIsEmpty(datatype)) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("Data type should not be empty or null ")
					.addConstraintViolation();
			return false;
		}		
		Pattern pattern = Pattern.compile("\\s");
		Matcher matcher = pattern.matcher(datatype);

		while (matcher.find()) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(" Remove space from data type : ")
					.addConstraintViolation();
			return false;
		}
		if (OracleSqlKeywordCheck.checkdatatypeKeyWord(datatype)) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("Invalied data type")
					.addConstraintViolation();
			return false;
		}		
		
		return true;
	}
	
}
