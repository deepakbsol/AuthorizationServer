package com.rrrs.config.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.PARAMETER;

import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.rrrs.config.annotationvalidator.FormatnameConstraintValidator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;

@Target({METHOD,FIELD,CONSTRUCTOR,PARAMETER,ANNOTATION_TYPE})
@Retention(RUNTIME)
@Documented
@Size(min=2,max=30,message="Format name length should be 2 to 30 characters")
@NotNull
@Constraint(validatedBy = {FormatnameConstraintValidator.class})
public @interface ValidFormatName {

	String message() default "Not a valid format name";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	int min() default 2;
	int max() default 30;

}
