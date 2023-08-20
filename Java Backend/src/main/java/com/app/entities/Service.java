package com.app.entities;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "services")

public class Service {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long service_id;

	    @NotBlank(message = "Service name is required")
	    @Size(max = 100, message = "Service name can't exceed 100 characters")
	    private String service_name;

	    @Size(max = 1000, message = "Description can't exceed 1000 characters")
	    private String description;

	    @NotNull(message = "Service rates are required")
	    @DecimalMin(value = "1", message = "Service rates must be at least Rs1")
	    private BigDecimal service_rates;

	    // Relationships (if needed)
	     @ManyToOne
	     @JoinColumn(name = "category_id")
	     private Category category;

	     @OneToMany(mappedBy = "service")
	     private List<Appointment> appointments;

		public Service() {
			super();
		}

		public Service(Long service_id,
				@NotBlank(message = "Service name is required") @Size(max = 100, message = "Service name can't exceed 100 characters") String service_name,
				@Size(max = 1000, message = "Description can't exceed 1000 characters") String description,
				@NotNull(message = "Service rates are required") @DecimalMin(value = "0.01", message = "Service rates must be at least 0.01") BigDecimal service_rates,
				Category category, List<Appointment> appointments) {
			super();
			this.service_id = service_id;
			this.service_name = service_name;
			this.description = description;
			this.service_rates = service_rates;
			this.category = category;
			this.appointments = appointments;
		}

		public Long getService_id() {
			return service_id;
		}

		public void setService_id(Long service_id) {
			this.service_id = service_id;
		}

		public String getService_name() {
			return service_name;
		}

		public void setService_name(String service_name) {
			this.service_name = service_name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public BigDecimal getService_rates() {
			return service_rates;
		}

		public void setService_rates(BigDecimal service_rates) {
			this.service_rates = service_rates;
		}

		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}

		public List<Appointment> getAppointments() {
			return appointments;
		}

		public void setAppointments(List<Appointment> appointments) {
			this.appointments = appointments;
		}

		@Override
		public String toString() {
			return "Service [service_id=" + service_id + ", service_name=" + service_name + ", description="
					+ description + ", service_rates=" + service_rates + "]";
		}
	     

}
