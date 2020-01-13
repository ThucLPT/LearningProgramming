package com.entity;

import java.util.Set;

import javax.persistence.*;

import lombok.*;

@Entity

@NoArgsConstructor
@Getter
@Setter
public class Choice extends Abstract {
	@OneToMany(mappedBy = "choice")
	private Set<Quiz> quiz;
}
