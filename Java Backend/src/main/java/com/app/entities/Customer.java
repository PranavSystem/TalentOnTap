package com.app.entities;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long cust_id;

	    @NotBlank(message = "Name is required")
	    @Size(max = 50, message = "Name can't exceed 50 characters")
	    private String cust_name;

	    @NotBlank(message = "Email is required")
	    @Email(message = "Invalid email format")
	    @Size(max = 50, message = "Email can't exceed 50 characters")
	    private String email;

	    @NotBlank(message = "Password is required")
	    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
	    message = "Password must be strong: at least 8 characters, one uppercase, one lowercase, one digit, and one special character")
	    private String password;

	    @NotBlank(message = "Contact number is required")
	    @Pattern(regexp = "\\d{10}", message = "Contact number must be a 10-digit number")
	    private String contact_no;

	    @NotBlank(message = "Address is required")
	    private String address;
	    
	    //relations
	    @OneToMany(mappedBy = "customer")
	    private List<Appointment> appointments;

	    @OneToMany(mappedBy = "customer")
	    private List<RatingAndReview> reviews;

		public Customer() {
			super();
		}

		public Customer(Long cust_id,
				@NotBlank(message = "Name is required") @Size(max = 100, message = "Name can't exceed 100 characters") String cust_name,
				@NotBlank(message = "Email is required") @Email(message = "Invalid email format") @Size(max = 100, message = "Email can't exceed 100 characters") String email,
				@NotBlank(message = "Password is required") @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "Password must be strong: at least 8 characters, one uppercase, one lowercase, one digit, and one special character") String password,
				@NotBlank(message = "Contact number is required") @Pattern(regexp = "\\d{10}", message = "Contact number must be a 10-digit number") String contact_no,
				@NotBlank(message = "Address is required") String address, List<Appointment> appointments,
				List<RatingAndReview> reviews) {
			super();
			this.cust_id = cust_id;
			this.cust_name = cust_name;
			this.email = email;
			this.password = password;
			this.contact_no = contact_no;
			this.address = address;
			this.appointments = appointments;
			this.reviews = reviews;
		}

		public Long getCust_id() {
			return cust_id;
		}

		public void setCust_id(Long cust_id) {
			this.cust_id = cust_id;
		}

		public String getCust_name() {
			return cust_name;
		}

		public void setCust_name(String cust_name) {
			this.cust_name = cust_name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getContact_no() {
			return contact_no;
		}

		public void setContact_no(String contact_no) {
			this.contact_no = contact_no;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public List<Appointment> getAppointments() {
			return appointments;
		}

		public void setAppointments(List<Appointment> appointments) {
			this.appointments = appointments;
		}

		public List<RatingAndReview> getReviews() {
			return reviews;
		}

		public void setReviews(List<RatingAndReview> reviews) {
			this.reviews = reviews;
		}

		public void setPassword(String password) {
			this.password = password;	
		}

		
		public String getPassword() {
			return password;
		}

		@Override
		public String toString() {
			return "Customer [cust_id=" + cust_id + ", cust_name=" + cust_name + ", email=" + email + ", contact_no="
					+ contact_no + ", address=" + address + "]";
		}
	   


}
