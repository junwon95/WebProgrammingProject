package com.example.webpproject.security;

import com.example.webpproject.dto.ChangePasswordDto;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class PasswordValidator implements Validator {

	private static final String REQUIRED = "required";

	@Override
	public void validate(Object obj, Errors errors) {
		ChangePasswordDto passwordDto = (ChangePasswordDto) obj;
		String password = passwordDto.getPassword();
		String newPassword = passwordDto.getNewPassword();

		// password validation
		if (!StringUtils.hasLength(password)) {
			errors.rejectValue("password", REQUIRED, REQUIRED);
		}

		// new password validation
		if (!StringUtils.hasLength(newPassword)) {
			errors.rejectValue("newPassword", REQUIRED, REQUIRED);
		}
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return ChangePasswordDto.class.isAssignableFrom(clazz);
	}

}
