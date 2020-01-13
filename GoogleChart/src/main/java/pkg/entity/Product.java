package pkg.entity;

import javax.persistence.*;

import lombok.*;

@Entity

@NoArgsConstructor
@Getter
public class Product {
	@Id
	@GeneratedValue
	private int id;

	private String name;

	private int quantity;

	public Product(String name, int quantity) {
		this.name = name;
		this.quantity = quantity;
	}
}
