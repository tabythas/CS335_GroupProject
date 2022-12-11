package code;

import java.awt.*;
import java.io.File;
import javax.swing.*;
import java.awt.event.*;
import com.formdev.flatlaf.FlatDarculaLaf;

public class gui {

    private JFrame mainFrame;
    private JPanel mainPanel;
    private JButton mainButton;
    private JLabel mainLabel;
    private JLabel extendedLabel;
    private JButton century17th;
    private JButton century18th;
    private JButton century19th;
    private JButton century20th;
    private JButton next;
    // set variables for standard button width and height
    private int width = 300;
    private int height = 30;

    String currentCentury = "";

    // counter for panel
    int COUNTER = 1;
    // counter for incorrect answers
    int INCORRECT_ANSWER = 0;
    // array to hold specific information for each panel
    data newClassobj = new data();
    String[] centurySelected = newClassobj.getCentury();
    // 17th century data
    String[] header_17th = newClassobj.getHeaderArray17();
    String[] imageFile_17th = newClassobj.getImageArray17();
    String[] correctAnswer_17th = newClassobj.getCorrectAnswerArray17();
    String[][] questionArray_17th = newClassobj.getQuestionArray17();
    // 18th century data
    String[] header_18th = newClassobj.getHeaderArray18();
    String[] imageFile_18th = newClassobj.getImageArray18();
    String[] correctAnswer_18th = newClassobj.getCorrectAnswerArray18();
    String[][] questionArray_18th = newClassobj.getQuestionArray18();
    // 19th century data
    String[] header_19th = newClassobj.getHeaderArray19();
    String[] imageFile_19th = newClassobj.getImageArray19();
    String[] correctAnswer_19th = newClassobj.getCorrectAnswerArray19();
    String[][] questionArray_19th = newClassobj.getQuestionArray19();
    // 20th century data
    String[] header_20th = newClassobj.getHeaderArray20();
    String[] imageFile_20th = newClassobj.getImageArray20();
    String[] correctAnswer_20th = newClassobj.getCorrectAnswerArray20();
    String[][] questionArray_20th = newClassobj.getQuestionArray20();

    // Used to access the century buttons 
    JButton[] centuryChoices = new JButton[4];
    
    public gui(){
        // create main frame
        mainFrame = new JFrame();

        // button for starting the quiz
        mainButton = new JButton("Start Quiz");
        mainButton.setPreferredSize(new Dimension(350, 50));
        mainButton.setEnabled(false);
        mainButton.putClientProperty("FlatLaf.style", "font: bold $h2.font");

        // label to show the user what they are using
        mainLabel = new JLabel("Test Your Art Knowledge (or lack thereof)!", SwingConstants.CENTER);
        extendedLabel = new JLabel("Select the century you want to be quizzed on:");

        mainLabel.putClientProperty("FlatLab.styleClass", "h1");
        mainLabel.putClientProperty("FlatLaf.style", "font: bold $h1.font");
        extendedLabel.putClientProperty("FlatLab.styleClass", "h2");
        extendedLabel.putClientProperty("FlatLaf.style", "font: bold $h2.font");

        century17th = new JButton("17th Century");
        century18th = new JButton("18th Century");
        century19th = new JButton("19th Century");
        century20th = new JButton("20th Century");

        // TODO: JToggleButton and Button groups are a better future option
        setupCenturyButtons();

        // each "page" will be a panel
        mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(200, 200, 200, 200));

        // need to add components into the panel 
        mainPanel.add(mainLabel);
        mainPanel.add(extendedLabel);
        mainPanel.add(century17th);
        mainPanel.add(century18th);
        mainPanel.add(century19th);
        mainPanel.add(century20th);
        mainPanel.add(mainButton);

        // add main panel to main frame
        mainFrame.add(mainPanel, BorderLayout.CENTER);
        // application will close if exit is clicked
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setting frame title
        mainFrame.setTitle("Art Quiz");
        mainFrame.setSize(850, 750);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
      
