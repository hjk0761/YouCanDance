package controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import spring.StudioRegisterRequest;

public class StudioRegisterRequestValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return StudioRegisterRequest.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "locate", "required");
	}

}
