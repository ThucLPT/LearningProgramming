package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.service.QuestionService;

@Controller
public class QuestionController {
	@Autowired
	private QuestionService questionService;

	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("questions", questionService.findAll());
		return "index";
	}

	@PostMapping("submit")
	@ResponseBody
	public String submit(HttpServletRequest request) {
		int score = 0;
		String[] questionIds = request.getParameterValues("questionId");
		for (String questionId : questionIds) {
			int correctChoiceId = questionService.getCorrectChoiceIdByQuestionId(Integer.parseInt(questionId));
			if (Integer.parseInt(request.getParameter("question" + questionId)) == correctChoiceId) {
				score++;
			}
		}
		return "Score: " + score;
	}
}
