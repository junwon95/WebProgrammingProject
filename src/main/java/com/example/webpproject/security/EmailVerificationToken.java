package com.example.webpproject.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Setter
public class EmailVerificationToken {

	String value;

	BCryptPasswordEncoder bCryptPasswordEncoder;

	EmailVerificationToken() {
	}

	EmailVerificationToken(Member member) {
		this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
		value = this.bCryptPasswordEncoder.encode(member.getEmail()).substring(10, 14);
	}

}
