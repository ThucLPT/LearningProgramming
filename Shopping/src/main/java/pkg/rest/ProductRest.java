package pkg.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pkg.entity.Product;
import pkg.service.ProductService;

@RestController
public class ProductRest {
	@Autowired
	private ProductService productService;

	@GetMapping("search/{min}/{max}")
	public List<Product> findByPriceBetween(@PathVariable int min, @PathVariable int max) {
		return productService.findByPriceBetween(min, max);
	}

	@GetMapping("search")
	public List<String> search(HttpServletRequest request) {
		String name = request.getParameter("term");
		return productService.findByNameContaining(name);
	}
}
