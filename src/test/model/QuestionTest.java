package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//Represents a test for methods in Question class
class QuestionTest {

    private Question question1;

    @BeforeEach
    void runBefore() {
        this.question1 = new Question("what is the number whose absolute value is 3?");
        this.question1.addAnswer("-3");
        this.question1.addAnswer("3");
    }

    @Test
    void testConstructor() {
        assertEquals("what is the number whose absolute value is 3?", question1.getQuestion());
        assertTrue(question1.getAnswers().contains("3"));
    }

    @Test
    void testGetQuestion() {
        String question = question1.getQuestion();
        assertEquals("what is the number whose absolute value is 3?", question);
    }

    @Test
    void testGetAnswers() {
        ArrayList<String> expectedAnswers = new ArrayList<>();
        assertTrue(question1.getAnswers().contains("3"));
        assertTrue(question1.getAnswers().contains("-3"));
    }

    @Test
    void testGetUniqueCode() {
        int code = question1.getUniqueCode();
        assertTrue(code >= 1 && code <= 10000);
        assertEquals(question1.uniqueCode, code);
    }

    @Test
    void testAddAnswer() {
        question1.addAnswer("30");
        assertTrue(question1.getAnswers().contains("30"));
    }
}