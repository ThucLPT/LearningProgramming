package pkg.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

@Entity
@Table(name = "order_detail")

@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({ "order", "product" })
public class OrderDetail {
	@EmbeddedId
	private OrderDetailId orderDetailId;

	@ManyToOne
	@JoinColumn(insertable = false, updatable = false)
	private Order order;

	@ManyToOne
	@JoinColumn(insertable = false, updatable = false)
	private Product product;

	private int quantity;
}
