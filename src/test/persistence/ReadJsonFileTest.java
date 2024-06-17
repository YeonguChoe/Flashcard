package persistence;

import model.Question;
import model.QuestionList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

//Represents a test for methods in ReadJsonFile class
public class ReadJsonFileTest {

    ReadJsonFile reader;
    QuestionList questionList;
    HashMap<Integer, Question> testingQuestions;

    @BeforeEach
    void runBefore() {
        reader = new ReadJsonFile("./data/testingReader.json");
        testingQuestions = new HashMap<>();
        Question q1 = new Question("3+2=?", 1000);
        testingQuestions.put(q1.getUniqueCode(), q1);
    }

    @Test
    void testLoadNonExistingFile() {
        reader = new ReadJsonFile("./data/notExisting.json");
        try {
            questionList = reader.read();
            fail("It should have given IOException error");
        } catch (IOException e) {
            /*expected*/
        }
    }

    @Test
    void testLoadOneQuestion() {
        try {
            questionList = reader.read();
            assertEquals(testingQuestions.get(1000).getQuestion(), questionList.getQuestions().get(1000).getQuestion());
            assertTrue(questionList.getQuestions().containsKey(1000));
            assertEquals("3+2=?", questionList.getQuestions().get(1000).getQuestion());
        } catch (IOException e) {
            fail("The destination file is not found!!");
        }
    }

    @Test
    void testLoadMultipleQuestions() {
        Question q2 = new Question("5+2=?", 2000);
        testingQuestions.put(q2.getUniqueCode(), q2);
        try {
            questionList = reader.read();
            assertTrue(questionList.getQuestions().containsKey(1000));
            assertEquals("3+2=?", questionList.getQuestions().get(1000).getQuestion());
            assertTrue(questionList.getQuestions().containsKey(2000));
            assertEquals("5+2=?", questionList.getQuestions().get(2000).getQuestion());
            assertEquals(2, questionList.getQuestions().size());
        } catch (IOException e) {
            fail("The destination file is not found!!");
        }
    }

}
