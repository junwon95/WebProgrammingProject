package com.example.webpproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangePasswordDto {

	private String username;

	private String password;

	private String newPassword;

}
