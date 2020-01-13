package pkg.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import pkg.entity.*;

public interface OrderDetailRepo extends JpaRepository<OrderDetail, OrderDetailId> {

}
