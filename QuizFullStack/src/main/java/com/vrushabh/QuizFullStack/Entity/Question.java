package com.vrushabh.QuizFullStack.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "question_des")
    private String questionDes;

    @Column(name = "correct_ans")
    private String correctAns;

    private String category;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "question_options", joinColumns = @JoinColumn(name = "question_id"))
    @Column(name = "option_text")
    @JsonProperty("options")
    private List<String> options;

    // Constructors
    public Question() {}

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getQuestionDes() { return questionDes; }
    public void setQuestionDes(String questionDes) { this.questionDes = questionDes; }
    public String getCorrectAns() { return correctAns; }
    public void setCorrectAns(String correctAns) { this.correctAns = correctAns; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public List<String> getOptions() { return options; }
    public void setOptions(List<String> options) { this.options = options; }
}
