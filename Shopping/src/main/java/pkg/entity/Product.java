package pkg.entity;

import java.util.*;

import javax.persistence.*;

import lombok.*;

@Entity

@NoArgsConstructor
@Getter
@Setter
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private int price;

	@Lob
	private byte[] img;

	@OneToMany(mappedBy = "product")
	private List<Review> reviews;

	public String getImg() {
		return "data:image/png;base64," + Base64.getEncoder().encodeToString(img);
	}
}
