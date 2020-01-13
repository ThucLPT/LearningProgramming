package pkg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import pkg.entity.Product;
import pkg.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService service;

	@GetMapping("")
	public String index() {
		return "index";
	}

	@GetMapping("api")
	@ResponseBody
	public List<Product> findAll() {
		return service.findAll();
	}
}
