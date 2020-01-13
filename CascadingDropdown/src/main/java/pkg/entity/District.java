package pkg.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

@Entity
@Getter
@JsonIgnoreProperties({ "wards", "city" })
public class District {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	@OneToMany(mappedBy = "district")
	private List<Ward> wards;

	@ManyToOne
	@JoinColumn
	private City city;
}
