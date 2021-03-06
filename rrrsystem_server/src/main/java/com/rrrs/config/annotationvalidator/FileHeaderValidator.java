package com.rrrs.config.annotationvalidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rrrs.config.annotation.ValidHeader;
import com.rrrs.util.OracleSqlKeywordCheck;

public class FileHeaderValidator implements ConstraintValidator<ValidHeader, String>{

	Logger logger = LoggerFactory.getLogger(FileHeaderValidator.class);

	@Override
	public void initialize(ValidHeader constraintAnnotation) {
		logger.info("enter into FileHeaderValidator");	
	}

	@Override
	public boolean isValid(String header, ConstraintValidatorContext context) {

		if (OracleSqlKeywordCheck.checkIsEmpty(header)) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("File Column should not be empty or null ")
			.addConstraintViolation();
			return false;
		}

		if (OracleSqlKeywordCheck.checkSpecialChar(header)) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("File Column should not be a special characters")
			.addConstraintViolation();
			return false;
		}

		return true;
	}

}
