package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.*;
import com.repo.QuestionRepo;

@Service
public class QuestionService {
	@Autowired
	private QuestionRepo questionRepo;

	public List<Question> findAll() {
		return questionRepo.findAll();
	}

	public int getCorrectChoiceIdByQuestionId(int id) {
		Question question = questionRepo.findById(id).get();
		for (Quiz quiz : question.getQuiz()) {
			if (quiz.isAnswer()) {
				return quiz.getChoice().getId();
			}
		}
		return -1;
	}
}
