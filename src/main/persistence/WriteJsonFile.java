package persistence;

import model.QuestionList;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

// Represents a writer that writes question list data into JSON file
public class WriteJsonFile {

    private PrintWriter openedFile;

    /*
     * REQUIRES: filePath should be valid
     * EFFECTS: construct JSon writer and assign the file name
     */
    public WriteJsonFile(String filePath) {
    }


    /*
     * REQUIRES: filePath should be valid
     * EFFECTS: initialize the PrintWriter
     * */
    public void open(String filePath) throws FileNotFoundException {
        openedFile = new PrintWriter(filePath);
    }

    /*
     * MODIFIES: this
     * EFFECTS: make JSON object using a QuestionList
     * and write it on the clipboard
     */
    public void write(QuestionList theQuestionList) {
        JSONObject json = theQuestionList.toJsonObject();
        openedFile.print(json.toString());
    }

    /*
     *MODIFIES: this
     *EFFECTS: actually save the clipboard data to the JSON file
     */
    public void close() {
        openedFile.close();
    }
}
