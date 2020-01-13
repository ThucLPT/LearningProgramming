package com.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.*;

@Embeddable

@NoArgsConstructor
@Getter
@Setter
public class QuizId implements Serializable {
	private static final long serialVersionUID = 1L;
	private int question_ID;
	private int choice_ID;
}
