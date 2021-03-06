package com.rrrs.config.annotationvalidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rrrs.config.annotation.ValidColumn;
import com.rrrs.util.OracleSqlKeywordCheck;

public class OracleSqlConstraintValidator implements ConstraintValidator<ValidColumn, String> {
	Logger LOGGER = LoggerFactory.getLogger(OracleSqlConstraintValidator.class);
	@Override
	public void initialize(ValidColumn constraintAnnotation) {
		LOGGER.debug("Inside OracleContraintValidator class");
		
	}

	@Override
	public boolean isValid(String column, ConstraintValidatorContext context) {
		LOGGER.debug("Cloumn "+ column +" Inside isValid method in OracleConstraintValidator class");
	
		if (OracleSqlKeywordCheck.checkIsEmpty(column)) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("Database column should not be empty or null ")
					.addConstraintViolation();
			return false;
		}
		
		if (OracleSqlKeywordCheck.checkKeyWord(column)) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("Database column should not be a keyword ")
					.addConstraintViolation();
			return false;
		}
		
		if (OracleSqlKeywordCheck.checkSpecialCharacter(column)) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("Database column should not contains special characters")
					.addConstraintViolation();
			return false;
		}
		
		if (OracleSqlKeywordCheck.checkStartWithUnderscore(column)) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("Database column should not start with underscore(_) ")
					.addConstraintViolation();
			return false;
		}
		
		Pattern pattern = Pattern.compile("\\s");
		Matcher matcher = pattern.matcher(column);

		while (matcher.find()) {
			LOGGER.debug(column +" Database Column should not contain underscore(_)");
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(" Remove space from Database Column name : ")
					.addConstraintViolation();
			return false;
		}
		
		if(Character.isDigit(column.charAt(0))){
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("Database column should not be start with numeric ")
					.addConstraintViolation();
			return false;
		}
			
		return true;
	}

}
