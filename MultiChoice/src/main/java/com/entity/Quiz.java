package com.entity;

import javax.persistence.*;

import lombok.*;

@Entity

@NoArgsConstructor
@Getter
@Setter
public class Quiz {
	@EmbeddedId
	private QuizId quizId;

	@ManyToOne
	@MapsId("question_ID")
	@JoinColumn
	private Question question;

	@ManyToOne
	@MapsId("choice_ID")
	@JoinColumn
	private Choice choice;

	private boolean answer;
}
