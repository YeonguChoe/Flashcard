//package ui;
//
//import model.Question;
//import model.QuestionList;
//import persistence.ReadJsonFile;
//import persistence.WriteJsonFile;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.Scanner;
//
////Represents flash card application
//public class FlashCardCLI {
//    private QuestionList theQuestionList;
//    private Question firstQuestion;
//    private Scanner input;
//    private WriteJsonFile jsonWriter;
//    private ReadJsonFile jsonReader;
//    public static final String SAVEDQUESTIONLIST = "./data/questions.json";
//
//
//    /*
//     * EFFECTS: run flash card application
//     */
//    public FlashCardCLI() {
//        runFlashCard();
//    }
//
//    /*
//     * MODIFIES: this
//     * EFFECTS: Process input
//     */
//    private void runFlashCard() {
//        boolean keepGoing = true;
//        String command;
//        init();
//        while (keepGoing) {
//            displayOptions();
//            command = input.nextLine();
//            command = command.toLowerCase();
//
//            if (command.equals("q")) {
//                keepGoing = false;
//            } else {
//                processCommand(command);
//            }
//        }
//    }
//
//
//    /*
//     * EFFECTS: display options that user can choose
//     */
//    private void displayOptions() {
//        System.out.println("\nSelect from:");
//        System.out.println("\ts -> Solve Question");
//        System.out.println("\ta -> Add Question");
//        System.out.println("\tn -> Add another answer");
//        System.out.println("\td -> Delete Question");
//        System.out.println("\tp -> Print question list");
//        System.out.println("\tsave -> Save question list");
//        System.out.println("\tload -> Load question list");
//        System.out.println("\tq -> quit");
//    }
//
//    /*
//     * EFFECTS: call method based on user input
//     */
//    private void processCommand(String command) {
//        if (command.equals("s")) {
//            solveQuestion();
//        } else if (command.equals("p")) {
//            printQuestionList();
//        } else if (command.equals("a")) {
//            addQuestion();
//        } else if (command.equals("d")) {
//            deleteQuestion();
//        } else if (command.equals("n")) {
//            addAnotherAnswer();
//        } else if (command.equals("save")) {
//            saveQuestions();
//        } else if (command.equals("load")) {
//            loadQuestions();
//        } else {
//            System.out.println("wrong input");
//        }
//    }
//
//    /*
//     * EFFECTS: display questions and let user solve question
//     */
//    private void solveQuestion() {
//        if (theQuestionList.getQuestions().size() == 0) {
//            System.out.println("Quiz ended");
//        } else {
//            for (Integer code : theQuestionList.getQuestions().keySet()) {
//                Question selectedQuestion = theQuestionList.getQuestionObject(code);
//                System.out.println(selectedQuestion.getQuestion());
//                String answer = input.nextLine();
//                if (selectedQuestion.getAnswers().contains(answer)) {
//                    System.out.println("You are correct");
//                } else {
//                    System.out.println("You are wrong.");
//                }
//            }
//        }
//    }
//
//    /*
//     * REQUIRES: theQuestionList should not be empty
//     * EFFECTS: display details of questions of question list
//     */
//    private void printQuestionList() {
//        for (int code : theQuestionList.getQuestions().keySet()) {
//            Question q1 = theQuestionList.getQuestionObject(code);
//            String theQuestion = q1.getQuestion();
//            String theAnswer = q1.getAnswers().toString();
//            int theCode = q1.getUniqueCode();
//            System.out.print("The question is..." + theQuestion + "/\t\t the answer is..." + theAnswer + "\t");
//            System.out.println("/The code is..." + theCode);
//        }
//    }
//
//    /*
//     * MODIFIES: this
//     * EFFECTS: add a new question to the question list
//     * */
//    private void addQuestion() {
//        String a1;
//        System.out.println("Type Question here");
//        String q1 = input.nextLine();
//        Question newQuestion = new Question(q1);
//        System.out.println("Type answer");
//        a1 = input.nextLine();
//        newQuestion.addAnswer(a1);
//        theQuestionList.addQuestion(newQuestion);
//    }
//
//    /*
//     * REQUIRES: Question list should not be empty
//     * MODIFIES: this
//     * EFFECTS: Delete question from question list
//     * */
//    private void deleteQuestion() {
//        printQuestionList();
//        System.out.println("type question code you want to delete");
//        String code = input.nextLine();
//        int theCode = Integer.parseInt(code);
//        theQuestionList.deleteQuestion(theCode);
//    }
//
//    /*
//     * MODIFIES: this
//     * EFFECTS: add an answer to the answers arraylist
//     * */
//    private void addAnotherAnswer() {
//        printQuestionList();
//        System.out.println("select the code and type it!");
//        String selectedCode = input.nextLine();
//        Question theQuestion = theQuestionList.getQuestionObject(Integer.parseInt(selectedCode));
//        System.out.println("Type new answer");
//        String anotherAnswer = input.nextLine();
//        theQuestion.addAnswer(anotherAnswer);
//    }
//
//    /*
//     * EFFECTS: save the question list to the JSON file
//     * */
//    private void saveQuestions() {
//        try {
//            jsonWriter.open(SAVEDQUESTIONLIST);
//            jsonWriter.write(theQuestionList);
//            jsonWriter.close();
//            System.out.println("saving complete");
//        } catch (FileNotFoundException e) {
//            System.out.println("failed to save");
//        }
//    }
//
//    /*
//     * MODIFIES: this
//     * EFFECTS: bring the saved data from the json file
//     * */
//    private void loadQuestions() {
//        try {
//            theQuestionList = jsonReader.read();
//            System.out.println("Successfully Loaded");
//        } catch (IOException e) {
//            System.out.println("Failed to load data");
//        }
//    }
//
//    /*
//     * MODIFIES: this
//     * EFFECTS: initialize fields
//     * */
//    private void init() {
//        theQuestionList = new QuestionList();
//        jsonWriter = new WriteJsonFile(SAVEDQUESTIONLIST);
//        jsonReader = new ReadJsonFile(SAVEDQUESTIONLIST);
//        firstQuestion = new Question("What is 1+1?");
//        firstQuestion.addAnswer("2");
//        theQuestionList.addQuestion(firstQuestion);
//        input = new Scanner(System.in);
//    }
//
//}
