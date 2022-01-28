package pro.sky.java.course2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.Question;
import pro.sky.java.course2.examinerservice.exceptions.TooBigAmountException;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> questionSet = new HashSet<>();
        for (int i = 0; i < amount; i++) {
            Question question = questionService.getRandomQuestion();
            if(questionSet.contains(question)){
                i--;
                continue;
            }
            questionSet.add(question);
        }
        return questionSet;
    }
}
