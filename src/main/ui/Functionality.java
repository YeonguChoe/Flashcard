package ui;

import model.Question;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.swing.*;
import java.io.*;

//Create method for functionality of GUI window
public class Functionality extends Initialization {

    /*
     * MODIFIES: SAVEDQUESTIONLIST
     * EFFECTS: save the data to json file
     * */
    protected void saveButtonFunctionality() {
        saveBtn.addActionListener(a -> {
            try {
                jsonWriter.open(SAVEDQUESTIONLIST);
                jsonWriter.write(theQuestionList);
                jsonWriter.close();
                System.out.println("saving complete");
            } catch (FileNotFoundException b) {
                System.out.println("failed to save");
            }
        });
    }

    /*
     * MODIFIES: this
     * EFFECTS: reset the data in the existing table
     * and insert the data acquired from json file
     * */
    protected void loadButtonFunctionality() {
        loadBtn.addActionListener(a -> {
            try {
                makeQuestionList();
                int numberOfLines = theTable.getRowCount();
                for (int i = 0; i < numberOfLines; i++) {
                    theTable.removeRow(0);
                }
                for (int eachCode : theQuestionList.getQuestions().keySet()) {
                    String correspondingQuestion = theQuestionList.getQuestionObject(eachCode).getQuestion();
                    Object[] row = new Object[2];
                    row[0] = eachCode;
                    row[1] = correspondingQuestion;
                    theTable.addRow(row);
                }
                System.out.println("Successfully Loaded");
            } catch (Exception b) {
                System.out.println("Failed to load data");
            }
        });
    }

    /*
     * EFFECTS: pop up message box which tells user if
     * the question is correct or incorrect
     * */
    protected void answerButtonFunctionality() {
        answerBtn.addActionListener(e -> {
            try {
                int theCode = Integer.parseInt(answerCodeBox.getText());
                String theAnswer = answerBox.getText();
                if (theQuestionList.getQuestions().containsKey(theCode)) {
                    if (theQuestionList.getQuestions().get(theCode).getAnswers().contains(theAnswer)) {
                        correctIncorrectSoundEffect(true);
                        JOptionPane.showMessageDialog(null, "Correct!!");
                    } else {
                        correctIncorrectSoundEffect(false);
                        JOptionPane.showMessageDialog(null, "Incorrect!!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "the input code is not in the"
                            + " saved question list");
                }
            } catch (NumberFormatException a) {
                JOptionPane.showMessageDialog(null, "Please input number only!!");
            }
        });
    }

    /*
     * MODIFIES: this
     * EFFECTS: add question to question list and show it to GUI
     * */
    protected void newQuestionButtonFunctionality() {
        newQuestionBtn.addActionListener(e -> {
            try {
                Object[] set = new Object[2];
                if (!newQuestionBox.getText().isEmpty()) {
                    Question theQuestion = new Question(newQuestionBox.getText());
                    theQuestionList.addQuestion(theQuestion);
                    set[0] = theQuestion.getUniqueCode();
                    set[1] = newQuestionBox.getText();
                    theTable.addRow(set);
                }
            } catch (Exception a) {
                JOptionPane.showMessageDialog(null, "Something's wrong with your input.");
            }
        });
    }

    /*
     * MODIFIES: this
     * EFFECTS: add another answer to a question
     * */
    protected void newAnswerButtonFunctionality() {
        newAnswerBtn.addActionListener(a -> {
            int theCode;
            try {
                theCode = Integer.parseInt(newAnswerCodeBox.getText());
                String newAnswerString;
                newAnswerString = newAnswerBox.getText();
                theQuestionList.getQuestions().get(theCode).addAnswer(newAnswerString);
            } catch (NumberFormatException b) {
                JOptionPane.showMessageDialog(null, "Please type code in number");
            } catch (Exception c) {
                theCode = Integer.parseInt(newAnswerCodeBox.getText());
                if (!theQuestionList.getQuestions().containsKey(theCode)) {
                    JOptionPane.showMessageDialog(null, "You may save "
                            + "the question first, because the question corresponding"
                            + " to the code wasn't in the loaded data!");
                } else {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }
        });
    }

    /*
     * MODIFIES: theQuestionList
     * EFFECTS: delete the question using code
     * */
    protected void deleteButtonFunctionality() {
        deleteQuestionBtn.addActionListener(e -> {
            try {
                int theCode = Integer.parseInt(deleteQuestionCodeBox.getText());
                for (int i = 0; i <= theTable.getRowCount(); i++) {
                    if (theTable.getValueAt(i, 0).equals(theCode)) {
                        theTable.removeRow(i);
                        theQuestionList.deleteQuestion(theCode);
                        break;
                    }
                }
            } catch (Exception a) {
                JOptionPane.showMessageDialog(null, "Invalid Code!!");
            }
        });
    }

    /*
     * MODIFIES: this
     * EFFECTS: read the data from json file and assign it to
     * question list
     * */
    protected void makeQuestionList() {
        try {
            theQuestionList = jsonReader.read();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not find the file!");
        }
    }

    /*
     * EFFECTS: create sound effect when user inputs correct or incorrect answers
     * */
    protected void correctIncorrectSoundEffect(boolean correct) {
        File soundEffectFile;
        if (correct) {
            soundEffectFile = new File("./data/correctSoundEffect.wav");
        } else {
            soundEffectFile = new File("./data/incorrectSoundEffect.wav");
        }
        InputStream theSound;
        try {
            theSound = new FileInputStream(soundEffectFile);
            AudioStream soundEffect = new AudioStream(theSound);
            AudioPlayer.player.start(soundEffect);
        } catch (Exception e) {
            System.out.println("Error occurred");
        }
    }

}
