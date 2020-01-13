package pkg.entity;

import java.time.*;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "orders")

@NoArgsConstructor
@Getter
@Setter
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private LocalDate date;

	private LocalTime time;

	@ManyToOne
	@JoinColumn
	private User user;
}
