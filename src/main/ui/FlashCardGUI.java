package ui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;


//Implements GUI of Flash Card app
public class FlashCardGUI extends Functionality {


    //constructor
    public FlashCardGUI() {

        initializeJButton();

        initializeJPanel();

        initializeJTextArea();

        initializeJLabel();

        initializeJTable();

        initializeJsonReaderWriter();

        makeQuestionList();

        saveButtonFunctionality();

        loadButtonFunctionality();

        answerButtonFunctionality();

        newQuestionButtonFunctionality();

        newAnswerButtonFunctionality();

        deleteButtonFunctionality();

        settingJTable();

        settingLeftPanel();

        settingAnswerBtnPanel();

        settingNewQuestionBtnPanel();

        settingNewAnswerBtnPanel();

        settingDeleteBtnPanel();

        settingBottomFourPanels();

        settingBigJFrame();

        settingJFrame();
    }


    /*
     * MODIFIES: this
     * EFFECTS: create question list table structure
     * */
    private void settingJTable() {
        String[] heading = new String[]{
                "Code", "Question"
        };
        theTable.setColumnIdentifiers(heading);
        questionTable.setModel(theTable);
        JScrollPane tablePanel = new JScrollPane(questionTable);
        tablePanel.setBorder(new LineBorder(Color.DARK_GRAY, 3));
        topRightPanel.setLayout(new BorderLayout());
        topRightPanel.setBorder(new LineBorder(Color.GREEN, 3));
        topRightPanel.add(tablePanel, BorderLayout.CENTER);
    }

    /*
     * MODIFIES: this
     * EFFECTS: create the structure for left side panel in the GUI
     * */
    private void settingLeftPanel() {
        topLeftPanel.setBackground(Color.black);
        topLeftPanel.setLayout(new GridLayout(2, 1, 20, 20));
        topLeftPanel.add(saveBtn);
        topLeftPanel.add(loadBtn);
    }

    /*
     * MODIFIES: this
     * EFFECTS: create the structure for panel for answering question
     * */
    private void settingAnswerBtnPanel() {
        bottomPanel1.setLayout(new GridLayout(2, 2, 10, 10));
        bottomPanel1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        bottomPanel1.setBorder(new LineBorder(Color.RED, 3));
        bottomPanel1.add(answerCodeLabel);
        bottomPanel1.add(answerCodeBox);
        bottomPanel1.add(answerBtn);
        bottomPanel1.add(answerBox);
    }

    /*
     * MODIFIES: this
     * EFFECTS: create the structure for a panel that makes new question
     * */
    private void settingNewQuestionBtnPanel() {
        bottomPanel2.setLayout(new GridLayout(1, 2, 10, 10));
        bottomPanel2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        bottomPanel2.setBorder(new LineBorder(Color.ORANGE, 3));
        bottomPanel2.add(newQuestionBtn);
        bottomPanel2.add(newQuestionBox);
    }


    /*
     * MODIFIES: this
     * EFFECTS: create a structure for panel that adds new answer to a question
     * with corresponding code
     * */
    private void settingNewAnswerBtnPanel() {
        bottomPanel3.setLayout(new GridLayout(2, 2, 10, 10));
        bottomPanel3.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        bottomPanel3.setBorder(new LineBorder(Color.YELLOW, 3));
        bottomPanel3.add(newAnswerCodeLabel);
        bottomPanel3.add(newAnswerCodeBox);
        bottomPanel3.add(newAnswerBtn);
        bottomPanel3.add(newAnswerBox);
    }


    /*
     * MODIFIES: this
     * EFFECTS: create a structure for a panel which can delete question
     * */
    private void settingDeleteBtnPanel() {
        bottomPanel4.setLayout(new GridLayout(2, 2, 10, 10));
        bottomPanel4.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        bottomPanel4.setBorder(new LineBorder(Color.CYAN, 3));
        bottomPanel4.add(deleteQuestionCodeLabel);
        bottomPanel4.add(deleteQuestionCodeBox);
        bottomPanel4.add(deleteQuestionBtn);
    }

    /*
     * MODIFIES: this
     * EFFECTS: create structure for bottom panel of GUI window
     * add four created panels to bottom panel
     * */
    private void settingBottomFourPanels() {
        bottomPanel.setBackground(Color.GRAY);
        bottomPanel.setLayout(new GridLayout(1, 3, 20, 20));
        bottomPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        bottomPanel.add(bottomPanel1);
        bottomPanel.add(bottomPanel2);
        bottomPanel.add(bottomPanel3);
        bottomPanel.add(bottomPanel4);
    }

    /*
     * MODIFIES: this
     * EFFECTS: Create a structure for top left, top right and bottom panel
     * which can contain panels of each function
     * */
    private void settingBigJFrame() {
        panelMain.setLayout(new BorderLayout());
        panelMain.add(topLeftPanel, BorderLayout.LINE_START);
        panelMain.add(topRightPanel, BorderLayout.CENTER);
        panelMain.add(bottomPanel, BorderLayout.PAGE_END);
    }

    /*
     * MODIFIES: this
     * EFFECTS: structure the JFrame which is the whole window for the GUI program
     * */
    private void settingJFrame() {
        frameMain.setVisible(true);
        frameMain.setSize(1500, 1500);
        frameMain.setResizable(false);
        frameMain.setLocationRelativeTo(null);
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMain.add(panelMain);
    }


}