        // method to connect the first button to an action when clicked
        mainButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                // when mainButton is clicked, the mainPanel will be invisible
                mainPanel.setVisible(false);
                switch(currentCentury){
                    case "17th Century":
                    // call method to build question panel
                    buildQuestionPanel(header_17th[0], imageFile_17th[0], questionArray_17th[0], correctAnswer_17th[0], INCORRECT_ANSWER);
                    break;

                    case "18th Century":
                    buildQuestionPanel(header_18th[0], imageFile_18th[0], questionArray_18th[0], correctAnswer_18th[0], INCORRECT_ANSWER);
                    break;

                    case "19th Century":
                    buildQuestionPanel(header_19th[0], imageFile_19th[0], questionArray_19th[0], correctAnswer_19th[0], INCORRECT_ANSWER);
                    break;

                    case "20th Century":
                    buildQuestionPanel(header_20th[0], imageFile_20th[0], questionArray_20th[0], correctAnswer_20th[0], INCORRECT_ANSWER);
                    break;
                }
            }
        });

    }
    // end of gui class that sets up the applications

    public void setCenturyButtons(JButton mainButton, JButton selection) {
        for (int i = 0; i < centuryChoices.length; i++) {
            setCenturyButtonStyle(centuryChoices[i]);
        }
        selection.setBorder(BorderFactory.createLineBorder(Color.green));
        mainButton.setEnabled(true);
        mainButton.setBorder(BorderFactory.createLineBorder(Color.green));
    };
    
    // this method builds question panel
    public void buildQuestionPanel(String headerText, String fileName, String[] questionArray, String correct, int INCORRECT_ANSWER){
        // using a JTextArea allows for overflow text to span 2 lines (instead of 1)
        JTextArea questionPrompt = new JTextArea(2,30);
        questionPrompt.setWrapStyleWord(true);
        questionPrompt.setLineWrap(true);
        questionPrompt.setFocusable(false);
        questionPrompt.setText(headerText);
        questionPrompt.putClientProperty("FlatLab.styleClass", "h2");
        questionPrompt.putClientProperty( "FlatLaf.style", "font: bold $h2.font" );

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(75, 75, 75, 75));
        panel.add(questionPrompt, SwingConstants.CENTER);
        
        JLabel imageLabel = new JLabel();
        File file = new File(fileName);
        String absPath = file.getAbsolutePath();
        ImageIcon image = new ImageIcon(absPath);
        imageLabel.setIcon(image);
        panel.add(imageLabel, SwingConstants.CENTER);

        JButton[] wrongChoices = new JButton[4];
        // loop through array of options
        for (int i = 0; i < questionArray.length; i++){
            // if option is the correct answer, build summary panel
            if (questionArray[i].equals(correct)){
                JButton correctAnswer = new JButton(correct);
                correctAnswer.setPreferredSize(new Dimension(width, height));
                panel.add(correctAnswer);
                correctAnswer.putClientProperty( "FlatLaf.style", "font: bold $h3.font" );
                
                correctAnswer.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent correctAnswerButton) {
                        //panel.setVisible(false);
                        //buildSummaryPanel(imageLabel);
                        correctAnswer.setBorder(BorderFactory.createLineBorder(Color.green));
                        removeButtonFocus(correctAnswer);

                        // hooray, you pass!
                        next.setEnabled(true);
                        next.setBorder(BorderFactory.createLineBorder(Color.green));

                        // if the correct answer is pressed, disable all the wrong answers 
                        for (int i=0; i<4; i++){
                            // wrongChoices will always have 1 spot in the array that is null (due to correct answer also being in the questionArray)
                            try {
                                disableWrongChoice(wrongChoices[i]);
                            } catch (Exception e) {
                                System.out.println("(" + i + ")" + "Exception: " + e);
                            }
                        }
                        next.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent nextButton) {
                                panel.setVisible(false);
                                // reached 5 questions
                                if (COUNTER == 5){
                                    buildResultsPage();
                                }
                                else{
                                    switch(currentCentury){
                                        case "17th Century":
                                        // call method to build question panel
                                        buildQuestionPanel(header_17th[COUNTER], imageFile_17th[COUNTER], questionArray_17th[COUNTER], correctAnswer_17th[COUNTER], INCORRECT_ANSWER);
                                        break;
                    
                                        case "18th Century":
                                        buildQuestionPanel(header_18th[COUNTER], imageFile_18th[COUNTER], questionArray_18th[COUNTER], correctAnswer_18th[COUNTER], INCORRECT_ANSWER);
                                        break;
                    
                                        case "19th Century":
                                        buildQuestionPanel(header_19th[COUNTER], imageFile_19th[COUNTER], questionArray_19th[COUNTER], correctAnswer_19th[COUNTER], INCORRECT_ANSWER);
                                        break;
                    
                                        case "20th Century":
                                        buildQuestionPanel(header_20th[COUNTER], imageFile_20th[COUNTER], questionArray_20th[COUNTER], correctAnswer_20th[COUNTER], INCORRECT_ANSWER);
                                        break;
                                    }
                                    COUNTER += 1;
                                }
                            }
                        });
                    }
                });
            }
            // for each incorrect option, call wrongButton method
            else {
                JButton option = new JButton(questionArray[i]);
                // wrongChoices lets us reference the buttons after theyre made
                wrongChoices[i] = option;
                option.setPreferredSize(new Dimension(width, height));
                panel.add(option);
                option.putClientProperty("FlatLaf.style", "font: bold $h3.font");
                wrongButton(option);
                removeButtonFocus(option);
            }
        }

        // Create Next button to go to next question
        next = new JButton("Next");
        next.setPreferredSize(new Dimension(350, 40));
        next.putClientProperty( "FlatLaf.style", "font: bold $h2.font" );
        next.setEnabled(false);
        panel.add(next, BorderLayout.SOUTH);
        next.setEnabled(false);
        mainFrame.add(panel, BorderLayout.CENTER);
    }

    //  results page 
    void buildResultsPage(){
        JPanel panel = new JPanel();
        String reviewAnswerText = "You selected ";
        if (INCORRECT_ANSWER == 0){
            reviewAnswerText += INCORRECT_ANSWER + " incorrect answers! Congratulations!";
        } else if (INCORRECT_ANSWER == 1){
            reviewAnswerText += INCORRECT_ANSWER + " incorrect answer!";
        } else {
            reviewAnswerText += INCORRECT_ANSWER + " incorrect answers!";
        }
        JLabel label1 = new JLabel(reviewAnswerText, SwingConstants.CENTER);
        JLabel label2 = new JLabel("Quiz yourself on another century or be lame and exit:", SwingConstants.CENTER);
        JButton exitButton = new JButton("Exit");
        JButton tryAgainButton = new JButton("Try Again");
        label1.putClientProperty("FlatLab.styleClass", "h1");
        label1.putClientProperty( "FlatLaf.style", "font: bold $h1.font" );
        label2.putClientProperty("FlatLab.styleClass", "h2");
        label2.putClientProperty( "FlatLaf.style", "font: bold $h2.font" );
        panel.setBorder(BorderFactory.createEmptyBorder(200, 200, 200, 200));
        panel.add(label1);
        panel.add(label2);
        panel.add(exitButton);
        panel.add(tryAgainButton);
        exitButton.setBorder(BorderFactory.createLineBorder(Color.gray));
        exitButton.putClientProperty("FlatLab.styleClass", "h2");
        exitButton.putClientProperty( "FlatLaf.style", "font: bold $h2.font" );
        exitButton.setPreferredSize(new Dimension (350, 50));
        tryAgainButton.setBorder(BorderFactory.createLineBorder(Color.gray));
        tryAgainButton.putClientProperty("FlatLab.styleClass", "h2");
        tryAgainButton.putClientProperty( "FlatLaf.style", "font: bold $h2.font" );
        tryAgainButton.setPreferredSize(new Dimension (350, 50));
        mainFrame.add(panel, BorderLayout.CENTER);
        // builds new gui 
        tryAgainButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent tryAgainButton) {
                mainFrame.setVisible(false);
                new gui();
            }
        });
        // exit the game
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent exitButton) {
                System.exit(0);
            }
        });
    }

    // Helper functions

    // Sets up listener on wrong options
    private void wrongButton(JButton wrong){
        wrong.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent wrongAnswer) {
                disableWrongChoice(wrong);
                INCORRECT_ANSWER += 1;
            }
        });
    }

    // What should happen when the wrong choice is clicked (red border, disabled)
    private void disableWrongChoice(JButton wrong){
        wrong.setBorder(BorderFactory.createLineBorder(Color.red));
        wrong.putClientProperty( "FlatLaf.style", "font: bold $h3.font" );
        wrong.setEnabled(false);
    }

    // Removes the default automatic blue highlight cycle of button
    private void removeButtonFocus(JButton button){
        button.setRolloverEnabled(false);
        button.setFocusPainted(false);
        button.setFocusable(false);
    }

    // Setup of the the century buttons through centuryChoices array
    private void setupCenturyButtons(){
        // Map 0 -> 17th, 1 -> 18th, etc.
        centuryChoices[0] = century17th;
        centuryChoices[1] = century18th;
        centuryChoices[2] = century19th;
        centuryChoices[3] = century20th;
        // Add event listeners to each 
        for (int i = 0; i < centuryChoices.length; i++){
            setCenturyButtonListener(centuryChoices[i], i);
            setCenturyButtonStyle(centuryChoices[i]);
        }
    }

    // Sets up the century choice button style
    private void setCenturyButtonStyle(JButton button){
        // note: width and height are set as globals as part of gui class
        button.setPreferredSize(new Dimension(width, height));
        button.putClientProperty("FlatLaf.style", "font: bold $h3.font");
        button.setBackground(Color.darkGray);
        button.setBorder(BorderFactory.createLineBorder(Color.gray));
    }

    // Event listener for choosing the current century
    private void setCenturyButtonListener(JButton century_button, int century_index){
        century_button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                currentCentury = centurySelected[century_index];
                setCenturyButtons(mainButton, centuryChoices[century_index]);
            }
        });
    }

    // main method to call and build application
    public static void main(String[] args){
        // FlatLaf needs to happen before we start working on the GUI
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (UnsupportedLookAndFeelException e) {
            System.out.println(e);
        }
        new gui();
    }
}