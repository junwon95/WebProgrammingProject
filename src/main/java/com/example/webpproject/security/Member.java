package com.example.webpproject.security;

import com.example.webpproject.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "members")
@ToString
public class Member extends BaseEntity {

	@Column(name = "username", unique = true)
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "role_name")
	@Enumerated(EnumType.STRING)
	private Roles role;

}
