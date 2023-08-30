package com.ycp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ycp.Classes.Review;
import com.ycp.Services.ReviewService;

@RestController
@RequestMapping("/review")
public class ReviewController {

	@Autowired
	private ReviewService service;

	@GetMapping("/{review_id}")
	public Review getReviewById(@PathVariable long review_id) {
		System.out.println("inside Review controller");
		return service.getReviewById(review_id);
	}

	@GetMapping("/getAll")
	public List<Review> getAll() {
		return service.getAllReview();
	}

}
