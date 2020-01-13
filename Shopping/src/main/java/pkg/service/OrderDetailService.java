package pkg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pkg.entity.OrderDetail;
import pkg.repo.OrderDetailRepo;

@Service
public class OrderDetailService {
	@Autowired
	private OrderDetailRepo orderDetailRepo;

	public OrderDetail save(OrderDetail orderDetail) {
		return orderDetailRepo.save(orderDetail);
	}
}
