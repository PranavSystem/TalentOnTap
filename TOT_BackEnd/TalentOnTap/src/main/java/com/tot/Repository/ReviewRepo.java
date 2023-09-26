package com.tot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tot.Classes.Review;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {

}
