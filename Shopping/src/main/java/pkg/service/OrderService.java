package pkg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pkg.entity.Order;
import pkg.repo.OrderRepo;

@Service
public class OrderService {
	@Autowired
	private OrderRepo orderRepo;

	public Order save(Order order) {
		return orderRepo.save(order);
	}
}
