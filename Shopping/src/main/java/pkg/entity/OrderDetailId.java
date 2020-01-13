package pkg.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.*;

@Embeddable

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class OrderDetailId implements Serializable {
	private static final long serialVersionUID = 1L;
	private int order_ID;
	private int product_ID;
}
