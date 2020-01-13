package pkg.dto;

import lombok.*;
import pkg.entity.Product;

@AllArgsConstructor
@Getter
@Setter
public class Item {
	private Product product;
	private int quantity;
}
