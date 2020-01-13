package pkg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pkg.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
