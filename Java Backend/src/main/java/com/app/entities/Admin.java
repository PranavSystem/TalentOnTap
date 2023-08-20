package com.app.entities;

import javax.persistence.*;//all specs Java EE supplied
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;

@Entity
//lombok annotations
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@ToString(exclude = "password")
public class Admin  {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long a_id;
	
		@Column(length = 20) // varchar(20)
		@NotBlank(message = "Name is required")
		private String name;
		
		@Column(length = 30, unique = true) // unique constraint
		@NotBlank(message = "Email is required")
		@Email(message = "Invalid email format")
		private String email;
		
		@Column(length = 20, nullable = false) // NOT NULL constraint
		@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
	    message = "Password must be strong: at least 8 characters, one uppercase, one lowercase, one digit, and one special character")
		private String password;

		public Admin() {
			super();
		}
		
		public Admin(Long a_id, @NotBlank(message = "Name is required") String name, 
		@NotBlank(message = "Email is required") @Email(message = "Invalid email format") String email,
		@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "Password must be strong: at least 8 characters, one uppercase, one lowercase, one digit, and one special character") String password) {
			super();
			this.a_id = a_id;
			this.name = name;
			this.email = email;
			this.password = password;
		}

		public Long getA_id() {
			return a_id;
		}

		public void setA_id(Long a_id) {
			this.a_id = a_id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
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
			return "Admin [a_id=" + a_id + ", name=" + name + ", email=" + email + "]";
		}

	
	}
		
	
	
