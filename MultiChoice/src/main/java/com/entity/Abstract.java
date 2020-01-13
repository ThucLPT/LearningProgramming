package com.entity;

import javax.persistence.*;

import lombok.*;

@MappedSuperclass

@NoArgsConstructor
@Getter
@Setter
public abstract class Abstract {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String content;
}
