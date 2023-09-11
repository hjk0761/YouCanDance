package controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import spring.BoardWriteRequest;

public class BoardWriteRequestValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return BoardWriteRequest.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subject", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content", "required");
	}

}
