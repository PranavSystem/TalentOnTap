package com.app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Setter //de ser
//@Getter // getting em n pwd
//@ToString //only for debugging
//P.L validations 
public class AuthRequestDTO {
	@NotBlank(message ="Email can't be blank!!!" )
	@Email(message = "Invalid email format!!!!!")
	private String email;
	@NotBlank(message = "Password is required!!!")
	private String password;
	
	
	
	public AuthRequestDTO() {
		super();
	}
		
	public AuthRequestDTO(
			@NotBlank(message = "Email can't be blank!!!") @Email(message = "Invalid email format!!!!!") String email,
			@NotBlank(message = "Password is required!!!") String password) {
		super();
		this.email = email;
		this.password = password;
	}


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "AuthRequestDTO [email=" + email + "]";
	}
	
	
	
}
