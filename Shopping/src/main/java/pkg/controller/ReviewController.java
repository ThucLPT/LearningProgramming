package pkg.controller;

import java.time.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import pkg.entity.*;
import pkg.service.ReviewService;

@Controller
@RequestMapping("review")
public class ReviewController {
	@Autowired
	private ReviewService reviewService;

	@PostMapping("save")
	public String save(@ModelAttribute("review") Review review, HttpSession session) {
		Product product = (Product) session.getAttribute("product");
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		ReviewId reviewId = new ReviewId();
		reviewId.setProduct_ID(product.getId());
		reviewId.setUser_Username(username);
		review.setId(reviewId);
		review.setDate(LocalDate.now());
		review.setTime(LocalTime.now());
		reviewService.save(review);
		return "redirect:/product/view/" + product.getId();
	}

	@GetMapping("delete")
	public String delete(HttpSession session) {
		Review review = (Review) session.getAttribute("yourReview");
		int id = review.getProduct().getId();
		reviewService.delete(review);
		return "redirect:/product/view/" + id;
	}
}
