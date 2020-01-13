package pkg.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import pkg.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Integer> {

}
