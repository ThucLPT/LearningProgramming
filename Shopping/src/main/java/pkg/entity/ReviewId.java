package pkg.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.*;

@Embeddable

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class ReviewId implements Serializable {
	private static final long serialVersionUID = 1L;
	private int product_ID;
	private String user_Username;
}
