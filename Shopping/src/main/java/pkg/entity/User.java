package pkg.entity;

import javax.persistence.*;

import lombok.*;

@Entity

@NoArgsConstructor
@Getter
@Setter
public class User {
	@Id
	private String username;

	private String password;

	@ManyToOne
	@JoinColumn
	private Role role;
}
