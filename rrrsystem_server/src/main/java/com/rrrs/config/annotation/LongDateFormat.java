package com.rrrs.config.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.PARAMETER;

import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.rrrs.config.annotationvalidator.JsonLongDateFormat;
import com.rrrs.config.annotationvalidator.SerializeJsonLongDateFormat;

@Target({METHOD,FIELD,CONSTRUCTOR,PARAMETER,ANNOTATION_TYPE})
@Retention(RUNTIME)
@Documented
@JacksonAnnotationsInside
@JsonSerialize(using = SerializeJsonLongDateFormat.class)
@JsonDeserialize(using = JsonLongDateFormat.class)
@JsonFormat(pattern = "dd-MMM-yyyy HH:mm:ss")
public @interface LongDateFormat {

}
