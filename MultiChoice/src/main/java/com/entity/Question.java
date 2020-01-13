package com.entity;

import java.util.List;
import javax.persistence.*;

import lombok.*;

@Entity

@NoArgsConstructor
@Getter
@Setter
public class Question extends Abstract {
	@OneToMany(mappedBy = "question")
	private List<Quiz> quiz;
}
