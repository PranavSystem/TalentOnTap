package com.app.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class Professional{
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long p_id;
	
	 @NotBlank(message = "Name is required")
	@Column(length = 20) // varchar(20)
	private String p_name;
	
	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format")
	@Column(length = 30, unique = true) // unique constraint
	private String email;
	
	@Column(length = 20, nullable = false) // NOT NULL constraint
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
    message = "Password must be strong: at least 8 characters, one uppercase, one lowercase, one digit, and one special character")
	private String password;
	
	@Pattern(regexp = "\\d{10}", message = "Contact number must be a 10-digit number")
	@Column(nullable=false)
	private int contact_no;
	
	@NotBlank(message = "Region is required")
    private String region;

    @NotBlank(message = "Address is required")
    private String address;

    private boolean availability;
    
    //one to many relations
    @OneToMany(mappedBy = "professional")
    private List<Service> services;

    @OneToMany(mappedBy = "professional")
    private List<RatingAndReview> reviews;


	public Professional() {
		super();
	}

	public Professional(@NotBlank(message = "Name is required") String p_name,
			@NotBlank(message = "Email is required") @Email(message = "Invalid email format") String email,
			@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "Password must be strong: at least 8 characters, one uppercase, one lowercase, one digit, and one special character") String password,
			@Pattern(regexp = "\\d{10}", message = "Contact number must be a 10-digit number") int contact_no,
			@NotBlank(message = "Region is required") String region,
			@NotBlank(message = "Address is required") String address, boolean availability) {
		super();
		this.p_name = p_name;
		this.email = email;
		this.password = password;
		this.contact_no = contact_no;
		this.region = region;
		this.address = address;
		this.availability = availability;
	}

	public Long getP_id() {
		return p_id;
	}

	public void setP_id(Long p_id) {
		this.p_id = p_id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getContact_no() {
		return contact_no;
	}

	public void setContact_no(int contact_no) {
		this.contact_no = contact_no;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "Professional [p_id=" + p_id + ", p_name=" + p_name + ", email=" + email + ", contact_no=" + contact_no
				+ ", region=" + region + ", address=" + address + ", availability=" + availability + ", reviews="
				+ reviews + "]";
	}

	
	
    
    

}
