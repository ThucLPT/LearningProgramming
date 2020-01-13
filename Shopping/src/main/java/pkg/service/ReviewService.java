package pkg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pkg.entity.Review;
import pkg.repo.ReviewRepo;

@Service
public class ReviewService {
	@Autowired
	private ReviewRepo reviewRepo;

	public Review save(Review review) {
		return reviewRepo.save(review);
	}

	public void delete(Review review) {
		reviewRepo.delete(review);
	}
}
