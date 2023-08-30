package com.ycp.Classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Review_And_Rating")
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Review_id")
	private long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "Rating", length = 20)
	private Rating rating;

	@Column(name = "Review")
	private String review;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "Customer_id")
	private Professional reviewpid;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "Professional_id")
	private Customer reviewdid;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Professional getReviewpid() {
		return reviewpid;
	}

	public void setReviewpid(Professional reviewpid) {
		this.reviewpid = reviewpid;
	}

	public Customer getReviewdid() {
		return reviewdid;
	}

	public void setReviewdid(Customer reviewdid) {
		this.reviewdid = reviewdid;
	}

	public Review(long id, Rating rating, String review, Professional reviewpid, Customer reviewdid) {
		super();
		this.id = id;
		this.rating = rating;
		this.review = review;
		this.reviewpid = reviewpid;
		this.reviewdid = reviewdid;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", rating=" + rating + ", review=" + review + ", reviewpid=" + reviewpid
				+ ", reviewdid=" + reviewdid + "]";
	}

	public Review() {
		
	}

}
