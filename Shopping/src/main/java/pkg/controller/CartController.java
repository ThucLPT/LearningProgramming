package pkg.controller;

import java.time.*;
import java.util.*;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import pkg.dto.Item;
import pkg.entity.*;
import pkg.service.*;

@Controller
public class CartController {
	@Autowired
	private UserService userService;
	@Autowired
	private ProductService productService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderDetailService orderDetailService;

	@SuppressWarnings("unchecked")
	@GetMapping("add/{id}")
	public String add(@PathVariable int id, HttpSession session) {
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		int index = productService.isExist(id, cart);
		if (index == -1) {
			cart.add(new Item(productService.findById(id), 1));
		} else {
			int quantity = cart.get(index).getQuantity() + 1;
			cart.get(index).setQuantity(quantity);
		}
		session.setAttribute("cart", cart);
		return "redirect:/";
	}

	@SuppressWarnings("unchecked")
	@GetMapping("remove/{id}")
	public String remove(@PathVariable int id, HttpSession session) {
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		int index = productService.isExist(id, cart);
		cart.remove(index);
		session.setAttribute("cart", cart);
		return "redirect:/";
	}

	@SuppressWarnings("unchecked")
	@PostMapping("update")
	public String update(HttpServletRequest request, HttpSession session) {
		String[] quantities = request.getParameterValues("quantity");
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		for (int i = 0; i < cart.size(); i++) {
			cart.get(i).setQuantity(Integer.parseInt(quantities[i]));
		}
		session.setAttribute("cart", cart);
		return "redirect:/";
	}

	@SuppressWarnings("unchecked")
	@GetMapping("checkout")
	@ResponseBody
	public String checkout(HttpServletRequest request, HttpSession session) {
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		if (cart.size() > 0) {
			Order order = new Order();
			order.setDate(LocalDate.now());
			order.setTime(LocalTime.now());

			String username = request.getUserPrincipal().getName();
			User user = userService.findById(username).get();
			order.setUser(user);

			int orderId = orderService.save(order).getId();
			for (Item item : cart) {
				OrderDetailId orderDetailId = new OrderDetailId();
				orderDetailId.setOrder_ID(orderId);
				orderDetailId.setProduct_ID(item.getProduct().getId());

				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setOrderDetailId(orderDetailId);
				orderDetail.setQuantity(item.getQuantity());
				orderDetailService.save(orderDetail);
			}
			session.removeAttribute("cart");
		}
		return "Thank you for using our service";
	}
}
