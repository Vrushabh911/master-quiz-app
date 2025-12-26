package com.vrushabh.QuizFullStack.Controller;

import com.vrushabh.QuizFullStack.Entity.Question;
import com.vrushabh.QuizFullStack.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class QuizController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/questions")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/questions/category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category) {
        List<Question> questions = questionService.getQuestionsByCategory(category);
        return questions.isEmpty() ? List.of() : questions;
    }

    @PostMapping("/questions")
    public Question saveQuestion(@RequestBody Question question) {
        return questionService.saveQuestion(question);
    }
}
