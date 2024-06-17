package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

//Represents a test for methods in QuestionList class
public class QuestionListTest {

    private Question question1, question2, question3;
    private QuestionList questionList1;

    @BeforeEach
    void runBefore() {
        this.question1 = new Question("Province of Vancouver", 1);
        question1.addAnswer("BC");
        this.question2 = new Question("3*8=?", 2);
        question2.addAnswer("24");
        this.question3 = new Question("How many color in Canadian flag?", 3);
        question3.addAnswer("2");
        this.questionList1 = new QuestionList();
        this.questionList1.addQuestion(question1);
        this.questionList1.addQuestion(question2);
        this.questionList1.addQuestion(question3);
    }

    @Test
    void testingConstructor() {
        assertTrue(questionList1.getQuestionObject(question1.getUniqueCode()).equals(question1));
        assertTrue(questionList1.getQuestionObject(question2.getUniqueCode()).equals(question2));
        assertTrue(questionList1.getQuestionObject(question3.getUniqueCode()).equals(question3));
    }

    @Test
    void testGetQuestions() {
        HashMap<Integer, Question> theSample = new HashMap<>();
        theSample.put(question1.getUniqueCode(), question1);
        theSample.put(question2.getUniqueCode(), question2);
        theSample.put(question3.getUniqueCode(), question3);
        assertEquals(theSample, questionList1.getQuestions());
    }

    @Test
    void testGetQuestion() {
        int code1 = question1.getUniqueCode();
        assertEquals(question1, questionList1.getQuestionObject(code1));
    }

    @Test
    void testAddQuestionNoExist() {
        Question question4 = new Question("1+9=?", 4);
        question4.addAnswer("10");
        questionList1.addQuestion(question4);
        int code4 = question4.getUniqueCode();
        assertEquals(question4, questionList1.getQuestionObject(code4));
    }

    @Test
    void testAddQuestionAlreadyExist() {
        assertEquals(3, questionList1.getQuestions().size());
        questionList1.addQuestion(question3);
        assertEquals(3, questionList1.getQuestions().size());
    }

    @Test
    void testDeleteQuestion() {
        String code = Integer.toString(question1.getUniqueCode());
        questionList1.deleteQuestion(Integer.parseInt(code));
        assertFalse(questionList1.getQuestions().containsKey(code));
    }

}
