package pkg.controller;

import java.util.*;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pkg.dto.Item;
import pkg.entity.Product;
import pkg.service.ProductService;

@Controller
public class IndexController {
	@Autowired
	private ProductService productService;

	@GetMapping("")
	public String index(Model model, HttpSession session) {
		if (session.getAttribute("cart") == null) {
			List<Item> cart = new ArrayList<Item>();
			session.setAttribute("cart", cart);
		}
		model.addAttribute("products", productService.findAll());
		model.addAttribute("total", productService.total(session));
		return "index";
	}

	@GetMapping("find")
	@ResponseBody
	public List<Product> search(HttpServletRequest request) {
		String[] names = request.getParameterValues("keyword");
		if (names != null) 
			return productService.search(names);
		return productService.findAll();
	}
}
