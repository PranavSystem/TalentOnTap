package com.app.entities;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "ratings_and_reviews")

public class RatingAndReview {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long r_id;

	    @Min(value = 1, message = "Rating must be at least 1")
	    @Max(value = 5, message = "Rating must not exceed 5")
	    private Integer rating;

	    @Size(max = 1000, message = "Review can't exceed 1000 characters")
	    private String review;

	    @PastOrPresent(message = "Review date must be in the past or present")
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date r_date;

	    @ManyToOne
	    @JoinColumn(name = "p_id")
	    private Professional professional;

	    @ManyToOne
	    @JoinColumn(name = "cust_id")
	    private Customer customer;

	    @ManyToOne
	    @JoinColumn(name = "service_id")
	    private Service service;

		public RatingAndReview() {
			super();
		}

		public RatingAndReview(Long r_id,
			    @Min(value = 1, message = "Rating must be at least 1") @Max(value = 5, message = "Rating must not exceed 5") Integer rating,
				@Size(max = 1000, message = "Review can't exceed 1000 characters") String review,
				@PastOrPresent(message = "Review date must be in the past or present") Date r_date,
				Professional professional, Customer customer, Service service) {
			super();
			this.r_id = r_id;
			this.rating = rating;
			this.review = review;
			this.r_date = r_date;
			this.professional = professional;
			this.customer = customer;
			this.service = service;
		}

		public Long getR_id() {
			return r_id;
		}

		public void setR_id(Long r_id) {
			this.r_id = r_id;
		}

		public Integer getRating() {
			return rating;
		}

		public void setRating(Integer rating) {
			this.rating = rating;
		}

		public String getReview() {
			return review;
		}

		public void setReview(String review) {
			this.review = review;
		}

		public Date getR_date() {
			return r_date;
		}

		public void setR_date(Date r_date) {
			this.r_date = r_date;
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
			return "RatingAndReview [r_id=" + r_id + ", rating=" + rating + ", review=" + review + ", r_date=" + r_date
					+ ", professional=" + professional + ", customer=" + customer + "]";
		}
	        

}
