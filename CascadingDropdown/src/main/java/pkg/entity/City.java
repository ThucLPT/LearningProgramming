package pkg.entity;

import java.util.List;

import javax.persistence.*;

import lombok.Getter;

@Entity
@Getter
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	@OneToMany(mappedBy = "city")
	private List<District> districts;
}
