package pkg.service;

import java.util.*;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pkg.dto.Item;
import pkg.entity.Product;
import pkg.repo.ProductRepo;

@Service
public class ProductService {
	@Autowired
	private ProductRepo productRepo;

	public Product save(Product product) {
		return productRepo.save(product);
	}

	public List<Product> findAll() {
		return productRepo.findAll();
	}

	public Product findById(int id) {
		return productRepo.findById(id).get();
	}

	public List<Product> findByPriceBetween(int min, int max) {
		return productRepo.findByPriceBetween(min, max);
	}

	public List<Product> findByName(String name) {
		return productRepo.findByName(name);
	}

	public List<String> findByNameContaining(String name) {
		return productRepo.findByNameContaining(name);
	}

	public List<Product> search(String[] names) {
		List<Product> products = new ArrayList<Product>();
		for (String name : Arrays.stream(names).collect(Collectors.toSet())) {
			products.addAll(findByName(name));
		}
		return products;
	}

	public int isExist(int id, List<Item> cart) {
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getProduct().getId() == id) {
				return i;
			}
		}
		return -1;
	}

	@SuppressWarnings("unchecked")
	public int total(HttpSession session) {
		int total = 0;
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		for (Item item : cart) {
			total += item.getProduct().getPrice() * item.getQuantity();
		}
		return total;
	}
}
