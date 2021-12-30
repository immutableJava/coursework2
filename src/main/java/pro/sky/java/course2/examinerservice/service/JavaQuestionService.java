package pro.sky.java.course2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService{

    Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        Question currentQuestion = new Question(question,answer);
        questions.add(currentQuestion);
        return currentQuestion;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        int randomDigit = new Random().nextInt(questions.size());
        Iterator<Question> i = questions.iterator();
        int counter = 0;
        while (i.hasNext()) {
            if(counter == randomDigit){
                return i.next();
            }
            i.next();
            counter++;
        }
        return null;
    }
}
