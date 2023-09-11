package controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import spring.InstructorRegisterRequest;

public class InstructorRegisterRequestValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return InstructorRegisterRequest.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "studio_name", "required");
	}

}
