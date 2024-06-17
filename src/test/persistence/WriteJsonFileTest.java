package persistence;

import model.Question;
import model.QuestionList;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

//Represents a test for methods in WriteJsonFile class
public class WriteJsonFileTest {

    WriteJsonFile writer;
    ReadJsonFile reader;
    QuestionList q1, q2;
    String invalidPath = "./data/the\0illegal:fileName.json";
    String validPath = "./data/testingWriter.json";

    @Test
    void testWriteOnInvalidFile() {

        writer = new WriteJsonFile(invalidPath);
        q1 = new QuestionList();
        try {
            writer.open(invalidPath);
            fail("It should have given IOException!!");
        } catch (IOException e) {
            /*expected*/
        }
    }

    @Test
    void testWriteOneQuestion() {

        writer = new WriteJsonFile(validPath);
        reader = new ReadJsonFile(validPath);
        q1 = new QuestionList();
        q1.addQuestion(new Question("10+2=?", 10));
        try {
            writer.open(validPath);
            writer.write(q1);
            writer.close();
            //Read
            q2 = reader.read();
            assertTrue(q2.getQuestions().containsKey(10));
            assertEquals(1, q2.getQuestions().size());
        } catch (IOException e) {
            fail("Exception is not expected");
        }
    }

    @Test
    void testWriteMultipleQuestions() {
        writer = new WriteJsonFile(validPath);
        reader = new ReadJsonFile(validPath);
        q1 = new QuestionList();
        try {

            q1.addQuestion(new Question("3+8=?", 11));
            q1.addQuestion(new Question("7+2=?", 12));

            writer.open(validPath);
            writer.write(q1);
            writer.close();

            //Read the Json file
            q2 = reader.read();
            assertEquals(2, q2.getQuestions().size());
            assertEquals("3+8=?", q2.getQuestions().get(11).getQuestion());
            assertEquals("7+2=?", q2.getQuestions().get(12).getQuestion());
        } catch (IOException e) {
            fail("Exception is not expected. The code is wrong!");
        }
    }
}
