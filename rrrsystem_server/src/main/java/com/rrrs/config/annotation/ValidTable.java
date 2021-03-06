package com.rrrs.config.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.PARAMETER;

import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;

import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Size;

import com.rrrs.config.annotationvalidator.OracleSqlConstraintValidatorImpl;

@Target({METHOD,FIELD,CONSTRUCTOR,PARAMETER,ANNOTATION_TYPE})
@Retention(RUNTIME)
@Size(min = 2, max = 25, message = "Table name length should be 2 to 25 characters")
@Constraint(validatedBy = { OracleSqlConstraintValidatorImpl.class })

public @interface ValidTable {

	String message() default "Not a valid table name";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	int min() default 2;

	int max() default 25;

}
