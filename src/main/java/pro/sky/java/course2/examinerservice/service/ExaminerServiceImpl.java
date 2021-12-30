package pro.sky.java.course2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.Question;
import pro.sky.java.course2.examinerservice.exceptions.TooBigAmountException;

import java.util.*;

@Service
public class ExaminerServiceImpl implements QuestionService,ExaminerService {
    QuestionService questionService;
    Set<Question> questionSet = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        Question currentQuestion = new Question(question, answer);
        questionSet.add(currentQuestion);
        return currentQuestion;
    }

    @Override
    public Question add(Question question) {
        questionSet.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questionSet.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questionSet;
    }

    @Override
    public Question getRandomQuestion() {
        int randomDigit = new Random().nextInt(questionSet.size());
        Iterator<Question> i = questionSet.iterator();
        int counter = 0;
        while (i.hasNext()) {
            if (counter == randomDigit) {
                return i.next();
            }
            i.next();
            counter++;
        }
        return null;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Collection<Question> questions = questionService.getAll();
        if (questions.size() < amount) {
            throw new TooBigAmountException();
        }
        for (int i = 0; i < amount; i++) {
            questionSet.add(questionService.getRandomQuestion());
        }
        return questionSet;
    }
}
