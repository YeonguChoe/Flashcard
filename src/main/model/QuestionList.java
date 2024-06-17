package model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

//Represents a list of questions that can store question objects
public class QuestionList {

    private HashMap<Integer, Question> questions;

    /*
     * Constructor
     * EFFECTS: construct a list which stores questions
     */
    public QuestionList() {
        this.questions = new HashMap<>();
    }

    public HashMap<Integer, Question> getQuestions() {
        return this.questions;
    }

    /*
     * REQUIRES: unique code must be valid
     * EFFECTS: returns a question of that code
     * */
    public Question getQuestionObject(int uniqueCode) {
        return questions.get(uniqueCode);
    }

    /*
     * MODIFIES: this
     * EFFECTS: add question to the question list
     */
    public void addQuestion(Question question) {
        if (!questions.containsValue(question)) {
            questions.put(question.uniqueCode, question);
        }
    }

    /*
     * REQUIRES: uniqueCode must exist
     * MODIFIES: this
     * EFFECTS: delete question from the question list
     */
    public void deleteQuestion(int uniqueCode) {
        questions.remove(uniqueCode);
    }

    /*
     * EFFECTS: make Json object out of this
     * then returns the JSON object
     */
    public JSONObject toJsonObject() {
        JSONObject json = new JSONObject();
        json.put("questions", toJsonArray());
        return json;
    }

    /*
    * EFFECTS: returns Json array
    * */
    public JSONArray toJsonArray() {
        JSONArray jsonArray = new JSONArray();
        for (int code : questions.keySet()) {
            JSONObject element = new JSONObject();
            element.put("code", code);
            Question q1 = getQuestionObject(code);
            element.put("question", q1.getQuestion());
            element.put("answers", q1.getAnswers());
            jsonArray.put(element);
        }
        return jsonArray;
    }

}
