package com.vrushabh.QuizFullStack.Controller;

import com.vrushabh.QuizFullStack.Entity.Question;
import com.vrushabh.QuizFullStack.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Collections;

@CrossOrigin(origins = {"http://127.0.0.1:5500", "http://localhost:5500"})
@RestController
@RequestMapping("/api")
public class QuizController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/auth/check")
    public ResponseEntity<String> checkAuth(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()
                && !"anonymousUser".equals(authentication.getName())) {
            return ResponseEntity.ok("authenticated");
        }
        return ResponseEntity.status(401).build();
    }

    @GetMapping("/questions/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(
            @PathVariable String category,
            Authentication auth) {

        List<Question> questions = questionService.getQuestionsByCategory(category);
        return ResponseEntity.ok(questions.isEmpty() ? Collections.emptyList() : questions);
    }

    @GetMapping("/questions")
    public ResponseEntity<List<Question>> getAllQuestions(Authentication auth) {
        List<Question> questions = questionService.getAllQuestions();
        return ResponseEntity.ok(questions);
    }

    @PostMapping("/questions")
    public ResponseEntity<Question> saveQuestion(
            @RequestBody Question question,
            Authentication auth) {
        Question saved = questionService.saveQuestion(question);
        return ResponseEntity.ok(saved);
    }
}
