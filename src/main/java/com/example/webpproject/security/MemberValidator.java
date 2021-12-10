package com.example.webpproject.security;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class MemberValidator implements Validator {

	private static final String REQUIRED = "required";

	@Override
	public void validate(Object obj, Errors errors) {
		Member member = (Member) obj;
		String username = member.getUsername();
		String password = member.getPassword();
		String email = member.getEmail();

		// username validation
		if (!StringUtils.hasLength(username)) {
			errors.rejectValue("username", REQUIRED, REQUIRED);
		}

		// password validation
		if (!StringUtils.hasLength(password)) {
			errors.rejectValue("password", REQUIRED, REQUIRED);
		}

		// email validation
		if (!StringUtils.hasLength(email)) {
			errors.rejectValue("email", REQUIRED, REQUIRED);
		}
		else if (!email.matches("\\S+@\\S+\\.\\S+")) {
			errors.rejectValue("email", "notValid", "not a valid address");
		}
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Member.class.isAssignableFrom(clazz);
	}

}
