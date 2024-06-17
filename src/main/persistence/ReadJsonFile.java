package persistence;


import model.Question;
import model.QuestionList;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Represents a reader which can read data from JSON file
// Citation: Code obtained from "JSON serialization demo" in Phase 2 instruction
// URL: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
public class ReadJsonFile {

    private final String fileLocation;

    /*
     * EFFECTS: construct JSon reader and assign the file name
     */
    public ReadJsonFile(String filePath) {
        this.fileLocation = filePath;
    }

    /*
     * EFFECTS: make JSON object from JSON file content
     * throws IOException if it can't read the data from file
     * */
    public QuestionList read() throws IOException {
        String jsonData = readContent(fileLocation);
        JSONObject jsonObject = new JSONObject(jsonData);
        return questionListMaker(jsonObject);
    }

    /*
     * EFFECTS: reads the JSON file and returns the contents in terms of String
     * */
    private String readContent(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(contentBuilder::append);
        }
        return contentBuilder.toString();
    }

    /*
     * REQUIRES: JSON file is not empty
     * EFFECTS: make a question list out of JSON file
     * and returns the question list
     * */
    private QuestionList questionListMaker(JSONObject jsonFile) {
        QuestionList theQuestionList = new QuestionList();
        JSONArray wholeArray = jsonFile.getJSONArray("questions");
        for (Object element : wholeArray) {
            JSONObject newElement = (JSONObject) element;
            Question newQuestion = new Question(newElement.getString("question"), newElement.getInt("code"));
            JSONArray answers = newElement.getJSONArray("answers");
            for (Object answer : answers) {
                String anotherAnswer = (String) answer;
                newQuestion.addAnswer(anotherAnswer);
            }
            theQuestionList.addQuestion(newQuestion);
        }
        return theQuestionList;
    }

}
