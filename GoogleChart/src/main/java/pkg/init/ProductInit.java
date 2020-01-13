package pkg.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.stereotype.Component;

import pkg.entity.Product;
import pkg.repository.ProductRepository;

@Component
public class ProductInit implements ApplicationRunner {
	@Autowired
	private ProductRepository repository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Product entity1 = new Product("Laptop 1", 41);
		Product entity2 = new Product("Laptop 2", 222);
		Product entity3 = new Product("Computer 1", 37);
		Product entity4 = new Product("Computer 2", 17);
		Product entity5 = new Product("Computer 3", 25);

		repository.save(entity1);
		repository.save(entity2);
		repository.save(entity3);
		repository.save(entity4);
		repository.save(entity5);
	}
}
