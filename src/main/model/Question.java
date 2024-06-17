package model;

import java.util.ArrayList;
import java.util.Random;

//Represents a question object which has details about a question
public class Question {

    private final String question;
    private final ArrayList<String> answers;
    protected int uniqueCode;

    /*
     * Constructor
     * MODIFIES: this
     * EFFECTS: construct Question
     * assign question and randomly generated uniqueCode
     */
    public Question(String quiz) {
        this.question = quiz;
        answers = new ArrayList<>();
        Random numberGenerator = new Random();
        this.uniqueCode = numberGenerator.nextInt(10000);
    }

    /*
     * Constructor
     * REQUIRES: the parameter, code should be between 1 and 10000
     * MODIFIES: this
     * EFFECTS: construct Question
     * assign question and unique code using parameter
     */
    public Question(String quiz, int code) {
        this.question = quiz;
        answers = new ArrayList<>();
        this.uniqueCode = code;
    }

    /*
     * EFFECTS: returns the content of question
     * */
    public String getQuestion() {
        return this.question;
    }

    /*
     * EFFECTS: returns the list of answers
     * */
    public ArrayList<String> getAnswers() {
        return this.answers;
    }

    /*
     * EFFECTS: returns the unique code for this
     * */
    public int getUniqueCode() {
        return this.uniqueCode;
    }

    /*
     * MODIFIES: this
     * EFFECTS: add another answer to the correct answer list
     */
    public void addAnswer(String newAnswer) {
        this.answers.add(newAnswer);
    }

}
