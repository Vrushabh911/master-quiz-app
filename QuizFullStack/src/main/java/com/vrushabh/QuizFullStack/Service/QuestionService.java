package com.vrushabh.QuizFullStack.Service;

import com.vrushabh.QuizFullStack.Entity.Question;
import com.vrushabh.QuizFullStack.Repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepo questionRepo;

    public List<Question> getAllQuestions() {
        return questionRepo.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionRepo.findByCategory(category);
    }

    public Question saveQuestion(Question question) {
        return questionRepo.save(question);
    }
}
