package com.rrrs.annotation;

import java.io.Serializable;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomeLengthClass implements ConstraintValidator<CustomeLength, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		System.out.println("value--"+value);
		if(value.length()>10) {
			return true;
		}
		return false;
	}

}
