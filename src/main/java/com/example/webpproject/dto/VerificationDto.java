package com.example.webpproject.dto;

import com.example.webpproject.security.Member;
import com.example.webpproject.security.Roles;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VerificationDto {

	private String inputCode;

	private String verificationCode;

	private String username;

	private String password;

	private String email;

	private Roles role;

	public void setMember(Member member) {
		this.username = member.getUsername();
		this.password = member.getPassword();
		this.email = member.getEmail();
		this.role = member.getRole();
	}

	public Member getMember() {
		Member member = new Member();
		member.setUsername(this.username);
		member.setPassword(this.password);
		member.setEmail(this.email);
		member.setRole(this.role);

		return member;
	}

}
