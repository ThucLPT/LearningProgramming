package pkg.entity;

import javax.persistence.*;

import lombok.*;

@Entity

@NoArgsConstructor
@Getter
@Setter
public class Tag {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String text;

	private int use;

	@Transient
	private double weight;

	public Tag(String text, int use) {
		this.text = text;
		this.use = use;
	}
}
