package controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import spring.ClassesRegisterRequest;

public class ClassesRegisterRequestValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return ClassesRegisterRequest.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "studio_name", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "instructor_name", "required");
		ValidationUtils.rejectIfEmpty(errors, "start_time", "required");
		ValidationUtils.rejectIfEmpty(errors, "end_time", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "genre", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "difficulty", "required");
	}

}
