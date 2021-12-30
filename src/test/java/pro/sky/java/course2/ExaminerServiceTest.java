package pro.sky.java.course2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.examinerservice.Question;
import pro.sky.java.course2.examinerservice.service.ExaminerServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {
    @Mock
    private ExaminerServiceImpl examinerServiceImpl;

    @Test
    public void shouldCallQuestionServiceMethodWhenAddAndRemoveElement() {
        Question question = new Question("Сколько будет 5 + 5", "5 + 5 = 10");

        when(examinerServiceImpl.add(question)).thenReturn(question);
        when(examinerServiceImpl.remove(question)).thenReturn(question);
        assertEquals(question,examinerServiceImpl.add(question));
        assertEquals(question,examinerServiceImpl.remove(question));
    }
}
