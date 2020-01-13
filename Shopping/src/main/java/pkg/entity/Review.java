package pkg.entity;

import java.time.*;

import javax.persistence.*;

import lombok.*;

@Entity

@NoArgsConstructor
@Getter
@Setter
public class Review {
	@EmbeddedId
	private ReviewId id;

	@ManyToOne
	@JoinColumn(insertable = false, updatable = false)
	private Product product;

	@ManyToOne
	@JoinColumn(insertable = false, updatable = false)
	private User user;

	private int star;

	private String comment;

	private LocalDate date;

	private LocalTime time;
}
