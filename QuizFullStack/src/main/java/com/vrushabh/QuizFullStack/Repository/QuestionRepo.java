package com.vrushabh.QuizFullStack.Repository;

import com.vrushabh.QuizFullStack.Entity.Question;
import com.vrushabh.QuizFullStack.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Long> {
    List<Question> findByCategory(String category);
    List<Question> findByCategoryOrderByIdAsc(String category);
    List<Question> findByCategoryIgnoreCase(String category);
}
