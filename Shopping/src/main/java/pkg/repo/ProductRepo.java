package pkg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.*;

import pkg.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {
	List<Product> findByPriceBetween(int min, int max);

	List<Product> findByName(String name);

	@Query("select p.name from Product p where p.name like %?1%")
	List<String> findByNameContaining(String name);
}
