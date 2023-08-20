package com.app.entities;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "appointments")
 
public class Appointment {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long appt_id;

	    @NotNull(message = "Appointment date is required")
	    @FutureOrPresent(message = "Appointment date must be in the future or present")
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date appt_date;

	    @ManyToOne
	    @JoinColumn(name = "p_id")
	    private Professional professional;

	    @ManyToOne
	    @JoinColumn(name = "cust_id")
	    private Customer customer;

	    @ManyToOne
	    @JoinColumn(name = "service_id")
	    private Service service;

		public Appointment() {
			super();
		}

		public Appointment(Long appt_id,
				@NotNull(message = "Appointment date is required") @FutureOrPresent(message = "Appointment date must be in the future or present") Date appt_date,
				Professional professional, Customer customer, Service service) {
			super();
			this.appt_id = appt_id;
			this.appt_date = appt_date;
			this.professional = professional;
			this.customer = customer;
			this.service = service;
		}

		public Long getAppt_id() {
			return appt_id;
		}

		public void setAppt_id(Long appt_id) {
			this.appt_id = appt_id;
		}

		public Date getAppt_date() {
			return appt_date;
		}

		public void setAppt_date(Date appt_date) {
			this.appt_date = appt_date;
		}

		public Professional getProfessional() {
			return professional;
		}

		public void setProfessional(Professional professional) {
			this.professional = professional;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		public Service getService() {
			return service;
		}

		public void setService(Service service) {
			this.service = service;
		}

		@Override
		public String toString() {
			return "Appointment [appt_id=" + appt_id + ", appt_date=" + appt_date + ", professional=" + professional
					+ ", customer=" + customer + ", service=" + service + "]";
		}
	    
	 
}
