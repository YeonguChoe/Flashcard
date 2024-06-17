package ui;

import model.QuestionList;
import persistence.ReadJsonFile;
import persistence.WriteJsonFile;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

//Initialize fields used in GUI
public class Initialization {
    JFrame frameMain = new JFrame();
    JPanel panelMain;

    public static final String SAVEDQUESTIONLIST = "./data/questions.json";
    JPanel bottomPanel;
    JPanel topLeftPanel;
    JPanel topRightPanel;
    JTable questionTable;

    JPanel bottomPanel1;
    JPanel bottomPanel2;
    JPanel bottomPanel3;
    JPanel bottomPanel4;
    JButton saveBtn;
    JButton loadBtn;
    JButton answerBtn;
    JButton newAnswerBtn;
    JButton newQuestionBtn;
    JButton deleteQuestionBtn;
    ReadJsonFile jsonReader;

    JTextArea answerBox;
    JTextArea answerCodeBox;
    JTextArea newQuestionBox;
    JTextArea newAnswerBox;
    JTextArea newAnswerCodeBox;
    JTextArea deleteQuestionCodeBox;
    JLabel answerCodeLabel;
    JLabel newAnswerCodeLabel;
    JLabel deleteQuestionCodeLabel;

    DefaultTableModel theTable;

    QuestionList theQuestionList;
    WriteJsonFile jsonWriter;

    /*
     * MODIFIES: this
     * EFFECTS: initialize buttons
     * */
    protected void initializeJButton() {
        saveBtn = new JButton("Save");
        loadBtn = new JButton("Load");
        answerBtn = new JButton("Answer!");
        newQuestionBtn = new JButton("New Question!");
        newAnswerBtn = new JButton("New Answer!");
        deleteQuestionBtn = new JButton("Delete Question!");
    }

    /*
     * MODIFIES: this
     * EFFECTS: Initialize JPanels
     * */
    protected void initializeJPanel() {
        topLeftPanel = new JPanel();
        topRightPanel = new JPanel();
        bottomPanel = new JPanel();
        bottomPanel1 = new JPanel();
        bottomPanel2 = new JPanel();
        bottomPanel3 = new JPanel();
        bottomPanel4 = new JPanel();
        panelMain = new JPanel();
    }

    /*
     * MODIFIES: this
     * EFFECTS: initialize JTextAreas
     * */
    protected void initializeJTextArea() {
        newAnswerBox = new JTextArea();
        answerBox = new JTextArea();
        newQuestionBox = new JTextArea();
        newAnswerCodeBox = new JTextArea();
        newAnswerCodeBox = new JTextArea();
        deleteQuestionCodeBox = new JTextArea();
        answerCodeBox = new JTextArea();
    }

    /*
     * MODIFIES: this
     * EFFECTS: initialize instruction part as "Code: "
     * */
    protected void initializeJLabel() {
        newAnswerCodeLabel = new JLabel("Code: ");
        deleteQuestionCodeLabel = new JLabel("Code: ");
        answerCodeLabel = new JLabel("Code: ");
    }

    /*
     * MODIFIES: this
     * EFFECTS: initialize tables
     * */
    protected void initializeJTable() {
        questionTable = new JTable();
        theTable = new DefaultTableModel();
    }

    /*
     * MODIFIES: this
     * EFFECTS: initialize JSON reader and writer
     * */
    protected void initializeJsonReaderWriter() {
        jsonReader = new ReadJsonFile(SAVEDQUESTIONLIST);
        jsonWriter = new WriteJsonFile(SAVEDQUESTIONLIST);
    }
}
