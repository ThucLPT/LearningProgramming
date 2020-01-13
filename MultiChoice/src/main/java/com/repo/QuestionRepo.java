package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.entity.Question;;

public interface QuestionRepo extends JpaRepository<Question, Integer> {

}
