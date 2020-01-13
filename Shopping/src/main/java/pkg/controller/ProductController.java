package pkg.controller;

import java.security.Principal;
import java.util.*;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import pkg.entity.*;
import pkg.service.ProductService;

@Controller
@RequestMapping("product")
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping("create")
	public String create(HttpSession session) {
		session.setAttribute("product", new Product());
		return "form";
	}

	@GetMapping("update/{id}")
	public String update(HttpSession session, @PathVariable("id") int id) {
		session.setAttribute("product", productService.findById(id));
		return "form";
	}

	@GetMapping("view/{id}")
	public String view(HttpSession session, @PathVariable("id") int id, Model model, Principal principal) {
		Product product = productService.findById(id);
		model.addAttribute("product", product);
		if (principal != null) {
			model.addAttribute("review", new Review());
			session.setAttribute("product", product);
			List<Review> reviews = new ArrayList<Review>();
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			for (Review review : product.getReviews()) {
				if (review.getUser().getUsername().equals(username)) {
					model.addAttribute("yourReview", review);
					session.setAttribute("yourReview", review);
					continue;
				}
				reviews.add(review);
			}
			model.addAttribute("reviews", reviews);
		} else
			model.addAttribute("reviews", product.getReviews());
		return "view";
	}

	@PostMapping("save")
	public String save(HttpSession session, HttpServletRequest request, @RequestParam("img") MultipartFile file) {
		try {
			Product product = (Product) session.getAttribute("product");
			product.setName(request.getParameter("name"));
			product.setPrice(Integer.parseInt(request.getParameter("price")));
			product.setImg(file.getBytes());
			productService.save(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}
}
