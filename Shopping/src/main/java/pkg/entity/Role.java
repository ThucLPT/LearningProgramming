package pkg.entity;

import javax.persistence.*;

import lombok.*;

@Entity

@NoArgsConstructor
@Getter
@Setter
public class Role {
	@Id
	private String name;
}
