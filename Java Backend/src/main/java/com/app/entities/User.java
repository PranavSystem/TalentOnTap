package com.app.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")

public class User {
	
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long user_id;

	    @NotBlank(message = "Email is required")
	    @Email(message = "Invalid email format")
	    @Size(max = 100, message = "Email can't exceed 100 characters")
	    private String email;

	    @NotBlank(message = "Password is required")
	    @Size(min = 6, message = "Password must be at least 6 characters")
	    private String password;

	    @NotBlank(message = "Role is required")
	    private String role;

	    // Relationships (if needed)
	     @OneToOne(mappedBy = "user")
	     private Customer customer;

	     @OneToOne(mappedBy = "user")
	     private Professional professional;

		public User() {
			super();
		}

		public User(Long user_id,
				@NotBlank(message = "Email is required") @Email(message = "Invalid email format") @Size(max = 100, message = "Email can't exceed 100 characters") String email,
				@NotBlank(message = "Password is required") @Size(min = 6, message = "Password must be at least 6 characters") String password,
				@NotBlank(message = "Role is required") String role, Customer customer, Professional professional) {
			super();
			this.user_id = user_id;
			this.email = email;
			this.password = password;
			this.role = role;
			this.customer = customer;
			this.professional = professional;
		}

		public Long getId() {
			return user_id;
		}

		public void setId(Long user_id) {
			this.user_id = user_id;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		public Professional getProfessional() {
			return professional;
		}

		public void setProfessional(Professional professional) {
			this.professional = professional;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
		

		public String getPassword() {
			return password;
		}

		@Override
		public String toString() {
			return "User [id=" + user_id + ", email=" + email + ", role=" + role + ", customer=" + customer
					+ ", professional=" + professional + "]";
		}


}
